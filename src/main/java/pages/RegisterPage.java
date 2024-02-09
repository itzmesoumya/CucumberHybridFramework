package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class RegisterPage {
	
	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameTextField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameTextField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressTextField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneTextField;
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordTextField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement radioButton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateWarningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	public String getPasswordWarningMessage() {
		
		return elementUtils.getTextFromElement(passwordWarningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getTelephoneWarningMessage() {
		
		return elementUtils.getTextFromElement(telephoneWarningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getFirstNameWarningMessage() {
		
		return elementUtils.getTextFromElement(firstNameWarningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getLastNameWarningMessage() {
		
		return elementUtils.getTextFromElement(lastNameWarningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getEmailWarningMessage() {
		
		return elementUtils.getTextFromElement(emailWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	public String getPrivacyPolicyWarningMessage() {
		
		return elementUtils.getTextFromElement(privacyPolicyWarningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void EnterFirstName(String firstName) {
		
		elementUtils.typeTextIntoElement(firstNameTextField,firstName, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void EnterLastName(String lastName) {
		
		elementUtils.typeTextIntoElement(lastNameTextField,lastName, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void EnterEmailAddress(String email) {
		
		elementUtils.typeTextIntoElement(emailAddressTextField,email, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void EnterTelephoneNumber(String telephone) {
		
		elementUtils.typeTextIntoElement(telephoneTextField,telephone, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void EnterPassword(String password) {
		
		elementUtils.typeTextIntoElement(passwordTextField,password, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void EnterConfirmPassword(String password) {
		
		elementUtils.typeTextIntoElement(confirmPasswordTextField,password, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void SelectPrivacyPolicy() {
		
		elementUtils.clickOnElement(privacyPolicyCheckBox,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void SelectRadioButton() {
		
		elementUtils.clickOnElement(radioButton,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountSuccessPage ClickContinueButton() {
		
		elementUtils.clickOnElement(continueButton,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public String getDuplicaetWarningMessage() {
		
		return elementUtils.getTextFromElement(duplicateWarningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}