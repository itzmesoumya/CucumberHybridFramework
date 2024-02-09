package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;
import utils.ElementUtils;

public class Search {
	
	WebDriver driver;
	private SearchResultPage searchResultPage;
	private HomePage homePage;
	private DriverFactory driverFactory;
	private ElementUtils elementUtils;
	
	@When("User opens the aappliction")
	public void user_opens_the_aappliction() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		ElementUtils elementUtils = new ElementUtils(driver);
	    
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		
		homePage = new HomePage(driver);
		homePage.enterValidProduct(validProductText);
	    
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		homePage = new HomePage(driver);
		searchResultPage = homePage.clickSearchButton();
	    
	}

	@Then("User should get valid product displyed in search results")
	public void user_should_get_valid_product_displyed_in_search_results() {
		
		searchResultPage = new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.getValidProductMessage());
	    
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		
		homePage = new HomePage(driver);
		homePage.enterInvalidProduct(invalidProductText);
	    
	}

	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching() {
		
		searchResultPage = new SearchResultPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",searchResultPage.getNoProductWarningMessage());
		
	}

	@When("User enters any product name into Search box field")
	public void user_enters_any_product_name_into_search_box_field() {
		
		HomePage homePage = new HomePage(driver);
		
	    
	}

}