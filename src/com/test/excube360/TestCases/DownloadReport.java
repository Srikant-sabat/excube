/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.DashboardPage;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
public class DownloadReport extends ReportGenerate {
	GlobalVariable gv=new GlobalVariable();  															//create object for GlobalVariable
    GenericFunction gf=new GenericFunction();
    
    @BeforeClass()
    public void beforeclass()
    {
    	test=extent.createTest("DownloadReport verification");
    	gf.getWebdriver();																				//call to get web driver method in generic function which returns browser reference
    	test.log(Status.INFO, "Browser open");
    	GenericFunction.driver.get(gv.getexcube360());
    	test.log(Status.INFO, "Application running");
    	GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   	
    	  }
    
    @Test
    public void ReportDownload() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
    	try {
    		LoginPage lp = PageFactory.initElements(GenericFunction.driver, LoginPage.class);
        	DashboardPage dp = PageFactory.initElements(GenericFunction.driver, DashboardPage.class);
        	
        	lp.Login();
        	test.log(Status.INFO, "Login sucessfully");
        	dp.getDashboard().click();
        	test.log(Status.INFO, "click on Dashboard");
        	dp.DownloadReport();
        	test.log(Status.INFO, "click on download button and download file");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "test case fail"+e.getMessage());
		}
    	
    	
      }
		
    @AfterClass
    public void afterclass()
    {
	  GenericFunction.driver.close();
	  test.log(Status.INFO, "Browser close sucessfully");
    }

}
