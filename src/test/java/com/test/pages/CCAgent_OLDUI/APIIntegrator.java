package com.test.pages.CCAgent_OLDUI;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.ProjectDefaults;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APIIntegrator {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//table[@id=\"externalAPIDashboard\"]//tr[contains(.,\"Recipero Search\")]/td[2]")
    private WebElement reciperoSearchHook;

    @FindBy(xpath = "//table[@id=\"externalAPIDashboard\"]")
    private WebElement externalApiDashoardTable;

    @FindBy(xpath = "//a[@class=\"DTTT_button btnStandard\"]/span[contains(.,\"Edit\")]")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"Endpoint\"]")
    private WebElement endPointUrl;

    @FindBy(xpath = "//button[@id=\"saveBtn\"]")
    private WebElement saveButton;

    @FindBy(xpath = "//table[@id=\"externalAPIDashboard\"]//tr[contains(.,\"Recipero Search\")]/td[3]")
    private WebElement reciperoSearchHookURLUpdated;

    public APIIntegrator(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    private void navigateToApiIntegratorPage() {
        base.navigateToPage(base.prop.getProperty("APIINTEGRATOR"));
    }

    private void navigateToApiIntegratorPageInNewTab() {
        base.navigateToaNewTab(base.prop.getProperty("APIINTEGRATOR"));
    }

    private boolean isApiIntegratorPageLoaded() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(externalApiDashoardTable)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private boolean isUpdateApiConsumerPageLoaded() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(endPointUrl)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isReciperoSearchUrlUpdated(String url) {
        boolean status = false;
        try {
            base.hardWait("3000");
            base.waitForElementVisible(reciperoSearchHookURLUpdated);
            if (reciperoSearchHookURLUpdated.getText().equals(url)) {
                base.highlightElement(reciperoSearchHookURLUpdated);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void setNewApiHookForReciperoSearch(String url) {
        navigateToApiIntegratorPage();
        if (isApiIntegratorPageLoaded()) {
            base.waitForElementVisible(reciperoSearchHook);
            base.clickElement(reciperoSearchHook);
            base.clickElement(editButton);
            if (isUpdateApiConsumerPageLoaded()) {
                base.sendFieldInputData(endPointUrl, url);
                base.waitForElementVisible(saveButton);
                base.clickElement(saveButton);
            } else {
                LOGGER.info("==============>>>>>> API Integrator Page not loaded");
            }
        } else {
            base.hardWait("3000");
            navigateToApiIntegratorPage();
            if (isApiIntegratorPageLoaded()) {
                base.waitForElementVisible(reciperoSearchHook);
                base.clickElement(reciperoSearchHook);
                base.clickElement(editButton);
                if (isUpdateApiConsumerPageLoaded()) {
                    base.sendFieldInputData(endPointUrl, url);
                    base.waitForElementVisible(saveButton);
                    base.clickElement(saveButton);
                } else {
                    LOGGER.info("==============>>>>>> API Integrator Page not loaded");
                }
            } else {
                LOGGER.info("==============>>>>>> API Integrator Page not loaded");
            }
        }
    }

    public String getReciperoURL(String claimType) {
        String url;
        switch (claimType.toUpperCase()) {
            case "STOLEN":
            case "THEFT": {
                url = ProjectDefaults.RECIPEROMOCK_STOLEN;
                break;
            }
            case "LOSS": {
                url = ProjectDefaults.RECIPEROMOCK_LOSS;
                break;
            }
            default: {
                url = ProjectDefaults.RECIPERO_LIVE;
                break;
            }
        }
        return url;
    }

    public void setNewApiHookForReciperoSearchInANewChromeTab(String claimType, String make, String model) {
        navigateToApiIntegratorPageInNewTab();

        if (isApiIntegratorPageLoaded()) {
            base.waitForElementVisible(reciperoSearchHook);
            base.clickElement(reciperoSearchHook);
            base.clickElement(editButton);
            if (isUpdateApiConsumerPageLoaded()) {

                base.sendFieldInputData(endPointUrl, getReciperoURL(claimType) + "?make=" + make + "&model=" + model.replace(" ", "+"));
                base.waitForElementVisible(saveButton);
                base.clickElement(saveButton);
            } else {
                LOGGER.info("==============>>>>>> API Integrator Page not loaded");
            }
        } else {
            base.hardWait("3000");
            navigateToApiIntegratorPage();
            if (isApiIntegratorPageLoaded()) {
                base.waitForElementVisible(reciperoSearchHook);
                base.clickElement(reciperoSearchHook);
                base.clickElement(editButton);
                if (isUpdateApiConsumerPageLoaded()) {
                    base.sendFieldInputData(endPointUrl, getReciperoURL(claimType) + "?make=" + make + "&model=" + model.replace(" ", "+"));
                    base.waitForElementVisible(saveButton);
                    base.clickElement(saveButton);
                } else {
                    LOGGER.info("==============>>>>>> API Integrator Page not loaded");
                }
            } else {
                LOGGER.info("==============>>>>>> API Integrator Page not loaded");
            }
        }
    }

    public void setNewApiHookForReciperoSearchInANewChromeTab(String url) {
        navigateToApiIntegratorPageInNewTab();

        if (isApiIntegratorPageLoaded()) {
            base.waitForElementVisible(reciperoSearchHook);
            base.clickElement(reciperoSearchHook);
            base.clickElement(editButton);
            if (isUpdateApiConsumerPageLoaded()) {
                base.sendFieldInputData(endPointUrl, url);
                base.waitForElementVisible(saveButton);
                base.clickElement(saveButton);
            } else {
                LOGGER.info("==============>>>>>> API Integrator Page not loaded");
            }
        } else {
            base.hardWait("3000");
            navigateToApiIntegratorPage();
            if (isApiIntegratorPageLoaded()) {
                base.waitForElementVisible(reciperoSearchHook);
                base.clickElement(reciperoSearchHook);
                base.clickElement(editButton);
                if (isUpdateApiConsumerPageLoaded()) {
                    base.sendFieldInputData(endPointUrl, url);
                    base.waitForElementVisible(saveButton);
                    base.clickElement(saveButton);
                } else {
                    LOGGER.info("==============>>>>>> API Integrator Page not loaded");
                }
            } else {
                LOGGER.info("==============>>>>>> API Integrator Page not loaded");
            }
        }
    }
}
