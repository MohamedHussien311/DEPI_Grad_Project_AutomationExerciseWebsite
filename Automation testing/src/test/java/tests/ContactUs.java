package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUs extends TestBase{
	
	 
	HomePage homePageObject ;
	ContactUsPage contuctUsObject ;
	String fileLocation = System.getProperty("user.dir")+"\\file.txt";
	
  @Test
  public void UserCanContactUs() {
	  homePageObject = new HomePage (driver);
	  contuctUsObject = new ContactUsPage(driver);

	  homePageObject.openContactUsPage();
	  Assert.assertEquals("GET IN TOUCH", contuctUsObject.getGetInTouchMsg());
	  contuctUsObject.contactUsSubmit("Khaled", "xsky0sama@gmail.com", "Hello" , "Hello", fileLocation);
	 
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  
	  Assert.assertEquals(contuctUsObject.getSuccessMessage(), "Success! Your details have been submitted successfully.");
	  
	  
  }
}
