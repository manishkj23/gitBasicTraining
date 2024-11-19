package com.test.pages.RepairerPortal;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewJobBookingSuccessfulPopupPage {


    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName() );
    private static String EXCESS_ALERT_CONTENT_PART_1 = "A Call Out Charge of ";
    private static String EXCESS_ALERT_CONTENT_PART_2 = " will be required in order to book this claim. Once you have collected the excess, please record the payment reference";


    @FindBy(xpath = "//div[@role=\"dialog\"]//div[@id=\"modP\"][contains(.,\"Job successfully booked\")]")
    private WebElement jobSuccessfullyBookedMsg;

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[@class=\"ui-dialog-buttonset\"]//button[contains(.,\"Open Job\")]")
    private WebElement openJobBtn;

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[@class=\"ui-dialog-buttonset\"]//button[contains(.,\"Cancel\")]")
    private WebElement cancelBtn;


    public NewJobBookingSuccessfulPopupPage(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOpenJob(){

    }
    public boolean isJobSuccessfulPopupDisplayed() {
        boolean status = false;
        try {
            base.hardWait("5000");
            if (base.checkIfELementIsAvailable(jobSuccessfullyBookedMsg) && jobSuccessfullyBookedMsg.isDisplayed()) {
                base.highlightElement(jobSuccessfullyBookedMsg);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOpenJobButton(){
        base.clickElement(openJobBtn);
        base.hardWait("15000");
    }

}