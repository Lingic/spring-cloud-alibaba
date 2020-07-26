package com.rfics.bus.evaluation.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfics.bus.evaluation.service.EvaluationService;
import com.rfics.unit.Config;
import com.rfics.unit.ContantMode;
import com.rfics.unit.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private Config config;

	// 附件1：地方自评报告
	@Override
	public ResponseMessage readLocalEvaluationReport(int privilege, String zone, int type, String fileName) {
		log.info("readExcel1 privilege=" + privilege + ", zone=" + zone + ", type=" + type + ", fileName=" + fileName);
		ResponseMessage res = new ResponseMessage();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			Map<String, Object> rb = new HashMap<>();
			for (int i = 1; i < 6; i ++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rows = sheet.getLastRowNum() + 1;
				Map<Object, Object> sheetMap = readSheetData(sheet, 5, rows, 0, 7);
				rb.put("sheet"+i, sheetMap);
			}
			
			res.setRb(rb);;
			
		} catch (IOException e) {
			log.error("error", e);
			res.setRc("900901");
			res.setRt("读取EXCEL异常");
			return res;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}
	
	
	// 附件2：专项评估报告
	@Override
	public ResponseMessage readSpecialEvaluationReport(int privilege, String zone, int type, String fileName) {
		log.info("readExcel2 privilege=" + privilege + ", zone=" + zone + ", type=" + type + ", fileName=" + fileName);
		ResponseMessage res = new ResponseMessage();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			Map<String, Object> rb = new HashMap<>();
			
			for (int i = 1; i < 6; i ++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rows = sheet.getLastRowNum();
				Map<Object, Object> sheetMap = readSheetData(sheet, 5, rows, 0, 7);
				rb.put("sheet"+i, sheetMap);
			}
			
			res.setRb(rb);;
			
		} catch (IOException e) {
			log.error("error", e);
			res.setRc("900901");
			res.setRt("读取EXCEL异常");
			return res;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}

	// 附件3：常规评估报告
	@Override
	public ResponseMessage readNormalEvaluationReport(int privilege, String zone, int type, String fileName) {
		log.info("readExcel3 privilege=" + privilege + ", zone=" + zone + ", type=" + type + ", fileName=" + fileName);
		ResponseMessage res = new ResponseMessage();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			Map<String, Object> rb = new HashMap<>();
			
			XSSFSheet sheet1 = workbook.getSheetAt(0);
			int rows1 = sheet1.getLastRowNum() + 1;
			Map<Object, Object> sheet1Map = readSheetData(sheet1, 5, rows1, 0, 7);
			rb.put("sheet1", sheet1Map);
			
			XSSFSheet sheet2 = workbook.getSheetAt(1);
			Map<Object, Object> sheet2Map1 = readSheetData(sheet2, 4, 9, 0, 5);
			rb.put("sheet2.1", sheet2Map1);
			
			Map<Object, Object> sheet2Map2 = readSheetData(sheet2, 16, 19, 0, 7);
			rb.put("sheet2.2", sheet2Map2);
			
			Map<Object, Object> sheet2Map3 = readSheetData(sheet2, 23, 28, 0, 4);
			rb.put("sheet2.3", sheet2Map3);
			
			Map<Object, Object> sheet2Map4 = readSheetData(sheet2, 32, 35, 0, 2);
			rb.put("sheet2.4", sheet2Map4);
			
			res.setRb(rb);;
			
		} catch (IOException e) {
			log.error("error", e);
			res.setRc("900901");
			res.setRt("读取EXCEL异常");
			return res;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}

	// 附件4：整改报告
	@Override
	public ResponseMessage readReformEvaluationReport(int privilege, String zone, int type, String fileName) {
		log.info("readExcel4 privilege=" + privilege + ", zone=" + zone + ", type=" + type + ", fileName=" + fileName);
		ResponseMessage res = new ResponseMessage();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			Map<String, Object> rb = new HashMap<>();
			
			for (int i = 1; i < 6; i ++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rows = sheet.getLastRowNum();
				Map<Object, Object> sheetMap = readSheetData(sheet, 3, rows, 0, 13);
				rb.put("sheet"+i, sheetMap);
			}
			
			res.setRb(rb);;
			
		} catch (IOException e) {
			log.error("error", e);
			res.setRc("900901");
			res.setRt("读取EXCEL异常");
			return res;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}

	// 附件5：自动评估明细问题
	@Override
	public ResponseMessage readDetailEvaluationReport(int privilege, String zone, int type, String fileName) {
		log.info("readExcel5 privilege=" + privilege + ", zone=" + zone + ", type=" + type + ", fileName=" + fileName);
		ResponseMessage res = new ResponseMessage();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			Map<String, Object> rb = new HashMap<>();
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			Map<Object, Object> sheetMap = readSheetData(sheet, 5, 8, 0, 6);
			rb.put("sheet0", sheetMap);
			
			Map<Object, Object> sheetMap2 = readSheetData(sheet, 13, 16, 0, 6);
			rb.put("sheet02", sheetMap2);
			
			Map<Object, Object> sheetMap3 = readSheetData(sheet, 21, 26, 0, 6);
			rb.put("sheet02", sheetMap3);
			
			XSSFSheet sheet1 = workbook.getSheetAt(1);
			Map<Object, Object> sheet1Map = readSheetData(sheet1, 4, 10, 2, 5);
			rb.put("sheet1", sheet1Map);
			
			res.setRb(rb);;
			
		} catch (IOException e) {
			log.error("error", e);
			res.setRc("900901");
			res.setRt("读取EXCEL异常");
			return res;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		
		return res;
	}
	
	
	private Map<Object, Object> readSheetData(XSSFSheet sheet, int iRow, int iLastRow, int iCol, int iLastCol) {
		Map<Object, Object> map = new HashMap<>();
		map.put("SheetName", sheet.getSheetName());
		map.put("RowCount", sheet.getLastRowNum() - iRow);
		
		List<Map<Object, Object>> rows = new ArrayList<>();
		for (int i = iRow; i < iLastRow; i ++) {
			XSSFRow row = sheet.getRow(i);
			
			if (null != row) {
				Map<Object, Object> cellMap = new HashMap<>();
				for (int j = iCol; j < iLastCol; j ++) {
					XSSFCell cell = row.getCell(j);
					
					if (null != cell) {
						cellMap.put(j - iCol, cell.toString());
					}
				}
				rows.add(cellMap);
			}
		}
		map.put("rows", rows);
		return map;
	}


	@Override
	public ResponseMessage readSpecialAndLocalEvaluationReport(int privilege, String zone, int type, String fileName) {
		log.info("readExcel6 privilege=" + privilege + ", zone=" + zone + ", type=" + type + ", fileName=" + fileName);
		ResponseMessage res = new ResponseMessage();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		try {
			String path = new String(config.getUploadPath().getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path + File.separator + privilege + File.separator + zone + File.separator + type + File.separator + fileName;
			
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			Map<String, Object> rb = new HashMap<>();
			XSSFSheet sheet1 = workbook.getSheetAt(1);
			int rows1 = sheet1.getLastRowNum() + 1;
			Map<Object, Object> sheet1Map = readSheetData(sheet1, 7, rows1, 0, 9);
			rb.put("sheet"+1, sheet1Map);
			
			for (int i = 2; i < 4; i ++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rows = sheet.getLastRowNum() + 1;
				Map<Object, Object> sheetMap = readSheetData(sheet, 6, rows, 0, 9);
				rb.put("sheet"+i, sheetMap);
			}
			
			for (int i = 4; i < 6; i ++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rows = sheet.getLastRowNum() + 1;
				Map<Object, Object> sheetMap = readSheetData(sheet, 7, rows, 0, 9);
				rb.put("sheet"+i, sheetMap);
			}
			
			res.setRb(rb);;
			
		} catch (IOException e) {
			log.error("error", e);
			res.setRc("900901");
			res.setRt("读取EXCEL异常");
			return res;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					log.error("Error", e);
				}
			}
		}
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}

}
