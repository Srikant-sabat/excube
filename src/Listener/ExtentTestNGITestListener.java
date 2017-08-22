package Listener;

import java.util.Arrays;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestNGITestListener implements ITestListener{
	 private ExtentHtmlReporter htmlReports = new ExtentHtmlReporter(System.getProperty("user.dir")+"./ScreenShots/advancereport.html");
	private ExtentReports extent = new ExtentReports();
	
	//public static ExtentHtmlReporter htmlReports;
	public static ExtentTest test;
/*@BeforeSuite
public void seup(){
	htmlReports = new ExtentHtmlReporter(System.getProperty("user.dir")+"./ScreenShots/advancereport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlReports);
}
*/

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("pass");
		extent.attachReporter(htmlReports);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SUCCESS){
			test.pass(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.GREEN));
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		/*if (result.getStatus()==ITestResult.FAILURE){
			System.out.println(result.getName()+"test case failuer");
			test.fail(MarkupHelper.createLabel(result.getName()+"test case failuer", ExtentColor.RED));
			test.fail(result.getThrowable());
		}*/
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	}
