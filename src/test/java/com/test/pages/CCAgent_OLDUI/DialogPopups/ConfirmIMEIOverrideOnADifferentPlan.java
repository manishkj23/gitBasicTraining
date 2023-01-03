package com.test.pages.CCAgent_OLDUI.DialogPopups;

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

public class ConfirmIMEIOverrideOnADifferentPlan {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    private final String popupAlert = "//div[@role=\"dialog\"]";
    @FindBy(xpath = popupAlert)
    private WebElement popupAlertWindow;

    @FindBy(xpath = "//div[@id=\"modP\"][contains(.,\"This IMEI  has been used previously on a different Plan.\")]")
    private WebElement popupTextTitle;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Override\")]")
    private WebElement overrideButton;

    public ConfirmIMEIOverrideOnADifferentPlan(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(popupAlert) != null && base.checkIfELementIsAvailable(popupTextTitle)) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void overrideIMEIonClaim() {
        try {
            if (isPopUpDisplayed() && base.checkIfELementIsAvailable(overrideButton)) {
                base.clickElement(overrideButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
