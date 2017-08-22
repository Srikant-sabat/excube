/**
 * 
 */
package com.test.excube360.GenericFunction;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author User
 *
 */
public class ReportGenerate {
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
	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException{
		if (result.getStatus()==ITestResult.FAILURE){
			test.fail(MarkupHelper.createLabel(result.getName()+"test case failure", ExtentColor.RED));
			test.fail(result.getThrowable());
			String screenshot_path=gf.CaptureScreenShot(result.getTestName(), "abc");
			ExtentTest image= test.addScreenCaptureFromPath(screenshot_path);
			Thread.sleep(2000);
			test.log(Status.FAIL, "Title verification"+image);
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.pass(MarkupHelper.createLabel(result.getName()+"--test case sucessfully", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP){
			test.skip(MarkupHelper.createLabel(result.getName()+"--test case skip", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
			
		}
		
		
	}
	@AfterSuite
	public void teardown(){
		extent.flush();
	}


}
