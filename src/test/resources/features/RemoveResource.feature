Feature: Remove planets and moons to the planetarium database
  As a user I want to remove planets and moons from the Planetarium so I can correct my findings

  Background: Removing planetary objects starting information
    Given the user is logged in on the home page

  Scenario: User can remove planet and associated moons from the table
    When the user selects the planet option
    And the user inputs valid planet name to be deleted
    And submits the data to be deleted
    Then the home table should refresh with planetary data removed

  Scenario: User can remove moon from table
    When the user inputs valid moon name to be deleted
    And submits the data to be deleted
    Then the home table should refresh with planetary data removed


  Scenario Outline: User can not remove planet from table
    When the user selects the planet option
    When the user inputs invalid "<planetary name>"
    And submits the data to be deleted
    Then the user should get a browser alert saying "<alert>"

    Examples:
      |planetary name|alert              |
      |Jupiter       |Invalid planet name|

  Scenario Outline: User can not remove moon from table
    When the user inputs invalid "<planetary name>"
    And submits the data to be deleted
    Then the user should get a browser alert saying "<alert>"

    Examples:
      |planetary name|alert              |
      |The Moon      |Invalid moon name  |