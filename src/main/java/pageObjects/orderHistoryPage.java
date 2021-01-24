package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class orderHistoryPage {

	public WebDriver driver;
	
	
	@FindBy(xpath="//h1[@class='page-heading bottom-indent']") WebElement pageHeader;
	@FindBy(xpath="//span[@id='total_price']") WebElement totalPrice;
	@FindBy(xpath="//a[@class='color-myaccount']") WebElement referenceNumber;
	@FindBy(xpath="//tr[@class='first_item  footable-detail-show']//span[@class='footable-toggle']") WebElement plusIcon;
	@FindBy(xpath="//div[@class='footable-row-detail-value']//a[@title='Invoice']") WebElement pdfIcon;
	@FindBy(xpath="//tr[@class='first_item ']//a[@title='Invoice']") WebElement dwnloadPDF;
	
	
	
	
	String exp ="Order summary";
	
	public orderHistoryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void clickFirstOrder() {
		plusIcon.click();
	}
	
	public void downloadPDF() {
		dwnloadPDF.click();
	}
}
