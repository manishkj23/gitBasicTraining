package com.test.pages.CCAgentUI_NPV.BookingOverview.RepairAuthority;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepaitAuthorityPanel {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public RepaitAuthorityPanel(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"overrideStatus\"]")
    private WebElement RAStatusOverrideCheckbox;

    @FindBy(xpath = "//*[@id=\"RAStatusIDElement\"]/span/input")
    private WebElement newRAStatusDropdownList;

    @FindBy(xpath = "//*[@id=\"RANotes\"]")
    private WebElement RANotes;

    @FindBy(xpath = "//div[@id=\"RAStatusElement\"]//a[contains(.,\"Apply New RA Status\")]")
    private WebElement applyNewRAStatusButton;

    @FindBy(xpath = "//*[@id=\"juNewRAStatusConfirmation\"][//legend[contains(.,\"Apply New RA Status Confirmation\")]]//a[contains(.,\"Continue\")]")
    private WebElement getApplyNewRAStatus_PopupContinueButton;

    @FindBy(xpath = "//div[@role=\"dialog\"][//span[contains(.,\"Success\")]]//div[contains(.,\"The plan has been successfully written off\")]")
    private WebElement planWrittenOffSuccesfullyMessage;

    @FindBy(xpath = "//div[@role=\"dialog\"][//span[contains(.,\"Success\")]][//div[contains(.,\"The plan has been successfully written off\")]]//button[contains(.,\"OK\")]")
    private WebElement planWrittenOffSuccessfull_PopupOkButton;

    @FindBy(xpath = "//span[@id=\"JobStatusText\"]/b")
    private WebElement RAStatusJobStatus;

    @FindBy(xpath = "//div[@id=\"juNewRAStatusConfirmation\"]//a[contains(.,\"Continue\")]")
    private WebElement applyNewRAStatusConfirmation_ContinueButton;

    @FindBy(xpath = "//div[@role=\"dialog\"][//div[contains(.,\"The plan has been successfully written off\")]]//button[contains(.,\"OK\")]")
    private WebElement writtenOffSuccessPopup;

    private final String missingAppointmentNotesXpath = "//div[@role=\"dialog\"][div[contains(.,\"Please enter Notes\")]]//button[contains(.,\"Close\")]";
    @FindBy(xpath = missingAppointmentNotesXpath)
    private WebElement missingAppointmentNotes;

    private final String missingInfoPopup_Xpath = "//div[@role=\"dialog\"][//span[contains(.,\"Missing Information\")]]//input[@value=\"OK\"]";
    @FindBy(xpath = missingInfoPopup_Xpath)
    private WebElement missingInfoPopup_writtenOff;

    @FindBy(xpath = "//div[contains(.,\"Booking Summary\")]//table/tbody/tr[contains(.,\"System Status\")]/td[2]")
    private WebElement workflowSystemStatus;

    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    private WebElement jobCompletedStatus;


    public void processWrittenOff(String writtenOffStatus) {
        base.hardWait("1000");
        base.clickElement(RAStatusOverrideCheckbox);
        base.hardWait("1000");
        base.waitForElementVisible(newRAStatusDropdownList);
        base.isClickable(newRAStatusDropdownList);
        base.sendFieldInputData(newRAStatusDropdownList, writtenOffStatus);
        try {
            seleniumHelper.actionToMoveDownOnList(newRAStatusDropdownList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        base.hardWait("2000");
        base.sendFieldInputData(RANotes, writtenOffStatus);
        base.hardWait("1000");
        base.sendFieldInputData(RANotes, writtenOffStatus);

        base.isClickable(applyNewRAStatusButton);
        base.clickWithJsExecutor(applyNewRAStatusButton);
        base.isClickable(applyNewRAStatusConfirmation_ContinueButton);
        base.clickWithJsExecutor(applyNewRAStatusConfirmation_ContinueButton);
        seleniumHelper.captureScreeshot();

        if (base.checkIfELementIsAvailable(writtenOffSuccessPopup)) {
            Assert.assertTrue("Unable to verify WrittenOff Successfull", base.checkIfELementIsAvailable(writtenOffSuccessPopup));
            base.clickElement(writtenOffSuccessPopup);
        }
        if (base.getElementFromXpath(missingAppointmentNotesXpath) != null) {
            base.clickElement(missingAppointmentNotes);
        }
//        if (base.checkElementIsAvailableByXpath(missingInfoPopup_Xpath)) {
        if (base.getElementFromXpath(missingInfoPopup_Xpath) != null) {
            base.clickElement(base.quickWait(missingInfoPopup_Xpath));
        }

        base.hardWait("3000");
        base.refreshPage();
    }

}
