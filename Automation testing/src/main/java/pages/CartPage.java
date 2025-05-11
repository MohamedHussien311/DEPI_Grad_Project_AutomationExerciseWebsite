package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By productNames = By.cssSelector("td.cart_description h4 a");
    private By productPrices = By.cssSelector("td.cart_price p");
    private By productQuantities = By.cssSelector("td.cart_quantity button");
    private By productTotalPrices = By.cssSelector("td.cart_total p");
    private By shoppingCart = By.cssSelector("li[class='active']");
    private By proceedToCheckoutButton = By.cssSelector("a[class='btn btn-default check_out']");
    private By registerLoginButton = By.cssSelector("a[href='/login'] u");
    private By xButton1 = By.cssSelector("a[data-product-id='1']");
    private By xButton2 = By.cssSelector("a[data-product-id='2']");
    private By emptyCartSpan = By.id("empty_cart");
    private By xButtons = By.cssSelector("a[class='cart_quantity_delete']");
    private By subscriptionText = By.xpath("//h2[normalize-space()='Subscription']");
    private By emailInput = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");
    private By alertSuccess = By.cssSelector("div.alert-success");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Actions

    public List<String> getProductsNames() {
        List<WebElement> elements = driver.findElements(productNames);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getPrices() {
        List<WebElement> elements = driver.findElements(productPrices);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getQuantities() {
        List<WebElement> elements = driver.findElements(productQuantities);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTotalPrices() {
        List<WebElement> elements = driver.findElements(productTotalPrices);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getShoppingCartText() {
        return driver.findElement(shoppingCart).getText();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void clickRegisterLoginButton() {
        driver.findElement(registerLoginButton).click();
    }

    public void clickRemoveButtons() {
        driver.findElement(xButton1).click();
        driver.findElement(xButton2).click();
    }

    public String getEmptyCartText() {
        return driver.findElement(emptyCartSpan).getText();
    }

    public void deleteAllAddedProducts() {
        List<WebElement> buttons = driver.findElements(xButtons);
        while (!buttons.isEmpty()) {
            WebElement button = buttons.get(0);
            button.click();
            buttons = driver.findElements(xButtons);
        }
    }

    public String getSubscriptionText() {
        return driver.findElement(subscriptionText).getText();
    }

    public void fillSubscribe(String emailAddress) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(emailAddress);
        WebElement button = driver.findElement(subscribeButton);
        button.click();
    }

    public String getSuccessSubscribeAlert() {
        return driver.findElement(alertSuccess).getText();
    }


    public boolean containsExpectedNumberOfProducts(int expectedCount) {
        return getProductsNames().size() == expectedCount;
    }
}
