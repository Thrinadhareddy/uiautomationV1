Feature: Login Functionality

  @login @smoke
  Scenario: Successful Login with Valid Credentials
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button
    Then I should be redirected to the dashboard

  @login @regression
  Scenario: Unsuccessful Login with Invalid Credentials
    Given I am on the OrangeHRM login page
    When I enter invalid username "admin" and password "wrongpass"
    And I click on the login button
    Then I should see an error message "Invalid credentials"

  @login @regression
  Scenario: Login with Empty Credentials
    Given I am on the OrangeHRM login page
    When I click on the login button
    Then I should see validation error for required fields

  @login @regression
  Scenario: Verify Forgot Password Link
    Given I am on the OrangeHRM login page
    When I click on forgot password link
    Then I should be redirected to password reset page

