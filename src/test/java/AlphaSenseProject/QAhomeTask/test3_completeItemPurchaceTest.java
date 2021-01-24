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

public class test3_completeItemPurchaceTest extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider="data1")
	public void completeItemPurchase(Map<String, String> map) throws InterruptedException {
		
		landingPage	lp = PageFactory.initElements(driver, landingPage.class);
		Thread.sleep(1000L);
		lp.clickSignInBtn();
		login_signupPage ls = PageFactory.initElements(driver, login_signupPage.class);
		ls.userSignIn(map.get("Email"), map.get("Password"));
		//ls.userSignIn("airish@resmi.com", "12345");
		myAccountPage mp = PageFactory.initElements(driver, myAccountPage.class);
		mp.VerifygetPageHeader("MY ACCOUNT");
		mp.verifyLoggedInUser(map.get("FirstName"));
		log.info("Searching an Item");
		mp.searchForItem(map.get("query"));
		mp.selectingAnItem();
		addToCartPage ac = PageFactory.initElements(driver, addToCartPage.class);
		log.info("Verifying the cart is empty");
		ac.verifyThecartIsEmpty("(empty)");
		ac.clickaddTocartBtn();
		log.info("Verifying the Successfull message after adding to cart and proceed to checkout");
		ac.verifyTheSuccessMsgAndProceed("There is 1 item in your cart.");
		cartSummaryPage cs = PageFactory.initElements(driver, cartSummaryPage.class);
		cs.clickaddTocartBtn();
		cartSummary_step1Page cs1 = PageFactory.initElements(driver, cartSummary_step1Page.class);
		cs1.VerifygetPageHeader("ADDRESSES");
		cs1.clickproceedToChckoutBtnpage2();
		shippingPage sp = PageFactory.initElements(driver, shippingPage.class);
		sp.VerifygetPageHeader("SHIPPING");
		sp.radioButtonIsEnabled();
		sp.clickproceedToChckoutBtn();
		sp.checkBoxErrorMessage("You must agree to the terms of service before continuing.");
		sp.checkBoxClick();
		sp.clickproceedToChckoutBtn();
		payementPage pp = PageFactory.initElements(driver, payementPage.class);
		pp.VerifygetPageHeader("PLEASE CHOOSE YOUR PAYMENT METHOD");
		pp.selectCheckPaymentOption();
		orderSummaryPage os = PageFactory.initElements(driver, orderSummaryPage.class);
		os.VerifygetPageHeader("ORDER SUMMARY");
		os.otherPaymentOption();
		pp.selectBankPaymentOption();
		os.confirmOrderBtn();
		orderConfirmationPage op  = PageFactory.initElements(driver, orderConfirmationPage.class);
		op.VerifygetPageHeader("ORDER CONFIRMATION");
		op.checkCartIsEmpty("(empty)");
		op.VerifytheSuccsMsg("Your order on My Store is complete.");
		op.backToOrderBtn();
		orderHistoryPage oh = PageFactory.initElements(driver, orderHistoryPage.class);
		oh.VerifygetPageHeader("ORDER HISTORY");
		
		
	}
	
	@DataProvider(name = "data1")
	public Object[][] regTest() throws InterruptedException, IOException {
		dataProvider dp = new dataProvider();
		return dp.dataSupplier();
	}	

	
	
}
