package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Base {
	public WebDriver driver;
	public Properties prop;
	public String downloadPath=System.getProperty("user.dir");
	

	public WebDriver webdriverIntialization() throws IOException {
		
		
		ChromeOptions options =new ChromeOptions();
		String downloadPath =System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		System.setProperty("webdriver.chrome.driver",
		            "user.dir"+"\\src\\main\\java\\Resources\\chromedriver.exe");
		driver = new ChromeDriver(options);
		return driver;
	}
	
	public String getUrl() throws IOException {
	    // Get baseUrl property
		Properties prop = new Properties();
	    FileInputStream fileInput = new FileInputStream("user.dir"+"\\src\\main\\java\\Resources\\data.properties");
	    prop.load(fileInput);
	    fileInput.close();       
	    String baseUrl = prop.getProperty("url");
	    return baseUrl;}
	
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String TestName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String Destination= System.getProperty("user.dir")+"\\reports\\"+TestName+".png";
		FileUtils.copyFile(source,new File(Destination));
		return Destination;
		
		
	}
	
	public void isFileDownloaded(String directory) {
		File dir = new File(directory);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains("IN0"))
	        	dir_contents[i].delete();
	            }
	}

}