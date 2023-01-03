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

public class PlanSearchNPV {

    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//input[@id=\"Icq_policySearchInput\"]")
    private WebElement poicySearchInput;

    @FindBy(xpath = "//a[@onclick=\"PolicySearch();\"]/img")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@onclick=\"cancelPolicyConfirm('cd');\"]")
    private WebElement cancelButton;

    @FindBy(xpath = "//legend[contains(.,\"Plan Search\")]")
    private WebElement titleOfPage;



    public PlanSearchNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    public boolean isTitleOfPageVerified(){

        boolean status = false;
        try{
            base.waitForElementVisible(titleOfPage);
            if(base.checkIfELementIsAvailable(titleOfPage)){
                base.highlightElement(titleOfPage);
                status = true;
            } else {
                LOGGER.error("Failed to verify the title of the Page");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isHomePageLoaded(){

        boolean status = false;
        try{
            base.waitForElementVisible(poicySearchInput);
            if(base.checkIfELementIsAvailable(poicySearchInput)){
                base.highlightElement(poicySearchInput);
                status = true;
            } else {
                LOGGER.error("Failed to verify Home Page");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterPlanNoAndClickSearch(String planNo){

        try{
            if(!base.checkIfELementIsAvailable(poicySearchInput)){
                base.waitForElementVisible(poicySearchInput);
                if(!base.checkIfELementIsAvailable(poicySearchInput)) {
                    LOGGER.error("Unable to Find the Element - Policy Search Input Parameter");
                }
            } else {
                base.sendFieldInputData(poicySearchInput,planNo);
                if(base.isClickable(searchButton)) {
                    base.clickElement(searchButton);
                }else {
                    base.hardWait("2000");
                    base.isClickable(searchButton);
                    base.clickElement(searchButton);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
