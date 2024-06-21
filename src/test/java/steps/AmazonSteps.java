package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.AmazonPage;

public class AmazonSteps {

  
	 AmazonPage amazon = new AmazonPage();
      
    @Given("^the user navigate to Amazon Website$")
    public void navigateToAmazon () throws InterruptedException{
    	
        amazon.navigateToAmazon();

    }

    @And("^User click on search textarea then enter the product$")
    public void searchCriteria(){
        amazon.clickonsearchicon();   
    }
      
    @Then("^User get the product$")
    public void getproduct(){
        amazon.enterproductinfield();
    }
    
    @Then("^User filter the search result$")
    public void filterthedata() throws InterruptedException{
        amazon.filterproduct();  
    }

    @And("^User add the product to cart$")
    public void addtocart(){
        amazon.addtocart();
    }
               
    @Then("^User Fill the checkout and fill the form$")
    public void checkform() throws InterruptedException{
    amazon.checkoutform();        	
    }
            
        
    

   

   

 
   }
    
   


    
   
  
    