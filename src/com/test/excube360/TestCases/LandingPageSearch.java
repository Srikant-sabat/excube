/**
 * 
 */
package com.test.excube360.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.DashboardPage;
import com.test.excube360.pages.LoginPage;
import com.test.excube360.pages.SearchPageLogin;

/**
 * @author User
 *
 */
public class LandingPageSearch extends ReportGenerate {
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		 test=extent.createTest("LandingPageSearch Verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	public void LandingPageSearchTest() throws InterruptedException{
		try {
			WebDriverWait wait = new WebDriverWait(GenericFunction.driver, 50);
			LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
			SearchPageLogin spl = PageFactory.initElements(GenericFunction.driver, SearchPageLogin.class);
			
			lp.getSearch().click();
			test.log(Status.INFO, "Locating environment scan search");
			lp.getSearch().sendKeys("");
			test.log(Status.INFO, "Sending blank keyword and click on excube it");
			lp.getenvironmentscan().click();
			String msg = lp.geterrorMessage().getText();
			//System.out.println("Error Message for without entering keywords-" + msg);
			test.log(Status.INFO, "Capturing the error message");
			
			if (lp.getsearchTextCount().isDisplayed()) {
				test.log(Status.INFO, "Checking for any error message present");
				//System.out.println("Remaining keywords should not be displayed");
			}
			if (lp.getenvironmentscan().isEnabled()) {
				test.log(Status.INFO, "Checking for excube it button is disabled");
				//System.out.println("Button should be disabled");
			}
			lp.getSearch().sendKeys("iot ");
			lp.getSearch().sendKeys("medical ");
			WebElement mySelectElement = lp.getsearchlocation();
			Select dropdown1 = new Select(mySelectElement);
			dropdown1.selectByVisibleText("India");
			lp.getenvironmentscan().click();
			String wordcount2 = lp.getsearchTextCount().getText();
			//System.out.println("Remaining keywords :" + wordcount2);
			test.log(Status.INFO, "Select india");
			
			if (lp.geterrorMessage().isDisplayed()) {
				//System.out.println("Error Message should not be displayed");
				test.log(Status.INFO, "Error Message should not be displayed");
			}
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='accordion']")));
			// SearchResult();
			//Thread.sleep(5000);
			
			if (lp.getaccordion().isDisplayed()) {
				spl.getActivity1().getText();
				spl.getActivity2().getText();
				spl.getActivity3().getText();
				spl.getActivity4().getText();
			}
			if (spl.getSignup().isDisplayed()) {
				//System.out.println("Sign Up link enabled");
				test.log(Status.INFO, "Sign up link is enabled");
			}
			if (spl.getLogin().isDisplayed()) {
				//System.out.println("Login link enabled");
				test.log(Status.INFO, "Login link is enabled");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Test case Fail");
		}
		
		
	}
	 @AfterClass
	    public void afterclass()
	    {
	  	  GenericFunction.driver.close();
	  	  test.log(Status.INFO, "close the Browser");
	    }
	

}
