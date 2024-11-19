package com.test.pages.CCAgentUI_NPV.ReciperoQATree.QApopups;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FMIEnabledPopup {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public FMIEnabledPopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[contains(text(),\"FMI Enabled\")]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@id=\"UIqaRuleDiv\"]//center[contains(.,\"FMI Status is LOST\")]")
    private WebElement fmiLostStatusmsgArea;

    @FindBy(xpath = "//div[@id=\"UIqaRuleDiv\"]//button[contains(.,\"Continue\")]")
    private WebElement continueToClaim;

    @FindBy(xpath = "//div[@id=\"UIqaRuleDiv\"]//button[contains(.,\"Override\")]")
    private WebElement overRideBtn;


    public boolean isPageDisplayed(){
        boolean status = false;
        try{
            base.waitForPageToLoad();
            base.waitTillElementFound(pageTitle);
            if(base.checkIfELementIsAvailable(pageTitle)){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public boolean isFmiLostMessageDisplayed(){
        boolean status = false;
        try{
            base.waitForPageToLoad();
            base.waitTillElementFound(fmiLostStatusmsgArea);
            if(base.checkIfELementIsAvailable(fmiLostStatusmsgArea)){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public void continueToClaim(){
        base.waitTillElementFound(continueToClaim);
        if(!base.isClickable(continueToClaim)){
            base.hardWait("2000");
        }
        base.clickElement(continueToClaim);
    }
}