Feature: WomenDress

Scenario Outline: Show Women Dress

Given the user is in the index page
When the user accepts cookies
When the user clicks the products option
When the user clicks the View Product button for product a
And the user clicks the Add to Cart button
And the user clicks the View Cart button
And the user clicks the Cart button
Then go to cart page