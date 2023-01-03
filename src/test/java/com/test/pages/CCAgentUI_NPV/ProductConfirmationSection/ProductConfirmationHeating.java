package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

//import com.test.pages.CCAgent_OLDUI.MakeAClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationHeating {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
//    private MakeAClaimPage claimPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationHeating(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
//        MakeAClaimPage claimPage
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
//        this.claimPage = claimPage;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//legend[contains(.,\"Product Confirmation\")]")
    private WebElement pageHeader;

    @FindBy(xpath = "//input[@id=\"custVerifiedIMEI\"]")
    private WebElement verifiedWithCustCheckbox;

    @FindBy(xpath = "//fieldset[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    private WebElement modelInput;


    @FindBy(xpath = "//button[@onclick=\"confirmUnitType();\"]")
    private WebElement confirmBtn;

    @FindBy(id = "makeClaimBut")
    private WebElement continueButton;

    @FindBy(xpath="//button[@id='twoTwo'][contains(.,\"Product Confirmation\")]")
    private WebElement WB_productConfirmation;

    @FindBy(xpath="//input[@class='ui-state-default ui-combobox-input combopncModel-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
    private WebElement WB_modelInput;

    @FindBy(xpath="//input[@class='ui-state-default ui-combobox-input comboelecJobFaultLookup-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
    private WebElement WB_faultInput;

    @FindBy(xpath="//button[@id='makeClaimBut']")
    private WebElement WB_continueButton;






    public boolean isPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(pageHeader);
            if (base.checkIfELementIsAvailable(pageHeader)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmModel(String model) {
        if (isPageDisplayed()) {
            base.waitTillElementFound(modelInput);
            base.sendFieldInputData(modelInput, model);
            base.clickElement(verifiedWithCustCheckbox);
            base.clickElement(confirmBtn);
            base.hardWait("1000");
            enterContinueButton();
        }
    }


    public boolean isWBProductConfirmationPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(WB_productConfirmation);
            if (base.checkIfELementIsAvailable(WB_productConfirmation)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmModelAndFaultForWorcesterBosch(String model,String fault) throws InterruptedException {
        if (isWBProductConfirmationPageDisplayed()) {
            base.waitTillElementFound(WB_modelInput);
            base.sendFieldInputData(WB_modelInput, model);
            base.clickOutside();
            Thread.sleep(2000);
            base.sendFieldInputData(WB_faultInput, fault);
            base.clickOutside();
            Thread.sleep(2000);
            enterContinueButton();
        }
    }








    public void enterContinueButton() {
        base.clickElement(continueButton);
    }
}
