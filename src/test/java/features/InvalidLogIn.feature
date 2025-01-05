@tag
Feature: Invalid login

  @tag1
  Scenario: Logejar-se amb nom incorrecte
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the login option
		Then the login button is displayed
		When the user enters "joanestuopp@example.com" as email and "SecurePassword123!" as password for login
    And the user clicks the login button
    Then an error message indicating invalid name or password is displayed
    
      @tag2
  Scenario Outline: Loggejar-se amb contrasenya incorrecte
    Given the user is in the index page
		When the user accepts cookies
		When the user clicks the login option
		Then the login button is displayed
		When the user enters "joanestopp@example.com" as email and "SecurePassword!" as password for login
    And the user clicks the login button
    Then an error message indicating invalid name or password is displayed
