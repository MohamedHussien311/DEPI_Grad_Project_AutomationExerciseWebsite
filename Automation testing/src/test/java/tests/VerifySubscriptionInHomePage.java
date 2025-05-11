package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifySubscriptionInHomePage extends TestBase {

    HomePage homePage;

    @Test(priority = 1, description = "Verify Subscription in home page")
    public void verifySubscriptionInHomePage() {

        homePage = new HomePage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise"));


        String subscriptionText = homePage.getSubscription().getText();
        Assert.assertEquals(subscriptionText.trim(), "SUBSCRIPTION");

        homePage.fillSubscribe("abdomostafa511@gmail.com");

        String successMessage = homePage.getAlertSuccessSubscribe().getText();
        Assert.assertEquals(successMessage.trim(), "You have been successfully subscribed!");
    }
}
