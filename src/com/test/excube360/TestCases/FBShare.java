/**
 * 
 */
package com.test.excube360.TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.excube360.GenericFunction.GenericFunction;
import com.test.excube360.GenericFunction.GlobalVariable;
import com.test.excube360.GenericFunction.ReportGenerate;
import com.test.excube360.pages.Facebookpage;
import com.test.excube360.pages.HomePage;
import com.test.excube360.pages.LoginPage;



/**
 * @author User
 *
 */
public class FBShare extends ReportGenerate{
	GlobalVariable gv=new GlobalVariable();  //create object for GlobalVariable
    GenericFunction gf=new GenericFunction(); //create object for GenericFunction
    String TestCaseName="";

    @BeforeClass()
    public void beforeclass() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
    	test=extent.createTest("FB Share Verification");
    	gf.getWebdriver();//call to get web driver method in generic function which returns browser reference
    	test.log(Status.INFO, "Browser open");
    	GenericFunction.driver.get(gv.getexcube360());
    	test.log(Status.INFO, "Application Running");
    	GenericFunction.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    
    @BeforeMethod()
    public void beforeMethod(Method method) //to know about all the method instance in a class
    {
     	TestCaseName=method.getName(); //to know current executing test case
    }
    
    @Test
    
    public void FbShairing() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
    	try {
    		Facebookpage fb = PageFactory.initElements(GenericFunction.driver, Facebookpage.class);
            LoginPage lp = PageFactory.initElements(GenericFunction.driver, LoginPage.class);
            HomePage hp = PageFactory.initElements(GenericFunction.driver, HomePage.class);
        	
        	lp.Login();
        	test.log(Status.INFO, "Login sucessfully");
        	
        	int x= Integer.parseInt(fb.getScanCount().getText());
        	//System.out.println("Number of scans remianing :"+x);
        	fb.getInviteYourFriend().click();
        	test.log(Status.INFO, "click on InviteYourFriend ");
        	
        	//try {
        		GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  //
        		Set<String> str=GenericFunction.driver.getWindowHandles();						 //
      		    Iterator<String> itr=str.iterator();											 // Window handle code
      		    String pwid=itr.next();															 //
      		    String cwid=itr.next();															 //
      		     
      		    
      		    GenericFunction.driver.switchTo().window(cwid);
      		    GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
      		    fb.getFbId().clear();
      		    fb.getFbId().sendKeys(gf.getExcldata("FBShareing","Registersheet", "email"));
      		    fb.getFbPwd().sendKeys(gf.getExcldata("FBShareing", "Registersheet", "Password"));
      		    fb.getFbLogin().click();
      		    GenericFunction.driver.switchTo().window(pwid);
      		    
      		  int size = GenericFunction.driver.findElements(By.tagName("iframe")).size();
      		  
      		for(int i=0; i<=size; i++){
      		    GenericFunction.driver.switchTo().frame(i);
      		    fb.getPostToFacebook().click();
      			//System.out.println(total);
      		    GenericFunction.driver.switchTo().defaultContent();
      		    
      		  GenericFunction.driver.switchTo().frame(0); //Switching to the frame
      		//System.out.println("********We are switched to the iframe*******");
		} 
    	}
      		catch (Exception e) {
			// TODO: handle exception
      			test.log(Status.FAIL, "Test case fail"+e.getMessage());
		}
    	
    	
 
  		    
  		   
  		
  		
  		/*GenericFunction.driver.switchTo().frame("f36607db98bac08");
  		    System.out.println("pass1-------");
  		    GenericFunction.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
  		    fb.getPostToFacebook().click();
  		    System.out.println("pass2");
  		    GenericFunction.driver.navigate().refresh();
  		    test.log(Status.INFO, "post in Facebook");
	    	int y= Integer.parseInt(fb.getScanCount().getText());
	    	System.out.println("x - "+x+" : y - "+y);
	    	Assert.assertEquals(x+1, y);*/
	    	//test.log(Status.INFO, "	searches count increses");
  		  
	    	//}
    	/*catch(Exception e)
    	{
    		String s3 = fb.getFbModalLabel().getText();
    		if(s3.equals("You have already shared today. Please try tomorrow :)"))
    		{
    			test.log(Status.INFO, "Already shared today");
    			System.out.println("pass");
    			fb.getCancel();
    			test.log(Status.INFO, "click on facebook pop-up cancel button");
    		}
    		Thread.sleep(2000);
        	hp.logout();
        	test.log(Status.INFO, "log out sucessfully");
        }*/
        
    }
    @AfterClass
    public void afterclass()
    {
  	  GenericFunction.driver.close();
  	  test.log(Status.INFO, "Browser close sucessfully");
    }
}
