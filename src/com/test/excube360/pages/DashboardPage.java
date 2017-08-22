/**
 * 
 */
package com.test.excube360.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.excube360.GenericFunction.GenericFunction;


/**
 * @author User
 *
 */
public class DashboardPage {
	
	GenericFunction gf=new GenericFunction();
	
	@FindBy(how=How.XPATH,using="//a[text()='My Dashboard']")
	private WebElement Dashboard;
	
	@FindBy(how=How.XPATH,using="//a[text()='Got a coupon code?']")
	private WebElement GotaCouponCode;
	
	@FindBy(how=How.ID,using="buyButton")
	private WebElement BuyDetailsReport;
	
	@FindBy(how=How.XPATH,using="//u[text()='here']")
	private WebElement SeeSampleReport;
	
	@FindBy(how=How.XPATH,using="//div[@id='testimonial_div']//preceding-sibling::button[@class='close']")
	private WebElement close;
	
	@FindBy(how=How.ID,using="couponCode")
	private WebElement CouponCoad;
	
	@FindBy(how=How.ID,using="applyCoupon")
	private WebElement ApplyCoupon;
	
	@FindBy(how=How.ID,using="couponMessage")
	private WebElement CouponMessage;
	
	@FindBy(how=How.XPATH,using="//li[@class='last']")
	private WebElement LastNo;
	
	@FindBy(how=How.XPATH,using="//*[@id='searchPanination']/ul/li[8]/a")
	private WebElement Next;
	
	@FindBy(how=How.XPATH,using="//div[@id='recentSearchList']/div[1]/div[2]/span/button[1]")
	private WebElement ViewResult;
	

