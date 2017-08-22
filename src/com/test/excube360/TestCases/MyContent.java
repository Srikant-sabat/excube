/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
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
import com.test.excube360.pages.MyContentPage;

/**
 * @author User
 *
 */
public class MyContent extends ReportGenerate {
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();

	      @BeforeClass()
	       public void beforeclass()
	        {
	    	    test=extent.createTest("MyContent verification");
		        gf.getWebdriver();                                                  //call to get web driver method in generic function which returns browser reference
		        test.log(Status.INFO, "browser open");
		        GenericFunction.driver.get(gv.getexcube360());                     //get the browser
		        test.log(Status.INFO, "application open");
		        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        }
	      @Test
	      public void MyContentPageCheck() throws EncryptedDocumentException, InvalidFormatException, IOException{
	    	  try {
	    		  LoginPage lp= PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		    	  HomePage hp = PageFactory.initElements(GenericFunction.driver, HomePage.class);
		    	  MyContentPage cp=PageFactory.initElements(GenericFunction.driver, MyContentPage.class);
		    	  
		    	  
		    	  lp.Login();
		    	  test.log(Status.INFO, "login sucessfully");
		    	  hp.getMyContent().click();
		    	  test.log(Status.INFO, "click on MyContent");
		    	  Assert.assertTrue(cp.getheaderText().isDisplayed());
		    	  test.log(Status.INFO, "hadder text Vesible");
		    	  Assert.assertTrue(cp.getlatestUpdate().isDisplayed());
		    	  test.log(Status.INFO, "latest update is vesible");
		    	  Assert.assertTrue(cp.getpresentation().isDisplayed());
		    	  test.log(Status.INFO, "Presentation is vesible");
		    	  Assert.assertTrue(cp.getLastThreeDays().isDisplayed());
		    	  test.log(Status.INFO, "Last Three Days is vesible");
		    	  Assert.assertTrue(cp.getLastThreeDays1().isDisplayed());
		    	  test.log(Status.INFO, "Last Three Days 1st block is vesible");
		    	  Assert.assertTrue(cp.getLastThreeDays2().isDisplayed());
		    	  test.log(Status.INFO, "Last Three Days 2st block is vesible");
		    	  Assert.assertTrue(cp.getLastThreeDays3().isDisplayed());
		    	  test.log(Status.INFO, "Last Three Days 3st block is vesible");
		    	  Assert.assertTrue(cp.getPreviousWeek().isDisplayed());
		    	  test.log(Status.INFO, "Previous Week");
				
			} catch (Exception e) {
				// TODO: handle exception
				test.log(Status.FAIL, "Test case fail");
			}
	    	 
	    	  
	      }
	      @AfterClass
		    public void afterclass()
		    {
		  	  GenericFunction.driver.close(); 
		  	  test.log(Status.INFO, "close the Browser");
		    }
	      

}
