package tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class add_products_in_cart extends TestBase {

    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test(description = "Add Products in Cart")
    public void addProductsInCart() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        // Step 1: Open Products page
        homePage.openProductsPage();

        // Step 2: Add products to the cart and go to the cart
        productsPage.addProductsToCart();

        // Step 3: Verify two products are added
        List<String> productNames = cartPage.getProductsNames();
        Assert.assertEquals(productNames.size(), 2, "Verify both products are added to Cart");

        // Step 4: Verify prices, quantity, total price
        List<String> prices = cartPage.getPrices();
        List<String> quantities = cartPage.getQuantities();
        List<String> totalPrices = cartPage.getTotalPrices();

        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(prices.get(i).equals(totalPrices.get(i)), "Price equals total for product " + (i + 1));
            Assert.assertEquals(quantities.get(i), "1", "Quantity is 1 for product " + (i + 1));
        }
    }
}
