//package cn.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//import com.rfics.unit.WriteExcel;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//class TestExcelWrite {
//	
//	
////	@Test
//	public void testWriteCell() {
//		log.info("writerCell");
//		String pathFile = "D:\\\\work\\\\附件1：地方自评报告.xlsx";
//		int sheetIndex = 1;
//		int rowIndex = 6;
//		int columnIndex = 4;
//		String content = "中华人民工和国6-4";
//		WriteExcel.writeCell(pathFile, sheetIndex, rowIndex, columnIndex, content);
//	}
//	
//	
////	@Test
//	public void testWriteRow() {
//		log.info("writerRow");
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
//	
//	@Test
//	public void testWriteSheet() {
//		log.info("writerSheet");
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
