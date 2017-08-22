package com.test.excube360.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.pages.DashboardPage;
import com.test.excube360.pages.HomePage;
import com.test.excube360.pages.LoginPage;

public class excubedemo extends commonclass {
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	/*@BeforeClass
	public void beforeclass(){
		test=extent.createTest("BuyReport");
		gf.getWebdriver();
		test.log(Status.INFO, "open browser");
		GenericFunction.driver.get(gv.getexcube360());
		test.log(Status.INFO, "application running");
		//Assert.assertEquals(GenericFunction.driver.getTitle(), "excube360");
		
	}*/
	@Test
	public void test() throws EncryptedDocumentException, InvalidFormatException, IOException{
		/*LoginPage lp =PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		DashboardPage hp = PageFactory.initElements(GenericFunction.driver, DashboardPage.class);*/
		
		test=extent.createTest("BuyReport");
		gf.getWebdriver();
		test.log(Status.INFO, "open browser");
		GenericFunction.driver.get(gv.getexcube360());
		test.log(Status.INFO, "application running");
		System.out.println(GenericFunction.driver.getTitle());
		Assert.assertEquals(GenericFunction.driver.getTitle(), "Excube360");
		System.out.println("pass");
		//test.log(Status.FAIL, "titel not matched");
		LoginPage lp =PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		DashboardPage hp = PageFactory.initElements(GenericFunction.driver, DashboardPage.class);
		lp.Login();
		test.log(Status.INFO, "log in sucessful");
		hp.getDashboard().click();
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException{
		if(result.getStatus()==ITestResult.FAILURE){
		System.out.println(result.getStatus());
		System.out.println(ITestResult.FAILURE);
		test.fail(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.RED));
		test.fail(result.getThrowable());
		String screenshot_path=gf.CaptureScreenShot("abc", "xyz");
		ExtentTest image= test.addScreenCaptureFromPath(screenshot_path);
		Thread.sleep(2000);
		test.log(Status.FAIL, "Title verification"+image);
		}
		
	}
	
}


