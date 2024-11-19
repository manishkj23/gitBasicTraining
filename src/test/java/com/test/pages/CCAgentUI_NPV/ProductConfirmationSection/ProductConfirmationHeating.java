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
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationHeating {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage claimPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationHeating(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage claimPage) {
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

    @FindBy(xpath = "//fieldset[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    private WebElement modelInput;

    @FindBy(xpath = "//div[@id='newUISubUnitType']//button[@onclick=\"confirmUnitType();\"]")
    private WebElement confirmBtn;

    @FindBy(id = "makeClaimBut")
    private WebElement continueButton;

    @FindBy(xpath = "//select[@name=\"pncModel\"]/..//input")
    private WebElement modelInputField;

    @FindBy(xpath = "//select[@id=\"elecJobFaultLookup\"]/..//input")
    private WebElement faultInputField;

    @FindBy(xpath = "//button[@id='twoTwo'][contains(.,\"Product Confirmation\")]")
    private WebElement WB_productConfirmation;

    @FindBy(xpath = "//input[@class='ui-state-default ui-combobox-input combopncModel-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
    private WebElement WB_modelInput;

    @FindBy(xpath = "//input[@class='ui-state-default ui-combobox-input comboelecJobFaultLookup-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
    private WebElement WB_faultInput;

    @FindBy(xpath = "//div[@id='ProductConfirmationInner']//select[@id=\"pncModel\"]")
    private WebElement NonOem_ModelDropdown;

    @FindBy(xpath = "//div[@id='ProductConfirmationInner']//div[contains(text(),'the bo')]//input[@value='Yes']")
    private WebElement NonOem_BoilerFaultYesRadioButton;

    @FindBy(xpath = "//div[@id='ProductConfirmationInner']//input[@id='boiler_fault_text']")
    private WebElement NonOem_BoilerFaultCodeTextBox;

    @FindBy(xpath = "//button[@id='twoTwo'][contains(.,'Product Confirmation')]")
    private WebElement productConfirmationPageHeader;

    @FindBy(xpath = "//div[@id=\"isCustomerApplianceReusableDiv\"]")
    private WebElement CXApplianceUsableFieldDisplayed;

    @FindBy(xpath = "//input[@id=\"pncmSerial\"]")
    private WebElement SNCaptureFieldForBeko;

    @FindBy(xpath = "//*[@id=\"boilerFaultDiv\"]/div[1]")
    private WebElement boilerFaultCodeSection;

    private final String cxApplianceUsable = "//div[@id='CustApplicationUsable']/div[@id='isCustomerApplianceReusableDiv']/input[contains(@value,\"Yes\")]";
    @FindBy(xpath = cxApplianceUsable)
    private WebElement cxApplianceUsableRadioButton;

    @FindBy(xpath = "//div[@id='CustApplicationUsable']/div[@id='isCustomerApplianceReusableDiv']/label")
    private WebElement cxApplianceUsableField;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanData_Content\"]//table//tr//b[contains(.,'Serial')]//following::*[name()='br'][1]")
    private WebElement SNValueOnPlanviewpageForBEKO;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanData_Content\"]//table//tr//b[contains(.,'Serial')]//following::*[name()='br'][1]")
    private WebElement SNValueOnPlanviewpageForBAXI;

    @FindBy(xpath = "//div[@id=\"pncNoCode\"]//input[@id=\"mlcCode\"]")
    private WebElement SNCaptureFieldForBaxi1;

    @FindBy(xpath = "//div[@id=\"pncNoCode\"]//input[@id=\"pncSerial\"]")
    private WebElement SNCaptureFieldForBaxi2;

//    @FindBy(xpath = "(//td[@class='PlanDataField']/b[contains(text(),Make)]/following-sibling::br/following-sibling::text())[7]")
//    private WebElement OEM;

    private final String oem = "//div[@id='PlanView_PlanData_Wrapper']/div/table[@id=\"PlanView_PlanData_Table\"]/tbody/tr[6]/td[2]";
    @FindBy(xpath = oem)
    private WebElement OEMPath;

    private final String OEMName = "BAXI";

    @FindBy(xpath = "//div[@id=\"PlanView_PlanData_Content\"]//table//tr//b[contains(.,'Serial')]//following::*[name()='br']//following::i[contains(.,'None')]")
    private WebElement snOnGetPlanDetails;

    @FindBy(xpath = "//div[@id='flush-collapseTwo']//div[@id=\"ProductConfirmationInner\"]//p//input[@value='yes'][@type='radio']")
    private WebElement clickYestoProvideSnDetails;

    private static final String yesOrNoRadioButtonToProvideSnDetails = "//div[@id='flush-collapseTwo']//div[@id=\"ProductConfirmationInner\"]//p//input[@value=\"${value}\"][@type='radio']";


    @FindBy(xpath = "//div[@id='flush-collapseTwo']//div[@id=\"ProductConfirmationInner\"]//p//input[@value='no'][@type='radio']")
    private WebElement clickNotoProvideSnDetails;

    @FindBy(xpath = "//div[@id=\"modP\"]")
    private WebElement inValidSNPopup;

    public final String inValidSNAlert = "Please Enter Valid Serial Number";

    @FindBy(xpath = "//button[@class=\"btnStandard\"]")
    private WebElement closeSNAlertPopup;

    @FindBy(xpath = "//span[contains(.,'SerialNo Pattern')]")
    private WebElement inValidSNPopupForBeko;

    public final String inValidSNAlertForBeko = "SerialNo Pattern";

    @FindBy(xpath = "//select[@id='mUnitTypeID']//following::span//input")
    private WebElement productTypeInputField;

    private static final String serialNoCheckBox = "//p[contains(text(),'Can the customer provide the boilers serial number?')]//following::input[@value=\"${value}\"]";

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

    public void confirmModel(String model) throws InterruptedException {
//        if(isPageDisplayed()){
        Thread.sleep(5000);
        base.waitTillElementFound(modelInput);
        Thread.sleep(5000);
        base.sendFieldInputData(modelInput, model);
        Thread.sleep(5000);
        base.selectTextByIndex(modelInput,0);
        Thread.sleep(5000);
//        base.clickElement(verifiedWithCustCheckbox);
//            base.clickElement(confirmBtn);
//        base.clickWithJsExecutor(confirmBtn);
//        base.hardWait("1000");
//        enterContinueButton();
    }


    public void enterHeatingModelFromDropdwn() {
        base.hardWait("10000");
        // modelInputField.sendKeys(Keys.ARROW_DOWN);
        modelInputField.sendKeys(Keys.DOWN);
        try {
            seleniumHelper.actionToMoveDownOnList(modelInputField, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterFaultInputDataDropdown(String fault) {

        faultInputField.sendKeys(fault);
        try {
            seleniumHelper.actionToMoveDownOnList(faultInputField, 0);
//            base.sendFieldInputData(faultInputField, fault);
//            base.clickOutside();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterContinueButton() {
        base.clickElement(continueButton);
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

    public void confirmModelAndFaultForWorcesterBosch(String model, String fault) throws InterruptedException {
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

    public boolean isProductConfirmationPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(productConfirmationPageHeader);
            if (base.checkIfELementIsAvailable(productConfirmationPageHeader)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmModelAndBoilerFaultForNonOemBoilersPlans(String modelNumber, String fault) throws InterruptedException {
        if (productConfirmationPageHeader.isDisplayed()) {
            base.highlightElement(productConfirmationPageHeader);
            base.waitTillElementFound(NonOem_ModelDropdown);
            base.highlightElement(NonOem_ModelDropdown);
            Select modelDropdown = new Select(NonOem_ModelDropdown);
//            modelDropdown.selectByValue(modelNumber);
            modelDropdown.selectByVisibleText(modelNumber);
//            modelDropdown.selectByValue("287923");
//            base.clickWithJsExecutor(NonOem_ModelDropdown);
//            NonOem_ModelDropdown.sendKeys(Keys.ARROW_DOWN);
//            try {
//                seleniumHelper.actionToMoveDownOnList(NonOem_ModelDropdown,0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
        Thread.sleep(2000);
        base.clickWithJsExecutor(NonOem_BoilerFaultYesRadioButton);
        Thread.sleep(1000);
        base.sendFieldInputData(NonOem_BoilerFaultCodeTextBox, fault);
        Thread.sleep(1000);
//        enterContinueButton();

    }

    public void confirmApplianceDetails(String make) {
//        if(isPageDisplayed()){
        base.waitTillElementFound(modelInput);
        base.sendFieldInputData(modelInput, make);
        base.clickElement(verifiedWithCustCheckbox);
//            base.clickElement(confirmBtn);
        base.clickWithJsExecutor(confirmBtn);
//        base.hardWait("1000");
//        enterContinueButton();
    }

    public void confirmModelNumberForBoilerPlans(String modelNumber) throws InterruptedException {
        if (productConfirmationPageHeader.isDisplayed()) {
            base.highlightElement(productConfirmationPageHeader);
            base.waitTillElementFound(NonOem_ModelDropdown);
            base.highlightElement(NonOem_ModelDropdown);
            Select modelDropdown = new Select(NonOem_ModelDropdown);
//            modelDropdown.selectByValue(modelNumber);
            modelDropdown.selectByVisibleText(modelNumber);
//            modelDropdown.selectByValue("287923");
//            base.clickWithJsExecutor(NonOem_ModelDropdown);
//            NonOem_ModelDropdown.sendKeys(Keys.ARROW_DOWN);
//            try {
//                seleniumHelper.actionToMoveDownOnList(NonOem_ModelDropdown,0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }

    public boolean verifyBoilerFaultCodeSectionIsNotPresent() {
        boolean Status = false;
        try {
            if (!(base.checkIfELementIsAvailable(boilerFaultCodeSection) && base.waitForElementVisible(boilerFaultCodeSection))) {
                Status = true;
                LOGGER.info(" Boiler fault code section is not present");
            } else {
                LOGGER.info(" Boiler fault code section is present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status;
    }

    public boolean verifyCxApplianceUsableSelect() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(cxApplianceUsableField) && base.waitForElementVisible(cxApplianceUsableRadioButton)) {
                base.highlightElement(cxApplianceUsableField);
                base.highlightElement(cxApplianceUsableRadioButton);
                base.clickWithJsExecutor(cxApplianceUsableRadioButton);
                status = true;
            } else {
                LOGGER.info("CX Usable Appliance radio button is not clickable");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isCXApplianceUsableFieldDisplayed() {
        boolean status = false;
        try {
            base.highlightElement(CXApplianceUsableFieldDisplayed);
            if (base.checkIfELementIsAvailable(CXApplianceUsableFieldDisplayed)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean isSNCaptureFieldPrePopulated() {
        boolean status = false;

        String getOEM = OEMPath.getText().substring(5);

        if (getOEM.equals(OEMName)) {
            base.waitTillElementFound(SNCaptureFieldForBaxi1);
            base.waitTillElementFound(SNCaptureFieldForBaxi2);
            String getSNValueatPlanviewPageForBAXI = SNValueOnPlanviewpageForBAXI.getText();
            String SNField1 = SNCaptureFieldForBaxi1.getText();
            String SNField2 = SNCaptureFieldForBaxi2.getText();
            if (SNField1 != null && SNField2 != null) {
                String SNvalueForBAXI = "SNField1" + "SNField2";
                getSNValueatPlanviewPageForBAXI.equals(SNvalueForBAXI);
                status = true;
            } else {
                LOGGER.info("SN is not matched to getplandetails for BAXI");
            }

        } else {
            base.waitTillElementFound(SNCaptureFieldForBeko);
            String getSNValueatPlanviewPageForBEKO = SNValueOnPlanviewpageForBEKO.getText();
            if (base.isElementAvailable(SNCaptureFieldForBeko)) {
                base.highlightElement(SNCaptureFieldForBeko);
                if (SNCaptureFieldForBeko != null) {
                    SNCaptureFieldForBeko.getText();
                    getSNValueatPlanviewPageForBEKO.equals(SNCaptureFieldForBeko);
                    status = true;
                } else {
                    LOGGER.info("SN is not matched to getplandetails for BEKO");
                }
            }
        }
        return status;
    }

    public boolean verifyIfSNIsPresentOnThePlan() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(snOnGetPlanDetails)) {
                base.highlightElement(snOnGetPlanDetails);
                status = true;
            } else {
                LOGGER.info("SN value on getplandetails is not None");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickYesButtonProvideSnDetails() {
        if (base.checkIfELementIsAvailable(clickYestoProvideSnDetails)) {
            base.clickWithJsExecutor(clickYestoProvideSnDetails);
        } else {
            LOGGER.info("Radio button to provide SN is not clickable");
        }
    }

    public boolean enterSNDetails(String yesorno) {
        boolean status = false;
        try {
            String getOEM = OEMPath.getText().substring(5);
            LOGGER.info("Manufacturer is: " + getOEM);

            if (getOEM.equals(OEMName)) {
                clickYesButtonProvideSnDetails();

                base.checkIfELementIsAvailable(SNCaptureFieldForBaxi1);
                base.checkIfELementIsAvailable(SNCaptureFieldForBaxi2);

                String inValidSN1 = "AD";
                String inValidSN2 = "34REO45JK";
                base.sendFieldInputData(SNCaptureFieldForBaxi1, inValidSN1);
                base.sendFieldInputData(SNCaptureFieldForBaxi2, inValidSN2);

                base.clickOutside();

                String inValidSNAlertText = inValidSNPopup.getText();
                if (inValidSNAlertText.equalsIgnoreCase(inValidSNAlert)) {
                    base.highlightElement(inValidSNPopup);
                } else {
                    LOGGER.error("SN invalid alert validation failed");
                }

                if (base.checkIfELementIsAvailable(closeSNAlertPopup)) {
                    base.clickWithJsExecutor(closeSNAlertPopup);
                    base.checkIfElementIsNotNull(SNCaptureFieldForBaxi1);
                    base.checkIfElementIsNotNull(SNCaptureFieldForBaxi2);
                    base.clearText(SNCaptureFieldForBaxi1);
                    base.clearText(SNCaptureFieldForBaxi2);

                    base.sendFieldInputData(SNCaptureFieldForBaxi1,base.generateRandomAlphabetForBaxi());
                    Thread.sleep(2000);
                    base.sendFieldInputData(SNCaptureFieldForBaxi2,base.generateSerialNumber());
                }
            } else {
                if (base.checkIfELementIsAvailable(SNCaptureFieldForBeko)) {
                    base.highlightElement(SNCaptureFieldForBeko);

                    String inValidSNForBEKO = "9976356";
                    base.sendFieldInputData(SNCaptureFieldForBeko, inValidSNForBEKO);

                    base.clickOutside();

                    String inValidSNAlertTextForBeko = inValidSNPopupForBeko.getText();
                    if (inValidSNAlertTextForBeko.equalsIgnoreCase(inValidSNAlertForBeko)) {
                        base.highlightElement(inValidSNPopupForBeko);
                    } else {
                        LOGGER.error("SN value is invalid for BEKO");
                    }

                    if (base.checkIfELementIsAvailable(closeSNAlertPopup)) {
                        base.clickWithJsExecutor(closeSNAlertPopup);
                        base.checkIfElementIsNotNull(SNCaptureFieldForBeko);
                        base.clearText(SNCaptureFieldForBeko);

                        String validSNForBeko = "1220701007";
                        base.sendFieldInputData(SNCaptureFieldForBeko, validSNForBeko);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickYesOrNoToProvideBoilersSerialNumber(String yesorno) {
        try {
            if (base.isClickable(seleniumHelper.getCustomElementByXpath(yesOrNoRadioButtonToProvideSnDetails, yesorno))) {
                base.highlightElement(seleniumHelper.getCustomElementByXpath(yesOrNoRadioButtonToProvideSnDetails, yesorno));
                Thread.sleep(3);
                base.clickWithJsExecutor(seleniumHelper.getCustomElementByXpath(yesOrNoRadioButtonToProvideSnDetails, yesorno));
            } else {
                LOGGER.info("Radio button to provide SN is not clickable");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public boolean enterSNDetailsForBaxi() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(SNCaptureFieldForBaxi1) && base.checkIfELementIsAvailable(SNCaptureFieldForBaxi2)) {
                base.highlightElement(SNCaptureFieldForBaxi1);
                base.highlightElement(SNCaptureFieldForBaxi2);
                base.sendFieldInputData(SNCaptureFieldForBaxi1,base.generateRandomAlphabetForBaxi());
                base.sendFieldInputData(SNCaptureFieldForBaxi2,base.generateSerialNumber());
                status = true;
            }else{
                LOGGER.info("SN is already available on the plan");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public void enterSNDetailsForBeko() {
        try{
            if (base.checkIfELementIsAvailable(SNCaptureFieldForBeko)) {
                base.highlightElement(SNCaptureFieldForBeko);
                base.sendFieldInputData(SNCaptureFieldForBeko, base.generateRandomSNForBeko());
                LOGGER.info("Beko random SN capture with specificed format used: " + base.generateRandomSNForBeko());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}