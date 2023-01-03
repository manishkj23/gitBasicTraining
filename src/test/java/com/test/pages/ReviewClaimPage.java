package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReviewClaimPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private DialogPoppupPage popupWindow;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    ////*[@id=\"section_64_c\"]//div/div/div[contains(.,\"Booking Summary\")]
//    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"][contains(.,\"FIELD CALL\")]")
    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    WebElement jobStatus;

    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    WebElement jobStatusAny;

    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    private WebElement jobStatusVerify;

    @FindBy(xpath = "//*[@id=\"menuIconHolder\"]/a[contains(.,\"Menu\")]/div")
    WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"logo\"]")
    WebElement DGLOGO;

    @FindBy(xpath = "//*[@id=\"SystemNotesPanel\"]//fieldset[contains(.,\"Labour and Parts Cost \")]/img[@class = \"fieldsetArror\"]")
    WebElement labourAndPartsCostButton;

    private final String labourAndPartsCostButtonSelectedXpath = "//*[@id=\"SystemNotesPanel\"]//fieldset[contains(.,\"Labour and Parts Cost \")]/img[@class = \"fieldsetArror\"][contains(@src,\"arrow_down_green\")]";
    @FindBy(xpath = labourAndPartsCostButtonSelectedXpath)
    WebElement labourAndPartsCostButtonSelected;

    @FindBy(xpath = "//*[@id=\"engineerName\"]")
    WebElement engineerName;

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//span[contains(.,\"Full Breakdown\")]/input")
    WebElement fullBreakdownRadiobutton;

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//span[contains(.,\"Partial Breakdown\")]/input")
    WebElement partialBreakdownRadiobutton;

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//div[contains(@class,\"ri_div\")][contains(.,\"Serial Number\")]/img")
    WebElement serialNumberIcon;

    @FindBy(xpath = "//div[@role=\"dialog\"]//input[@id=\"ppf_SerialNo\"]")
    WebElement updateSerialNumberField;

    @FindBy(xpath = "//div[@role=\"dialog\"]//textarea[@id=\"ppf_SerialUpdateReason\"]")
    WebElement updateSerialReasonText;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Finish\")]")
    WebElement finishButtonSerialUpdate;

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[1]/select")
    WebElement faulcodeSectionB; //2282 : X17 - at upper side

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[2]/select")
    WebElement faulcodeSectionE; //-1 : BREAKDOWN -

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//button[contains(.,\"Create Estimate\")]")
    WebElement createEstimateButton;
    //
    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Authority Line Summary Page\")]")
    WebElement authorityLinePageTitle;
    //
    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Create Estimate\")]")
    WebElement createEstimatePopupTitle;

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Proceed\")]")
    WebElement createEstimateProceedButton;

    @FindBy(xpath = "//*[@id=\"LitePartsTable\"]//tr/td/a[contains(.,\"Add Part\")]")
    WebElement addPartLink;

    @FindBy(xpath = "//*[@id=\"PartStatus_51556\"]")
    WebElement partStatus; // Part Fitted value="11" / Part Fitted

    @FindBy(xpath = "//*[@id=\"ltePartsTableShow\"]")
    WebElement displayPartFaultCodesCheckbox;

    @FindBy(xpath = "//*[@id=\"DgPartFaultCodeID_74\"]")
    WebElement addPartEFaultCode;

    @FindBy(xpath = "//*[@id=\"lite_part_net_51556\"]")
    WebElement netCost;

    @FindBy(xpath = "//*[@id=\"lite_part_gross_51556\"]")
    WebElement grossValue; // just to cilck on it and wait for 2 sec's

    @FindBy(xpath = "//*[@id=\"lite_part_desc_51556\"]")
    WebElement partDescription;

    @FindBy(xpath = "//*[@id=\"lite_part_no_51556\"]")
    WebElement partNumber;

    @FindBy(xpath = "//*[@id=\"LitePartsTable\"]//tr/td/a[contains(.,\"Add Adjustment\")]")
    WebElement addAdjustmentLink;


    @FindBy(xpath = "//*[@id=\"PopUpLiteParts\"]//button[contains(.,\"Lock Estimate\")]")
    WebElement lockEstimateButton;

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Continue\")]")
    WebElement continueWithWarning;

    @FindBy(xpath = "//*[@id=\"raJobDt\"]")
    WebElement claimReviewPageButton;

    @FindBy(xpath = "//div[@class=\"SpMapRadioBut\"]//label/input[contains(@value,\"FLYINGTOOLBOX RESPOND\")]")
    private WebElement spAsFlyingToolBox;

    @FindBy(xpath = "//*[@id=\"CustomerCommunicationTable\"]/tbody/tr[1]")
    private WebElement customerCommsEmailAndSms;

    @FindBy(xpath = "//*[@id=\"communicationType\"]")
    private WebElement smsCommsRadiobutton;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr[last()]/td[7]")
    private WebElement currentDiaryAppointmentStatus;

    @FindBy(xpath = "//*[@id=\"Appointments\"]/fieldset/img[contains(@onclick,\"toggleSection\")]")
    private WebElement enableDiaryAppointmentSection;

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

    private final String missingInfoPopup_Xpath = "//div[@role=\"dialog\"][//span[contains(.,\"Missing Information\")]]//input[@value=\"OK\"]";
    @FindBy(xpath = missingInfoPopup_Xpath)
    private WebElement missingInfoPopup_writtenOff;

    @FindBy(xpath = "//div[contains(.,\"Booking Summary\")]//table/tbody/tr[contains(.,\"System Status\")]/td[2]")
    private WebElement workflowSystemStatus;

    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    private WebElement jobCompletedStatus;

    @FindBy(xpath = "//div[@id=\"SystemNotesPanel\"]//div[contains(.,\"Booking Summary\")]//table[contains(.,\"Job Completion Status\")]/tbody/tr[contains(.,\"Job Completion Status \")]/td[2]")
    private WebElement workflowJobCompletionStatus;

    @FindBy(xpath = "//table[@id=\"StatusChanges\"]//tr[contains(.,\"REPAIR COMPLETE\")]")
    private WebElement statusChangesCompletedStatus;

    @FindBy(xpath = "//table[@id=\"RAHistory\"]/tbody/tr[count(*)>0]/..")
    private WebElement raHistortyTableWithStatusChange;

    @FindBy(xpath = "//legend[contains(.,\"Fault Codes\")]/../..//div[@id=\"whirlpoolFCHolder_7\"]/div[contains(.,\"Fault Code\")]//select/option")
    private WebElement faultCodeSectionTextExist;

    @FindBy(xpath = "//legend[contains(.,\"Fault Codes\")]/../..//div[@id=\"whirlpoolFCHolder_7\"]/div[contains(.,\"Problem Code\")]//select/option")
    private WebElement problemCodeSectionTextExist;

    // ServiceCost
    @FindBy(xpath = "//*[@id=\"PaymentDue\"]/span[@class=\"fieldValue\"]")
    private WebElement serviceCostPaymentDue;

    //
    // System Notes :
    @FindBy(xpath = "//button[@id=\"addContactHistory\"]/span")
    private WebElement systemNotesAddNotesButton;

    @FindBy(xpath = "//*[@id=\"Note\"]")
    private WebElement systemNotesAddNewNoteTextArea;

    @FindBy(xpath = "//*[@id=\"insert_save_btn_notes\"]")
    private WebElement systemNotesAddNewNoteSaveButton;

    @FindBy(xpath = "//div[@id=\"cboxContent\"]//input[@id=\"cancel_btn\"]")
    private WebElement systemNotesAddNewNotePopupOkButton;

    @FindBy(xpath = "//*[@id=\"dataInsertedMsgForm\"][//legend[contains(.,\"Add Note\")]]//p[contains(.,\"Your data has been inserted successfully\")]")
    private WebElement systemNotesAddNoteSuccessfulMessage;

    @FindBy(xpath = "//table[@id=\"ContactHistory\"]/tbody/tr[1]")
    private WebElement updatedSystemNoteFirstRecord;

    @FindBy(xpath = "//legend[contains(.,\"Status Changes \")]/../img[@class=\"fieldsetArror\"]")
    private WebElement statusChangeSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"System Notes\")]/../img[@class=\"fieldsetArror\"]")
    private WebElement systemNotesSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"Fault Codes\")]/../img[@class=\"fieldsetArror\"]")
    private WebElement faultCodesSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"Diary Appointments\")]/../img[@class=\"fieldsetArror\"]")
    private WebElement diaryAppointmentSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"Service Costs\")]/../img[@class=\"fieldsetArror\"]")
    private WebElement serviceCostSectionDisplayButton;

    @FindBy(xpath = "//table[@id=\"AppointmentsDT\"]/tbody/tr[1]/td[1]")
    private WebElement diaryAppointmentFirstRecord;

    @FindBy(xpath = "//*[@id=\"ToolTables_AppointmentsDT_2\"]/span[contains(.,\"Rebook\")]")
    private WebElement diaryAppointment_RebookButton;

    @FindBy(xpath = "//*[@id=\"ToolTables_AppointmentsDT_1\"]/span[contains(.,\"Cancel\")]")
    private WebElement diaryAppointment_CancelAppointmentButton;

    private final String secondAvailableDateXpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][2]";
    @FindBy(xpath = secondAvailableDateXpath)
    private WebElement secondAvailableDate;

    @FindBy(xpath = "//*[@id=\"claimApptRebook\"]")
    private WebElement confirmRebookingButton;

    @FindBy(xpath = "//div[@role=\"dialog\"][//*[contains(.,\"Confirm Rebooking\")]]//button[contains(.,\"Confirm\")]")
    private WebElement popupConfirmRebookingButton;

    @FindBy(xpath = "//a[@id='ToolTables_AppointmentsDT_2'][@class='DTTT_button btnStandardInsert findnewDGAppointmnent']")
    private WebElement findNewAppointmentButton;

    @FindBy(xpath = "//legend[contains(text(),'Find New Appointment')]")
    private WebElement FindNewAppointmentPopUpDisplay;

    @FindBy(xpath = "//input[@id='StartAppointmnetSearch' and @name='StartAppointmnetSearch']")
    private WebElement findNewAppointment_StartAppointmentSearchButton;

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

    private final String searchOtherServiceProvider = "//input[@id='showotherspscal'][@name='showotherspscal']";
    @FindBy(xpath = searchOtherServiceProvider)
    private WebElement findNewAppointment_searchOtherServicepPoviderButton;

    private final String fieldCallCalendarAvailability = "//*[@id='claimRebkAppt_rSp']//tr/td[contains(@class,\"dayAvailable\")][9]";
    @FindBy(xpath = fieldCallCalendarAvailability)
    private WebElement findNewAppointment_fieldCallCalendarAvailability;

    @FindBy(xpath = "//input[@id='allocateSP0'][@name='allocateSP']")
    private WebElement findNewAppointment_availableServiceProviderRadioButton;

    @FindBy(xpath = "//input[@id='rebookPayAndUse' and @name='rebookPayAndUse']")
    private WebElement findNewAppointment_rebookButtonForReselectionSP;

    @FindBy(xpath = "//span[contains(text(),'Alert')][@id='ui-id-13']")
    private WebElement findNewAppointment_alertPopUpBox;

    @FindBy(xpath = "//*[@class='ui-dialog-buttonset']//button[contains(text(),'Yes')]")
    private WebElement findNewAppointment_confirmationAlertPopUpYes;

    @FindBy(xpath = "//div[@id='jobdetails']//div[@id='jbTpDet']//div[@style='float: left; text-align: center; margin-left: 50px;']")
    private WebElement reviewClaimPage_claimSection;

    private final String claimNumberPath = "//div[@id='jobdetails']//div[@id='jbTpDet']//div[@style='float: left; text-align: center; margin-left: 50px;']//span[@class='bold']";
    @FindBy(xpath = claimNumberPath)
    private WebElement reviewClaimPage_claimNo;

    public ReviewClaimPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, DialogPoppupPage popupPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.popupWindow = popupPage;
        PageFactory.initElements(driver, this);
    }

    @Before
    public void checkAndCloseAnyPopupDisplayed() {
        if (popupWindow.isPopUpDisplayed()) {
            popupWindow.closePopup();
        }
    }

    public String getServiceCostValue() {
        String value = null;
        try {
            if (base.checkIfELementIsAvailable(serviceCostSectionDisplayButton)) {
                base.clickWithJsExecutor(serviceCostSectionDisplayButton);
            }
            if (base.checkIfELementIsAvailable(serviceCostPaymentDue)) {
                value = serviceCostPaymentDue.getText().trim();
                base.highlightElement(serviceCostPaymentDue);
            } else {
                base.waitForPageToLoad();
                base.hardWait("2000");
                if (base.checkIfELementIsAvailable(serviceCostPaymentDue)) {
                    value = serviceCostPaymentDue.getText().trim();
                    base.highlightElement(serviceCostPaymentDue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }

    public boolean isWokflowStatusUpdated() {
        boolean status = false;
        try {
            base.checkIfELementIsAvailable(workflowSystemStatus);
            if (workflowSystemStatus.getText().contains("REPAIR COMPLETED")) {
                base.highlightElement(workflowSystemStatus);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isWokflowStatusUpdated(String stat) {
        boolean status = false;
        try {
            base.checkIfELementIsAvailable(workflowSystemStatus);
            if (workflowSystemStatus.getText().contains(stat)) {
                base.highlightElement(workflowSystemStatus);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isJobCompletionStatusInWorkflowUpdated() {
        boolean status = false;
        try {
            base.checkIfELementIsAvailable(workflowSystemStatus);
            if (workflowSystemStatus.getText().contains("REPAIR COMPLETED")) {
                base.highlightElement(workflowSystemStatus);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isJobCompletionStatusUpdated() {
        boolean status = false;
        try {
            base.checkIfELementIsAvailable(jobCompletedStatus);
            if (jobCompletedStatus.getText().contains("REPAIR COMPLETED")) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isStatusChangesUpdated() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(statusChangeSectionDisplayButton)) {
                base.clickWithJsExecutor(statusChangeSectionDisplayButton);
            }
            if (base.checkIfELementIsAvailable(statusChangesCompletedStatus)) {
                base.highlightElement(statusChangesCompletedStatus);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(statusChangesCompletedStatus)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(statusChangesCompletedStatus)) {
                    base.highlightElement(statusChangesCompletedStatus);
                    status = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isRAHistoryStatusChangesUpdated() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(raHistortyTableWithStatusChange)) {
                base.highlightElement(raHistortyTableWithStatusChange);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(raHistortyTableWithStatusChange)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(raHistortyTableWithStatusChange)) {
                    base.highlightElement(raHistortyTableWithStatusChange);
                    status = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isFaultSectionUpdated() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(faultCodesSectionDisplayButton)) {
                base.clickWithJsExecutor(faultCodesSectionDisplayButton);
            }
            if (base.checkIfELementIsAvailable(faultCodeSectionTextExist) && base.checkIfELementIsAvailable(problemCodeSectionTextExist)) {
                base.highlightElement(faultCodeSectionTextExist);
                base.highlightElement(problemCodeSectionTextExist);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(faultCodeSectionTextExist)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(faultCodeSectionTextExist) && base.checkIfELementIsAvailable(problemCodeSectionTextExist)) {
                    base.highlightElement(faultCodeSectionTextExist);
                    base.highlightElement(problemCodeSectionTextExist);
                    status = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private void addSystemNotes() {
        if (base.isClickable(systemNotesAddNotesButton) && (base.checkIfELementIsAvailable(systemNotesAddNotesButton))) {
            base.clickWithJsExecutor(systemNotesAddNotesButton);
            if (base.checkIfELementIsAvailable(systemNotesAddNewNoteTextArea)) {
                base.sendFieldInputData(systemNotesAddNewNoteTextArea, base.scenarioName);
                base.clickWithJsExecutor(systemNotesAddNewNoteSaveButton);
                base.clickWithJsExecutor(systemNotesAddNewNotePopupOkButton);


            } else {
                base.hardWait("2000");
                if (base.checkIfELementIsAvailable(systemNotesAddNewNoteTextArea)) {
                    base.sendFieldInputData(systemNotesAddNewNoteTextArea, base.scenarioName);
                    base.clickWithJsExecutor(systemNotesAddNewNoteSaveButton);
                    base.clickWithJsExecutor(systemNotesAddNewNotePopupOkButton);
                }
            }
        }
    }

    public boolean addAndVerifyNewSystemNotesAdded() {
        boolean status = false;
        try {
            // add system note down arrow select logic
            if (base.checkIfELementIsAvailable(systemNotesSectionDisplayButton)) {
                base.clickWithJsExecutor(systemNotesSectionDisplayButton);
            }
            addSystemNotes();

            if (updatedSystemNoteFirstRecord.getText().contains(base.scenarioName)) {
                status = true;
            } else {
                base.hardWait("2000");
                if (updatedSystemNoteFirstRecord.getText().contains(base.scenarioName) | (!updatedSystemNoteFirstRecord.getText().isEmpty())) {
                    status = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isCustomerCommunicationsEmailSectionDisplayed() {
        boolean status = false;
        try {
            base.hardWait("2000");
            if (base.checkIfELementIsAvailable(customerCommsEmailAndSms) && customerCommsEmailAndSms.isDisplayed()) {
                base.highlightElement(customerCommsEmailAndSms);
                status = true;
            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isCustomerCommunicationsSmsSectionDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(smsCommsRadiobutton)) {
                base.clickWithJsExecutor(smsCommsRadiobutton);
                if (base.checkIfELementIsAvailable(customerCommsEmailAndSms) && customerCommsEmailAndSms.isDisplayed()) {
                    base.highlightElement(customerCommsEmailAndSms);
                    status = true;
                }
            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void setServiceProviderAsFlyingToolbox() {
        try {
            if (base.checkIfELementIsAvailable(spAsFlyingToolBox) && spAsFlyingToolBox.isSelected()) {

            } else {
                base.clickWithJsExecutor(spAsFlyingToolBox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    public boolean isReviewClaimPageDisplayed(){
//        base.waitTillElementFound(jobStatus);
//        base.waitForPageToLoad();
//        base.highlightElement(jobStatus);
//        return (jobStatus.isDisplayed()) ? true : false;
//    }
    public boolean isReviewClaimJobStatusDisplayed() {
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains("FIELD CALL")) {
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
//        return (jobStatus.isDisplayed()) ? true : false;
    }

    public boolean isReviewClaimJobStatusDisplayed(String jobStatusFinal) {
        boolean status = false;
        base.waitTillElementFound(jobStatusVerify);
        base.waitForPageToLoad();
        if (jobStatusVerify.getText().contains(jobStatusFinal)) {
            base.highlightElement(jobStatusVerify);
            status = true;
        }
        return status;
    }


    public void clickMenuOption() {
        if (base.getElementFromXpath(seleniumHelper.getAbsoluteXPath(menuButton)) == null) {
            base.hardWait("3000");
            base.waitTillElementFound(menuButton);
            base.clickElement(menuButton);
        } else {
            base.clickElement(menuButton);
        }
    }

    public void clickDandGLogo() {
        try {
            Thread.sleep(5000);
            base.waitTillElementFound(DGLOGO);
            base.clickWithJsExecutor(DGLOGO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Labour and Parts Sections -
     * - Check if the Sections is displayed first.
     * - And select the section if not selected.
     * - And enter the Labour section details
     * -
     */

    public void setLabourAndPartsSection() {
        clickLabourAndPartsSection();
        base.waitTillElementFound(engineerName);
        base.highlightElement(engineerName);
        base.sendFieldInputData(engineerName, "Test Engineer");

    }

    private void clickLabourAndPartsSection() {
        if (!isLabourAndPartsSectionDisplayed()) {
            base.scrollToElement(labourAndPartsCostButton);
            base.clickWithJsExecutor(labourAndPartsCostButton);
        }
    }

    private boolean isLabourAndPartsSectionDisplayed() {
        boolean status = false;
        try {
            if (base.quickWait(labourAndPartsCostButtonSelectedXpath).getText() != null) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyTheCurrentDiaryApointmentStatus(String stat) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(enableDiaryAppointmentSection)) {
                base.clickWithJsExecutor(enableDiaryAppointmentSection);
                base.waitForElementVisible(currentDiaryAppointmentStatus);
                if (base.checkIfELementIsAvailable(currentDiaryAppointmentStatus) & currentDiaryAppointmentStatus.isDisplayed() && currentDiaryAppointmentStatus.equals(stat)) {
                    base.highlightElementWithScreenshot(currentDiaryAppointmentStatus, "DAAppointmentStatus_" + stat);
                    status = true;
                } else {
                    base.waitToLoadElement();
                    base.waitForElementVisible(currentDiaryAppointmentStatus);
                    if (base.checkIfELementIsAvailable(currentDiaryAppointmentStatus) & currentDiaryAppointmentStatus.isDisplayed() && currentDiaryAppointmentStatus.getText().equals(stat.toString())) {
                        base.highlightElementWithScreenshot(currentDiaryAppointmentStatus, "DAAppointmentStatus_" + stat);
                        status = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to verify DA Appointment");
        }
        return status;
    }

    public void processWrittenOff(String writtenOffStatus) {

        base.clickElement(RAStatusOverrideCheckbox);
        base.waitForElementVisible(newRAStatusDropdownList);
        base.isClickable(newRAStatusDropdownList);
        base.sendFieldInputData(newRAStatusDropdownList, writtenOffStatus);
        try {
            seleniumHelper.actionToMoveDownOnList(newRAStatusDropdownList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        if (base.checkElementIsAvailableByXpath(missingInfoPopup_Xpath)) {
            base.clickElement(base.quickWait(missingInfoPopup_Xpath));
        }
        base.hardWait("3000");
        base.refreshPage();
    }

    public boolean isClaimWrittenOff(String outcome) {
        boolean status = false;
        try {
            if (base.getElementFromXpath(seleniumHelper.getAbsoluteXPath(jobCompletedStatus)) != null) {
                if (jobCompletedStatus.getText().equals(outcome)) {
                    status = true;
                }
            } else {
                base.waitTillElementFound(jobCompletedStatus);
                if (jobCompletedStatus.getText().equals(outcome)) {
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //Manish Kumar Jain- > 12th July 2021

    public boolean findNewAppointmentCalendarDisplayed() {
        if (!base.checkIfELementIsAvailable(base.getElementFromXpath(NinethAvailableDateXpath))) {
            base.hardWait("2000");
        }
        return (base.getElementFromXpath(NinethAvailableDateXpath) != null) ? true : false;
    }

    //Manish Kumar Jain:
    public boolean claimJobStatusDisplayedAfterRebooked() {
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains("FIELD CALL")) {
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






    public void rebookButtonConfirmationPopUpForReselectServiceProvider() throws InterruptedException {
        if (base.waitForElementVisible(findNewAppointment_rebookButtonForReselectionSP) && base.checkIfELementIsAvailable(findNewAppointment_rebookButtonForReselectionSP)) {
            base.isElementAvilable(findNewAppointment_rebookButtonForReselectionSP);
            base.highlightElement(findNewAppointment_rebookButtonForReselectionSP);
            base.clickWithJsExecutor(findNewAppointment_rebookButtonForReselectionSP);
        }
        Thread.sleep(3000);
        if (base.waitForElementVisible(findNewAppointment_alertPopUpBox) && base.checkIfELementIsAvailable(findNewAppointment_alertPopUpBox)) {
            base.isElementAvilable(findNewAppointment_confirmationAlertPopUpYes);
            base.highlightElement(findNewAppointment_confirmationAlertPopUpYes);
            base.clickWithJsExecutor(findNewAppointment_confirmationAlertPopUpYes);
        }

    }



    /*Name: Manish Kumar Jain
    Scenario Name: Verify that the new claim ID created and compared with the old ClaimID "<ClaimNo>"
     */
    public void oldClaimIComparedWithNewClaimId(String claimNo) {
        if (base.waitForElementVisible(reviewClaimPage_claimSection) && base.checkIfELementIsAvailable(reviewClaimPage_claimNo)) {
            String claimNewNo = base.getElementFromXpath(claimNumberPath).getText();
            System.out.println("New Claim ID is " + claimNewNo);
            if (claimNewNo != claimNo)
                System.out.println("Reselection of new service provider done successfully " + claimNewNo);
        }
    }

    /*Name: Manish Kumar Jain
    Scenario Name: Verify the old claim updated with status Job Reassigned from the Review Claim section
     */
    public boolean oldClaimJobReassignedStatus(String reviewClaimStatus) {
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains("JOB REASSIGNED")) {
            String status1 = driver.findElement(By.xpath("//*[@id='JuBarStatusName']")).getText();
            base.highlightElement(jobStatus);
            if (status1 == reviewClaimStatus)
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






}
