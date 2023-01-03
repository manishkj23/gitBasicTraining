package com.test.pages.CCAgent_OLDUI.DialogPopups;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepeatRepairNotice {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@role=\"dialog\"]//button[contains(.,\"Ok\")]")
    private WebElement okButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//span[contains(.,\"Repeat Repair Notice\")]")
    private WebElement repeatRepairNoticeDialog;

    private static final String repeatRepairDialogXpath = "//*[@role=\"dialog\"]//span[contains(.,\"Repeat Repair Notice\")]";

    public RepeatRepairNotice(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public void handleRepeatRepairNotice() {
        WebElement dialogBox = null;
        try {
            dialogBox = base.getElementFromXpath(repeatRepairDialogXpath);
            if (dialogBox != null && dialogBox.isDisplayed()) {
                base.isClickable(okButton);
                base.clickElement(okButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
