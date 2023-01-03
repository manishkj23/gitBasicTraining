package com.test.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "@target/rerun.txt", //Cucumber picks the failed scenarios from this file
        glue = {"classpath:com/test/steps","classpath:com/test/utils/Hooks"},
        format = {"pretty", "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"}
)
public class RerunTestRunner {
}
