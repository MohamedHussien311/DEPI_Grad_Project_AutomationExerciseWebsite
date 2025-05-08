package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	By loginToAccountMsg = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
	By emailTxt = By.name("email");
	By passwordTxt = By.name("password");
	By loginBtn = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	By logoutBtn = By.linkText("Logout");
	By failedMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
	By signUpBtn = By.linkText("Signup / Login");

	public String loginToAccountMsg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginToAccountMsg));
		return driver.findElement(loginToAccountMsg).getText();
	}

	public void userCanLogin(String email, String password) {
		driver.findElement(emailTxt).sendKeys(email);
		driver.findElement(passwordTxt).sendKeys(password);
		driver.findElement(loginBtn).click();
	}

	public void userCanLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
	}
	public String verifyLogin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
		return driver.findElement(logoutBtn).getText();
	}

	public String failedMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(failedMessage));
		return driver.findElement(failedMessage).getText();
	}

	public String verifyLogout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtn));
		return driver.findElement(signUpBtn).getText();
	}
}
