package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationSteps {


    @Given("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        TestRunner.loginPage.clickRegisterLink();
        Assert.assertEquals("Account Creation", TestRunner.registrationPage.getRegisterTitle());
    }

    @When("the user provides a valid username and password for registration")
    public void the_user_provides_a_valid_username_and_password_for_registration() {
        TestRunner.registrationPage.enterValidUserRegistration();
    }

    @When("clicks the register button")
    public void clicks_the_register_button() {
        TestRunner.registrationPage.clickRegisterButton();
    }

    @Then("the user should get a browser alert saying Account created successfully")
    public void the_user_should_get_a_browser_alert_saying_Account_created_successfully() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Account created successfully", alert.getText());
        alert.accept();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.loginPage.getLoginTitle());
    }

    //negative testing steps

    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String string) {
        try {
            TestRunner.wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = TestRunner.driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            Assert.assertEquals(string, alertText);
        } catch (TimeoutException e) {
            Assert.fail("No alert appeared with the expected message.");
        }
    }
}
