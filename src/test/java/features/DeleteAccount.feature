@tag
Feature: Delete Account

  @tag1
  Scenario: Eliminar Compte
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the register option
		Then the signup button is displayed
		When the user enters "Joan Estop" as name and "joanestoppppppppp@example.com" as email for signup
    And the user clicks the signup button
    When the user fills the registration form with valid data
    And the user submits the registration form
    And the user clicks the continue button
    Then the user is redirected to the homepage
    When the user clicks the delete account option
    And the user clicks the continue button
    Then the user is redirected to the homepage
    When the user clicks the login option
		Then the login button is displayed
		When the user enters "joanestoppppppppp@example.com" as email and "SecurePassword123!" as password for login
		And the user clicks the login button
    Then an error message indicating invalid name or password is displayed
    
   @tag2
  Scenario Outline: Eliminar Compte fent loggin
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the register option
		Then the signup button is displayed
		When the user enters "Joan Estop" as name and "joanestoppppppppp@example.com" as email for signup
    And the user clicks the signup button
    When the user fills the registration form with valid data
    And the user submits the registration form
    And the user clicks the continue button
    Then the user is redirected to the homepage
    When the user clicks the logout option
    Then go to login page
    When the user enters "joanestoppppppppp@example.com" as email and "SecurePassword123!" as password for login
    And the user clicks the login button
    Then the user is redirected to the homepage
    When the user clicks the delete account option
    And the user clicks the continue button
    Then the user is redirected to the homepage
    When the user clicks the login option
		Then the login button is displayed
		When the user enters "joanestoppppppppp@example.com" as email and "SecurePassword123!" as password for login
		And the user clicks the login button
    Then an error message indicating invalid name or password is displayed
