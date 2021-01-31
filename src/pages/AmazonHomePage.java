package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonHomePage {

	static WebDriver driver;
	
	public void setBookSearchString(String string) {
//		driver.findElement(By.cssSelector("#nav-search-bar-form > div.nav-fill > div.nav-search-field")).click();		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.nav-search-field")));
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.nav-search-field"))).click();
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(string);
	}
	
	public void clickBookSearchButton() {
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}
	
	public void searchBook(String bookType) {
		setBookSearchString(bookType);
		clickBookSearchButton();
	}
	
	public String getPrice() {
		return driver.findElement(By.cssSelector("span.a-price")).getText();
	}
	
	public void selectBook() {
		driver.findElement(By.cssSelector("img.s-image")).click();
	}
	
	public void validatePrice(String price) {
		String localPrice  = driver.findElement(By.xpath("//*[@id=\"mediaTab_heading_0\"]/a/span/div[2]/span")).getText();
		Assert.assertEquals(price, driver.findElement(By.xpath("//*[@id=\"mediaTab_heading_0\"]/a/span/div[2]/span")).getText());
	}
	
	public void addToCart() {
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	}
	
	public void validateCartSubTotal(String price) {
		String localPrice  = driver.findElement(By.xpath("//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")).getText();
		Assert.assertEquals(price, driver.findElement(By.xpath("//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")).getText());
	}
	
	public void proceedToCheckout() {
		driver.findElement(By.xpath("//*[@id=\"hlb-ptc-btn\"]/span")).click();
	}
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
}
