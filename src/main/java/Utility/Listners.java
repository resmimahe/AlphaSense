package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listners extends Base implements ITestListener {
	ExtentReports extent=extendReport.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentreport= new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ExtentTest would help in getting the test details as per the execution, so we would need an object for tracking the tc
		
		test= extent.createTest(result.getMethod().getMethodName());
		
		//If we are running the tc in parellle we need to store the tc object into a thread free place,ie,ThreadLocal
		extentreport.set(test);
			//so replace all the test object into 
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentreport.get().log(Status.PASS, "The test is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//to get the logs of the failed tc
				extentreport.get().fail(result.getThrowable());
				
				WebDriver driver = null;
				String TestMethodName=result.getMethod().getMethodName();
				//To pass the driver life to this method
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				try {
					
					extentreport.get().addScreenCaptureFromPath(getScreenshot(TestMethodName,driver), result.getMethod().getMethodName());
					getScreenshot(TestMethodName,driver);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// TODO Auto-generated method stub
				
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	

}
