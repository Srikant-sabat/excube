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
public class SearchWithOneKeyword extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("SearchWithOneKeywords Verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	public void One_Word_Search() throws EncryptedDocumentException, InvalidFormatException, IOException{
		try {
			LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
			
			lp.getSearch().click();
			lp.getSearch().sendKeys(gf.getExcldata("OneKeyword", "Registersheet", "one key"));
			test.log(Status.INFO, "send OneKeyword word");
			WebElement mySelectElement = lp.getsearchlocation();
			Select dropdown1 = new Select(mySelectElement);
			dropdown1.selectByVisibleText("India");
			test.log(Status.INFO, "select india in location");
			lp.getenvironmentscan().click();
			test.log(Status.INFO, "click on environmentscan");
			String ErrorMsg = lp.geterrorMessage().getText();
			test.log(Status.INFO, "get error Message");
			//System.out.println("Error Message : " + ErrorMsg);
			String RemainingWords = lp.getsearchTextCount().getText();
			//System.out.println("Remaining keywords : " + RemainingWords);
			test.log(Status.INFO, "Search Text Count--->"+RemainingWords);
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Test case fail"+e.getMessage());
		}
        
	}
	@AfterClass
    public void afterclass()
    {
  	  GenericFunction.driver.close();
  	  test.log(Status.INFO, "close the Browser");
    }


}
