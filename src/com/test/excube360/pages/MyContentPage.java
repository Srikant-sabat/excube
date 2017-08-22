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
public class MyContentPage {
	
	@FindBy(how=How.XPATH,using="//section[@id='header']/div")
	private WebElement headerText;
	
	@FindBy(how=How.XPATH,using="//*[@id='yourDailyResource']/div[1]/div/h2")
	private WebElement latestUpdate;
	
	@FindBy(how=How.ID,using="0")
	private WebElement presentation;
	
	@FindBy(how=How.XPATH,using="//*[@id='yourDailyResource']/div[1]/div/div/h2")
	private WebElement LastThreeDays;
	
	@FindBy(how=How.XPATH,using="//*[@id='LastThree']/div[1]")
	private WebElement LastThreeDays1;
	
	@FindBy(how=How.XPATH,using="//*[@id='LastThree']/div[2]")
	private WebElement LastThreeDays2;
	
	@FindBy(how=How.XPATH,using="//*[@id='LastThree']/div[3]")
	private WebElement LastThreeDays3;
	
	@FindBy(how=How.XPATH,using="//*[@id='yourDailyResource']/div[2]")
	private WebElement PreviousWeek;
	
	
	public WebElement getheaderText(){
    	return headerText;
    }
	public WebElement getlatestUpdate(){
    	return latestUpdate;
    }
	public WebElement getpresentation(){
    	return presentation;
    }
	public WebElement getLastThreeDays(){
    	return LastThreeDays;
    }
	public WebElement getLastThreeDays1(){
    	return LastThreeDays1;
    }
	public WebElement getLastThreeDays2(){
    	return LastThreeDays2;
    }
	public WebElement getLastThreeDays3(){
    	return LastThreeDays3;
    }
	public WebElement getPreviousWeek(){
    	return PreviousWeek;
    }


}
