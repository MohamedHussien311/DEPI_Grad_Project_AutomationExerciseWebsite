package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	By placeOrderBtn = By.cssSelector(".btn.btn-default.check_out");
	
	public void clickPlaceOrderBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn));
		driver.findElement(placeOrderBtn).click();
	}
}
