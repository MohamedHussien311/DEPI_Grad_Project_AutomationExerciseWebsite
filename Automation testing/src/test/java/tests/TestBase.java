package tests;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import java.time.Duration;

public class TestBase {
	
	protected WebDriver driver; 
	protected String baseURL = "https://automationexercise.com/";
    @BeforeTest
    public void openBrowser() {
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
    	driver.navigate().to(baseURL);
    }

    @AfterTest
    public void closeBrowser() {
    	driver.quit();
    }


}
