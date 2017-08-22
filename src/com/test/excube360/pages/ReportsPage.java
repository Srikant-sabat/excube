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
public class ReportsPage {
	@FindBy(how=How.XPATH,using="html/body/div[1]/div[2]")
	private WebElement REPORTSINSPIREDBYYOURSEARCHHISTORY;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div[3]")
	private WebElement FEATUREDREPORTS;
	
	@FindBy(how=How.CLASS_NAME,using="filterby")
	private WebElement Filterby;
	
	@FindBy(how=How.ID,using="submit")
	private WebElement APPLY;
	
	@FindBy(how=How.ID,using="clear")
	private WebElement cancel;
	
	@FindBy(how=How.XPATH,using="//span[text()='Internet Of Things']")
	private WebElement InternetOfThings;
	
	@FindBy(how=How.XPATH,using="//span[text()='AR/VR']")
	private WebElement ARVR;
	
	@FindBy(how=How.XPATH,using="//span[text()='Parenting']")
	private WebElement Parenting;
	
	
	public WebElement getREPORTSINSPIREDBYYOURSEARCHHISTORY(){
    	return REPORTSINSPIREDBYYOURSEARCHHISTORY;
    }
	public WebElement getFEATUREDREPORTS(){
    	return FEATUREDREPORTS;
    }
	public WebElement getFilterby(){
    	return Filterby;
    }
	public WebElement getAPPLY(){
    	return APPLY;
    }
	public WebElement getcancel(){
    	return cancel;
    }
	public WebElement getInternetOfThings(){
    	return InternetOfThings;
    }
	public WebElement getARVR(){
    	return ARVR;
    }
	public WebElement getParenting(){
    	return Parenting;
    }
	

}
