package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
Still have to do:
        Validate deletion by counting the number of celestial bodies in table
 */


public class RemoveResourceSteps {
    @When("submits the data to be deleted")
    public void submits_the_data_to_be_deleted() {
        TestRunner.homePage.clickDeleteButton();
    }

    @When("the user selects the planet option")
    public void the_user_selects_the_planet_option() {
        TestRunner.homePage.selectPlanet();
    }
    
    @When("the user inputs valid planet name to be deleted")
    public void the_user_inputs_valid_planet_name_to_be_deleted() {
        TestRunner.homePage.inputValidPlanetNameDelete();
    }

    @When("the user inputs valid moon name to be deleted")
    public void the_user_inputs_valid_moon_name_to_be_deleted() {
        TestRunner.homePage.inputValidMoonNameDelete();
    }

    @Then("the home table should refresh with planetary data removed")
    public void the_home_table_should_refresh_with_planetary_data_removed() {

    }

    @When("the user inputs invalid {string}")
    public void the_user_inputs_invalid(String string) {
        TestRunner.homePage.inputInvalidCelestialDataForDelete(string);
    }

}
