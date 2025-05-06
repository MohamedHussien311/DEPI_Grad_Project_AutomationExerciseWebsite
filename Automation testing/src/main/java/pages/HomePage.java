package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the HomePage elements
    By signUpBtn = By.linkText("Signup / Login");
    By homeBtn = By.linkText("Home");
    By contactUsbtn = By.linkText("Contact us");
    By productsBtn = By.xpath("//a[@href='/products']");
    By cartBtn = By.linkText("Cart");

    // Locators for subscription section
    By subscriptionText = By.xpath("//h2[normalize-space()='Subscription']");
    By emailInput = By.id("susbscribe_email");
    By subscribeButton = By.id("subscribe");
    By alertSuccess = By.cssSelector("div.alert-success");
    
    // Locators for product section
     By addToCartButton = By.xpath("//button[@data-product-id='%d']"); // Product specific button by index
     By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");
     By viewCartButton = By.xpath("//a[contains(text(), 'View Cart')]");

    // Actions
    
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

    public WebElement getSubscription() {
        return driver.findElement(subscriptionText);
    }

    public HomePage fillSubscribe(String emailAddress) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement button = driver.findElement(subscribeButton);
        button.click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return driver.findElement(alertSuccess);
    }

    public HomePage addProductToCartByIndex(int productIndex) {
        By productAddToCartButton = By.xpath(String.format("//button[@data-product-id='%d']", productIndex));
        WebElement addToCartBtn = driver.findElement(productAddToCartButton);
        addToCartBtn.click();
        return this;
    }

    public HomePage clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
        return this;
    }

    public HomePage clickViewCartButton() {
        driver.findElement(viewCartButton).click();
        return this;
    }
}
