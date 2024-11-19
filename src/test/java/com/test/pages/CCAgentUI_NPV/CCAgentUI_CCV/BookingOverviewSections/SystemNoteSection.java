package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewSections;

import com.test.pages.CCAgent_OLDUI.CancelClaimPage;
import com.test.pages.CCAgent_OLDUI.DialogPoppupPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemNoteSection {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;
    private CancelClaimPage cancelClaimPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//div[contains(@id,\"right_header\")][contains(.,\"System Note\")]")
    private WebElement sectionHeaderText;

    @FindBy(xpath = "//table[@id=\"ContactHistory\"]//tr[contains(.,\"Excess payment \")]//td[4]")
    private WebElement excessPaymentSystemNote;

    @FindBy(xpath = "//table[@id=\"ContactHistory\"]//tr[contains(.,\"Claim Booked via Self Signposting\")]//td[4]")
    private WebElement claimBookedViaSelfSignpostingSystemNote;

    @FindBy(name = "PlanMessages_length")
    private WebElement selectPlanMsgsLengthToAll;

//   private static String planMessagesTextAreaXpath = "//table[@id=\"PlanMessages\"]//tr[contains(.,\"Claim ${value} Call Out Charge Cost Collected\")]//td[3]";


    public SystemNoteSection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage,
                             CancelClaimPage cancelClaimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        this.cancelClaimPage = cancelClaimPage;
        PageFactory.initElements(driver, this);
    }


    public boolean isSystemNoteSectionDisplayed() {
        boolean status = false;
        try {
            if(base.checkIfELementIsAvailable(sectionHeaderText)) {
                status = true;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;

    }


    public boolean isExcessPaymentDisplayedOnSystemNote(String excessAmount) {
        boolean status = false;
        try {
            if(base.checkIfELementIsAvailable(excessPaymentSystemNote) &&
                    excessPaymentSystemNote.getText().contains("Reference:") &&
                    excessPaymentSystemNote.getText().contains("£") &&
                    excessPaymentSystemNote.getText().contains(excessAmount)) {
                base.highlightElement(excessPaymentSystemNote);
                status = true;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public boolean isSystemNoteShowsClaimBookedViaSelfSignposting() {
        boolean status = false;
        try {
            if(base.checkIfELementIsAvailable(claimBookedViaSelfSignpostingSystemNote) &&
                    claimBookedViaSelfSignpostingSystemNote.isDisplayed()) {
                base.highlightElement(claimBookedViaSelfSignpostingSystemNote);
                status = true;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;

    }
//
//    public boolean isExcessPaymentStampedOnScheme(String claimNo) {
//        boolean status = false;
//        try {
//            base.selectTextByValue(selectPlanMsgsLengthToAll,"-1");
//            WebElement planMsg = seleniumHelper.getCustomElementByXpath(planMessagesTextAreaXpath,claimNo);
//            if(base.checkIfELementIsAvailable(planMsg)) {
//                status = true;
//            }
//        } catch ( Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//
//    }
}