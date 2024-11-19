package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

import com.test.pages.CCAgent_OLDUI.MakeAClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationTelevision {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage claimPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationTelevision(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage claimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.claimPage = claimPage;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//legend[contains(.,\"Product Confirmation\")]")
    private WebElement pageHeader;

    @FindBy(xpath = "//input[@id=\"custVerifiedIMEI\"]")
    private WebElement verifiedWithCustCheckbox;

    @FindBy(xpath = "//div[@id='nonWPProductConfirmationInner']//fieldset[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    private WebElement modelInput;

    @FindBy(id = "makeClaimBut")
    private WebElement continueButton;


    @FindBy(xpath = "//button[@onclick=\"confirmUnitType();\"]")
    private WebElement confirmBtn;

    private final String model55InchTv = "Television - 55\" (140cm) & above";

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

    public void confirmModel(String model){
        if(isPageDisplayed()){
            base.waitTillElementFound(modelInput);
            base.sendFieldInputData(modelInput,model);
            base.clickElement(verifiedWithCustCheckbox);
            base.clickWithJsExecutor(confirmBtn);
        }
    }

    public void confirmDefaultSizeModel(){
//        if(isPageDisplayed()){
        base.waitTillElementFound(modelInput);
//            base.selectDropdownValueFromFilterList(modelInput,model55InchTv);
        base.sendFieldInputData(modelInput,model55InchTv);
        base.clickElement(verifiedWithCustCheckbox);
        base.clickWithJsExecutor(confirmBtn);
        base.hardWait("1000");
        enterContinueButton();
//        }
    }

    public void enterContinueButton(){
        base.clickWithJsExecutor(continueButton);
    }
}