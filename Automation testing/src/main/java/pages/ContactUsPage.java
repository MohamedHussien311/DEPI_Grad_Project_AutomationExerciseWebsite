package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactUsPage {
    protected WebDriver driver;
    protected String successMessage = ("Success! Your details have been submitted successfully.");
    protected String getInTocuhMessage = ("Get In Touch");
    private WebDriverWait wait;
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    
    By contactUsBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By nameTxt = By.name("name");
    By emailTxt = By.name("email");
    By subject = By.name("subject");
    By message = By.name("message");
    By uploadFile = By.name("upload_file");
    By subBtn = By.name("submit");
    By getInTouchTxt = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
    By getSuccessMessage = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    By homeBtn = By.xpath("//*[@id=\"form-section\"]/a/span");
    
    public void name (String name) {
    	driver.findElement(nameTxt).sendKeys(name);
    }
    
    public void email (String email) {
    	driver.findElement(emailTxt).sendKeys(email);
    }
    
    public void subject (String subject) {
    	driver.findElement(this.subject).sendKeys(subject);
    }
    
    public void message (String message) {
    	driver.findElement(this.message).sendKeys(message);
    }
    
    public void upLoadFile (String file) { 
    	// send file location
    	driver.findElement(uploadFile).sendKeys(file);
    }
    
    public void submit () {
    	WebElement submitBtn = driver.findElement(subBtn);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
    	wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
    	submitBtn.click();
    }
    
    public void contactUsSubmit (String name , String email , String subject , String message , String file) {
    	name(name);
    	email(email);
    	subject(subject);
    	message(message);
    	upLoadFile(file);
    	submit();
    	wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public String getGetInTouchMsg () {
	String checkMessage = driver.findElement(getInTouchTxt).getText();
	return checkMessage;
     }
    
    public String getSuccessMessage () {
	String checkMessage = driver.findElement(getSuccessMessage).getText();
	return checkMessage;
     }
    
    
    public String getHomeButtonColor() {
        return driver.findElement(contactUsBtn).getCssValue("color");
    }
    

}
