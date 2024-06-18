package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //By Locators
    private By emailInputLocator = By.id("identifierId");
    private By emailNextButtonLocator = By.cssSelector("div[id=\"identifierNext\"] > div > button");
    private By passwordInputLocator = By.cssSelector("input[type='password']");
    private By passwordNextButtonLocator = By.cssSelector("div[id=\"passwordNext\"] > div > button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void clickNextButtonAfterEnteringEmail(){
        WebElement emailNextButton = driver.findElement(emailNextButtonLocator);
        emailNextButton.click();
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputLocator));
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickNextButtonAfterEnterPassword(){
        WebElement passwordNextButton = driver.findElement(passwordNextButtonLocator);
        passwordNextButton.click();
    }
}
