package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
//import cucumber.api.java.gl.E;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenJobAlertPopup {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String openJobAlertXpath = "//span[contains(.,\"Open Job Alert\")]";
    @FindBy(xpath = openJobAlertXpath)
    WebElement openJobAlertHeading;

    @FindBy(xpath = "//button/span[contains(.,\"Go to Open Claim\")]")
    WebElement goToOpenClaimButton;

    @FindBy(xpath = "//button/span[contains(.,\"Cancel\")]")
    WebElement cancelButton;

    public OpenJobAlertPopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(openJobAlertXpath) != null) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void goToOpenClaim() {
        base.waitTillElementFound(goToOpenClaimButton);
        base.clickElement(goToOpenClaimButton);
        base.waitForPageToLoad();

    }

    public void cancelOperation() {
        base.waitTillElementFound(cancelButton);
        base.clickElement(cancelButton);
    }


}
