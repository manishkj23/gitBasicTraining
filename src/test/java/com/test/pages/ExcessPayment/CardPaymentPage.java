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

public class CardPaymentPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private WaiveCalloutChargePage waiveCalloutChargePage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String cardNumberLabelPath = "//*[@id=\"cardNumberLabel\"]";
    @FindBy(xpath = cardNumberLabelPath)
    WebElement cardNumberLabel;

    @FindBy(xpath = "//*[@id=\"cardNumber\"]")
    WebElement cardNumber;

    @FindBy(xpath = "//*[@id=\"cardholderName\"]")
    WebElement cardHolderName;

    @FindBy(xpath = "//*[@id=\"expiryMonth\"]")
    WebElement expiryMonth;

    @FindBy(xpath = "//*[@id=\"expiryYear\"]")
    WebElement expiryYear;

    @FindBy(xpath = "//*[@id=\"securityCode\"]")
    WebElement securityCode;

    @FindBy(xpath = "//*[@id=\"submitButton\"]")
    WebElement makePaymentButton;

    @FindBy(id = "emailYes")
    WebElement emailSameAsCustomerEmailYes;

    @FindBy(id = "addressYes")
    WebElement addressSameAsCustomerAddress;

    @FindBy(xpath = "//*[@id=\"ManualRefDiv\"]/fieldset/div[3]/button[1]")
    WebElement confirmAddressDetailsBtn;

    //Constants

    private final String CARDNUMBER = "4111111111111111";
    private final String CARDHOLDERNAME = "TEST";
    private final String EXPIRYMONTH = "07";
    private final String EXPIRYYEAR = "27";
    private final String SECCODE = "123";

    public CardPaymentPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, WaiveCalloutChargePage waiveCalloutChargePage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.waiveCalloutChargePage = waiveCalloutChargePage;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.getElementFromXpath(cardNumberLabelPath) != null) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmBillingAddressPage(){
        if(base.checkIfELementIsAvailable(emailSameAsCustomerEmailYes)){
            base.clickWithJsExecutor(emailSameAsCustomerEmailYes);
            base.clickWithJsExecutor(addressSameAsCustomerAddress);
            base.clickWithJsExecutor(confirmAddressDetailsBtn);
        }
    }

    public void processPayment() {
        if (isPopUpDisplayed()) {
            base.highlightElement(cardNumber);
            base.sendFieldInputData(cardNumber, CARDNUMBER);
            base.sendFieldInputData(cardHolderName, CARDHOLDERNAME);
            base.sendFieldInputData(expiryMonth, EXPIRYMONTH);
            base.sendFieldInputData(expiryYear, EXPIRYYEAR);
            base.sendFieldInputData(securityCode, SECCODE);
            if (base.isClickable(makePaymentButton)) {
                base.clickWithJsExecutor(makePaymentButton);
            } else {
                LOGGER.info("Payment not Processed");
            }

        }

    }

    public void processPaymentWithOutAnyPopupsCheck() {
        base.highlightElement(cardNumber);
        base.sendFieldInputData(cardNumber, CARDNUMBER);
        base.sendFieldInputData(cardHolderName, CARDHOLDERNAME);
        base.sendFieldInputData(expiryMonth, EXPIRYMONTH);
        base.sendFieldInputData(expiryYear, EXPIRYYEAR);
        base.sendFieldInputData(securityCode, SECCODE);
        if (base.isClickable(makePaymentButton)) {
            base.clickWithJsExecutor(makePaymentButton);
        } else {
            LOGGER.info("Payment not Processed");
        }
    }
}
