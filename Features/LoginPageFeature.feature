Feature: Login

  Background: 
    Given User luanch the chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"

    @Sanity
  Scenario: Successful login with valid credentials
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page title should be "Your store. Login"


      @regression
  Scenario Outline: Successful Login with valid credentials DDT
    And User enters Email as "<email>" and Password as "<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page title should be "Your store. Login"


    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | test@yourstore.com  | pass     |
