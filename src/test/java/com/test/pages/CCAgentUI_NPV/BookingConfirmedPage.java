package com.test.pages.CCAgentUI_NPV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingConfirmedPage {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public BookingConfirmedPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"UICoreModal_Content\"]//b[contains(.,\"Booking Confirmed\")]")
    private WebElement bookingConfirmationPopupMessage;

    @FindBy(xpath = "//p[@id=\"ClaimID\"]")
    private WebElement claimNumber;

    @FindBy(xpath = "//p[@id=\"Repairer\"]")
    private WebElement repairer;

    @FindBy(xpath = "//p[@id=\"RepairerReference\"]")
    private WebElement repairerReferenceNo;

    @FindBy(xpath = "//div[@id='UICoreModal_Content']//button[contains(.,\"Close Window\")]")
    private WebElement closeWindowButton;

    @FindBy(xpath = "//button[contains(.,\"Find New Appointment\")]")
    private WebElement findNewAppointmentButton;

    @FindBy(xpath = "//button[contains(.,\"Go to\")]")
    private WebElement gotoClaimButton;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]/div/div[contains(.,\"Accessory Only Exchange\")]")
    private WebElement bookingConfirmationPopupMessageForAOE;

    @FindBy(xpath = "//div[@id='UICoreModal_Holder']//div[@id='UICoreModal_Content']//button[contains(text(),'Close Window')]")
    private WebElement bookingConfirmationCloseWindow;

    @FindBy(xpath = "//b[text()=\"APPOINTMENT DATE\"]//parent::td")
    private WebElement appointmentDate;

    private static final String serviceProviderDetailsXpath = "//h6[contains(.,\"Repairer Details\")]/..//table//td[contains(.,\"${value}\")]";
    public static String repairerRefNo;
    public static String apptDate;

    public boolean isBookingConfirmationPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfElementIsNotNull(bookingConfirmationPopupMessage) &&
                    base.checkIfELementIsAvailable(bookingConfirmationPopupMessage)) {
                base.highlightElement(bookingConfirmationPopupMessage);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isServiceProviderDetailsDisplayed(String spName) {
        if (seleniumHelper.getCustomElementByXpath(serviceProviderDetailsXpath, spName.toUpperCase()) != null) {
            base.highlightElement(seleniumHelper.getCustomElementByXpath(serviceProviderDetailsXpath, spName.toUpperCase()));
            return true;
        } else return false;
    }

    public void cickGotoClaim() {
        base.isClickable(gotoClaimButton);
        base.clickElement(gotoClaimButton);
        base.switchToNextTab();
    }

    public boolean isClaimNumberDisplayed() {
        base.highlightElement(claimNumber);
        return (claimNumber.isDisplayed()) ? true : false;
    }

    public boolean isRepairerDisplayed(String spName) {
        base.highlightElement(repairer);
        return (repairer.getText().equalsIgnoreCase(spName)) ? true : false;
    }

    public boolean isRepairReferenceDisplayed() {
        base.highlightElement(repairerReferenceNo);
        return (repairerReferenceNo.isDisplayed()) ? true : false;
    }

    public boolean isReparerMatched(String spName) {
        return (repairer.getText().equalsIgnoreCase(seleniumHelper.getCustomElementByXpath(serviceProviderDetailsXpath, spName.toUpperCase()).toString())) ? true : false;
    }

    public boolean isGotoClaimButtonDisplayed(String claimType) {
        boolean status = false;
        try {
            if (gotoClaimButton.isDisplayed() && gotoClaimButton.getText().contains(claimType)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public boolean isBookingConfirmationPageDisplayedForAOE() {
        boolean status = false;
        try {
            if (base.checkIfElementIsNotNull(bookingConfirmationPopupMessageForAOE) &&
                    base.checkIfELementIsAvailable(bookingConfirmationPopupMessageForAOE)) {
                base.highlightElement(bookingConfirmationPopupMessageForAOE);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean clickOnCloseWindowButton()
    {
        boolean status = false;
        try {
            if (closeWindowButton.isDisplayed() && base.isClickable(closeWindowButton)) {
                base.clickWithJsExecutor(closeWindowButton);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public boolean clickOnCloseWindowButton1(){
        boolean status = false;
        try {
            if (base.waitForElementVisible(bookingConfirmationCloseWindow) &&
                    base.checkIfELementIsAvailable(bookingConfirmationCloseWindow)) {
                base.highlightElement(bookingConfirmationCloseWindow);
                base.clickWithJsExecutor(bookingConfirmationCloseWindow);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public void cickCloseWindow() {
        base.isClickable(closeWindowButton);
        base.clickElement(closeWindowButton);
    }

    public void getRepairReferenceNo() {
        try {
            if (base.checkIfELementIsAvailable(repairerReferenceNo)) {
                base.highlightElement(repairerReferenceNo);
                repairerRefNo= repairerReferenceNo.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAppointmentDate() {
        try {
            if (base.checkIfELementIsAvailable(appointmentDate)) {
                base.highlightElement(appointmentDate);
                apptDate= appointmentDate.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}