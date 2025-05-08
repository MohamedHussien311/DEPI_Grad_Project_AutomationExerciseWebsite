package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class VerifyAllProduct extends TestBase {
	HomePage HomePageObject ;
	ProductsPage ProductPageObject ; 
	ProductDetailPage ProductDetailObject ;
  @Test
  public void verifyAllProducts() {
	  HomePageObject = new HomePage (driver);
	  Assert.assertEquals(driver.getCurrentUrl(), baseURL);
	  
	  HomePageObject.openProductsPage();
	  
	  List<WebElement> productList = driver.findElements(By.className("features_items"));
	  System.out.println("Products list visible: " + (!productList.isEmpty() && productList.get(0).isDisplayed()));
	  
	  WebElement firstProductBtn = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
	  firstProductBtn.click();

	  WebElement infoBox = driver.findElement(By.className("product-information"));
	  String productInfo = infoBox.getText();

	  String[] expectedDetails = {"Category", "Availability", "Condition", "Brand", "Rs."};

	  for (String detail : expectedDetails) {
	      if (productInfo.contains(detail)) {
	          System.out.println(detail + " is visible.");
	      } else {
	          System.out.println(detail + " is NOT found.");
	      }
  }
}
}
