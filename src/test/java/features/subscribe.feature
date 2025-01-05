Feature: Subscribe

Scenario Outline: Subscirbe to newletter

Given the user is in the index page
When the user accepts cookies
When the user enters "joanestop@example.com" in the subscription bar
When the user clicks the subscribe button
Then the user is redirected to the homepage