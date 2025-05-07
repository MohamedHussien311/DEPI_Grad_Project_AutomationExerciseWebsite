package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class PaymentPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By cardNameTxt = By.name("name_on_card");
	By cardNumberTxt = By.name("card_number");
	By cvcTxt = By.name("cvc");
	By expiryMonthTxt = By.name("expiry_month");
	By expiryYearTxt = By.name("expiry_year");
	By submitBtn = By.id("submit");
	By successMessage = By.linkText("Congratulations! Your order has been confirmed!");
	By downloadInvoiceBtn = By.cssSelector(".btn.btn-default.check_out");
	public void EnterPaymentInfo(String cardName, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cardNameTxt));
		driver.findElement(cardNameTxt).sendKeys(cardName);
		driver.findElement(cardNumberTxt).sendKeys(cardNumber);
		driver.findElement(cvcTxt).sendKeys(cvc);
		driver.findElement(expiryMonthTxt).sendKeys(expiryMonth);
		driver.findElement(expiryYearTxt).sendKeys(expiryYear);
		driver.findElement(submitBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		Assert.assertEquals(driver.findElement(successMessage).getText(), "Congratulations! Your order has been confirmed!");
	}
	public void downloadInvoice() {
		driver.findElement(downloadInvoiceBtn).click();
	}
}
