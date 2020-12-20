@AddToCart
Feature: Add to cart

  Scenario Outline: Enable cart to allow users to add food items and checkout
    Given user accesses Swiggy
    And user searches for restaurant at <location>
    When user runs a generic search for <fooditem>
    And user clicks on Add
    Then website should add items to food cart
    And allow user to purchase items in cart

    Examples: 
      | location | fooditem |
      | Thane    | Idli     |
