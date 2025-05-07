package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private WebDriverWait wait;

	private WebDriver driver;	
	public RegisterPage (WebDriver driver) {
	        this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	By newUserMessage = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");
	By nameTxt = By.name("name");
	By emailTxt = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
	By signUpBtn = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
	By accountInfoMessage = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
	By gender1 = By.id("id_gender1");
	By gender2 = By.id("id_gender2");
	By passwordTxt = By.id("password");
	By daysList = By.id("days");
	By monthsList = By.id("months");
	By yearsList = By.id("years");
	By newsletterBtn = By.id("newsletter");
	By offerBtn = By.id("optin");
	By firstNameTxt = By.id("first_name");
	By lastNameTxt = By.id("last_name");
	By companyNameTxt = By.id("company");
	By address1Txt = By.id("address1");
	By address2Txt = By.id("address2");
	By countryList =By.id("country");
	By stateTxt = By.id("state");
	By cityTxt = By.id("city");
	By zipCodeTxt = By.id("zipcode");
	By mobileNumberTxt = By.id("mobile_number");
	By createAccountBtn =By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
	By continueBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
	By successMessage = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
	By loggedMessage = By.partialLinkText("Logged in as");
	By deleteAccount = By.linkText("Delete Account");
	By deleteAccountMessage = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
	By failedMessage = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
	
	public void userCanRegister(String name, String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).sendKeys(name);
		driver.findElement(emailTxt).sendKeys(email);
		driver.findElement(signUpBtn).click();
	}
	
	public void accountInformation
			(String password, int day, String month , String year,
			 String firstName , String lastName , String company , String address1,
			 String address2 , String country , String state , String city ,
			 String zipCode , String mobileNumber)
	{
		wait.until(ExpectedConditions.elementToBeClickable(gender1)).click();
		driver.findElement(passwordTxt).sendKeys(password);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("let newsletter = document.getElementById ('newsletter') \r\n"
				+ "newsletter.scrollIntoView(\r\n"
				+ "    {\r\n"
				+ "        behaviour: 'smooth'\r\n"
				+ "    } \r\n"
				+ ")");
		
		Select makeDaysList = new Select(driver.findElement(daysList));     
		Select makeMonthsList = new Select(driver.findElement(monthsList)); 
		Select makeYearsList = new Select(driver.findElement(yearsList));   
		makeDaysList.selectByIndex(day);
		makeMonthsList.selectByValue(month);
		makeYearsList.selectByVisibleText(year);
		
		driver.findElement(newsletterBtn).click();
		driver.findElement(offerBtn).click();
		driver.findElement(firstNameTxt).sendKeys(firstName);
		driver.findElement(lastNameTxt).sendKeys(lastName);
		driver.findElement(companyNameTxt).sendKeys(company);
		driver.findElement(address1Txt).sendKeys(address1);
		driver.findElement(address2Txt).sendKeys(address2);
		js.executeScript("let country = document.getElementById ('country') \r\n"
				+ "country.scrollIntoView(\r\n"
				+ "    {\r\n"
				+ "        behaviour: 'smooth'\r\n"
				+ "    } \r\n"
				+ ")");
		Select makeCountryList = new Select (driver.findElement(countryList));
		makeCountryList.selectByVisibleText(country);
		driver.findElement(stateTxt).sendKeys(state);
		driver.findElement(cityTxt).sendKeys(city);
		driver.findElement(zipCodeTxt).sendKeys(zipCode);
		driver.findElement(mobileNumberTxt).sendKeys(mobileNumber);
		driver.findElement(createAccountBtn).click();
	}
		public void accountInformation2
		(String password, String firstName , String lastName , String address1,
		 String country , String state , String city , String zipCode , String mobileNumber)
	{
	wait.until(ExpectedConditions.elementToBeClickable(gender1)).click();
	driver.findElement(passwordTxt).sendKeys(password);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("let newsletter = document.getElementById ('newsletter') \r\n"
			+ "newsletter.scrollIntoView(\r\n"
			+ "    {\r\n"
			+ "        behaviour: 'smooth'\r\n"
			+ "    } \r\n"
			+ ")");

	driver.findElement(newsletterBtn).click();
	driver.findElement(offerBtn).click();
	driver.findElement(firstNameTxt).sendKeys(firstName);
	driver.findElement(lastNameTxt).sendKeys(lastName);
	driver.findElement(address1Txt).sendKeys(address1);
	js.executeScript("let country = document.getElementById ('country') \r\n"
			+ "country.scrollIntoView(\r\n"
			+ "    {\r\n"
			+ "        behaviour: 'smooth'\r\n"
			+ "    } \r\n"
			+ ")");
	Select makeCountryList = new Select (driver.findElement(countryList));
	makeCountryList.selectByVisibleText(country);
	driver.findElement(stateTxt).sendKeys(state);
	driver.findElement(cityTxt).sendKeys(city);
	driver.findElement(zipCodeTxt).sendKeys(zipCode);
	driver.findElement(mobileNumberTxt).sendKeys(mobileNumber);
	driver.findElement(createAccountBtn).click();
	}
	
	public String newUserMessage () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserMessage)).getText();		
		}
	public String accountInfoMessage () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoMessage)).getText();
	}
	public String successMessage () {
		return wait.until (ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	}
	public void continueButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn));
		driver.findElement(continueBtn).click();
	}
	public String loggedMessage () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedMessage)).getText();
	}
	public void deleteAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteAccount)).click();
	}
	public String deleteAccountMessage () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteAccountMessage)).getText();
	} 
	public String failedMessage () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(failedMessage)).getText();
	} 
	
}
