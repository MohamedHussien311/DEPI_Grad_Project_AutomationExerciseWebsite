package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class VerifyTestCasesPage extends TestBase {  
	HomePage HomePageObject ;
  @Test
  public void TestCasesPageExist() {
	  HomePageObject = new HomePage (driver);
	  HomePageObject.openTestCasesPage();
	  Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases");
  }
}
