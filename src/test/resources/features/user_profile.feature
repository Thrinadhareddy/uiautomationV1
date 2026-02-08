Feature: User Profile Management

  Background:
    Given I am on the OrangeHRM login page
    When I enter valid username "Admin" and password "admin123"
    And I click on the login button
    And I navigate to My Info module

  @profile @smoke
  Scenario: Update Personal Details
    When I update first name to "Robert"
    And I update middle name to "James"
    And I update last name to "Williams"
    And I click save personal details
    Then I should see success message

  @profile @regression
  Scenario: Add Contact Information with Country Dropdown
    When I navigate to Contact Details tab
    And I enter street address "123 Main Street"
    And I enter city "New York"
    And I select country "United States" from dropdown
    And I click save
    Then I should see success message

  @profile @regression
  Scenario: Add Emergency Contact
    When I navigate to Emergency Contacts tab
    And I click on Add button
    And I enter emergency contact name "Maria Williams"
    And I enter relationship "Spouse"
    And I enter home telephone "555-1234"
    And I click save
    Then I should see success message

  @profile @regression
  Scenario: Upload Profile Picture
    When I upload user profile picture "profile.jpg"
    And I click save
    Then I should see success message
    And I should see updated profile picture
