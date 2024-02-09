package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class SearchResultPage {
	
	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public SearchResultPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductWrningMessage;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProductMessage;
	
	public boolean getValidProductMessage() {
		
		return elementUtils.displayStatusOfElement(validProductMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getNoProductWarningMessage() {
		
		return elementUtils.getTextFromElement(noProductWrningMessage,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}

}
