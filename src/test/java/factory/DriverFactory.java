package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.commonUtils;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public WebDriver initializeBrowser(String browserName) {
		
		
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
		
		}else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browserName.equals("firefox")){
				
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(commonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(commonUtils.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public WebDriver getDriver() {
		
		return driver;
	}

}
