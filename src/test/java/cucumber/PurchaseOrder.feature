
@tag
Feature: Purchase the order from Ecommerce Website
  
Background:
Given I landed on Ecommerce Page

@Regression
  Scenario Outline: Positive Test of submitting the order
    Given logged in with username as <username> and Password as <Password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username        | Password    | productName|
      | test123@gft.com |  Pujitha@95 | ZARA COAT 3|
      
