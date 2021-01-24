package Utility;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class extendReport {

static ExtentReports extent;
	@Test
	public static ExtentReports getReport() {
		//extend report and extend spark report
		//ExtentHtmlReporter used to create the report file and manage the appearance 
		
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentHtmlReporter Reporter = new ExtentHtmlReporter(path);
	//will create the report in the above path
	Reporter.config().setReportName("Web Automation Reports");
	//We can add the report title and name as per our wish
	Reporter.config().setDocumentTitle("Test Results");
	//mapping the created report file format to extent report class
	 extent = new ExtentReports();
	 extent.attachReporter(Reporter);
	 extent.setSystemInfo("Tester", "Resmi");
	//returning this project for using all where
	return extent;
		
	}
	
	
}
