package com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV;

import com.test.pages.ExcessPayment.CardPaymentPage;
import com.test.pages.ExcessPayment.ExcessFeePaymentDuePage;
import com.test.pages.ExcessPayment.WaiveCalloutChargePage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
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
    private CardPaymentPage cardPaymentPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    private WaiveCalloutChargePage waiveCallOutChargePayment;

    private final String popupClaimPaymentRequiredXpath = "//div[@class=\"modal-dialog modal-lg\"]//b[contains(.,\"Claim Payment Required\")]";
    private final String popupExcessPaymentPath = "//*[@id=\"cboxLoadedContent\"]//legend[contains(.,\"Excess Fee Payment Due\")]";
    @FindBy(xpath = popupClaimPaymentRequiredXpath)
    WebElement popupClaimPaymentRequiredHeading;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//input[@id=\"CustomerNotified\"]")
    WebElement confirmWithCustomerCheckbox;

    // @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Close\")]")
    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//button[contains(.,\"Close\")]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Waive\")]")
    WebElement waiveCalloutChargeButton;

    @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[contains(.,\"Continue\")]")
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(.,\"Waive Charge\")]")
    private WebElement waiveExcessChargeSection;

    @FindBy(xpath = "//*[@id=\"waiveExcess\"]/fieldset/legend[contains(.,\"Waive Call Out Charge Payment\")]")
    WebElement popupWaiveCallOutChargePayment;

    @FindBy(xpath = "//*[@id=\"NewValue\"]")
    WebElement newCharge;

    @FindBy(xpath = "//*[@id=\"WaiveReason\"]")
    WebElement waiveReason;

    private final String WAIVE_REASON = "Sky Faulty Swap out device";

    @FindBy(xpath = "//*[@id=\"waiveExcess\"]/fieldset/div[4]/button[contains(.,\"Proceed\")]")
    WebElement clickProceed;

    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//button[contains(.,\"Close\")]")
    WebElement clickClose;

    //Commented: Manish Kumar Jain : New Xpath added for Payment & Billing Details pop up and confirm

    private static final String worldpay_ccWorldPayQAPath = "//form[@id='IcqMainForm']//div[@id='icqHelpAndAdvice'][contains(.,'WorldPay')]";
    @FindBy(xpath = worldpay_ccWorldPayQAPath)
    WebElement worldpay_ccWorldPayQA;

    private static final String worldpay_ccPaymentAmountTextPath = "//form[@id='IcqMainForm']//div//b[contains(text(),'cost of milk, bread and butter pack')]";
    @FindBy(xpath = worldpay_ccPaymentAmountTextPath)
    WebElement worldpay_ccPaymentAmountText;

    private static final String worldpay_ccPaymentAmountTextboxPath = "//div[@id='icqTabs']//div[@id='icqTabs-99']//form[@id='IcqMainForm']//div[@id=\"WorldPaymentPaymentcheckDiv\"]//p//input[@id=\"paymentAmount\"]";
    @FindBy(xpath = worldpay_ccPaymentAmountTextboxPath)
    WebElement worldpay_ccPaymentAmountTextbox;

    private static final String worldpay_ccWorldPayQANextButtonPath = "//div[@id='IcqNextButton']//button[@id='IcqAnswerButton'][contains(text(),'Next')]";
    @FindBy(xpath = worldpay_ccWorldPayQANextButtonPath)
    WebElement worldpay_ccWorldPayQANextButton;

    private static final String worldpay_TakePaymentButtonPath = "//div[@id='cboxLoadedContent']//button[@onclick='getWorlPayBillingAddressData()'][contains(.,'Take Payment')]";
    @FindBy(xpath = worldpay_TakePaymentButtonPath)
    WebElement worldpay_TakePaymentButton;

    private static final String worldpay_billingDetailsYesEmailRadioButtonPath = "//div[@id='cboxLoadedContent']//div[@id='ManualRefDiv']//input[@id='emailYes']";
    @FindBy(xpath = worldpay_billingDetailsYesEmailRadioButtonPath)
    WebElement worldpay_billingDetailsYesEmailRadioButton;

    private static final String worldpay_billingDetailsYesAddressRadioButtonPath = "//div[@id='cboxLoadedContent']//div[@id='ManualRefDiv']//input[@id='addressYes'][1]";
    @FindBy(xpath = worldpay_billingDetailsYesAddressRadioButtonPath)
    WebElement worldpay_billingDetailsYesAddressRadioButton;

    private static final String worldpay_billingDetailsAddressLine2TextBoxPath = "//div[@id='addressFields']//input[@id='addressLine2'][1]";
    @FindBy(xpath = worldpay_billingDetailsAddressLine2TextBoxPath)
    WebElement worldpay_billingDetailsAddressLine2TextBox;

    private static final String worldpay_billingDetailsAddressLine3TextBoxPath = "//div[@id='addressFields']//input[@id='addressLine3'][1]";
    @FindBy(xpath = worldpay_billingDetailsAddressLine3TextBoxPath)
    WebElement worldpay_billingDetailsAddressLine3TextBox;

    private static final String worldpay_billingDetailsConfirmButtonPath = "//div[@id='cboxLoadedContent']//div[@id='ManualRefDiv']//button[contains(.,'Confirm')]";
    @FindBy(xpath = worldpay_billingDetailsConfirmButtonPath)
    WebElement worldpay_billingDetailsConfirmButton;

    private final String paymentFramePath = "//iframe[@title=\"Payment Pages\"]";
    @FindBy(xpath = paymentFramePath)
    WebElement paymentFrame;

    @FindBy(xpath = "//div[@id='ServiceOptions_Wrapper']//div[@id='ServiceOptionsMainDiv']//div//a[contains(text(),'Waive Charge')]")
    WebElement waiveChargesLink;

    private final String  waiveCallOutPopUpXPath = "//div[@id='cboxLoadedContent']//div[@id='waiveExcess']//legend[contains(text(),'Waive Call Out Charge Payment')]";
    @FindBy(xpath = waiveCallOutPopUpXPath)
    WebElement waiveCallOutPopUp;




    public ClaimPaymentRequired(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, WaiveCalloutChargePage waiveCalloutChargePage, ExcessFeePaymentDuePage excessFeePaymentDuePage,
                                CardPaymentPage cardPaymentPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.waiveCallOutChargePayment = waiveCalloutChargePage;
        this.cardPaymentPage = cardPaymentPage;
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

    public void proceedToWaiveCharge() throws InterruptedException {
        if (isPopUpDisplayed()) {
            base.clickElement(confirmWithCustomerCheckbox);
            if (waiveCalloutChargeButton.isDisplayed()) {
                base.clickWithJsExecutor(waiveCalloutChargeButton);
                if (waiveCallOutChargePayment.isPopUpDisplayed()) {
                    waiveCallOutChargePayment.waiveExcessPayment();
                }
            }
        }
    }


    public void proceedToExcessPay() {
        if(isPopUpDisplayed()) {
            base.clickElement(confirmWithCustomerCheckbox);
            base.clickWithJsExecutor(continueButton);

        }

    }

    public boolean isWorldPayTakePaymentButtonDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(worldpay_TakePaymentButton) && worldpay_TakePaymentButton.isEnabled()){
                status = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterPaymentDetailsAndConfirm() throws InterruptedException {
        base.highlightElement(worldpay_TakePaymentButton);
        base.clickWithJsExecutor(worldpay_TakePaymentButton);
        Thread.sleep(3000);
        base.highlightElement(worldpay_billingDetailsYesEmailRadioButton);
        base.clickWithJsExecutor(worldpay_billingDetailsYesEmailRadioButton);
        Thread.sleep(2000);
        base.highlightElement(worldpay_billingDetailsYesAddressRadioButton);
        base.clickWithJsExecutor(worldpay_billingDetailsYesAddressRadioButton);
        Thread.sleep(3000);
        base.highlightElement(worldpay_billingDetailsAddressLine2TextBox);
        String addr2TextRetrieved = driver.findElement(By.name("addressLine2")).getAttribute("value");
        LOGGER.info("Address line 2 is : " + addr2TextRetrieved);
        Thread.sleep(4000);
        base.highlightElement(worldpay_billingDetailsAddressLine3TextBox);
        driver.findElement(By.xpath(worldpay_billingDetailsAddressLine3TextBoxPath)).sendKeys(addr2TextRetrieved);
        String addr3TextRetrieved = driver.findElement(By.name("addressLine3")).getAttribute("value");
        LOGGER.info("Address line 3 is : " + addr3TextRetrieved);
        Thread.sleep(2000);
        base.clickWithJsExecutor(worldpay_billingDetailsConfirmButton);
        Thread.sleep(3000);
    }

    public void outstandingDDPaymentProcess() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(paymentFrame);
        if (cardPaymentPage.isPopUpDisplayed()) {
            cardPaymentPage.processPayment();
            base.hardWait("5000");

        } else {
            LOGGER.info("Card Payment Page is not Displayed");
        }
        driver.switchTo().defaultContent();
    }


    public void clickContinueForClaimRequiredPopup() throws InterruptedException {
        if (isPopUpDisplayed()) {
            base.clickElement(confirmWithCustomerCheckbox);
            if (continueButton.isDisplayed()) {
                base.clickWithJsExecutor(continueButton);
            }
        }
    }
    public boolean isWaiveExcessChargeButtonDisplayed() throws InterruptedException {
        boolean status = false;
        Thread.sleep(10000);
        try {
            base.highlightElement(waiveExcessChargeSection);
            if (base.checkIfELementIsAvailable(waiveExcessChargeSection)) {
                Thread.sleep(10000);
                base.highlightElement(waiveExcessChargeSection);
                Thread.sleep(3000);
                base.clickWithJsExecutor(waiveExcessChargeSection);
                status = true;
            }
            else {
                LOGGER.info("Unable to verify the Waive Charge button at service option section");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }
    public void clickOnWaiveChargesLinkinServiceOption() {
        if (waiveChargesLink.isDisplayed()) {
            base.highlightElement(waiveChargesLink);
            base.clickWithJsExecutor(waiveChargesLink);
        }
    }


    public boolean isWaiveExcessPopUpDisplayedAtServiceOptionSection() throws InterruptedException {
        boolean status = false;
        try {
            if (popupWaiveCallOutChargePayment.isDisplayed()) {
                Thread.sleep(3000);
                base.highlightElement(popupWaiveCallOutChargePayment);
                Thread.sleep(3000);
                status = true;
            } else {
                LOGGER.info("Unable to verify the Waive Call Out Charge Payment Popup");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }
    public boolean isWaiveCallOutPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(waiveCallOutPopUpXPath) != null) {
                status = true;
            } else {
                LOGGER.info("Unable to verify the Waive Call Out Charge Pop up");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void proceedToWaiveCallOutCharge() throws InterruptedException {
        if (waiveCallOutChargePayment.isPopUpDisplayed()) {
            waiveCallOutChargePayment.waiveExcessPayment();
        }
    }

    public void proceedToWaiveCallOutChargePayment() throws InterruptedException {
        if (isWaiveExcessPopUpDisplayedAtServiceOptionSection()) {
            Thread.sleep(5000);
            base.sendFieldInputData(newCharge, "0");
            base.selectTextByVisibleText(waiveReason, WAIVE_REASON);
            if (base.checkIfELementIsAvailable(clickProceed)) {
                base.clickWithJsExecutor(clickProceed);
            }
            if (base.checkIfELementIsAvailable(clickClose)) {
                base.clickWithJsExecutor(clickClose);
            }else{
                LOGGER.info("Waived excess Pop up is not displayed");
            }
        }
    }
}