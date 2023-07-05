
Feature: Web Application Test Scenarios
 
@Web
Scenario: Add to Cart Functionality
    Given User searches the medicine
    When User clicks on Add to Card Button
    Then Validate user is navigated to Cart details page
    And Remove cart items
    
@Desktop
Scenario: Outlook Validations
    Given User clciks the New Email Button
    When User enters the Subject
    Then Validate user can enter and Send message

@Mobile    
Scenario: Validate APK Demo Scenarios 
    Given Launch the APK app
    When User clicks on Preferences
    Then User enables WiFi option in App
    