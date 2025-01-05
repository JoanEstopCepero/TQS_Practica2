@tag
Feature: login

  @tag1
  Scenario: Logejar-se com Usuari
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the login option
		Then the login button is displayed
		When the user enters "joanestop@example.com" as email and "SecurePassword123!" as password for login
    And the user clicks the login button
    Then the user is redirected to the homepage
