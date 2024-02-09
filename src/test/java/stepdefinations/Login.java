package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.commonUtils;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private commonUtils commonUtils;
	private DriverFactory driverFactory;
	
	@Given("^User navigates to login page$")
	public void User_navigates_to_login_page() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLogin();
		
	}
	
	@When("^User has enter valid email address (.+) into the email field$")
	public void User_has_enter_valid_email_address_into_the_email_field(String email) {
		
		loginPage.enterEmailAddress(email);
		
	}
	
	@And("^User has enter valid password (.+) into the password field$")
	public void User_has_enter_valid_password_into_the_password_field(String password) {
		
		loginPage.enterPassword(password);
	}
	
	@And("^User clicks on login button$")
	public void User_clicks_on_login_button() {
		
		accountPage = loginPage.clickLoginButton();
		
	}
	
	@Then("^User should get successfully logged in$")
	public void User_should_get_successfully_logged_in() {
		
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformation());
	}
	
	@When("User has enter invalid email address into the email field")
	public void User_has_enter_invalid_email_address_into_the_email_field() {
		
		LoginPage loginPage = new LoginPage(driver);
		commonUtils commonUtils = new commonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}
	
	@And("User has enter invalid password {string} into the password field")
	public void user_has_enter_invalid_password_into_the_password_field(String invalidPassword) {
	    
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassword(invalidPassword);
	}

	@Then("User should get propper warning message about credentials mismatch")
	public void user_should_get_propper_warning_message_about_credentials_mismatch() {
		
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

	@When("User dont enter email address into eamil field")
	public void user_dont_enter_email_address_into_eamil_field() {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");

	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		
		loginPage.enterPassword("");
		
	}
	

}
