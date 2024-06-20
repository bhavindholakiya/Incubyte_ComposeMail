
# Automated Testing of Gmail Compose Functionality

This repository contains automated tests for the Gmail compose functionality using Selenium WebDriver and Cucumber in Java. The tests simulate composing and sending an email on Gmail.

## Prerequisites
* Java JDK 8 or higher installed
* Maven installed
* Chrome browser installed

## Setup Instructions
#### 1. Clone the repository
```
git clone https://github.com/bhavindholakiya/Incubyte_ComposeMail.git
cd Incubyte_ComposeMail
```
### 2. Running the Tests:
* To run the tests, execute the following Maven command:
```
mvn test
```
## Important Notes
* Email and Password Setup:
  * Before running the tests, ensure you have set your Gmail credentials directly in the properties file (**`'GlobalData.properties'`**).
  * Locate the following lines in **`src/test/java/resources/GlobalData.properties`**:
    ```
    email = "your_email@gmail.com";
    password = "your_password";
    ```
    Replace `your_email@gmail.com` and `your_password` with your actual Gmail credentials.

## Test Structure
* **Feature File: `src/test/resources/features/compose_email.feature`**
    * Contains Cucumber scenarios specifying various test cases for composing and sending emails.

* **Step Definitions: `src/test/java/com/incubyte/stepsDefs/ComposeEmailSteps.java`**

    * Implements the Cucumber step definitions for the scenarios defined in compose_email.feature.
    * Uses Selenium WebDriver to interact with the Gmail web interface.

* **Test Runner: `src/test/java/com/incubyte/runner/TestRunner.java`**

  * Configures the execution of Cucumber tests using TestNG.

## Additional Information
For any issues or questions, please contact **Bhavin Dholakiya** at **bhavin7023@gmail.com**.
