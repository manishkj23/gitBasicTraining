package com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV;

import com.test.pages.ExcessPayment.ExcessFeePaymentDuePage;
import com.test.pages.ExcessPayment.WaiveCalloutChargePage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaiveCallOutChargePaymentNPV {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String popupWaiveCallOutChargeHeadingXpath = "//div[@id=\"waiveExcess\"]//legend[contains(.,\"Waive Call Out Charge Payment\")]";
    @FindBy(xpath = popupWaiveCallOutChargeHeadingXpath)
    private WebElement popupWaiveCallOutChargeHeading;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//input[@id=\"CustomerNotified\"]")
    private WebElement confirmWithCustomerCheckbox;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Close\")]")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Waive Call Out Charge\")]")
    private WebElement waiveCalloutChargeButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Continue\")]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id=\"waiveExcess\"]//label[contains(.,\"Current Charge\")]/../input")
    private WebElement currentChargeValue; // Value already exist on the element -> getProperty -> value in the code

    @FindBy(xpath = "//div[@id=\"waiveExcess\"]//label[contains(.,\"New Charge\")]/../input")
    private WebElement newChargeValue;

    @FindBy(id = "WaiveReason")
    private WebElement waiveOffReason;

    @FindBy(xpath = "//div[@id=\"waiveExcess\"]//button[contains(.,\"Proceed\")]")
    private WebElement proccedButton;


    @FindBy(xpath = "//div[@id=\"waiveExcess\"]//button[contains(.,\"Cancel\")]")
    private WebElement cancelButton;


    public WaiveCallOutChargePaymentNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, WaiveCalloutChargePage waiveCalloutChargePage, ExcessFeePaymentDuePage excessFeePaymentDuePage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(popupWaiveCallOutChargeHeadingXpath) != null) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void proceedToWaiveCharge() {
        if (isPopUpDisplayed() && base.checkIfELementIsAvailable(waiveOffReason)) {
            base.sendFieldInputData(newChargeValue, "0");
            base.selectTextByIndex(waiveOffReason, 0);
            if (base.isClickable(proccedButton)) {
                base.clickElement(proccedButton);
            } else {
                base.hardWait("1000");
                base.clickElement(proccedButton);
            }

        } else {
            LOGGER.info(" =======>>>>>>> Unable to proceed with the WaiveOff Excess");
        }

    }

}