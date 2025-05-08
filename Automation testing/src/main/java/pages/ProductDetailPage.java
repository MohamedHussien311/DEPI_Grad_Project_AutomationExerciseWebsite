package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By productName = By.cssSelector("div[class='product-information'] h2");
    private By productCategory = By.xpath("//section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private By productPrice = By.cssSelector("div[class='product-information'] span span");
    private By productAvailability = By.xpath("//section/div/div/div[2]/div[2]/div[2]/div/p[2]");
    private By productCondition = By.xpath("//section/div/div/div[2]/div[2]/div[2]/div/p[3]");
    private By productBrand = By.xpath("//section/div/div/div[2]/div[2]/div[2]/div/p[4]");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.cssSelector("button[class='btn btn-default cart']");
    private By viewCartButton = By.cssSelector("a[href='/view_cart'] u");
    private By writeYourReview = By.cssSelector("a[href='#reviews']");
    private By yourNameInput = By.id("name");
    private By emailAddress = By.id("email");
    private By addReviewHere = By.id("review");
    private By submitButton = By.id("button-review");
    private By successMessage = By.cssSelector("div[class='alert-success alert'] span");
    By allProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div");

    // Constructor
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getProductName() {
        return driver.findElement(productName);
    }

    public WebElement getProductCategory() {
        return driver.findElement(productCategory);
    }

    public WebElement getProductPrice() {
        return driver.findElement(productPrice);
    }

    public WebElement getProductAvailability() {
        return driver.findElement(productAvailability);
    }

    public WebElement getProductCondition() {
        return driver.findElement(productCondition);
    }

    public WebElement getProductBrand() {
        return driver.findElement(productBrand);
    }

    public ProductDetailPage increaseQuantity(String value) {
        WebElement quantityElement = driver.findElement(quantityInput);
        quantityElement.clear();
        quantityElement.sendKeys(value);
        return this;
    }

    public ProductDetailPage addToCartButtonClick() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        wait.until(driver -> driver.findElement(viewCartButton).isDisplayed());
        driver.findElement(viewCartButton).click();
        return new CartPage(driver);
    }

    public WebElement getWriteYourReview() {
        return driver.findElement(writeYourReview);
    }

    public ProductDetailPage fillReview(String name, String email) {
        driver.findElement(yourNameInput).sendKeys(name);
        driver.findElement(emailAddress).sendKeys(email);
        driver.findElement(addReviewHere).sendKeys("this a good prodduct");
        driver.findElement(submitButton).click();
        return this;
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessage);
    }
    

}
