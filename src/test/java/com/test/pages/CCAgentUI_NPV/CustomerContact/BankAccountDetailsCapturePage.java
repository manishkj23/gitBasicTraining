package com.test.pages.CCAgentUI_NPV.CustomerContact;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccountDetailsCapturePage {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public BankAccountDetailsCapturePage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//div//b[contains(.,\"Bank Account Details Required\")]")
    private WebElement pageHeading;

    @FindBy(xpath = " //input[@id=\"sortCode1\"]")
    private WebElement sortCodeSection1;

    @FindBy(xpath = " //input[@id=\"sortCode2\"]")
    private WebElement sortCodeSection2;

    @FindBy(xpath = " //input[@id=\"sortCode3\"]")
    private WebElement sortCodeSection3;

    @FindBy(xpath = "//input[@id=\"accountNo\"]")
    private WebElement accountNumber;

    @FindBy(xpath = " //div[@onclick=\"validateDetails();\"]")
    private WebElement validatDetailsBtn;

    @FindBy(xpath = "//div/b[contains(.,\"Validation Error\")]")
    private WebElement validateErrorHeader;

    @FindBy(xpath = "//div[@id=\"validationErrorText\"]")
    private WebElement validateErrorMsgContent;




    public boolean isBankDetailsCapturePageDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(pageHeading)){
                base.highlightElement(pageHeading);
                status = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public void enterBankDetailsProvided(String sortCode,String accntNo){
        try{

            if(base.checkIfELementIsAvailable(sortCodeSection1)
                    && base.checkIfELementIsAvailable(sortCodeSection2)
                    && base.checkIfELementIsAvailable(sortCodeSection3)
                    && base.checkIfELementIsAvailable(accountNumber)){
                base.sendFieldInputData(sortCodeSection1,sortCode.trim().substring(0,2));
                base.sendFieldInputData(sortCodeSection2,sortCode.trim().substring(3,5));
                base.sendFieldInputData(sortCodeSection3,sortCode.trim().substring(6,8));
                base.sendFieldInputData(accountNumber,accntNo);
                base.isClickable(validatDetailsBtn);
                validatDetailsBtn.click();
                base.waitForPageToLoad();

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean isBankDetailsInvalidErrorDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(validatDetailsBtn)
                    && base.checkIfELementIsAvailable(validateErrorMsgContent) ) {
                base.highlightElement(validateErrorMsgContent);
                status = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

}