Feature: test login functionality
 Scenario: login with valid email and valid password
    Given  the user in home page
    When  Enter "useremail" and "password" and click on login button
    Then user successfully login

