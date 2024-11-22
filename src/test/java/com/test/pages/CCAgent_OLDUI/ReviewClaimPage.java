package com.test.pages.CCAgent_OLDUI;

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

    private static final String REPAIR_PAUSED_POPUP = "Repair Paused - TestWaivePayment";

    private static final String CLICK_HERE = "Click here";

    private static final String CLOSE = "Close";

    private static final String REPAIR_PAUSED_TOASTER_MESSAGE = "Repair Paused";

//    private static final String GO_TO_PREVIOUS_PLAN_BUTTON = "Go to previous plan";

//    private static final String GO_TO_New_PLAN_BUTTON = "Go to new plan";

    private static final String PLAN_SKIPPED_TO_TEXT = "Information - Plan Skipped to";

    private static final String PLAN_SKIPPED_FROM_TEXT = "Information - Plan Skipped from";

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    ////*[@id=\"section_64_c\"]//div/div/div[contains(.,\"Booking Summary\")]
//    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"][contains(.,\"FIELD CALL\")]")
    @FindBy(xpath = "//*[@id=\"JobStatusName\"]")
    private WebElement jobStatus;

    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    private WebElement jobStatusAny;

    @FindBy(xpath = "//*[@id=\"JuBarStatusName\"]")
    private WebElement jobStatusVerify;

    @FindBy(xpath = "//*[@id=\"menuIconHolder\"]/a[contains(.,\"Menu\")]/div")
    private WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"logo\"]")
    private WebElement DGLOGO;

    @FindBy(xpath = "//*[@id=\"SystemNotesPanel\"]//fieldset[contains(.,\"Labour and Parts Cost \")]/img[@class = \"fieldsetArror\"]")
    private WebElement labourAndPartsCostButton;

    private final String labourAndPartsCostButtonSelectedXpath = "//*[@id=\"SystemNotesPanel\"]//fieldset[contains(.,\"Labour and Parts Cost \")]/img[@class = \"fieldsetArror\"][contains(@src,\"arrow_down_green\")]";
    @FindBy(xpath = labourAndPartsCostButtonSelectedXpath)
    private WebElement labourAndPartsCostButtonSelected;

    @FindBy(xpath = "//*[@id=\"engineerName\"]")
    private WebElement engineerName;

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//span[contains(.,\"Full Breakdown\")]/input")
    private WebElement fullBreakdownRadiobutton;

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//span[contains(.,\"Partial Breakdown\")]/input")
    private WebElement partialBreakdownRadiobutton;

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//div[contains(@class,\"ri_div\")][contains(.,\"Serial Number\")]/img")
    private WebElement serialNumberIcon;

    @FindBy(xpath = "//div[@role=\"dialog\"]//input[@id=\"ppf_SerialNo\"]")
    private WebElement updateSerialNumberField;

    @FindBy(xpath = "//div[@role=\"dialog\"]//textarea[@id=\"ppf_SerialUpdateReason\"]")
    private WebElement updateSerialReasonText;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Finish\")]")
    private WebElement finishButtonSerialUpdate;

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[1]/select")
    private WebElement faulcodeSectionB; //2282 : X17 - at upper side

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[2]/select")
    private WebElement faulcodeSectionE; //-1 : BREAKDOWN -

    @FindBy(xpath = "//*[@id=\"section_68_c\"]//button[contains(.,\"Create Estimate\")]")
    private WebElement createEstimateButton;
    //
    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Authority Line Summary Page\")]")
    private WebElement authorityLinePageTitle;
    //
    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Create Estimate\")]")
    private WebElement createEstimatePopupTitle;

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Proceed\")]")
    private WebElement createEstimateProceedButton;

    @FindBy(xpath = "//*[@id=\"LitePartsTable\"]//tr/td/a[contains(.,\"Add Part\")]")
    private WebElement addPartLink;

    @FindBy(xpath = "//*[@id=\"PartStatus_51556\"]")
    private WebElement partStatus; // Part Fitted value="11" / Part Fitted

    @FindBy(xpath = "//*[@id=\"ltePartsTableShow\"]")
    private WebElement displayPartFaultCodesCheckbox;

    @FindBy(xpath = "//*[@id=\"DgPartFaultCodeID_74\"]")
    private WebElement addPartEFaultCode;

    @FindBy(xpath = "//*[@id=\"lite_part_net_51556\"]")
    private WebElement netCost;

    @FindBy(xpath = "//*[@id=\"lite_part_gross_51556\"]")
    private WebElement grossValue; // just to cilck on it and wait for 2 sec's

    @FindBy(xpath = "//*[@id=\"lite_part_desc_51556\"]")
    private WebElement partDescription;

    @FindBy(xpath = "//*[@id=\"lite_part_no_51556\"]")
    private WebElement partNumber;

    @FindBy(xpath = "//*[@id=\"LitePartsTable\"]//tr/td/a[contains(.,\"Add Adjustment\")]")
    private WebElement addAdjustmentLink;


    @FindBy(xpath = "//*[@id=\"PopUpLiteParts\"]//button[contains(.,\"Lock Estimate\")]")
    private WebElement lockEstimateButton;

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Continue\")]")
    private WebElement continueWithWarning;

    @FindBy(xpath = "//*[@id=\"raJobDt\"]")
    private WebElement claimReviewPageButton;

    @FindBy(xpath = "//div[@class=\"SpMapRadioBut\"]//label/input[contains(@value,\"FLYINGTOOLBOX RESPOND\")]")
    private WebElement spAsFlyingToolBox;

    @FindBy(xpath = "//*[@id=\"CustomerCommunicationTable\"]/tbody/tr[1]/td[3]")
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

    @FindBy(xpath = "//legend[contains(.,\"Status Changes \")]/../img[contains(@class,\"fieldsetArror\")]")
    private WebElement statusChangeSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"System Notes\")]/../img[contains(@class,\"fieldsetArror\")]")
    private WebElement systemNotesSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"Fault Codes\")]/../img[contains(@class,\"fieldsetArror\")]")
    private WebElement faultCodesSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"Diary Appointments\")]/../img[contains(@class,\"fieldsetArror\")]")
    private WebElement diaryAppointmentSectionDisplayButton;

    @FindBy(xpath = "//legend[contains(.,\"Service Costs\")]/../img[contains(@class,\"fieldsetArror\")]")
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

    @FindBy(xpath = "//table[@id=\"RAHistory\"]//tbody/tr[contains(.,\"CLAIM ON HOLD\")]")
    private WebElement claimOnHoldRAStatus;

    private final String reciperoViewButtonXpath = "//*[@id=\"reciperoButtonContainer\"]/img";
    @FindBy(xpath = reciperoViewButtonXpath)
    private WebElement reciperoViewButton;

    @FindBy(xpath = "//span[@id=\"ServiceCentreAcronymSpan\"]")
    private WebElement serviceProviderName;

    @FindBy(xpath = "//span[@id=\"showServiceCentreJobNo\"]")
    private WebElement serviceProviderJobNo;

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//span[contains(.,\"Claim No\")]/../span[2]")
    private WebElement orbitCurrentClaimNumber;

    /*
    Manish Kumar Jain
    Date: 17th Nov
     */
    @FindBy(xpath = "//input[@id='jobnoSearch']")
    private WebElement claimNumberSearchInput;

    @FindBy(xpath = "//div[@style='float:left; margin-bottom: 10px; width: 100%;']//img[@onclick='goToSearchJob();']")
    private WebElement claimNumberSearchButton;

    @FindBy(xpath = "//a[contains(@id,'ToolTables_AppointmentsDT')][@class='DTTT_button btnStandardInsert findnewDGAppointmnent']")
    private WebElement findNewAppointmentButton;

    @FindBy(xpath = "//legend[contains(text(),'Find New Appointment')]")
    private WebElement FindNewAppointmentPopUpDisplay;

    @FindBy(xpath = "//input[@id='StartAppointmnetSearch' and @name='StartAppointmnetSearch']")
    private WebElement findNewAppointment_StartAppointmentSearchButton;

    private final String FifthAvailableDateXpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][5]";
    @FindBy(xpath = FifthAvailableDateXpath)
    private WebElement findNewAppointment_FifthAvailableDate;

    private final String preferredDateForSpecificSlot = "//span[@id='prefferedDelDate']";
    @FindBy(xpath = preferredDateForSpecificSlot)
    private WebElement findNewAppointment_preferredDateDisplay;

    @FindBy(xpath = "//input[@id='claimApptRebook']")
    private WebElement findNewAppointment_confirmRebookingButton;

    private final String RebookPopup = "//span[contains(text(),'Confirm Rebooking') and @class='ui-dialog-title ui_Warning']";
    @FindBy(xpath = RebookPopup)
    private WebElement findNewAppointment_confirmRebookingPopupTitle;

    private final String confirmRebookingAppointmentButton = "//button[text()='Confirm']";
    @FindBy(xpath = confirmRebookingAppointmentButton)
    private WebElement findNewAppointment_RebookAnAppointmentConfirmButton;

    private final String searchOtherServiceProvider = "//input[@id='showotherspscal'][@name='showotherspscal']";
    @FindBy(xpath = searchOtherServiceProvider)
    private WebElement findNewAppointment_searchOtherServicepPoviderButton;

    private final String searchOtherServiceProviderDisabled = "//input[@id='showotherspscal' and @class=\"btnStandard rounded disabled\" and @disabled=\"disabled\"]";
    @FindBy(xpath = searchOtherServiceProviderDisabled)
    private WebElement findNewAppointment_searchOtherServicepPoviderButtonDisabled;

    private final String fieldCallCalendarAvailability = "//*[@id='claimRebkAppt_rSp']//tr/td[contains(@class,\"dayAvailable\")][9]";
    @FindBy(xpath = fieldCallCalendarAvailability)
    private WebElement findNewAppointment_fieldCallCalendarNinthDayAvailability;

    private final String claimJobStatusPath = "//div[@id='ui2_top_header']//b[@id='JobStatusName']";
    @FindBy(xpath = claimJobStatusPath)
    WebElement claimJobStatus;

    @FindBy(xpath = "//div[@id='ui2_top_header']//b[@id='JobStatusName']")
    WebElement jobStatusAnyPath;

    @FindBy(xpath = "//input[@id='allocateSP0'][@name='allocateSP']")
    private WebElement findNewAppointment_availableServiceProviderRadioButton;

    @FindBy(xpath = "//input[@id='rebookPayAndUse' and @name='rebookPayAndUse']")
    private WebElement findNewAppointment_rebookButtonForReselectionSP;

    @FindBy(xpath = "//span[contains(text(),'Alert')][@id='ui-id-13'][@class=\"ui-dialog-title ui_Default\"]")
    private WebElement findNewAppointment_alertPopUpText;

    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//button[contains(text(),'Yes')][@type=\"button\"]")
    private WebElement findNewAppointment_confirmationAlertPopUpYes;

    @FindBy(xpath = "//div[@id='jobdetails']//div[@id='jbTpDet']//div[@style='float: left; text-align: center; margin-left: 50px;']")
    private WebElement reviewClaimPage_claimSection;

    private final String claimNumberPath = "//div[@id='jobdetails']//div[@id='jbTpDet']//div[@style='float: left; text-align: center; margin-left: 50px;']//span[@class='bold']";
    @FindBy(xpath = claimNumberPath)
    private WebElement reviewClaimPage_claimNo;

    private final String reviewClaimTab = "//label[contains(text(),'Review Claim')]";
    @FindBy(xpath = reviewClaimTab)
    private WebElement reviewClaimPage_reviewClaimTab;

    private final String claimJobReassignedPath = "//tr[@class='odd']//td[contains(text(),'Claim Closed - Reassigned')]";
    @FindBy(xpath = claimJobReassignedPath)
    private WebElement reviewClaimPage_appointmentStatusClaimJobReassigned;

    private final String rebookCalendarAvailability = "//table[@id='MainICCollectionCalendar']";
    @FindBy(xpath = rebookCalendarAvailability)
    private WebElement findNewAppointment_rebookCalendarAvailability;

    private final String oldServiceProviderNamePath = "//span[@id='ServiceCentreAcronymSpan']";
    @FindBy(xpath = oldServiceProviderNamePath)
    private WebElement reselect_newServiceProviderName;

    private final String confirmationAlertPopUpPath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Default']";
    @FindBy(xpath = confirmationAlertPopUpPath)
    private WebElement reselect_confirmationAlertPopUpBox;

    private final String DAndGLogoPath = "//td[contains(@width,'30%')]//div[contains(@style,'')]";
    @FindBy(xpath = DAndGLogoPath)
    private WebElement DAndGLogo;

    @FindBy(xpath = "//div[@id=\"JobStatusText\"]")
    private WebElement raCurrentStatus;

    private final String apptReselectErrorPopupPath = "//div[@id='modP']";
    @FindBy(xpath = apptReselectErrorPopupPath)
    private WebElement apptReselectErrorPopup;

    private final String continueButtonPath = "//div[@id='modP']//following::div//button";
    @FindBy(xpath = continueButtonPath)
    private WebElement continueButton;


    @FindBy(xpath = "//div[@id='reasonTitle']")
    private WebElement repairPausedPopUp;

    @FindBy(xpath = "//div[@class='toast-title']")
    private WebElement repairPausedToasterMessage;

    @FindBy(xpath = "//div/button[contains(text(),'Close')]")
    private static WebElement closeButton;

    @FindBy(xpath = "//div/a[@id='toastanchor']")
    private WebElement clickhereLink;

    @FindBy(xpath = "//div[contains(text(),'Go to previous plan')]")
    private WebElement goToPreviousPlanButton;

    @FindBy(xpath = "//div[@class='btn btn-sm btn-primary']")
    private WebElement goToNewPlanButton;

    @FindBy(xpath = "//div/b")
    private WebElement planSkippedTo_Text;

    @FindBy(xpath = "//div/b")
    private WebElement planSkippedFrom_Text;
    @FindBy(xpath = "//*[@id=\"makemodel\"]")
    private WebElement modelNumberInReviewClaimPage;

    @FindBy(xpath = "//div[@id='ui2_right_content']//tbody//tr//td//b[contains(text(),'Customer HTW:')]")
    private WebElement customerHappyToWaitField;

    @FindBy(xpath = "//div[@id='ui2_right_content']//tbody//tr//td//button[@class='btnStandardInsert'][contains(text(),'Edit')]")
    private WebElement customerHappyToWaitEditButton;

    @FindBy(xpath = "//div[@id='cboxLoadedContent']//form//h2[contains(.,\"Customer Happy To Wait\")]")
    private WebElement customerHappyToWaitPopUp;

    @FindBy(xpath = "//div[@id='cboxContent']/div[@id='cboxLoadedContent']/form/p//input[@value=\"Yes\"]")
    private WebElement customerHappyToWaitYesRadioButton;

    @FindBy(xpath = "//div[@id='cboxLoadedContent']//form//a[@class='btnStandard'][contains(text(),'Save')]")
    private WebElement customerHappyToWaitSaveButton;

    @FindBy(xpath = "//form//div[@id='HTWEndDateDiv']//p[@id='HTWEndDateP']//input[@id='HTWEndDate']")
    private WebElement customerHappyToWaitDateInputField;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//span[contains(@class,'ui-icon ui-icon-circle-triangle-e')]")
    private WebElement customerHappyToWaitCalendarNextMonthButton;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[2]/a")
    private WebElement customerHappyToWaitCalendarNextMonthDateSelection;

    @FindBy(xpath = "//div[@id='ui2_right_content']//tbody//tr//td[contains(text(),'Yes')]")
    private WebElement customerHappyToWaitFlagInReviewClaimPage;

    @FindBy(xpath = "//div[@id='ui2_top_summary']//span[@id='ClaimTypenameid']")
    private WebElement claimTypeNameIdInReviewClaimPage;

    @FindBy(xpath = "//b[text()='Plan Number:']//following::a")
    private WebElement  planNoLink;

    @FindBy(xpath ="//div[@id='nav_BookingOverview']")
    private WebElement  bookingOverviewTab;

    @FindBy(xpath ="//b[text()='Repairer Reference:']//following::td")
    private WebElement repairerReferenceNo;

    @FindBy(xpath = "//div[@id='modP']")
    private WebElement alertPopup;

    @FindBy(xpath = "//div[@id='modP']//following-sibling::div//button[text()='OK']")
    private WebElement closeAlertPopup;

    @FindBy(xpath = "//button[contains(.,'Continue')]")
    private WebElement clickContinue;

    @FindBy(xpath = "//table[@id=\"ContactHistory\"]//td[text()='${value}']//following-sibling::td")
    private WebElement systemNote;

    private final String systemNoteDynamicXpath = "//table[@id='ContactHistory']//td[text()='${value}']//following-sibling::td";

    @FindBy(xpath = "//table[@id=\"ContactHistory\"]//td[text()='Import Repair Status']//following-sibling::td")
    private WebElement estimateNotes;

    @FindBy(xpath = "//div[@id='nav_RequestAuthorisation']//i")
    private WebElement repairAuthorityTab;


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

    public boolean isClaimOnHoldInRAHistoryTab() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(claimOnHoldRAStatus)) {
                base.highlightElement(claimOnHoldRAStatus);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(claimOnHoldRAStatus)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(claimOnHoldRAStatus)) {
                    base.highlightElement(claimOnHoldRAStatus);
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
                for (int i = 0; i <= 3; i++) {
                    if (base.checkIfELementIsAvailable(customerCommsEmailAndSms) && customerCommsEmailAndSms.isDisplayed()) {
                        base.highlightElement(customerCommsEmailAndSms);
                        status = true;
                        break;
                    } else {
                        base.hardWait("10000");
                    }
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

    public boolean isReviewClaimJobStatusDisplayed(String jobStatusFinal, String additionalJobStatusCheck) {
        boolean status = false;
        base.waitTillElementFound(jobStatusVerify);
        base.waitForPageToLoad();
        if (jobStatusVerify.getText().contains(jobStatusFinal)) {
            base.highlightElement(jobStatusVerify);
            status = true;
        } else if (!additionalJobStatusCheck.isEmpty() && jobStatusVerify.getText().contains(additionalJobStatusCheck)) {  // to handle if the status is changed on the orbit config in UAT
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
            base.isClickable(menuButton);
            base.clickElement(menuButton);

        }
    }

    public void clickDandGLogo() {
        try {
            Thread.sleep(5000);
            base.waitTillElementFound(DGLOGO);
            base.clickWithJsExecutor(DGLOGO);
            LOGGER.info("==============>>>>>> Clicked Domestic & General Logo .");
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
                if (base.checkIfELementIsAvailable(currentDiaryAppointmentStatus) && currentDiaryAppointmentStatus.isDisplayed() && currentDiaryAppointmentStatus.getText().equals(stat)) {
                    base.highlightElementWithScreenshot(currentDiaryAppointmentStatus, "DAAppointmentStatus_" + stat);
                    status = true;
                } else {
                    base.waitToLoadElement();
                    base.waitForElementVisible(currentDiaryAppointmentStatus);
                    if (base.checkIfELementIsAvailable(currentDiaryAppointmentStatus) && currentDiaryAppointmentStatus.isDisplayed() && currentDiaryAppointmentStatus.getText().equals(stat.toString())) {
                        base.highlightElementWithScreenshot(currentDiaryAppointmentStatus, "DAAppointmentStatus_" + stat);
                        status = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to verify DA Appointment");
        }
        return status;
    }

    public void processWrittenOff(String writtenOffStatus) {
        base.hardWait("1000");
        base.clickElement(RAStatusOverrideCheckbox);
        base.hardWait("2000");
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

        if (base.checkIfELementIsAvailable(alertPopup) && base.waitForElementVisible(alertPopup))
            base.clickWithJsExecutor(closeAlertPopup);

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

//    public boolean isReciperoViewButtonEnabled(){
//        boolean status = false;
//        try{
//
//            if(reciperoViewButton.isDisplayed()){
//                status = true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//    }

    public boolean isServiceProviderNameDisplayed(String spName) {
        boolean status = false;
        try {
            if (isReviewClaimJobStatusDisplayed()) {
                base.checkIfELementIsAvailable(serviceProviderName);
                if (serviceProviderName.getText().contains(spName)) {
                    base.highlightElement(serviceProviderName);
                    status = true;
                }
            } else {
                LOGGER.info("==============>>>>>> Unable to verify the Review Claim Page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isServiceProviderJobisDifferentFromClaimNo() {
        boolean status = false;
        try {
            if (isReviewClaimJobStatusDisplayed()) {
                if (base.checkIfELementIsAvailable(serviceProviderJobNo) && base.checkIfELementIsAvailable(orbitCurrentClaimNumber)) {
                    if (!serviceProviderJobNo.getText().contains(orbitCurrentClaimNumber.getText())) {
                        base.highlightElement(serviceProviderJobNo);
                        base.highlightElement(orbitCurrentClaimNumber);
                        status = true;
                    }
                }
            } else {
                LOGGER.info("==============>>>>>> Unable to verify the Review Claim Page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private boolean isReciperoViewButtonEnabled() {
        boolean status = false;
        WebElement reciperoView = null;
        try {
            reciperoView = base.getElementFromXpath(reciperoViewButtonXpath);
            if (reciperoView != null && reciperoView.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickReciperoViewIcon() {
        try {
            if (isReciperoViewButtonEnabled() && reciperoViewButton != null && reciperoViewButton.isDisplayed() && base.isClickable(reciperoViewButton)) {
                base.clickElement(reciperoViewButton);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Manish Kumar Jain
    Date: 17th Nov
    Scenario: Rebooking and Reselection scenario for Whirlpool plans.
     */

    public boolean clickOnDiaryAppointmentArrow() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(enableDiaryAppointmentSection)) {
                base.highlightElementWithScreenshot(enableDiaryAppointmentSection, "Click on Dairy Appointment Arrow");
                base.clickWithJsExecutor(enableDiaryAppointmentSection);
                status = true;
            } else {
                base.waitToLoadElement();
                base.waitForElementVisible(enableDiaryAppointmentSection);
                if (base.checkIfELementIsAvailable(enableDiaryAppointmentSection) & enableDiaryAppointmentSection.isDisplayed()) {
                    base.highlightElementWithScreenshot(enableDiaryAppointmentSection, "Click on Dairy Appointment Arrow");
                    base.clickWithJsExecutor(enableDiaryAppointmentSection);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on DA Appointment");
        }
        return status;
    }

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

    //To click on Start Appointment Search button and verify calendar section is showing to Rebook an appointment
    public void clickOnStartAppointmentSearchFindNewAppointmentPopUpAndVerifyCalendarToRebook() {
        try {
            if (base.checkIfELementIsAvailable(FindNewAppointmentPopUpDisplay) && FindNewAppointmentPopUpDisplay.isDisplayed()) {
                if (base.checkIfELementIsAvailable(findNewAppointment_StartAppointmentSearchButton) && findNewAppointment_StartAppointmentSearchButton.isEnabled()) {
                    base.clickWithJsExecutor(findNewAppointment_StartAppointmentSearchButton);
                    Thread.sleep(2000);
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability)) {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
                        Thread.sleep(3000);
                    } else {
                        base.waitForElementAndReturnJS(rebookCalendarAvailability);
                        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
                        Thread.sleep(3000);
                    }
                } else {
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability)) {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
                        Thread.sleep(3000);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on Start Appointment Search button and not able to select date from calendar");
        }
    }


    public void clickOnFindNewAppointmentStartAppointmentSearchAndVerifyPopUp() {
        try {
            if (base.checkIfELementIsAvailable(findNewAppointmentButton)) {
                base.highlightElementWithScreenshot(findNewAppointmentButton, "Click on Find New Appointment button");
                base.clickWithJsExecutor(findNewAppointmentButton);

            } else {
                base.waitToLoadElement();
                base.waitForElementVisible(findNewAppointmentButton);
                if (base.checkIfELementIsAvailable(findNewAppointmentButton) & findNewAppointmentButton.isDisplayed()) {
                    base.highlightElementWithScreenshot(findNewAppointmentButton, "Click on Find New Appointment button");
                }
            }
            Thread.sleep(3000);
            if (base.checkIfELementIsAvailable(FindNewAppointmentPopUpDisplay) && FindNewAppointmentPopUpDisplay.isDisplayed()) {
                if (base.checkIfELementIsAvailable(findNewAppointment_StartAppointmentSearchButton)) {
                    base.clickWithJsExecutor(findNewAppointment_StartAppointmentSearchButton);
                    Thread.sleep(3000);
                } else {
                    base.waitForElementVisible(findNewAppointment_StartAppointmentSearchButton);
                    base.clickWithJsExecutor(findNewAppointment_StartAppointmentSearchButton);
                }
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on DA Appointment & Start Appointment Search button");
        }

    }


    public void selectFifthAvailableAppointmentDateAndConfirmRebookButton() throws InterruptedException {
        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
        base.clickWithJsExecutor(findNewAppointment_FifthAvailableDate);
        Thread.sleep(3000);
        base.checkIfELementIsAvailable(findNewAppointment_confirmRebookingButton);
        base.highlightElement(findNewAppointment_confirmRebookingButton);
        base.clickWithJsExecutor(findNewAppointment_confirmRebookingButton);
        Thread.sleep(3000);
    }

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

    public boolean claimJobStatusDisplayedAfterRebooked(String claimJobStatus) {
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains(claimJobStatus)) {
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

    public void verifyAppointmentOutcomeStatusAfterRebooked(String appointmentstatus) throws InterruptedException {
        String before_xpath = "//*[@id='AppointmentsDT_wrapper']/table[@id='AppointmentsDT']/tbody[contains(@role,'alert')]/tr[";
        String after_xpath = "]/td[7]";
        String ApptCompletionStatus = "";

        //Find a total no of columns in a web table.
        List<WebElement> columns = driver.findElements(By.xpath("//div[@id='AppointmentsDT_wrapper']/table/thead/tr/th"));
        int columnCount = columns.size();
        LOGGER.info("No of columns in a table : " + columnCount);

        //Find a total no of rows in a web table.
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='AppointmentsDT_wrapper']/table/tbody/tr/td[1]"));
        int rowCount = rows.size();
        LOGGER.info("No of rows in a table : " + rowCount);

        String columnNull = driver.findElement(By.xpath(before_xpath + rowCount + after_xpath)).getText();
        if (columnNull == ApptCompletionStatus) {
            LOGGER.info("Appointment completion status is ---> " + columnNull + " which means appointment rebooked successfully");
        }

        for (int i = rowCount - 1; i >= 1; i--) {
            String status = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
            LOGGER.info("Appointment Completion Status is: " + status);
            if (status.equalsIgnoreCase(appointmentstatus)) {
                LOGGER.info("Appointment Completion Status updated successfully after rebooking an appointment");
            }
            break;
        }
    }

    public void clickOnSearchOtherServiceProviderButtonAndSelectAvailableDate() throws InterruptedException {
        if (base.waitForElementVisible(findNewAppointment_searchOtherServicepPoviderButton) & findNewAppointment_searchOtherServicepPoviderButton.isEnabled()) {
            base.isElementAvailable(findNewAppointment_searchOtherServicepPoviderButton);
            base.highlightElement(findNewAppointment_searchOtherServicepPoviderButton);
            base.clickWithJsExecutor(findNewAppointment_searchOtherServicepPoviderButton);
            Thread.sleep(2000);
            if(base.checkIfELementIsAvailable(apptReselectErrorPopup))
                base.clickElement(continueButton);
            Thread.sleep(2000);
            if (base.waitForElementVisible(findNewAppointment_fieldCallCalendarNinthDayAvailability) & base.checkIfELementIsAvailable(findNewAppointment_fieldCallCalendarNinthDayAvailability)) {
                base.isElementAvailable(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.highlightElement(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.clickWithJsExecutor(findNewAppointment_fieldCallCalendarNinthDayAvailability);
            }
        } else {
            System.out.println("Search other Service provider button is disabled");
            if (base.waitForElementVisible(findNewAppointment_fieldCallCalendarNinthDayAvailability) & base.checkIfELementIsAvailable(findNewAppointment_fieldCallCalendarNinthDayAvailability)) {
                base.isElementAvailable(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.highlightElement(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.clickWithJsExecutor(findNewAppointment_fieldCallCalendarNinthDayAvailability);
            }
        }

    }

    public void selectAvailableServiceProviderRadioButtonAndClickOnRebookButton() throws InterruptedException {
        if (base.waitForElementVisible(findNewAppointment_availableServiceProviderRadioButton) && base.checkIfELementIsAvailable(findNewAppointment_availableServiceProviderRadioButton)) {
            base.isElementAvailable(findNewAppointment_availableServiceProviderRadioButton);
            base.highlightElement(findNewAppointment_availableServiceProviderRadioButton);
            base.clickWithJsExecutor(findNewAppointment_availableServiceProviderRadioButton);
        }
        if (base.waitForElementVisible(findNewAppointment_rebookButtonForReselectionSP) && base.checkIfELementIsAvailable(findNewAppointment_rebookButtonForReselectionSP)) {
            base.isElementAvailable(findNewAppointment_rebookButtonForReselectionSP);
            base.highlightElement(findNewAppointment_rebookButtonForReselectionSP);
            base.clickWithJsExecutor(findNewAppointment_rebookButtonForReselectionSP);
        }
        Thread.sleep(3000);
    }

    public void verifyAlertPopUpAndClickOnYesButton() throws InterruptedException {
        if (base.waitForElementVisible(reselect_confirmationAlertPopUpBox) && base.checkIfELementIsAvailable(findNewAppointment_alertPopUpText)) {
            base.highlightElement(findNewAppointment_confirmationAlertPopUpYes);
            base.clickWithJsExecutor(findNewAppointment_confirmationAlertPopUpYes);
            Thread.sleep(3000);
        } else {
            base.waitToLoadElement();
            base.isElementAvailable(findNewAppointment_confirmationAlertPopUpYes);
            base.highlightElement(findNewAppointment_confirmationAlertPopUpYes);
            base.clickWithJsExecutor(findNewAppointment_confirmationAlertPopUpYes);
        }
    }

    public boolean verifyNewServiceProviderNameInReviewClaimAfterReselect () {
        String oldServiceProvider = "WHIRLPOOL UK APPLIANCE LTD";
        String newServiceProviderName;
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(reselect_newServiceProviderName);
        if (base.checkIfELementIsAvailable(reselect_newServiceProviderName) && base.isElementAvailable(reselect_newServiceProviderName)) {
            //newServiceProviderName = base.getElementFromXpath(oldServiceProviderNamePath).getText().toString();
            newServiceProviderName = driver.findElement(By.xpath("//span[@id='ServiceCentreAcronymSpan']")).getText().toString();
            System.out.println("New Service Provider: " + newServiceProviderName);
            if (!newServiceProviderName.equals(oldServiceProvider)) {
                System.out.println("New Service Provider" + newServiceProviderName + "selected successfully after reselect an appointment");
                base.highlightElement(reselect_newServiceProviderName);
                status = true;
            } else {
                System.out.println("New Service Provider" + newServiceProviderName + " not selected and updated successfully after reselect an appointment");
                base.highlightElement(reselect_newServiceProviderName);
                status = false;
            }
        }
        return status;
    }

    public boolean claimJobStatusDisplayedAfterReselectServiceProvider (String reselectjobstatus){
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
    Scenario Name: Verify that the new claim ID created and compared with the old ClaimID "<ClaimNo>"
     */
    public void oldClaimIdComparedWithNewClaimId (String claimNo){
        if (base.waitForElementVisible(reviewClaimPage_claimSection) && base.checkIfELementIsAvailable(reviewClaimPage_claimNo)) {
            String claimNewNo = base.getElementFromXpath(claimNumberPath).getText();
            System.out.println("New Claim ID is " + claimNewNo);
            if (claimNewNo != claimNo)
                System.out.println("New Claim ID created with new service provider after reselection done successfully " + claimNewNo);
        }
    }

    public void clickOnDAndGLogo() {
        try {
            Thread.sleep(5000);
            base.waitTillElementFound(DAndGLogo);
            base.clickWithJsExecutor(DAndGLogo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean oldClaimJobReassignedStatus (String reviewClaimStatus){
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(jobStatus);
        if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains("JOB REASSIGNED")) {
            String oldJobStatus = driver.findElement(By.xpath(claimJobStatusPath)).getText();
            base.highlightElement(jobStatus);
            if (oldJobStatus == reviewClaimStatus) {
                System.out.println("Old claim cancelled and job status changed to Job Reassigned");
                status = true;
            }
        } else {
            System.out.println("Status not updated successfully after reselection done");
            status = false;
//            base.waitTillElementFound(jobStatusAny);
//            if (base.checkIfELementIsAvailable(jobStatusAny)) {
//                base.waitForPageToLoad();
//                base.highlightElement(jobStatusAny);
//                status = true;
        }
        return status;
    }

    public void clickOnReviewClaimTab () throws InterruptedException {
        Thread.sleep(2000);
        if (base.checkIfELementIsAvailable(reviewClaimPage_reviewClaimTab) && base.isElementAvailable(reviewClaimPage_reviewClaimTab)) {
            base.getElementByXpathJS(reviewClaimTab).click();
            Thread.sleep(2000);
        } else {
            System.out.println("Review Claim tab is not present");
        }
    }

    public boolean validateDiaryAppointmentJobReassignedStatus (String appointmentJobStatus){
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(enableDiaryAppointmentSection)) {
                base.waitForElementVisible(reviewClaimPage_appointmentStatusClaimJobReassigned);
                if (base.checkIfELementIsAvailable(reviewClaimPage_appointmentStatusClaimJobReassigned) & reviewClaimPage_appointmentStatusClaimJobReassigned.isDisplayed() && reviewClaimPage_appointmentStatusClaimJobReassigned.equals(appointmentJobStatus)) {
                    base.highlightElementWithScreenshot(reviewClaimPage_appointmentStatusClaimJobReassigned, "DAAppointmentStatus_" + appointmentJobStatus);
                    status = true;
                } else {
                    base.waitToLoadElement();
                    base.waitForElementVisible(reviewClaimPage_appointmentStatusClaimJobReassigned);
                    if (base.checkIfELementIsAvailable(reviewClaimPage_appointmentStatusClaimJobReassigned) & reviewClaimPage_appointmentStatusClaimJobReassigned.isDisplayed() && reviewClaimPage_appointmentStatusClaimJobReassigned.getText().equals(appointmentJobStatus.toString())) {
                        base.highlightElementWithScreenshot(reviewClaimPage_appointmentStatusClaimJobReassigned, "DAAppointmentStatus_" + appointmentJobStatus);
                        status = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to verify DA Appointment status after reselect Service provider");
        }
        return status;
    }


    //If we select radio button for specific appointment then below code need to use
    public void specificSlotSelection () {
        base.waitForElementVisible(findNewAppointment_preferredDateDisplay);
        base.checkIfELementIsAvailable(findNewAppointment_preferredDateDisplay);
        String preDate = base.getElementFromXpath(preferredDateForSpecificSlot).getText().toString();
        if (preDate.length() >= 2) {
            int specificDate = Integer.parseInt(preDate.substring(0, 2));
        } else {
            LOGGER.info("Date not selected for specific timeslot");
        }

    }

    public boolean isRACurrentJobStatusDisplayed (String jobStatus){
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(raCurrentStatus);
        try {
            if (base.checkIfELementIsAvailable(raCurrentStatus) && raCurrentStatus.getText().toUpperCase().contains(jobStatus.toUpperCase())) {
                base.highlightElement(raCurrentStatus);
                status = true;
            } else {
                base.waitTillElementFound(raCurrentStatus);
                if (base.checkIfELementIsAvailable(raCurrentStatus) && raCurrentStatus.getText().toUpperCase().contains(jobStatus.toUpperCase())) {
                    base.highlightElement(raCurrentStatus);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean repairPausedPopUpBeingDisplayed () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(repairPausedPopUp) && repairPausedPopUp.getText().equalsIgnoreCase(REPAIR_PAUSED_POPUP)) {
                Thread.sleep(5000);
                base.highlightElement(repairPausedPopUp);
                status = true;
            } else {
                LOGGER.error("Unable to Verify Repair Paused pop-up being displayed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean clickOnTheCloseButton () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(closeButton) && closeButton.getText().equalsIgnoreCase(CLOSE)) {
                Thread.sleep(3000);
                base.highlightElement(closeButton);
                closeButton.click();
                status = true;
            } else {
                LOGGER.error("Unable to Click on the Close button");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean clickOnTheClickhereLink() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(clickhereLink) && clickhereLink.getText().equalsIgnoreCase(CLICK_HERE)) {
                Thread.sleep(3000);
                base.highlightElement(clickhereLink);
                clickhereLink.click();
                status = true;
            } else {
                LOGGER.error("Unable to Click on the clickhere link");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean repairPausedToasterMessageBeingDisplayed () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(repairPausedToasterMessage) && repairPausedToasterMessage.getText().equalsIgnoreCase(REPAIR_PAUSED_TOASTER_MESSAGE)) {
                base.waitForElementVisible(repairPausedToasterMessage);
                Thread.sleep(3000);
                base.highlightElement(repairPausedToasterMessage);
                status = true;

            } else {
                LOGGER.error("Unable to Verify Repair Paused Toaster Message being displayed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean modelNumberMatchedInReviewClaimPage (String modelNum){
        boolean status = false;
        String modelNumber = modelNumberInReviewClaimPage.getText();
        try {
            if (modelNumber.contains(modelNum)) {
                base.highlightElement(modelNumberInReviewClaimPage);
                LOGGER.info(("WHPL MB model number displayed correctly in Claim review page : " + modelNumber));
                status = true;
            } else {
                base.waitForElementVisible(modelNumberInReviewClaimPage);
                base.highlightElement(modelNumberInReviewClaimPage);
                LOGGER.info(("\"WHPL MB model number displayed correctly in Claim review page :" + modelNumber));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*
    Manish Kumar Jain
    Scenario: Happy to Wait change part of R53
    Steps: HTW field is present in Booking overview
     */
    public boolean verifyHappyToWaitFieldInBookingOverviewDisplayed () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(customerHappyToWaitField)) {
                base.highlightElement(customerHappyToWaitField);
                LOGGER.info("Customer Happy to Wait field is present in Booking Overview");
                status = true;
            } else {
                base.waitForElementVisible(customerHappyToWaitField);
                base.highlightElement(customerHappyToWaitField);
                LOGGER.info("Customer Happy to Wait field is present in Booking Overview");
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*
    Manish Kumar Jain
    Scenario: Happy to Wait change part of R53
    Steps: HTW button is present in Booking overview and clickable
     */
    public boolean verifyHappyToWaitButtonInBookingOverviewAndClickable () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(customerHappyToWaitEditButton) && customerHappyToWaitEditButton.isEnabled()) {
                base.highlightElement(customerHappyToWaitEditButton);
                LOGGER.info("Customer Happy to Wait button is present in Booking Overview");
                base.clickWithJsExecutor(customerHappyToWaitEditButton);
                status = true;
            } else {
                base.waitForElementVisible(customerHappyToWaitEditButton);
                base.highlightElement(customerHappyToWaitEditButton);
                LOGGER.info("Customer Happy to Wait button is present in Booking Overview");
                base.clickWithJsExecutor(customerHappyToWaitEditButton);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*
    Manish Kumar Jain
    Scenario: Happy to Wait change part of R53
    Steps: Customer HTW pop up launched
     */
    public boolean verifyCustomerHappyToWaitPopUpDisplayed () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(customerHappyToWaitPopUp) && customerHappyToWaitPopUp.isDisplayed()) {
                LOGGER.info("Customer Happy To Wait Pop Up Launched successfully");
                status = true;
            } else {
                base.waitForElementVisible(customerHappyToWaitPopUp);
                LOGGER.info("Customer Happy To Wait Pop Up Launched successfully");
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*
    Manish Kumar Jain
    Scenario: Happy to Wait change part of R53
    Steps: click on Yes button and select Customer HTW date from date picker
     */
    public void clickOnYesButtonAndSelectDateAndSave () throws InterruptedException {
        if(base.checkIfELementIsAvailable(customerHappyToWaitPopUp) && customerHappyToWaitYesRadioButton.isEnabled()) {
            LOGGER.info("Customer HTW Pop up displayed and radio button is clickable");
            base.clickWithJsExecutor(customerHappyToWaitYesRadioButton);
            Thread.sleep(2000);
            customerHappyToWaitDateInputField.click();
            base.clickWithJsExecutor(customerHappyToWaitCalendarNextMonthButton);
            Thread.sleep(2000);
            base.clickWithJsExecutor(customerHappyToWaitCalendarNextMonthDateSelection);
            Thread.sleep(3000);
            base.clickWithJsExecutor(customerHappyToWaitSaveButton);
        }

    }

    /*
    Manish Kumar Jain
    Scenario: Happy to Wait change part of R53
    Steps: Verify Customer HTW updated with Yes flag in Review Claim page
     */
    public boolean verifyHtwFlagUpdatedInReviewClaimPage ()
    {
        String HTWFlag;
        boolean status = false;
        if (base.checkIfELementIsAvailable(customerHappyToWaitField)) {
            base.highlightElement(customerHappyToWaitField);
            base.highlightElement(customerHappyToWaitFlagInReviewClaimPage);
            String HTWFlagIndicator = customerHappyToWaitFlagInReviewClaimPage.getText();
            HTWFlag = HTWFlagIndicator.substring(0, HTWFlagIndicator.length() - 31);
            LOGGER.info("Customer HTW Flag updated with : " + HTWFlag);
            if (HTWFlag.equalsIgnoreCase("YES")) {
                LOGGER.info("CCA successfully updated the HTW flag for the Customer to: " + HTWFlag);
                status = true;
            }
        }
        return status;
    }

    public boolean verifyClaimTypeNameIdInReviewClaimPage (String claimType){
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(claimTypeNameIdInReviewClaimPage)) {
                base.highlightElement(claimTypeNameIdInReviewClaimPage);
                String claimTypeName = claimTypeNameIdInReviewClaimPage.getText();
                if (claimTypeName.equalsIgnoreCase(claimType)) {
                    LOGGER.info(("claim created successfully with new claim type: " + claimTypeName));
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOnPlanNoLink() {
        try {
            if (base.checkIfELementIsAvailable(planNoLink)) {
                base.highlightElement(planNoLink);
                base.clickElement(planNoLink);
                base.waitForPageToLoad();
                base.switchToNextTab();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void compareOldClaimIdWithNewClaimId (String claimNo){
        if (base.waitForElementVisible(bookingOverviewTab)) {
            String claimNewNo = repairerReferenceNo.getText();
            System.out.println("New Claim ID is " + claimNewNo);
            if (claimNewNo != claimNo)
                System.out.println("New Claim ID created with new service provider after reselection done successfully " + claimNewNo);
        }
    }

    public void clickOnStartAppointmentSearchFindNewAppointmentPopUpAndVerifyCalendarToRebookForBeko() {
        try {
            base.clickElement(clickContinue);
            if (base.checkIfELementIsAvailable(FindNewAppointmentPopUpDisplay) && FindNewAppointmentPopUpDisplay.isDisplayed()) {
                if (base.checkIfELementIsAvailable(findNewAppointment_StartAppointmentSearchButton) && findNewAppointment_StartAppointmentSearchButton.isEnabled()) {
                    base.clickWithJsExecutor(findNewAppointment_StartAppointmentSearchButton);
                    Thread.sleep(2000);
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability)) {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
                        Thread.sleep(3000);
                    } else {
                        base.waitForElementAndReturnJS(rebookCalendarAvailability);
                        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
                        Thread.sleep(3000);
                    }
                } else {
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability)) {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_FifthAvailableDate);
                        Thread.sleep(3000);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on Start Appointment Search button and not able to select date from calendar");
        }
    }


    public boolean verifySystemNoteWithTypeAs(String noteType, String note) {
        boolean status = false;
        WebElement systemNoteDynamic= seleniumHelper.getCustomElementByXpath(systemNoteDynamicXpath, noteType);
        try {
            if (base.checkIfELementIsAvailable(systemNoteDynamic)) {
                base.highlightElement(systemNoteDynamic);
                System.out.println("note:"+systemNoteDynamic.getText());
                if (systemNoteDynamic.getText().contains(note)) {
                    status = true;
                }
            } else {
                LOGGER.info("System note is not updated as" +note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickRepairAuthority() throws InterruptedException {
        if (base.checkIfELementIsAvailable(repairAuthorityTab)) {
            base.clickWithJsExecutor(repairAuthorityTab);
            Thread.sleep(3000);
        }
        Assert.assertTrue("Repair Authority Page not loaded", repairAuthorityTab.isDisplayed());
        Thread.sleep(2000);
    }
}


