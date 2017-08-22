package com.test.excube360.practice;
/*package com.excubator.practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.excubator.GenericFunction.GenericFunction;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReport1 {
GenericFunction gf = new GenericFunction();
	
	ExtentReports report;
	ExtentTest logger; 
	 
	 
	@Test
	public void verifyBlogTitle()
	{
	report=new ExtentReports("D:\\Test\\Excube360Final\\ScreenShots\\advancereport.html");
	 
	logger=report.startTest("VerifyBlogTitle");
	 
	gf.getWebdriver();
	 
	logger.log(LogStatus.INFO, "Browser started ");
	 
	GenericFunction.driver.get("https://www.excube360.com");
	 
	logger.log(LogStatus.INFO, "Application is up and running");
	
	String s1 = GenericFunction.driver.findElement(By.id("search-title")).getText();
	System.out.println(s1);
	logger.log(LogStatus.INFO, "print the text");
	 
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