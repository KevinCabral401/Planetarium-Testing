package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(tagName = "input")
    private WebElement registerButton;

    @FindBy(tagName = "a")
    private WebElement loginLink;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //Keeps things fresh
    }

    public String getRegisterTitle(){
        return driver.getTitle();
    }

    public void enterValidUserRegistration(){
        usernameInput.sendKeys("Super_man-2001");
        passwordInput.sendKeys("Krypton-was_2000");
    }

    public void clickRegisterButton(){
        registerButton.submit();
    }
}
