package baseComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ReportsOfexceution;

public class Listeners extends BaseComponents implements ITestListener  {
	
	ExtentTest test;
	ExtentReports reports =ReportsOfexceution.execreport();
	
	public void onTestStart(ITestResult result) {
	  test=  reports.createTest(result.getMethod().getMethodName());
	  }

	  public  void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, "Passed");
	  }

	  public  void onTestFailure(ITestResult result) {
		  test.fail(result.getThrowable());
	   
		 try {
		driver=	(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 
		 catch (Exception e) {
		
			e.printStackTrace();
		}
		 String scrshot = null;
		try {
			scrshot = getscreenshotoffailedCase(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 test.addScreenCaptureFromBase64String(scrshot, result.getMethod().getMethodName());
	  }

	  public  void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  public  void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	   public void onStart(ITestContext context) {
	    // not implemented
	  }

	   public void onFinish(ITestContext context) {
	    // not implemented
		   reports.flush();
	  }

}
