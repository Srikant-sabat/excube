package com.test.excube360.practice;
/**
 * 
 *//*
package com.excubator.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.excubator.GenericFunction.GenericFunction;

*//**
 * @author User
 *
 *//*
public class AdvanceReport {
	
	GenericFunction gf = new GenericFunction();
	
	ExtentReports report;
	ExtentTest logger; 
	 
	 
	@Test
	public void verifyBlogTitle()
	{
	report=new ExtentReports("D:\\Test\\Excube360Final\\ScreenShots\\advancereport.html");
	 
	logger=report.startTest("VerifyBlogTitle");
	 
	gf.getWebdriver();
	 
	logger.log(Status.FAIL, details)
	 
	GenericFunction.driver.get("http://www.learn-automation.com");
	 
	logger.log(LogStatus.INFO, "Application is up and running");
	 
	String title=GenericFunction.driver.getTitle();
	 
	Assert.assertTrue(title.contains("Google")); 
	 
	logger.log(LogStatus.PASS, "Title verified");
	
	}
	 
	 
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
	 
	String screenshot_path=gf.CaptureScreenShot("abc", "xyz");
	String image= logger.addScreenCapture(screenshot_path);
	Thread.sleep(2000);
	logger.log(LogStatus.FAIL, "Title verification", image);
	 
	 
	}
	 
	report.endTest(logger);
	report.flush();
	 
	GenericFunction.driver.get("D:\\Test\\Excube360Final\\ScreenShots\\advancereport.html");
	 
	 
	}
}
*/