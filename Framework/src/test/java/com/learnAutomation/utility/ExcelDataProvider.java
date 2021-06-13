package com.learnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
	File src=new File("./TestDATA/DATA.xlsx");
	try {
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
	} catch (IOException e) {
		System.out.println("Unable to read excel file"+e.getMessage());
	}
	}
	
	public String  getStringdata(int sheetIndex,int row, int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public String  getStringdata(String sheetname,int row, int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String sheetname,int row, int column)
	{
		return wb.getSheet("sheetname").getRow(row).getCell(column).getNumericCellValue();
	
	}
	
	
}
