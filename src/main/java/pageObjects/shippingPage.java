package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class shippingPage {

	public WebDriver driver;
	
	@FindBy(xpath="//h1[@class='page-heading']") WebElement pageHeader;
	@FindBy(xpath="//button[@name='processCarrier']") WebElement proceedToChckoutBtnpage3;
	@FindBy(xpath="//input[@name='cgv']") WebElement termsOfServiceChckbx;
	@FindBy(xpath="//div[@class='delivery_option_price']") WebElement deliveryCharge;
	@FindBy(xpath="//input[@class='delivery_option_radio']") WebElement radioButton;
	@FindBy(xpath="//p[@class='fancybox-error']") WebElement chckbxError;
	@FindBy(xpath="//a[@title='Close']") WebElement chckbxErrorClose;
	
	
	
	String exp ="You must agree to the terms of service before continuing.";
	
	public shippingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	
	public void radioButtonIsEnabled() {
		
		radioButton.isEnabled();
	}
	
	public void checkBoxErrorMessage(String expected) throws InterruptedException {
		
		Set<String> allWindows = driver.getWindowHandles();
	      Iterator<String> i = allWindows.iterator();
	      while(i.hasNext()){
	         String childwindow = i.next();
	         driver.switchTo().window(childwindow);
	         Thread.sleep(1000L);
	         assertEquals(chckbxError.getText(), expected);
	         Thread.sleep(1000L);
	         chckbxErrorClose.click();
	         }	      
	}

	public void checkBoxClick() {
		
		termsOfServiceChckbx.click();
	}
	
	public void clickproceedToChckoutBtn() {
		proceedToChckoutBtnpage3.click();
	}
	
}
