
package com.test.pages.CCAgentUI_NPV.RepairManager;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RADataPage {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    private static String planDropDownXpath = "//*[@id=\"raData\"]//span[text(.,\"${value}\")]";
    private static String planExpiryDateXpath = "//span[text()=\"${value}\"]";

    @FindBy(id = "PolicyExpiryDate")
    private WebElement policyExpiryDateValue;


    @FindBy(id = "OpenClaimBtn")
    private WebElement openClaimBtn;


    @FindBy(id = "raAuthLineSummLink")
    private WebElement raAuthSummaryLink;


    @FindBy(xpath = "//div[text()='Scheme']")
    private WebElement scheme;


    @FindBy(xpath = "//label[text()='Renewal Date:']/../..//span")
    private WebElement renewalDate;



    public RADataPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    public boolean VerifyExpiryDate(String planDropDownValue,String planExpiryDate) throws InterruptedException {

        WebElement planDropDown =  seleniumHelper.getCustomElementByXpath(planDropDownXpath,planDropDownValue);
        WebElement expiryDate =  seleniumHelper.getCustomElementByXpath(planExpiryDateXpath,planExpiryDate);
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(planDropDown) && base.isClickable(planDropDown)){
                base.highlightElement(planDropDown);
                base.clickElement(planDropDown);
                if(expiryDate.isDisplayed()){
                    status = true;
                }
            } else {
                LOGGER.info("Unable to get the plan expiry date under ra data :"+expiryDate);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;

    }

    public boolean isPlanDateValueDisplayed(String spName){
        base.highlightElement(policyExpiryDateValue);
        return (policyExpiryDateValue.getText().equalsIgnoreCase(spName))?true:false;
    }


    public boolean clickOpenCliam(){

        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(openClaimBtn) && base.isClickable(openClaimBtn)){
                base.highlightElement(openClaimBtn);
                base.clickElement(openClaimBtn);
                status=true;
            } else {
                LOGGER.info("Unable to click open claim butoon:"+openClaimBtn);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;


    }



    public boolean clickSummaryLink(){

        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(raAuthSummaryLink) && base.isClickable(raAuthSummaryLink)){
                base.highlightElement(raAuthSummaryLink);
                base.clickElement(raAuthSummaryLink);
                status=true;
            } else {
                LOGGER.info("Unable to click summary link :"+raAuthSummaryLink);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;


    }

    public boolean clickSchemeAndVerifyRenewalDate(String spName){
        base.highlightElement(scheme);
        base.clickElement(scheme);

        return (renewalDate.getText().equalsIgnoreCase(spName))?true:false;
    }


}