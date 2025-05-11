package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    // Locators
    private By titleTextCenter = By.cssSelector(".title.text-center");
    private By viewProductOfFirstProductButton = By.cssSelector("a[href='/product_details/1']");
    private By searchProductInput = By.id("search_product");
    private By submitSearchInput = By.id("submit_search");
    private By searchResultsNames = By.xpath("//div[contains(@class, 'productinfo text-center')]//p");
    
    // Product locators
    private By addToCartButton1 = By.cssSelector("a[data-product-id='1']");
    private By addToCartButton2 = By.cssSelector("a[data-product-id='2']");
    private By continueShoppingButton = By.cssSelector("button[data-dismiss='modal']");
    private By viewCartButton = By.cssSelector("#cartModal a[href='/view_cart']");
    
    private By menCategory = By.cssSelector("a[href='#Men']");
    private By tShirtsCategory = By.cssSelector("a[href='/category_products/3']");
    private By brands = By.cssSelector("div[class='brands-name']");
    private By poloBrand = By.cssSelector("a[href='/brand_products/Polo']");
    private By madameBrand = By.cssSelector("a[href='/brand_products/Madame']");
    private By addButtons = By.cssSelector("a[class='btn btn-default add-to-cart']");
    private By addProductToCartBtnBy = By.cssSelector(".btn.btn-default.add-to-cart");
    
    private By viewFirstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    // Product containers
    private By productContainers = By.cssSelector(".product-image-wrapper");

    // ***************** Abdullah Mohamed *************************
// ************* Abdullah Mohamed ****************
    
    By productsBtn =By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a");
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
	By PoloBrandbtn = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[1]/a");
	By PoloBrandtilte = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
	By SearchProductTxt =By.name("search");
	By SearchProductBtn=By.xpath("//*[@id=\"submit_search\"]");
	
	By addToCartBtn= By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	By goToCartBtn= By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div/div[2]/p[2]/a");
	By CartBage =By.cssSelector(".navbar-nav > li:nth-child(3) > a:nth-child(1)");
	By Cartbageproduct =By.cssSelector(".cart_description > h4:nth-child(1) > a:nth-child(1)");
	
	By subscriptionHeader = By.id("susbscribe_email");
    By scrollUpArrow = By.id("scrollUp");
    By fullFledgedText = By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2");
    
    public void  OpenWomenDL() {
        wait.until(ExpectedConditions.elementToBeClickable(WomenDL)).click();   
    }
    public void  OpenmenDL()  {
        wait.until(ExpectedConditions.elementToBeClickable(MenDL)).click();   
    }
    public void  OpenProductPage() {
 	     driver.findElement(productsBtn).click();
 	
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
     
      public void scrollDownABit() {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 500 pixels
      }
      
      public String  getTitleOfProduct( ) throws InterruptedException{
     	 
     	 return gettitle(productstitle);
      }
      
      public String  gettitle(By by ) {
 		  
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
 	//*************************************************************************************
    public WebElement getTitleTextCenter() {
        return driver.findElement(titleTextCenter);
    }

    public void clickViewProductOfFirstProduct() {
    	WebElement productLink = driver.findElement(viewProductOfFirstProductButton);
    	wait.until(ExpectedConditions.elementToBeClickable(productLink));
        productLink.click();
    }

    public ProductsPage fillSearchProductInput(String searchProduct) {
        driver.findElement(searchProductInput).sendKeys(searchProduct);
        driver.findElement(submitSearchInput).click();
        return this;
    }

    public List<String> getProductsSearchNames() {
        List<WebElement> elements = driver.findElements(searchResultsNames);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }


    public void addProductsToCart() {
        try {
            
            WebElement firstAddButton = driver.findElement(addToCartButton1);
            js.executeScript("arguments[0].scrollIntoView(true);", firstAddButton);
            js.executeScript("arguments[0].click();", firstAddButton);
            
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            
            
            WebElement continueButton = driver.findElement(continueShoppingButton);
            js.executeScript("arguments[0].click();", continueButton);
            
            WebElement secondAddButton = driver.findElement(addToCartButton2);
            js.executeScript("arguments[0].scrollIntoView(true);", secondAddButton);
            js.executeScript("arguments[0].click();", secondAddButton);
            
   
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
            
            WebElement viewCart = driver.findElement(viewCartButton);
            js.executeScript("arguments[0].click();", viewCart);
        } catch (Exception e) {
            System.out.println("Error in addProductsToCart: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public ProductsPage hoverAndAddProductToCart(int productIndex) {
            List<WebElement> products = driver.findElements(productContainers);
            if (productIndex >= 0 && productIndex < products.size()) {
                WebElement product = products.get(productIndex);
                
     
                js.executeScript("arguments[0].scrollIntoView(true);", product);

                actions.moveToElement(product).perform();
  
                WebElement addToCartButton = product.findElement(By.cssSelector("a.add-to-cart"));
                wait.until(ExpectedConditions.visibilityOf(addToCartButton));
                js.executeScript("arguments[0].click();", driver.findElement(addProductToCartBtnBy));
                
                return this;
            }
        return this;
    }


    public ProductsPage clickContinueShopping() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            WebElement continueButton = driver.findElement(continueShoppingButton);
            js.executeScript("arguments[0].click();", continueButton);
        } catch (Exception e) {
            System.out.println("Error in clickContinueShopping: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }
    

    public void clickViewCart() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
            WebElement viewCart = driver.findElement(viewCartButton);
            js.executeScript("arguments[0].click();", viewCart);
    }

    public ProductsPage clickMenCategory() {
        driver.findElement(menCategory).click();
        return this;
    }

    public ProductsPage clickTShirtsCategory() {
        driver.findElement(tShirtsCategory).click();
        return this;
    }

    public WebElement getBrands() {
        return driver.findElement(brands);
    }

    public ProductsPage clickPoloBrand() {
        driver.findElement(poloBrand).click();
        return this;
    }

    public ProductsPage clickMadameBrand() {
        driver.findElement(madameBrand).click();
        return this;
    }

    public ProductsPage addAllProducts() {
        List<WebElement> buttons = driver.findElements(addButtons);
        for (int i = 0; i < buttons.size(); i += 2) {
            js.executeScript("arguments[0].scrollIntoView(true);", buttons.get(i));
            js.executeScript("arguments[0].click();", buttons.get(i));
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            WebElement continueButton = driver.findElement(continueShoppingButton);
            js.executeScript("arguments[0].click();", continueButton);
        }
        return this;
    }
    
    public void viewFirstProduct () {
    	driver.findElement(viewFirstProduct).click();
    	
    }
}