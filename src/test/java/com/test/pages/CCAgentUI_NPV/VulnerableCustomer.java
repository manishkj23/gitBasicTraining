package com.test.pages.CCAgentUI_NPV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VulnerableCustomer {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public VulnerableCustomer(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id=\"JobVulnerabilityForm\"]//legend[contains(.,\"Vulnerable Customer\")]")
    private WebElement pageHeading;

    @FindBy(xpath = "//p[contains(.,\"Vulnerability Categories\")]//button/span[1]")
    private WebElement buttonToSelectCategory;

    private static final String xpathToCaptureCategory = "//ul//span[contains(.,\"$(value)\")]/../input";
    private static final String xpathToCaptureAllCategories = "//ul//span[contains(.,\"\")]/../input";
//    @FindBy(xpath = xpathToCaptureCategory)

    @FindBy(xpath = "//a[contains(.,\"Save\")]")
    private WebElement saveButtonCategory;

    @FindBy(id = "Distressed")
    private WebElement distressedOption;

    @FindBy(id = "save_btn3")
    private WebElement saveButtonMain;

    public boolean isVulneribilityPopupPageDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(pageHeading)){
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void setVulnerability(String value){
        base.clickWithJsExecutor(buttonToSelectCategory);
        base.clickWithJsExecutor(seleniumHelper.getCustomElementByXpath(xpathToCaptureCategory,value));
        base.clickWithJsExecutor(saveButtonCategory);
        base.clickWithJsExecutor(distressedOption);
        base.clickWithJsExecutor(saveButtonMain);

    }

    public void setAllVulnerabilities(){
//        List
//        base.clickWithJsExecutor(buttonToSelectCategory);
//        seleniumHelper.getCustomListOfElementsByXpath(xpathToCaptureCategory,"");
//        base.clickWithJsExecutor(saveButtonCategory);
//        base.clickWithJsExecutor(distressedOption);
//        base.clickWithJsExecutor(saveButtonMain);
    }


}
