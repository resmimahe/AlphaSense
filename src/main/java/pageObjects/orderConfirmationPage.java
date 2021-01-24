package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class orderConfirmationPage {

	public WebDriver driver;
	
	
	@FindBy(xpath="//h1[@class='page-heading']") WebElement pageHeader;
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']") WebElement confirmOrderBtn;
	@FindBy(xpath="//span[@id='total_price']") WebElement totalPrice;
	@FindBy(xpath="//p[@class='cheque-indent']/strong") WebElement confirmMsg;
	@FindBy(xpath="//span[@class='ajax_cart_no_product']") WebElement cartIcon;
	@FindBy(xpath="//a[@class='button-exclusive btn btn-default']") WebElement backToOrder;
	
	
	String exp ="Order confirmation";
	
	public orderConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void checkCartIsEmpty(String expected) {
		Assert.assertEquals(cartIcon.getText(),expected);
	}
	
	public void VerifytheSuccsMsg(String expected) {
		Assert.assertEquals(confirmMsg.getText(),expected);
	}
	
	public void backToOrderBtn() {
		
		backToOrder.click();
	}
	
}
