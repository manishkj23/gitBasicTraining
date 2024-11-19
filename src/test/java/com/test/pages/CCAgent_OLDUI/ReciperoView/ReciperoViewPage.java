package com.test.pages.CCAgent_OLDUI.ReciperoView;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReciperoViewPage {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ReciperoViewPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@role=\"dialog\"]//span[contains(.,\"Recipero Report View\")]")
    private WebElement reciperoViewReportTitle;

    @FindBy(xpath = "//*[@role=\"dialog\"]//span[contains(.,\"Plan No\")]/../span[2]")
    private WebElement planNo;

    @FindBy(xpath = "//*[@role=\"dialog\"]//span[contains(.,\"Claim No\")]/../span[2]")
    private WebElement claimNo;

    @FindBy(xpath = "//*[@role=\"dialog\"]//span[contains(.,\"Customer\")]/../span[2]")
    private WebElement customer;

    @FindBy(xpath = "//*[@role=\"dialog\"]//a[contains(.,\"Refresh Data\")]")
    private WebElement refreshDataButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Theft Records\")]//img")
    private WebElement theftRecordButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Theft Records\")]//img/../../fieldset")
    private WebElement theftRecordSectionToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Blocking Records\")]//img")
    private WebElement blockingRecordButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Blocking Records\")]//img/../../fieldset")
    private WebElement blockingRecordSectionToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Claim History\")]//img")
    private WebElement claimHistoryButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Claim History\")]//img/../../fieldset")
    private WebElement claimHistorySectionToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Search History\")]//img")
    private WebElement searchHistoryButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Search History\")]//img/../../fieldset")
    private WebElement searchHistorySectionToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Ownership\")]//img")
    private WebElement ownershipButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Ownership\")]//img/../../fieldset")
    private WebElement ownershipSectionToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Loss Records\")]//img")
    private WebElement lossRecordsButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Loss Records\")]//img/../../fieldset")
    private WebElement lossRecordsSectionToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Found Records\")]//img")
    private WebElement foundRecordsButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Found Records\")]//img/../../fieldset")
    private WebElement foundRecordsToggleValue;

    @FindBy(xpath = "//*[@role=\"dialog\"]//a[contains(.,\"Close Page\")]")
    private WebElement closePageButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Device Details\")]//div[contains(.,\"FMIP\")]/b/../text()[4]")
    private WebElement fmipStatus;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Device Details\")]//div[contains(.,\"Model\")]/b/../text()[2]")
    private WebElement modelRecipero;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"Device Details\")]//div[contains(.,\"Blocked\")]/b/../text()[6]")
    private WebElement blockedStatusRecipero;

    @FindBy(xpath = "//*[@role=\"dialog\"]//li[contains(.,\"CheckMEND\")]//div[contains(.,\"Result\")]/b/../text()[2]")
    private WebElement checkMENDResult;

    @FindBy(xpath = "//table[@id=\"recipero_data_block\"]//tbody/tr[1][contains(.,\"Block\")]")
    private WebElement blockRecord;

    @FindBy(xpath = "//table[@id=\"recipero_data_stolen\"]//tbody/tr[1][contains(.,\"DGPolice\")]")
    private WebElement stolenRecord;

    @FindBy(xpath = "//table[@id=\"recipero_data_loss\"]//tbody/tr[1][contains(.,\"DGPolice\")]")
    private WebElement lossRecord;


//    @FindBy(xpath = "")


    public boolean isReciperoViewPageDisplayed() {
        boolean status = false;
        try {

            if (reciperoViewReportTitle.isDisplayed()) {
                base.highlightElement(reciperoViewReportTitle);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getIMEIStatus() {
        String status = null;
        try {
            base.waitForElementVisible(blockedStatusRecipero);
            if (blockedStatusRecipero != null && blockedStatusRecipero.isDisplayed()) {
                status = blockedStatusRecipero.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getFMIStatus() {
        String status = null;
        try {
            base.waitForElementVisible(fmipStatus);
            if (fmipStatus != null && fmipStatus.isDisplayed()) {
                status = fmipStatus.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getModelDetails() {
        String status = null;
        try {
            base.waitForElementVisible(modelRecipero);
            if (modelRecipero != null && modelRecipero.isDisplayed()) {
                status = modelRecipero.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isIMEIBlocked() {
        boolean status = false;
        try {
            base.waitForElementVisible(blockedStatusRecipero);
            if (blockedStatusRecipero != null && blockedStatusRecipero.isDisplayed() && blockedStatusRecipero.getText().equalsIgnoreCase("Yes")) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean hasBlockedHistoryRecordsExist() {

        boolean status = false;
        try {
            base.waitForElementVisible(blockingRecordButton);
            if (blockingRecordButton != null && blockingRecordButton.isDisplayed() && base.isClickable(blockingRecordButton)) {
                base.clickElement(blockingRecordButton);
                if (blockRecord != null && base.checkIfELementIsAvailable(blockRecord)) {
                    base.highlightElement(blockRecord);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean hasTheftRecordsHistoryExist() {
        boolean status = false;
        try {
            base.waitForElementVisible(theftRecordButton);
            if (theftRecordButton != null && theftRecordButton.isDisplayed() && base.isClickable(theftRecordButton)) {
                base.clickElement(theftRecordButton);
                if (stolenRecord != null && base.checkIfELementIsAvailable(stolenRecord)) {
                    base.highlightElement(stolenRecord);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public boolean hasLossRecordsHistoryExist() {
        boolean status = false;
        try {
            base.waitForElementVisible(lossRecordsButton);
            if (lossRecordsButton != null && lossRecordsButton.isDisplayed() && base.isClickable(lossRecordsButton)) {
                base.clickElement(lossRecordsButton);
                if (lossRecord != null && base.checkIfELementIsAvailable(lossRecord)) {
                    base.highlightElement(lossRecord);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }
}