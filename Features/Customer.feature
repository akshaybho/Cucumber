Feature: Customer

  Background: 
    Given User luanch the chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"

  Scenario: Add new customer
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then User can view dashboard
    When User clicks on customer menu
    And Click on customers menu item
    And Click on add new button
    Then User can view add new customer page
    When User enters customer info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    Then Close browser

  
