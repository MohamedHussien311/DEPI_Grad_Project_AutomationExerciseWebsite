package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class AddReviewTest extends TestBase{
	HomePage objHomePage ;
	ProductsPage objProductsPage ;
	

  @Test
  public void addReview () {
	  objHomePage = new HomePage(driver);
	  objProductsPage = new ProductsPage (driver);
	  
	  objHomePage.openProductsPage();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
	  
	 objProductsPage.viewFirstProduct();
	 
	 WebElement name = driver.findElement(By.id("name"));
	 WebElement email = driver.findElement(By.id("email"));
	 WebElement review = driver.findElement(By.id("review"));
	 WebElement reviewBtnSubmit = driver.findElement(By.id("button-review"));
	 WebElement successBox = driver.findElement(By.xpath("//*[@id=\"review-section\"]/div"));
	 
	 name.sendKeys("Mohammed");
	 email.sendKeys("ashura@gmail.com");
	 review.sendKeys("Good product");
	 reviewBtnSubmit.click();
	 
	 Assert.assertEquals(successBox.getText(), "Thank you for your review.");
	 
  }
}
