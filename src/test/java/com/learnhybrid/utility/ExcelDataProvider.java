package com.learnhybrid.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
 public ExcelDataProvider() {
	 
 
	File src= new File(".//TestData//Testdata.xlsx");
	
	try { 
	FileInputStream  fis = new FileInputStream(src);// reading source file 
	 wb = new XSSFWorkbook(fis);// get excel data from source file through xssf workbook 
	}
	catch(Exception e)
	{
		System.out.println("unable to read excel file"+e.getMessage());
	}}
	
 public String  getStringData(int sheetIndex,int row , int column) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	public String  getStringData(String sheetName,int row , int column) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	public double getNumericData(String sheetName,int row , int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
		
		
	}
	
	
	
	
	
}
