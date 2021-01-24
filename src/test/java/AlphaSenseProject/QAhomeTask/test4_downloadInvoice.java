package AlphaSenseProject.QAhomeTask;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.dataProvider;
import junit.framework.Assert;
import pageObjects.addToCartPage;
import pageObjects.cartSummaryPage;
import pageObjects.cartSummary_step1Page;
import pageObjects.landingPage;
import pageObjects.login_signupPage;
import pageObjects.myAccountPage;
import pageObjects.orderConfirmationPage;
import pageObjects.orderHistoryPage;
import pageObjects.orderSummaryPage;
import pageObjects.payementPage;
import pageObjects.shippingPage;

public class test4_downloadInvoice extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider="data1")
	public void downloadInvoice(Map<String, String> map) throws InterruptedException {
		landingPage	lp = PageFactory.initElements(driver, landingPage.class);
		Thread.sleep(1000L);
		lp.clickSignInBtn();
		login_signupPage ls = PageFactory.initElements(driver, login_signupPage.class);
		//ls.userSignIn("airish@resmi.com", "12345");
		ls.userSignIn(map.get("Email"), map.get("Password"));
		myAccountPage mp = PageFactory.initElements(driver, myAccountPage.class);
		mp.ClickOrederHistory();
		orderHistoryPage oh = PageFactory.initElements(driver, orderHistoryPage.class);
		oh.VerifygetPageHeader("ORDER HISTORY");
		oh.downloadPDF();
		
		Thread.sleep(5000L);;
		isFileDownloaded(downloadPath);
		
		
	}
	
	@DataProvider(name = "data1")
	public Object[][] regTest() throws InterruptedException, IOException {
		dataProvider dp = new dataProvider();
		return dp.dataSupplier();
	}	
	
	@AfterTest
	public void tearDown() {
		tearDown();
	}
		
	
}
