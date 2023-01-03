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

import java.util.NoSuchElementException;

public class ClaimPaymentRequired {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    private WaiveCalloutChargePage waiveCallOutChargePayment;

    private final String popupClaimPaymentRequiredXpath = "//div[@class=\"modal-dialog modal-lg\"]//b[contains(.,\"Claim Payment Required\")]";
    private final String popupExcessPaymentPath = "//*[@id=\"cboxLoadedContent\"]//legend[contains(.,\"Excess Fee Payment Due\")]";
    @FindBy(xpath = popupClaimPaymentRequiredXpath)
    WebElement popupClaimPaymentRequiredHeading;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//input[@id=\"CustomerNotified\"]")
    WebElement confirmWithCustomerCheckbox;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Close\")]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Waive Call Out Charge\")]")
    WebElement waiveCalloutChargeButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Continue\")]")
    WebElement continueButton;

    public ClaimPaymentRequired(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, WaiveCalloutChargePage waiveCalloutChargePage, ExcessFeePaymentDuePage excessFeePaymentDuePage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.waiveCallOutChargePayment = waiveCalloutChargePage;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(popupClaimPaymentRequiredXpath) != null) {
                status = true;
            } else {
                LOGGER.info("Unable to verify the Excess Payment Popup");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void proceedToWaiveCharge() {
        if(isPopUpDisplayed()){
            base.clickElement(confirmWithCustomerCheckbox);
            base.clickWithJsExecutor(waiveCalloutChargeButton);
            if(waiveCallOutChargePayment.isPopUpDisplayed()){
                waiveCallOutChargePayment.waiveExcessPayment();
            }
        }
    }

    public void proceedToExcessPay() {
        if (isPopUpDisplayed()) {
            base.clickElement(confirmWithCustomerCheckbox);
            base.clickWithJsExecutor(continueButton);

        }

    }
}
