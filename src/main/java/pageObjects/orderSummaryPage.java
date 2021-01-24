package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class orderSummaryPage {

	public WebDriver driver;
	
	
	@FindBy(xpath="//h1[@class='page-heading']") WebElement pageHeader;
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']") WebElement confirmOrderBtn;
	@FindBy(xpath="//span[@id='total_price']") WebElement totalPrice;
	@FindBy(xpath="//a[@class='button-exclusive btn btn-default']") WebElement otherPaymentBtn;
	
	
	
	String exp ="Order summary";
	
	public orderSummaryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void otherPaymentOption() {
		otherPaymentBtn.click();
		
	}
	
	public void confirmOrderBtn() {
		confirmOrderBtn.click();
		
	}
	}
