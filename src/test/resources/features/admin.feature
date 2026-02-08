Feature: Admin Module

  Background:
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button
    And I navigate to Admin module

  @admin @smoke
  Scenario: Add New User with Role Selection Dropdown
    When I click on Add User button
    And I select user role "Admin" from dropdown
    And I enter employee name "Peter Anderson"
    And I select status "Enabled" from dropdown
    And I enter username "testuser123"
    And I enter password "Test@1234"
    And I click save user
    Then I should see success message

  @admin @regression
  Scenario: Search User by Username
    When I search for user by username "Admin"
    And I click search button
    Then I should see user record in results

  @admin @regression
  Scenario: Delete User with Confirmation Popup
    When I search for user by username "testuser"
    And I click search button
    And I click delete button for user
    Then I should see confirmation popup
    When I confirm delete action
    Then I should see success message

  @admin @regression
  Scenario: Add New Job Title
    When I navigate to Job menu
    And I click on Job Titles submenu
    And I click on Add button
    And I enter job title "Software Engineer"
    And I click save
    Then I should see success message

  @admin @regression
  Scenario: Verify User Role Dropdown Options
    When I click on Add User button
    And I click on user role dropdown
    Then I should see "Admin" option in dropdown
    And I should see "ESS" option in dropdown
