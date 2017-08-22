package com.test.excube360.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.excube360.GenericFunction.GenericFunction;

public class test2 extends commonclass{
	@Test
	public void test(){
		test=extent.createTest("test");
		Assert.assertTrue(1>0);
	}
	@Test
	public void test1(){
		test=extent.createTest("test1");
		Assert.assertEquals("jeeban", "jeeban");
	}
	@Test
	public void test3(){
		test=extent.createTest("test3");
		gf.getWebdriver();
		GenericFunction.driver.get(gv.getexcube360());
		Assert.assertEquals(GenericFunction.driver.getTitle(), "excube360");
	}

}
