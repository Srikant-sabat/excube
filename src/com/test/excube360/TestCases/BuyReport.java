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
import com.test.excube360.pages.CitrusPayPage;
import com.test.excube360.pages.DashboardPage;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
public class BuyReport extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("BuyReport Verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	
	@Test
	public void Reportbuy() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		try {
			LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
			DashboardPage dp = PageFactory.initElements(GenericFunction.driver, DashboardPage.class);
			CitrusPayPage cp = PageFactory.initElements(GenericFunction.driver, CitrusPayPage.class);
	        
			
			lp.Login();
			test.log(Status.INFO, "login sucessfully");
			dp.getDashboard().click();
			test.log(Status.INFO, "click on dashboard");
			dp.BuyReort();
			test.log(Status.INFO, "Buy Report Sucessfully");
			cp.getcancel().click();
			test.log(Status.INFO, "close the Citrus pop-up");
			Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Test case Fail"+e.getMessage());
		}
		
		
		
	}
	 @AfterClass
	    public void afterclass()
	    {
	  	  GenericFunction.driver.close();
	  	  test.log(Status.INFO, "close the Browser");
	    }

}
