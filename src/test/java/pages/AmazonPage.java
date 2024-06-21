package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonPage extends BasePage {
    
   public  AmazonPage(){
	   
	   super(driver); 	    
     }
       
    private String searchField = "//input[@placeholder='Search Amazon.in']";
    private String amazonlogo ="//a[@aria-label='Amazon.in']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String productimage = "//img[@alt='IPCA Acne-UV Gel SPF-50 (50 gm)']";
    private String gettomorrow = "//span[contains(text(),'Get It by Tomorrow')]";
    private String sortby = "//span[contains(text(),'Sort by:')]";
    private String avgcustomerrating = "//a[contains(text(),'Avg. Customer Review')]";
    private String topbrand  = "//span[contains(text(),'Top Brands')]";
    private String checkout  = "//input[@value='Proceed to checkout']";
    private String addToCart = "//input[@id='add-to-cart-button']";
    private String goToCart = "//a[contains(text(),'Go to Cart')]";
    private String checkouth = "//h1[contains(text(),'Checkout')]";
    private String paymentmethod = "//input[@class='a-button-input a-button-text' and @name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']";
    private String loginusername = "//input[@type='email']";
    private String continuebutton  = "//input[@id='continue']";
    private String password  = "//input[@type='password']";
    private String signin  = "//input[@id='signInSubmit']";
    private String useaddress = "//span[@id='orderSummaryPrimaryActionBtn']";
    private String slide = "//input[@id='p_36/range-slider_slider-item_upper-bound-slider']";
  
   
   
 
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.in/");
        driver.manage().window().maximize();   
    }

    public void clickonsearchicon (){
    	clickElement(amazonlogo);
    	clickElement(searchField);
    }
    
    public void enterproductinfield(){
    	clickElement(searchField);
    	BasePage.write(searchField,"ipca acne uv gel spf 50");
    	clickElement(searchButton);
    	isvisible(productimage);
    }
    
    public void filterproduct() throws InterruptedException{
    	 clickElement(sortby);
    	 clickElement(avgcustomerrating);
    	 clickElement(gettomorrow);
    	 scrolldown();
    	 clickElement(topbrand);	 
    	 scrolldown();
    	 slider();
    }
    
    public void addtocart(){
    		clickElement(productimage); 
    		switchtowindow();
    		clickElement(addToCart);
    		clickElement(goToCart); 	 	 
   }
  
        public void checkoutform() {
        	 clickElement(checkout); 
        	 clickElement(loginusername);
        	 BasePage.write(loginusername,"enter your username");
        	 clickElement(continuebutton);
        	 clickElement(password);
        	 BasePage.write(password,"enter password"); 
        	 clickElement(signin);
        	 isvisible(checkouth);  	
        	 clickElement(useaddress);
        	 scroll();  
        	 clickElement(paymentmethod);
        	 scrollproductimage();
        	 isvisible(productimage);  	 
         }

        
        public void scroll(){
        	JavascriptExecutor js = (JavascriptExecutor)driver;
        	WebElement button = driver.findElement(By.xpath(paymentmethod));
        	js.executeScript("arguments[0].scrollIntoView();",button);
        }
        
        
        public void slider() throws InterruptedException {
        	WebElement slider = driver.findElement(By.xpath(slide));
        	Thread.sleep(2000);
        	Actions action = new Actions(driver);
        	action.dragAndDropBy(slider,50,0).perform();    
        }
        
        public void scrollproductimage(){
        	JavascriptExecutor js = (JavascriptExecutor)driver;
        	WebElement button = driver.findElement(By.xpath(productimage));
        	js.executeScript("arguments[0].scrollIntoView();",button);
        }
       
    
}