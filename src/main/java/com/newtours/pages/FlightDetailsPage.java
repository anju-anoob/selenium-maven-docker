package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengers;

    @FindBy(name = "findFlights")
    private WebElement submitBtn;

    @FindBy(xpath = "//input[@value='Business']")
    private WebElement serviceClassRadioBtn;

    @FindBy(name = "airline")
    private WebElement airlines;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String noOfPassengers){
        this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select = new Select(passengers);
        select.selectByValue(noOfPassengers);
    }

    public void selectServiceClass(){
        this.wait.until(ExpectedConditions.elementToBeClickable(serviceClassRadioBtn));
        this.serviceClassRadioBtn.click();
    }

    public void selectAirlines(String airline){
        this.wait.until(ExpectedConditions.elementToBeClickable(airlines));
        Select select = new Select(airlines);
        select.selectByVisibleText(airline);
    }

    public void goToFindFlightsPage(){
        this.submitBtn.click();
    }
}
