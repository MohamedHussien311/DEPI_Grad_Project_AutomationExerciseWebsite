package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductsPage;
import pages.RegisterPage;

public class PlaceOrderTest extends TestBase{
	String cardName = "mohamed", cardNumber = "12345678902", cvc = "123",
		 expiryMonth = "10", expiryYear = "2026";
	HomePage homePage;
	ProductsPage productsPage;
	CartPage cartPage;
	RegisterPage registerPage;
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;
	@Test(priority = 1, dataProvider = "registerBasicData", dataProviderClass = ResgisterTests_HappyAndNegative.class)
	public void userCanCheckoutOrder(String name, String email, String password, 
            String firstName, String lastName, String address1,
            String country, String state, String city,
            String zipCode, String mobileNumber) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.openProductsPage();
		productsPage = new ProductsPage(driver);
		productsPage.hoverAndAddProductToCart(1);
		productsPage.clickViewCart();
		homePage.openRegisterationPage();
		registerPage = new RegisterPage(driver);
		registerPage.userCanRegister(name, email);
		registerPage.accountInformation2(password, firstName, lastName, address1, country,
			    state, city, zipCode, mobileNumber);
		registerPage.continueButton();
		cartPage = new CartPage(driver);
		homePage.openCart();
		cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.clickPlaceOrderBtn();
		paymentPage = new PaymentPage(driver);
		paymentPage.EnterPaymentInfo(cardName, cardNumber, cvc, expiryMonth, expiryYear);
		
	}
}
