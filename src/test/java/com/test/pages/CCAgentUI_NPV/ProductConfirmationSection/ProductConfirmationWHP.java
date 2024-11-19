package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

import com.test.pages.CCAgent_OLDUI.MakeAClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationWHP {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage claimPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationWHP(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage claimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.claimPage = claimPage;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]/div/span/input")
    private WebElement modelInput;

    @FindBy(xpath = "//div[@id=\"whirlpoolFCHolder\"]/span/input")
    private WebElement faultCode;

    @FindBy(xpath = "//div[@id=\"whirlpoolFCLookupHolder\"]/span/input")
    private WebElement problemCode;

    @FindBy(id = "makeClaimBut")
    private WebElement continueButton;



//    private final String model = "B3344FNFSP";
//    private final String fault = "FRE00301     - ACCESSORIES / COMPONENTS";
//    private final String problem = "157         - ACCESSORIES / COMPONENTS - MISSING";

    public boolean isPageDisplayed(){
        boolean status = false;
        try{
            base.waitTillElementFound(pageHeader);
            if(base.checkIfELementIsAvailable(pageHeader)){
                status = true;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void confirmModel() {
////        pageHeader.isDisplayed();
//        modelInput.sendKeys(Keys.SPACE);
//        base.selectTextByIndex(modelInput, 1);
//        base.hardWait("1000");
        try {

            base.checkElementPresence(modelInput);
            modelInput.sendKeys(Keys.ARROW_DOWN);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(modelInput, 0);
            if (modelInput.getAttribute("value").isEmpty()) {
                base.checkElementPresence(modelInput);
                modelInput.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(modelInput, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public void confirmFaultCode() {
        try {

            base.checkElementPresence(faultCode);
            faultCode.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(faultCode, 0);
            if (faultCode.getAttribute("value").isEmpty()) {
                base.checkElementPresence(faultCode);
                faultCode.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(faultCode, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void confirmProblemCode() {
        try{

            base.checkElementPresence(problemCode);
            problemCode.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(problemCode, 0);
            if (problemCode.getAttribute("value").isEmpty()) {
                base.checkElementPresence(problemCode);
                problemCode.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(problemCode, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterContinueButton(){
        base.clickWithJsExecutor(continueButton);
    }

    public void confirmModelFaultAndProblemCodeWHPPlans(String model, String fault, String problem) {
        if (isPageDisplayed()) {
            base.waitTillElementFound(modelInput);
            base.sendFieldInputData(modelInput, model);
            base.selectDropdownValueFromFilterList(modelInput, model);
            base.waitTillElementFound(faultCode);
            base.sendFieldInputData(faultCode, fault);
            base.waitTillElementFound(problemCode);
            base.sendFieldInputData(problemCode, problem);
            base.clickWithJsExecutor(continueButton);
        }
    }
}