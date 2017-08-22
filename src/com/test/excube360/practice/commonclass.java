package com.test.excube360.practice;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;

public class commonclass {
	GenericFunction gf = new GenericFunction();
	GlobalVariable gv = new GlobalVariable();
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReports;
	public static ExtentTest test;
	
	@BeforeSuite
	public void seup(){
		htmlReports = new ExtentHtmlReporter(System.getProperty("user.dir")+"./ScreenShots/advancereport.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReports);
	}
	/*@BeforeMethod
	public void start(){
		test=extent.createTest(GenericFunction.driver.getClass().getMethods());
	}*/
	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException{
		if (result.getStatus()==ITestResult.FAILURE){
			test.fail(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.RED));
			test.fail(result.getThrowable());
			String screenshot_path=gf.CaptureScreenShot("abc", "xyz");
			ExtentTest image= test.addScreenCaptureFromPath(screenshot_path);
			Thread.sleep(2000);
			test.log(Status.FAIL, "Title verification"+image);
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.pass(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP){
			test.skip(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.STARTED){
			test.error(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.PURPLE));
			test.error(result.getThrowable());
			
		}
		
	}
	@AfterSuite
	public void teardown(){
		extent.flush();
	}

}
