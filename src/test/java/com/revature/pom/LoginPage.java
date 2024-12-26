package com.revature.pom;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.revature.TestRunner.wait;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(tagName = "input")
    private WebElement loginButton;

    @FindBy(tagName = "a")
    private WebElement registerLink;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //Keeps things fresh
    }

    public void setUpLoggedInUser(){
        driver.get("http://localhost:8080/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameInput")));
        usernameInput.sendKeys("Batman");
        passwordInput.sendKeys("Iamthenight1939");
        loginButton.submit();
    }

    public void enterValidUser(){
        usernameInput.sendKeys("Batman");
        passwordInput.sendKeys("Iamthenight1939");
    }

    public void enterInvalidUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterInvalidPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void openLoginPage(){
        driver.get("http://localhost:8080/");
    }

    public String getLoginTitle() {
        return driver.getTitle();
    }

    public void clickLoginButton(){
        loginButton.submit();
    }

    public void clickRegisterLink(){
        registerLink.click();
    }
}
