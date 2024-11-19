package com.test.pages.RepairerPortal.Excess;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcessAlertPage {

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[@id=\"modP\"][contains(.,\"A Call Out Charge of £\")]")
    private WebElement excessPaymentText;

    @FindBy(id = "ExcesspaymentRef")
    private WebElement excessPaymentRefTextArea;

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[@class=\"ui-dialog-buttonset\"]//button")
    private WebElement continueBtn;

    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName() );
    private static String EXCESS_ALERT_CONTENT_PART_1 = "A Call Out Charge of ";
    private static String EXCESS_ALERT_CONTENT_PART_2 = " will be required in order to book this claim. Once you have collected the excess, please record the payment reference";
    public ExcessAlertPage(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isExcessAlertPageDisplayed() {
        boolean status = false;
        try {
            if (excessPaymentText.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isExcessAmountMatched(String excessAmount) {
        boolean status = false;
        try {
            if (excessPaymentText.isDisplayed() && excessPaymentText.getText().contains(excessAmount)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isExcessAlertTextMatched(String excessAmount) {
        boolean status = false;
        try {
            if (excessPaymentText.isDisplayed() &&
                    excessPaymentText.getText().contains(EXCESS_ALERT_CONTENT_PART_1+"£"+excessAmount+EXCESS_ALERT_CONTENT_PART_2)) {
                base.highlightElement(excessPaymentText);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmExcessPayment(){
        base.waitForElementVisible(excessPaymentRefTextArea);
        excessPaymentRefTextArea.sendKeys("Amount collected");
        try {
            base.isClickable(continueBtn);
            base.clickElement(continueBtn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}