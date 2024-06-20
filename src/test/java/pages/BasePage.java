package pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;
  
   
    static{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();
        driver = new ChromeDriver(chromeoptions);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();    
    }
    
    public WebElement Find (String locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); 
    }

    public void clickElement (String locator){
    	driver.findElement(By.xpath(locator)).click();
    }
    
    
    public void scrolldown (){
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("scroll(0, 250);");
    }
    
    
    
    
    public void scrollup (){
    	JavascriptExecutor js = (JavascriptExecutor)driver;	
    	js.executeScript("scroll(0, -250);");
    }

    public void isvisible (String locator){
         scrolldown();
    	driver.findElement(By.xpath(locator)).isDisplayed();
    	scrollup();
    }

    
    
    public static void write (String locator, String textToWrite){
    	driver.findElement(By.xpath(locator)).clear();
    	driver.findElement(By.xpath(locator)).sendKeys(textToWrite);
    }

    public void goToLinkText(String link){
        driver.findElement(By.linkText(link)).click();;
    }

    public void selectItems(String locator, int index){
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
        }
  
    
    public static void switchtowindow(){  	
    	Set<String> s = driver.getWindowHandles();
    	ArrayList ar = new ArrayList(s);
    	System.out.println(ar.get(0));
    	System.out.println(ar.get(1));
    	driver.switchTo().window((String)ar.get(1));
    }





}