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
import com.test.excube360.pages.HomePage;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
/**
 * @author User
 *
 */
public class ApplyCoupon extends ReportGenerate{
	
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();

	      @BeforeClass()
	       public void beforeclass()
	        {
	    	    test=extent.createTest("ApplyCoupon varification");
		        gf.getWebdriver();                                                  //call to get web driver method in generic function which returns browser reference
		        test.log(Status.INFO, "browser open");
		        GenericFunction.driver.get(gv.getexcube360());                     //get the browser
		        test.log(Status.INFO, "application open");
		        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        }
	      
	      @Test
	      public void CoupanCheck() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
	    	  try {
	    		  LoginPage lp= PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		    	  DashboardPage dp= PageFactory.initElements(GenericFunction.driver, DashboardPage.class);
		    	  HomePage hp = PageFactory.initElements(GenericFunction.driver, HomePage.class);
		    	  
		    	  lp.Login();
		    	  test.log(Status.INFO, "login sucessfully");
		    	  dp.getDashboard().click();
		    	  test.log(Status.INFO, "click on dashboard");
		    	  dp.ValiedCoupon();
		    	  test.log(Status.INFO, "Put valied coupan and check");
		    	  dp.getclose().click();
		    	  test.log(Status.INFO, "close the pop-up");
		    	  Thread.sleep(2000);
		    	  hp.logout();
		    	  test.log(Status.INFO, "Log out sucessfully");
		    	  lp.getClose().click();
		    	  test.log(Status.INFO, "close the logout pop-up");
		    	  Thread.sleep(2000);
		    	  lp.Login();
		    	  test.log(Status.INFO, "login sucessfully");
		    	  dp.getDashboard().click();
		    	  test.log(Status.INFO, "click on dashboard");
		    	  dp.InValiedCoupon();
		    	  test.log(Status.INFO, "Put Invalied coupan and check");
		    	  dp.getclose().click();
		    	  test.log(Status.INFO, "close the pop-up");
		    	  Thread.sleep(2000);
		    	  hp.logout();
		    	  test.log(Status.INFO, "Log out sucessfully");
		    	  lp.getClose().click();
		    	  test.log(Status.INFO, "close the logout pop-up");
		    	  Thread.sleep(2000);
		    	  lp.Login();
		    	  test.log(Status.INFO, "login sucessfully");
		    	  dp.getDashboard().click();
		    	  test.log(Status.INFO, "click on dashboard");
		    	  dp.UsedCoupan();
		    	  test.log(Status.INFO, "Put used coupan and check");
		    	  dp.getclose().click();
		    	  test.log(Status.INFO, "close the pop-up");
		    	  Thread.sleep(2000);
		    	  hp.logout();
		    	  test.log(Status.INFO, "Log out sucessfully");
		    	  lp.getClose().click();
		    	  test.log(Status.INFO, "close the logout pop-up");
		    	  
				
			} catch (Exception e) {
				// TODO: handle exception
				test.log(Status.FAIL, "Test case fail-->"+e.getMessage());
			}
	    	 
	    	  
	     }
	      @AfterClass
		    public void afterclass()
		    {
		  	  GenericFunction.driver.close(); 
		  	  test.log(Status.INFO, "close the Browser");
		    }

}
