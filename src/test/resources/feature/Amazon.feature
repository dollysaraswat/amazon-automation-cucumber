
@Amazon1
Feature: To validate user can search , filter and add to cart then checkout product 
 

  	 @Scenario1  
   	Scenario: This scenario contain searching for a product 
    Given the user navigate to Amazon Website
    And User click on search textarea then enter the product 
    Then User get the product

    
   @Scenario2  
   Scenario: This scenario contain filtering the search results 
   Given the user navigate to Amazon Website
   And User click on search textarea then enter the product 
   Then User get the product
   Then User filter the search result 
  
   
    @Scenario3  
   	Scenario: This scenario contain adding a product to the shopping cart
   	Given the user navigate to Amazon Website
   	And User click on search textarea then enter the product
   	Then User get the product
   	Then User filter the search result 
   	And User add the product to cart
   
   
     
