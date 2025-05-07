package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators for the HomePage elements
    By signUpBtn = By.linkText("Signup / Login");
    By homeBtn = By.linkText("Home");
    By contactUsbtn = By.linkText("Contact us");
    By productsBtn = By.xpath("//a[@href='/products']");
    By cartBtn = By.linkText("Cart");

    // Locators for subscription section
    By subscriptionText = By.xpath("//h2[normalize-space()='Subscription']");
    By emailInput = By.id("susbscribe_email");
    By subscribeButton = By.id("subscribe");
    By alertSuccess = By.cssSelector("div.alert-success");
    
    // Locators for product section
     By addToCartButton = By.xpath("//button[@data-product-id='%d']"); // Product specific button by index
     By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");
     By viewCartButton = By.xpath("//a[contains(text(), 'View Cart')]");

     // ************* Abdullah Mohamed ***************************
     By productsBtn2 =By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a");
 	 By productstitle =By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
 	
 	By Viewproductsearched=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
 	By nameOfProduct = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");

 	By WomenDL =By.cssSelector("div.panel:nth-child(1) > div:nth-child(1) > h4:nth-child(1) > a:nth-child(1)");
 	
 	By Dress =By.xpath("/html/body/section[2]/div/div/div[1]/div/div[1]/div[1]/div[2]/div/ul/li[1]/a");
 	By Dresstitle =By.xpath("/html/body/section/div/div[2]/div[2]/div/h2") ;
 	
 	By Tops  =By.cssSelector("#Women > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)");
 	By Topstitle =By.xpath("/html/body/section/div/div[2]/div[2]/div/h2") ;
 	
 	By Saree =By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/ul/li[3]/a");
 	By Sareetitle =By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
 	
 	By MenDL =By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > a:nth-child(1)");
 	By Tshirts  =By.cssSelector("#Men > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
 	By Tshirtstitle  =By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
 	
 	By jean =By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/ul/li[2]/a");
 	By jeantitle  =By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");

 	
 	
 	By KidsDL =By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[3]/div[1]/h4/a");
 	
 	By PoloBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[1]/a");
 	By PoloBrandtilte = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
 	By H_MBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[2]/a");
 	By MadameBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[3]/a");
 	By Mast_HarbourBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[4]/a");
 	By BabyhugBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[5]/a");
 	By AllenSollyJuniorBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[6]/a");
 	By Kookie_KidsBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[7]/a");
 	By BibaBrandbtn = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div/ul/li[8]/a");

 	By SearchProductTxt =By.name("search");
 	By SearchProductBtn=By.xpath("//*[@id=\"submit_search\"]");
 	
 	By addToCartBtn= By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
 	By goToCartBtn= By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div/div[2]/p[2]/a");
 	By CartBage =By.cssSelector(".navbar-nav > li:nth-child(3) > a:nth-child(1)");
 	By Cartbageproduct =By.cssSelector(".cart_description > h4:nth-child(1) > a:nth-child(1)");
 	
 	By subscriptionHeader = By.id("susbscribe_email");
    By scrollUpArrow = By.id("scrollUp");
    By fullFledgedText = By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2");
     
    // Actions
    
    public void openRegisterationPage() {
        driver.findElement(signUpBtn).click();
    }

    public void openLoginPage() {
        driver.findElement(signUpBtn).click();
    }

    public void openContactUsPage() {
        driver.findElement(contactUsbtn).click();
    }

    public void openCart() {
        driver.findElement(cartBtn).click();
    }

    public void openProductsPage() {
        driver.findElement(productsBtn).click();
    }

    public String getHomeButtonColor() {
        return driver.findElement(homeBtn).getCssValue("color");
    }

    public WebElement getSubscription() {
        return driver.findElement(subscriptionText);
    }

    public HomePage fillSubscribe(String emailAddress) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(emailAddress);
        driver.findElement(subscribeButton).click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return driver.findElement(alertSuccess);
    }

    public HomePage addProductToCartByIndex(int productIndex) {
        By productAddToCartButton = By.xpath(String.format("//button[@data-product-id='%d']", productIndex));
        driver.findElement(productAddToCartButton).click();
        return this;
    }

    public HomePage clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
        return this;
    }

    public HomePage clickViewCartButton() {
        driver.findElement(viewCartButton).click();
        return this;
    }
    
    // *************** Abdullah Mohamed ***********************
    
    public void  OpenWomenDL() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(WomenDL)).click();   
    }
    public void  OpenmenDL() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(MenDL)).click();   
    }
    public void  OpenProductPage() throws InterruptedException {
 	     driver.findElement(productsBtn2).click();
 	
 	}  
    public String opendress() throws InterruptedException {
                   OpenWomenDL();
 	              return openall(Dress,Dresstitle);
    }
    
    public String opentops() throws InterruptedException{ 
 	             OpenWomenDL();
                	 return openall(Tops,Topstitle);      
                	 }
    public String  openSaree() throws InterruptedException { 
 	   OpenWomenDL();
      	 return openall(Saree,Sareetitle);      
      	 }
    public String openTshirts() throws InterruptedException{
 	                OpenmenDL();
 	                
      	 return openall(Tshirts,Tshirtstitle);      
      	 }
    public String openJeans() throws InterruptedException{
        OpenmenDL();
        
        return openall(jean,jeantitle);      
 }
    public String openPolo() throws InterruptedException{
        
    	return openall(PoloBrandbtn,PoloBrandtilte);      
 }
    
    
    public String  openall(By by1,By by2 ) throws InterruptedException {
 		   
 	   WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(by1));
 	            element.click();
 		   String rawTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(by2)).getText();
 	       
 	       // Normalize spaces and case
 	       return rawTitle
 	           .replaceAll("\\s+", " ")  // Replace multiple spaces with one
 	           .trim()                   // Remove leading/trailing spaces
 	           .toLowerCase(); 
 	        
 	}
          
      public void navigateBackToProductsPage() {
          driver.navigate().back();
          wait.until(ExpectedConditions.visibilityOfElementLocated(productsBtn2));
      }
      public void scrollDownABit() {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 500 pixels
      }
      
      public String  getTitleOfProduct( ) throws InterruptedException{
     	 
     	 return gettitle(productstitle);
      }
      
      public String  gettitle(By by ) throws InterruptedException {
 		  
   		   String rawTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
   	       
   	       // Normalize spaces and case
   	       return rawTitle
   	           .replaceAll("\\s+", " ")  // Replace multiple spaces with one
   	           .trim()                   // Remove leading/trailing spaces
   	           .toLowerCase(); 
   	        
   	}
      public String userCanSearch(String name) {
  		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchProductTxt)).sendKeys(name);
  		driver.findElement(SearchProductBtn).click();
  		 JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0, 750)"); 
          wait.until(ExpectedConditions.visibilityOfElementLocated(Viewproductsearched)).click();
          
          
  		return wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfProduct)).getText();
  	}
 	public String addtocart() {
 		// TODO Auto-generated method stub
         wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(goToCartBtn)).click();

       HomePage homePage = new HomePage(driver);
 	             homePage.openRegisterationPage();
 	  LoginPage loginPage =new LoginPage(driver); 
 	             loginPage.userCanLogin( "omar12@yahoo.com" ,"987654");
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(CartBage)).click();
 		return wait.until(ExpectedConditions.visibilityOfElementLocated(Cartbageproduct)).getText();


 	}

 	public String  scrollUpDownUsingArrowButton(){
 		
         Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page not visible");
         
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         
         WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionHeader));
         Assert.assertTrue(subscription.isDisplayed(), "Subscription header not visible");
         
         WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(scrollUpArrow));
         arrow.click();
         
         WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(fullFledgedText));
         Assert.assertTrue(textElement.isDisplayed(), "Text not visible after scrolling up");
         
         return textElement.getText();
         
 	}
      
 	public String scrollUpDownWithoutArrowButton() {
 	    Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page not visible");
 	    
 	    JavascriptExecutor js = (JavascriptExecutor) driver;
 	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
 	    
 	    WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionHeader));
 	    Assert.assertTrue(subscription.isDisplayed(), "Subscription header not visible");

 	    js.executeScript("window.scrollTo(0, 0)");
 	    
 	    WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(fullFledgedText));
 	    Assert.assertTrue(textElement.isDisplayed(), "Text not visible after scrolling up");
 	    
         return textElement.getText();

 	}
}
