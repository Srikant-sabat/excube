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
public class AnalyticPage {
	
	@FindBy(how=How.ID,using="keyword-div")
	private WebElement keyword;
	
	@FindBy(how=How.ID,using="reseultDetailNavbar")
	private WebElement ResultDetails;
	
	@FindBy(how=How.ID,using="ideaDescription-title")
	private WebElement ideaDescription;
	
	@FindBy(how=How.ID,using="recentSearch")
	private WebElement RecentSearch;
	
	@FindBy(how=How.XPATH,using="//div[@id='recentSearchList']/div[1]/div[1]")
	private WebElement RecentSearch1;
	
	@FindBy(how=How.XPATH,using="//div[@id='recentSearchList']/div[2]/div[1]")
	private WebElement RecentSearch2;
	
	@FindBy(how=How.XPATH,using="//div[@id='recentSearchList']/div[3]/div[1]")
	private WebElement RecentSearch3;
	
	@FindBy(how=How.ID,using="seePackage")
	private WebElement SeePackage;
	
	@FindBy(how=How.ID,using="buyDetailReport")
	private WebElement BuyDetailReport;
	
	@FindBy(how=How.ID,using="seeMoreSearch")
	private WebElement SeeMoreSearch;
	
	@FindBy(how=How.ID,using="market-activity")
	private WebElement MarketBuzz;
	
	@FindBy(how=How.ID,using="investor-activity")
	private WebElement InvestorInterest;
	
	@FindBy(how=How.ID,using="entrepreneur-activity")
	private WebElement EntrepreneurInterest;
	
	@FindBy(how=How.ID,using="crowd-activity")
	private WebElement CompetitionIndex;
	
	@FindBy(how=How.XPATH,using="//div[@id='wait']/img")
	private WebElement Wait;
	
	@FindBy(how=How.ID,using="accordion")
	private WebElement Accordion;
	
	
	
	public WebElement getAccordian(){
    	return Accordion;
    }
	public WebElement getkeyword(){
		return keyword;
	}
	public WebElement getResultDetails(){
		return ResultDetails;
	}
	public WebElement getideaDescription(){
		return ideaDescription;
	}
	public WebElement getRecentSearch(){
		return RecentSearch;
	}
	public WebElement getRecentSearch1(){
		return RecentSearch1;
	}
	public WebElement getRecentSearch2(){
		return RecentSearch2;
	}
	public WebElement getRecentSearch3(){
		return RecentSearch3;
	}
	public WebElement getSeePackage(){
		return SeePackage;
	}
	public WebElement getBuyDetailReport(){
		return BuyDetailReport;
	}
	public WebElement getSeeMoreSearch(){
		return SeeMoreSearch;
	}
	public WebElement getMarketBuzz(){
		return MarketBuzz;
	}
	public WebElement getInvestorInterest(){
		return InvestorInterest;
	}
	public WebElement getEntrepreneurInterest(){
		return EntrepreneurInterest;
	}
	public WebElement getCompetitionIndex(){
		return CompetitionIndex;
	}
	public WebElement getWait(){
		return Wait;
	}
	
	//public void 
	
}
