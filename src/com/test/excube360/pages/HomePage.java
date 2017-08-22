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
public class HomePage {
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement usermenu;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement Signout;
	
	@FindBy(how=How.XPATH,using="//div[@id='searchFieldArea']//div//div//input")
	private WebElement search;
	
	@FindBy(xpath="//a[text()='My Content']")
	private WebElement MyContent;
	
	@FindBy(xpath="//a[text()='Reports']")
	private WebElement Reports;
	
	
	
	public WebElement getReports(){
    	return Reports;
    }
	public WebElement getMyContent(){
    	return MyContent;
    }
	public WebElement getSearch(){
    	return search;
    }
    public WebElement getusermenu() {
		return usermenu;
	}
    public WebElement getSignout() {
		return Signout;
	}
	public void logout(){
		usermenu.click();
		Signout.click();
	}
}

