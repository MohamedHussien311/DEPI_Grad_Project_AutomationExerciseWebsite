package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

import java.util.List;

public class remove_products_from_cart extends TestBase {
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test(description = "Remove Products From Cart")
    public void removeProductsFromCart() {
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise"));
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        
        homePage.openProductsPage();
        productsPage.addProductsToCart();
        verifyThatCartPageIsDisplayed();
        verifyThatProductIsRemovedFromTheCart();
    }

    private void verifyThatCartPageIsDisplayed() {
        By cartButton = By.cssSelector("a[href='/view_cart']");
        driver.findElement(cartButton).click();

        By shoppingCartText = By.cssSelector("li[class='active']");
        WebElement cartPage = driver.findElement(shoppingCartText);
        Assert.assertTrue(cartPage.getText().contains("Shopping Cart"), "Cart page is not displayed");
    }

    private void verifyThatProductIsRemovedFromTheCart() {

        By deleteButtons = By.cssSelector("a[class='cart_quantity_delete']");
        List<WebElement> buttons = driver.findElements(deleteButtons);
        while (!buttons.isEmpty()) {
            buttons.get(0).click();
            buttons = driver.findElements(deleteButtons); 
        }

        By emptyCartMessage = By.id("empty_cart");
        WebElement message = driver.findElement(emptyCartMessage);
        Assert.assertEquals(message.getText().trim(), "Cart is empty! Click here to buy products.",
                "Verify that product is removed from the cart");
    }
}
