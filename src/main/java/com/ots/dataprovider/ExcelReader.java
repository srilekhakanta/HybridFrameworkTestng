package com.ots.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*public class Excelreader {
	static XSSFWorkbook wb;
	public  static Object[][]getdatafromexcel(String SheetName)
	{
		 try {
			wb=new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\teja8\\Downloads\\TestData.xlsx")));
		} catch (IOException e) {
			
			System.out.println("Could not load the data file "+e.getMessage());
		}
		 int row= wb.getSheet("TestdataNew").getPhysicalNumberOfRows();
		 int column=wb.getSheet("TestdataNew").getRow(0).getPhysicalNumberOfCells();
		
		 /*in excel sheet we have 4 rows
		  * but array its takes 3 rows because array starts with zero
		  * so in object array give row-1..so excel  remove first row
		  * come to for loop ( as per excel) i became 1 so we give i=1
		  * in array[i-0]-> here i=1 so array take value 0,0-> this the logic here 
		  */
		/* Object[][] arr=new Object[row-1][column];
		 for(int i=1;i<row;i++)
		 {
			 for(int j=0;j<column;j++)
			 {
				 arr[i-1][j]=getdata("SheetName",i,j);
				 
			 }
		 }
	
		try {
			wb.close();
		} catch (IOException e) {
			
			System.out.println("Could not close the data file "+e.getMessage());

		}
		
		return arr;
	}
	public static String getdata(String SheetName,int row,int column)
	{
		String value="";
		 CellType type=wb.getSheet(SheetName).getRow(row).getCell(column).getCellType();
		 if(type==CellType.NUMERIC)
		 {
			  double dvalue=wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
			 value= String.valueOf(dvalue);
		 }
		 else if(type==CellType.STRING)
		 {
			value= wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		 }
		 else if(type==CellType.BOOLEAN)
		 {
			 boolean bvalue= wb.getSheet(SheetName).getRow(row).getCell(column).getBooleanCellValue();
			value= String.valueOf(bvalue);
		 }
		 else if(type==CellType.BLANK)
		 {
			 value="";
		 }
		 return value;
	}*/

	public class ExcelReader 
	{
		
		static XSSFWorkbook wb;
		
		public static Object[][] getDataFromExcel(String sheetName)
		{
		
			try 
			{
				wb=new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\teja8\\Downloads\\TestData.xlsx")));
				
				System.out.println("LOG:INFO - Loading Excel Workbook");
				
			} catch (IOException e) 
			{
				System.out.println("Could not load the data file "+e.getMessage());
			}
			
			int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
			
			int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			

			Object [][]arr=new Object[row-1][column];
			
			for(int i=1;i<row;i++)
			{
				
				for(int j=0;j<column;j++)
				{
					arr[i-1][j]=getData(sheetName, i, j);
				}
				
			}
			
			System.out.println("LOG:INFO - Excel Workbook Completed");
			
			try 
			{
				wb.close();
				
			} catch (IOException e) 
			{
				System.out.println("Could not close the data file "+e.getMessage());
			}
			
			return arr;
		}
		
		public static Object[][] getDataFromExcel(String TestDataFileName,String sheetName)
		{
		
			try 
			{
				wb=new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\teja8\\Downloads\\TestData.xlsx")));
				
				System.out.println("LOG:INFO - Loading Excel Workbook");
				
			} catch (IOException e) 
			{
				System.out.println("Could not load the data file "+e.getMessage());
			}
			
			int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
			
			int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			
			Object [][]arr=new Object[row-1][column];
			
			for(int i=1;i<row;i++)
			{
				
				for(int j=0;j<column;j++)
				{
					arr[i-1][j]=getData(sheetName, i, j);
				}
				
			}
			
			System.out.println("LOG:INFO - Excel Workbook Completed");
			
			try 
			{
				wb.close();
				
			} catch (IOException e) 
			{
				System.out.println("Could not close the data file "+e.getMessage());
			}
			
			return arr;
		}
		
		public static String getData(String sheetName,int row,int column)
		{
			String value="";
			
			CellType type=wb.getSheet(sheetName).getRow(row).getCell(column).getCellType();
			
			if(type==CellType.NUMERIC)
			{
				double dValue=wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
				
				value=String.valueOf(dValue);
			}
			else if(type==CellType.BOOLEAN)
			{
				boolean bValue=wb.getSheet(sheetName).getRow(row).getCell(column).getBooleanCellValue();
				
				value=String.valueOf(bValue);
			}
			else if(type==CellType.STRING)
			{
				value=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
			}
			else if(type==CellType.BLANK)
			{
				value="";
			}
			
			return value;
			
		}
		
}
