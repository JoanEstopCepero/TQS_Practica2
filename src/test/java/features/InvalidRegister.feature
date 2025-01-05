@tag
Feature: invalid register

  @tag1
  Scenario: Intentar Registrar nou Usuari
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the register option
		Then the signup button is displayed
		When the user enters "Joan Estop" as name and "joanestopp@example.com" as email for signup
    Then an error message indicating the email already exists is displayed
