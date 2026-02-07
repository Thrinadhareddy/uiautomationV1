Feature: Login Functionality

  Scenario: Successful Login with Valid Credentials
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button
    Then I should be redirected to the dashboard

  Scenario: Unsuccessful Login with Invalid Credentials
    Given I am on the OrangeHRM login page
    When I enter invalid username "admin" and password "wrongpass"
    And I click on the login button
    Then I should see an error message "Invalid credentials"
