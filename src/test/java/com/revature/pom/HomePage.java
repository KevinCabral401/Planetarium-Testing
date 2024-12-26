package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    /*
        This class is going to be our POM Page Object Model. Will store relevant information about web page we
        know we need to find and interact with.
     */

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    @FindBy(tagName = "Select")
    private WebElement celestialSelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(xpath = "//button[@class='submit-button' and text()='Submit Planet']")
    private WebElement submitPlanetButton;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(xpath = "//button[@class='submit-button' and text()='Submit Moon']")
    private WebElement submitMoonButton;

    @FindBy(id="deleteInput")
    private WebElement deleteInput;

    @FindBy(id="deleteButton")
    private WebElement deleteButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  //Keeps things fresh
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void logout(){
        logoutButton.click();
    }

    public void selectPlanet(){
        Select select = new Select(celestialSelect);
        select.selectByIndex(1);
    }

    public void inputValidPlanetName(){
        planetNameInput.sendKeys("Planet Number_23-19");
    }

    public void inputValidPlanetNameJpg(){
        planetNameInput.sendKeys("Planet Number_23-20");
    }

    public void inputInvalidPlanetName(String string){
        planetNameInput.sendKeys(string);
    }

    public void inputPlanetImage(String string){
        planetImageInput.sendKeys(string);
    }

    public void clickSubmitPlanetButton(){
        submitPlanetButton.click();
    }

    public void inputValidMoonName(){
        moonNameInput.sendKeys("Moon Number_23-19");
    }

    public void inputValidMoonNamePng(){
        moonNameInput.sendKeys("Moon Number_23-20");
    }

    public void inputInvalidMoonName(String string){
        moonNameInput.sendKeys(string);
    }

    public void inputValidPlanetId(){
        orbitedPlanetInput.sendKeys("2");
    }

    public void inputInvalidPlanetId(){
        orbitedPlanetInput.sendKeys("10");
    }

    public void inputMoonImage(String string){
        moonImageInput.sendKeys(string);
    }

    public void clickSubmitMoonButton(){
        submitMoonButton.click();
    }

    public void inputValidPlanetNameDelete(){
        deleteInput.sendKeys("Earth"); //luna should be deleted too
    }

    public void inputValidMoonNameDelete(){
        deleteInput.sendKeys("Titan");
    }

    public void inputInvalidCelestialDataForDelete(String string){
        deleteInput.sendKeys(string);
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }
}
