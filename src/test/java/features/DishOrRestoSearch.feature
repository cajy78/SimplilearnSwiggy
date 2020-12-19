Feature: Dishes or Restaurant search

  Scenario Outline: Search for restaurant or dishes
    Given user accesses swiggy website
    And enters <location>
    When user selects search and enteres <dishname> or <restaurantname>
    Then results should display either dishes or restaurants in location

    Examples: 
      | location | dishname | restaurantname |
      | thane    | burger   | mcdondalds     |
      | mumbai   | pasta    | Qualia         |