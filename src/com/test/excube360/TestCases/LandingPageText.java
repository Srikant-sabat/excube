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
public class LandingPageText extends ReportGenerate{
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("LandingPageText Verification");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application running");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	public void HomePageSearchTest(){
		try {
			LoginPage lp=PageFactory.initElements(GenericFunction.driver, LoginPage.class);
			
			if (lp.getlogo() != null) {
				//System.out.println("Logo Displayed" );
				test.log(Status.INFO, "Logo Displayed");
		    }
			else {
				//System.out.println("Logo not available");
			}
			if (lp.getCreateanAccountorLogIn() != null) {
				//System.out.println("Create an Account or Log In link found");
				test.log(Status.INFO, "Create an Account or Log In link found");
			} else {
				//System.out.println("Create an Account or Log In link is not found");
	        }
			String HeaderTitleText = lp.getsearchtitle().getText();
			if (HeaderTitleText != null) {
				//System.out.println("Search Test -" + HeaderTitleText);
				test.log(Status.INFO, "Header Title Text is displayed");
			} else {
				//System.out.println("Search Text Null -" + HeaderTitleText);
			}
			if (lp.getSearch().isEnabled()) {
				//System.out.println("Environment Search input enabled");
				test.log(Status.INFO, "Environment Search input enabled");
			} else {
				//System.out.println("Environment Search input disabled");
			}
			if (lp.getenvironmentscan().isEnabled()) {
				//System.out.println("Button Enabled");
				test.log(Status.INFO, "Environment scan Button Enabled");
			} else {
				//System.out.println("Button Disabled");
			}
			if (lp.getsearchlocation().isDisplayed()) {
				//System.out.println("Drop down list enabled");
				test.log(Status.INFO, "Drop down list enabled");
			} else {
				//System.out.println("Drop Down list disabled");
			}
			WebElement dropdown =lp.getsearchlocation();
			Select select = new Select(dropdown);
			java.util.List<WebElement> options = select.getOptions();
			for (WebElement item : options) {

				//System.out.println("Dropdown values are " + item.getText());
				test.log(Status.INFO, "Dropdown values are displayed--->"+ item.getText());
			}
			if (lp.getVideosection().isDisplayed()) {
				//System.out.println("Video Section displayed");
				test.log(Status.INFO, "Video Section displayed");
			}
			if (lp.getdetail().isDisplayed()) {
				//System.out.println("Do more with Excube360 displayed");
				test.log(Status.INFO, "Do more with Excube360 displayed");
			}
			String IdeaCount = lp.getsearchedIdeaCount().getText();
			//System.out.println("Idea Searched-" + IdeaCount);
			test.log(Status.INFO, "Idea Searched-" + IdeaCount);
			
			if (lp.getpackage().isDisplayed()) {
				//System.out.println("Package section displayed");
				test.log(Status.INFO, "Package section displayed");
			}
			if (lp.getAboutus().isDisplayed()) {
				//System.out.println("About us Section displayed");
				test.log(Status.INFO, "About us Section displayed");
				String AboutUsText =lp.getAboutus().getText();
				//System.out.println(AboutUsText);
			}
			if (lp.getfooter().isDisplayed()) {
				//System.out.println("Footer Section displayed");
				test.log(Status.INFO, "Footer Section displayed");
				String FooterText = lp.getfooter().getText();
				//System.out.println(FooterText);
			}
			if (lp.getTermsofUse().isDisplayed()) {
				//System.out.println("Terms of Use displayed");
				test.log(Status.INFO, "Terms of Use displayed");
			}
			if (lp.getPrivacyPolicy().isDisplayed()) {
				//System.out.println("Privacy Policy displayed");
				test.log(Status.INFO, "Privacy Policy displayed");
			}
			
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
