package com.test.pages.CCAgentUI_NPV.CustomerContactView;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertRequestSentPopup {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public AlertRequestSentPopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[contains(.,\"Request Sent\")]")
    private WebElement requestSentAlertPopup;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Confirm\")]")
    private WebElement popupConfirmBtn;

    public boolean isRequestSentAlertPopupDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(requestSentAlertPopup)){
                base.highlightElement(requestSentAlertPopup);
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public void confirmPopup(){
        if(!base.isClickable(popupConfirmBtn)){
            base.waitTillElementFound(popupConfirmBtn);

        }
        base.clickElement(popupConfirmBtn);
    }
}