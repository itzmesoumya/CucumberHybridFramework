package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.commonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private DriverFactory driverFactory;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerPage = homepage.clickOnRegister();
	    
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataMap.get("firstName"));
		registerPage.EnterLastName(dataMap.get("lastName"));
		commonUtils commonUtils = new commonUtils();
		registerPage.EnterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerPage.EnterTelephoneNumber(dataMap.get("telephone"));
		registerPage.EnterPassword(dataMap.get("password"));
		registerPage.EnterConfirmPassword(dataMap.get("password"));
	    
	}
	
	@When("User enters the below fields with duplicate emailaddress")
	public void User_enters_the_below_fields_with_duplicate_emailaddress(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
				
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataMap.get("firstName"));
		registerPage.EnterLastName(dataMap.get("lastName"));
		registerPage.EnterEmailAddress(dataMap.get("email"));
		registerPage.EnterTelephoneNumber(dataMap.get("telephone"));
		registerPage.EnterPassword(dataMap.get("password"));
		registerPage.EnterConfirmPassword(dataMap.get("password"));
		
	}
	

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		
		registerPage.SelectPrivacyPolicy();
	   
	}

	@When("User clicks Continue button")
	public void user_clicks_continue_button() {
		
		accountSuccessPage = registerPage.ClickContinueButton();
	   
	}

	@Then("User account should created successfully")
	public void user_account_should_created_successfully() {
		
		accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
	    
	}

	@When("User selects yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	    
		registerPage.SelectRadioButton();
	}

	@Then("User account should get propper warning message about duplicate emailaddress")
	public void user_account_should_get_propper_warning_message_about_duplicate_emailaddress() {
		
		registerPage = new RegisterPage(driver);
		Assert.assertTrue(registerPage.getDuplicaetWarningMessage().contains("Warning: E-Mail Address is already registered!"));;
	    
	}

	@When("User dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() {
		
		registerPage = new RegisterPage(driver);
	    
	}

	@Then("User should get propper warning messages for every mandatory field")
	public void user_should_get_propper_warning_messages_for_every_mandatory_field() {
		
		Assert.assertTrue(registerPage.getPrivacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarningMessage());
		
	   
	}

}
