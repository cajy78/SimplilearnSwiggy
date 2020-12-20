@AccountLogin
Feature: Account Login

  @Registered
  Scenario Outline: Registered user attempts login
    Given registered user accesses website and attempts to login
    When enters the <registeredmobilenumber>
    Then a One Time Pin is sent to the users number to login

    Examples: 
      | registeredmobilenumber |
      |             9619127329 |

  @Unregistered
  Scenario Outline: Unregistered user attempts login
    Given unregistered user accesses website and attempts to login
    When enters unregistered <unregisteredmobilenumber>
    Then website should display signup options to enter <name>, <email>, and <password>

    Examples: 
      | unregisteredmobilenumber | name       | email           | password |
      |               7405217429 | Vegas Live | cajy78@live.com | P@$$w0rd |
