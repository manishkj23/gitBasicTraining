package com.test.pages.RepairerPortal;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RepairerJobUpdate {
    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr/td[7][string-length(text()) = 0]")
    private WebElement diaryAppointment;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr/td[7][string-length(text()) = 0]")
    private WebElement openDiaryAppointment;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr[1]/td[3]")
    private WebElement firstDiaryAppointmentDate;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT_wrapper\"]//span[contains(.,\"Complete\")]")
    private WebElement diaryAppointmentCompleteButtom;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT_wrapper\"]//span[contains(.,\"Insert\")]")
    private WebElement diaryAppointmentInsertButton;

    @FindBy(xpath = "//div[@id=\"topBreadcrumb\"]//*[@id=\"jobUpdateBreadcrumb\"]")
    private WebElement jobUpdatePageTitle;

    @FindBy(xpath = "//*[@id=\"matches_table\"]/tbody/tr[1]/td[1]")
    private WebElement activeClaim;

    @FindBy(xpath = "//div[@class='DTTT_container']//span[contains(.,'View Job Details')]")
    private WebElement viewJobButton;

    @FindBy(xpath = "//*[@id=\"AppointmentOutcome\"]")
    private WebElement selectOutcomeOfAppointment;

    @FindBy(xpath = "//*[@id=\"engArrivalTime\"]")
    private WebElement enterArrivalTime;

    @FindBy(xpath = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-hours']//td[contains(.,'08')]")
    private WebElement timeArrivedHours;

    @FindBy(xpath = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-minutes']//td[contains(.,'10')]")
    private WebElement timeArrivedMins;

    @FindBy(xpath = "//div[@role='dialog']//button[contains(.,'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"ServiceReport\"]")
    private WebElement serviceReportText;

    @FindBy(xpath = "//*[@id=\"engineerName\"]")
    private WebElement engineerName;

    @FindBy(xpath = "//*[@id=\"dgdamtp\"][contains(@onclick,'Partial Breakdown')]")
    private WebElement partialBreakdownRadiobutton;

    @FindBy(xpath = "//img[contains(@onclick,'serialChange')]")
    private WebElement serialNumberChange;

    @FindBy(xpath = "//*[@id=\"ppf_SerialNo\"]")
    private WebElement serialNumber;

    @FindBy(xpath = "//*[@id=\"ppf_SerialUpdateReason\"]")
    private WebElement serialUpdateReason;

    @FindBy(xpath = "//*[@id=\"popUpModelUpdateForm\"]//button[contains(.,'Finish')]")
    private WebElement serialUpdateFinishBtn;

    private static final String createEstimateButtonPath = "//button[@class=\"btnStandard createEstimateButton\"]";
    @FindBy(xpath = createEstimateButtonPath)
    private WebElement createEstimateButton;

    //@FindBy(xpath = "//div[@role='dialog']//button[contains(.,'Proceed')]")
    @FindBy(xpath = "//div[@role='dialog']//div[@class='ui-dialog-buttonset']//button[contains(text(),'Proceed')]")
    private WebElement poppupToProceed;

    private static final String labourChargeSectionBPath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[1]/select";
    @FindBy(xpath = labourChargeSectionBPath)
    private WebElement labourChargeSectionB;

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[2]/select")
    private WebElement labourChanrgeFaultCode;

    @FindBy(xpath = "//a[contains(.,'Add Adjustment')]")
    private WebElement addAdjustmentButton;

    @FindBy(xpath = "//a[contains(.,'Add Part')]")
    private WebElement addPartButton;

    @FindBy(xpath = "//input[contains(@id,\"lite_part_desc\")][@type=\"text\"][contains(@onblur,\"PartDescription\")]")
    private WebElement addPart_Description;

    @FindBy(xpath = "//input[contains(@id,\"lite_part_no_\")][@type=\"text\"][contains(@onblur,\"PartNo\")]")
    private WebElement addPart_PartNo;

    @FindBy(xpath = "//select[contains(@id,\"PartStatus_\")]")
    private WebElement addPart_PartStatus;

    @FindBy(xpath = "//select[contains(@id,\"DgPartFaultCodeID_\")]")
    private WebElement addPart_FaultCode;

    @FindBy(xpath = "//div[@class = \"PartPNLAType\"]/select")
    private WebElement addPart_PNLAPartDescription;

    @FindBy(xpath = "//table[@id='LitePartsTable']//tr[td//input[contains(@value,'ADJUSTMENT ONLY')][@type='text']]//td[3]/div/select[@name='DgPartFaultCodeID']")
    private WebElement addAdjustmentFaultCode;

    @FindBy(xpath = "//button[contains(.,'Unrepairable')]")
    private WebElement buttonUnrepairable;

    @FindBy(xpath = "//button[contains(.,'Non Viable Repair')]")
    private WebElement buttonPartsETAWrittenOff;

    @FindBy(xpath = "//div[@role=\"dialog\"][//div[contains(.,\"Parts ETA\")]]//button[contains(.,\"Yes\")]")
    private WebElement partsETAConfirmationPopup_Yes_Button;


    @FindBy(xpath = "//*[@id=\"nvpChkAll\"]")
    private WebElement selectPartsForPartETA_Popup_Checkbox;

    @FindBy(xpath = "//*[@id=\"nvPartsSubmit\"]")
    private WebElement partsETA_patsSelection_SubmitButton;

    @FindBy(xpath = "//button[contains(.,'Lock Estimate')]")
    private WebElement lockEstimateButton;

    @FindBy(xpath = "//div[@role='dialog']//button[contains(.,'Continue')]")
    private WebElement lockEstimateWarningContinueBtn;

    @FindBy(xpath = "//div[@role='dialog']//button[contains(.,'Proceed')]")
    private WebElement estimateAcceptedProceedButton;

    @FindBy(xpath = "//button[contains(.,'Estimate Revision')]")
    private WebElement estimateRevisionButton;

    @FindBy(xpath = "//div[@role='dialog'][//span[contains(.,\"Appliance Written Off\")]]//button[contains(.,'Proceed')]")
    private WebElement applicationWrittenOffProceedButton;

    @FindBy(xpath = "//form[@id='raJobsForm']//span[@id=\"JobStatusText\"]")
    private WebElement RAJobStatus;

    @FindBy(xpath = "//*[@id=\"completeJobBut\"]")
    private WebElement completeJobButton;

    @FindBy(xpath = "//*[@id=\"completionForm\"]/div/div[1]/div[1]/span[2]/a/span[1]")
    private WebElement serviceCategoryStatusDropdown;

    @FindBy(xpath = "//*[@id=\"completionForm\"]/div/div[1]/div[2]/span[2]/a/span[1]")
    private WebElement completionStatusDropdown;

    @FindBy(xpath = "//*[@id=\"jobCompleteBtn\"]/a")
    private WebElement confirmJobCompletionBtn;

    @FindBy(xpath = "//div[@role='dialog']//button[contains(.,'No')]")
    private WebElement eInvoiceRequiredNo;

    @FindBy(xpath = "//*[@id=\"JobStatusText\"]/b")
    private WebElement jobCompletedStatusText;

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//span[substring-after(.,'(')][substring-before(.,')')]/text()")
    private WebElement firstAppointmentBookedTime;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr[1]/td[3]")
    private WebElement firstAppointmentDate;

    @FindBy(xpath = "//*[@id=\"AppointmentsCount\"]/text()")
    private WebElement totalAppointments;

    @FindBy(xpath = "//*[@id=\"ToolTables_AppointmentsDT_0\"]/span")
    private WebElement insertButton;

    @FindBy(xpath = "//table[@id=\"AppointmentsDT\"]/tbody/tr/td[contains(.,'No data available in table')]")
    private WebElement zeroAppointmentsExist;

    //    @FindBy(xpath = "//*[@id=\"mainAppointmentCalendarTable\"]//tr/td[contains(@class,'dayAvailable')][1]")
    @FindBy(xpath = "//div[@id='availabilityOuter']//div[@id='availabilityHolder']//div[@id='0_0']")
    private WebElement firstAvailableDate;

    @FindBy(xpath = "//*[@id=\"mainAppointmentCalendarTable\"]//tr/td[contains(@class,'dayAvailable')][2]")
    private WebElement nextAvailableDateForCC;

    //    @FindBy(xpath = "//button[@id=\"juBookJobAppB3\"][contains(.,'Book Appointment')]")
    @FindBy(xpath = "//div[@id='daySummary']//button[@onclick=\"bookAppointment('keepSlot');\"]")
    private WebElement bookAppointmentButton;

    private final static String repairerJobStatusCompletedPath = "//*[@id=\"JobStatusText\"][contains(.,\"REPAIR COMPLETED\")]";
    @FindBy(xpath = repairerJobStatusCompletedPath)
    private WebElement repairerJobStatusCompleted;

    @FindBy(xpath = "//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[2]/table/tbody//a")
    private List<WebElement> engineerArrivalTimeMinutesArray;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tbody/tr[last()]/td[7]")
    private WebElement currentAppointmentStatus;


    @FindBy(xpath = "//div[@class=\"partDdEtaN\"]//img[@class=\"ui-datepicker-trigger\"]")
    private WebElement partETA_dateIcon;

    // Status Change :
    @FindBy(xpath = "//table[@id=\"StatusChanges\"]/tbody/tr[1]")
    private WebElement statusChangesExist;

    @FindBy(xpath = "//table[@id=\"RAHistory\"]/tbody/tr[1]")
    private WebElement RAHistory;

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

    @FindBy(xpath = "//*[@id=\"IssueReportID\"]")
    private WebElement reportedFault;

    // ServiceCost
    @FindBy(xpath = "//*[@id=\"PaymentDue\"]/span[@class=\"fieldValue\"]")
    private WebElement serviceCostPaymentDue;

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]//select[@name=\"JobFaultCodeLookupID\"][@fc=\"206\"]/option[@selected=\"selected\"]")
    private WebElement labourBfaultCodeSelected;

    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]//select[@name=\"JobFaultCodeLookupID\"][@fc=\"207\"]/option[@selected=\"selected\"]")
    private WebElement labourEfaultCodeSelected;

    // Customer Communication :
    @FindBy(xpath = "//table[@id=\"CustomerCommunicationTable\"]/tbody/tr[1]")
    private WebElement customerCommsExist;

    private final String partETA_DatePickerXpath = "//table[@class=\"ui-datepicker-calendar\"]//a[contains(.,\"${value}\")]";

    //No Appointment booked pop up
    private final String noAppointmentBookedPopUpPath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Default']";
    @FindBy(xpath = noAppointmentBookedPopUpPath)
    private WebElement noAppointmentBookedPopUp;

    private final String noAppointmentBookedPopUpCloseButtonPath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'Close')]";
    @FindBy(xpath = noAppointmentBookedPopUpCloseButtonPath)
    private WebElement noAppointmentBookedPopUpCloseButton;

    private final String netCostAmountForHotpointPlanPath = "//div[@class='edit_labour_net']//input[@id='labour_net_0']";
    @FindBy(xpath = netCostAmountForHotpointPlanPath)
    private WebElement netCostAmountForHotpointPlan;


    private static final String pathForTotalAppointments = "//*[@id=\"AppointmentsCount\"]/text()";
    private static final String xPathForTimeHours = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-hours']//td[contains(.,'$(input)')]";
    private static final String xPathForTimeMins = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-minutes']//td[contains(.,'$(input)')]";
    private static final String xPathForTimeMinsAll = "//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[2]/table/tbody//a/text()";
    private static final String visitComplete = "Callout / Visit Complete";
    private static final String partsNeeded = "Parts Needed";

    private static final String serviceCategoryDropdownPath = "//input[@class='ui-state-default ui-combobox-input combodgServiceCategory-input text ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']";
    @FindBy(xpath = serviceCategoryDropdownPath)
    private WebElement serviceCategoryDropdown;

    private static final String completionStatusDropdownPath = "//input[@class='ui-state-default ui-combobox-input combodgCompletionStatus-input text ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']";
    @FindBy(xpath = completionStatusDropdownPath)
    private WebElement completionStatusDropdownText;

    @FindBy(xpath = "//div[@id=\"AttachmentsTable_wrapper\"]//span[contains(.,\"Insert\")]")
    private WebElement attachmentInsertBtn;

    @FindBy(xpath = "//table[@id=\"AttachmentsTable\"]//tbody[1][contains(.,\"SERVICE CERTIFICATE\")]")
    private WebElement uploadedAttachmentType;

    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    private AddAttachment addAttachment;


    public RepairerJobUpdate(BasePage base, SeleniumHelper seleniumHelper, AddAttachment addAttachment) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        PageFactory.initElements(driver, this);
        this.addAttachment = addAttachment;
    }

    //    public boolean isStatusChangesLoggedInRPportal(){
