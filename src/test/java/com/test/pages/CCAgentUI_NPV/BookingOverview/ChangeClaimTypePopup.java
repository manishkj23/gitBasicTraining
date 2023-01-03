package com.test.pages.CCAgentUI_NPV.BookingOverview;

import com.test.steps.Steps_NPV.NPVHomePageStepDef;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeClaimTypePopup {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private static final Logger LOGGER = LoggerFactory.getLogger(NPVHomePageStepDef.class);

    public ChangeClaimTypePopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//fieldset[@id=\"ChangeClaimTypeForm\"]/legend[contains(.,\"Change Claim Type\")]")
    private WebElement changeClaimTypeHeader;

    @FindBy(xpath = "//select[@id=\"ClaimTypeID\"]/../span/input")
    private WebElement newClaimTypeID;

    @FindBy(id = "ReasonNote")
    private WebElement reasonForClaimTypeID;

    @FindBy(xpath = "//button[contains(.,\"Confirm\")]")
    private WebElement confirmPopupBtn;

    public boolean isChangeClaimTypePopupDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(changeClaimTypeHeader)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void changeClaimType(String clmTyp) {
        if (isChangeClaimTypePopupDisplayed()) {
            base.sendFieldInputData(newClaimTypeID, clmTyp);
            base.sendFieldInputData(reasonForClaimTypeID, "10Characters to be added");
            base.clickElement(confirmPopupBtn);
        } else {
            LOGGER.info("Unable to change the ClaimType to :" + clmTyp);
        }
    }

}
