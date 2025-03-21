@HBuyProduct
Feature: Buying product

  @BuyingProduct
  Scenario: Buying the product
    Given the user is on the home page..
    And the user add the product  from wishlist to cart
    And changing the quantity of product
    And clicking on checkout
    And enter the details pincode Address firstname lastname mobile
      | pincode | Address    | firstname | lastname | mobile     |
      |  500032 | gachibowli | sai       | amara    | 7584321695 |
    And click on Save and Continue button
    And then click on place order
