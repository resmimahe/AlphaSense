package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class cartSummary_step1Page {

	public WebDriver driver;
	
	@FindBy(xpath="//h1[@class='page-heading']") WebElement pageHeader;
	@FindBy(name="processAddress") WebElement proceedToChckoutBtnpage2;
	
	
	
	public cartSummary_step1Page(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void clickproceedToChckoutBtnpage2() {
		proceedToChckoutBtnpage2.click();
		
	}
	
	
}
