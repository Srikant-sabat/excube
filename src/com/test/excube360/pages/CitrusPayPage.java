package com.test.excube360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CitrusPayPage {
	@FindBy(how=How.ID,using="mob")
	private WebElement MobileNum;
	
	@FindBy(how=How.ID,using="email1")
	private WebElement EmailId;
	 
	@FindBy(how=How.ID,using="register")
	private WebElement ContinueToPay;
	
	@FindBy(how=How.XPATH,using="//a[@alt='Cards']")
	private WebElement Cards;
	
	@FindBy(how=How.XPATH,using="//a[@alt='Banks']")
	private WebElement Banks;
	
	@FindBy(how=How.ID,using="cardNumber")
	private WebElement CardNumber;
	
	@FindBy(how=How.ID,using="cardExp")
	private WebElement CardExp;
	
	@FindBy(how=How.ID,using="cvvNumber")
	private WebElement CVV;
	
	@FindBy(how=How.ID,using="cardHolderName")
	private WebElement NameOnCard;
	
	@FindBy(how=How.ID,using="citrusCardPayButton")
	private WebElement PayNow;
	
	@FindBy(how=How.XPATH,using="//div[@class='saveCardT']//div//label")
	private WebElement SaveCardDetails;
	
	@FindBy(how=How.XPATH,using="//div[@class='container']//preceding-sibling::div[@class='cancel-this']//a//i")
	private WebElement cancel;
	
	public WebElement getMobileNum(){
		return MobileNum;
	}
	public WebElement getEmailId(){
		return EmailId;
	}
	public WebElement getContinueToPay(){
		return ContinueToPay;
	}
	public WebElement getCards(){
		return Cards;
	}
	public WebElement getBanks(){
		return Banks;
	}
	public WebElement getCardNumber(){
		return CardNumber;
	}
	public WebElement getCardExp(){
		return CardExp;
	}
	public WebElement getCVV(){
		return CVV;
	}
	public WebElement getNameOnCard(){
		return NameOnCard;
	}
	public WebElement getPayNow(){
		return PayNow;
	}
	public WebElement getSaveCardDetails(){
		return SaveCardDetails;
	}
	public WebElement getcancel(){
		return cancel;
	}
	
	
}
