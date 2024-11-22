package com.test.pages.CCAgentUI_NPV;

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

public class HeatingReplacementPage {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private static final String OpenTabWithNameAsXpath ="//div[contains(text(),'${value}')]";

    @FindBy(xpath = "//button[contains(text(),'Update Status')]")
    private WebElement updateStatusButton;

    private static final String UpdateStatusXpath ="//a[contains(text(),'${value}')]";

    @FindBy(xpath = "//div[@id='cboxLoadedContent']")
    private WebElement updateStatusPopup;

    @FindBy(xpath = "//textarea[@id='Comments']")
    private WebElement commentBox;

    @FindBy(xpath = "//div[@id='cboxLoadedContent']//button[contains(text(),'Proceed')]")
    private WebElement proceedButton;

    @FindBy(xpath = "//input[@id='communicationType' and @value='2']")
    private WebElement manualCommunicationTypeRadioButton;

    @FindBy(xpath = "//span[contains(text(),'Insert')]//parent::a")
    private WebElement insertButton;

    @FindBy(xpath = "//select[@id='CommunicationType']//following-sibling::span//input")
    private WebElement commTypeDropdown;

    @FindBy(xpath = "//select[@id='Outcome']//following-sibling::span//input")
    private WebElement commOutcomedropdown;

    @FindBy(xpath = "//textarea[@id='Notes']")
    private WebElement notesTextBox;

    @FindBy(xpath = "//button[@id='saveBtn']")
    private WebElement submitButton;

    @FindBy(xpath = "//select[@id='NewBoilerManufacturerID']//following-sibling::span//input")
    private WebElement newBoilerMakeDropdown;

    @FindBy(xpath = "//input[@id='NewModelID']")
    private WebElement newBoilerModelTextbox;

    @FindBy(xpath = "//input[@id='ModelWarrantyMonths']")
    private WebElement guaranteePeriodTextbox;

    @FindBy(xpath = "//input[@id='TotalInstallationCost']")
    private WebElement instalCostTextbox;

    @FindBy(xpath = "//input[@id='DateInstalled']")
    private WebElement dateInstalled;

    private static String dateInstalledFieldXpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td[contains(.,\"${value}\")]/a";

    @FindBy(xpath = "//label[contains(text(),'B (Section)')]//following::select[@name='JobFaultCodeLookupID']")
    private WebElement faultCodeBDropdown;

    @FindBy(xpath = "//label[contains(text(),'E (FaultCode)')]//following::select[@name='JobFaultCodeLookupID']")
    private WebElement faultCodeEDropdown;

    public HeatingReplacementPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    public void updateStatusAs(String status) throws InterruptedException {
        if (!base.checkIfELementIsAvailable(updateStatusButton))
            base.waitTillElementFound(updateStatusButton);
        base.clickElement(updateStatusButton);
        base.hardWait("1000");
        WebElement updateStatus = seleniumHelper.getCustomElementByXpath(UpdateStatusXpath, status);
        base.waitTillElementFound(updateStatus);
        base.clickWithJsExecutor(updateStatus);
    }

    public void updateRejectionReasonAs(String reason){
        try {
            if (base.checkIfELementIsAvailable(updateStatusPopup)) {
                base.sendFieldInputData(commentBox, reason);
                base.clickElement(proceedButton);
            } else {
                LOGGER.error("Update Status Popup not available");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addManualCommunication(String notes, String type, String outcome) {
        try {
            base.clickElement(manualCommunicationTypeRadioButton);
            base.clickElement(insertButton);
            base.waitTillElementFound(updateStatusPopup);
            if (base.checkIfELementIsAvailable(updateStatusPopup) && updateStatusPopup.isDisplayed()) {

                base.sendFieldInputData(commTypeDropdown,type);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(commTypeDropdown, 0);

                base.sendFieldInputData(commOutcomedropdown,outcome);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(commOutcomedropdown, 0);
                base.sendFieldInputData(notesTextBox, notes);
                base.clickElement(submitButton);
                base.hardWait("1000");
                base.refreshPage();
            }
            else
            {
                LOGGER.error("Update Status Popup not available");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillNewBoilerDetails(String model, String guarenteePeriod, String instalCost, String notes) {
        try {
            if (base.checkIfELementIsAvailable(updateStatusPopup)) {
                base.checkElementPresence(newBoilerMakeDropdown);
                newBoilerMakeDropdown.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(newBoilerMakeDropdown, 0);

                base.sendFieldInputData(newBoilerModelTextbox, model);
                base.sendFieldInputData(guaranteePeriodTextbox, guarenteePeriod);
                base.sendFieldInputData(instalCostTextbox, instalCost);

                base.waitTillElementFound(dateInstalled);
                base.isClickable(dateInstalled);
                dateInstalled.click();
                WebElement dateInstalledField = seleniumHelper.getCustomElementByXpath(dateInstalledFieldXpath, seleniumHelper.getCurrentDate().substring(0, 2).replaceAll("^0+", "").trim());
                base.clickElement(dateInstalledField);

              /*  base.waitTillElementFound(faultCodeBDropdown);
                base.highlightElement(faultCodeBDropdown);
                Select faultBDropdown = new Select(faultCodeBDropdown);
                faultBDropdown.selectByIndex(1);

                base.waitTillElementFound(faultCodeEDropdown);
                base.highlightElement(faultCodeEDropdown);
                Select faultEDropdown = new Select(faultCodeEDropdown);
                faultEDropdown.selectByIndex(1);*/

                base.sendFieldInputData(commentBox, notes);

                base.clickElement(proceedButton);

            } else {
                LOGGER.error("Update Status Popup not available");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
