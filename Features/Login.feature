Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in successfully

  Scenario: User cannot log in with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    Then the user should see an error message

  Scenario: User logs out successfully
    Given the user is logged in
    When the user clicks the logout button
    Then the user should be logged out