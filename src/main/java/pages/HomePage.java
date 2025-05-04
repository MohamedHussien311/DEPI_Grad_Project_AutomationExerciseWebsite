package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signUpBtn = By.linkText("Signup / Login");
	By homeBtn = By.linkText("Home");
	By contactUsbtn = By.linkText("Contact us");
	By productsBtn = By.linkText("Products");
	By cartBtn = By.linkText("Cart");
	
	public void openRegisterationPage() {
		driver.findElement(signUpBtn).click();
	}
	
	public void openLoginPage() {
		driver.findElement(signUpBtn).click();
	}
	
	public void openContactUsPage() {
		driver.findElement(contactUsbtn).click();
	}
	public void openCart() {
		driver.findElement(cartBtn).click();
	}
	public void openProductsPage() {
		driver.findElement(productsBtn).click();
	}
	public String getHomeButtonColor() {
	   return driver.findElement(homeBtn).getCssValue("color");  
	}
	
}
