package com.test.pages.RepairerPortal;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairerHomePage {

    @FindBy (xpath = "//a[@id=\"JobTypeID_47\"]")
    private WebElement newJobBooking;

    @FindBy(xpath = "//*[@id=\"jobSearch\"]")
    private WebElement planSearchField;

    @FindBy(xpath = "//*[@id=\"jobSearchForm\"]//img[contains(@onclick,\"planNumberSearch\")]")
    private WebElement planSearchIcon;

    @FindBy(xpath = "//*[@id=\"matches_table\"]/tbody/tr[1]/td[1]")
    private WebElement activeClaim;

    @FindBy(xpath = "//div[@class=\"DTTT_container\"]//span[contains(.,\"View Job Details\")]")
    private WebElement viewJobButton;

    @FindBy(xpath = "//legend[contains(.,\"System Notes\")]/..//table/tbody/tr[contains(.,\"Excess payment\")][contains(.,\"taken, Reference:\")]")
    private WebElement excessPaymentConfirmationSystemNote;

    @FindBy (xpath = "//*[text()=\"Menu\"]")
    private WebElement functionMenu;

    @FindBy (xpath = "//div[@id='Cancel_Claim']")
    private WebElement CancelClaim;


    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public RepairerHomePage(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        PageFactory.initElements(driver, this);
    }


    public boolean isRepairerHomePageDisplayed() {

        boolean status = false;
        try {
            if (planSearchField.isEnabled()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void searchPlan(String planNo) {
        try {
            if (planSearchField.isEnabled()) {
                planSearchField.sendKeys(planNo);
                Thread.sleep(2000);
                planSearchIcon.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickLatestClaim() {

        try {
            if (base.checkIfELementIsAvailable(activeClaim)) {
                activeClaim.click();
                Thread.sleep(2000);
                base.waitForElementVisible(viewJobButton);
                viewJobButton.click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickNewJobBooking() {

        try {
            if (base.checkIfELementIsAvailable(newJobBooking) && base.isClickable(newJobBooking)) {
                base.clickWithJsExecutor(newJobBooking);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExcessPaymentSystemNoteDisplayed(String excessAmount) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(excessPaymentConfirmationSystemNote)
                    && excessPaymentConfirmationSystemNote.isDisplayed()
                    && excessPaymentConfirmationSystemNote.getText().contains(excessAmount.substring(0,2))) {
                base.highlightElement(excessPaymentConfirmationSystemNote);
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickFunctionMenu() {

        try {
            if (base.checkIfELementIsAvailable(functionMenu) && base.isClickable(functionMenu)) {
                base.clickWithJsExecutor(functionMenu);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnCancelClaim() {

        try {
            if (base.checkIfELementIsAvailable(CancelClaim) && base.isClickable(CancelClaim)) {
                base.clickWithJsExecutor(CancelClaim);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}