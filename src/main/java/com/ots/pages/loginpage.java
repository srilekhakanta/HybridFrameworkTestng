package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ots.utility.utility;

public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver=driver; // inside constructor driver and given driver is same we have to use "this" keyword
	}
	
	 private By username=By.xpath("//input[@placeholder='Enter Email']");
	 private By password=By.xpath("//input[@placeholder='Enter Password']");
	 private By loginbutton=By.xpath("//button[text()='Sign in']");
	 private By createlink=By.xpath("//a[normalize-space()='New user? Signup']");

public boolean islinkvisible()
{
	boolean status=utility.getElement(driver,createlink).isDisplayed();
	return status;
}

	public Homepage loginApplication(String uname,String pass)//we can use this method everywhere that's y we pass parameters
	{
		utility.getElement(driver, username).sendKeys(uname);
		//driver.findElement(username).sendKeys(uname);
	utility.getElement(driver, password).sendKeys(pass);
		//driver.findElement(password).sendKeys(pass);
		
		utility.clickElement( driver, loginbutton);
		Homepage home=new Homepage(driver);
		return home;
		
	}


}


