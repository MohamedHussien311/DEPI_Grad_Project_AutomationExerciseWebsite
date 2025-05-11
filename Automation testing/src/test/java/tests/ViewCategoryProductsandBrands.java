package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;
import static org.testng.Assert.assertEquals;
public class ViewCategoryProductsandBrands extends TestBase   {
 
	ProductsPage ProductObject;
	    @Test(priority =1)
	    public void WomenCategory() throws InterruptedException {
	        // Test Dress
	    	ProductObject = new ProductsPage (driver);
	        ProductObject.OpenProductPage();
	        assertEquals(ProductObject.opendress(), "women - dress products");
	        ProductObject.OpenWomenDL();
	        assertEquals(ProductObject.opentops(), "women - tops products");        
	        ProductObject.OpenWomenDL();;
	        assertEquals(ProductObject.openSaree(), "women - saree products");
	        
	    }
	    
	    @Test(priority =2)

	    public void MenCategory() throws InterruptedException {
	    	ProductObject = new ProductsPage (driver);
	    	ProductObject.scrollDownABit();
	        assertEquals(ProductObject.openTshirts(), "men - tshirts products");
	        assertEquals(ProductObject.openJeans(), "men - jeans products");

	    }	
	    @Test(priority =3)
	    public void Brands() throws InterruptedException {
	    	ProductObject = new ProductsPage (driver);
	        assertEquals(ProductObject.openPolo(), "brand - polo products");
	    }		   
	}

