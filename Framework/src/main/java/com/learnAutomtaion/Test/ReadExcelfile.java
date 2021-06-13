package com.learnAutomtaion.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelfile {
	public static void main(String[] args) throws Exception {
		

	File src= new File("./TestDATA/DATA.xlsx");
	FileInputStream fis  =new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh1=wb.getSheet("Login");
	String value=sh1.getRow(0).getCell(0).getStringCellValue();
	System.out.println(value);
	
	

}}