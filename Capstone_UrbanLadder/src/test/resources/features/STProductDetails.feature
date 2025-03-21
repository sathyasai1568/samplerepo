@ProductDetails
Feature: Product Page Verification

 Scenario: Verify Product Page Sections

  Given the user is on the search page
  And the enters the "<product>" name in searchbar
  And click on product and validate the title,description and price
  And the user should add the product to wishlist
  And the user add the product  from wishlist to cart
  And removing product from cart
Examples:
|product|
|sofa|