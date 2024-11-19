package com.test.pages.SiteMap.Whirlpoolimport;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportJobWhirlpool {

    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    //Find elements
    @FindBy(xpath = "//legend[contains(.,\"Job Import Wizard (Whirlpool)\")]")
    private WebElement pageTitle;

    @FindBy(xpath = "//input[@id=\"import_file_dmw\"]")
    private WebElement chooseFileInput;

    @FindBy(xpath = "//input[@id=\"import_btn\"]")
    private WebElement importFileBtn;




    public static final String claimTypeXpath = "//div[@id=\"BookingTypeHolder\"]/div[contains(.,\"${value}\")]";
    public ImportJobWhirlpool (BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isJobImportPageLoaded() {
        try {
            base.waitForPageToLoad();
            base.waitTillElementFound(pageTitle);
            base.highlightElement(pageTitle);
            LOGGER.info("==============>>>>>> Page Displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (pageTitle.isDisplayed()) ? true : false;
    }


    public void loadImportFile(){
        base.checkIfELementIsAvailable(chooseFileInput);
        base.sendFieldInputData(chooseFileInput,System.getProperty("user.dir") + "/target/importfile.csv");
        base.checkIfElementIsNotNull(importFileBtn);
        base.clickElement(importFileBtn);
    }


}