package com.jbk.OfflineWebsite;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelRead {
	@Test
	public void readData() throws Exception{
		try {
			FileInputStream fis = new FileInputStream("E:\\workspace3\\com.jbk\\TestData.xls");
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh= wb.getSheetAt(0);
			int rowCount=sh.getLastRowNum();
			System.out.println(rowCount);
			for(int i=0;i<rowCount;i++){
			String data=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
