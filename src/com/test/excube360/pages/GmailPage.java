/**
 * 
 */
package com.test.excube360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author User
 *
 */
public class GmailPage {
	@FindBy(xpath="//input[@id='identifierId']")
	private WebElement username;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement gmailpwd;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement SignIn;
	
	@FindBy(xpath="//div/span/strong/a")
	private WebElement verifylink;
	
	@FindBy(xpath="(//td[div[span[text()='excube360']]]/div[@class='yW']/span)[1]")
	private WebElement  mailverify;
	
	@FindBy(xpath="//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']/span")
	private WebElement gmailLogout;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement  signout;
	

	public WebElement getusername() {
		return username;
	}

	public WebElement getnext() {
		return next;
	}
	public WebElement getgmailpwd() {
		return gmailpwd;
	}
	public WebElement getSignIn() {
		return SignIn;
	}
	public WebElement getverifylink() {
		return verifylink;
	}
	public WebElement getmailverify() {
		return mailverify;
	}
	public WebElement getgmailLogout() {
		return gmailLogout;
	}
	public WebElement getsignout() {
		return signout;
	}
	

}
