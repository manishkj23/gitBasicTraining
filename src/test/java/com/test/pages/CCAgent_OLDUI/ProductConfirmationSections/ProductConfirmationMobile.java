package com.test.pages.CCAgent_OLDUI.ProductConfirmationSections;

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

public class ProductConfirmationMobile {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String popupProductConfirmationPath = "//fieldset[@id=\"SubUnitTypeSelectionFormID\"]/legend[contains(.,\"Product Confirmation\")]";
    @FindBy(xpath = popupProductConfirmationPath)
    private WebElement popupProductConfirmation;

    @FindBy(xpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    private WebElement chooseBrand;

    @FindBy(xpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/div[contains(.,\"Current IMEI\")]/div")
    private WebElement currentIMEILabel;

    @FindBy(xpath = "//input[@id=\"CurrentIMEI\"]")
    private WebElement currentIMEI;


    @FindBy(xpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]//span[@id=\"updateImeiSpan\"]")
    private WebElement updateIMEIButton;

    @FindBy(xpath = "//input[@name=\"NewIMEI\"]")
    private WebElement newIMEI;

    @FindBy(xpath = "//select[@id=\"ImeiUpdateReason\"]")
    private WebElement selectIMEIUpdateReason;

    @FindBy(xpath = "//*[@id=\"custVerifiedIMEI\"]")
    private WebElement verifiedWithCustomer;

    private final String confirmPath = "//*[@id=\"newUISubUnitType\"]//button[contains(.,\"Confirm\")]";
    @FindBy(xpath = confirmPath)
    private WebElement confirmButton;

    @FindBy(id = "makeClaimBut")
    private WebElement continueBtn;

    private final String productSelectionDropdownPath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/a/span[1]";

    @FindBy(xpath = productSelectionDropdownPath)
    private WebElement productSelectionDropdown;

    private static final String UPD_IMEI_REASON = "Device swapped during warranty period";

    public ProductConfirmationMobile(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.getElementFromXpath(popupProductConfirmationPath) != null) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmTheMake(String make) {
        if (base.checkIfELementIsAvailable(chooseBrand)) {
            base.sendFieldInputData(chooseBrand, make);
            base.clickElement(verifiedWithCustomer);
            if (base.getElementFromXpath(confirmPath) != null) {
                base.clickWithJsExecutor(confirmButton);
            }
        }

    }

    public void confirmIMEI() {
        try {
            if (isCurrentIMEIExist() && base.isClickable(verifiedWithCustomer) && base.isClickable(confirmButton)) {
                base.clickElement(verifiedWithCustomer);
                base.clickElement(confirmButton);
                base.isClickable(continueBtn);
                base.clickElement(continueBtn);
            } else {
                LOGGER.error("Unable to confirm the IMEI on the Product confirmation Page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCurrentIMEIExist() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(currentIMEI) && !currentIMEI.getAttribute("value").isEmpty()) {
                base.highlightElement(currentIMEI);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isCurrentIMEIExist(String iMEI) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(currentIMEI) && currentIMEI.getText().contains(iMEI)) {
                base.highlightElement(currentIMEI);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void updateCurrentIMEI(String iMEI) {
        try {
            if (base.isClickable(updateIMEIButton)) {
                base.clickElement(updateIMEIButton);
                base.checkIfELementIsAvailable(newIMEI);
                base.sendFieldInputData(newIMEI, iMEI);
                base.selectTextByVisibleText(selectIMEIUpdateReason, UPD_IMEI_REASON);
                base.isClickable(verifiedWithCustomer);
                base.clickElement(verifiedWithCustomer);
                base.clickElement(confirmButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
