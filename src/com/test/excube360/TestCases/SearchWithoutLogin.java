/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.GmailPage;
import com.test.excube360.pages.LoginPage;
import com.test.excube360.pages.SearchPageLogin;

/**
 * @author User
 *
 */
public class SearchWithoutLogin extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();

	     /* @BeforeClass()
	       public void beforeclass()
	        {
		        gf.getWebdriver();                                                  //call to get web driver method in generic function which returns browser reference
		       
	        }*/
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("SearchWithoutLogin");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	
	      @Test(priority=1)
	      public void Search() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
	    	  try {
	    		  LoginPage lp = PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		    	  SearchPageLogin spl =PageFactory.initElements(GenericFunction.driver, SearchPageLogin.class);
		          GmailPage gp =PageFactory.initElements(GenericFunction.driver, GmailPage.class);
		    	  //System.out.println("pass");
		    	  lp.getSearch().sendKeys(gf.getExcldata("FourKeyword", "Registersheet", "four key"));
		    	  test.log(Status.INFO, "send keywords");
		    	  spl.getEnvironmentScan().click();
		    	  test.log(Status.INFO, "click on EnvironmentScan");
		    	  gf.WebdriverWait("visible", spl.getAccordian());
		    	  test.log(Status.INFO, "Accordian visible");
		    	  //System.out.println(spl.getDetail().getText());
		    	  //System.out.println("MARKET BUZZ-----"+spl.getActivity1().getText());
		    	  //System.out.println("INVESTOR INTEREST-----"+spl.getActivity2().getText());
		    	 // System.out.println("ENTREPRENEUR INTEREST-----"+spl.getActivity3().getText());
		    	  //System.out.println("COMPETITION INDEX-----"+spl.getActivity4().getText());
		    	  
		    	  spl.getSignup().click();;
		    	  spl.getRegistrationName().sendKeys(gf.getExcldata("newRegisterTest", "Registersheet", "username"));
		    	  spl.getRegistrationmail().sendKeys(gf.getExcldata("newRegisterTest", "Registersheet", "email"));
		    	  spl.getRegistrationpassword().sendKeys(gf.getExcldata("newRegisterTest", "Registersheet", "Password"));
		    	  spl.getcheckbox().click();
		    	  spl.getRegister().click();
		    	  GenericFunction.driver.get(gv.getgmail());
		    		 
		    	  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    	  gp.getusername().sendKeys(gf.getExcldata("newRegisterTest", "RegisterSheet", "email"));
		    	  gp.getnext().click();
		    	  Thread.sleep(2000);
		    	  gp.getgmailpwd().sendKeys(gf.getExcldata("newRegisterTest", "RegisterSheet", "gmailpass"));
		    	  gp.getSignIn().click();
			 
		    	  GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			 
			 try {
				 gp.getmailverify().click();
				 
				 GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				 
				 gp.getverifylink().click();
				 
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
			 		}
			 
			 	 gp.getgmailLogout().click();
			 	 gp.getsignout().click();
			 	 Thread.sleep(2000);
			 
				
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
	    	  
	    	  
	        }
	     /* @Test(priority=2)
	      
	      public void SearchLogin() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
	    	  LoginPage lp = PageFactory.initElements(GenericFunction.driver, LoginPage.class);
	    	    SearchPageLogin spl =PageFactory.initElements(GenericFunction.driver, SearchPageLogin.class);
	    		HomePage hp =PageFactory.initElements(GenericFunction.driver, HomePage.class);
	    		
	    	  lp.getSearch().sendKeys(gf.getExcldata("FourKeyword", "Registersheet", "four key"));
	    	  spl.getEnvironmentScan().click();
	    	  gf.WebdriverWait("visible", spl.getLogin());
	    	  System.out.println("pass-------------");
	    	  Thread.sleep(2000);
	    	  spl.getLogin().click();
	    	  spl.getusername().sendKeys(gf.getExcldata("SearchLogin", "Registersheet", "email"));
	    	  spl.getpassword().sendKeys(gf.getExcldata("SearchLogin", "Registersheet", "Password"));
	    	  spl.getShinin().click();
	    	  hp.getusermenu().click();
	    	  hp.getSignout().click();
	    	  
	    	  
	      }*/
	      @AfterMethod
     	   public void afterclass()
     	{
     		GenericFunction.driver.close();
	  //System.out.println("after-class");
     	}

	      

}
