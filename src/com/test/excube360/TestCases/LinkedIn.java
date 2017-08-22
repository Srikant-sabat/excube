/**
 * 
 */
package com.test.excube360.TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.HomePage;
import com.test.excube360.pages.LinkedinPage;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
public class LinkedIn extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("LinkedIn login  Verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	
	public void LinkedinLogin(){
		try {
			LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
			LinkedinPage ldp = PageFactory.initElements(GenericFunction.driver, LinkedinPage.class);
			HomePage hp =PageFactory.initElements(GenericFunction.driver, HomePage.class);
			
			lp.getCreateanAccountorLogIn().click();
			test.log(Status.INFO, "click on createAccount");
			lp.getLinkedinLogin().click();
			test.log(Status.INFO, "click on linkedinLogin");
			
			GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  //
			Set<String> str=GenericFunction.driver.getWindowHandles();						 //
			    Iterator<String> itr=str.iterator();											 // Window handle code
			    String pwid=itr.next();															 //
			    //String cwid=itr.next();															 //
			     
			    
			   // GenericFunction.driver.switchTo().window(cwid);
			    GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    ldp.getLinkedInID().clear();
			    ldp.getLinkedInID().sendKeys("test.excube360@gmail.com");
			    ldp.getLinkedInPassword().sendKeys("excube063");
			    ldp.getLinkedInsignin().click();
			    test.log(Status.INFO, "linkedin login Sucessfully");
			    GenericFunction.driver.switchTo().window(pwid);
			    GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    hp.logout();
			    test.log(Status.INFO, "log out sucessfully");
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Timeout exception");
			test.log(Status.FAIL, "Slow internet Connection--"+e.getMessage());
		}
		
		    
	}
	 @AfterClass
	    public void afterclass()
	    {
	  	  GenericFunction.driver.close();
	  	  test.log(Status.INFO, "Browser close sucessfully");
	    }

}
