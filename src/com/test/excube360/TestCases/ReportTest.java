/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.HomePage;
import com.test.excube360.pages.LoginPage;
import com.test.excube360.pages.ReportsPage;

/**
 * @author User
 *
 */
public class ReportTest extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("Report test verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	public void Report() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		
		try {
			LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
			HomePage hp=PageFactory.initElements(GenericFunction.driver, HomePage.class);
			ReportsPage rp = PageFactory.initElements(GenericFunction.driver, ReportsPage.class);
			
			
			lp.Login();
			test.log(Status.INFO, "Log in Sucessfully");
			hp.getReports().click();
			test.log(Status.INFO, "click on BuyReport");
			GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue(rp.getREPORTSINSPIREDBYYOURSEARCHHISTORY().isDisplayed());
			test.log(Status.INFO, "REPORTS INSPIRED BY YOUR SEARCH HISTORY is displayed");
			rp.getFilterby().click();
			test.log(Status.INFO, "click on FilterBy button");
			rp.getInternetOfThings().click();
			test.log(Status.INFO, "click on Internet of Things");
			rp.getAPPLY().click();
			test.log(Status.INFO, "click on Apply button");
			Thread.sleep(2000);
			rp.getFilterby().click();
			test.log(Status.INFO, "click on FilterBy button");
			rp.getcancel().click();
			test.log(Status.INFO, "click on cancel button");
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Test case Fail");
		}
		
		
		
				
	}
	@AfterClass
    public void afterclass()
    {
  	  GenericFunction.driver.close();
  	  test.log(Status.INFO, "close the Browser");
    }

}
