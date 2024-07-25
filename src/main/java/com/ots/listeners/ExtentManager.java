package com.ots.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ots.utility.utility;

public class ExtentManager {
	 private static ExtentReports extent;
	    
	    public static ExtentReports getInstance() {
	    	if (extent == null)
	    	{
	    		extent=createInstance();
		    	
		        return extent;
	    	}
	    		 
	        else
	        {
	        	return extent;
	        }
	    }
	    
	    public static ExtentReports createInstance() {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/Automation_Report"+utility.getDateTime()+".html");
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setReportName("spirnt 1 Report");
	        htmlReporter.config().setDocumentTitle("Automation Report");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
			return extent;
	        


	    }


}
