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

public class BabyPlanViewPage {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public BabyPlanViewPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    private static String selectedBabyPlanOnListXpath = "//div[@id=\"PlanView_Page\"]//table//tr[contains(.,\"${value}\")]/td[5]";

    @FindBy(xpath = "//div[@id=\"PlanView_Errors\"]//b")
    private WebElement babyPlanViewPageText;

    @FindBy(xpath = "//div[@id='babyPlanTable']")
    private WebElement babyPlanTable ;

    public boolean isBabyPlanPageDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(babyPlanViewPageText) &&
                    babyPlanViewPageText.getText().toLowerCase().contains("select a baby plan")){

                base.highlightElement(babyPlanViewPageText);
                status = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public void navigateToBabyPlan(String babyPlanNo){
        WebElement babyPlanSelected =  seleniumHelper.getCustomElementByXpath(selectedBabyPlanOnListXpath,babyPlanNo);
        try{
            if(babyPlanSelected!= null && base.checkIfELementIsAvailable(babyPlanSelected) && base.isClickable(babyPlanSelected)){
                base.highlightElement(babyPlanSelected);
                base.clickElement(babyPlanSelected);
                base.waitForPageToLoad();
            } else {
                LOGGER.info("Unable to get the Baby Plan listed on the plan view page :"+babyPlanNo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isBabyPlanTableIsDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(babyPlanTable)) {
                base.highlightElement(babyPlanTable);
                status = true;
            } else {
                LOGGER.error("Unable to verify the Baby Plan Table");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}