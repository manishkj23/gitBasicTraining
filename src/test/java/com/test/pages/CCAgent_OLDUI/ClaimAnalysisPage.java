package com.test.pages.CCAgent_OLDUI;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClaimAnalysisPage {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//div[@id=\"stepMenuTitleSpan\"][contains(.,\"CLAIM ANALYSIS\")]")
    private WebElement claimAnalysisPageTitle;


    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    private WebElement jobCompletedStatus;

    @FindBy(xpath = "//div[@id=\"SystemNotesPanel\" and contains(.,\"Claim Analysis\")]//table[@class=\"no-bg-table ca_table\"]/tbody/tr[contains(.,\"Completion Status\")]/td[2][contains(.,\"COMPLETE JOB\")]")
    private WebElement claimAnalysisCompletetionStatus;

    @FindBy(xpath = "//table[@class=\"no-bg-table ca_table\"]//tbody//tr/td[.=\"Total Cost\"]/../td[2]")
    private WebElement totalCostValue;

    public ClaimAnalysisPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        PageFactory.initElements(driver, this);
    }

    public boolean isClaimAnalysisPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(claimAnalysisPageTitle) && claimAnalysisPageTitle != null) {
                status = true;
            } else {
                base.refreshPage();
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(claimAnalysisPageTitle) && claimAnalysisPageTitle != null) {
                    status = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isJobCompletionStatusUpdated() {
        boolean status = false;
        try {
            base.checkIfELementIsAvailable(jobCompletedStatus);
            if (jobCompletedStatus.getText().contains("REPAIR COMPLETED")) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isJobCompletionStatusUpdated(String jobStatus) {
        boolean status = false;
        try {
            base.checkIfELementIsAvailable(jobCompletedStatus);
            if (jobCompletedStatus.getText().contains(jobStatus)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getTotalCostValue() {
        String value = null;
        try {
            if (base.checkIfELementIsAvailable(totalCostValue)) {
                value = totalCostValue.getText().trim();
                base.highlightElement(totalCostValue);
            } else {
                base.waitForPageToLoad();
                base.hardWait("2000");
                if (base.checkIfELementIsAvailable(totalCostValue)) {
                    value = totalCostValue.getText().trim();
                    base.highlightElement(totalCostValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
