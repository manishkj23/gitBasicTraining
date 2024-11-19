package com.test.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TestDataGenerate extends BasePage {
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    //private static final Logger LOGGER = LoggerFactory.getLogger(TestClass.class);

    public void generateReport() {
        BasePage base = new BasePage();
        SeleniumHelper seleniumHelper = new SeleniumHelper(base);
        seleniumHelper.generateBDDReport();
    }


    public void createContractApiCall() throws Exception {
        BasePage base = new BasePage();
        SeleniumHelper seleniumHelper = new SeleniumHelper(base);
        CommonUtils cm = new CommonUtils(base, seleniumHelper);
        String PlanNo = cm.createContractApiCallForElux();
        System.out.println(PlanNo);
    }


    public void generateBDDReport() {
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");
        String buildNo = "1";
        Configuration configuration = new Configuration(reportOutputDirectory, "ORBIT UI Automation Pack");
        configuration.setBuildNumber(buildNo);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//        Reportable result = reportBuilder.generateReports();
        Reportable result = reportBuilder.generateReports();

    }

}