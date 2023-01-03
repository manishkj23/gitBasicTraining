package com.test.utils;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
//@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
//        excludeCoverageTags = {"@wip" },
//        includeCoverageTags = {"@completed" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json","rerun:target/rerun.txt","usage:target/cucumber-usage.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "rerun:target/rerun.txt"},
        glue = {"classpath:com/test/steps","cl asspath:com/test/utils/Hooks"},
//        features={"src/test/resources/features/OrbitRegressionPack.feature"},
        //features={"src/test/resources/features.FeatureFiles/Srv9487BekoFaultCode.feature"}
        //features={"src/test/resources/features.FeatureFiles/dataCreation.feature"}
        //features={"src/test/resources/features.FeatureFiles/siteMap.feature"}
        //tags = {"@SIT1"}
        features={"src/test/resources/features.FeatureFiles/InflightCustomerInteractionHistory.feature"}

)
//        features = "src/test/resources/features")
public class TestRunner{

}
