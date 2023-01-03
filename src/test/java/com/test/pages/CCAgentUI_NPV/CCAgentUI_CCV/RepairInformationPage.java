package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RepairInformationPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    // private DialogPoppupPage popupWindow;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@id=\"JobStatusName\"]")
    private WebElement jobStatusHeader;

    private final String repairInformationTabPath = "//div[@id='ui2_left_nav']//div[@id='nav_RepairInformation']";
    @FindBy(xpath = repairInformationTabPath)
    private WebElement repairInformationTab;

    private final String repairInformationHeaderPath = "//div[@id='ui2_right']//div[@id='ui2_right_header' and @class='ui2_header_bar']";
    @FindBy(xpath = repairInformationHeaderPath)
    private WebElement repairInformationHeader;

    @FindBy(xpath = "//div[@id='AppointmentsDT_wrapper']//table[@id='AppointmentsDT']")
    private WebElement appointmentTableExistPath;

    private final String repairInformationFirstRowPath = "//table[@id='AppointmentsDT']//tbody[contains(@role,'alert')]//tr[contains(@class,'odd')]//td[contains(text(),'Whirlpool Engineer')]";
    @FindBy(xpath = repairInformationFirstRowPath)
    private WebElement repairInformationFirstRow;

    @FindBy(xpath = "//div[@class='DTTT_container']//a[@id='ToolTables_AppointmentsDT_1' and @class='DTTT_button btnCancel ']")
    private WebElement cancelAppointmentButton;

    private final String cancelRememberPopUpBoxPath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Default']";
    @FindBy(xpath = cancelRememberPopUpBoxPath)
    private WebElement cancelRememberPopUpBox;

    private final String cancelRememberPopUpTextPath = "//span[@id='ui-id-4' and @class='ui-dialog-title ui_Default']";
    @FindBy(xpath = cancelRememberPopUpTextPath)
    private WebElement cancelRememberPopUpText;

    private final String cancelRememberPopUpYesButtonPath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Yes')]";
    @FindBy(xpath = cancelRememberPopUpYesButtonPath)
    private WebElement cancelRememberPopUpYesButton;

    private final String cancelAppointmentPopUpPath = "//legend[contains(text(),'Cancel Appointment')]";
    @FindBy(xpath = cancelAppointmentPopUpPath)
    private WebElement cancelAppointmentPopUp;

    private final String cancelAppointment_completionStatusDropDownSelectPath = "//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']";
    @FindBy(xpath = cancelAppointment_completionStatusDropDownSelectPath)
    private WebElement cancelAppointment_completionStatusDropDownSelect;

    private final String cancelAppointment_completionStatusSearchBoxPath = "//span[@class='ui-combobox']//input[@class='ui-state-default ui-combobox-input comboCompletionStatusID-input text ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']";
    @FindBy(xpath = cancelAppointment_completionStatusSearchBoxPath)
    private WebElement cancelAppointment_completionStatusSearchBox;

    private final String cancelAppointment_completionStatusDropDownOptionPath = "/html[1]/body[1]/ul[1]/li[1]/div[1]";
    @FindBy(xpath = cancelAppointment_completionStatusDropDownOptionPath)
    private WebElement cancelAppointment_completionStatusDropDownOption;

    private final String cancelAppointment_NotesPath = "//form[@id='cancelAppoinmentFrom']//textarea[@id='Notes']";
    @FindBy(xpath = cancelAppointment_NotesPath)
    private WebElement cancelAppointment_Notes;

    private final String cancelAppointment_ConfirmButtonPath = "//div[@id=\"cancelAppoinmentDiv\"]//form[@id='cancelAppoinmentFrom']//button[@id='submitAppointmentCancelBtn']";
    @FindBy(xpath = cancelAppointment_ConfirmButtonPath)
    private WebElement cancelAppointment_ConfirmButton;

    private final String cancelAppointment_ConfirmationPopUpPath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons']";
    @FindBy(xpath = cancelAppointment_ConfirmationPopUpPath)
    private WebElement cancelAppointment_ConfirmationPopUp;

    private final String cancelAppointment_ConfirmationPopUpTextPath = "//div[@id='modP'][@class='ui-dialog-content ui-widget-content']";
    @FindBy(xpath = cancelAppointment_ConfirmationPopUpTextPath)
    private WebElement cancelAppointment_ConfirmationPopUpText;

    private final String cancelAppointment_ConfirmationPopUpCloseButtonPath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'Close')]";
    @FindBy(xpath = cancelAppointment_ConfirmationPopUpCloseButtonPath)
    private WebElement cancelAppointment_ConfirmationPopUpCloseButton;

    private final String cancelAppointment_appointmentCompletionStatusPath = "//table[@id='AppointmentsDT']//tbody[@role='alert']//tr[@class='odd']//td[contains(text(),'Customer Request')]";
    @FindBy(xpath = cancelAppointment_appointmentCompletionStatusPath)
    private WebElement cancelAppointment_appointmentCompletionStatus;

    @FindBy(xpath = "//a[@id='ToolTables_AppointmentsDT_2'][@class='DTTT_button btnStandardInsert findnewDGAppointmnent']")
    private WebElement findNewAppointmentButton;

    @FindBy(xpath = "//legend[contains(text(),'Find New Appointment')]")
    private WebElement FindNewAppointmentPopUpDisplay;

    @FindBy(xpath = "//input[@id='StartAppointmnetSearch' and @name='StartAppointmnetSearch']")
    private WebElement findNewAppointment_StartAppointmentSearchButton;

    private final String rebookCalendarAvailability = "//table[@id='MainICCollectionCalendar']";
    @FindBy(xpath = rebookCalendarAvailability)
    private WebElement findNewAppointment_rebookCalendarAvailability;

    private final String NinethAvailableDateXpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][9]";
    @FindBy(xpath = NinethAvailableDateXpath)
    private WebElement findNewAppointment_NinethAvailableDate;

    private final String preferredDateForSpecificSlot = "//span[@id='prefferedDelDate']";
    @FindBy(xpath = preferredDateForSpecificSlot)
    private WebElement findNewAppointment_preferredDateDisplay;

    @FindBy(xpath = "//input[@id='claimApptRebook']")
    private WebElement findNewAppointment_confirmRebookingButton;

    private final String RebookPopup = "//span[contains(text(),'Confirm Rebooking') and @class='ui-dialog-title ui_Warning']";
    @FindBy(xpath = RebookPopup)
    private WebElement findNewAppointment_confirmRebookingPopupTitle;

    private final String confirmRebookingAppointmentButton = "//button[contains(text(),'Confirm')]";
    @FindBy(xpath = confirmRebookingAppointmentButton)
    private WebElement findNewAppointment_RebookAnAppointmentConfirmButton;

    private final String reselectWhirlpoolTestWarningMessagePopUpPath = "//div[contains(@class,'ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Warning')]";
    @FindBy(xpath = reselectWhirlpoolTestWarningMessagePopUpPath)
    private WebElement reselectAppointment_reselectWhirlpoolTestWarningMessagePopUp;

    private final String reselectWhirlpoolTestTitleWarningMessagePath = "//span[@id='ui-id-2' and @class='ui-dialog-title ui_Warning']";
    @FindBy(xpath = reselectWhirlpoolTestTitleWarningMessagePath)
    private WebElement reselectAppointment_reselectWhirlpoolTestTitleWarningMessage;

    private final String reselectWhirlpoolTestContinueButtonPath = "//div[contains(@class,'ui-dialog-buttonset')]/button[contains(text(),'Continue')]";
    @FindBy(xpath = reselectWhirlpoolTestContinueButtonPath)
    private WebElement reselectAppointment_reselectWhirlpoolTestContinueButton;

    private final String systemErrorMessagePopUpPath = "//div[contains(@class,'ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Default')]";
    @FindBy(xpath = systemErrorMessagePopUpPath)
    private WebElement reselectAppointment_systemErrorMessagePopUpPath;

    private final String systemErrorMessageContinueButtonPath = "//div[contains(@class,'ui-dialog-buttonset')]/button[contains(text(),'Continue')]";
    @FindBy(xpath = systemErrorMessageContinueButtonPath)
    private WebElement reselectAppointment_systemErrorMessageContinueButtonPath;

    private final String searchOtherServiceProvider = "//input[@id='showotherspscal'][@name='showotherspscal']";
    @FindBy(xpath = searchOtherServiceProvider)
    private WebElement serviceProvidersAppointment_searchOtherServicePoviderButton;

    private final String searchOtherServiceProviderDisabled = "//input[@id='showotherspscal' and @class=\"btnStandard rounded disabled\" and @disabled=\"disabled\"]";
    @FindBy(xpath = searchOtherServiceProviderDisabled)
    private WebElement serviceProvidersAppointment_searchOtherServicepPoviderButtonDisabled;

    private final String fieldCallCalendarAvailability = "//*[@id='claimRebkAppt_rSp']//tr/td[contains(@class,\"dayAvailable\")][9]";
    @FindBy(xpath = fieldCallCalendarAvailability)
    private WebElement serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability;

    private final String fieldCallCalendarPath = "//table[@id='MainICCollectionCalendar']";
    @FindBy(xpath = fieldCallCalendarPath)
    private WebElement serviceProvidersAppointment_fieldCallCalendarPath;

    @FindBy(xpath = "//input[@type='radio' and @id='allocateSP1' and @name='allocateSP']")
    private WebElement serviceProvidersAppointment_availableServiceProviderRadioButton;

    @FindBy(xpath = "//input[@id='rebookPayAndUse' and @name='rebookPayAndUse']")
    private WebElement serviceProvidersAppointment_rebookButtonForReselectionSP;

    private final String confirmationAlertPopUpPath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Default']";
    @FindBy(xpath = confirmationAlertPopUpPath)
    private WebElement serviceProvidersAppointment_confirmationAlertPopUpBox;

    @FindBy(xpath = "//span[contains(text(),'Alert')][@id='ui-id-1'][@class=\"ui-dialog-title ui_Default\"]")
    private WebElement serviceProvidersAppointment_alertPopUpText;

    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//button[contains(text(),'Yes')][@type=\"button\"]")
    private WebElement serviceProvidersAppointment_confirmationAlertPopUpYes;

    private final String bookingOverviewServiceProviderNamePath = "//div[@id='ui2_right_content']//tbody//tr//td[contains(text(),'FLYINGTOOLBOX RESPOND')]";
    @FindBy(xpath = bookingOverviewServiceProviderNamePath)
    private WebElement bookingOverviewServiceProviderName;

    private final String claimJobStatusPath = "//div[@id='ui2_top_header']//b[@id='JobStatusName']";
    @FindBy(xpath = claimJobStatusPath)
    WebElement jobStatus;

    @FindBy(xpath = "//div[@id='ui2_top_header']//b[@id='JobStatusName']")
    WebElement jobStatusAny;

    private final String bookingOverviewClaimIdPath = "//td[@style='width: 33.3%; text-align:center;']";
    @FindBy(xpath = bookingOverviewClaimIdPath)
    WebElement bookingOverviewClaimID;

    private final String DandGLogoPath = "//div[@id='header']//td[contains(@width,'30%')]//div[contains(@style,'')]";
    @FindBy(xpath = DandGLogoPath)
    private WebElement DandGLogo;

    private final String oldServiceProviderNamePath = "//div[@id='ui2_right_content']//tbody//tr//td[contains(text(),'WHIRLPOOL UK APPLIANCE LTD')]";
    @FindBy(xpath = oldServiceProviderNamePath)
    private WebElement oldServiceProviderName;

    private final String oldClaimIdAppointmentCompletionStatusPath = "//table[@id='AppointmentsDT']//td[contains(text(),'Claim Closed - Reassigned')]";
    @FindBy(xpath = oldClaimIdAppointmentCompletionStatusPath)
    private WebElement oldClaimIdAppointmentCompletionStatus;

    private final String payAndClaimButtonPath = "//div[@id='calenderExt']//input[@id='showPayClaimPanelID']";
    @FindBy(xpath = payAndClaimButtonPath)
    private WebElement payAndClaimButton;

    private final String payAndClaim_CheckboxPath = "//input[@id='payConfirm']";
    @FindBy(xpath = payAndClaim_CheckboxPath)
    private WebElement payAndClaim_Checkbox;

    private final String payAndClaim_RebookButtonPath = "//div[@id='calenderExtStep2']//input[@id='rebookPayAndUse']";
    @FindBy(xpath = payAndClaim_RebookButtonPath)
    private WebElement payAndClaim_RebookButton;

    private final String payAndClaim_multipleClaimsPopUpPath = "//button[contains(text(),'×')]";
    @FindBy(xpath = payAndClaim_multipleClaimsPopUpPath)
    private WebElement payAndClaim_multipleClaimsPopUp;

    private final String payAndClaim_ConfirmButtonPath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Yes')]";
    @FindBy(xpath = payAndClaim_ConfirmButtonPath)
    private WebElement payAndClaim_ConfirmButton;

    private final String payAndClaimConfirmationPagePath = "//div[@style='width:100%; text-align: center; float: left;']";
    @FindBy(xpath=payAndClaimConfirmationPagePath)
    private WebElement payAndClaimConfirmationPage;

    private final String checkBoxFirstRowGridPath="//table[@id='matches_table']/tbody[@role='alert']/tr[1]/td[12]/input[1]";
    @FindBy(xpath = checkBoxFirstRowGridPath)
    private WebElement checkBoxFirstRowGrid;

    private final String viewJobDetailsButtonPath = "//div[@class='DTTT_container']//a[@id='ToolTables_matches_table_0']//span[contains(text(),'View Job Details')]";
    @FindBy(xpath = viewJobDetailsButtonPath)
    private WebElement viewJobDetailsButton;


    public RepairInformationPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @Before
    public void verifyIfNewUIPageIsLoaded() throws InterruptedException {
        Assert.assertTrue("New CC Agent Portal Not Loaded", jobStatusHeader.isDisplayed());
        Thread.sleep(6000);
    }

    public void clickOnRepairInformationTab() throws InterruptedException {
        if (base.checkIfELementIsAvailable(repairInformationTab)) {
            base.clickWithJsExecutor(repairInformationTab);
            Thread.sleep(3000);
        }
        Assert.assertTrue("Repair Information Page not loaded", repairInformationHeader.isDisplayed());
        Thread.sleep(2000);
    }

    public void selectAnOpenAppointmentRow() throws InterruptedException {
        if (base.checkIfELementIsAvailable(appointmentTableExistPath)) {
            base.clickWithJsExecutor(repairInformationFirstRow);
            Thread.sleep(3000);
        } else {
            base.waitToLoadElement();
            base.clickWithJsExecutor(repairInformationFirstRow);
            Thread.sleep(3000);
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void clickOnCancelButton() throws InterruptedException {
        if (base.checkIfELementIsAvailable(cancelAppointmentButton) & base.checkIfELementIsAvailable(cancelAppointmentButton)) {
            base.clickWithJsExecutor(cancelAppointmentButton);
            Thread.sleep(3000);
        } else {
            base.waitToLoadElement();
            base.clickWithJsExecutor(cancelAppointmentButton);
            Thread.sleep(3000);
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void clickOnYesInCancelAppointmentPopUp() throws InterruptedException {
        if (base.checkIfELementIsAvailable(cancelRememberPopUpBox)) {
            base.clickWithJsExecutor(cancelRememberPopUpYesButton);
            Thread.sleep(5000);
        } else {
            base.waitForPageToLoad();
            base.clickWithJsExecutor(cancelRememberPopUpYesButton);
            Thread.sleep(5000);
        }

    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void verifyCancelAppointmentPopUpBoxLoaded() {
        Assert.assertTrue("Cancel Appointment pop up box not loaded", cancelAppointmentPopUp.isDisplayed());
        String cancelAppointment = driver.findElement(By.xpath(cancelAppointmentPopUpPath)).getText();
        System.out.println(cancelAppointment);
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void selectCompletionStatusValueAndNotes() throws InterruptedException {
        if (base.checkIfELementIsAvailable(cancelAppointment_completionStatusDropDownSelect)) {
            base.clickWithJsExecutor(cancelAppointment_completionStatusDropDownSelect);
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath(cancelAppointment_completionStatusSearchBoxPath)).sendKeys("Customer");
        Thread.sleep(3000);
        List<WebElement> appointmentStatus = driver.findElements(By.xpath(cancelAppointment_completionStatusDropDownOptionPath));
        for (WebElement elements : appointmentStatus) {
            if (elements.getText().equals("Customer Request")) {
                elements.click();
                break;
            }
        }
        Thread.sleep(4000);
        base.sendFieldInputData(cancelAppointment_Notes, "testing");
        Thread.sleep(2000);
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void clickOnCancelAppointmentConfirmButton() throws InterruptedException {
        if (base.checkIfELementIsAvailable(cancelAppointment_ConfirmButton)) {
            base.clickWithJsExecutor(cancelAppointment_ConfirmButton);
        }
        Thread.sleep(15000);
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void cancelAppointmentSuccessfulWithCloseButtonPopUp() throws InterruptedException {
        String completionText = "Order Successfully Cancelled";
        if (base.checkIfELementIsAvailable(cancelAppointment_ConfirmationPopUp)) {
            String order = driver.findElement(By.xpath(cancelAppointment_ConfirmationPopUpTextPath)).getText().toString();
            System.out.println(order);
            Thread.sleep(3000);
            if (order.equalsIgnoreCase(completionText)) {
                System.out.println("Appointment has been cancelled successfully: " + order);
            } else {
                System.out.println("Appointment hasn't been cancelled successfully");
            }
            Thread.sleep(2000);
            base.clickWithJsExecutor(cancelAppointment_ConfirmationPopUpCloseButton);
            Thread.sleep(5000);
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Cancel an appointment of Whirlpool plan
     */
    public void cancelAppointment_AppointmentCompletionStatus(String appointmentCompletionStatus) {
        if (base.checkIfELementIsAvailable(repairInformationFirstRow)) {
            String appointmentStatus = driver.findElement(By.xpath(cancelAppointment_appointmentCompletionStatusPath)).getText();
            System.out.println("Appointment Completion Status is: " + appointmentStatus);
            if (appointmentStatus.equalsIgnoreCase(appointmentCompletionStatus)) {
                System.out.println("Appointment Completion Status updated with : " + appointmentStatus);
            } else {
                System.out.println("Appointment has not been cancelled");
            }
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Rebook an appointment of Whirlpool plan
    Click on Find New Appointment button in Repair Information Tab in New Review UI
     */

    public void clickOnFindNewAppointmentButton() {
        try {
            if (base.checkIfELementIsAvailable(findNewAppointmentButton)) {
                base.highlightElementWithScreenshot(findNewAppointmentButton, "Click on Find New Appointment button");
                base.clickWithJsExecutor(findNewAppointmentButton);

            } else {
                base.waitToLoadElement();
                base.waitForElementVisible(findNewAppointmentButton);
                if (base.checkIfELementIsAvailable(findNewAppointmentButton) & findNewAppointmentButton.isDisplayed()) {
                    base.highlightElementWithScreenshot(findNewAppointmentButton, "Click on Find New Appointment button");
                    base.clickWithJsExecutor(findNewAppointmentButton);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on Find New Appointment button");
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Rebook an appointment of Whirlpool plan
    To click on Start Appointment Search button and verify calendar section is showing to Rebook an appointment
     */

    public void clickOnStartAppointmentSearchFindNewAppointmentPopUpAndVerifyCalendarToRebook() {
        try {
            if (base.checkIfELementIsAvailable(FindNewAppointmentPopUpDisplay) && FindNewAppointmentPopUpDisplay.isDisplayed()) {
                if (base.checkIfELementIsAvailable(findNewAppointment_StartAppointmentSearchButton) && findNewAppointment_StartAppointmentSearchButton.isEnabled()) {
                    base.clickWithJsExecutor(findNewAppointment_StartAppointmentSearchButton);
                    Thread.sleep(2000);
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability)) {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
                        Thread.sleep(3000);
                    } else {
                        base.waitForElementAndReturnJS(rebookCalendarAvailability);
                        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
                        Thread.sleep(3000);
                    }
                } else {
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability)) {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
                        Thread.sleep(3000);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on Start Appointment Search button and not able to select date from calendar");
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Rebook an appointment of Whirlpool plan
    Select a date from the Available Calendar and click on Confirm Rebook to Rebook an appointment
     */
    public void selectNinethAvailableAppointmentDateAndConfirmRebookButton() throws InterruptedException {
        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
        base.clickWithJsExecutor(findNewAppointment_NinethAvailableDate);
        Thread.sleep(3000);
        base.checkIfELementIsAvailable(findNewAppointment_confirmRebookingButton);
        base.highlightElement(findNewAppointment_confirmRebookingButton);
        base.clickWithJsExecutor(findNewAppointment_confirmRebookingButton);
        Thread.sleep(3000);
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Rebook an appointment of Whirlpool plan
    Click on Confirm button in Confirm Rebooking Pop up box
     */
    public void finalConfirmRebookingPopUpDisplayAndConfirmButton() throws InterruptedException {
        if (base.waitForElementVisible(findNewAppointment_confirmRebookingPopupTitle) && base.checkIfELementIsAvailable(findNewAppointment_confirmRebookingPopupTitle)) {
            String RebookPopupDisplay = driver.findElement(By.xpath(RebookPopup)).getText().toString();
            System.out.println("Rebook pop up text displayed : " + RebookPopupDisplay);
            if (RebookPopupDisplay.contains("Confirm Rebooking")) {
                if (base.checkIfELementIsAvailable(findNewAppointment_RebookAnAppointmentConfirmButton)) {
                    base.clickWithJsExecutor(findNewAppointment_RebookAnAppointmentConfirmButton);
                } else {
                    base.waitForElementVisible(findNewAppointment_RebookAnAppointmentConfirmButton);
                    base.clickWithJsExecutor(findNewAppointment_RebookAnAppointmentConfirmButton);
                    Thread.sleep(10000);
                }
            }
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Rebook an appointment of Whirlpool plan
    Verify Appointment Completion Status updated with "Customer Request" after rebook an appointment
     */
    public void verifyAppointmentOutcomeStatusAfterRebookedInRepairInformationNewUI(String appointmentstatus) {
        String before_xpath = "//div[@id='AppointmentsPanel']/div[@id='AppointmentsDT_wrapper']/table[@id='AppointmentsDT']/tbody[contains(@role,'alert')]/tr[";
        String after_xpath = "]/td[7]";
        String ApptCompletionStatus = "";

        //Find a total no of columns in a web table.
        List<WebElement> columns = driver.findElements(By.xpath("//div[@id='AppointmentsDT_wrapper']/table/thead/tr/th"));
        int columnCount = columns.size();
        System.out.println("No of columns in a table : " + columnCount);

        //Find a total no of rows in a web table.
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='AppointmentsDT_wrapper']/table/tbody/tr/td[1]"));
        int rowCount = rows.size();
        System.out.println("No of rows in a table : " + rowCount);

        String columnNull = driver.findElement(By.xpath(before_xpath + rowCount + after_xpath)).getText();
        if (columnNull == ApptCompletionStatus) {
            System.out.println("Appointment completion status is blank---> " + columnNull + " which means appointment rebooked successfully");
        }

        for (int i = rowCount - 1; i >= 1; i--) {
            String status = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
            System.out.println("Appointment Completion Status is: " + status);
            if (status.equalsIgnoreCase(appointmentstatus)) {
                System.out.println("Appointment Completion Status updated successfully after rebooking an appointment");
            }
            break;
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Rebook an appointment of Whirlpool plan
    Click on Search Other Service Provider button and select the date from the Field Call Calendar.
     */

    public void clickOnSearchOtherServiceProviderButtonAndSelectAvailableDate() throws InterruptedException {
        if (base.waitForElementVisible(serviceProvidersAppointment_searchOtherServicePoviderButton) && serviceProvidersAppointment_searchOtherServicePoviderButton.isEnabled()) {
            base.highlightElement(serviceProvidersAppointment_searchOtherServicePoviderButton);
            base.clickWithJsExecutor(serviceProvidersAppointment_searchOtherServicePoviderButton);
            Thread.sleep(2000);
            if (base.waitForElementVisible(reselectAppointment_reselectWhirlpoolTestWarningMessagePopUp)) {
                base.highlightElement(reselectAppointment_reselectWhirlpoolTestContinueButton);
                base.clickWithJsExecutor(reselectAppointment_reselectWhirlpoolTestContinueButton);
                Thread.sleep(2000);
                base.highlightElement(reselectAppointment_systemErrorMessageContinueButtonPath);
                base.clickWithJsExecutor(reselectAppointment_systemErrorMessageContinueButtonPath);
                Thread.sleep(3000);
                if (base.waitForElementVisible(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability)) {
                    base.highlightElement(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability);
                    base.clickWithJsExecutor(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability);
                }
            } else {
                base.highlightElement(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability);
                base.clickWithJsExecutor(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability);
            }
        } else {
            System.out.println("Search other Service provider button is disabled");
            if (base.waitForElementVisible(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability)) {
                base.highlightElement(serviceProvidersAppointment_fieldCallCalendarPath);
                base.highlightElement(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability);
                base.clickWithJsExecutor(serviceProvidersAppointment_fieldCallCalendarNinthDayAvailability);
            } else {
                System.out.println("Calendar availability not displayed under Field Call Calendar");
            }
        }
    }


    /*
    Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan
    Click on Reselect Service Provider Appointment button to reselect an appointment and click on Rebook button
     */

    public void reselectServiceProviderAppointmentRadioButtonAndClickOnRebookButton() throws InterruptedException {
        if (base.waitForElementVisible(serviceProvidersAppointment_availableServiceProviderRadioButton) && base.checkIfELementIsAvailable(serviceProvidersAppointment_availableServiceProviderRadioButton)) {
            base.highlightElement(serviceProvidersAppointment_availableServiceProviderRadioButton);
            base.clickWithJsExecutor(serviceProvidersAppointment_availableServiceProviderRadioButton);
        }
        if (base.waitForElementVisible(serviceProvidersAppointment_rebookButtonForReselectionSP)) {
            base.isElementAvilable(serviceProvidersAppointment_rebookButtonForReselectionSP);
            base.highlightElement(serviceProvidersAppointment_rebookButtonForReselectionSP);
            base.clickWithJsExecutor(serviceProvidersAppointment_rebookButtonForReselectionSP);
        }
        Thread.sleep(3000);
    }


    /*
    Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan
    Verify Alert pop up displayed and click on Yes button in Confirmation Alert pop up box
     */
    public void verifyAlertPopUpAndClickOnYesButton() throws InterruptedException {
        if (base.waitForElementVisible(serviceProvidersAppointment_confirmationAlertPopUpBox) && base.checkIfELementIsAvailable(serviceProvidersAppointment_alertPopUpText)) {
            base.highlightElement(serviceProvidersAppointment_confirmationAlertPopUpYes);
            base.clickWithJsExecutor(serviceProvidersAppointment_confirmationAlertPopUpYes);
            Thread.sleep(3000);
        } else {
            base.waitToLoadElement();
            base.isElementAvilable(serviceProvidersAppointment_confirmationAlertPopUpYes);
            base.highlightElement(serviceProvidersAppointment_confirmationAlertPopUpYes);
            base.clickWithJsExecutor(serviceProvidersAppointment_confirmationAlertPopUpYes);
        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan in New UI
    Verify new Service provider Name updated successfully in Booking Overview page.
     */
    public boolean verifyNewServiceProviderNameInBookingOverviewAfterReselect() {
        String oldServiceProvider = "WHIRLPOOL UK APPLIANCE LTD";
        String newServiceProviderName;
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(bookingOverviewServiceProviderName);
        if (base.checkIfELementIsAvailable(bookingOverviewServiceProviderName)) {
            //newServiceProviderName = base.getElementFromXpath(oldServiceProviderNamePath).getText().toString();
            newServiceProviderName = driver.findElement(By.xpath(bookingOverviewServiceProviderNamePath)).getText().toString();
            System.out.println("New Service Provider name is : " + newServiceProviderName);
            if (!newServiceProviderName.equalsIgnoreCase(oldServiceProvider)) {
                System.out.println("New Service Provider " + newServiceProviderName + " selected successfully after reselect an appointment");
                base.highlightElement(bookingOverviewServiceProviderName);
                status = true;
            } else {
                System.out.println("New Service Provider not selected and updated successfully after reselect an appointment");
                base.highlightElement(bookingOverviewServiceProviderName);
                status = false;
            }
        }
        return status;
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan in New UI
    Verify Claim Job Status in Booking Overview page After Reselect Service Provider.
     */
    public boolean claimJobStatusBookingOverviewAfterReselectServiceProvider(String reselectjobstatus) {
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains(reselectjobstatus)) {
            base.highlightElement(jobStatus);
            status = true;
        } else {
            base.waitTillElementFound(jobStatusAny);
            if (base.checkIfELementIsAvailable(jobStatusAny)) {
                base.waitForPageToLoad();
                base.highlightElement(jobStatusAny);
                status = true;
            }
        }
        return status;
    }


    /*Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan in New UI
    Verify that the new claim ID created and compared with the old ClaimID "<ClaimNo>"
     */
    public void oldClaimIdComparedWithNewClaimId(String claimNo) {
        if (base.waitForElementVisible(bookingOverviewClaimID)) {
            String claimIdString = driver.findElement(By.xpath(bookingOverviewClaimIdPath)).getText().toString();
            String newClaimNo = claimIdString.replaceAll("[^0-9]", "");
            System.out.println("New Claim ID is : " + newClaimNo);
            if (!newClaimNo.equalsIgnoreCase(claimNo)) {
                System.out.println("New Claim ID created with new service provider after reselection done successfully " + newClaimNo);
            } else {
                System.out.println("Reselect not done and New Claim ID not created successfully");
            }
        }
    }

    /*Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan in New UI
    Click on D&G Logo and navigate to Orbit homepage
     */
    public void clickOnDnGLogo() {
        try {
            if (base.checkIfELementIsAvailable(DandGLogo) & base.isClickable(DandGLogo)) {
                base.highlightElement(DandGLogo);
                base.clickWithJsExecutor(DandGLogo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on D and G logo");
        }
    }


    /*Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan in New UI
    Verify Job Status changed and updated with Job Reassigned for old claim ID.
     */
    public boolean oldClaimJobReassignedStatus(String oldClaimIdStatus) {
        boolean status = false;
        base.waitForPageToLoad();
        base.highlightElement(oldServiceProviderName);
        String oldServiceProvider = driver.findElement(By.xpath(oldServiceProviderNamePath)).getText().toString();
        System.out.println("Old Service provider name is : " + oldServiceProvider);
        if (oldServiceProvider.contains("WHIRLPOOL UK APPLIANCE LTD")) {
            System.out.println("Old claim ID closed successfully");
        }
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains("JOB REASSIGNED")) {
            String oldClaimIdJobStatus = driver.findElement(By.xpath(claimJobStatusPath)).getText();
            System.out.println("Job status is : " + oldClaimIdJobStatus);
            base.highlightElement(jobStatus);
            if (oldClaimIdJobStatus.equalsIgnoreCase(oldClaimIdStatus)) {
                System.out.println("Old claim cancelled and job status changed to Job Reassigned");
                status = true;
            }
        } else {
            System.out.println("Status not updated successfully after job reassigned to different service provider");
            status = false;
        }
        return status;
    }

    /*Name: Manish Kumar Jain
    Scenario: Reselect an appointment with new Service Provider for Whirlpool plan in New UI
    Verify Appointment Completion Status updated with Claim Closed - Reassigned for old claim ID in Repair Information
     */

    public void verifyOldClaimIdAppointmentCompletionStatusBookingOverview(String appointmentCompletionStatus) {
        base.waitForPageToLoad();
        if (base.waitForElementVisible(oldClaimIdAppointmentCompletionStatus) & base.checkIfELementIsAvailable(oldClaimIdAppointmentCompletionStatus)) {
            String appointmentStatus = driver.findElement(By.xpath(oldClaimIdAppointmentCompletionStatusPath)).getText().toString();
            if (appointmentStatus.equalsIgnoreCase(appointmentCompletionStatus)) {
                System.out.println("Job successfully reassigned to different service provider");
            } else {
                System.out.println("Job has not reassigned to different service provider");
            }

        }
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Pay & Claim Scenario from Reselect Service provider
    Click on Search Other Service Provider button and click continue button and Pay & Claim button
     */

    public void clickOnSearchOtherServiceProviderAndPayAndClaim() throws InterruptedException {
        if (base.waitForElementVisible(serviceProvidersAppointment_searchOtherServicePoviderButton) && serviceProvidersAppointment_searchOtherServicePoviderButton.isEnabled()) {
            base.highlightElement(serviceProvidersAppointment_searchOtherServicePoviderButton);
            base.clickWithJsExecutor(serviceProvidersAppointment_searchOtherServicePoviderButton);
            Thread.sleep(3000);
            base.waitForElementVisible(payAndClaimButton);
            base.clickWithJsExecutor(payAndClaimButton);
        } else {
            Thread.sleep(3000);
            base.waitForElementVisible(payAndClaimButton);
            base.clickWithJsExecutor(payAndClaimButton);
        }
    }


    /*
    Name: Manish Kumar Jain
    Scenario: Pay & Claim Scenario from Reselect Service provider
    Click on Customer has confirmed to the Pay and Claim Options checkbox
     */

    public void clickOnPayAndClaimOptionsCheckboxAndConfirmRebookButton() throws InterruptedException {
        Thread.sleep(3000);
        if (base.checkIfELementIsAvailable(payAndClaim_Checkbox) && payAndClaim_Checkbox.isSelected()) {
            base.highlightElement(payAndClaim_RebookButton);
            base.clickWithJsExecutor(payAndClaim_RebookButton);
            Thread.sleep(2000);
        } else {
            base.clickWithJsExecutor(payAndClaim_Checkbox);
            Thread.sleep(2000);
            base.highlightElement(payAndClaim_RebookButton);
            base.clickWithJsExecutor(payAndClaim_RebookButton);
            Thread.sleep(2000);
        }
    }

    public void clickOnPayAndClaimConfirmButton() throws InterruptedException {
        Thread.sleep(3000);
        if (base.checkIfELementIsAvailable(payAndClaim_ConfirmButton)) {
            base.highlightElement(payAndClaim_ConfirmButton);
            base.clickWithJsExecutor(payAndClaim_ConfirmButton);
            Thread.sleep(2000);
        } else {
            base.waitToLoadElement();
            base.highlightElement(payAndClaim_ConfirmButton);
            base.clickWithJsExecutor(payAndClaim_ConfirmButton);
            Thread.sleep(2000);
        }
    }

    public boolean isPayAndClaimConfirmationDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(payAndClaimConfirmationPage)) {
                base.highlightElement(payAndClaimConfirmationPage);
                status = true;
            } else {
                LOGGER.error("Unable to verify the Pay & Claim Confirmation page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*
    Name: Manish Kumar Jain
    Scenario: Search for a claim with the help  Plan No. and navigate to Review Claim Page
    Steps: Click on checkbox present in the first row of the Job search grid
     */

    public void clickOnCheckboxInJobSearchGrid() throws InterruptedException {
        Thread.sleep(3000);
        base.highlightElement(checkBoxFirstRowGrid);
        //identify rows of table.
        base.clickWithJsExecutor(checkBoxFirstRowGrid);
        Thread.sleep(3000);

    }

    public void clickOnViewJobDetailsButton() throws InterruptedException {
        base.waitForElementVisible(viewJobDetailsButton);
        Thread.sleep(3000);
        base.highlightElement(viewJobDetailsButton);
        base.clickWithJsExecutor(viewJobDetailsButton);
        Thread.sleep(2000);
    }

}
