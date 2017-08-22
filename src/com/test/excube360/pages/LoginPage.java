/**
 * 
 */
package com.test.excube360.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.test.excube360.GenericFunction.GenericFunction;

/**
 * @author User
 *
 */
public class LoginPage {
	
	GenericFunction gf= new GenericFunction();
	
	@FindBy(xpath="//a[text()='Create an Account or Log In']")
	private WebElement CreateanAccountorLogIn;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@id='form-username']")
	private WebElement username;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@id='form-password']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='modal-body']//button[@class='btn btn-cyan form-control']")
	private WebElement SignIn;
	
	@FindBy(xpath="//span[@id='signupFormLinkModal']/a[contains(text(),'Sign Up')]")
	private WebElement  signup;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@id='regName']")
	private WebElement RegistrationName;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@id='regMail']")
	private WebElement Registrationmail;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@id='regPass']")
	private WebElement Registrationpassword;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@id='terms']")
	private WebElement checkbox;
	
	@FindBy(xpath="//div[@class='modal-body']//button[text()='Register']")
	private WebElement  Register;
	
	@FindBy(xpath="//img[@id='thankyouImg']/../../preceding-sibling::button")
	private WebElement close;
	
	@FindBy(how=How.XPATH,using="//div[@id='searchFieldArea']//div//div//input")
	private WebElement search;
	
	@FindBy(how=How.ID,using="environmentscan")
	private WebElement environmentscan;
	
	@FindBy(how=How.ID,using="errorMessage")
	private WebElement errorMessage;
	
	@FindBy(how=How.ID,using="searchTextCount")
	private WebElement searchTextCount;
	
	@FindBy(how=How.ID,using="searchlocation")
	private WebElement searchlocation;
	
	@FindBy(how=How.ID,using="accordion")
	private WebElement accordion;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Excube360']")
	private WebElement logo;
	
	@FindBy(how=How.ID,using="search-title")
	private WebElement searchtitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='videoOverlay videoSize']")
	private WebElement Videosection;
	
	@FindBy(how=How.ID,using="detail")
	private WebElement detail;
	
	@FindBy(how=How.ID,using="searchedIdeaCount")
	private WebElement searchedIdeaCount;
	
	@FindBy(how=How.ID,using="package")
	private WebElement packageSection;
	
	@FindBy(how=How.XPATH,using="//*[@id='about_excubator']/div")
	private WebElement Aboutus;
	
	@FindBy(how=How.XPATH,using="html/body/footer")
	private WebElement footer;
	
	@FindBy(how=How.LINK_TEXT,using="Terms of Use")
	private WebElement TermsofUse;
	
	@FindBy(how=How.LINK_TEXT,using="Privacy Policy")
	private WebElement PrivacyPolicy;
	
	@FindBy(how=How.ID,using="forgotFormLinkModal")
	private WebElement ForgotPassword;
	
	@FindBy(how=How.ID,using="forgotid")
	private WebElement ForgotEmail;
	
	@FindBy(how=How.XPATH,using="//form[@id='forgotFormModal']/div[2]/button")
	private WebElement ForgotEmailSubmit;
	
	@FindBy(how=How.XPATH,using="//*[@id='loginformModal']/div[2]/div[5]/a")
	private WebElement LinkedinLogin;
	
	
	
	
	
	public WebElement getLinkedinLogin(){
    	return LinkedinLogin;
    }
	public WebElement getForgotEmailSubmit(){
    	return ForgotEmailSubmit;
    }
	public WebElement getForgotEmail(){
    	return ForgotEmail;
    }
	public WebElement getForgotPassword(){
    	return ForgotPassword;
    }
	public WebElement getPrivacyPolicy(){
    	return PrivacyPolicy;
    }
	public WebElement getTermsofUse(){
    	return TermsofUse;
    }
	public WebElement getfooter(){
    	return footer;
    }
	public WebElement getAboutus(){
    	return Aboutus;
    }
	public WebElement getpackage(){
    	return packageSection;
    }
	public WebElement getsearchedIdeaCount(){
    	return searchedIdeaCount;
    }
	public WebElement getdetail(){
    	return detail;
    }
	public WebElement getVideosection(){
    	return Videosection;
    }
	public WebElement getsearchtitle(){
    	return searchtitle;
    }
	public WebElement getlogo(){
    	return logo;
    }
	public WebElement getaccordion(){
    	return accordion;
    }
	public WebElement getsearchlocation(){
    	return searchlocation;
    }
	public WebElement getsearchTextCount(){
    	return searchTextCount;
    }
	public WebElement geterrorMessage(){
    	return errorMessage;
    }
	public WebElement getenvironmentscan(){
    	return environmentscan;
    }
	public WebElement getSearch(){
    	return search;
    }
	public WebElement getCreateanAccountorLogIn() {
		return CreateanAccountorLogIn;
	}
    public WebElement getusername() {
		return username;
	}
	public WebElement getpassword() {
		return password;
	}
	public WebElement getSignIn() {
		return SignIn;
	}
	public WebElement getsignup() {
		return signup;
	}
	public WebElement getRegistrationmail() {
		return Registrationmail;
	}

	public WebElement getRegistrationName() {
		return RegistrationName;
	}
	public WebElement getRegistrationpassword() {
		return Registrationpassword;
	}
	public WebElement getcheckbox() {
		return checkbox;
	}
	public WebElement getRegister() {
		return Register;
	}
	public WebElement getClose(){
		return close;
	}
	public  void Login() throws EncryptedDocumentException, InvalidFormatException, IOException{
		CreateanAccountorLogIn.click();
		username.sendKeys(gf.getExcldata("login", "Registersheet", "username"));
		password.sendKeys(gf.getExcldata("login","RegisterSheet","Password"));
		SignIn.click();
	}
	

	
	
}