//
//    }
//
//    public boolean isNewRAStatusChangesLoggedInRPportal(){
//
//    }
//
//    public void addNewSystemNotes(String notes){
//
//    }
//    public boolean isSystemNotesUpdatedSuccesfully(){
//
//    }
//
//    public boolean isFaultCodeUpdatedInRPPortal(){
//
//    }
//
//    public boolean isWorkflowStatusUpdated(){
//
//    }
    public boolean isJobUpdatePageLanded() {
        boolean status = false;
        try {
            base.waitTillElementFound(jobUpdatePageTitle);
            if (jobUpdatePageTitle != null && jobUpdatePageTitle.getText().contains("Job Update")) {
                status = true;
            }
        } catch (Exception e) {
            LOGGER.error("Unable to Open the Job Update Page");
        }
        return status;
    }

    public boolean checkIfZeroAppointmentsExists() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(zeroAppointmentsExist)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }

    public void completeAppointment(String hours, String mins) throws InterruptedException {
        base.waitForElementVisible(diaryAppointment);
        base.waitForPageToLoad();
        diaryAppointment.click();
        Thread.sleep(3000);
        diaryAppointmentCompleteButtom.click();
        Thread.sleep(5000);
        base.selectTextByVisibleText(selectOutcomeOfAppointment, visitComplete);
        Thread.sleep(2000);
        enterArrivalTime.click();
        getElement(xPathForTimeHours, hours).click();
        Thread.sleep(2000);
        getElement(xPathForTimeMins, mins).click();
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);
//        serialUpdateFinishBtn.click();
    }

    public void completeAppointmentIfAppointmentSelected(String hours, String mins) throws InterruptedException {
        diaryAppointmentCompleteButtom.click();
        base.selectTextByVisibleText(selectOutcomeOfAppointment, visitComplete);
        enterArrivalTime.click();
        getElement(xPathForTimeHours, hours).click();
        getElement(xPathForTimeMins, mins).click();
        submitButton.click();


    }


    public void completeAppointmentAs(String hours, String mins, String status) {
        switch (status) {
            case "Parts Delay":
            case "Customer Request":
            case "Out Card Left - Engineer Delayed":
            case "Appointment moved forward": {
                base.clickWithJsExecutor(diaryAppointmentCompleteButtom);
                base.selectTextByVisibleText(selectOutcomeOfAppointment, status);
                base.clickWithJsExecutor(submitButton);
                break;
            }
            case "Out Card Left - Customer not available":
            case "Parts Needed":
            case "TBC Completed":
            case "Callout / Visit Complete":
            {
                base.waitForElementVisible(diaryAppointmentCompleteButtom);
                base.clickWithJsExecutor(diaryAppointmentCompleteButtom);
                base.selectTextByVisibleText(selectOutcomeOfAppointment, status);
                enterArrivalTime.click();
                getElement(xPathForTimeHours, hours).click();
                getElement(xPathForTimeMins, setEngineerArrivalMinutes()).click();
                base.clickWithJsExecutor(submitButton);
                break;
            }
            case "Remediation Work Required":
            {
                try {
                    setAddAttachment();
                    base.waitForElementVisible(diaryAppointmentCompleteButtom);
                    base.clickWithJsExecutor(diaryAppointmentCompleteButtom);
                    base.selectTextByVisibleText(selectOutcomeOfAppointment, status);
                    enterArrivalTime.click();
                    getElement(xPathForTimeHours, hours).click();
                    getElement(xPathForTimeMins, setEngineerArrivalMinutes()).click();
                    base.clickWithJsExecutor(submitButton);
                    break;
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String setEngineerArrivalMinutes() {
        String retTime = "55";
        for (WebElement arrTime : engineerArrivalTimeMinutesArray) {
            if (Integer.valueOf(seleniumHelper.getCurrentTime("mm")) <= Integer.valueOf(arrTime.getText())) {
                retTime = arrTime.getText();
                break;
            }
        }
        return retTime;
    }

    public boolean isAppointmentStatusUpdatedSuccessfully(String outCome) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(currentAppointmentStatus) && currentAppointmentStatus.getText().equals(outCome)) {
                status = true;
            } else {
                for (int i = 0; i <= 2; i++) {
                    if (base.checkIfELementIsAvailable(currentAppointmentStatus) && currentAppointmentStatus.getText().equals(outCome)) {
                        status = true;
                        break;
                    }
                    Thread.sleep(3000);
                }

            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (InterruptedException el) {
            el.printStackTrace();
        }
        return status;
    }

    public boolean isRepairerJobStatusIsCompleted() {
        boolean status = false;
        WebElement jobCompleted = null;
        try {
            jobCompleted = base.getElementFromXpath(repairerJobStatusCompletedPath);
            if (jobCompleted != null && jobCompleted.isDisplayed()) {
                base.scrollToElement(jobCompleted);
                base.highlightElement(jobCompleted);
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOpenDiaryAppointment() {
        base.waitForElementVisible(diaryAppointment);
        diaryAppointment.click();
    }

    public boolean checkIfAppointmentIsOpen(int index) {
        boolean status = false;
        try {
            String path = "//*[@id=\"AppointmentsDT\"]//tr[idx]/td[7][string-length(text()) = 0]";
            path = path.replace("idx", Integer.toString(index));
            WebElement appointment = base.getElementFromXpath(path);
            if (appointment != null) {
                base.scrollToElement(appointment);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean checkIfAppointmentIsOpen() {
        boolean status = false;
        WebElement appointment = null;
        try {
            String path = "//*[@id=\"AppointmentsDT\"]//tr/td[7][string-length(text()) = 0]";
//            path = path.replace("idx", Integer.toString(index));
            appointment = base.getElementFromXpath(path);
            if (appointment != null) {
                base.scrollToElement(appointment);
                base.highlightElement(appointment);
                status = true;
            } else if (appointment == null) {
                base.hardWait("3000");
                appointment = base.getElementFromXpath(path);
                if (appointment != null) {
                    base.scrollToElement(appointment);
                    base.highlightElement(appointment);
                    status = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean clickIfAppointmentIsOpen() {
        boolean status = false;
        try {
            String path = "//*[@id=\"AppointmentsDT\"]//tr/td[7][string-length(text()) = 0]";
//            path = path.replace("idx", Integer.toString(index));
            WebElement appointment = base.getElementFromXpath(path);
            if (appointment != null) {
                base.scrollToElement(appointment);
                base.clickWithJsExecutor(appointment);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getCurrentAppointmentStatus() {

        String status = null;
        try {
            base.refreshPage();
            base.waitForPageToLoad();
            String path = "//*[@id=\"AppointmentsDT\"]/tbody//tr[last()]/td[7]";
            if (base.getElementByXpathJS(path) == null) {
                base.hardWait("5000");
            }
            WebElement appointment = base.quickWait(path);
            base.hardWait("5000");
            if (appointment.isDisplayed()) {
                base.scrollToElement(appointment);
                status = appointment.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getAppointmentDate(int index) {
        String result = "";
        try {
            String path = "//*[@id=\"AppointmentsDT\"]//tr[idx]/td[7][string-length(text()) = 0]";
            path = path.replace("idx", Integer.toString(index));
            WebElement appointment = driver.findElement(By.xpath(path));
            if (appointment.isDisplayed()) {
                String pathToDate = "//*[@id=\"AppointmentsDT\"]//tr[idx]/td[3]";
                pathToDate = pathToDate.replace("idx", Integer.toString(index));
                WebElement appointmentDate = driver.findElement(By.xpath(pathToDate));
                if (appointmentDate.isDisplayed()) {
                    result = appointmentDate.getText();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void clickFirstAppointment() {
        try {
            WebElement appointment = driver.findElement(By.xpath("//*[@id=\"AppointmentsDT\"]//tr[1]/td[7][string-length(text()) = 0]"));
            base.waitFor();
            appointment.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSecondAppointment() {
        try {
            WebElement appointment = driver.findElement(By.xpath("//*[@id=\"AppointmentsDT\"]//tr[2]/td[7][string-length(text()) = 0]"));
            base.waitFor();
            appointment.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickThirdAppointment() {
        try {
            WebElement appointment = driver.findElement(By.xpath("//*[@id=\"AppointmentsDT\"]//tr[3]/td[7][string-length(text()) = 0]"));
            Thread.sleep(1000);
            appointment.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickCompleteAppointment(String status, String hours, String mins) throws InterruptedException {
//        waitForElementVisible(diaryAppointment);
//        waitForPageToLoad();
//        diaryAppointment.click();
//        Thread.sleep(3000);
        diaryAppointmentCompleteButtom.click();
        Thread.sleep(5000);
        if (status == partsNeeded) {
            base.selectTextByVisibleText(selectOutcomeOfAppointment, partsNeeded);
        } else {
            base.selectTextByVisibleText(selectOutcomeOfAppointment, status);
        }
        Thread.sleep(2000);
        enterArrivalTime.click();
        getElement(xPathForTimeHours, hours).click();
        Thread.sleep(2000);
        getElement(xPathForTimeMins, mins).click();
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);
//        serialUpdateFinishBtn.click();
    }

    public void clickInsertNewAppointmentButton() {
        base.checkIfELementIsAvailable(diaryAppointmentInsertButton);
        base.clickWithJsExecutor(diaryAppointmentInsertButton);
        base.waitForPageToLoad();
    }

    public void pendingForPartsNeededAppointment(String hours, String mins) throws InterruptedException {

    }

    public void completeServiceReport() {
        serviceReportText.sendKeys("Test");
    }

    public int getTotalAppointmentsInTheList() {

        int total = 0;
        try {
            WebElement totalAppointment = driver.findElement(By.xpath(pathForTotalAppointments));
            String totalAppointments = totalAppointment.getText();
            total = Integer.parseInt(totalAppointments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public boolean checkIfTheVisitCompleted(String record, String outcome) {
        boolean status = false;
        String path = "//*[@id=\"AppointmentsDT\"]//tr[${input}]/td[7]";
        path = path.replace("${input}", record);
        try {
            WebElement appointmentStat = driver.findElement(By.xpath(path));
            base.checkIfELementIsAvailable(appointmentStat);
            if (appointmentStat.getText() == outcome) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // check the first appointment status using outcome
        return status;
    }

    public void completePartialVisit(String outcome, String hours, String mins) throws InterruptedException {
//        clickOpenDiaryAppointment();
        Thread.sleep(3000);
        clickCompleteAppointment(outcome, hours, mins);
    }

    public void performRepairCompleteWithoutSerialNo() throws InterruptedException {
        completeServiceReport();
        base.hardWait("2000");
        completeLabourAndPartsForRepairComplete();
        base.hardWait("3000");
        completeJobProcess();
        base.hardWait("3000");
    }

    public void performRepairCompleteWithoutSerialNo(String completeStatus) throws InterruptedException {
        completeServiceReport();
        base.hardWait("2000");
        completeLabourAndPartsForRepairComplete();
        base.hardWait("3000");
        if(!completeStatus.equals("Remediation Work Required")) {
            completeJobProcess(completeStatus);}
        base.hardWait("3000");
    }

    public void performRepairCompleteWithSerialNo() throws InterruptedException {
        completeServiceReport();
        base.hardWait("2000");
        updateSerialNo();
        completeLabourAndPartsForRepairComplete();
        base.hardWait("3000");
        completeJobProcess();
        base.hardWait("3000");
    }

    public void updateSerialNo() {
        serialNumberChange.click();
        base.sendFieldInputData(serialNumber, "AKNRV");
        base.sendFieldInputData(serialUpdateReason, "Testdatasetup");
        base.hardWait("2000");
        base.isClickable(serialUpdateFinishBtn);
        base.clickElement(serialUpdateFinishBtn);
        base.hardWait("2000");
    }

    public void performRepairComplete() throws InterruptedException {
        completeServiceReport();
        base.hardWait("2000");
        completeLabourAndParts();
        base.hardWait("3000");
        completeJobProcess();
        base.hardWait("3000");
    }

    public void completeLabourAndParts() throws InterruptedException {
        base.sendFieldInputData(engineerName, "TestEngineer");
        base.clickWithJsExecutor(partialBreakdownRadiobutton);
        Thread.sleep(2000);
        if (base.isClickable(serialNumber)) {
            base.clickWithJsExecutor(serialNumberChange);
        } else {
            base.waitTillElementFound(serialNumberChange);
            base.clickWithJsExecutor(serialNumberChange);
        }

        if (serialNumber.isEnabled()) {
            base.sendFieldInputData(serialNumber, "AKNRV");
            base.sendFieldInputData(serialUpdateReason, "Test");
            if (base.isClickable(serialUpdateFinishBtn)) {
                base.clickWithJsExecutor(serialUpdateFinishBtn);
            } else {
                base.waitTillElementFound(serialUpdateFinishBtn);
                base.clickWithJsExecutor(serialUpdateFinishBtn);
            }
        }

//        Thread.sleep(5000);
//        base.waitForPageToLoad();
//        base.waitForElementVisible(createEstimateButton);
        if (base.isClickable(base.quickWait(createEstimateButtonPath))) {
            base.clickWithJsExecutor(createEstimateButton);
//            base.waitForElementVisible(poppupToProceed);
        } else {
            base.waitForElementVisible(createEstimateButton);
            base.clickWithJsExecutor(createEstimateButton);
        }

        if (base.isClickable(poppupToProceed)) {
            base.clickWithJsExecutor(poppupToProceed);
        } else {
            base.waitTillElementFound(poppupToProceed);
            base.clickWithJsExecutor(poppupToProceed);
        }

//        Thread.sleep(15000);
//        base.waitForElementVisible(labourChargeSectionB);
        if (base.quickWait(labourChargeSectionBPath).isDisplayed()) {
            base.selectTextByVisibleText(labourChargeSectionB, "103 - No heating");
            base.hardWait("2000");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        } else {
            base.waitToLoadElement();
//            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.selectTextByVisibleText(labourChargeSectionB, "103 - No heating");
            base.hardWait("2000");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        }

        if (base.waitForElementVisible(addAdjustmentButton)) {
            base.clickWithJsExecutor(addAdjustmentButton);
        }
        base.waitForElementVisible(addAdjustmentFaultCode);
        base.selectTextByVisibleText(addAdjustmentFaultCode, "A01 - Adjustment - Electrical");
        base.clickWithJsExecutor(lockEstimateButton);
        base.waitForElementVisible(lockEstimateWarningContinueBtn);
        base.clickWithJsExecutor(lockEstimateWarningContinueBtn);
        base.clickWithJsExecutor(estimateAcceptedProceedButton);

    }

    public void completeJobProcess() throws InterruptedException {
        base.refreshPage();
        if (!base.isClickable(completeJobButton)) {
            base.refreshPage();
            base.hardWait("3000");
        }
//        completeJobButton.click();
        base.clickWithJsExecutor(completeJobButton);
        base.waitForElementVisible(serviceCategoryStatusDropdown);
        Thread.sleep(3000);
        selectCombibox(serviceCategoryStatusDropdown, "Physical");
        base.hardWait("3000");
        selectCombibox(completionStatusDropdown, "Technical Fix");
        base.hardWait("3000");
        if (!base.isClickable(confirmJobCompletionBtn)) {
            base.waitTillElementFound(confirmJobCompletionBtn);
        }
        confirmJobCompletionBtn.click();

        if (!base.isClickable(eInvoiceRequiredNo)) {
            base.hardWait("5000");
        }
        eInvoiceRequiredNo.click();
    }


    public void completeJobProcess(String completeStatus) throws InterruptedException {
        base.refreshPage();
        if (!base.isClickable(completeJobButton)) {
            base.refreshPage();
            base.hardWait("3000");
        }
//        completeJobButton.click();
        base.clickWithJsExecutor(completeJobButton);
        base.waitForElementVisible(serviceCategoryStatusDropdown);
        selectCombibox(serviceCategoryStatusDropdown, "Physical");
        base.hardWait("3000");
        selectCombibox(completionStatusDropdown, completeStatus);
        base.hardWait("3000");
        if (!base.isClickable(confirmJobCompletionBtn)) {
            base.waitTillElementFound(confirmJobCompletionBtn);
        }
        confirmJobCompletionBtn.click();

        if (!base.isClickable(eInvoiceRequiredNo)) {
            base.hardWait("5000");
        }
        eInvoiceRequiredNo.click();
    }

    public void completeLabourAndPartsForPNLA() {
        base.sendFieldInputData(engineerName, "TestEngineer");
        base.clickWithJsExecutor(partialBreakdownRadiobutton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (base.isClickable(base.quickWait(createEstimateButtonPath))) {
            base.clickWithJsExecutor(createEstimateButton);
        } else {
            base.waitForElementVisible(createEstimateButton);
            base.clickWithJsExecutor(createEstimateButton);
        }

        if (base.isClickable(poppupToProceed)) {
            base.clickWithJsExecutor(poppupToProceed);
        } else {
            base.waitTillElementFound(poppupToProceed);
            base.clickWithJsExecutor(poppupToProceed);
        }

        if (base.quickWait(labourChargeSectionBPath).isDisplayed()) {

            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        } else {
            base.waitToLoadElement();
            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
            if (labourChanrgeFaultCode.getAttribute("value") == null) {
                base.hardWait("1000");
                base.selectTextByIndex(labourChanrgeFaultCode, 1);
            }
        }

        // Add Part
        if (base.waitForElementVisible(addPartButton)) {
            base.clickWithJsExecutor(addPartButton);
        }
        base.waitForElementVisible(addPart_Description);
        base.sendFieldInputData(addPart_Description, "Test1");
        base.waitForElementVisible(addPart_PartNo);
        base.sendFieldInputData(addPart_PartNo, "Test1");
        base.waitForElementVisible(addPart_PartStatus);
        base.selectTextByVisibleText(addPart_PartStatus, "Part No Longer Available");
        base.waitForPageToLoad();
        base.waitForElementVisible(addPart_FaultCode);
        base.hardWait("2000");
        base.isClickable(addPart_FaultCode);
        base.selectTextByIndex(addPart_FaultCode, 1);
        base.waitForPageToLoad();
        base.waitForElementVisible(addPart_PNLAPartDescription);
        base.hardWait("2000");
        base.isClickable(addPart_PNLAPartDescription);
        base.selectTextByIndex(addPart_PNLAPartDescription, 1);

        // Click Button - Lock Estimate
        base.waitForElementVisible(lockEstimateButton);
        base.clickWithJsExecutor(lockEstimateButton);
        base.waitForElementVisible(lockEstimateWarningContinueBtn);
        base.clickWithJsExecutor(lockEstimateWarningContinueBtn);
        base.waitForPageToLoad();
        base.hardWait("3000");
        base.refreshPage();
    }

    public void completeLabourAndPartsForUnRepairable() {
        base.sendFieldInputData(engineerName, "TestEngineer");
        base.clickWithJsExecutor(partialBreakdownRadiobutton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (base.isClickable(base.quickWait(createEstimateButtonPath))) {
            base.clickWithJsExecutor(createEstimateButton);
        } else {
            base.waitForElementVisible(createEstimateButton);
            base.clickWithJsExecutor(createEstimateButton);
        }

        if (base.isClickable(poppupToProceed)) {
            base.clickWithJsExecutor(poppupToProceed);
        } else {
            base.waitTillElementFound(poppupToProceed);
            base.clickWithJsExecutor(poppupToProceed);
        }

//        Thread.sleep(15000);
//        base.waitForElementVisible(labourChargeSectionB);
        if (base.quickWait(labourChargeSectionBPath).isDisplayed()) {

            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
//            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        } else {
            base.waitToLoadElement();
            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
//            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        }

        // Add Part
        if (base.waitForElementVisible(addPartButton)) {
            base.clickWithJsExecutor(addPartButton);
        }
        base.waitForElementVisible(addPart_Description);
        base.sendFieldInputData(addPart_Description, "Test1");
        base.waitForElementVisible(addPart_PartNo);
        base.sendFieldInputData(addPart_PartNo, "Test1");
        base.waitForElementVisible(addPart_PartStatus);
        base.selectTextByVisibleText(addPart_PartStatus, "Part No Longer Available");
        base.waitForPageToLoad();
        base.waitForElementVisible(addPart_FaultCode);
        base.hardWait("2000");
        if (!base.isClickable(addPart_FaultCode)) {
            base.hardWait("2000");
            if (!base.isClickable(addPart_FaultCode)) {
                LOGGER.info("Labour and Parts -> Fault Code section is not clickable at the moment");
            } else {
                base.selectTextByIndex(addPart_FaultCode, 1);
                base.waitForPageToLoad();
                base.waitForElementVisible(addPart_PNLAPartDescription);
                base.hardWait("2000");
            }
        }
//        if (!base.isClickable(addPart_PNLAPartDescription)) {
        base.hardWait("2000");
//            if (!base.isClickable(addPart_PNLAPartDescription)) {
//                LOGGER.info("Labour and Parts -> PNLA Part Description section is not clickable at the moment");
//            } else {
        base.selectTextByIndex(addPart_PNLAPartDescription, 1);

        // Click Button Unrepairable
        base.waitForElementVisible(buttonUnrepairable);
        base.clickWithJsExecutor(buttonUnrepairable);
        base.clickWithJsExecutor(estimateAcceptedProceedButton);
        base.checkIfELementIsAvailable(applicationWrittenOffProceedButton);
        base.clickWithJsExecutor(applicationWrittenOffProceedButton);
        base.waitForPageToLoad();
        base.waitFor();
        base.hardWait("3000");
//            }
//        }
    }


    public boolean isRAJobStatusisSetToWrittenOff(String writtenOffStatus) {

        boolean status = false;
        try {
            if (RAJobStatus.getText().contains(writtenOffStatus)) {
                status = true;
            }
        } catch (Exception e) {
            LOGGER.error("Unable to verify the RA Status");
        }
        return status;

    }

    public boolean isCurrentJobStatusisSet(String currStatus) {
        int nextRun = 0;
        boolean status = false;
        try {
            if (getCurrentAppointmentStatus().contains(currStatus)) {
                status = true;
            } else {
                while (nextRun == 3) {
                    base.refreshPage();
                    base.hardWait("2000");
                    if (getCurrentAppointmentStatus().contains(currStatus)) {
                        status = true;
                        break;
                    }
                    nextRun++;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Unable to verify the Job Status");
        }
        return status;

    }

    public boolean isRAJobStatusisSetToWrittenOffUnRepairable() {

        boolean status = false;
        try {
            if (RAJobStatus.getText().contains("WRITTEN OFF - UNREPAIRABLE")) {
                status = true;
            }
        } catch (Exception e) {
            LOGGER.error("Unable to verify the RA Status");
        }
        return status;

    }

    public boolean isJobCompleted() {

        boolean status = false;
        try {
            if (jobCompletedStatusText.getText().contains("REPAIR COMPLETED")) {
                status = true;
            }
        } catch (Exception e) {
            LOGGER.error("Unable to complete the Repair");
        }
        return status;
    }

    private void selectCombibox(WebElement element, String value) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
        action.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform();
        action.sendKeys(Keys.TAB).build().perform();
    }

    private WebElement getElement(String path, String value) {

        String xPath = path.replace("$(input)", value);
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;


    }

    public String getClaimBookedTime() {
        String bookedTime = firstAppointmentBookedTime.getText();
        bookedTime = bookedTime.replace("(", "");
        bookedTime = bookedTime.replace(")", "").trim();
        return bookedTime;
    }

    public String getClaimFirstAppointmentDate() {
        return firstAppointmentDate.getText();
    }


    public String getNextAvailableDate(String curDate, int days) {
        String nextDate = "";
        try {
            Calendar today = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(curDate);
            today.setTime(date);
            today.add(Calendar.DAY_OF_YEAR, days);
            nextDate = format.format(today.getTime());
        } catch (Exception e) {
            return nextDate;
        }
        return nextDate;
    }

    public void insertNewAppointment() {
        try {
            if (base.checkIfELementIsAvailable(insertButton)) {
                base.clickWithJsExecutor(insertButton);
                base.waitToLoadElement();
                base.checkIfELementIsAvailable(firstAvailableDate);
                base.clickWithJsExecutor(firstAvailableDate);
                base.waitToLoadElement();
                base.checkIfELementIsAvailable(bookAppointmentButton);
                base.clickWithJsExecutor(bookAppointmentButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setPartETAAvailableDate() {
        WebElement dateToPick = null;
        try {
            dateToPick = seleniumHelper.getCustomElementByXpath(partETA_DatePickerXpath, seleniumHelper.getCurrentDate().substring(0, 2));
            if (dateToPick != null) {
                base.clickElement(dateToPick);
            } else {
                base.waitForElementVisible(seleniumHelper.getCustomElementByXpath(partETA_DatePickerXpath, seleniumHelper.getCurrentDate().substring(0, 2)));
                base.hardWait("1000");
                dateToPick = seleniumHelper.getCustomElementByXpath(partETA_DatePickerXpath, seleniumHelper.getCurrentDate().substring(0, 2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void completeLabourAndPartsForPartEta() {
        base.sendFieldInputData(engineerName, "TestEngineer");
        base.clickWithJsExecutor(partialBreakdownRadiobutton);
        base.hardWait("3000");
        if (base.isClickable(base.quickWait(createEstimateButtonPath))) {
            base.clickWithJsExecutor(createEstimateButton);
        } else {
            base.waitForElementVisible(createEstimateButton);
            base.clickWithJsExecutor(createEstimateButton);
        }

        if (base.isClickable(poppupToProceed)) {
            base.clickWithJsExecutor(poppupToProceed);
        } else {
            base.waitTillElementFound(poppupToProceed);
            base.clickWithJsExecutor(poppupToProceed);
        }

        if (base.quickWait(labourChargeSectionBPath).isDisplayed()) {

            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
//            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        } else {
            base.waitToLoadElement();
            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
//            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
        }

        // Add Part
        if (base.waitForElementVisible(addPartButton)) {
            base.clickWithJsExecutor(addPartButton);
        }
        base.waitForElementVisible(addPart_Description);
        base.sendFieldInputData(addPart_Description, "Test1");
        base.waitForElementVisible(addPart_PartNo);
        base.sendFieldInputData(addPart_PartNo, "Test1");
        base.waitForElementVisible(addPart_PartStatus);
        base.selectTextByVisibleText(addPart_PartStatus, "Part Order Required");
        base.waitForPageToLoad();
        // Date Picker
        base.isClickable(partETA_dateIcon);
        base.clickWithJsExecutor(partETA_dateIcon);
        setPartETAAvailableDate();
        base.waitToLoadElement();
        base.hardWait("2000");
        base.waitForElementVisible(addPart_FaultCode);
        base.hardWait("2000");
        base.isClickable(addPart_FaultCode);
        base.selectTextByIndex(addPart_FaultCode, 1);
        base.waitForPageToLoad();
        base.hardWait("1000");


        // Click Button - Non Viable repair - Parts ETA
        base.waitForElementVisible(buttonPartsETAWrittenOff);
        base.clickWithJsExecutor(buttonPartsETAWrittenOff);
        base.checkIfELementIsAvailable(partsETAConfirmationPopup_Yes_Button);
        base.clickWithJsExecutor(partsETAConfirmationPopup_Yes_Button);

        if (base.checkIfELementIsAvailable(selectPartsForPartETA_Popup_Checkbox)) {
            base.clickWithJsExecutor(selectPartsForPartETA_Popup_Checkbox);
            base.clickWithJsExecutor(partsETA_patsSelection_SubmitButton);
        } else {
            base.waitForPageToLoad();
            base.clickWithJsExecutor(selectPartsForPartETA_Popup_Checkbox);
            base.clickWithJsExecutor(partsETA_patsSelection_SubmitButton);
        }

        base.checkIfELementIsAvailable(applicationWrittenOffProceedButton);
        base.clickWithJsExecutor(applicationWrittenOffProceedButton);
        base.waitForPageToLoad();
        base.waitFor();
        base.refreshPage();
        base.hardWait("3000");
    }

    public void completeLabourAndPartsForRepairComplete() {
        base.sendFieldInputData(engineerName, "TestEngineer");
        base.clickWithJsExecutor(partialBreakdownRadiobutton);
        base.hardWait("3000");
        if (base.isClickable(base.quickWait(createEstimateButtonPath))) {
            base.clickWithJsExecutor(createEstimateButton);
        } else {
            base.waitForElementVisible(createEstimateButton);
            base.clickWithJsExecutor(createEstimateButton);
        }

        if (base.isClickable(poppupToProceed)) {
            base.clickWithJsExecutor(poppupToProceed);
        } else {
            base.waitTillElementFound(poppupToProceed);
            base.clickWithJsExecutor(poppupToProceed);
        }

        if (base.quickWait(labourChargeSectionBPath).isDisplayed()) {

//            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.selectTextByIndex(labourChargeSectionB, 1);
            base.waitForPageToLoad();
            base.hardWait("2000");
//            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
            if (labourChanrgeFaultCode.getAttribute("value") == null) {
                base.hardWait("2000");
                base.selectTextByIndex(labourChanrgeFaultCode, 1);
            }
        } else {
            base.waitToLoadElement();
            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
//            base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
            if (labourChanrgeFaultCode.getAttribute("value") == null) {
                base.hardWait("2000");
                base.selectTextByIndex(labourChanrgeFaultCode, 1);
            }
        }

        base.hardWait("3000");

        if (base.waitForElementVisible(addAdjustmentButton)) {
            base.clickWithJsExecutor(addAdjustmentButton);
        }
        base.waitForElementVisible(addAdjustmentFaultCode);
        base.selectTextByVisibleText(addAdjustmentFaultCode, "A01 - Adjustment - Electrical");
        base.clickWithJsExecutor(lockEstimateButton);
        base.waitForElementVisible(lockEstimateWarningContinueBtn);
        base.clickWithJsExecutor(lockEstimateWarningContinueBtn);
        base.clickWithJsExecutor(estimateAcceptedProceedButton);
//
//        // Add Part
//        if (base.waitForElementVisible(addPartButton)) {
//            base.clickWithJsExecutor(addPartButton);
//        }
//        base.waitForElementVisible(addPart_Description);
//        base.sendFieldInputData(addPart_Description,"Test1");
//        base.waitForElementVisible(addPart_PartNo);
//        base.sendFieldInputData(addPart_PartNo,"Test1");
//        base.waitForElementVisible(addPart_PartStatus);
//        base.selectTextByVisibleText(addPart_PartStatus, "Part Order Required");
//        base.waitForPageToLoad();
//        // Date Picker
//        base.isClickable(partETA_dateIcon);
//        base.clickWithJsExecutor(partETA_dateIcon);
//        setPartETAAvailableDate();
//        base.waitToLoadElement();
//        base.hardWait("2000");
//        base.waitForElementVisible(addPart_FaultCode);
//        base.hardWait("2000");
//        base.isClickable(addPart_FaultCode);
//        base.selectTextByIndex(addPart_FaultCode,1);
//        base.waitForPageToLoad();
//        base.hardWait("1000");
//
//
//        // Click Button - Non Viable repair - Parts ETA
//        base.waitForElementVisible(buttonPartsETAWrittenOff);
//        base.clickWithJsExecutor(buttonPartsETAWrittenOff);
//        base.checkIfELementIsAvailable(partsETAConfirmationPopup_Yes_Button);
//        base.clickWithJsExecutor(partsETAConfirmationPopup_Yes_Button);
//
//        if (base.checkIfELementIsAvailable(selectPartsForPartETA_Popup_Checkbox)) {
//            base.clickWithJsExecutor(selectPartsForPartETA_Popup_Checkbox);
//            base.clickWithJsExecutor(partsETA_patsSelection_SubmitButton);
//        }  else {
//            base.waitForPageToLoad();
//            base.clickWithJsExecutor(selectPartsForPartETA_Popup_Checkbox);
//            base.clickWithJsExecutor(partsETA_patsSelection_SubmitButton);
//        }
//
//        base.checkIfELementIsAvailable(applicationWrittenOffProceedButton);
//        base.clickWithJsExecutor(applicationWrittenOffProceedButton);
//        base.waitForPageToLoad();
//        base.waitFor();
//        base.refreshPage();
//        base.hardWait("3000");
    }

    /*
    Manish Kumar Jain
    Date: 11th Nov 2021
    Scenario: Close appointment pop up for the plan which do not have appointment booked.
     */

    public void closeAppointmentPopUp() {
        if (base.checkIfELementIsAvailable(noAppointmentBookedPopUp) && base.waitForElementVisible(noAppointmentBookedPopUp)) {
            base.clickWithJsExecutor(noAppointmentBookedPopUpCloseButton);
        } else {
            base.waitToLoadElement();
            base.clickWithJsExecutor(noAppointmentBookedPopUpCloseButton);
        }
    }

    /*
    Manish Kumar Jain
    Date: 11th Nov
    Scenario: Click on Close button in No Appointment booked pop up and update Labour & Charge section in Repairer Portal
     */
    public void performRepairCompleteWithoutSerialNoHotpoint() throws InterruptedException {
        closeAppointmentPopUp();
        base.hardWait("2000");
        completeServiceReport();
        base.hardWait("2000");
        completeLabourAndPartsForRepairCompleteHotpoint();
        base.hardWait("3000");
        closeAppointmentPopUp();
        base.hardWait("3000");
        completeJobProcessHotpoint();
        base.hardWait("3000");
    }

    /*
    Name : Manish Kumar jain
    Date: 12th Nov
    Scenario: Labour and Parts cost update for the Hotpoint Plans with Net Cost value updated.
     */
    public void completeLabourAndPartsForRepairCompleteHotpoint() throws InterruptedException {
        base.sendFieldInputData(engineerName, "TestEngineer");
        base.clickWithJsExecutor(partialBreakdownRadiobutton);
        //base.hardWait("5000");
        Thread.sleep(4000);

        if (base.quickWait(labourChargeSectionBPath).isDisplayed()) {
            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
            if (labourChanrgeFaultCode.getAttribute("value") == null) {
                base.hardWait("2000");
                base.selectTextByIndex(labourChanrgeFaultCode, 1);
            }
        } else {
            base.waitToLoadElement();
            base.selectTextByVisibleText(labourChargeSectionB, "X11 - At door");
            base.waitForPageToLoad();
            base.hardWait("2000");
            base.checkIfELementIsAvailable(labourChanrgeFaultCode);
            base.selectTextByIndex(labourChanrgeFaultCode, 1);
            if (labourChanrgeFaultCode.getAttribute("value") == null) {
                base.hardWait("2000");
                base.selectTextByIndex(labourChanrgeFaultCode, 1);
            }
        }
        Thread.sleep(5000);

        if (base.isClickable(base.quickWait(createEstimateButtonPath))) {
            base.clickWithJsExecutor(createEstimateButton);
        } else {
            base.waitForElementVisible(createEstimateButton);
            base.clickWithJsExecutor(createEstimateButton);
        }
        Thread.sleep(3000);

        if (base.isClickable(poppupToProceed)) {
            base.clickWithJsExecutor(poppupToProceed);
        } else {
            base.waitTillElementFound(poppupToProceed);
            base.clickWithJsExecutor(poppupToProceed);
        }
        Thread.sleep(6000);

//        netCostAmountForHotpointPlan.clear();
//        netCostAmountForHotpointPlan.sendKeys("10");
//        Thread.sleep(3000);

        if (base.waitForElementVisible(addAdjustmentButton)) {
            base.clickWithJsExecutor(addAdjustmentButton);
        }
        Thread.sleep(3000);
        base.waitForElementVisible(addAdjustmentFaultCode);
        Thread.sleep(3000);
        base.selectTextByVisibleText(addAdjustmentFaultCode, "A01 - Adjustment - Electrical");
        Thread.sleep(3000);

        base.clickWithJsExecutor(lockEstimateButton);
        Thread.sleep(3000);
        base.waitForElementVisible(lockEstimateWarningContinueBtn);
        Thread.sleep(3000);
        base.clickWithJsExecutor(lockEstimateWarningContinueBtn);
        Thread.sleep(3000);
        base.clickWithJsExecutor(estimateAcceptedProceedButton);
        Thread.sleep(8000);
    }

    /*
    Manish Kumar Jain
    Date: 11th Nov
    Scenario: Update the Job Completion status in Hotpoint Repairer Portal to mark the Job complete.
     */
    public void completeJobProcessHotpoint() throws InterruptedException {
        //base.refreshPage();
        if (!base.isClickable(completeJobButton)) {
            base.refreshPage();
            base.hardWait("3000");
        }
        base.clickWithJsExecutor(completeJobButton);
        base.waitForElementVisible(serviceCategoryStatusDropdown);
        serviceCategoryDropdown.clear();
        Thread.sleep(2000);
        serviceCategoryDropdown.sendKeys("Physical");

        completionStatusDropdownText.clear();
        Thread.sleep(2000);
        completionStatusDropdownText.sendKeys("Technical Fix");

        driver.findElement(By.xpath("//span[@id='jbCompletionDate']")).click();
        Thread.sleep(2000);

        if (!base.isClickable(confirmJobCompletionBtn)) {
            base.waitTillElementFound(confirmJobCompletionBtn);
        }
        confirmJobCompletionBtn.click();

        if (!base.isClickable(eInvoiceRequiredNo)) {
            base.hardWait("5000");
        }
        eInvoiceRequiredNo.click();
    }

    public void updateRepairFaultCodeAndProblemCode() {
        base.quickWait(labourChargeSectionBPath).isDisplayed();
        base.selectTextByIndex(labourChargeSectionB, 1);
        base.hardWait("2000");
        base.selectTextByIndex(labourChanrgeFaultCode, 1);

    }

    public void addAttachment() {
        if (!base.isClickable(attachmentInsertBtn)) {
            base.waitToLoadElement();
        }
        base.clickElement(attachmentInsertBtn);
        addAttachment.uploadAttachment();
    }

    public boolean isAttachmentUploaded() {
        return base.checkIfELementIsAvailable(uploadedAttachmentType);
    }

    public void completeLabourAndPartsWithSerialNo() throws InterruptedException {
        completeServiceReport();
        base.hardWait("2000");
        updateSerialNo();
        completeLabourAndPartsForRepairComplete();
        base.hardWait("3000");
    }

    public void setAddAttachment() throws InterruptedException {
        addAttachment();
        base.hardWait("3000");
    }

    public void completeJobWithSerialNo() throws InterruptedException {
        completeJobProcess();
        base.hardWait("3000");
    }

    public void completeLabourAndPartsWithoutSerialNo() throws InterruptedException {
        completeServiceReport();
        base.hardWait("2000");
        completeLabourAndPartsForRepairComplete();
        base.hardWait("3000");
    }

}