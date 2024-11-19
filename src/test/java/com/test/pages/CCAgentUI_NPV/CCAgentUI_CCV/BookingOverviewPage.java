package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV;

import com.test.pages.CCAgentUI_NPV.BookingOverview.ChangeClaimTypePopup;
import com.test.pages.CCAgentUI_NPV.BookingOverview.ViewAccessories;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewSections.BookingOverviewSubSection;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewSections.RepairAuthoritySectionPage;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewSections.SystemNoteSection;
import com.test.pages.CCAgentUI_NPV.VulnerableCustomer;
import com.test.pages.CCAgent_OLDUI.CancelClaimPage;
import com.test.pages.CCAgent_OLDUI.DialogPoppupPage;
import com.test.pages.CCAgent_OLDUI.ReviewClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BookingOverviewPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;
    private CancelClaimPage cancelClaimPage;
    public ChangeClaimTypePopup changeClaimTypePopup;
    public ViewAccessories viewAccessoriesPage;
    public VulnerableCustomer vulnerableCustomer;
    public RepairAuthoritySection repairAuthority;
    public ReviewClaimPage reviewClaimPage;
    public RepairInformationPage repairInformationPage;
    public BookingOverviewSubSection bookingOverviewSubSection;
    public SystemNoteSection systemNotePage;
    public RepairAuthoritySectionPage repairAuthoritySectionPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@id=\"JobStatusName\"]")
    private WebElement jobStatusHeader;

    @FindBy(xpath = "//div[@id=\"ui2_top_header\"]//td[contains(.,\"REPAIRER\")]/text()")
    private WebElement repairerNameHeaderArea;

    @FindBy(xpath = "//*[@id=\"JobStatusName\"]/../../td[contains(.,\"CLAIM NO\")]/text()")
    private WebElement currentClaimNumber;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Booking Overview\")]")
    private WebElement bookingOverviewSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Customer Details\")]")
    private WebElement customerDetailsSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Repair Information\")]")
    private WebElement repairInformationSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Repair Authority\")]")
    private WebElement repairAuthoritySection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Customer Communications\")]")
    private WebElement customrCommunicationsSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Attachments\")]")
    private WebElement attachmentsSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Claim History\")]")
    private WebElement claimHistorySection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"System Note\")]")
    private WebElement systemNoteSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Claim Q&A\")]")
    private WebElement claimQandASection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Claim Risk\")]")
    private WebElement claimRiskSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Write Off Authorization\")]")
    private WebElement woAuthorizationSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Service Option\")]")
    private WebElement serviceOptionSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Event Logger\")]")
    private WebElement eventLoggerSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Cancel Claim\")]")
    private WebElement cancelClaimSection;

    //Vulnerable
    @FindBy(xpath = "//div[@class=\"ClaimAlerts\"][contains(.,\"Vulnerable Customer\")]")
    private WebElement vulnerableCustomerIcon;

    @FindBy(xpath = "//div[@onclick=\"ReciperoView()\"]/img")
    private WebElement reciperoIcon;

    @FindBy(id = "ClaimTypenameid")
    private WebElement claimTypeDisplayed;

    @FindBy(xpath = "//button[@onclick=\"changeClaimType()\"]")
    private WebElement changeClaimTypeButton;

    @FindBy(xpath = "//button[@onclick=\"displayAccessories()\"]")
    private WebElement viewAccessoriesBtn;

    @FindBy(xpath = "//div[@id=\"ui2_top_claim_banner\"][contains(.,\"ACCESSORY ONLY REPAIR\")]")
    private WebElement accessoryOnlyRepairBanner;

    @FindBy(xpath = "//div[contains(@id,'top_header')]//td[contains(.,'CLAIM NO')]")
    private WebElement currentClaimNo;

    @FindBy(xpath = "//div[@id=\"ui2_left_alerts_holder\"]/div[2]/div[contains(.,'D&G Warranty Repair')]")
    private WebElement dgWarrantyIcon;

    @FindBy(xpath = "//*[@id=\"cboxLoadedContent\"]")
    private WebElement dgWarrantyDetailsPopup;


    @FindBy(xpath = "//table[@id='HeatingReplacement_Table']//tr[3]/td[@class='PlanDataField']")
    private WebElement dgWarrantyRepairclaimNumber;

    @FindBy(xpath = "//*[@id=\"PlanHistory_Claims\"]/table/tbody/tr[2]/td[1]/a")
    private WebElement oldClaimNumber;

    @FindBy(xpath = "//*[@id=\"HeatingReplacement_Table\"]/tbody/tr[10]/td")
    private WebElement dgWarrantyRepairServiceReport;




    //    private static final String leftMenuItem = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"${value}\")]";
    private static final String leftMenuItem = "//div[@id=\"container-main\"]//div[@id=\"ui2_left_nav\"]//div[contains(@id,\"nav\")][contains(.,\"${value}\")]";
    private final String reviewClaimBookingOverviewPath = "//div[@id='ui2_wrapper']//div[@id='ui2_right']//div[@id='ui2_right_header']";
    @FindBy(xpath=reviewClaimBookingOverviewPath)
    private WebElement reviewClaimBookingOverview;

    private final String multipleClaimBoxPath = "//div[@id='toast-container']//div[@class='toast toast-info']//div[@class='toast-title']";
    @FindBy(xpath=multipleClaimBoxPath)
    private WebElement multipleClaimBox;

    private final String multipleClaimBoxCrossPath = "//div[@class='toast toast-info']//button[contains(text(),'×')]";
    @FindBy(xpath=multipleClaimBoxCrossPath)
    private WebElement multipleClaimBoxCross;

    @FindBy(xpath="//div[text()=\"REMEDIAL WORK REQUIRED\"]//ancestor::div[@id=\"cboxLoadedContent\"]")
    private WebElement RemedialWorkRequiredPopUP;

