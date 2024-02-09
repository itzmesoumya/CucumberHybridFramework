package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class HomePage {
	
	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searhBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	
	public SearchResultPage clickSearchButton() {
		
		elementUtils.clickOnElement(searchButton,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
		
	}

	
	public void enterValidProduct(String validProductText) {
		
		elementUtils.typeTextIntoElement(searhBoxField,validProductText,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterInvalidProduct(String invalidProductText) {
		
		elementUtils.typeTextIntoElement(searhBoxField,invalidProductText,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnElement(myAccountDropMenu,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	public LoginPage clickOnLogin() {
		
		elementUtils.clickOnElement(loginOption, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegister() {
		
		elementUtils.clickOnElement(registerOption, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}

}
