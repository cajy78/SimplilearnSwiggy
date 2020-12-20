@AccountSignup
Feature: Account Signup

  Scenario: User attempts to signup
    Given user accesses swiggy
    When user clicks on Sign up
    Then site should display signup page

  Scenario Outline: User attempts to signup on Swiggy website
    Given Unregistered user accesses swiggy and clicks on signup
    When user enters <phonenumber>, <name>, <emailaddress>, and <password>
    Then site should create user account

    Examples: 
      | phonenumber | name             | emailaddress            | password |
      |  9757078221 | Vegas Nevadatory | cajy78@testingVegas.com | P@$$w0rd |
