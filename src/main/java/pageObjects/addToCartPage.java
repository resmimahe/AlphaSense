package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addToCartPage {

	public WebDriver driver;
	
	@FindBy(name="Submit") WebElement addTocartBtn;
	@FindBy(xpath="//span[@class='ajax_cart_product_txt ']") WebElement addTocartSuccsMsg;
	@FindBy(xpath="//a[@title='Proceed to checkout']") WebElement proceedToChckoutBtn;
	@FindBy(xpath="//span[@class='ajax_cart_no_product']") WebElement cartBtn;
	
	
	
	public addToCartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyThecartIsEmpty(String expected) {
		assertEquals(cartBtn.getText(), expected);
	}
	public void clickaddTocartBtn() {
		addTocartBtn.click();
		
	}
	
	public void verifyTheSuccessMsgAndProceed(String expected) throws InterruptedException {
		
		Set<String> allWindows = driver.getWindowHandles();
	      Iterator<String> i = allWindows.iterator();
	      while(i.hasNext()){
	         String childwindow = i.next();
	         driver.switchTo().window(childwindow);
	         Thread.sleep(1000L);
	         assertEquals(addTocartSuccsMsg.getText(), expected);
	         proceedToChckoutBtn.click();}	      
	}
	
}
