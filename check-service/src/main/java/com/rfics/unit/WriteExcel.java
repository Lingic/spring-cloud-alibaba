package com.rfics.unit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WriteExcel {

	
	public static void writeCell(String pathFile, int sheetIndex, int rowIndex, int columnIndex, String content) {
		if (null != content) {
			FileInputStream fis = null;
			XSSFWorkbook workbook = null;
			FileOutputStream os = null;
			
			try {
				fis = new FileInputStream(pathFile);
				workbook = new XSSFWorkbook(fis);
				
				XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				XSSFRow row = sheet.getRow(rowIndex);
				XSSFCell cell = row.getCell(columnIndex);
				cell.setCellValue(content);
				
				os = new FileOutputStream(pathFile);
				os.flush();
				workbook.write(os);
				
			} catch (IOException e) {
				log.error("Error ", e);
			} finally {
				if (null != fis) {
					try {
						fis.close();
					} catch (IOException e) {
						log.error("Error", e);
					}
				}
				if (null != os) {
					try {
						os.close();
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
		}
	}
	
	
	public static void writeRow(String pathFile, int sheetIndex, int rowIndex, int columnIndex, List<String> content) {
		if (null != content) {
			FileInputStream fis = null;
			XSSFWorkbook workbook = null;
			FileOutputStream os = null;
			
			try {
				fis = new FileInputStream(pathFile);
				workbook = new XSSFWorkbook(fis);
				
				XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				XSSFRow row = sheet.getRow(rowIndex);
				
				if (null != row) {
					for (Iterator<String> iter = content.iterator(); iter.hasNext(); ) {
						String str = iter.next();
						
						if (null != str) {
							XSSFCell cell = row.getCell(columnIndex ++);
							cell.setCellValue(str);
						}
					}
				}
				
				os = new FileOutputStream(pathFile);
				os.flush();
				workbook.write(os);
				
			} catch (IOException e) {
				log.error("Error ", e);
			} finally {
				if (null != fis) {
					try {
						fis.close();
					} catch (IOException e) {
						log.error("Error", e);
					}
				}
				if (null != os) {
					try {
						os.close();
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
		}
	}
	
	
	public static void writeSheet(String pathFile, int sheetIndex, int rowIndex, int columnIndex, List<List<String>> content) {
		if (null != content) {
			FileInputStream fis = null;
			XSSFWorkbook workbook = null;
			FileOutputStream os = null;
			
			try {
				fis = new FileInputStream(pathFile);
				workbook = new XSSFWorkbook(fis);
				
				XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				for (Iterator<List<String>> iter = content.iterator(); iter.hasNext(); ) {
					List<String> list = iter.next();
					if (null != list) {
						XSSFRow row = sheet.getRow(rowIndex ++);
						
						if (null != row) {
							int column = columnIndex;
							for (Iterator<String> iter2 = list.iterator(); iter2.hasNext(); ) {
								String str = iter2.next();
								
								if (null != str) {
									XSSFCell cell = row.getCell(column ++);
									cell.setCellValue(str);
								}
							}
						}
					}
				}
				
				os = new FileOutputStream(pathFile);
				os.flush();
				workbook.write(os);
				
			} catch (IOException e) {
				log.error("Error ", e);
			} finally {
				if (null != fis) {
					try {
						fis.close();
					} catch (IOException e) {
						log.error("Error", e);
					}
				}
				if (null != os) {
					try {
						os.close();
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
		}
	}
	
	
}
