@tag
Feature: register

  @tag1
  Scenario: Registrar nou Usuari
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the register option
		Then the signup button is displayed
		When the user enters "Joan Estop" as name and "joanestop@example.com" as email for signup
    And the user clicks the signup button
    When the user fills the registration form with valid data
    And the user submits the registration form
    And the user clicks the continue button
    Then the user is redirected to the homepage
