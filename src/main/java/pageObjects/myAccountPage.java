package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class myAccountPage {

	public WebDriver driver;
	
	@FindBy(xpath ="//h1[@class='page-heading']")  WebElement pageHeader;
	@FindBy(xpath="//a[@class='account']/span") WebElement	loggedUser;
	@FindBy(id="search_query_top") WebElement	searchBox;
	@FindBy(name="submit_search") WebElement	searchButton;
	@FindBy(xpath="//span[@class='heading-counter']") WebElement	resultCount;
	@FindBy(xpath="//div[@class='product-container']") WebElement	searchResults;
	@FindAll(@FindBy(xpath="//a[@class='product-name' and @itemprop='url']")) List<WebElement>	searchResultText;
	@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']") WebElement	firstSearchItem;
	@FindBy(xpath="//a[@title='Orders']") WebElement  orederHistory;
	@FindBy(xpath="//a[@title='Log me out']") WebElement  signOutBtn;
	
	
	public myAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void verifyLoggedInUser(String expected) {
		
		String s =loggedUser.getText();
		String Fn =s.substring(0,s.indexOf(' '));
		Assert.assertEquals(Fn,expected);
	}
	
	public void searchForItem(String item) {
		searchBox.sendKeys(item);
		searchButton.click();
	}
	
	public int getResultCount() {
		String count=resultCount.getText();
		int Count = Integer.parseInt(String.valueOf(count.charAt(0)));
		return Count;
	}
	
	public int getItemCount() {
		return searchResultText.size();
		
	}
	
	public void VerifySerachresultAndCountAreMatching(int getItemCount,int getResultCount) {
		
		assertEquals(getItemCount, getResultCount);
	}
	
	public void verifyTheResultsareMatchingWithSearchQuery(String query) {
		for(WebElement we: searchResultText) {
			System.out.println(we.getText());
			if(we.getText().contains(query))
				assert true;
			else
				fail("Results should not match with the search query");
		}
	}
	
	public void selectingAnItem() {
		firstSearchItem.click();
	}
	
	public void ClickOrederHistory() {
		orederHistory.click();
	}
	
	public void signOut() {
		signOutBtn.click();
	}
}
