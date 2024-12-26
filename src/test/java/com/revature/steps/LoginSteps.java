package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
        Assert.assertEquals("Planetarium Login", TestRunner.loginPage.getLoginTitle());
    }

    @When("the user provides a valid username and password for login")
    public void the_user_provides_a_valid_username_and_password_for_login() {
        TestRunner.loginPage.enterValidUser();
    }

    @When("the user submits the credentials")
    public void the_user_submits_the_credentials() {
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        Assert.assertEquals("Welcome to the Home Page Batman", TestRunner.homePage.getHomePageGreeting());
    }

    @When("the user provides username {string}")
    public void the_user_provides_username(String string) {
        TestRunner.loginPage.enterInvalidUsername(string);
    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String string) {
        TestRunner.loginPage.enterInvalidPassword(string);
    }

    @Then("the user should get a browser alert saying Invalid credentials")
    public void the_user_should_get_a_browser_alert_saying_Invalid_credentials() {
        // Handle browser alert
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Invalid credentials", alert.getText());
        alert.accept();
    }

}
