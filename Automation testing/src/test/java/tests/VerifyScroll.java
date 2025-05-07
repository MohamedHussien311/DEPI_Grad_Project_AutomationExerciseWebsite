package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

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