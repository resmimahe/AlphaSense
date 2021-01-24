package AlphaSenseProject.QAhomeTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.dataProvider;
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


public class test2_searchResultChcekTest extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test(dataProvider="data1")
	public void verifySearchResult(Map<String, String> map) throws InterruptedException {
		
		landingPage	lp = PageFactory.initElements(driver, landingPage.class);
		lp.clickSignInBtn();
		login_signupPage ls = PageFactory.initElements(driver, login_signupPage.class);
		ls.userSignIn(map.get("Email"), map.get("Password"));
		myAccountPage mp = PageFactory.initElements(driver, myAccountPage.class);
		Thread.sleep(2000L);
		mp.VerifygetPageHeader("MY ACCOUNT");
		mp.verifyLoggedInUser(map.get("FirstName"));
		log.info("Searching an Item");
		//mp.searchForItem("Dress"); map.get("Email")
		mp.searchForItem(map.get("query"));
		log.info("Verifying the result count matching with the actual results");
		mp.VerifySerachresultAndCountAreMatching(mp.getItemCount(), mp.getResultCount());
		log.info("Verifying the results are matching with the search query");
		mp.verifyTheResultsareMatchingWithSearchQuery(map.get("query"));

		
	}

	@DataProvider(name = "data1")
	public Object[][] regTest() throws InterruptedException, IOException {
		dataProvider dp = new dataProvider();
		return dp.dataSupplier();
	}	
	
		
}
