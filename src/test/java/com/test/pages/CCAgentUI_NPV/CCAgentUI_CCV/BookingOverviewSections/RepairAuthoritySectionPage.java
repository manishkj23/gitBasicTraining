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

public class RepairAuthoritySectionPage {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;
    private CancelClaimPage cancelClaimPage;
    public AuthorityLineSummaryPage authorityLineSummaryPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//div[contains(@id,\"right_header\")][contains(.,\"Repair Authority\")]")
    private WebElement sectionHeaderText;

    @FindBy(name = "PlanMessages_length")
    private WebElement selectPlanMsgsLengthToAll;

    @FindBy(xpath = "//div[@id=\"RAStatusElement\"]//a[contains(.,\"Authority Line Summary Page\")]")
    private WebElement authorityLineSummaryPageLinkToClick;

    private static String planMessagesTextAreaXpath = "//table[@id=\"PlanMessages\"]//tr[contains(.,\"Claim ${value} Call Out Charge Cost Collected\")]//td[3]";


    public RepairAuthoritySectionPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage,
                                      CancelClaimPage cancelClaimPage, AuthorityLineSummaryPage authorityLineSummaryPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        this.cancelClaimPage = cancelClaimPage;
        this.authorityLineSummaryPage = authorityLineSummaryPage;
        PageFactory.initElements(driver, this);
    }


    public boolean isRepairAuthorityPageDisplayed() {
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


    public void clickAuthorityLineSummaryLink() {

        try {
            if(base.isClickable(authorityLineSummaryPageLinkToClick)){
                base.clickElement(authorityLineSummaryPageLinkToClick);
            } else {
                LOGGER.info("Unable to click the Link for Authority Line Summary");
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }

    }
}