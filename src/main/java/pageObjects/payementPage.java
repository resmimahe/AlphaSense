package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class payementPage {

	public WebDriver driver;
	
	@FindBy(name="processCarrier") WebElement proceedToChckoutBtnpage3;
	@FindBy(xpath="//h1[@class='page-heading']") WebElement pageHeader;
	@FindBy(xpath="//a[@class='bankwire']") WebElement payByBank;
	@FindBy(xpath="//a[@class='cheque']") WebElement payByCheck;
	@FindBy(xpath="//span[@id='total_price']") WebElement totalPrice;
	
	
	String exp ="Please choose your payment method";
	
	public payementPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void selectBankPaymentOption() {
		payByBank.click();
	}
	
	public void selectCheckPaymentOption() {
		payByCheck.click();
	}
	
}
