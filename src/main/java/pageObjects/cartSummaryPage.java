package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class cartSummaryPage {

	public WebDriver driver;
	
	@FindBy(id ="cart_title")  WebElement pageHeader;
	@FindBy(xpath="//p//a[@title='Proceed to checkout']") WebElement addTocartBtn;
	@FindBy(xpath="//td[@class='cart_product']") WebElement item;
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']") WebElement proceedToChckoutBtn;
	
	
	
	public cartSummaryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void clickaddTocartBtn() {
		addTocartBtn.click();
		
	}
	
	
}
