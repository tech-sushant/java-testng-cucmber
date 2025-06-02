package com.browserstack;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = {"com.browserstack", "com.browserstack.stepDefinitions"},
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        }
)
public class RunWebDriverCucumberTests extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}