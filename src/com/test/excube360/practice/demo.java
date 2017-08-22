package com.test.excube360.practice;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;

public class demo extends commonclass {
	@BeforeClass()
    public void beforeclass()
     {
		test=extent.createTest("BuyReport");
	        gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
	        test.log(Status.INFO, "browser open");
	        GenericFunction.driver.get(gv.getexcube360());  //get the browser
	        test.log(Status.INFO, "application open");
	       // Assert.assertEquals(GenericFunction.driver.getTitle(),"excube360");
	        GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
	@Test
	public void jeeban(){
		
		test.log(Status.INFO, "browser open");
		test.log(Status.INFO, "browser aaaaaaaaaaaaaaaaaclose");
		test.log(Status.PASS,"");
		
	}
	@Test
	public void rakesh(){
		test=extent.createTest("rakesh");
		test.log(Status.INFO, "browser close");
		System.out.println("rakesh");
		test.log(Status.INFO, "browser dsvbfzvzd close");
	}


}
