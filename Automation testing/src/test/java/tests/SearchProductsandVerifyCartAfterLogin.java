package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;
import static org.testng.Assert.assertEquals;

public class SearchProductsandVerifyCartAfterLogin extends TestBase {
	
	    ProductsPage ProductObject;
	    @Test(priority =1)
	    public void Shearch() throws InterruptedException {
	    	ProductObject = new ProductsPage (driver);
	        ProductObject.OpenProductPage();
	        assertEquals(ProductObject.getTitleOfProduct(), "all products");
	        assertEquals(ProductObject.userCanSearch("Men Tshirt"),"Men Tshirt");
	        assertEquals(ProductObject.addtocart(),"Men Tshirt");
	    }	
}
