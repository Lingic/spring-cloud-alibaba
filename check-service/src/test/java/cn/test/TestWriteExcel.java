//package cn.test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.jupiter.api.Test;
//
//import com.rfics.unit.WriteExcel;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//class TestWriteExcel {
//
////	@Test
//	void test() {
//		try {
//			String filePath = "D:\\work\\附件1：地方自评报告.xlsx";
//			FileInputStream fis = new FileInputStream(filePath);
//			XSSFWorkbook workbook = new XSSFWorkbook(fis);
//			XSSFSheet sheet = workbook.getSheetAt(1);
//			
//			XSSFRow row = sheet.getRow(5);
//			XSSFCell cell = row.getCell(3);
//			
//			cell.setCellValue("中华人民工和国");
//			
//			FileOutputStream os = new FileOutputStream(filePath);
//			os.flush();
//			workbook.write(os);
//			
//			fis.close();
//			os.close();
//			workbook.close();
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		} 
//	}
//	
//	
////	@Test
//	void test2() {
//		try {
//			String filePath = "D:\\work\\附件1：地方自评报告.xlsx";
//			FileInputStream fis = new FileInputStream(filePath);
//			XSSFWorkbook workbook = new XSSFWorkbook(fis);
//			XSSFSheet sheet = workbook.getSheetAt(1);
//			
//			XSSFRow row = sheet.getRow(5);
//			XSSFCell cell = row.getCell(3);
//			
//			cell.setCellValue("中华人民工和国");
//			
//			Map<Object, Object> mapRow5 = new HashMap<>();
//			mapRow5.put(3, "中华人民工和国5-3");
//			mapRow5.put(4, "中华人民工和国5-4");
//			mapRow5.put(5, "中华人民工和国5-5");
//			
//			Map<Object, Object> mapRow6 = new HashMap<>();
//			mapRow6.put(3, "中华人民工和国6-3");
//			mapRow6.put(4, "中华人民工和国6-4");
//			mapRow6.put(5, "中华人民工和国6-5");
//			
//			Map<Object, Object> mapSheet1 = new HashMap<>();
//			mapSheet1.put(5, mapRow5);
//			mapSheet1.put(6, mapRow6);
//			
//			Map<Object, Object> map1 = new HashMap<>();
//			map1.put(1, mapSheet1);
////			map1.put(2, Object);
////			map1.put(3, Object);
////			map1.put(4, Object);
////			map1.put(5, Object);
//			
//			FileOutputStream os = new FileOutputStream(filePath);
//			os.flush();
//			workbook.write(os);
//			
//			fis.close();
//			os.close();
//			workbook.close();
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		} 
//	}
//	
//	
////	@Test
//	void test3() {
//		try {
//			String filePath = "D:\\work\\附件1：地方自评报告.xlsx";
//			FileInputStream fis = new FileInputStream(filePath);
//			XSSFWorkbook workbook = new XSSFWorkbook(fis);
//			XSSFSheet sheet = workbook.getSheetAt(1);
//			
//			XSSFRow row = sheet.getRow(5);
//			XSSFCell cell = row.getCell(3);
//			cell.setCellValue("中华人民工和国");
//			
//			XSSFCell cell4 = row.getCell(4);
//			cell4.setCellValue("中华人民共和国4");
//			
//			FileOutputStream os = new FileOutputStream(filePath);
//			os.flush();
//			workbook.write(os);
//			
//			fis.close();
//			os.close();
//			workbook.close();
//			
//		} catch (IOException e) {
//			log.error("Error ", e);
//		} 
//	}
//
//	
////	@Test
//	public void testWriteCell() {
//		String pathFile = "D:\\\\work\\\\附件1：地方自评报告.xlsx";
//		int sheetIndex = 1;
//		int rowIndex = 6;
//		int columnIndex = 4;
//		String content = "中华人民工和国6-4";
//		WriteExcel.writeCell(pathFile, sheetIndex, rowIndex, columnIndex, content);
//	}
//	
//	
//	
////	@Test
//	public void testWriteRow() {
//		String pathFile = "D:\\\\work\\\\附件1：地方自评报告.xlsx";
//		int sheetIndex = 1;
//		int rowIndex = 7;
//		int columnIndex = 3;
//		List<String> content = new ArrayList<>();
//		content.add("中华人民工和国7-3");
//		content.add("中华人民工和国7-4");
//		content.add("中华人民工和国7-5");
//		content.add("中华人民工和国7-6");
//		WriteExcel.writeRow(pathFile, sheetIndex, rowIndex, columnIndex, content);
//	}
//	
//	@Test
//	public void testWriteSheet() {
//		String pathFile = "D:\\\\work\\\\附件1：地方自评报告.xlsx";
//		int sheetIndex = 2;
//		int rowIndex = 5;
//		int columnIndex = 3;
//		
//		List<List<String>> content = new ArrayList<>();
//		
//		List<String> list1 = new ArrayList<>();
//		list1.add("中华人民工和国5-3");
//		list1.add("中华人民工和国5-4");
//		list1.add("中华人民工和国5-5");
//		list1.add("中华人民工和国5-6");
//		content.add(list1);
//		
//		List<String> list2 = new ArrayList<>();
//		list2.add("中华人民工和国6-3");
//		list2.add("中华人民工和国6-4");
//		list2.add("中华人民工和国6-5");
//		list2.add("中华人民工和国6-6");
//		content.add(list2);
//		
//		List<String> list3 = new ArrayList<>();
//		list3.add("中华人民工和国7-3");
//		list3.add("中华人民工和国7-4");
//		list3.add("中华人民工和国7-5");
//		list3.add("中华人民工和国7-6");
//		content.add(list3);
//		
//		WriteExcel.writeSheet(pathFile, sheetIndex, rowIndex, columnIndex, content);
//	}
//	
//	
//}
