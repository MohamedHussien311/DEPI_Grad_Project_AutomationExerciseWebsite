package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class SearchProduct extends TestBase {
	HomePage objHomePage ;
	ProductsPage objProductsPage ;
  @Test
  public void searchProduct() {
	  objHomePage = new HomePage(driver);
	  objProductsPage = new ProductsPage (driver);
	  String homeBtnColor = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).getCssValue("color");
	  if (homeBtnColor.equals("orange")) System.out.println("you are in the Home Page") ;
	  objHomePage.openProductsPage();
	  
	  String productsBtnColor = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]")).getCssValue("color");
	  if (productsBtnColor.equals("orange")) System.out.println("you are in the products Page") ;
	  
	  objProductsPage.fillSearchProductInput("winter top");
	  
  }
  
  
}
