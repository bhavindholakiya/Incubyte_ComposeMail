package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComposeEmailPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By composeButtonLocator = By.cssSelector(".T-I.T-I-KE.L3");
    private By toRecipientInputLocator = By.name("to");
    private By subjectInputLocator = By.name("subjectbox");
    private By bodyInputLocator = By.cssSelector(".Am.Al.editable.LW-avf.tS-tW");
    private By sendButtonLocator = By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3");

    public ComposeEmailPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickComposeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(composeButtonLocator));
        WebElement composeButton = driver.findElement(composeButtonLocator);
        composeButton.click();
    }

    public void typeEmailAddress(String email){
        wait.until(ExpectedConditions.elementToBeClickable(toRecipientInputLocator));
        WebElement toRecipientEmail = driver.findElement(toRecipientInputLocator);
        toRecipientEmail.sendKeys(email);
    }

    public void typeSubject(String subject){
        WebElement subjectInput = driver.findElement(subjectInputLocator);
        subjectInput.sendKeys(subject);
    }

    public void typeEmailBody(String body){
        WebElement bodyInput = driver.findElement(bodyInputLocator);
        bodyInput.sendKeys(body);
    }

    public void clickSendButton(){
        WebElement sendButton = driver.findElement(sendButtonLocator);
        sendButton.click();
    }
}
