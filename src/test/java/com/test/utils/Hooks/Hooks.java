package com.test.utils.Hooks;


import com.test.steps.OrbitHomePageStepDef;
import com.test.utils.BasePage;
import com.test.utils.GetScenarioDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private BasePage base;
    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
    private SeleniumHelper seleniumHelper;
    private GetScenarioDetails getScenarioDetails;
    private OrbitHomePageStepDef orbitHomePageStepDef;



    public Hooks(BasePage base, SeleniumHelper seleniumHelper, GetScenarioDetails getScenarioDetails,OrbitHomePageStepDef orbitHomePageStepDef) {
        this.base = base;
        this.driver = this.base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.getScenarioDetails = getScenarioDetails;
        this.orbitHomePageStepDef = orbitHomePageStepDef;
    }

    //    @Before(order = 0)
    @Before(order = 0)
    public void beforeMethod(Scenario scenario) {
        LOGGER.info("======>>> Test Started : " + scenario.getName());
        this.driver = base.getDriver();
        getScenarioDetails.setScenario(scenario.getName());
        base.scenarioName = getScenarioDetails.getScenario();
        base.myScenario = scenario;
    }

    @Before(order = 1)
//    @BeforeStep(order = 1)
    public void StartRecording(Scenario scenario) {

        try {
            if (base.prop.getProperty("enableVideoRecording").equals("true")) {
                LOGGER.info("======>>> Test Recoding Started : " + scenario.getName());
                seleniumHelper.startRecording(base.scenarioName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterStep(order = 0)
    public void captureScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LOGGER.info(scenario.getName() + "==>>> TEST FAILED");
        } else {
            LOGGER.info(scenario.getName() + "==>>> TEST PASSED");
        }
        LOGGER.info("======>>> End - Of - Test : " + scenario.getName());
        // capture the screenshot if the test fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png");
            scenario.attach(screenshot, "image/png", scenario.getName());


        } else {
            if (base.prop.getProperty("attachAllScreenshots").equalsIgnoreCase("true")) {
                scenario.attach(base.allScreenshots, "image/png", scenario.getName());
            } else {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }
        base.waitFor();
        if (driver != null) {
            LOGGER.info("=====>>>> ( ... Close : ChromeDriver.exe...)");
            driver.quit();


        }
    }

    @After(order = 1)
    public void StopRecording(Scenario scenario) {

        try {
            if (base.prop.getProperty("enableVideoRecording").equals("true")) {
                LOGGER.info("======>>> Test Recoding Stopped : " + scenario.getName());
                seleniumHelper.stopRecording();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After(order=2, value="@RECIPERO")
    public void revertReciperoConfig(){
        orbitHomePageStepDef.iRevertTheReciperoHookToTheLiveURL();
    }
}