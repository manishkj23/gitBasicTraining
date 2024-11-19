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

public class AuthorityLineSummaryPage {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;
    private CancelClaimPage cancelClaimPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//div[contains(@onclick,\"loadSchemeData()\")]")
    private WebElement schemeIcon;

    @FindBy(name = "spdMessagesDetails_length")
    private WebElement schemeMsgsLengthToAll;


    private static String planMessagesTextAreaXpath = "//table[@id=\"spdMessagesDetails\"]//tbody/tr[contains(.,\"Claim ${value} Call Out Charge Cost Collected\")]";


    public AuthorityLineSummaryPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage,
                                    CancelClaimPage cancelClaimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        this.cancelClaimPage = cancelClaimPage;
        PageFactory.initElements(driver, this);
    }


    public boolean isAuthorityLineSummaryPageDisplayed() {
        boolean status = false;
        try {
            if(base.checkIfELementIsAvailable(schemeIcon) && schemeIcon.isDisplayed()) {
                base.highlightElement(schemeIcon);
                status = true;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;

    }


    public boolean isExcessPaymentStampedOnScheme(String claimNo) {
        boolean status = false;
        try {
            base.waitTillElementFound(schemeIcon);
            base.isClickable(schemeIcon);
            base.clickWithJsExecutor(schemeIcon);
            base.waitTillElementFound(schemeMsgsLengthToAll);
            base.selectTextByValue(schemeMsgsLengthToAll,"-1");
            WebElement planMsg = seleniumHelper.getCustomElementByXpath(planMessagesTextAreaXpath,claimNo);
            if(base.checkIfELementIsAvailable(planMsg)) {
                base.highlightElement(planMsg);
                status = true;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;

    }
}