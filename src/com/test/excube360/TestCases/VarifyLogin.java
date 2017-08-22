/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
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
import com.test.excube360.pages.HomePage;
import com.test.excube360.pages.LoginPage;


/**
 * @author User
 *
 */

public class VarifyLogin extends ReportGenerate {
GenericFunction gf=new GenericFunction();
GlobalVariable gv=new GlobalVariable();
String TestCaseName="";

      @BeforeMethod()
    //to know about all the method instance in a class
      public void beforeMethod(Method method) 
       {
    	  //to know current executing test case
 	       TestCaseName=method.getName();
       }

      @BeforeClass()
       public void beforeclass()
        {
    	    test=extent.createTest("varifay login");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        Assert.assertEquals(GenericFunction.driver.getTitle().toLowerCase(), "excube360");
	        test.log(Status.INFO, "Application running");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

      @Test(priority=1)
       public void newRegisterTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
        {
    	  try {
    		  test.log(Status.INFO, "newRegisterTest--------------");
        	  LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
        	  GmailPage gp=PageFactory.initElements(GenericFunction.driver, GmailPage.class);
        	  
        	  //new user registration
        	  lp.getCreateanAccountorLogIn().isDisplayed();
        	  Assert.assertEquals(lp.getCreateanAccountorLogIn().getText(), "Create an Account or Log In");
        	  lp.getCreateanAccountorLogIn().click();
        	  test.log(Status.INFO, "click on log in button");
        	  
        	  lp.getsignup().isDisplayed();
        	  Assert.assertEquals(lp.getsignup().getText().trim(), "Sign Up");
        	  lp.getsignup().click();
        	  test.log(Status.INFO,"click on signup button to register");
        	  Assert.assertTrue(lp.getRegistrationName().isDisplayed()); 
        	  lp.getRegistrationName().sendKeys(gf.getExcldata(TestCaseName, "Registersheet", "username"));
        	  Assert.assertTrue(lp.getRegistrationmail().isDisplayed());
        	  lp.getRegistrationmail().sendKeys(gf.getExcldata(TestCaseName, "Registersheet", "email"));
        	  Assert.assertTrue(lp.getRegistrationpassword().isDisplayed());
        	  lp.getRegistrationpassword().sendKeys(gf.getExcldata(TestCaseName, "Registersheet", "Password"));
        	  lp.getcheckbox().click();
        	  Assert.assertTrue(lp.getcheckbox().isSelected());
        	  Assert.assertTrue(lp.getRegister().isDisplayed());
        	  lp.getRegister().click();
        	  test.log(Status.INFO, "put value and click on register");
    	 
        	  GenericFunction.driver.get(gv.getgmail());
        	  Assert.assertEquals(GenericFunction.driver.getTitle(), "Gmail");
        	  test.log(Status.INFO, "Gmail open");
    	      GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        	  gp.getusername().sendKeys(gf.getExcldata(TestCaseName, "RegisterSheet", "email"));
        	  gp.getnext().click();
        	  Thread.sleep(2000);
        	  gp.getgmailpwd().sendKeys(gf.getExcldata(TestCaseName, "RegisterSheet", "gmailpass"));
        	  gp.getSignIn().click();
        	  test.log(Status.INFO, "Gmail login sucessfully");
    	 
        	  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	 
    	 try {
    		 gp.getmailverify().click();
    		 test.log(Status.INFO, "click on mail varifay link");
    		 
    		 GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    		 
    		 gp.getverifylink().click();
    		 test.log(Status.INFO, "click on varifay link");
    		 
    		 GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    		 
    		 //code for verification the mail
    		 
    		 Set<String> str=GenericFunction.driver.getWindowHandles();
    		  Iterator<String> itr=str.iterator();
    		  String pwid=itr.next();
    		  String cwid=itr.next();
    		  GenericFunction.driver.switchTo().window(cwid);
    		  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    		  GenericFunction.driver.close();
    		  GenericFunction.driver.switchTo().window(pwid);
    		  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    		 
    			} 
    	 
    	 	catch (Exception e) {
    		// TODO: handle exception
    	 		test.log(Status.INFO, "Email already exist");
    	 		}
    	 
    	 	 gp.getgmailLogout().click();
    	 	 gp.getsignout().click();
    	 	 test.log(Status.INFO, "gmail logout sucessfully");
    	 	 Thread.sleep(2000);
    	 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
        }


      	@Test(priority=2)
      		public void login() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
      		try {
      			test.log(Status.INFO, "varifay login and logout");
          		LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
          		HomePage hp=PageFactory.initElements(GenericFunction.driver, HomePage.class);
             
          		GenericFunction.driver.get(gv.getexcube360());
          		test.log(Status.INFO, "application running");
          		lp.getCreateanAccountorLogIn().click();
          		test.log(Status.INFO, "click on CreateanAccountorLogIn");
          		lp.getusername().sendKeys(gf.getExcldata(TestCaseName,"RegisterSheet", "username"));
          		lp.getpassword().sendKeys(gf.getExcldata(TestCaseName,"RegisterSheet","Password"));
          		lp.getSignIn().click();
          		test.log(Status.INFO, "login sucessfully");
             	Thread.sleep(2000);
             
             	hp.getusermenu().click();
             	test.log(Status.INFO, "click on logout");
             	hp.getSignout().click();
             	test.log(Status.INFO, "logout sucessfully");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
      		
         	
 	}

      	@AfterClass
      	   public void afterclass()
      	{
      		GenericFunction.driver.close();
	  //System.out.println("after-class");
      	}

}
