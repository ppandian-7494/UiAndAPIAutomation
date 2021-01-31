package com.iptech;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AmazonHomePage;

public class UIAutomation {

	public static void main(String[] args) {
		WebDriver driver;
//		String browserType = "Firefox";
		String browserType = "Chrome";
		String url = "https://www.amazon.com";
		String bookSearchString = "qa testing for beginners";
		
		driver = utilities.DriverFactory.open(browserType);
		
		driver.get(url);
		
		AmazonHomePage homePage = new AmazonHomePage(driver);
		homePage.searchBook(bookSearchString);
		
		String price = homePage.getPrice().replace("\n", ".");
		
		homePage.selectBook();
		
		homePage.validatePrice(price);
		
		homePage.addToCart();
		
		homePage.validateCartSubTotal(price);
		
		homePage.proceedToCheckout();
	}

}
