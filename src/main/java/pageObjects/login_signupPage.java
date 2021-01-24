package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class login_signupPage {

	public WebDriver driver;
	
	@FindBy(xpath ="//h1[@class='page-heading']")  WebElement pageHeader;
	@FindBy(id ="email_create")  WebElement emailAddress;
	@FindBy(id ="SubmitCreate")  WebElement submitBtnCreate;
	@FindBy(id ="email")  WebElement emailLogin;
	@FindBy(id ="passwd")  WebElement passwordLogin;
	@FindBy(id ="SubmitLogin")  WebElement submitLoginBtn;

	public login_signupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void enterEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void clickSubmitBtn() {
		submitBtnCreate.click();
	}
	
	public void userSignIn(String username, String pwd) {
		emailLogin.sendKeys(username);
		passwordLogin.sendKeys(pwd);
		submitLoginBtn.click();
	}
	
}
