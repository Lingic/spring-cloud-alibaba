//package cn.test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.junit.jupiter.api.Test;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//class TestExcel {
//
////	@Test
//	void test() {
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\testExcel.xls";
//			HSSFWorkbook workbook = new HSSFWorkbook();
//			HSSFSheet sheet = workbook.createSheet();
//			sheet = workbook.createSheet("TEST");
//			FileOutputStream out = new FileOutputStream(filePath);
//			workbook.write(out);
//			out.close();
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//	}
//
////	@Test
//	void testSheet() {
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\testExcel.xls";
//			HSSFWorkbook workbook = new HSSFWorkbook();
//			HSSFSheet sheet = workbook.createSheet("TEST");		// 创建工作表(Sheet)
//			HSSFRow row = sheet.createRow(0);					// 创建行,从0开始
//			HSSFCell cell = row.createCell(0);					// 创建行的单元格,也是从0开始
//			cell.setCellValue("李志伟");							// 设置单元格内容
//			row.createCell(1).setCellValue(false);				// 设置单元格内容,重载
//			row.createCell(2).setCellValue(new Date());			// 设置单元格内容,重载
//			row.createCell(3).setCellValue(12.345);				// 设置单元格内容,重载
//			
//			FileOutputStream out = new FileOutputStream(filePath);
//			workbook.write(out);
//			out.close();
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//	}
//	
//	
//	@Test
//	void testReadSheet() {
//		log.info("begin");
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\testExcel.xls";
//			FileInputStream fis = new FileInputStream(filePath);
//			POIFSFileSystem fs = new POIFSFileSystem(fis);
//			HSSFWorkbook workbook = new HSSFWorkbook(fs);
//			HSSFSheet sheet = workbook.getSheetAt(0);
//			
//			log.info(sheet.getSheetName());
//			
//			log.info(""+sheet.getLastRowNum());
//			
//			log.info(""+sheet.getRow(0).getCell(0).toString());
//			log.info(""+sheet.getRow(0).getCell(1).toString());
//			
//			for (int i = 0; i < sheet.getLastRowNum() + 1; i ++) {
//				HSSFRow row = sheet.getRow(i);
//				
//				log.info(row.getCell(i).toString());
//				
//				for (int j = 0; j < row.getLastCellNum(); j ++) {
//					HSSFCell cell = row.getCell(j);
//					System.out.println(cell.toString());
//				}
//			}
//			
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//		log.info("end");
//	}
//}
