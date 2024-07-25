package com.ots.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ots.dataprovider.configread;
import com.ots.factory.Browserfactory;

public class Base {
	 public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.out.println("starting the browser");
		
		
		driver=Browserfactory.startBrowser(configread.getProperty("browser"), configread.getProperty("URL"));
		
		System.out.println("starting the browser up and running");
	}
	@AfterMethod
	public void TearDown()
	{
		System.out.println("closing the browser run after method");
		Browserfactory.closeBrowser(driver);
		System.out.println("session closed");
	}


}
