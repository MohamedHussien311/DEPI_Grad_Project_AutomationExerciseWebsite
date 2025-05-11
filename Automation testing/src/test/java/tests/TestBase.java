package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {
	
	protected WebDriver driver; 
	protected String baseURL = "https://automationexercise.com/";
	
    @BeforeClass
    public void openBrowser() {
    	driver = new EdgeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
    	driver.navigate().to(baseURL);
    }

    @AfterClass
    public void closeBrowser() {
    	driver.quit();
    }


}
