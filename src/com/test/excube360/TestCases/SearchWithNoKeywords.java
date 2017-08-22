/**
 * 
 */
package com.test.excube360.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.LoginPage;

/**
 * @author User
 *
 */
public class SearchWithNoKeywords extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("SearchWithN0Keywords Verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	public void No_Word_Search(){
        LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
		
		lp.getSearch().click();
		lp.getSearch().sendKeys("");
		test.log(Status.INFO, "send nothing");
		WebElement mySelectElement = lp.getsearchlocation();
		Select dropdown1 = new Select(mySelectElement);
		dropdown1.selectByVisibleText("India");
		test.log(Status.INFO, "select india in location");
		lp.getenvironmentscan().click();
		test.log(Status.INFO, "click on environmentscan");
		String ErrorMsg = lp.geterrorMessage().getText();
		test.log(Status.INFO, "get error Message--->"+ErrorMsg);
	}
	@AfterClass
    public void afterclass()
    {
  	  GenericFunction.driver.close();
  	  test.log(Status.INFO, "close the Browser");
    }

}
