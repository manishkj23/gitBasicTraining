package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

import com.test.pages.MakeAClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationPNC {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage claimPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationPNC(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage claimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.claimPage = claimPage;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"pncnyn\"][@value=\"yes\"]")
    private WebElement customerProvidePncYes;

    @FindBy(id = "makeClaimBut")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id=\"pncNoCode\"][div[contains(.,\"PNC Number\")]]//a")
    private WebElement pNCNumberListBox;

//    @FindBy(xpath = "")

    private final String pncNumberCodePath = "//*[@id=\"pncNoCode\"]//span/input";
    @FindBy(xpath = pncNumberCodePath)
    private WebElement pncNumberCode;

    @FindBy(id = "mlcCode")
    private WebElement mlCode;

    @FindBy(id = "pncSerial")
    private WebElement serialNumber;

    private final String faultAreaPath = "//*[@id=\"ejFc\"]/div[1]/span/a";
    @FindBy(xpath = faultAreaPath)
    private WebElement faultArea;

    private final String faultPath = "//*[@id=\"elecJfLook\"]/span/a/span[1]";
    @FindBy(xpath = faultPath)
    private WebElement fault;

    @FindBy(xpath = "//div[@id=\"elecJfLook\"]//input")
    private WebElement faultInput;

    @FindBy(xpath = "//*[@id=\"pncNoCode\"]//span/a")
    private WebElement pncListButton;

    private final String eluxFaultAreaPath="//input[@class='ui-state-default ui-combobox-input comboelecJobFault-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']";
    @FindBy(xpath=eluxFaultAreaPath)
    private WebElement eluxFaultArea;

    private final String eluxFaultPath="//input[@class='ui-state-default ui-combobox-input comboelecJobFaultLookup-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']";
    @FindBy(xpath=eluxFaultPath)
    private WebElement eluxFault;


    public void enterPNCDetails1(){

        try {
            base.clickElement(customerProvidePncYes);
            Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
            seleniumHelper.actionToMoveDownOnList(pncNumberCode, 0);

            if (base.getElementFromXpath(faultAreaPath) == null) {
                base.waitForElementAndReturnJS(faultAreaPath);
            }
            base.clickWithJsExecutor(faultArea);
            seleniumHelper.actionToMoveDownOnList(faultArea, 0);

            if (!faultArea.isSelected()) {
                base.clickWithJsExecutor(faultArea);
                seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            }
//            base.waitForElementAndReturnJS(faultPath);
            if (base.getElementFromXpath(faultPath) == null) {
                base.waitForElementAndReturnJS(faultPath);
            }
            base.clickWithJsExecutor(fault);
            seleniumHelper.actionToMoveDownOnList(fault, 0);
            if (!fault.isSelected()) {
                base.clickWithJsExecutor(fault);
                seleniumHelper.actionToMoveDownOnList(fault, 0);
            }
            claimPage.enterConfirmProductDetailsSectionForPNCForNPV("0");
            base.clickElement(continueButton);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void enterPNCDetails() {

        try {
            base.clickElement(customerProvidePncYes);
            Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
            base.clickElement(pncListButton);
            seleniumHelper.actionToMoveDownOnList(pncNumberCode, 0);
            base.sendFieldInputData(mlCode, "02");
            base.sendFieldInputData(serialNumber, "12345");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterFaultData() {
        try {

            base.checkElementPresence(faultArea);
            faultArea.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            if (faultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(faultArea);
                faultArea.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            }

            base.checkElementPresence(faultInput);
            if (!faultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(faultInput);
                faultInput.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(faultInput, 0);
                if (faultInput.getAttribute("value").isEmpty()) {
                    base.checkElementPresence(faultInput);
                    faultInput.sendKeys(Keys.SPACE);
                    base.hardWait("1000");
                    seleniumHelper.actionToMoveDownOnList(faultInput, 0);
                }
            } else {
                LOGGER.info("Unable to fill the Fault value");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterContinueButton() {
        base.clickElement(continueButton);
    }

    public boolean isFaultDataEntered() {
        boolean status = false;
        try {
            if (!faultArea.getAttribute("value").isEmpty() && !faultInput.getAttribute("value").isEmpty()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterFaultAreaAndFaultAndClickContinue(String faultArea, String faultCode) throws InterruptedException {
        base.highlightElement(eluxFaultArea);
        base.sendFieldInputData(eluxFaultArea,faultArea);
        base.clickOutside();
        Thread.sleep(3000);
        base.sendFieldInputData(eluxFaultArea,faultArea);
        base.clickOutside();
        Thread.sleep(3000);
        base.sendFieldInputData(eluxFault,faultCode);
        base.clickOutside();
        Thread.sleep(3000);
//        base.highlightElement(eluxFaultArea);
//        base.sendFieldInputData(eluxFaultArea,faultArea);
//        base.clickOutside();
//        Thread.sleep(3000);
//        base.sendFieldInputData(eluxFault,faultCode);
//        base.clickOutside();


    }

}
