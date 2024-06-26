package com.incubyte.stepsDefs;

import com.incubyte.pages.ComposeEmailPage;
import com.incubyte.pages.LoginPage;
import com.incubyte.utility.PropertyFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class ComposeEmailSteps {

    private WebDriver driver;
    private PropertyFileReader fileReader;

    private LoginPage loginPage;
    private ComposeEmailPage composeEmail;

    @Before
    public void setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fileReader = new PropertyFileReader();
        driver.get(fileReader.getProperty("baseURL"));
    }

    @After
    public void tearDown(){
        if (driver!= null){
            driver.quit();
        }
    }

    @Given("I am on the Gmail login page")
    public void i_am_on_the_gmail_login_page(){
        loginPage = new LoginPage(driver);
    }

    @Given("the user is logged into Gmail account")
    public void the_user_is_logged_into_gmail_account() throws IOException {
        loginPage.enterEmail(fileReader.getProperty("email"));
        loginPage.clickNextButtonAfterEnteringEmail();
        loginPage.enterPassword(fileReader.getProperty("password"));
        loginPage.clickNextButtonAfterEnterPassword();
    }

    @When("the user clicks on the Compose button")
    public void the_user_clicks_on_the_compose_button(){
        composeEmail.clickComposeButton();
    }

    @When("the user enters {string} in the recipient field")
    public void the_user_enters_email_in_the_recipient_field(String email){
        composeEmail.typeEmailAddress(email);
    }

    @When("the user enters {string} in the subject field")
    public void the_user_enters_subject_in_the_subject_field(String subject){
        composeEmail.typeSubject(subject);
    }

    @When("the user enters {string} in the body field")
    public void the_user_enters_body_in_the_body_field(String body){
        composeEmail.typeEmailBody(body);
    }

    @When("the user clicks on the Send button")
    public void the_user_clicks_on_the_Send_button(){
        composeEmail.clickSendButton();
    }

    @Then("the email is sent successfully")
    public void the_email_is_sent_successfully(){
        Assert.assertTrue(driver.getPageSource().contains("Message sent"));
    }

    @Then("the email appears in the Sent folder")
    public void the_email_appears_in_the_Sent_folder(){
        driver.findElement(By.linkText("Sent")).click();
        Assert.assertTrue(driver.getPageSource().contains("Incubyte"));
    }

    @Then("the email subject is {string}")
    public void the_email_subject_is_Incubyte(String subject){
        Assert.assertTrue(driver.getPageSource().contains(subject));
    }

    @Then("the email body is {string}")
    public void the_email_body_is_Automation_QA_test_for_Incubyte(String body){
        Assert.assertTrue(driver.getPageSource().contains(body));
    }
}
