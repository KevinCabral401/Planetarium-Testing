#create another scenario where no image is input
#still need to validate that the planets and moons were in fact added to the table
  #Png dont work
  #JPG work


Feature: Add planets and moons to the planetarium database
  As a user I want to add new planets and moons to the Planetarium so I can update my findings

  Background: Adding planetary objects starting information
    Given the user is logged in on the home page

  Scenario: User can add new planets to the table without an image
    When the user selects the planet option
    And the user inputs valid planet name
    And submits the planet data
    Then the home table should refresh with the newly added planet input

  Scenario Outline: User can add new planets to the table with valid jpg
    When the user selects the planet option
    And the user inputs valid planet name jpg
    And provides a planet image "<image file>"
    And submits the planet data
    Then the home table should refresh with the newly added planet input jpg

    Examples:
      |image file|
      |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\moon.jpg|

  Scenario Outline: User can add new moons to the table with valid png
    When the user inputs valid moon name png
    And the user inputs valid planet id
    And provides a moon image "<image file>"
    And submits the moon data
    Then the home table should refresh with the newly added moon input png

    Examples:
      |image file|
      |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetpng.png|


  Scenario: User can add new moon to the table without an image
    And the user inputs valid moon name
    And the user inputs valid planet id
    And submits the moon data
    Then the home table should refresh with the newly added moon input
#
#  Scenario Outline: User can not add new planet to table with invalid data
#    When the user selects the planet option
#    And the user provides a planet name "<planet name>"
#    And provides a planet image "<image file>"
#    And submits the planet data
#    Then the user should get a browser alert saying "<alert>"
#
#    Examples:
#      |planet name                    |image file                                                                                        |alert              |
#      |                               |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetp.png|Invalid planet name|
#      |This_planets_name_is_too_longgg|C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetp.png|Invalid planet name|
#      |Jupiter!?()<>                  |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetp.png|Invalid planet name|
#      |Earth                          |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetp.png|Invalid planet name|
#      |Planet Number_23-19            |C:\Users\kerbl\Downloads\Test Philosophy Study Guide.docx                                       |Invalid file type  |
#
#    Scenario Outline: User can not add new moons to the table with invalid data
#      When the user provides a moon name "<moon name>"
#      And the user provides a planetId "<planet id>"
#      And provides a moon image "<image file>"
#      And submits the moon data
#      Then the user should get a browser alert saying "<alert>"
#
#    Examples:
#      |moon name                      |planet id|image file  |alert            |
#      |                               |2        |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetj.jpg|Invalid moon name|
#      |This_moons_name_is_tooo_longggg|2        |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetj.jpg|Invalid moon name|
#      |Moon!?<>(){}                   |2        |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetj.jpg|Invalid moon name|
#      |Titan                          |2        |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetj.jpg|Invalid moon name|
#      |Moon Number_23-19              |4        |C:\Users\kerbl\Desktop\PlanetariumSetup\db-setup\src\test\resources\Celestial-Images\planetj.jpg|Invalid planet id|
#      |Moon Number_23-19              |2        |C:\Users\kerbl\Downloads\Test Philosophy Study Guide.docx                                       |                 |
