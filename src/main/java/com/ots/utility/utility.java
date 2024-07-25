package com.ots.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ots.dataprovider.configread;

public class utility {
	//alert
	public static String gettextandacceptaltert(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait( driver,Duration.ofSeconds(10));
		 Alert alt=wait.until(ExpectedConditions.alertIsPresent());
		 String alt_text= alt.getText();
		 alt.accept();
		return alt_text;
	}
	
	
	public static String gettextandacceptaltert(WebDriver driver ,String dataToType)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 Alert alt=wait.until(ExpectedConditions.alertIsPresent());
		 String alt_text= alt.getText();
		 alt.sendKeys(dataToType);
		 return alt_text;
	}
	
	
	
	//click only elements
	public static void clickElement(WebDriver driver,WebElement element)
	{
		try {
			
			element.click();
		}catch(Exception e)
		{
			System.out.println("Webelement click failed _trying with actions class");
			Actions act=new Actions(driver);
			
			try {
				act.click(element).perform();
			}catch(Exception e1)
			{
				System.out.println("WebElemnt not click trying with javascriptexcutor");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",element);
			}
		}
		
	}
	
	//click,actionsclick,javascriptclick
	public static void clickElement(WebDriver driver,By locator)
	{
		try {
			
			driver.findElement(locator).click();
		}catch(Exception e)
		{
			System.out.println("Webelement click failed _trying with actions class");
			Actions act=new Actions(driver);
			
			try {
				act.click(driver.findElement(locator)).perform();
			}catch(Exception e1)
			{
				System.out.println("WebElemnt not click trying with javascriptexcutor");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",driver.findElement(locator) );
			}
		}
		
	}
	//highlightelement
	public static WebElement highlightelement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("aruguments[0].setAttribute('style',background:yellow; border:2px soild red;');",element);
		waitForSeconds(1);
		js.executeScript("aruguments[0].setAttribute('style', 'border:2px soild white');",element);
		return element;
	}
	//getelement
	public static WebElement getElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		if(configread.getProperty("highlightelement").equalsIgnoreCase("true"))
		{
			highlightelement(driver, element);
		}
	
		return element;
	}
		
	
	
	//wait for seconds
	public static void waitForSeconds( int Seconds)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread.Interrupted"+e.getMessage());
		}
	}
	//get currentdate
	public static String getDateTime()
	{
		Date currentdate=new Date();
		System.out.println(currentdate);
		SimpleDateFormat formateDate=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String newDate=formateDate.format(currentdate);
		System.out.println(newDate);
		return newDate;
		
	}
	//capture screen shot
	public static  String capturescreenshotAsBase64( WebDriver driver)
	{
		//screen shot wait
		TakesScreenshot ts=(TakesScreenshot)driver;//syntax
		String src=ts.getScreenshotAs(OutputType.BASE64);//syntax
		return src;
	}
	
	//capture screen shot for webelement
	public static  void capturescreenshotwithdate( WebDriver driver,WebElement element)
	{
		
		File src=element.getScreenshotAs(OutputType.FILE);//syntax
		File dest=new File( System.getProperty("user.dir")+"/screenshots/Element_screenshot_"+getDateTime()+".png");//creat new folder in package explorer
		System.out.println(src.getAbsolutePath());//to get absolutepath
		System.out.println(src.getName());//pathname
		try {
			FileHandler.copy(src,dest);//syntax
		} catch (IOException e) {
			// TODO Auto-generated catch block--------->exception handling
			e.printStackTrace();
			System.out.println("Failed tp get scrrenshot"+e.getMessage());
		}
	}
	
	
}
