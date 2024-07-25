package com.ots.testdata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ots.base.Base;
import com.ots.dataprovider.customdataprovider;
import com.ots.pages.Homepage;
import com.ots.pages.loginpage;

public class logintest extends Base{
	
	@Test(dataProvider="logintestdata",dataProviderClass=customdataprovider.class)
	public void validlogin(String username,String password)
	{
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://freelance-learn-automation.vercel.app/login");
		//driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("admin@email.com");
		//driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("admin@123");
		//driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		loginpage login=new loginpage(driver);
		Homepage home=login.loginApplication(username,password);
		Assert.assertTrue(home.isWelcomeMsgVisible(), "loginfailed");
		
	
	}
	@Test
	public void verifylink()
	{
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='New user? Signup']")).isDisplayed());
	
	}


}

