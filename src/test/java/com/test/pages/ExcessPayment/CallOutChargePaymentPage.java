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

public class CallOutChargePaymentPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private CardPaymentPage cardPaymentPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String popupCalloutChargePath = "//*[@id=\"ManualRefDiv\"]//legend[contains(.,\"Call Out Charge Payment Due\")]";
    @FindBy(xpath = popupCalloutChargePath)
    WebElement popupCalloutChargeHeading;

    @FindBy(xpath = "//*[@id=\"ManualRefDiv\"]//button[contains(.,\"Close Window\")]")
    WebElement closeWindowButton;

    @FindBy(xpath = "//*[@id=\"ManualRefDiv\"]//button[contains(.,\"Take Payment\")]")
    WebElement takePaymentButton;

    @FindBy(xpath = "//*[@id=\"ManualRefDiv\"]//button[contains(.,\"Waive Charge\")]")
    WebElement waiveChargeButton;

    private final String paymentFramePath = "//iframe[@title=\"Payment Pages\"]";
    @FindBy(xpath = paymentFramePath)
    WebElement paymentFrame;

    @FindBy(xpath = "//span[contains(.,\"Payment Successful\")]/../..//button[contains(.,\"Close\")]")
    WebElement paymentSuccessfulCloseBtn;

    public CallOutChargePaymentPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, CardPaymentPage cardPaymentPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.cardPaymentPage = cardPaymentPage;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(popupCalloutChargePath) != null) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void proceedToExcessPayNPV() {

        base.clickElement(takePaymentButton);
//        base.waitForElementAndReturnJS(paymentFramePath);
//        driver.switchTo().frame(paymentFrame);
//        if (cardPaymentPage.isPopUpDisplayed()) {
//            cardPaymentPage.processPayment();
//            base.hardWait("5000");
//            base.clickElement(takePaymentButton);
        cardPaymentPage.confirmBillingAddressPage(); //New Popup Worldpay
        base.waitForElementAndReturnJS(paymentFramePath);
        driver.switchTo().frame(paymentFrame);
        if (cardPaymentPage.isPopUpDisplayed()) {
            cardPaymentPage.processPayment();
            base.hardWait("5000");

        } else {
            LOGGER.info("Card Payment Page is not Displayed");
        }
        driver.switchTo().defaultContent();
    }
//    }

    public void proceedToExcessPay()
    {
        if (isPopUpDisplayed()) {
            base.clickElement(takePaymentButton);
            base.waitForElementAndReturnJS(paymentFramePath);
            driver.switchTo().frame(paymentFrame);
            if (cardPaymentPage.isPopUpDisplayed()) {
                cardPaymentPage.processPayment();
                base.hardWait("5000");

            } else {
                LOGGER.info("Card Payment Page is not Displayed");
            }
            driver.switchTo().defaultContent();

        }
    }

    public void confirmPaymentSuccessfulPopup() {
        if (!base.checkIfELementIsAvailable(paymentSuccessfulCloseBtn)) {
            LOGGER.info("Payment Successful banner displayed and no close button present on it");
        }
//            base.clickElement(paymentSuccessfulCloseBtn);
        else {
            base.waitTillElementFound(paymentSuccessfulCloseBtn);
//                base.clickElement(paymentSuccessfulCloseBtn);
            base.clickWithJsExecutor(paymentSuccessfulCloseBtn);
        }
    }

    public void proceedToServiceOptionPayment() {
        base.clickElement(takePaymentButton);
        cardPaymentPage.confirmBillingAddressPage(); //new popup
        base.waitForElementAndReturnJS(paymentFramePath);
        driver.switchTo().frame(paymentFrame);
        if (cardPaymentPage.isPopUpDisplayed()) {
            cardPaymentPage.processPayment();
            base.hardWait("5000");

        } else {
            LOGGER.info("Card Payment Page is not Displayed");
        }
        driver.switchTo().defaultContent();
    }

    public void proceedToServiceCostPaymentNPV() {

        base.clickElement(takePaymentButton);
        cardPaymentPage.confirmBillingAddressPage(); //New Popup Worldpay
        base.waitForElementAndReturnJS(paymentFramePath);
        driver.switchTo().frame(paymentFrame);
        if (cardPaymentPage.isPopUpDisplayed()) {
            cardPaymentPage.processPayment();
            base.hardWait("5000");

        } else {
            LOGGER.info("Card Payment Page is not Displayed");
        }
        driver.switchTo().defaultContent();


    }
//    }
}