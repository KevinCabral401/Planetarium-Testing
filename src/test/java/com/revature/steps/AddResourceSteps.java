package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Still to do:
        Validate planets added by counting the rows

 */


public class AddResourceSteps {

    @When("the user inputs valid planet name")
    public void the_user_inputs_valid_planet_name() {
        TestRunner.homePage.inputValidPlanetName();
    }

    @When("the user selects the planet option")
    public void the_user_selects_the_planet_option() {
        TestRunner.homePage.selectPlanet();
    }

    @When("the user inputs valid planet name jpg")
    public void the_user_inputs_valid_planet_name_jpg() {
        TestRunner.homePage.inputValidPlanetNameJpg();
    }

    @When("provides a valid {string}")
    public void provides_a_valid(String string) {
        TestRunner.homePage.inputPlanetImage(string);
    }

    @When("submits the planet data")
    public void submits_the_planet_data(){
        TestRunner.homePage.clickSubmitPlanetButton();
    }

    @Then("the home table should refresh with the newly added planet input")
    public void the_home_table_should_refresh_with_the_newly_added_planet_input() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(3));
        wait.until(driver -> TestRunner.homePage.getNumberOfCelestialRows() == 5);

        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @Then("the home table should refresh with the newly added planet input jpg")
    public void the_home_table_should_refresh_with_the_newly_added_planet_input_jpg() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(3));
        wait.until(driver -> TestRunner.homePage.getNumberOfCelestialRows() == 6);

        Assert.assertEquals(6, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @Then("the home table should refresh with the newly added moon input")
    public void the_home_table_should_refresh_with_the_newly_added_moon_input() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(3));
        wait.until(driver -> TestRunner.homePage.getNumberOfCelestialRows() == 7);

        Assert.assertEquals(7, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @When("the user inputs valid moon name")
    public void the_user_inputs_valid_moon_name() {
        TestRunner.homePage.inputValidMoonName();
    }

    @When("the user inputs valid moon name png")
    public void the_user_inputs_valid_moon_name_png() {
        TestRunner.homePage.inputValidMoonNamePng();
    }

    @Then("the home table should refresh with the newly added moon input png")
    public void the_home_table_should_refresh_with_the_newly_added_moon_input_png() {
        WebDriverWait wait = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(3));
        wait.until(driver -> TestRunner.homePage.getNumberOfCelestialRows() == 8);

        Assert.assertEquals(8, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @When("the user inputs valid planet id")
    public void the_user_inputs_valid_planet_id() {
        TestRunner.homePage.inputValidPlanetId();
    }

    @When("submits the moon data")
    public void submits_the_moon_data(){
        TestRunner.homePage.clickSubmitMoonButton();
    }


    @When("the user provides a planet name {string}")
    public void the_user_provides_a_planet_name(String string) {
        TestRunner.homePage.inputInvalidPlanetName(string);
    }

    @When("provides a planet image {string}")
    public void provides_a_planet_image(String string){
        TestRunner.homePage.inputPlanetImage(string);
    }

    @When("provides a moon image {string}")
    public void provides_a_moon_image(String string){
        TestRunner.homePage.inputMoonImage(string);
    }

    @When("the user provides a moon name {string}")
    public void the_user_provides_a_moon_name(String string) {
        TestRunner.homePage.inputInvalidMoonName(string);
    }

    @When("the user provides a planetId {string}")
    public void the_user_provides_a_planetId(String string){
        TestRunner.homePage.inputInvalidPlanetId();
    }


}
