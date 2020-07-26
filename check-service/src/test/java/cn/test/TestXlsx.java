//package cn.test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.jupiter.api.Test;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//class TestXlsx {
//
////	@Test
//	void test() {
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\testExcel.xlsx";
//			FileOutputStream out = new FileOutputStream(filePath);
//			
//			XSSFWorkbook workbook = new XSSFWorkbook();
//			XSSFSheet sheet = workbook.createSheet("TEST");
//			workbook.write(out);
//			out.close();
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//	}
//
////	@Test
//	void testSheet() {
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\testExcel.xlsx";
//			FileOutputStream out = new FileOutputStream(filePath);
//			
//			XSSFWorkbook workbook = new XSSFWorkbook();
//			XSSFSheet sheet = workbook.createSheet("TEST");
//			
//			XSSFRow row = sheet.createRow(0);
//			XSSFCell cell = row.createCell(0);
//			cell.setCellValue("李志伟");
//			
//			row.createCell(1).setCellValue(false);
//			row.createCell(2).setCellValue(new Date());
//			row.createCell(3).setCellValue(12.345);
//			
//			workbook.write(out);
//			out.close();
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//	}
//	
////	@Test
//	void testSheet2() {
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\testExcel.xlsx";
//			FileOutputStream out = new FileOutputStream(filePath);
//			
//			XSSFWorkbook workbook = new XSSFWorkbook();
//			XSSFSheet sheet = workbook.createSheet("TEST2");
//			
//			XSSFRow row = sheet.createRow(0);
//			XSSFCell cell = row.createCell(0);
//			cell.setCellValue("李志伟");
//			
//			row.createCell(1).setCellValue(false);
//			row.createCell(2).setCellValue(new Date());
//			row.createCell(3).setCellValue(12.345);
//			
//			XSSFRow row1 = sheet.createRow(1);
//			row1.createCell(0).setCellValue("赵志伟");
//			row1.createCell(1).setCellValue(true);
//			row1.createCell(2).setCellValue(new Date());
//			row1.createCell(3).setCellValue(54.321);
//			
//			workbook.write(out);
//			out.close();
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//	}
//	
//	@Test
//	void testReadSheet() {
//		log.info("begin");
//		try {
//			// 文件路径
//			String filePath = "D:\\work\\附件1：地方自评报告.xlsx";
//			FileInputStream fis = new FileInputStream(filePath);
//			
//			XSSFWorkbook workbook = new XSSFWorkbook(fis);
//			XSSFSheet sheet = workbook.getSheetAt(1);
//			
//			log.info(sheet.getSheetName());
//			
//			log.info(""+sheet.getLastRowNum());
//			
//			log.info(""+sheet.getRow(5).getCell(2).toString());
//			log.info(""+sheet.getRow(5).getCell(3).toString());
//			
//			log.info(""+sheet.getRow(6).getCell(2).toString());
//			log.info(""+sheet.getRow(6).getCell(3).toString());
//			
//			log.info(""+sheet.getRow(7).getCell(2).toString());
//			log.info(""+sheet.getRow(7).getCell(3).toString());
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		}
//		log.info("end");
//	}
//}
//
//
////XSSFSheet sheet1 = workbook.getSheetAt(1);
////Map<Object, Object> sheet1Map = readSheetData(sheet1, 5, 3, 7);
////
////XSSFSheet sheet2 = workbook.getSheetAt(2);
////Map<Object, Object> sheet2Map = readSheetData(sheet2, 5, 3, 7);
////
////XSSFSheet sheet3 = workbook.getSheetAt(3);
////Map<Object, Object> sheet3Map = readSheetData(sheet3, 5, 3, 6);
////
////XSSFSheet sheet4 = workbook.getSheetAt(4);
////Map<Object, Object> sheet4Map = readSheetData(sheet4, 5, 3, 6);
////
////XSSFSheet sheet5 = workbook.getSheetAt(5);
////Map<Object, Object> sheet5Map = readSheetData(sheet5, 5, 3, 6);
//
//
////rb.put("SheetName", sheet.getSheetName());
////rb.put("RowCount", sheet.getLastRowNum());
////
////Map<Object, Object> rowMap = new HashMap<>();
////for (int i = 5; i < sheet.getLastRowNum(); i ++) {
////	XSSFRow row = sheet.getRow(i);
////	
////	Map<Object, Object> cellMap = new HashMap<>();
//////	for (int j = 3; j < row.getLastCellNum(); j ++) {
////	for (int j = 3; j < 7; j ++) {
////		XSSFCell cell = row.getCell(j);
////		cellMap.put(j, cell.toString());
////	}
////	rowMap.put(i, cellMap);
////}
////rb.put("sheet1", rowMap);