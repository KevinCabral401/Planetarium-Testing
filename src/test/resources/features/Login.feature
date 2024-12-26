Feature: User login
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background: Login starting action
    Given the user is on the login page

  Scenario: Users can login with valid credentials
    #ToDo: make sure to use valid username/password in step implementation
    When the user provides a valid username and password for login
    And the user submits the credentials
    Then the user should be redirected to the home page

  Scenario Outline: Users can not login with invalid credentials
    When the user provides username "<username>"
    And the user provides password "<password>"
    And the user submits the credentials
    Then the user should get a browser alert saying Invalid credentials

    Examples:
      |username|password       |
      |Batman  |b0Ts           |
      |Robin   |Iamthenight1939|
      |Robin   |b0Ts           |


