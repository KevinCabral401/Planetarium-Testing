package com.revature;

import com.revature.pom.HomePage;
import com.revature.pom.LoginPage;
import com.revature.pom.RegistrationPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty", "html:src/test/resources/reports/html-report.html"}
)
public class TestRunner {
    public static WebDriver driver = null;
    public static WebDriverWait wait;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;

    //BeforeClass provided by Junit, tell Junit to execute the associated method before any other tests.
    //This is useful tool for doing any setup that is needed across multiple tests
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @After
    public void checkForAndAcceptAlert() {
        try {
            // Check if an alert is present
            Alert alert = driver.switchTo().alert();
            alert.accept(); // Accept the alert if present
            System.out.println("Alert was present and accepted.");
        } catch (NoAlertPresentException e) {
            // No alert is present, nothing to do
            System.out.println("No alert present.");
        }
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
