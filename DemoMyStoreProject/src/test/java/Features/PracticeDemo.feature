Feature: PracticeDemo

  Scenario: Order Tshirt using PayByWire payment option
    Given user launches AutomationPactice webapp
    When user logs in with "abc195@gmail.com" and password "abc195"
    And orders a tshirt
    Then order should be visible in order history
   
Scenario: Update First Name in Personal Information
    Given user launches AutomationPactice webapp
    When user logs in with "abc195@gmail.com" and password "abc195"
    And user updates first name in Personal Information Page
    Then user validates confirmation message