package com.test.pages.SiteMap.Whirlpoolimport;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobImportedAlert {

    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    //Find elements
    @FindBy(xpath = "//div[@role=\"dialog\"]//p[contains(.,\"Import Done\")]")
    private WebElement pageText;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"OK\")]")
    private WebElement confirmButton;

    public JobImportedAlert (BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isImportSuccessfulAlertDisplayed(){
        boolean status = false;
        try{
            if( base.checkIfELementIsAvailable(pageText)){
                base.highlightElement(pageText);
                status=true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public void confirmPopup(){
        base.clickElement(confirmButton);
    }
}