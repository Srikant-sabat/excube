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
public class Facebookpage {
	
	@FindBy(how=How.XPATH,using="//a[text()='invite your friends']")
	private WebElement InviteYourFriend;
	
	@FindBy(how=How.ID,using="email")
	private WebElement FbId;
	
	@FindBy(how=How.ID,using="pass")
	private WebElement FbPwd;
	
	@FindBy(how=How.XPATH,using="//label[@id='loginbutton']")
	private WebElement FbLogin;
	
	@FindBy(how=How.XPATH,using="//span[text()='Post to Facebook']")
	private WebElement PostToFacebook;
	
	@FindBy(how=How.ID,using="scancount")
	private WebElement ScanCount;
	
	@FindBy(how=How.XPATH,using="//h4[@id='inviteModalLabel']")
	private WebElement FbModalLabel;
	
	@FindBy(how=How.XPATH,using="//h4[@id='inviteModalLabel']/..//preceding-sibling::button")
	private WebElement Cancel;
	
	public WebElement getInviteYourFriend(){
		return InviteYourFriend;
	}
	public WebElement getFbId(){
		return FbId;
	}
	public WebElement getFbPwd(){
		return FbPwd;
	}
	public WebElement getFbLogin(){
		return FbLogin;
	}
	public WebElement getPostToFacebook(){
		return PostToFacebook;
	}
	public WebElement getScanCount(){
		return ScanCount;
	}
	public WebElement getFbModalLabel(){
		return FbModalLabel;
	}
	public WebElement getCancel(){
		return Cancel;
	}

}
