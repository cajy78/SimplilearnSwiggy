@Search
Feature: Search

  Scenario Outline: Search restaurants in location
    Given user access swiggy website
    When user enters location <location>
    Then site should display restaurants available in location
    And provide generic search functionality to run additional food or restaurant searches

    Examples: 
      | location |
      | Thane    |
      | Vashi    |
