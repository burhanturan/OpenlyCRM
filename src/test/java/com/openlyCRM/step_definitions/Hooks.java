package com.openlyCRM.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */

import com.openlyCRM.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
    @Before(order = 1)
    public void setupScenario() {
    }

    @Before(value = "@login", order = 2)
    public void setupScenarioForLogins() {
    }

    @Before(value = "@db", order = 0)
    public void setupForDatabaseScenarios() {
    }


    @After
    public void teardownScenario(Scenario scenario) {

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

    @BeforeStep
    public void setupStep() {
    }

    @AfterStep
    public void afterStep() {
    }


}
