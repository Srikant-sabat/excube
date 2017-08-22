/**
 * 
 */
package com.test.excube360.TestCases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.GmailPage;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
public class ForgotPassword extends ReportGenerate {
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();

	      @BeforeClass()
	       public void beforeclass()
	        {
	    	    test=extent.createTest("Forget Password");
		        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
		        test.log(Status.INFO, "browser open");
		        GenericFunction.driver.get(gv.getexcube360());  //get the browser
		        Assert.assertEquals(GenericFunction.driver.getTitle().toLowerCase(), "excube360");
		        test.log(Status.INFO, "Application running");
		        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        }
	      @Test
	      public void ForgetPassword(){
	    	  try {
	    		  LoginPage lp = PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		    	  GmailPage gp = PageFactory.initElements(GenericFunction.driver, GmailPage.class);
		    	  
		    	  lp.getCreateanAccountorLogIn().click();
		    	  lp.getForgotPassword().click();
		    	  lp.getForgotEmail().sendKeys("rakeshpani93@gmail.com");
		    	  lp.getForgotEmailSubmit().click();
		    	  
		    	  
		    	  GenericFunction.driver.get(gv.getgmail());
		    	  gp.getusername().sendKeys("rakeshpani93@gmail.com");
	        	  gp.getnext().click();
	        	  gp.getgmailpwd().sendKeys("9040696811");
	        	  gp.getSignIn().click();
	        	  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        	  
	        	  try {
	        		  gp.getmailverify().click();
	        		  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
	        	  
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	 
        	  
	      }
	      @AfterClass
		    public void afterclass()
		    {
		  	  GenericFunction.driver.close();
		  	  test.log(Status.INFO, "Browser close sucessfully");
		    }

}
