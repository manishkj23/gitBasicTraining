package com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV;

import com.test.pages.ExcessPayment.CallOutChargePaymentPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcessPaymentDue {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private CallOutChargePaymentPage paymentPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ExcessPaymentDue(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, CallOutChargePaymentPage paymentPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.paymentPage = paymentPage;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//legend[contains(.,\"Excess Payment Due\")]")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[@onclick=\"TakePaymentFromWaiveExcessForm()\"]")
    private WebElement takePaymentButton;

    @FindBy(xpath = "//div[@id=\"paymentSuccess\"]")
    private WebElement paymentSuccessfulBanner;

    public boolean isExcessPaymentPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(pageTitle)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void takeExcessPayment() {
        if (isExcessPaymentPageDisplayed()) {
            paymentPage.proceedToExcessPayNPV();
        } else {
            LOGGER.info("Unable to process the payment");
        }

    }

    public boolean isPaymentSuccessfulBannerDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(paymentSuccessfulBanner)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}