package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationMobileColorAndCapacity {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationMobileColorAndCapacity(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(.,\"Product Confirmation\")]")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[label[contains(.,\"Color\")]]//input")
    private WebElement color;

    @FindBy(xpath = "//div[label[contains(.,\"Memory Capacity\")]]//input")
    private WebElement capacity;

    @FindBy(xpath = "//div[@id='flush-collapseTwo']//div[label[contains(.,\"Serial Number\")]]//input")
    private WebElement serialNumber;

    @FindBy(xpath = "//fieldset[@id='SubUnitTypeSelectionFormID']//input[@id='custVerifiedIMEI']")
    private WebElement confirmApplianceCheckboxCheck;

    @FindBy(xpath = "//div[@id='newUISubUnitType']//button[@type='button'][contains(text(),'Confirm')]")
    private WebElement confirmApplianceConfirmButton;

    @FindBy(id = "makeClaimBut")
    private WebElement continueBtn;

    public boolean isProductConfirmationSectionDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(pageHeader) &&
                    base.checkIfELementIsAvailable(color) &&
                    base.checkIfELementIsAvailable(capacity)) {
                status = true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmColorAndCapacity() {
        if (!base.checkIfELementIsAvailable(color)) {
//            base.waitTillElementFound(color);
            base.hardWait("10000");
        }
        base.sendFieldInputData(color, "Black");

        if (!base.checkIfELementIsAvailable(capacity)) {
            base.waitTillElementFound(capacity);
        }
        base.sendFieldInputData(capacity, "64");

        if (!base.checkIfELementIsAvailable(confirmApplianceCheckboxCheck)) {
            base.waitTillElementFound(confirmApplianceCheckboxCheck);
        }
        base.clickWithJsExecutor(confirmApplianceCheckboxCheck);

        if (!base.checkIfELementIsAvailable(confirmApplianceConfirmButton)) {
            base.waitTillElementFound(confirmApplianceConfirmButton);
        }
        base.clickWithJsExecutor(confirmApplianceConfirmButton);

        base.isClickable(continueBtn);
        base.clickElement(continueBtn);
    }

    public void confirmSNumber() {
        int i=9;
        if (!base.checkIfELementIsAvailable(serialNumber)) {
            base.waitTillElementFound(serialNumber);
        }
        base.sendFieldInputData(serialNumber, base.getAlphaNumericString(i));
    }

    public void confirmSerialNumber() throws InterruptedException {
        Thread.sleep(5000);
        int i = 10;
        if (!base.checkIfELementIsAvailable(serialNumber)) {
            Thread.sleep(5000);
            base.waitTillElementFound(serialNumber);
        }
        Thread.sleep(5000);
        base.sendFieldInputData(serialNumber, base.getAlphaNumericString(i));
    }

}