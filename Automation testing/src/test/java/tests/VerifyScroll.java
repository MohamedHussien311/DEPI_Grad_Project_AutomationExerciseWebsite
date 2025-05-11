package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;
import static org.testng.Assert.assertEquals;

public class VerifyScroll extends TestBase {
	
	ProductsPage ProductObject;

    @Test(priority = 1)
      public  void ScrollUPDwonUsingArrowbutton() throws InterruptedException {
    	ProductObject = new ProductsPage (driver);
    	assertEquals(ProductObject.scrollUpDownUsingArrowButton(),"Full-Fledged practice website for Automation Engineers");
       }

    @Test(priority = 2)
      public  void ScrollUPDwonWithoutUsingArrowbutton() throws InterruptedException {
    	ProductObject = new ProductsPage (driver);
    	assertEquals(ProductObject.scrollUpDownWithoutArrowButton(),"Full-Fledged practice website for Automation Engineers");

      }
}