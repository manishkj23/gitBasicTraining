package com.test.pages.CCAgentUI_NPV.Product;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationModelNumber {


    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]//select[@id=\"ModleID\"]/../span/input")
    private WebElement ModelNumber;

    @FindBy(xpath = "//*[@id=\"whirlpoolFCHolder\"]/span/input")
    private WebElement faultCode;

    @FindBy(xpath = "//*[@id=\"JobFaultCodeID\"]")
    private WebElement faultCodeSelectBox;

    @FindBy(xpath = "//*[@id=\"whirlpoolFCLookupHolder\"]/span/input")
    private WebElement problemCode;

    @FindBy(xpath = "//*[@id=\"JobFaultCodeLookupID\"]")
    private WebElement problemCodeSelectBox;

    @FindBy(xpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    private WebElement selectModelNumber;

    @FindBy(xpath = "//*[@id=\"ModleID\"]")
    private WebElement modelNumberSelectBox;


    private static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public ProductConfirmationModelNumber(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    private void enterModelNumber(String value) {
        try {
            base.waitTillElementFound(selectModelNumber);
            if (selectModelNumber.isDisplayed() & selectModelNumber.getText() == null) {
                base.clearText(selectModelNumber);
                base.sendFieldInputData(selectModelNumber, value);
                seleniumHelper.actionToMoveDownOnList(selectModelNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to find the Model Number : " + value);
        }

    }

    private void enterFaultCode(String value) {
        try {
            base.waitToLoadElement();
            if (faultCode.isDisplayed()) {
                base.sendFieldInputData(faultCode, value);
                base.waitToLoadElement();
                seleniumHelper.actionToMoveDownOnList(faultCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to find the Fault Code contains value : " + value);
        }

    }

    private void enterProblemCode(String value) {
        try {
            base.waitToLoadElement();
            if (problemCode.isDisplayed()) {
                base.sendFieldInputData(problemCode, value);
                base.waitToLoadElement();
                seleniumHelper.actionToMoveDownOnList(problemCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to find the Fault Code contains value : " + value);
        }

    }

    public void enterModelFaultAndProblemCode(String modelNumber, String faultCode, String problemCode) {
        enterModelNumber(modelNumber);
        enterFaultCode(faultCode);
        enterProblemCode(problemCode);
        base.waitToLoadElement();
    }

}