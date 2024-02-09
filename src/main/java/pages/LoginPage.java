package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class LoginPage {
	
	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name="email")
	private WebElement eamailTextField;
	
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	
	public void enterEmailAddress(String email) {
		
		elementUtils.typeTextIntoElement(eamailTextField, email,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterPassword(String password) {
		
		elementUtils.typeTextIntoElement(passwordTextField,password,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	public AccountPage clickLoginButton() {
		
		elementUtils.clickOnElement(loginButton,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
