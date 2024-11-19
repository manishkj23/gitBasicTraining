package com.test.pages.CCAgent_OLDUI;

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

public class ServiceProviderAvailabilityPopup {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String SPAvailabilityPopupHeadingXpath = "//div[@role=\"dialog\"]//span[contains(.,\"SERVICE PROVIDER APPOINTMENT AVAILABILITY\")]";
    @FindBy(xpath = SPAvailabilityPopupHeadingXpath)
    WebElement openJobAlertHeading;

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Close\")]")
    WebElement popupCloseButton;

    public ServiceProviderAvailabilityPopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.getElementFromXpath(SPAvailabilityPopupHeadingXpath) != null) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void closePopup() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        base.waitTillElementFound(popupCloseButton);
        base.clickElement(popupCloseButton);
        base.waitForPageToLoad();

    }

}