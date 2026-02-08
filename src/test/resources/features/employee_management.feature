Feature: Employee Management

  Background:
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button
    And I navigate to PIM module

  @employee @smoke
  Scenario: Add New Employee with Mandatory Fields
    When I click on Add Employee button
    And I enter first name "John"
    And I enter middle name "Michael"
    And I enter last name "Doe"
    And I click save employee
    Then I should see personal details page
    And I should see success message

  @employee @regression
  Scenario: Add Employee with Profile Picture
    When I click on Add Employee button
    And I enter first name "Jane"
    And I enter last name "Smith"
    And I upload employee profile picture "test-image.jpg"
    And I click save employee
    Then I should see personal details page

  @employee @regression
  Scenario: Search Employee by Name
    When I search for employee by name "John Doe"
    And I click search button
    Then I should see employee record in results

  @employee @regression
  Scenario: Search Employee by ID
    When I search for employee by ID "0123"
    And I click search button
    Then I should see employee record in results

  @employee @regression
  Scenario: Edit Employee Details
    When I search for employee by name "John Doe"
    And I click search button
    And I click on employee record
    And I update employee first name to "Jonathan"
    And I click save employee
    Then I should see success message

  @employee @regression
  Scenario: Delete Employee with Confirmation Popup
    When I search for employee by name "Test Employee"
    And I click search button
    And I click delete button for employee
    Then I should see confirmation popup
    When I confirm delete action
    Then I should see success message

  @employee @regression
  Scenario: Verify Employee List Displays Correctly
    Then I should see employee list table
    And I should see employee records
