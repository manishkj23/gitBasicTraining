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

    @FindBy(xpath = "//div[@id=\"UICoreModal_Content\"]//b[contains(.,\"CLAIM NUMBER\")]/../text()")
    private WebElement claimNumberOnTheBookingPage;

    @FindBy(xpath = "//button[contains(.,\"Close Window\")]")
    private WebElement closeWindowButton;

    @FindBy(xpath = "//button[contains(.,\"Find New Appointment\")]")
    private WebElement findNewAppointmentButton;

    @FindBy(xpath = "//button[contains(.,\"Go to\")]")
    private WebElement gotoClaimButton;

    @FindBy(xpath = "//div[@id=\"UICoreModal_Content\"]//td[contains(.,\"REPAIRER REFERENCE\")]//text()[2]")
    private WebElement repairerReference;

    @FindBy(xpath = "//div[@id=\"UICoreModal_Content\"]//td[contains(.,\"REPAIRER\")][1]//text()[2]")
    private WebElement repairer;

    private static final String serviceProviderDetailsXpath = "//h6[contains(.,\"Repairer Details\")]/..//table//td[contains(.,\"${value}\")]";


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

    public boolean isServiceProviderDisplayed(String spName) {
        if (seleniumHelper.getCustomElementByXpath(serviceProviderDetailsXpath, spName.toUpperCase()) != null) {
            base.highlightElement(seleniumHelper.getCustomElementByXpath(serviceProviderDetailsXpath, spName.toUpperCase()));
            return true;
        } else return false;
    }

    public void cickGotoClaim() {
        base.isClickable(gotoClaimButton);
        base.clickElement(gotoClaimButton);
    }

    public boolean isClaimNumberDisplayed(){
        base.highlightElement(claimNumberOnTheBookingPage);
        return (claimNumberOnTheBookingPage.isDisplayed())?true:false;
    }

    public boolean isRepairerDisplayed(String spName){
        base.highlightElement(repairer);
        return (repairer.getText().equalsIgnoreCase(spName))?true:false;
    }

    public boolean isRepairReferenceDisplayed(){
        base.highlightElement(repairerReference);
        return(repairerReference.isDisplayed())?true:false;
    }

    public boolean isGotoClaimButtonDisplayed(String claimType){
        boolean status = false;
        try{
            if(gotoClaimButton.isDisplayed() && gotoClaimButton.getText().contains(claimType)){
                status = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}