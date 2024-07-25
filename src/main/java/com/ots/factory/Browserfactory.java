package com.ots.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ots.dataprovider.configread;

public class Browserfactory {
	
	 public static WebDriver driver;
	 public static WebDriver getdriver() {
			
			return driver;
		}

	public  static WebDriver startBrowser(String browser,String URL)
	{
		System.out.println(" Login Info:starting "+URL+" "+"on"+browser);
	
		if(browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			if(configread.getProperty("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("--headless=new");
				System.out.println("test run into headless mode");
			}
			
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			
			FirefoxOptions opt=new FirefoxOptions();
			if(configread.getProperty("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("--headless=new");
				System.out.println("test run into headless mode");
			}
		
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			EdgeOptions opt=new EdgeOptions();
			
		
			driver=new EdgeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configread.getProperty("implictwait"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(configread.getProperty("pageloadtimeout"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(configread.getProperty("Scripttimeout"))));
		driver.get(URL);
		return driver;
		
	}
	public  static void closeBrowser(WebDriver driver)
	{
		System.out.println("close the browser");
		driver.quit();
	}
}
	
