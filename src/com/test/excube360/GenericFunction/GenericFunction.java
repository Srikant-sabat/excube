/**
 * 
 */
package com.test.excube360.GenericFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author User
 *
 */

public class GenericFunction {                        //generic function for browser
	 GlobalVariable gv = new GlobalVariable();
	public static WebDriver driver;
	public WebDriver getWebdriver()     
	{
		 
		if(gv.getBrowserType().toLowerCase().equals("chrome"))  //open chromebrowser and set download path
		 {
			System.setProperty("webdriver.chrome.driver","D:\\Test\\Excube360Final\\chrome\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--start-maximized");
	    	Map<String, Object> prefs = new HashMap<String,Object>();
	    	prefs.put("download.prompt_for downlog", false);
	    	prefs.put("download.default_directory", "D:\\Test\\Excube360Final\\Download");
	    	options.setExperimentalOption("prefs", prefs);
	    	driver = new ChromeDriver( options );
	    	
		 }
		
		else if(gv.getBrowserType().toLowerCase().equals("ie"))   //open iebrowser
			
		 {
			
			System.setProperty("webdriver.ie.driver","C:\\Program Files\\Internet Explorer\\iexplore.exe");
			driver=new InternetExplorerDriver();
			
		 }
		
		else
		 {
			
			FirefoxProfile profile = new FirefoxProfile();        //open firefoxbrowser and set the download path
			profile.setPreference("browser.download.dir", "D:\\Test\\Excube360Final\\Download");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf"); 
		    profile.setPreference( "browser.download.manager.showWhenStarting", false );
		    profile.setPreference( "pdfjs.disabled", true );
			driver=new FirefoxDriver(profile);
		    driver.manage().window().maximize();
		 }
		
		return driver;
	}
	
	public void fileDownload()
	{
		String browserName=driver.getClass().getName();
		System.out.println("kunipua-----------------------");
		System.out.println(browserName);
		
		if(browserName.equals("FirefoxDriver"))
		{
			
		}
			
		
	}
	
	
	
	String FilePath=gv.getExcelFilePath();                     	//generic function for read excel                                   	  
    public String getExcldata(String TestCaseName,String SheetName,String ColoumName) throws IOException, EncryptedDocumentException, InvalidFormatException
                                                                               
     {
	        String returnValue=null;
	        FileInputStream fis =new FileInputStream(FilePath);
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sh = wb.getSheet(SheetName);
	        //System.out.println("last row no"+sh.getLastRowNum()+1);
	        //System.out.println("last cell no"+sh.getRow(0).getLastCellNum()+1);
	
	        int Rowno=+sh.getLastRowNum()+1;
	        int Coloumno=+sh.getRow(0).getLastCellNum()+1;
	
	outer:for (int i = 1; i <=Rowno; i++) 
	 {
		if(TestCaseName.equals(sh.getRow(i).getCell(0).getStringCellValue()))
		  {
			for (int j = 0; j <=Coloumno; j++) 
				
			   {
			      if(ColoumName.equals(sh.getRow(0).getCell(j).getStringCellValue()))
			    	  
			         {
			    	  
			            returnValue=sh.getRow(i).getCell(j).getStringCellValue();
			            //System.out.println("returnvalue is----"+returnValue);
			            break outer;
			
			         }
			   }
		  }
	 }
	        
	return returnValue;
	
	}
    
    
	public By locators(String locatorpath, String text) {           // Method for Identify the Locators 
		By by = null;
		if(locatorpath.equals("id"))
		{
			by=By.id(text);
		}
		else if(locatorpath.equals("name"))
		{
			by=By.name(text);
		}
		else if(locatorpath.equals("xpath"))
		{
			by=By.xpath(text);
		}
		else if(locatorpath.equals("css"))
		{
			by=By.cssSelector(text);
		}
		else if(locatorpath.equals("linkttext"))
		{
			by=By.linkText(text);
		}
		else if(locatorpath.equals("partialLinkText"))
		{
			by=By.partialLinkText(text);
		}
		return by;
	}
    
    
	public String CaptureScreenShot(String className,String ScrenShotName)     							//Generic function for ScreenShot
    {

    	String file_path = null;
		        
    	try 
    	{
    		String pattern = "dd-MMM-yyyy-HH-mm-ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File fis = ts.getScreenshotAs(OutputType.FILE);
			
			File file = new File("D:\\Test\\Excube360Final\\ScreenShots");
			if(file.exists())
				
			   {
	    		  FileUtils.copyFile(fis, new File("./ScreenShots/"+className+"-"+ScrenShotName+"("+date+").png"));
	    		  file_path = "file:///D:/Test/Excube360Final/ScreenShots/"+className+"-"+ScrenShotName+"("+date+").png";
			   }
			else
				
			   {
	    		file.mkdirs();
	    		FileUtils.copyFile(fis, new File("./ScreenShots/"+className+"-"+ScrenShotName+"("+date+").png"));
	    		file_path = "file:///D:/Test/Excube360Final/ScreenShots/"+className+"-"+ScrenShotName+"("+date+").png";
			   }  
		}
    	catch (Exception e) 
    	   {
			  // TODO Auto-generated catch block
			  e.getMessage();
		   }
		return file_path;
		
    }
    
    public void WebdriverWait(String text,WebElement element){
    	
       	if(text.toLowerCase().equals("visible"))
       	{       		
    	WebDriverWait wait = new WebDriverWait(driver, 50);
    	wait.until(ExpectedConditions.visibilityOf(element));
    	}
    }
    
	
}
