
@tag
Feature: Error Validation
  
  @ErrorValidation
  Scenario Outline: verify login failure with incorrect username and password
  Given I landed on Ecommerce Page
  When logged in with username as <username> and Password as <Password>
  Then "Incorrect email or password." message is displayed
  
    Examples: 
      | username         | Password |
      | test123@gft.com  |   fsdgd  | 
