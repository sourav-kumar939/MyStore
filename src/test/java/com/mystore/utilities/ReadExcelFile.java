package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {
	
	public static String[][] excelData(String fileName,String sheetName) {
		
		 String[][] data=null; 
		
		try {
			
			File file=new File(fileName);
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			
			XSSFSheet sheet=workbook.getSheet(sheetName);
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfColumns=sheet.getRow(0).getLastCellNum();
			
			data=new String[noOfRows-1][noOfColumns];
			for(int i=0;i<noOfRows-1;i++) {
				for(int j=0;j<noOfColumns;j++) {
					DataFormatter df=new DataFormatter();
					data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				}
			}
			
			fis.close();
			workbook.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	
//	public static FileInputStream inputStream;
//	public static XSSFWorkbook workBook;
//	public static XSSFSheet excelSheet;
//	public static XSSFRow row;
//	public static XSSFCell cell;
//
//	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo/*column no.*/)
//	{
//
//		try
//		{
//
//			inputStream = new FileInputStream(fileName);
//			workBook = new XSSFWorkbook(inputStream);
//			excelSheet =  workBook.getSheet(sheetName);
//			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
//
//			workBook.close();
//
//			return cell.getStringCellValue();
//
//		}
//
//		catch (Exception e)
//
//		{
//			return "";
//
//		}
//	}
//
//	public static int getRowCount (String fileName, String sheetName)
//	{
//
//		try
//
//		{
//
//			inputStream = new FileInputStream(fileName);
//			//create XSSFWorkBook Class object for excel file manipulation
//
//			workBook = new XSSFWorkbook(inputStream);
//			excelSheet =  workBook.getSheet(sheetName);
//
//			//get total no. of rows
//			int ttlRows = excelSheet.getLastRowNum() + 1;
//
//			workBook.close();
//
//			return ttlRows;
//
//		}
//
//		catch (Exception e)
//
//		{
//
//			return 0;
//            
//		}
//
//	}
//
//	public static int getColCount (String fileName, String sheetName)
//	{
//
//		try
//
//		{
//
//			FileInputStream inputStream = new FileInputStream(fileName);
//			//create XSSFWorkBook Class object for excel file manipulation
//			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
//			XSSFSheet excelSheet =  workBook.getSheet(sheetName);
//
//			//get total no. of columns
//			int ttlCells = excelSheet.getRow(0).getLastCellNum();
//
//			workBook.close();
//			return ttlCells;
//
//		}
//
//		catch (Exception e)
//         
//		{
//
//			return 0;
//
//		}
//
//	}
	
}
