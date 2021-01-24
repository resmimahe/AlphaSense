package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class landingPage {

	public WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']") WebElement	signInBtn;
	
	public landingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyPageTitle(String Expected) {
		
		assertEquals(driver.getTitle(), Expected);
		
	}
	
	public void clickSignInBtn() {
		signInBtn.click();
		
	}
	
	
}
