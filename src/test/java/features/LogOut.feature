@tag
Feature: logout

  @tag1
  Scenario: Fer log-out
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the login option
		Then the login button is displayed
		When the user enters "joanestopp@example.com" as email and "SecurePassword123!" as password for login
    And the user clicks the login button
    Then the user is redirected to the homepage
    When the user clicks the logout option
    Then go to login page
