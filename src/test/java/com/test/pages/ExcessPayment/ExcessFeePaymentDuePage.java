package com.test.pages.ExcessPayment;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcessFeePaymentDuePage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private WaiveExcessPymentPage waiveExcessPayment;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String popupExcessPaymentPath = "//*[@id=\"cboxLoadedContent\"]//legend[contains(.,\"Excess Fee Payment Due\")]";
    @FindBy(xpath = popupExcessPaymentPath)
    WebElement popupCalloutChargeHeading;

    @FindBy(xpath = "//*[@id=\"CustomerConfirmedProceedCheck\"]")
    WebElement confirmWithCustomerCheckbox;

    @FindBy(xpath = "//*[@id=\"buttons\"]/button[contains(.,\"Proceed\")]")
    WebElement proceedButton;

    @FindBy(xpath = "//*[@id=\"buttons\"]/button[contains(.,\"Cancel\")]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"buttons\"]/button[contains(.,\"Waive Excess\")]")
    WebElement waiveChargeButton;

    public ExcessFeePaymentDuePage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, WaiveExcessPymentPage waiveExcessPayment) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.waiveExcessPayment = waiveExcessPayment;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(popupExcessPaymentPath) != null){
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void proceedToWaiveCharge() {
        if(isPopUpDisplayed()){
            base.clickElement(confirmWithCustomerCheckbox);
            base.clickWithJsExecutor(waiveChargeButton);
            if(waiveExcessPayment.isPopUpDisplayed()){
                waiveExcessPayment.waiveExcessPayment();
            }
        }

    }

    public void proceedToExcessPay() {
        if(isPopUpDisplayed()){
            base.clickElement(confirmWithCustomerCheckbox);
            base.clickWithJsExecutor(proceedButton);

        }

    }
}
