package com.test.utils.Hooks;


import com.test.utils.BasePage;
import com.test.utils.GetScenarioDetails;
import com.test.utils.SeleniumHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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

    public Hooks(BasePage base, SeleniumHelper seleniumHelper, GetScenarioDetails getScenarioDetails) {
        this.base = base;
        this.driver = this.base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.getScenarioDetails = getScenarioDetails;
    }

    @Before (order = 0)
    public void beforeMethod(Scenario scenario) {
        LOGGER.info("======>>> Test Started : " + scenario.getName());
        this.driver = base.getDriver();
        getScenarioDetails.setScenario(scenario.getName());
        base.scenarioName = getScenarioDetails.getScenario();
    }

    @Before(order = 1)
    public void StartRecording(Scenario scenario) {

        try {
            if(base.prop.getProperty("enableVideoRecording").equals("true")) {
                LOGGER.info("======>>> Test Recoding Started : " + scenario.getName());
                seleniumHelper.startRecording(base.scenarioName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After (order = 0)
    public void tearDown(Scenario scenario) {
        LOGGER.info("======>>> End - Of - Test : " + scenario.getName());
        // capture the screenshot if the test fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
//        try {
//            if(base.prop.getProperty("enableVideoRecording").equals("true")) {
//                seleniumHelper.stopRecording();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        base.waitFor();
        if(driver!=null) {
            LOGGER.info("=====>>>> ( ... Close : ChromeDriver.exe...)");
            driver.quit();

        }
    }
    @After(order = 1)
    public void StopRecording(Scenario scenario) {

        try {
            if(base.prop.getProperty("enableVideoRecording").equals("true")) {
                LOGGER.info("======>>> Test Recoding Stopped : " + scenario.getName());
                seleniumHelper.stopRecording();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @After(order = 1)
//    public void killDriver(Scenario scenario){
////        try {
////            if(base.prop.getProperty("enableVideoRecording").equals("true") &&  base.prop.getProperty("browserState").isEmpty()) {
////                LOGGER.info("=====>>>> ( ... Killing Process : ChromeDriver.exe...)");
////                Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
}