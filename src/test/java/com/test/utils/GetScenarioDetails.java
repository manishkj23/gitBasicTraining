package com.test.utils;

import org.openqa.selenium.WebDriver;

public class GetScenarioDetails {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;
    private String scenario;

    public GetScenarioDetails(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        this.commonUtils = commonUtils;
    }


    public void setScenario(String scenario) {
        this.scenario = scenario.replaceAll("[^a-zA-Z0-9]", "");
    }

    public String getScenario(){
        if (this.scenario == null) {
            return this.scenario;
        } else {
            return this.scenario;
        }

    }

}