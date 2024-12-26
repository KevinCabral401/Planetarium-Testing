package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Still have to do:
        Validate deletion by counting the number of celestial bodies in table
 */


public class RemoveResourceSteps {
    @When("submits the data to be deleted")
    public void submits_the_data_to_be_deleted() {
        TestRunner.homePage.clickDeleteButton();
    }


    @When("the user inputs valid planet name to be deleted")
    public void the_user_inputs_valid_planet_name_to_be_deleted() {
        TestRunner.homePage.inputValidPlanetNameDelete();
    }

    @When("the user inputs valid moon name to be deleted")
    public void the_user_inputs_valid_moon_name_to_be_deleted() {
        TestRunner.homePage.inputValidMoonNameDelete();
    }

    @Then("the home table should refresh with planetary data removed 1")
    public void the_home_table_should_refresh_with_planetary_data_removed_1() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(3));
        wait.until(driver -> TestRunner.homePage.getNumberOfCelestialRows() == 5);

        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @Then("the home table should refresh with planetary data removed 2")
    public void the_home_table_should_refresh_with_planetary_data_removed_2() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(3));
        wait.until(driver -> TestRunner.homePage.getNumberOfCelestialRows() == 4);

        Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @When("the user inputs invalid {string}")
    public void the_user_inputs_invalid(String string) {
        TestRunner.homePage.inputInvalidCelestialDataForDelete(string);
    }

}
