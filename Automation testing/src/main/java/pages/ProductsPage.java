package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    // Locators
    private By titleTextCenter = By.cssSelector(".title.text-center");
    private By viewProductOfFirstProductButton = By.cssSelector("a[href='/product_details/1']");
    private By searchProductInput = By.id("search_product");
    private By submitSearchInput = By.id("submit_search");
    private By searchResultsNames = By.xpath("//div[contains(@class, 'productinfo text-center')]//p");
    
    // Product locators
    private By addToCartButton1 = By.cssSelector("a[data-product-id='1']");
    private By addToCartButton2 = By.cssSelector("a[data-product-id='2']");
    private By continueShoppingButton = By.cssSelector("button[data-dismiss='modal']");
    private By viewCartButton = By.cssSelector("#cartModal a[href='/view_cart']");
    
    private By menCategory = By.cssSelector("a[href='#Men']");
    private By tShirtsCategory = By.cssSelector("a[href='/category_products/3']");
    private By brands = By.cssSelector("div[class='brands-name']");
    private By poloBrand = By.cssSelector("a[href='/brand_products/Polo']");
    private By madameBrand = By.cssSelector("a[href='/brand_products/Madame']");
    private By addButtons = By.cssSelector("a[class='btn btn-default add-to-cart']");
    private By addProductToCartBtnBy = By.cssSelector(".btn.btn-default.add-to-cart");
    // Product containers
    private By productContainers = By.cssSelector(".product-image-wrapper");

    public WebElement getTitleTextCenter() {
        return driver.findElement(titleTextCenter);
    }

    public void clickViewProductOfFirstProduct() {
        driver.findElement(viewProductOfFirstProductButton).click();
    }

    public ProductsPage fillSearchProductInput(String searchProduct) {
        driver.findElement(searchProductInput).sendKeys(searchProduct);
        driver.findElement(submitSearchInput).click();
        return this;
    }

    public List<String> getProductsSearchNames() {
        List<WebElement> elements = driver.findElements(searchResultsNames);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }


    public void addProductsToCart() {
        try {
            
            WebElement firstAddButton = driver.findElement(addToCartButton1);
            js.executeScript("arguments[0].scrollIntoView(true);", firstAddButton);
            js.executeScript("arguments[0].click();", firstAddButton);
            
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            
            
            WebElement continueButton = driver.findElement(continueShoppingButton);
            js.executeScript("arguments[0].click();", continueButton);
            
            WebElement secondAddButton = driver.findElement(addToCartButton2);
            js.executeScript("arguments[0].scrollIntoView(true);", secondAddButton);
            js.executeScript("arguments[0].click();", secondAddButton);
            
   
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
            
            WebElement viewCart = driver.findElement(viewCartButton);
            js.executeScript("arguments[0].click();", viewCart);
        } catch (Exception e) {
            System.out.println("Error in addProductsToCart: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public ProductsPage hoverAndAddProductToCart(int productIndex) {
            List<WebElement> products = driver.findElements(productContainers);
            if (productIndex >= 0 && productIndex < products.size()) {
                WebElement product = products.get(productIndex);
                
     
                js.executeScript("arguments[0].scrollIntoView(true);", product);

                actions.moveToElement(product).perform();
  
                WebElement addToCartButton = product.findElement(By.cssSelector("a.add-to-cart"));
                wait.until(ExpectedConditions.visibilityOf(addToCartButton));
                js.executeScript("arguments[0].click();", driver.findElement(addProductToCartBtnBy));
                
                return this;
            }
        return this;
    }


    public ProductsPage clickContinueShopping() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            WebElement continueButton = driver.findElement(continueShoppingButton);
            js.executeScript("arguments[0].click();", continueButton);
        } catch (Exception e) {
            System.out.println("Error in clickContinueShopping: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }
    

    public void clickViewCart() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
            WebElement viewCart = driver.findElement(viewCartButton);
            js.executeScript("arguments[0].click();", viewCart);
    }

    public ProductsPage clickMenCategory() {
        driver.findElement(menCategory).click();
        return this;
    }

    public ProductsPage clickTShirtsCategory() {
        driver.findElement(tShirtsCategory).click();
        return this;
    }

    public WebElement getBrands() {
        return driver.findElement(brands);
    }

    public ProductsPage clickPoloBrand() {
        driver.findElement(poloBrand).click();
        return this;
    }

    public ProductsPage clickMadameBrand() {
        driver.findElement(madameBrand).click();
        return this;
    }

    public ProductsPage addAllProducts() {
        List<WebElement> buttons = driver.findElements(addButtons);
        for (int i = 0; i < buttons.size(); i += 2) {
            js.executeScript("arguments[0].scrollIntoView(true);", buttons.get(i));
            js.executeScript("arguments[0].click();", buttons.get(i));
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            WebElement continueButton = driver.findElement(continueShoppingButton);
            js.executeScript("arguments[0].click();", continueButton);
        }
        return this;
    }
}