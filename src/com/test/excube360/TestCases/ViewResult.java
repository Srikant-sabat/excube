/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.AnalyticPage;
import com.test.excube360.pages.DashboardPage;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
public class ViewResult extends ReportGenerate {
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();

	      @BeforeClass()
	       public void beforeclass()
	        {
	    	    test=extent.createTest("view Result verification");
		        gf.getWebdriver();                                                  //call to get web driver method in generic function which returns browser reference
		        test.log(Status.INFO, "ope browser");
		        GenericFunction.driver.get(gv.getexcube360());                     //get the browser
		        test.log(Status.INFO, "application running");
		        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        }
	      @Test
	      public void ResultView() throws EncryptedDocumentException, InvalidFormatException, IOException{
	    	  try {
	    		  LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		    	  DashboardPage dp = PageFactory.initElements(GenericFunction.driver, DashboardPage.class);
		    	  AnalyticPage ap = PageFactory.initElements(GenericFunction.driver, AnalyticPage.class);
		    	  
		    	  lp.Login();
		    	  test.log(Status.INFO, "log in sucessfully");
		    	  dp.getDashboard().click();
		    	  test.log(Status.INFO, "click on Dashboard");
		    	  dp.getViewResult().click();
		    	  test.log(Status.INFO, "click on ViewResult");
		    	  gf.WebdriverWait("visible", ap.getAccordian());
		    	  //System.out.println(ap.getkeyword().getText());
		    	  test.log(Status.INFO, "view Result sucessfully"+ap.getkeyword().getText());
		 
				
			} catch (Exception e) {
				// TODO: handle exception
				test.log(Status.INFO, "test case fail");
			}
	    	  
	      }
	      
	      @AfterClass
		    public void afterclass()
		    {
		  	  GenericFunction.driver.close();  
		  	  test.log(Status.INFO, "browser close sucessfully");
		    }

}
