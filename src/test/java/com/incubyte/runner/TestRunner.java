package com.incubyte.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/resources",
        glue = {"com.incubyte.stepsDefs"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        publish = true )

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
