Feature: Dashboard Functionality

  Background:
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button

  @dashboard @smoke
  Scenario: Verify Dashboard Loads After Login
    Then I should see the dashboard header
    And I should see the user dropdown

  @dashboard @regression
  Scenario: Navigate to Different Modules from Menu
    When I click on PIM menu
    Then I should be on PIM page
    When I navigate back to dashboard
    And I click on Admin menu
    Then I should be on Admin page

  @dashboard @regression
  Scenario: Verify Quick Launch Widgets
    Then I should see the quick launch widget