//    private static final String leftMenuItem = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"${value}\")]";

    @FindBy(xpath="//a[contains(text(),'Claim No')]")
    private WebElement claimNoLink;

    @FindBy(xpath="//b[text()='Remedial Work Complete']//ancestor::a")
    private WebElement remedialWorkCompleteIcon;

    @FindBy(xpath="//span[text()='Remedial Work Complete']//ancestor::div[@aria-describedby='modP']")
    private WebElement remedialWorkCompletePopup;

    @FindBy(xpath="//textarea[@id='RemedialWorkCompletedNotes']")
    private WebElement remedialWorkCompleteNotes;

    @FindBy(xpath="//button[text()='Submit']")
    private WebElement submitButton;

    public BookingOverviewPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage,
                               CancelClaimPage cancelClaimPage, ChangeClaimTypePopup changeClaimTypePopup, ViewAccessories viewAccessoriesPage,
                               VulnerableCustomer vulnerableCustomer, RepairAuthoritySection repairAuthority, ReviewClaimPage reviewClaimPage, RepairInformationPage repairInformationPage,
                               BookingOverviewSubSection bookingOverviewSubSection,SystemNoteSection systemNotePage, RepairAuthoritySectionPage repairAuthoritySectionPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        this.cancelClaimPage = cancelClaimPage;
        this.changeClaimTypePopup = changeClaimTypePopup;
        this.viewAccessoriesPage = viewAccessoriesPage;
        this.vulnerableCustomer = vulnerableCustomer;
        this.repairAuthority = repairAuthority;
        this.reviewClaimPage = reviewClaimPage;
        this.repairInformationPage = repairInformationPage;
        this.bookingOverviewSubSection = bookingOverviewSubSection;
        this.systemNotePage = systemNotePage;
        this.repairAuthoritySectionPage = repairAuthoritySectionPage;
        PageFactory.initElements(driver, this);
    }


    @Before
    public void verifyIfNewUIPageIsLoaded() {
        Assert.assertTrue("New CC Agent Portal Not Loaded", jobStatusHeader.isDisplayed());
    }


    public boolean isJobStatusUpdated(String jobStatus) {
        boolean status = false;
        List<String> outCome = Stream.of(jobStatus.split(","))
                .map(String::trim)
                .collect(toList());
        for (String stat : outCome) {
            try {
                if (base.checkIfELementIsAvailable(jobStatusHeader)) {
                    if (jobStatusHeader != null && jobStatusHeader.getText().contains(stat)) {
                        base.highlightElement(jobStatusHeader);
                        status = true;
                        break;
                    }
                } else {
                    base.hardWait("3000");
                    base.waitForElementVisible(jobStatusHeader);
                    if (jobStatusHeader != null && jobStatusHeader.getText().contains(stat)) {
                        base.highlightElement(jobStatusHeader);
                        status = true;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }

    public void cancelClaim() {
        try {
            if (base.checkIfELementIsAvailable(cancelClaimSection) && base.isClickable(cancelClaimSection)) {
                base.clickElement(cancelClaimSection);
                base.waitForPageToLoad();
                cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");
            } else {
                LOGGER.info("Unable to cancel the claim");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickRepairAuthoritySection() {

        try {
            if (base.checkIfELementIsAvailable(repairAuthoritySection) && base.isClickable(repairAuthoritySection)) {
                base.clickElement(repairAuthoritySection);
            } else {
                LOGGER.info("Unable to load Repair Authority Section");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickLeftMenuItem(String sectionName) {
        WebElement menuItem;
        try {
            menuItem = seleniumHelper.getCustomElementByXpath(leftMenuItem, sectionName);
            if (menuItem != null && base.checkIfELementIsAvailable(menuItem) && base.isClickable(menuItem)) {
                base.clickElement(menuItem);
            } else {
                LOGGER.info("Unable to load " + sectionName + " Section");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSubSections(String sectionName) {
        WebElement menuItem;
        try {
            menuItem = seleniumHelper.getCustomElementByXpath(leftMenuItem, sectionName);
            if (menuItem != null && base.checkIfELementIsAvailable(menuItem) && base.isClickable(menuItem)) {
                base.clickElement(menuItem);
            } else {
                LOGGER.info("Unable to load " + sectionName + " Section");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickCustomerCommunicationsSection() {

        try {
            if (base.checkIfELementIsAvailable(customrCommunicationsSection) && base.isClickable(customrCommunicationsSection)) {
                base.clickElement(customrCommunicationsSection);
            } else {
                LOGGER.info("Unable to load Customer Communications Section");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isBookingOverviewSectionDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(bookingOverviewSection)) {
                status = true;
            } else {
                LOGGER.info("Unable to verify the Booking overview Page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickReciperoIcon() {
        base.waitTillElementFound(reciperoIcon);
        base.clickElement(reciperoIcon);
    }

    public boolean isClaimTypeMatched(String claimTyp) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(claimTypeDisplayed) && claimTypeDisplayed.getText().contains(claimTyp)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Claim Type on the Booking Overview page not matched : Expected -" + claimTyp + " Actual -" + claimTypeDisplayed.getText());
        }
        return status;
    }

    public boolean isAccessoryOnlyRepairBannerDisplayed() {
        boolean status = false;
        try {
            if (accessoryOnlyRepairBanner.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void cancelClaimOnly() {
        try {
            cancelClaimPage.confirmClaimCancellation("TEST CLAIM", "Test");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCurrentClaimNo(){
        String claim = null;
        try{
            if(base.checkIfELementIsAvailable(currentClaimNo)){
                claim = currentClaimNo.getText().replace("CLAIM NO:","").trim();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return claim;
    }

    public boolean isBookingOverviewHeaderDisplayed() {
        boolean status = false;
        try {
            if(driver.findElement(By.xpath(multipleClaimBoxPath)).isDisplayed())
            {
                base.clickWithJsExecutor(multipleClaimBoxCross);
                base.highlightElement(reviewClaimBookingOverview);
                status = true;
            }
            else
            {
                base.highlightElement(reviewClaimBookingOverview);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyIfDgWarrantyIconDisplayed() {
        boolean status = false;
        try {
            if (base.isElementAvailable(dgWarrantyIcon)) {
                base.highlightElement(dgWarrantyIcon);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyDgWarrantyDetailsPopup() throws InterruptedException {
        boolean status = false;
        Thread.sleep(2000);
        try {
            base.clickWithJsExecutor(dgWarrantyIcon);
            if (base.isElementAvailable(dgWarrantyDetailsPopup)) {
                base.highlightElement(dgWarrantyDetailsPopup);
                Thread.sleep(3000);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyPreviousClaimDetailsOnDgWarrantyRepairPopup() throws InterruptedException {
        boolean status = false;
        try {
            base.highlightElement(dgWarrantyRepairclaimNumber);
            Thread.sleep(2000);

            String oldClaimNumberOnDGWarrantyPopup = dgWarrantyRepairclaimNumber.getText().substring(9);
            Thread.sleep(3000);
            base.goBack();
//           base.switchToDefaultTab();
            Thread.sleep(5000);
            base.highlightElement(oldClaimNumber);

            String oldClaimNumberOnPlanHistoryTable = oldClaimNumber.getText().substring(6);

            if (oldClaimNumberOnDGWarrantyPopup.equalsIgnoreCase(oldClaimNumberOnPlanHistoryTable)) {
                status = true;
                LOGGER.info("Claim matched with previous claim details. withinWarrantyClaimNumber: " + oldClaimNumberOnDGWarrantyPopup + ", oldClaim: " + oldClaimNumberOnPlanHistoryTable);

            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean verifyServiceReportNotes() {
        boolean status = false;
        try {
            base.highlightElement(dgWarrantyRepairServiceReport);
            String serviceReportNotes = dgWarrantyRepairServiceReport.getText().substring(15);

            if (serviceReportNotes.equalsIgnoreCase("test")) {
                status = true;
                LOGGER.info("Service notes Matched:" + serviceReportNotes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOnClaimNoLink() {
        if (base.checkIfELementIsAvailable(claimNoLink)) {
            base.highlightElement(claimNoLink);
            base.clickWithJsExecutor(claimNoLink);
        }
        else {
            LOGGER.info("Unable to find the Element");
        }
    }
    public void clickOnRemedialWorkCompleteIcon() {
        if (base.checkIfELementIsAvailable(remedialWorkCompleteIcon)) {
            base.highlightElement(remedialWorkCompleteIcon);
            base.clickWithJsExecutor(remedialWorkCompleteIcon);
        }
        else {
            LOGGER.info("Unable to find the Element");
        }
    }

    public void completeRemedialWorkCompletePopup(String notes)
    {
        try {
            if (base.checkIfELementIsAvailable(remedialWorkCompletePopup)) {
                base.sendFieldInputData(remedialWorkCompleteNotes,notes);
                base.clickElement(submitButton);
            }else {
                LOGGER.error("Remedial Work Complete Popup not available");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public boolean verifyRemedialWorkRequiredPopUp(){
        boolean status = false;
        try {
            if(RemedialWorkRequiredPopUP.isDisplayed()) {
                status = true;
                base.highlightElement(RemedialWorkRequiredPopUP);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}