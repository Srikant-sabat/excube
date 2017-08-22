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
public class LinkedinPage {
	
	@FindBy(how=How.ID,using="session_key-login")
	private WebElement LinkedInLogin;
	
	@FindBy(how=How.ID,using="session_password-login")
	private WebElement LinkedInPassword;
	
	@FindBy(how=How.XPATH,using="//input[@name='signin']")
	private WebElement LinkedInsignin;
	
	
	
	public WebElement getLinkedInsignin(){
		return LinkedInsignin;
		
	}
	public WebElement getLinkedInPassword(){
		return LinkedInPassword;
		
	}
	public WebElement getLinkedInID(){
		return LinkedInLogin;
		
	}

}
