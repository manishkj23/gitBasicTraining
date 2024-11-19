package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

import com.test.pages.CCAgent_OLDUI.MakeAClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationPNC {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage claimPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationPNC(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage claimPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.claimPage = claimPage;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"pncnyn\"][@value=\"yes\"]")
    private WebElement customerProvidePncYes;

    @FindBy(xpath = "//*[@id=\"makeClaimBut\"]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id=\"pncNoCode\"][div[contains(.,\"PNC Number\")]]//a")
    private WebElement pNCNumberListBox;

//    @FindBy(xpath = "")

    private final String pncNumberCodePath = "//*[@id=\"pncNoCode\"]//span/input";
    @FindBy(xpath = pncNumberCodePath)
    private WebElement pncNumberCode;

    @FindBy(xpath = "//*[@id=\"pncNoCode\"]//span/a")
    private WebElement pncListButton;

    @FindBy(id = "mlcCode")
    private WebElement mlCode;

    @FindBy(id = "pncSerial")
    private WebElement serialNumber;

    private final String faultAreaPath = "//div[@id=\"ejFc\"]//a";
    @FindBy(xpath = faultAreaPath)
    private WebElement faultAreaButton;

    //    private final String faultPath = "//div[@id='SubUnitTypeSelectionFormID']//span[@class='ui-combobox']//input";
    private final String faultPath = "//div[@id='ProductConfirmationInner']//div[@id='ejFc']//div[contains(text(),'Fault Area')]//span//input[1]";
    @FindBy(xpath = faultPath)
    private WebElement faultArea;


    @FindBy(xpath = "//div[@id=\"elecJfLook\"]//a")
    private WebElement faultButton;

    //    @FindBy(xpath = "//div[@id='SubUnitTypeSelectionFormID']//div[@id='whirlpoolFCLookupHolder']//span[@class='ui-combobox']//input")
    @FindBy(xpath = "//div[@id='ProductConfirmationInner']//div[@id='elecJfLook']//span//input")
    private WebElement faultInput;


    private final String faultAreaPathOnly = "//select[@id=\"elecJobFaultLookup\"]/../span/a";
    @FindBy(xpath = faultAreaPathOnly)
    private WebElement faultAreaButtonOnly;

    private final String faultPathOnly = "//select[@id=\"elecJobFaultLookup\"]/../span/input";
    @FindBy(xpath = faultPathOnly)
    private WebElement faultAreaOnly;

    private final String whplFaultPathOnly = "//div[@id='whirlpoolFCHolder']//span[@class=\"ui-combobox\"]/input";
    @FindBy(xpath = whplFaultPathOnly)
    private WebElement whplFaultAreaOnly;

    @FindBy(xpath = "//select[@id=\"JobFaultCodeLookupID\"]/..//input")
    private WebElement problemCodeOnly;

    @FindBy(xpath = "//div[@id='whirlpoolFCLookupHolder']//span[@class=\"ui-combobox\"]/input")
    private WebElement whplProblemCodeOnly;

    @FindBy(xpath = "//select[@id='JobFaultCodeID']/../span/input")
    private WebElement faultCode;

    @FindBy(xpath = "//select[@id='pncModel']/../span/input")
    private WebElement model;

    @FindBy(xpath = "(//*[@id=\"CustomersApplianceUsable\"])[1]")
    private WebElement applianceIsInUsableCondition;

    @FindBy(xpath = "//*[@id=\"showUseGenericModelCheckBox\"]")
    private WebElement useGenericModelCheckBox;

    @FindBy(xpath = "//span[@class=\"ui-combobox\"]/input")
    private WebElement whplModelOnly;

    @FindBy(xpath = "//tbody/tr[6]/td[2]")
    private WebElement makeName;

    @FindBy(xpath = "//p[@class=\"confirmPNR\"]")
    private WebElement PNCDescription;

    @FindBy(xpath = "//input[@name=\"pncnyn\"][@value=\"no\"]")
    private WebElement customerProvidePncNo;

    private final String selectAppliancePath = "//*[@id=\"pncNoCode\"]//span/input";
    @FindBy(xpath = selectAppliancePath)
    private WebElement selectAppliance;

    @FindBy(xpath = "//div[@id=\"noPncModelData\"]//input")
    private WebElement selectApplianceButton;

    @FindBy(xpath = "//select[@id=\"elecJobFault\"]/../span/a")
    private WebElement FaultArea;

    @FindBy(xpath = "//select[@id=\"elecJobFaultLookup\"]/../span/a")
    private WebElement Fault;

    private final String cookerFaultPath = "//div[@id='ProductConfirmationInner']//div[@id='ejFc']//div[contains(text(),'Fault Area')]//span/input";
    @FindBy(xpath = cookerFaultPath)
    private WebElement cookerFaultArea;

    private final String cookerFaultInputPath = "//div[@id='ProductConfirmationInner']//div[@id='ejFc']//div[@id='elecJfLook']//span//input";
    @FindBy(xpath = cookerFaultInputPath)
    private WebElement cookerFaultInput;

    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]//div[@id=\"whirlpoolFCSearchHolder\"]//input[@id=\"SearchFaultInput\"]")
    private WebElement whplSearchInputBox;

    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]//div[@id=\"whirlpoolFCSearchHolder\"]//img[@onclick=\"showhideFaultResults()\"]")
    private WebElement whplSearchInputBoxIcon;

    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]//div[@id=\"SubUnitTypeSelectionFormID\"]//div[@class=\"dropdown-contentWhpFC\"]")
    private WebElement whplSearchOptionDropdown;

    @FindBy(xpath = "//div[@id=\"ProductConfirmationInner\"]//div[@id=\"SubUnitTypeSelectionFormID\"]//div[@class=\"dropdown-contentWhpFC\"]//a[1]")
    private WebElement whplSearchOptionDropdownValue;






    private final String PNCText = "You must obtain the customer's Product Number (PNC). Without this you CANNOT book an appointment for the customer. Can the customer provide their Product Number?";

    public void enterPNCDetails() {
        try {
            base.hardWait("10000");
            base.clickElement(customerProvidePncYes);
            Thread.sleep(5000);
            Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
            base.hardWait("2000");
            base.clickElement(pncListButton);
            seleniumHelper.actionToMoveDownOnList(pncNumberCode, 0);
            Thread.sleep(5000);
            base.sendFieldInputData(mlCode, "02");
            Thread.sleep(5000);
            base.sendFieldInputData(serialNumber, "12345");
            Thread.sleep(5000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterFaultData() {
        try {

            base.checkElementPresence(faultArea);
            faultArea.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            if (faultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(faultArea);
                faultArea.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            }

            base.checkElementPresence(faultInput);
            if (!faultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(faultInput);
                faultInput.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(faultInput, 0);
                if (faultInput.getAttribute("value").isEmpty()) {
                    base.checkElementPresence(faultInput);
                    faultInput.sendKeys(Keys.SPACE);
                    base.hardWait("1000");
                    seleniumHelper.actionToMoveDownOnList(faultInput, 0);
                }
            } else {
                LOGGER.info("Unable to fill the Fault value");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterFaultCode() {
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

    public void enterFaultOnly() {
        try {
            base.checkElementPresence(faultAreaOnly);
            faultAreaOnly.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(faultAreaOnly, 0);
            if (faultAreaOnly.getAttribute("value").isEmpty()) {
                base.checkElementPresence(faultAreaOnly);
                faultAreaOnly.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(faultAreaOnly, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterProblemCodeOnly() {
        try {

            base.checkElementPresence(problemCodeOnly);
            problemCodeOnly.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(problemCodeOnly, 0);
            if (problemCodeOnly.getAttribute("value").isEmpty()) {
                base.checkElementPresence(problemCodeOnly);
                problemCodeOnly.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(problemCodeOnly, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isFaultDataEntered() {
        boolean status = false;
        try {
            if (!faultArea.getAttribute("value").isEmpty() && !faultInput.getAttribute("value").isEmpty()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isContinueButtonEnabled() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(continueButton) &&
                    base.isClickable(continueButton)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterContinueButton() {
        base.clickElement(continueButton);
    }

    public boolean isFaultCodeEntered(){
        boolean status = false;

        try{
            if(!faultCode.getAttribute("value").isEmpty()) {
                status = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isProblemCodeEntered(){
        boolean status = false;
        try{
            if(!problemCodeOnly.getAttribute("value").isEmpty()) {
                status = true;
            }
        }catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }

    public boolean isPNCSectionLoaded() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(customerProvidePncYes)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterWhplFaultOnly() {
        try {

            base.checkElementPresence(whplFaultAreaOnly);
            whplFaultAreaOnly.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(whplFaultAreaOnly, 0);
            if (whplFaultAreaOnly.getAttribute("value").isEmpty()) {
                base.checkElementPresence(whplFaultAreaOnly);
                whplFaultAreaOnly.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(whplFaultAreaOnly, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterWhplProblemCodeOnly() {
        try {

            base.checkElementPresence(whplProblemCodeOnly);
            whplProblemCodeOnly.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(whplProblemCodeOnly, 0);
            if (whplProblemCodeOnly.getAttribute("value").isEmpty()) {
                base.checkElementPresence(whplProblemCodeOnly);
                whplProblemCodeOnly.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(whplProblemCodeOnly, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isPNCDescriptionDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(PNCDescription);
            if (base.checkIfELementIsAvailable(PNCDescription)) {
                base.highlightElement(PNCDescription);

                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean enterPNCDetailsForNoToPNC() {
        boolean status = false;
        base.checkIfELementIsAvailable(customerProvidePncNo);
        base.clickWithJsExecutor(customerProvidePncNo);
        try{

            if ( base.isElementAvailable(selectApplianceButton)) {
                base.highlightElement(selectApplianceButton);
                selectApplianceButton.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(selectApplianceButton, 0);
                status = true;
            }else{
                LOGGER.info("Unable to select Appliance ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyIfModelIdisPopulated () {
        boolean status = false;
        try {
            if (!model.getAttribute("value").isEmpty()) {
                status = true;
                base.highlightElement(model);
                LOGGER.info("Model ID is Prepopulated as: " + model.getAttribute("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterFaultDetailsForNoPNC() {
        try{
            base.checkElementPresence(FaultArea);
            if (FaultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(FaultArea);
                FaultArea.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(FaultArea, 0);
            }

            base.checkElementPresence(faultInput);
            if (Fault.getAttribute("value").isEmpty()) {
                base.checkElementPresence(Fault);
                Fault.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(Fault, 0);
            } else {
                LOGGER.info("Unable to fill the Fault value");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyTheApplianceStillInUsableCondition () {
        try {
            if (base.checkIfELementIsAvailable(applianceIsInUsableCondition)) {
                base.clickElement(applianceIsInUsableCondition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void genericModelSelectionForWhplMb (String modelNumber) throws InterruptedException {
        base.waitTillElementFound(whplModelOnly);
        useGenericModelCheckBox.click();
        base.clearText(whplModelOnly);
        base.sendFieldInputData(whplModelOnly, modelNumber);
        seleniumHelper.actionToMoveDownOnList(whplModelOnly, 0);
    }

    public boolean verifyTheMakeAndUseGenericModelCheckboxAndEnterTheModelNumber (String make, String modelNumber){
        boolean status = false;
        try {
            String manufacture;
            manufacture = makeName.getText().substring(5);
            if ((make.equalsIgnoreCase(manufacture)) && (base.checkIfELementIsAvailable(useGenericModelCheckBox))) {
                LOGGER.info(" Use generic model check box is present ");
                genericModelSelectionForWhplMb(modelNumber);
                status = true;
            } else {
                LOGGER.info(" Use generic model check box is not present ");
                base.waitTillElementFound(whplModelOnly);
                base.clearText(whplModelOnly);
                base.sendFieldInputData(whplModelOnly, modelNumber);
                seleniumHelper.actionToMoveDownOnList(whplModelOnly, 0);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public void enterFaultDataforCooker ()
    {
        try {

            base.checkElementPresence(cookerFaultArea);
            cookerFaultArea.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(cookerFaultArea, 0);
            if (cookerFaultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(cookerFaultArea);
                cookerFaultArea.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(cookerFaultArea, 0);
            }
            Thread.sleep(5000);
            base.checkElementPresence(cookerFaultInput);
            if (!cookerFaultArea.getAttribute("value").isEmpty()) {
                base.checkElementPresence(cookerFaultInput);
                cookerFaultInput.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(cookerFaultInput, 0);
                if (cookerFaultInput.getAttribute("value").isEmpty()) {
                    base.checkElementPresence(cookerFaultInput);
                    cookerFaultInput.sendKeys(Keys.SPACE);
                    base.hardWait("1000");
                    seleniumHelper.actionToMoveDownOnList(cookerFaultInput, 0);
                }
            } else {
                LOGGER.info("Unable to fill the Fault value");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public boolean selectWhplModel(String modelNumber) {
        boolean status = false;
        try {
            LOGGER.info(" Use generic model check box is not present ");
            base.waitTillElementFound(whplModelOnly);
            base.clearText(whplModelOnly);
            base.sendFieldInputData(whplModelOnly, modelNumber);
            seleniumHelper.actionToMoveDownOnList(whplModelOnly, 0);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterTextInWhplTextSearchBox()
    {
        try {
            base.checkElementPresence(whplSearchInputBox);
            whplSearchInputBox.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            whplSearchInputBox.sendKeys("was");
            base.hardWait("1000");
            base.clickWithJsExecutor(whplSearchInputBoxIcon);
            Thread.sleep(3000);
            base.clickWithJsExecutor(whplSearchOptionDropdownValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean selectUseGenericModelCheckbox() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(useGenericModelCheckBox)) {
                useGenericModelCheckBox.click();
                LOGGER.info(" Use generic model check box is present ");
                status = true;
            } else {
                LOGGER.info(" Use generic model check box is not present ");
                status = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}