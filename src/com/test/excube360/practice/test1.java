package com.test.excube360.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;

public class test1  {
	GenericFunction gf = new GenericFunction();
	GlobalVariable gv = new GlobalVariable();
	
	@Test
	public void test(){
		
		/*test=extent.createTest("test1 test------------");
		test.log(Status.INFO, "Application is up and running");
		Assert.assertTrue(1>0);*/
		gf.getWebdriver();
	}
	@Test
	public void test2(){
		/*test=extent.createTest("test2");
		test.log(Status.INFO, "Application is up and running");
		Assert.assertEquals("jeeban", "jeeban");*/
		GenericFunction.driver.get(gv.getexcube360());
	}
	/*@Test
	public void test3(){
		test=extent.createTest("test3");
		
		Assert.assertNotEquals("jeeban", "jeeban");
	}*/


}
