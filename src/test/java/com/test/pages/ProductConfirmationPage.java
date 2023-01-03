package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String popupProductConfirmationPath = "//fieldset[@id=\"SubUnitTypeSelectionFormID\"]/legend[contains(.,\"Product Confirmation\")]";
    @FindBy(xpath = popupProductConfirmationPath)
    WebElement popupProductConfirmation;

    @FindBy(xpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    WebElement chooseBrand;

    @FindBy(xpath = "//*[@id=\"custVerifiedIMEI\"]")
    WebElement verifiedWithCustomer;

    private final String confirmPath = "//*[@id=\"SubUnitTypeSelectionFormID\"]//button[contains(.,\"Confirm\")]";
    @FindBy(xpath = confirmPath)
    WebElement confirmButton;

    private final String productSelectionDropdownPath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/a/span[1]";
    @FindBy(xpath = productSelectionDropdownPath)
    private WebElement productSelectionDropdown;

    public ProductConfirmationPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
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
        if(base.checkIfELementIsAvailable(chooseBrand)) {
            base.sendFieldInputData(chooseBrand,make);
            base.clickElement(verifiedWithCustomer);
            if(base.getElementFromXpath(confirmPath) != null ) {
                base.clickWithJsExecutor(confirmButton);
            }
        }

    }

    public void setTheProductFromList(int index){
        WebElement product = base.getElementFromXpath(productSelectionDropdownPath);
        try {
            if(product != null && product.isEnabled()) {
                base.clickElement(product);
                seleniumHelper.actionToMoveDownOnList(product,index);
                base.clickElement(verifiedWithCustomer);
                if(base.getElementFromXpath(confirmPath) != null ) {
                    base.clickWithJsExecutor(confirmButton);
                }
            } else {
                LOGGER.error("No Product selected");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSuchElementException el){
            el.printStackTrace();
        }
    }

}
