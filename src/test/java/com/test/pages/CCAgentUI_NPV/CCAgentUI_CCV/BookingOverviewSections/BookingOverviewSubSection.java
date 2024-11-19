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

public class BookingOverviewSubSection {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;
    private CancelClaimPage cancelClaimPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@id=\"JobStatusName\"]")
    private WebElement jobStatusHeader;

    @FindBy(xpath = "//div[@id=\"ui2_left_nav\"]//div[contains(.,\"Booking Overview\")]")
    private WebElement bookingOverviewSection;

    //Booking Overview Sections
    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Booked:\")]//td[1]")
    private WebElement bookedDateLbl;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Booked:\")]//td[2]")
    private WebElement bookedDate;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Booked By\")]//td[1]")
    private WebElement bookedByLbl;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Booked By\")]//td[2]")
    private WebElement bookedBy;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Booking Source\")]//td[1]")
    private WebElement bookingSourceLbl;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Booking Source\")]//td[2]")
    private WebElement bookingSource;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Report Fault\")]//td[1]")
    private WebElement reportFaultLbl;

    @FindBy(xpath = "//div[contains(@id,\"right_content\")]//table//tr[contains(.,\"Report Fault\")]//td[2]")
    private WebElement reportFault;

    @FindBy(xpath = "//div[@id=\"ui2_right\"][contains(.,\"Booking Overview\")]//tr[contains(.,\"Service Option\")]/td[2]")
    private WebElement serviceOptionDisplayed;

    @FindBy(xpath = "//div[@id=\"ui2_right\"][contains(.,\"Booking Overview\")]//tr[contains(.,\"Repairer:\")]/td[2]")
    private WebElement repairerDisplayed;

    @FindBy(xpath = "//div[@id=\"ui2_right\"][contains(.,\"Booking Overview\")]//tr[contains(.,\"Repairer Reference\")]/td[2]")
    private WebElement repairerReferenceNo;

    public BookingOverviewSubSection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage,
                                     CancelClaimPage cancelClaimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        this.cancelClaimPage = cancelClaimPage;
        PageFactory.initElements(driver, this);
    }


    public boolean isJobStatusUpdated(String jobStatus) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(jobStatusHeader)) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public boolean isServiceOptionDisplayed(String serviceOption) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(serviceOptionDisplayed) && serviceOptionDisplayed.getText().equalsIgnoreCase(serviceOption)) {
                status = true;
            } else {
                LOGGER.info("Unable to verify the Service Option : " + serviceOption);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isRepairerDisplayed(String spName) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(repairerDisplayed) && repairerDisplayed.getText().equalsIgnoreCase(spName)) {
                status = true;
            } else {
                LOGGER.info("Unable to verify the Service Provider : " + spName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isBookingSourceMatched(String src){
        boolean status = false;
        try{
            if ( base.checkIfELementIsAvailable(bookingSource) && bookingSource.getText().equalsIgnoreCase(src)){
                base.highlightElement(bookingSource);
                status = true;
            } else{
                LOGGER.info("Unable to verify the Booking Source as : "+src);
            }
        } catch ( Exception e ) { e.printStackTrace(); }
        return status;
    }
}