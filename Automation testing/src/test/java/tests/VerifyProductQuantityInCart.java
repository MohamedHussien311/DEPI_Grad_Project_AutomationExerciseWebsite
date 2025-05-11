package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import pages.CartPage;

public class VerifyProductQuantityInCart extends TestBase {
    
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    
    @Test(description = "Verify Product quantity in Cart")
    public void verifyProductQuantityInCart() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);

        homePage.openProductsPage();
        
 
        productsPage.clickViewProductOfFirstProduct();

        productDetailPage = new ProductDetailPage(driver);
        

        Assert.assertTrue(productDetailPage.getProductName().isDisplayed(), 
                         "Product detail page is not opened");
        
        productDetailPage.increaseQuantity("4");

        productDetailPage.addToCartButtonClick();

        cartPage = productDetailPage.viewCartButtonClick();

        String actualQuantity = cartPage.getQuantities().get(0);
        Assert.assertEquals(actualQuantity, "4", 
                           "Product is not displayed in cart page with quantity=4");
    }
}