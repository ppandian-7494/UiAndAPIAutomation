package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver open(String browserType) {
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/ct60644/software/selenium/geckodriver");
			WebDriver driver = new FirefoxDriver();
			return driver;
		}
		else {
			System.setProperty("webdriver.chrome.driver", "/Users/ct60644/software/selenium/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			WebDriver driver = new ChromeDriver(options);
			return driver;

		}
	}
}
