package com.test.utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        monochrome = true,
        features = "@target/rerun.txt", //Cucumber picks the failed scenarios from this file
        glue = {"classpath:com/test/steps", "classpath:com/test/utils/Hooks", "classpath:/resources/features"},
        plugin = {"pretty", "html:target/site/cucumber-pretty",
                "html:target/cucumber-report.html",
                "usage:target/cucumber-usage.json",
                "json:target/reruncucumber.json"}
)

public class RerunTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}