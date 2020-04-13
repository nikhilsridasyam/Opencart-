Feature: Checkout a product
Scenario: Checkout a product to buy a
Given I am on the shopping cart page 
When the user selects the cart and fill all detailes
Then the user checkout with the order fonfrmation
Then the user clicks logout and goes to home page