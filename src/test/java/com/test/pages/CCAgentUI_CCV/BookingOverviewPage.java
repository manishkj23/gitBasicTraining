package com.test.pages.CCAgentUI_CCV;

import com.test.pages.CancelClaimPage;
import com.test.pages.DialogPoppupPage;
import com.test.pages.CancelClaimPage;
import com.test.pages.DialogPoppupPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingOverviewPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;
    private CancelClaimPage cancelClaimPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@id=\"JobStatusName\"]")
    private WebElement jobStatusHeader;

    @FindBy(xpath="//div[@id=\"ui2_top_header\"]//td[contains(.,\"REPAIRER\")]/text()")
    private WebElement repairerNameHeaderArea;

    @FindBy(xpath = "//div[@id=\"ui2_top_header\"]//td[contains(.,\"CLAIM NO\")]/text()")
    private WebElement currentClaimNumberHeaderArea;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//div[1]/span[@onClick]")
    private WebElement currentClaimNumber;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Booking Overview\")]")
    private WebElement bookingOverviewSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Repair Information\")]")
    private WebElement repairInformationSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Customer Details\")]")
    private WebElement customerDetailsSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Repair Authority\")]")
    private WebElement repairAuthoritySection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Customer Communications\")]")
    private WebElement customrCommunicationsSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"System Note\")]")
    private WebElement systemNoteSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Write Off Authorization\")]")
    private WebElement woAuthorizationSection;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Service Option\")]")
    private WebElement serviceOptionSection;


    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Cancel Claim\")]")
    private WebElement cancelClaimSection;

    //Vulnerable
    @FindBy(xpath = "//div[@class=\"ClaimAlerts\"][contains(.,\"Vulnerable Customer\")]")
    private WebElement vulnerableCustomerIcon;




    private static final String leftMenuItem = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"${value}\")]";



    public BookingOverviewPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage,
                               CancelClaimPage cancelClaimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        this.cancelClaimPage = cancelClaimPage;
        PageFactory.initElements(driver, this);
    }



    @Before
    public void verifyIfNewUIPageIsLoaded() {
        Assert.assertTrue("New CC Agent Portal Not Loaded",jobStatusHeader.isDisplayed());
    }


    public boolean isJobStatusUpdated(String jobStatus) {
        boolean status = false;
        try {
            if(base.checkIfELementIsAvailable(jobStatusHeader)) {
                if (jobStatusHeader != null && jobStatusHeader.getText().equalsIgnoreCase(jobStatus)) {
                    status = true;
                }
            } else {
                base.hardWait("3000");
                base.waitForElementVisible(jobStatusHeader);
                if (jobStatusHeader != null && jobStatusHeader.getText().equalsIgnoreCase(jobStatus)) {
                    status = true;
                }
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void cancelClaim(){
        try{
            if(base.checkIfELementIsAvailable(cancelClaimSection) && base.isClickable(cancelClaimSection)){
                base.clickElement(cancelClaimSection);
                base.waitForPageToLoad();
                cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");
            } else {
                LOGGER.info("Unable to cancel the claim");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void clickRepairAuthoritySection(){

        try{
            if(base.checkIfELementIsAvailable(repairAuthoritySection) && base.isClickable(repairAuthoritySection)){
                base.clickElement(repairAuthoritySection);
            } else{
                LOGGER.info("Unable to load Repair Authority Section");
            }
        }catch ( Exception e ) {e.printStackTrace();}
    }


    public void clickLeftMenuItem(String sectionName){
        WebElement menuItem;
        try{
            menuItem = seleniumHelper.getCustomElementByXpath(leftMenuItem,sectionName);
            if(menuItem != null && base.checkIfELementIsAvailable(menuItem) && base.isClickable(menuItem)){
                base.clickElement(menuItem);
            } else{
                LOGGER.info("Unable to load "+ sectionName+" Section");
            }
        }catch ( Exception e ) {e.printStackTrace();}
    }
    public void clickCustomerCommunicationsSection(){

        try{
            if(base.checkIfELementIsAvailable(customrCommunicationsSection) && base.isClickable(customrCommunicationsSection)){
                base.clickElement(customrCommunicationsSection);
            } else{
                LOGGER.info("Unable to load Customer Communications Section");
            }
        }catch ( Exception e ) {e.printStackTrace();}
    }

    public boolean isBookingOverviewSectionDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(bookingOverviewSection)){
                status = true;
            } else{
                LOGGER.info("Unable to verify the Booking overview Page");
            }
        }catch ( Exception e ) {e.printStackTrace();}
        return status;
    }
}
