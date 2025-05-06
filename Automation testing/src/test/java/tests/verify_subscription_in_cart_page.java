package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class verify_subscription_in_cart_page extends TestBase {

    HomePage homePage;
    CartPage cartPage;

    @Test
    public void verifySubscriptionInCartPage() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise"));

        homePage.openCart();

        String subscriptionText = cartPage.getSubscriptionText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION");

        String testEmail = "abdomostafa511@gmail.com";
        homePage.fillSubscribe(testEmail);

        String successMsg = cartPage.getSuccessSubscribeAlert();
        Assert.assertEquals(successMsg, "You have been successfully subscribed!");
    }
}
