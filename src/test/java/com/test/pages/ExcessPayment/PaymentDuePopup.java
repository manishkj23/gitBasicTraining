package com.test.pages.ExcessPayment;

import com.test.pages.CCAgent_OLDUI.ServiceOptionsPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentDuePopup {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private ServiceOptionsPage serviceOptionsPage;
    private CardPaymentPage cardPaymentPage;
    private CallOutChargePaymentPage callOutChargePaymentPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public PaymentDuePopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils,
                           ServiceOptionsPage serviceOptionsPage, CardPaymentPage cardPaymentPage,
                           CallOutChargePaymentPage callOutChargePaymentPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.serviceOptionsPage = serviceOptionsPage;
        this.cardPaymentPage = cardPaymentPage;
        this.callOutChargePaymentPage = callOutChargePaymentPage;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//legend[contains(.,\"Payment Due\")]")
    private WebElement paymentDueHeading;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//table//tr[contains(.,\"Plan Excess\")]/td[2]")
    private WebElement planExcessAmountDisplayed;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//table//tr[contains(.,\"Excess Waived\")]/td[2]")
    private WebElement excessWaivedAmountDisplayed;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//table//tr[contains(.,\"Excess Due\")]/td[2]")
    private WebElement excessDueAmountDisplayed;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//table//tr[contains(.,\"Service Cost\")]/td[2]")
    private WebElement serviceCostAmountDisplayed;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//table//tr[contains(.,\"Total Due\")]/td[2]")
    private WebElement totalDueAmountDisplayed;


    //div[@id="cboxLoadedContent"]//button[contains(.,"Take Payment")]
    //div[@id="cboxLoadedContent"]//button[contains(.,"Close Window")]
    //div[@id="cboxLoadedContent"]//button[contains(.,"Waive Excess")]

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//button[contains(.,\"Take Payment\")]")
    private WebElement takePaymentButton;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//button[contains(.,\"Close Window\")]")
    private WebElement closeWindowButton;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]//button[contains(.,\"Waive Excess\")]")
    private WebElement waiveExcessButton;


    public boolean isServiceOptionCostMatchedFromTheServiceOptionPage() {
        boolean status = false;

        try {
            if (isPaymentDuePageLoaded() && serviceOptionsPage.serviceOptionCost == getServiceCostOnPaymentDuePage()) {
                status = true;
                if (serviceCostAmountDisplayed != null) {
                    base.highlightElement(serviceCostAmountDisplayed);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }


    public boolean isPaymentDuePageLoaded() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(paymentDueHeading)) {
                if (paymentDueHeading != null && paymentDueHeading.isDisplayed()) {
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int getServiceCostOnPaymentDuePage() {
        int cost = 0;
        try {
            if (base.checkIfELementIsAvailable(serviceCostAmountDisplayed) && serviceCostAmountDisplayed.isDisplayed()) {
                cost = Integer.valueOf(serviceCostAmountDisplayed.getText().replaceAll("£", "").replaceAll(".00", ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;

    }

    public void takePayment() {
        try {
            if (base.checkIfELementIsAvailable(takePaymentButton) && base.isClickable(takePaymentButton)) {
                callOutChargePaymentPage.proceedToServiceOptionPayment();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean isServiceOptionCostDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(serviceCostAmountDisplayed) && serviceCostAmountDisplayed.isDisplayed()) {
                status = true;
                base.highlightElement(serviceCostAmountDisplayed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public void takeServiceCostPayment() {
        if (isPaymentDuePageLoaded()) {
            callOutChargePaymentPage.proceedToServiceCostPaymentNPV();
        } else {
            LOGGER.info("Unable to process the payment");
        }

    }


}