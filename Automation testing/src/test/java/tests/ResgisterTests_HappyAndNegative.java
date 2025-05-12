package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;
public class ResgisterTests_HappyAndNegative extends TestBase {
	HomePage homeObject;
	RegisterPage registerObject;
	@DataProvider (name = "registerFullData")
	public Object[][] userRegistrationFullData(){
		Object testData[][]= new Object[][] {
			{"OmarSaleh" , "omar4@gmail.com","456789", 25 , "11" , "2000", "Omar","Saleh","Orange","Cairo", "Giza",
			"United States","New york","Manhatten","1230213","01105231222"} 
		};
		return testData;
	}
	@DataProvider (name ="registerBasicData")
	public Object[][] userRegistrationBasicData(){
		Object testData[][]= new Object[][] {
			{"OmarSaleh" , "mohamedElaraby5@gmail.com","456789",  "Omar","Saleh","Cairo",
			"United States","New york","Manhatten","1230213","01105231222"} 
		};
		return testData;
	}
  @Test (priority = 1, dataProvider = "registerFullData")
  public void Register_Test_HappyScenarioFullData(String name,String email,String password, int day, String month , String year,
			 String firstName , String lastName , String company , String address1,
			 String address2 , String country , String state , String city ,
			 String zipCode , String mobileNumber) {
	  homeObject = new HomePage (driver);
	  homeObject.openRegisterationPage(); 
	  registerObject = new RegisterPage (driver);
	  Assert.assertEquals("New User Signup!" , registerObject.newUserMessage());
	  
	  registerObject.userCanRegister(name , email);
	  Assert.assertEquals( registerObject.accountInfoMessage(),"ENTER ACCOUNT INFORMATION");
	  
	  registerObject.accountInformation(password, day, month , year, firstName , lastName , company , address1,
			address2 , country , state , city ,zipCode , mobileNumber);
	  Assert.assertEquals("ACCOUNT CREATED!", registerObject.successMessage());
	  
	  registerObject.continueButton();
	  Assert.assertEquals("Logged in as " + name, registerObject.loggedMessage());
	  
	  registerObject.deleteAccount(); 
	  Assert.assertTrue(registerObject.deleteAccountMessage().equalsIgnoreCase("Account Deleted!"));
	  registerObject.continueButton();  
  }
  @Test (priority = 2 , dataProvider = "registerBasicData")
  public void Register_Test_HappyScenarioBasicData(String name,String email,String password,
			 String firstName , String lastName  , String address1,
			 String country , String state , String city ,
			 String zipCode , String mobileNumber) {
	  homeObject = new HomePage (driver);
	  homeObject.openRegisterationPage();  
	  Assert.assertEquals("New User Signup!" , registerObject.newUserMessage());
	  registerObject = new RegisterPage (driver);
	  registerObject.userCanRegister(name , email);  
	  Assert.assertEquals( registerObject.accountInfoMessage(),"ENTER ACCOUNT INFORMATION");
	  
	  registerObject.accountInformation2
	  ( password, firstName , lastName , address1,
	    country , state ,city ,zipCode , mobileNumber);
	  Assert.assertEquals("ACCOUNT CREATED!", registerObject.successMessage());
  
	  registerObject.continueButton();
	  Assert.assertEquals("Logged in as " + name, registerObject.loggedMessage());
	  
	  registerObject.deleteAccount(); 
	  Assert.assertTrue(registerObject.deleteAccountMessage().equalsIgnoreCase("Account Deleted!"));
	  registerObject.continueButton();  
}
  @Test (priority = 3, dependsOnMethods = "Register_Test_HappyScenarioBasicData" )
  public void RegisterTest_Negative_Scenario() {
	  homeObject = new HomePage (driver);
	  homeObject.openRegisterationPage(); 
	  Assert.assertEquals("New User Signup!" , registerObject.newUserMessage());
	  String name = "OmarSaleh";
	  registerObject = new RegisterPage (driver);
	  registerObject.userCanRegister(name , "Omar@gmail.com");
	  Assert.assertEquals("Email Address already exist!", registerObject.failedMessage());
  } 
}