	public WebElement getDashboard(){
		return Dashboard;
	}
	public WebElement getGotaCouponCode(){
		return GotaCouponCode;
	}
	public WebElement getBuyDetailsReport(){
		return BuyDetailsReport;
	}
	public WebElement getSeeSampleReport(){
		return SeeSampleReport;
	}
	public WebElement getclose(){
		return close;
	}
	public WebElement getcouponCode(){
		return CouponCoad;
	}
	public WebElement getApplyCoupon(){
		return ApplyCoupon;
	}
	public WebElement getCouponMessage(){
		return CouponMessage;
	}
	public WebElement getLastNo(){
		return LastNo;
	}
	public WebElement getViewResult(){
		return ViewResult;
	}
	public void ValiedCoupon() throws InterruptedException{ 					//code for velied coupon
		
		LastNo.getAttribute("data-lp");
		//System.out.println(LastNo.getAttribute("data-lp"));
		double d = Double.parseDouble(LastNo.getAttribute("data-lp"));
    	int size = (int) d;
    	//System.out.println(size);
    	int page_value = 0;
    	
    	outer:	for (int i = 1; i < size; i++){
    		
    		int k=10;
        	for (int j = 1; j <= k; j++){
        		try {
        			WebElement w2 =GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//button[text()='Buy report']"));
        			if(w2.getText().equals("BUY REPORT")){
        				
        				GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]")).sendKeys(Keys.ENTER);
            			JavascriptExecutor jse = (JavascriptExecutor) GenericFunction.driver;
            			jse.executeScript("window.scrollBy(0,500)", "");
            			Thread.sleep(2000);
            			
            			GotaCouponCode.click();
            			CouponCoad.sendKeys(gf.getExcldata("CoupanCheck", "RegisterSheet", "validcoupon"));
            			ApplyCoupon.click();
            			Thread.sleep(3000);
            			
            			//System.out.println(CouponMessage.getText());
            			Assert.assertEquals("Coupon applied successfully.", CouponMessage.getText());
            			//System.out.println("pass");
            			break outer;
        			}
					
				} catch (Exception e) {
					System.out.println("There is no link");
					// TODO: handle exception
				}
        	}
        	Thread.sleep(2000);
        	page_value++;
        	if (i%5 == 0 ) {
        		Thread.sleep(2000);
        		Next.click();
        		page_value=0;
				
			}
        	Thread.sleep(2000);
    	    GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li["+(3+page_value)+"]/a")).click();
    	}
	}
	public void InValiedCoupon() throws InterruptedException{                 //code for Invalid coupon
		LastNo.getAttribute("data-lp");
		//System.out.println(LastNo.getAttribute("data-lp"));
		double d = Double.parseDouble(LastNo.getAttribute("data-lp"));
    	int size = (int) d;
    	//System.out.println(size);
    	int page_value = 0;
    	
    	outer:	for (int i = 1; i < size; i++){
    		
    		int k=10;
        	for (int j = 1; j <= k; j++){
        		try {
        			WebElement w2 =GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]"));
        			if(w2.getText().equals("BUY REPORT")){
        				
        				GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]")).sendKeys(Keys.ENTER);
            			JavascriptExecutor jse = (JavascriptExecutor) GenericFunction.driver;
            			jse.executeScript("window.scrollBy(0,500)", "");
            			Thread.sleep(2000);
            			
            			GotaCouponCode.click();
            			CouponCoad.sendKeys(gf.getExcldata("CoupanCheck", "RegisterSheet", "invalidcoupon"));
            			ApplyCoupon.click();
            			Thread.sleep(3000);
            			
            			//System.out.println(CouponMessage.getText());
            			Assert.assertEquals("Invalid Coupon", CouponMessage.getText());
            			//System.out.println("pass");
            			break outer;
        			}
					
				} catch (Exception e) {
					System.out.println("There is no link");
					// TODO: handle exception
				}
        	}
        	Thread.sleep(2000);
        	page_value++;
        	if (i%5 == 0 ) {
        		Thread.sleep(2000);
        		Next.click();
        		page_value=0;
				
			}
        	Thread.sleep(2000);
    	    GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li["+(3+page_value)+"]/a")).click();
    	}
		
	}
	public void UsedCoupan() throws InterruptedException{         //code for used coupon
		LastNo.getAttribute("data-lp");
		//System.out.println(LastNo.getAttribute("data-lp"));
		double d = Double.parseDouble(LastNo.getAttribute("data-lp"));
    	int size = (int) d;
    	//System.out.println(size);
    	int page_value = 0;
    	
    	outer:	for (int i = 1; i < size; i++){
    		
    		int k=10;
        	for (int j = 1; j <= k; j++){
        		try {
        			WebElement w2 =GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]"));
        			if(w2.getText().equals("BUY REPORT")){
        				
        				GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]")).sendKeys(Keys.ENTER);
            			JavascriptExecutor jse = (JavascriptExecutor) GenericFunction.driver;
            			jse.executeScript("window.scrollBy(0,500)", "");
            			Thread.sleep(2000);
            			
            			GotaCouponCode.click();
            			CouponCoad.sendKeys(gf.getExcldata("CoupanCheck", "RegisterSheet", "usedcoupon"));
            			ApplyCoupon.click();
            			Thread.sleep(3000);
            			
            			//System.out.println(CouponMessage.getText());
            			Assert.assertEquals("Coupon already used.", CouponMessage.getText());
            			//System.out.println("pass");
            			break outer;
        			}
					
				} catch (Exception e) {
					System.out.println("There is no link");
					// TODO: handle exception
				}
        	}
        	Thread.sleep(2000);
        	page_value++;
        	if (i%5 == 0 ) {
        		Thread.sleep(2000);
        		Next.click();
        		page_value=0;
				
			}
        	Thread.sleep(2000);
    	    GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li["+(3+page_value)+"]/a")).click();
    	}
		
	}
	
	
	
	public void BuyReort() throws InterruptedException{							//BuyReport 
		double d = Double.parseDouble(LastNo.getAttribute("data-lp"));
    	int size = (int) d;
    	//System.out.println(size);
    	int page_value = 0;
outer:	for (int i = 1; i < size; i++){
    		
    		int k=10;
        	for (int j = 1; j <= k; j++){
        		try {
        			WebElement w2 =GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]"));
        			if(w2.getText().equals("BUY REPORT")){
        				
        				GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]")).sendKeys(Keys.ENTER);
            			JavascriptExecutor jse = (JavascriptExecutor) GenericFunction.driver;
            			jse.executeScript("window.scrollBy(0,500)", "");
            			Thread.sleep(2000);
            			
            			BuyDetailsReport.click();
            			GenericFunction.driver.switchTo().frame("icpFrame");
            			CitrusPayPage cp = PageFactory.initElements(GenericFunction.driver, CitrusPayPage.class);
            			cp.getMobileNum().sendKeys("9480623276");
            			cp.getEmailId().sendKeys(gf.getExcldata("downloadreport", "Registersheet", "paymail"));
            			//System.out.println("pass");
            			cp.getContinueToPay().click();
            			//System.out.println("pass-----");
            			Thread.sleep(4000);
            			cp.getCardNumber().sendKeys("");
            			cp.getCardExp().sendKeys("");
            			cp.getCVV().sendKeys("");
            			cp.getNameOnCard().sendKeys("");
            			
            			break outer;
        			}
					
				} catch (Exception e) {
					//System.out.println(e.getMessage());
					//System.out.println("There is no link");
					
					// TODO: handle exception
				}
        	}
        	Thread.sleep(2000);
        	page_value++;
        	if (i%5 == 0 ) {
        		Thread.sleep(2000);
        		Next.click();
        		page_value=0;
				
			}
        	Thread.sleep(2000);
    	    GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li["+(3+page_value)+"]/a")).click();
    	}
		
		
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName)                              //check file is existing or not
    {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
    	//System.out.println(dir_contents.length);
	    for (int i = 0; i < dir_contents.length; i++) 
	    	{
	        	if (dir_contents[i].getName().equals(fileName))
	        	{
	               return flag=true;
	        	}
	    	}

	    return flag;
	}
	
	public void DownloadReport() throws InterruptedException{
		WebElement w1=LastNo;
        //System.out.println(w1.getAttribute("data-lp"));
    	
    	double d = Double.parseDouble(w1.getAttribute("data-lp"));
    	int size = (int) d;
    	//System.out.println(size);
    	int page_value = 0;
    	
    	outer:	for (int i = 1; i < size; i++) {
    		int k=10;
        	for (int j = 1; j <= k; j++) {
        		try {
        			WebElement w2 =GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]"));
            		//System.out.println(w2);
            		//System.out.println(w2.getText());
            		//System.out.println("pass");
       			         if(w2.getText().equals("DOWNLOAD REPORT")){
       			        	 //System.out.println("pass----");
       			        	WebElement w3 =	GenericFunction.driver.findElement(By.xpath(".//*[@id='recentSearchList']/div["+j+"]/div[1]/div[2]"));
       						
       			      		String file_name = w3.getText().replaceAll(" ", "_");                                           //file name convert to download file name       
       			      		file_name = file_name+".pdf";
       			      		//System.out.println(file_name);
       			      		//System.out.println("passsss");
       			      		
       			      		   if(isFileDownloaded("D:\\Test\\Excube360Final\\Download", file_name)){
       			      			File file = new File("D:\\Test\\Excube360Final\\Download\\"+file_name);
       		      			   file.delete();
       		      			   //System.out.println(file.getName());
       		      			   //System.out.println("File Deleted");
       		      			   //System.out.println("pasxxxxx");
       			      		   }
       		      			GenericFunction.driver.findElement(By.xpath("//div[@id='recentSearchList']//div["+j+"]//div[2]//span//button[2]")).sendKeys(Keys.ENTER);
       		 	 	    Thread.sleep(10000);
       		 	 		
       		 	 	    Assert.assertTrue(isFileDownloaded("D:\\Test\\Excube360Final\\Download", file_name), "Failed to download Expected document");      //check file download in folder
       		 	 		Thread.sleep(4000);
       		 	 			       break outer;
       		      			   
       			      			   
       			      		   
       			         }
					
				} catch (Exception e) {
					//System.out.println("there is no link");
					// TODO: handle exception
				}
        	}
            Thread.sleep(2000);
    		
    	    WebElement s1=	GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li["+(3+page_value)+"]/a"));
    	    //System.out.println(s1.getText());
    	    page_value++;
    	    
    	          if(i%5 == 0 )
    	            {
    		          Thread.sleep(2000);
    		          GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li[8]/a")).click();
    		          page_value=0;
    	            }
    	
    	    Thread.sleep(2000);
    	    GenericFunction.driver.findElement(By.xpath("//*[@id='searchPanination']/ul/li["+(3+page_value)+"]/a")).click();
        	
    	}
		
	}

}
