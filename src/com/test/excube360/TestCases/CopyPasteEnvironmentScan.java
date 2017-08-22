/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class CopyPasteEnvironmentScan extends ReportGenerate {
	
	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	@BeforeClass()
    public void beforeclass()
     {
 	    test=extent.createTest("CopyPasteEnvironmentScan Verification");
	        gf.getWebdriver();                                                  //call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());                     //get the browser
	        test.log(Status.INFO, "application open");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	
	@Test
	public void CopyPaste() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		try {
			DashboardPage dp= PageFactory.initElements(GenericFunction.driver, DashboardPage.class);
			HomePage hp = PageFactory.initElements(GenericFunction.driver, HomePage.class);
			
			WebElement environmentScan = hp.getSearch();
			Actions a = new Actions(GenericFunction.driver);
			a.sendKeys(environmentScan, Keys.chord(Keys.CONTROL, "a")).perform();
			Thread.sleep(2000);
			environmentScan.clear();
			test.log(Status.INFO, "clar scan field");
			Thread.sleep(2000);
			a.sendKeys(environmentScan, Keys.chord(Keys.CONTROL, "v")).perform();
			Thread.sleep(3000);
			test.log(Status.INFO, "paste the word");
			String errorMsg = GenericFunction.driver.findElement(By.xpath("//*[@id='errorMessage']")).getText();

			if (errorMsg.equalsIgnoreCase("Please enter atleast 2 words and at max 6 words")) {
				//System.out.println("Paste Failed");
				File scrFile = ((TakesScreenshot) GenericFunction.driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(scrFile, new File("D:\\Test\\Excube360Final\\ScreenShots\\CopyPasteLandingPage.jpg"));
				} catch (IOException e) {

					e.printStackTrace();
				}

			} else {
				//System.out.println("Text pasted");
				//System.out.println(GenericFunction.driver.getCurrentUrl());
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "test case fail"+e.getMessage());
			
		}

		
	}
	 @AfterClass
	    public void afterclass()
	    {
	  	  GenericFunction.driver.close(); 
	  	  test.log(Status.INFO, "close the Browser");
	    }
	
		
		
}
	
