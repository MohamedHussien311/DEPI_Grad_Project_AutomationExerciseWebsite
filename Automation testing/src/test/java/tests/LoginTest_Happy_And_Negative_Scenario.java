package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest_Happy_And_Negative_Scenario extends TestBase {
	HomePage homeObject;
	LoginPage loginObject;

	@DataProvider (name = "loginDataHappy")
	public Object[][] userLoginData(){
		Object testData[][] = new Object[][] {
			{"omar12@yahoo.com","987654" }, // correct email and password
		};	
		return testData;
	}
	@DataProvider (name = "loginDataNegative")
	public Object[][] userLoginNegativeData(){
		Object testData[][] = new Object[][] {
			{"omar12@yahoo.com","98765"},  // Correct email with wrong password
			{"omar1@yahoo.com","987654"}   // Correct password with wrong email
		};	
		return testData;
	}
	
  @Test (priority = 1 , dataProvider = "loginDataHappy")
  public void LoginTest_HappyScenario(String email , String password ) {
	  homeObject = new HomePage (driver);
	  homeObject.openLoginPage();
	  loginObject = new LoginPage (driver);
	  Assert.assertEquals("Login to your account", loginObject.loginToAccountMsg());
	  loginObject.userCanLogin(email, password);
	
	  Assert.assertEquals(loginObject.verifyLogin() , "Logout");
	  loginObject.userCanLogout();
	  Assert.assertEquals(loginObject.verifyLogout(),"Signup / Login");
	  
	  }
  @Test (priority = 2 , dataProvider = "loginDataNegative")
  public void LoginTest_NegativeScenario(String email , String password ) {
	  homeObject = new HomePage (driver);
	  homeObject.openLoginPage();
	  Assert.assertEquals("Login to your account", loginObject.loginToAccountMsg());
	  loginObject = new LoginPage (driver);
	  loginObject.userCanLogin(email , password);
	  Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage());
	  
	  }
  
  
}
