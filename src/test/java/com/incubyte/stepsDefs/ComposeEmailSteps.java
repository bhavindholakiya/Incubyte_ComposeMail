package com.incubyte.stepsDefs;

import com.incubyte.pages.ComposeEmailPage;
import com.incubyte.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComposeEmailSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    private LoginPage loginPage;
    private ComposeEmailPage composeEmail;

    String baseURL = "https://mail.google.com/";
    String email= "bhavin.comnet@gmail.com";
    String password = "Prayag@2211";

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println();
        driver.get(baseURL);
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
    public void the_user_is_logged_into_gmail_account(){
        loginPage.enterEmail(email);
        loginPage.clickNextButtonAfterEnteringEmail();
        loginPage.enterPassword(password);
        loginPage.clickNextButtonAfterEnterPassword();
    }

    @When("the user clicks on the Compose button")
    public void the_user_clicks_on_the_compose_button(){}

    @When("the user enters {string} in the recipient field")
    public void the_user_enters_email_in_the_recipient_field(String email){}

    @When("the user enters {subject}} in the subject field")
    public void the_user_enters_subject_in_the_subject_field(String subject){}

    @When("the user enters {body} in the body field")
    public void the_user_enters_body_in_the_body_field(String body){}

    @When("the user clicks on the Send button")
    public void the_user_clicks_on_the_Send_button(){}

    @Then("the email is sent successfully")
    public void the_email_is_sent_successfully(){}

    @Then("the email appears in the Sent folder")
    public void the_email_appears_in_the_Sent_folder(){}

    @Then("the email subject is {subject}")
    public void the_email_subject_is_Incubyte(String subject){}

    @Then("the email body is {body}")
    public void the_email_body_is_Automation_QA_test_for_Incubyte(String body){}
}
