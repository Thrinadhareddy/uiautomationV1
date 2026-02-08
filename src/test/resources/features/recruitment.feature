Feature: Recruitment Module

  Background:
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button
    And I navigate to Recruitment module

  @recruitment @smoke
  Scenario: Add New Candidate with Resume Upload
    When I click on Add Candidate button
    And I enter candidate first name "Alice"
    And I enter candidate middle name "Marie"
    And I enter candidate last name "Johnson"
    And I enter candidate email "alice.johnson@example.com"
    And I upload resume "resume.pdf"
    And I click save candidate
    Then I should see success message

  @recruitment @regression
  Scenario: Search Candidate by Name
    When I search for candidate by name "Alice Johnson"
    And I click search button
    Then I should see candidate record in results

  @recruitment @regression
  Scenario: Change Candidate Status Dropdown
    When I search for candidate by name "Alice Johnson"
    And I click search button
    And I click on candidate record
    And I click on shortlist button
    And I click save status
    Then I should see success message

  @recruitment @regression
  Scenario: Add New Vacancy
    When I navigate to Vacancies tab
    And I click on Add button
    And I enter vacancy name "Senior Developer Position"
    And I enter hiring manager "Peter Anderson"
    And I click save
    Then I should see success message
