package com.rfics.bus.file.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rfics.unit.Config;
import com.rfics.unit.ContantMode;
import com.rfics.unit.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/file")
public class FileController {

	@Autowired
	private Config config;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
	
	@RequestMapping(value = "/fileDownload")
	@ResponseBody
	public ResponseMessage download(HttpServletResponse response,
			@RequestBody Map<String,Object> map) {
		log.info("fileDownload");
		ResponseMessage res = new ResponseMessage();
		
		BufferedInputStream bis = null;
		OutputStream os = null;
		
		try {
			String zone = map.get("zone").toString();
			String fileName = map.get("fileName").toString();
			int type = (int) map.get("type");
			int privilege = (int) map.get("privilege");
			
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			File file = new File(filePath);
			byte[] buff = new byte[1024];
			
			response.setHeader("content-type", "application/octet-stream;charset=UTF-8");
			response.setContentType("application/octet-stream;charset=UTF-8");
			//加上设置大小下载下来的.xlsx文件打开时才不会报“Excel 已完成文件级验证和修复。此工作簿的某些部分可能已被修复或丢弃”
			response.addHeader("Content-Length", String.valueOf(file.length()));
			try {
				response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName.trim(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				log.error("Error ", e);
			}
			
			os = response.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
			
			Map<String, Object> rb = new HashMap<>();
			rb.put("download", "文件下载成功");
			res.setRb(rb);
		} catch (IOException e) {
			log.error("Error ", e);
			res.setRc("900001");
    		res.setRt("文件下载失败");
    		return res;
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}
	
	
    @ResponseBody
    @PostMapping(value = "/fileUpload")
	public ResponseMessage fileUpload(@RequestParam("file") MultipartFile file, 
    		@RequestParam("zone") String zone, 
    		@RequestParam("type") int type,
    		@RequestParam("privilege") int privilege) {
    	log.info("fileUpload");
		ResponseMessage res = new ResponseMessage();
		
        if (file.isEmpty()) {
        	res.setRc("900001");
    		res.setRt("请上传一个文件");
    		return res;
        }
        
        String filename = file.getOriginalFilename();
        long fileSize = file.getSize();
        log.info("文件名称" + filename + "-------文件大小" + fileSize + ", zone="+zone+", type="+type + ", privilege="+privilege);
        
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			createFolder(path);
			
			path = path + File.separator + privilege;
			createFolder(path);
			
			path = path + File.separator + zone;
			createFolder(path);
			
			path = path + File.separator + type;
			createFolder(path);
			
			String mid = sdf.format(new Date());
			String saveFileName = privilege + "_" + zone + "_" + type + "_" + mid + "_" + filename;
			
			File dest = new File(path + File.separator + saveFileName);
			//保存文件
			file.transferTo(dest);
			
			res.setRc(ContantMode.SUCCESS);
			res.setRt(ContantMode.SUCCESS_TEXT);
			return res;
		} catch (IOException e) {
			log.error("Error ", e);
			res.setRc("900001");
    		res.setRt("文件上传失败");
    		return res;
		}
    }
    
    
    @PostMapping(value="getFileList", produces="application/json;charset=UTF-8")
	public ResponseMessage getFileList(@RequestBody Map<String,Object> map) {
		log.info("getFileList");
		ResponseMessage res = new ResponseMessage();
		
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			
			String zone = map.get("zone").toString();
			int type = (int) map.get("type");
			int privilege = (int) map.get("privilege");
			
			File file = new File(path + File.separator + privilege + File.separator + zone + File.separator + type);
			if (null != file) {
				File[] files = file.listFiles();
				if (null != files && files.length > 0) {
					List<String> list = new ArrayList<>();
					for (File f:files) {
						if (f.isFile()) {
							log.info(f.getName());
							list.add(f.getName());
						}
					}
					
					Map<String, Object> rb = new HashMap<>();
					rb.put("files", list);
					res.setRb(rb);
				}
			}
		} catch (IOException e) {
			log.error("Error ", e);
			res.setRc("900001");
			res.setRt("文件列表获取异常");
			return res;
		}
		
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
    }
    
    
    @PostMapping(value="deleteFile", produces="application/json;charset=UTF-8")
    public ResponseMessage deleteFile(@RequestParam("zone") String zone, 
    		@RequestParam("type") int type,
    		@RequestParam("privilege") int privilege,
    		@RequestParam("fileName") String fileName) {
    	log.info("deleteFile");
    	ResponseMessage res = new ResponseMessage();
    	
    	try {
    		String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
    		String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
    		File file = new File(filePath);
    		
    		Map<String, Object> rb = new HashMap<>();
    		if (file.exists()) {
    			boolean bln = file.delete();
    			
    			if (bln) {
    				rb.put("isDelete", bln);
    				res.setRc(ContantMode.SUCCESS);
    				res.setRt(ContantMode.SUCCESS_TEXT);
    			} else {
    				rb.put("isDelete", bln);
    				res.setRc("900001");
    				res.setRt("文件删除异常");
    			}
    		}
    		res.setRb(rb);
    		
    	} catch (IOException e) {
    		log.error("Error ", e);
    		res.setRc("900001");
			res.setRt("文件删除异常");
    	}
    	
    	return res;
    }
    
    
    private boolean createFolder(String folder) {
    	boolean bln = false;
    	File file = new File(folder);
		if (!file.exists()) {
			bln = file.mkdirs();
			if (!bln) {
				log.info("文件目录创建失败！file=" + file);
			}
		}
		return bln;
    }
}
