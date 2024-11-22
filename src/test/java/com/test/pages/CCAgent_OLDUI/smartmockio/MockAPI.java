package com.test.pages.CCAgent_OLDUI.smartmockio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockAPI {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public MockAPI(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-cy=\"sign-in-form\"]//input[@name=\"username\"]")
    private WebElement userName;

    @FindBy(xpath = "//div[@data-cy=\"sign-in-form\"]//input[@name=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//button[contains(.,\"Sign in\")]")
    private WebElement signinButton;

    @FindBy(xpath = "//div[@id=\"workspaces-list\"]//h6[@title=\"ORB\"]")
    private WebElement workSpaceORB;

    @FindBy(xpath = "//div[@data-cy=\"workspace-mock-list\"]/div[contains(.,\"OrbitAuto\")]")
    private WebElement selectCreatedMockOrbitAuto;

    @FindBy(xpath = "//*[@id=\"path\"]")
    private WebElement path;

    @FindBy(xpath = "//*[@id=\"static1\"]/div[2]/div")
    private WebElement respBodyFull;

    @FindBy(xpath = "//*[@id=\"static1\"]/div[2]/div/div[2]/div[1]")
    private WebElement respBodyFirstLine;

    @FindBy(xpath = "//button[contains(.,\"Save (Ctrl+S)\")]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"dashboard-root\"]/div/div/div[2]/span[contains(.,\"Mock saved\")]")
    private WebElement mockSavedSpanElement;


    public void loginToMockServer() {
        try {
            base.navigateToPage(base.prop.getProperty("SMARTMOCKURL"));
//            base.waitForPageToLoad();
            if (!isSmartMockLoginPageLoaded()) {
                base.hardWait("3000");
                base.navigateToPage(base.prop.getProperty("SMARTMOCKURL"));
                base.waitForPageToLoad();
            }
            base.sendFieldInputData(userName, base.prop.getProperty("sm_user"));
            base.sendFieldInputData(password, base.prop.getProperty("sm_password"));
            if (base.isClickable(signinButton)) {
                base.clickElement(signinButton);
            } else {
                base.hardWait("2000");
                base.isClickable(signinButton);
                base.clickElement(signinButton);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSmartMockLoginPageLoaded() {
        boolean status = false;
        try {
            if (userName.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isSmartMockDashboardPageLoaded() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(workSpaceORB)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private void selectOrbWorkspace() {
        if (base.checkIfELementIsAvailable(workSpaceORB)) {
            base.clickElement(workSpaceORB);
        } else {
            base.waitForElementVisible(workSpaceORB);
            base.clickElement(workSpaceORB);
        }
    }

    private void selectTheMock() {
        if (base.checkIfELementIsAvailable(selectCreatedMockOrbitAuto)) {
            base.clickElement(selectCreatedMockOrbitAuto);
        } else {
            base.waitForElementVisible(selectCreatedMockOrbitAuto);
            base.clickElement(selectCreatedMockOrbitAuto);
        }
    }

    private void enterMockPathUrl(String url) {
        base.waitForElementVisible(path);
        seleniumHelper.actionSelectAllAndDelete(path);
        base.hardWait("3000");
        path.click();
        path.sendKeys(url);
        path.clear();
        path.sendKeys(url);

    }

    private void enterResponseDataAndSave(String jsonArray) {
        if (!respBodyFull.getText().isEmpty()) {
            seleniumHelper.actionSelectAllAndDelete(respBodyFull);
            commonUtils.setClipboardContentAndPasteDateToElement(jsonArray, respBodyFirstLine);
//            seleniumHelper.actionSelectAllAndDelete(respBodyFirstLine);
//            base.hardWait("2000");
//            respBodyFirstLine.sendKeys(jsonArray);
//            base.highlightElement(respBodyFirstLine);
//            Actions act = new Actions(driver);
//            act.click(respBodyFirstLine);
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("editor.setValue('"+jsonArray+"');");
//
//            //            base.sendFieldInputData(respBodyFirstLine,jsonArray);
            base.isClickable(saveButton);
            base.clickElement(saveButton);
        }
    }

    public boolean isResponseSaved() {
        boolean status = false;
        try {
            if (base.isElementAvailable(mockSavedSpanElement)) {
                base.highlightElement(mockSavedSpanElement);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isRespnseDataPastedOnTheTextArea(String jsonArray) {
        boolean status = false;
        seleniumHelper.actionToCopyDataFromTextAreaCTRL_C(respBodyFull);
        base.hardWait("1000");
        String currentResp = commonUtils.getClipboardContentToString();
        try {
            if (base.isElementAvailable(respBodyFull) && currentResp.contains(jsonArray)) {

                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public void createMockApi(String url, String jsonArray) {
        selectOrbWorkspace();
        selectTheMock();
        enterMockPathUrl(url);
        enterResponseDataAndSave(jsonArray);
    }

    public String beutifyJsonString(String jsonArray) {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(jsonArray);
        String jsonArrayNew = gson.toJson(el);
        return jsonArrayNew;
    }
}