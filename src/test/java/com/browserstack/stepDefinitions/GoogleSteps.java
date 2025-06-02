package com.browserstack.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class GoogleSteps {
    private WebDriver driver;
    
    public GoogleSteps() {
        this.driver = CucumberTest.getDriver();
    }

    @Given("I open the Google homepage")
    public void i_open_the_google_homepage() {
        driver.get("https://www.google.com");
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    }

    @Then("The page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle),
                   "Page title does not contain " + expectedTitle);
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(
                "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}"
            );
        }
    }
}
