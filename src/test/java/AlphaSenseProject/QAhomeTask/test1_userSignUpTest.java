package AlphaSenseProject.QAhomeTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.dataProvider;
import Utility.excelGetData;
import pageObjects.landingPage;
import pageObjects.login_signupPage;
import pageObjects.myAccountPage;
import pageObjects.registrationPage;

public class test1_userSignUpTest extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest	
	public void InitialSetup() throws IOException, InterruptedException {
		
		driver=webdriverIntialization();
		log.info("Broswer setup is done");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize(); 
		driver.get(getUrl());
		log.info("Reached Home page ");
	}
@Test(dataProvider="data1")
public void integrationTest(Map<String, String> map) throws InterruptedException {
landingPage lp = PageFactory.initElements(driver, landingPage.class);
lp.verifyPageTitle("My Store");
lp.clickSignInBtn();
log.info("User clicked sign in button");

login_signupPage ls= PageFactory.initElements(driver, login_signupPage.class);
Thread.sleep(1000L);
ls.VerifygetPageHeader("AUTHENTICATION");
ls.enterEmailAddress(map.get("Email"));
ls.clickSubmitBtn();

registrationPage rp= PageFactory.initElements(driver, registrationPage.class);
Thread.sleep(1000L);
//rp.VerifygetPageHeader("Create an account");
log.info("User enterd registration page");
Thread.sleep(3000L);
rp.selectGender(map.get("Title"));
rp.enterFirstName(map.get("FirstName"));
rp.enterLastName(map.get("LastName"));
//rp.getEmailId(map.get("Email"));
rp.enterPassword(map.get("Password"));
Thread.sleep(1000L);
//rp.selectDOB(map.get("Date"), map.get("Month"), map.get("Year"));
rp.enterAddFrstname(map.get("Addr_FirstName"));
rp.enterAddLastname(map.get("Addr_LastName"));
rp.enterCompany(map.get("Company"));
rp.enterAddress(map.get("Address"));
rp.enterAddressLin2(map.get("Address_Line2"));
rp.enterCity(map.get("city"));
rp.selectState(map.get("State"));
rp.enterZip("87654");
//rp.selectCountry(map.get("Country"));
rp.enterOther(map.get("Other"));
rp.enterHomePhone("9087654567");
rp.enterMobileNo("9087654567");
rp.enterAliasAddr(map.get("AddressAlias"));
rp.submitAccountBtn();
myAccountPage mp = PageFactory.initElements(driver, myAccountPage.class);
log.info("User enterd Myaccount page after registration");
mp.VerifygetPageHeader("MY ACCOUNT");
log.info("User name should present as logged in user");
mp.verifyLoggedInUser(map.get("FirstName"));
log.info("User is logging out");
mp.signOut();
log.info("User is logging In again");
ls.userSignIn(map.get("Email"), map.get("Password"));
mp.VerifygetPageHeader("MY ACCOUNT");
}

@DataProvider(name = "data1")
public Object[][] regTest() throws InterruptedException, IOException {
	dataProvider dp = new dataProvider();
	return dp.dataSupplier();
}

}
