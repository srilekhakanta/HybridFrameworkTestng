package com.ots.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class customdataprovider {

	@DataProvider(name="logintestdata")
	
	
	public  static Object[][] generatedatafromexcel()
	{
		Reporter.log("preparing data", true);
		Object[][]arr=ExcelReader.getDataFromExcel("logincredentials");
		Reporter.log("excel data prepared", true);
		
		return arr;
	}
	
}
