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

public class WaiveCalloutChargePage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String pageHeading = "//*[@id=\"waiveExcess\"]//legend[contains(.,\"Waive Call Out Charge Payment\")]";
    @FindBy(xpath = pageHeading)
    private WebElement waiveCalloutChargePageHeading;

    @FindBy(xpath = "//*[@id=\"NewValue\"]")
    private WebElement newValueToBeWaived;

    @FindBy(xpath = "//select[@id=\"WaiveReason\"]")
    private WebElement selectWaiveReason;

    @FindBy(xpath = "//*[@id=\"waiveExcess\"]//button[contains(.,\"Proceed\")]")
    private WebElement proceedWaiveExcessButton;

    @FindBy(xpath = "//*[@id=\"waiveExcess\"]//button[contains(.,\"Cancel\")]")
    private WebElement cancelWaiveExcessButton;

    // Constants :
    private final String WAIVE_REASON = "Gesture of goodwill waiver";

    public WaiveCalloutChargePage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(pageHeading) != null) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void waiveExcessPayment() {
        if(isPopUpDisplayed()) {
            base.sendFieldInputData(newValueToBeWaived,"0");
            base.selectTextByVisibleText(selectWaiveReason,WAIVE_REASON);
            if(base.checkIfELementIsAvailable(proceedWaiveExcessButton)) {
                base.clickWithJsExecutor(proceedWaiveExcessButton);
            }
        }

    }

}
