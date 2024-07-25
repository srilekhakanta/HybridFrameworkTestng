package com.ots.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.ots.dataprovider.configread;
import com.ots.factory.Browserfactory;
import com.ots.utility.utility;

	public class ReportlistenerForFramework implements ITestListener {

		ExtentReports extent = ExtentManager.createInstance();

		ExtentTest extenttest;

		ThreadLocal<ExtentTest> Test = new ThreadLocal<ExtentTest>();

		public void onTestStart(ITestResult result) {
			System.out.println("starting test");
			extenttest = extent.createTest(result.getMethod().getMethodName());
			Test.set(extenttest);
		}

		public void onTestSuccess(ITestResult result) 
		{
			System.out.println("Driver value "+Browserfactory.getdriver());
			if (configread.getProperty("screenshotOnSuccess").equalsIgnoreCase("true")) {
				Test.get().pass("Test pass",
						MediaEntityBuilder.createScreenCaptureFromBase64String(
								utility.capturescreenshotAsBase64(Browserfactory.getdriver())).build());
			} else {
				Test.get().pass("Test pass" + result.getThrowable());
			}

		}

		public void onTestFailure(ITestResult result) 
		{
			System.out.println("Driver value "+Browserfactory.getdriver());
			
			if (configread.getProperty("screenshotOnfailure").equalsIgnoreCase("true")) {
				Test.get().fail("Test Failed" + result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(
								utility.capturescreenshotAsBase64(Browserfactory.getdriver())).build());
			} else {
				Test.get().fail("Test Failed" + result.getThrowable());
			}

		}

		public void onTestSkipped(ITestResult result) {
			if (configread.getProperty("screenshotOnSkipped").equalsIgnoreCase("true")) {
				Test.get().skip("Test Skipped" + result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(
								utility.capturescreenshotAsBase64(Browserfactory.getdriver())).build());
			} else {
				Test.get().skip("Test Skipped" + result.getThrowable());
			}

		}

		public void onFinish(ITestContext context) {

			extent.flush();
		}

	}

