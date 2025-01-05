@tag
Feature: Cookies
  @tag1
  Scenario: AcceptarCookies
		Given the user is in the index page
		When the user accepts cookies
		Then the cookies popup should be closed

  @tag2
  Scenario Outline: GestionarCookies
    Given the user is in the index page
    When the user manages cookies
    When the user clicks more info cookie a
    When the user finishes reading more info cookie a
    When the user accepts cookie a
    When the user clicks accept all cookies
    Then the cookies popup should be closed