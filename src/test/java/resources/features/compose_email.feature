Feature: Compose and send an email in Gmail
  As a user of the Gmail
  I want to be able to log in with my account
  So that I can access my email account and compose email

  Background:
    Given I am on the Gmail login page

  Scenario: User can compose and send an email
    Given the user is logged into Gmail account
    When the user clicks on the "Compose" button
    And the user enters "recipient@example.com" in the recipient field
    And the user enters "Incubyte" in the subject field
    And the user enters "Automation QA test for Incubyte" in the body field
    And the user clicks on the "Send" button
    Then the email is sent successfully
    And the email appears in the "Sent" folder
    And the email subject is "Incubyte"
    And the email body is "Automation QA test for Incubyte"