package com.test.pages.CCAgentUI_NPV.BookingOverview.WriteOffAutorizationPage;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateColor {

    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public UpdateColor(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Update Colour\")]")
    private WebElement pageTitle;

    @FindBy(id = "ppf_ApplianceColour")
    private WebElement selectApplianceColour;

    @FindBy(id = "ppf_ApplianceColourReason")
    private WebElement reasonToUpdate;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Finish\")]")
    private WebElement finishBtn;

    public boolean isUpdateColorPopupScreenAppeared() {

        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(pageTitle)) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public void updateColour() {
        if (isUpdateColorPopupScreenAppeared()) {
            base.isClickable(selectApplianceColour);
            base.selectTextByIndex(selectApplianceColour, 1);
            base.sendFieldInputData(reasonToUpdate, "test");
            base.waitTillElementFound(finishBtn);
            base.clickElement(finishBtn);
        } else {
            LOGGER.info("Unable to update the Appliance Colour");
        }
    }
}
