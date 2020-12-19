Feature: Ordering food

  Scenario Outline: User orders food online
    Given Registered user searches for <foodItem>
    And opens a desired restaurant
    And adds to cart
    Then site should confirm order details
    And allow user to complete the order

    Examples: 
      | foodItem |
      | Burger   |
      | pasta    |
