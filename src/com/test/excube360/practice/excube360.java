package com.test.excube360.practice;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;

public class excube360 {

	GenericFunction gf=new GenericFunction();
	GlobalVariable gv=new GlobalVariable();
	
	public static  String browsername(){
		Capabilities cap = ((RemoteWebDriver)GenericFunction.driver).getCapabilities();
		String bname = cap.getBrowserName().toLowerCase();
		//System.out.println(bname);
		return bname;
	}

    
    @Test
    public void openBrowser() throws Exception {
  	  GenericFunction.driver = new FirefoxDriver();
  	  GenericFunction.driver.manage().window().maximize();
  	  GenericFunction.driver.get("http://www.google.com");
  	/*TakesScreenshot ts=(TakesScreenshot)driver;
	File fis = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(fis, new File("./ScreenShots/jkk).png"));*/
  	  gf.CaptureScreenShot("DSA", "sdsda");
    }
	      

}
