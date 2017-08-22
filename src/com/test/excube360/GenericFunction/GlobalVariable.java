/**
 * 
 */
package com.test.excube360.GenericFunction;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author User
 *
 */
public class GlobalVariable {
	private static final String browserType="chrome";
	private static final String excelFilePath="D:\\Test\\Excube360Final\\TestData.xlsx";
	private static final String excube360="http://www.excube360.com/";
	private static final String gmail="https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	
	
	public String getBrowserType(){
		return browserType;
	}
	public String getExcelFilePath(){
		return excelFilePath;
	}
	public String getexcube360(){
		return excube360;
	}
	public String getgmail(){
		return gmail;
	}
	public String getBrowserName(){
		Capabilities cap = ((RemoteWebDriver)GenericFunction.driver).getCapabilities();
		String browser = cap.getBrowserName().toLowerCase();
		return browser;
	}


}
