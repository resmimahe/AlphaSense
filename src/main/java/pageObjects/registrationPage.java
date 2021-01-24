package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class registrationPage {

	public WebDriver driver;
	
	@FindBy(xpath ="//h1[@class='page-heading']")  WebElement pageHeader;
	@FindBy(xpath ="//input[@id='id_gender1']")  WebElement gender_male;
	@FindBy(xpath ="//input[@id='id_gender2']")  WebElement gender_female;
	@FindBy(id ="customer_firstname")  WebElement firstName;
	@FindBy(id ="customer_lastname")  WebElement lastName;
	@FindBy(id ="email")  WebElement emailId;
	@FindBy(id ="passwd")  WebElement password;
	@FindBy(xpath ="//select[@id='days']")  WebElement dropdown_Days;
	@FindBy(id ="months")  WebElement dropdown_Month;
	@FindBy(id ="years")  WebElement dropdown_year;
	@FindBy(id ="newsletter")  WebElement newsLetter_ChckBx;
	@FindBy(id ="firstname")  WebElement firstName_Address;
	@FindBy(id ="lastname")  WebElement lastname_Address;
	@FindBy(id ="company")  WebElement company_Address;
	@FindBy(id ="address1")  WebElement address1_Address;
	@FindBy(id ="address2")  WebElement address2_Address;
	@FindBy(id ="city")  WebElement city_Address;
	@FindBy(id ="id_state")  WebElement state_Address;
	@FindBy(xpath ="//select[@id='id_state']//option[@value='1']")  WebElement state_Address1;	
	@FindBy(id ="postcode")  WebElement postcode_Address;
	@FindBy(id ="id_country")  WebElement country_Address;
	@FindBy(id ="other")  WebElement other_Address;
	@FindBy(id ="phone")  WebElement phone_Address;
	@FindBy(id ="phone_mobile")  WebElement phone_mobile_Address;
	@FindBy(id ="alias")  WebElement alias_Address;
	@FindBy(id ="submitAccount")  WebElement submitAccountBtn;
	
	

	public registrationPage(WebDriver driver) {
		this.driver=driver;
	}
		
	public void VerifygetPageHeader(String expected) {
		Assert.assertEquals(pageHeader.getText(),expected);
	}
	
	public void getEmailId(String email) {
		Assert.assertEquals(emailId.getText(),email);
	}
	
	
	public void selectGender(String Gender) {
		
		
		if (Gender.equalsIgnoreCase("male"))
		{
			gender_male.click();
		}
		
		else if (Gender.equalsIgnoreCase("female")) {
			gender_female.click();
		}}
	
	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
		
	}
	
	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname );
		
	}
	
	public void enterPassword(String Password) {
		password.sendKeys(Password );
		
	}
	
	public void enterAddFrstname(String addr_FN) {
		firstName_Address.sendKeys(addr_FN );
		
	}
	
	public void enterAddLastname(String addr_LN) {
		lastname_Address.sendKeys(addr_LN );
		
	}
	
	public void enterCompany(String company) {
		company_Address.sendKeys(company );
		
	}
	
	public void enterAddress(String addr) {
		address1_Address.sendKeys(addr );
		
	}
	
	public void enterAddressLin2(String addrlne2) {
		address2_Address.sendKeys(addrlne2 );
		
	}
	
	public void enterCity(String city) {
		city_Address.sendKeys(city );
		
	}
	
	public void enterZip(String zip) {
		postcode_Address.sendKeys(zip );
		
	}
	
	public void enterOther(String other) {
		other_Address.sendKeys(other );
		
	}
	
	public void enterHomePhone(String homePhone) {
		phone_Address.sendKeys(homePhone );
		
	}
	
	public void enterMobileNo(String Mobile) {
		phone_mobile_Address.sendKeys(Mobile );
		
	}
	
	public void enterAliasAddr(String AliasAddr) {
		alias_Address.sendKeys(AliasAddr );
		
	}
	
	public void selectDOB(String day, String month , String year) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(dropdown_Days));
		Select Day = new Select(dropdown_Days);
		Day.selectByValue(day);
		Select Month = new Select(dropdown_Month);
		Month.selectByValue(month);
		Select Year = new Select(dropdown_year);
		Year.selectByVisibleText(year);
	}
	
	public void selectState(String state) {
		
		 // Actions mouse = new Actions(driver);
		 // mouse.moveToElement(state_Address).perform();
		  //Select State = new Select(state_Address);
		 // State.selectByValue(state);
		//select[@id='id_state']//option[@value='1']
		state_Address1.click();
		
	}
	
	public void selectCountry(String country) {
		Select Country = new Select(country_Address);
		Country.deselectByValue(country);
		
	}
	
	public void submitAccountBtn() {
		submitAccountBtn.click();
		
	}
	
}
