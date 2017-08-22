/**
 * 
 */
package com.test.excube360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author User
 *
 */
public class SearchPageLogin {
	@FindBy(how=How.ID,using="accordion")
	private WebElement Accordion;
	
	@FindBy(how=How.ID,using="environmentscan")
	private WebElement Environmentscan;
	
	@FindBy(how=How.ID,using="market-activity")
	private WebElement Activity1;
	
	@FindBy(how=How.ID,using="investor-activity")
	private WebElement Activity2;
	
	@FindBy(how=How.ID,using="entrepreneur-activity")
	private WebElement Activity3;
	
	@FindBy(how=How.ID,using="crowd-activity")
	private WebElement Activity4;
	
	@FindBy(how=How.ID,using="detail-span")
	private WebElement Detail;
	
	@FindBy(how=How.XPATH,using="//a[text()='Signup']")
	private WebElement Signup;
	
	@FindBy(how=How.XPATH,using="//a[text()='Login']")
	private WebElement Login;
	
	@FindBy(how=How.XPATH,using="//form[@id='registrationForm']//input[@id='regName']")
	private WebElement RegistrationName;
	
	@FindBy(how=How.XPATH,using="//form[@id='registrationForm']//input[@id='regMail']")
	private WebElement Registrationmail;
	
	@FindBy(how=How.XPATH,using="//form[@id='registrationForm']//input[@id='regPass']")
	private WebElement Registrationpassword;
	
	@FindBy(how=How.XPATH,using="//form[@id='registrationForm']//input[@id='terms']")
	private WebElement checkbox;
	
	@FindBy(how=How.XPATH,using="//form[@id='registrationForm']//button[text()='Register']")
	private WebElement Register;
	
	@FindBy(how=How.XPATH,using="//form[@id='loginform']//input[@id='form-username']")
	private WebElement username;
	
	@FindBy(how=How.XPATH,using="//form[@id='loginform']//input[@id='form-password']")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//form[@id='loginform']/div[4]/button")
	private WebElement Shinin;
	
	
	
	public WebElement getpassword(){
		return password;
	}
	public WebElement getusername(){
		return username;
	}
	public WebElement getShinin(){
		return Shinin;
	}
	public WebElement getRegister(){
		return Register;
	}
	public WebElement getcheckbox(){
		return checkbox;
	}
	public WebElement getRegistrationmail(){
		return Registrationmail;
	}
	public WebElement getRegistrationpassword(){
		return Registrationpassword;
	}
	public WebElement getSignup(){
		return Signup;
	}
	public WebElement getLogin(){
		return Login;
	}
	public WebElement getRegistrationName(){
		return RegistrationName;
	}
	public WebElement getActivity1(){
		return Activity1;
	}
	public WebElement getActivity2(){
		return Activity2;
	}
	public WebElement getActivity3(){
		return Activity3;
	}
	public WebElement getActivity4(){
		return Activity4;
	}
	public WebElement getDetail(){
		return Detail;
	}
    public WebElement getEnvironmentScan(){
    	return Environmentscan;
    }
	public WebElement getAccordian(){
    	return Accordion;
    }

}
