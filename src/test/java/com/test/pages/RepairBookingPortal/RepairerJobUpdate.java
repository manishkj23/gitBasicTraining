package com.test.pages.RepairBookingPortal;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RepairerJobUpdate {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr/td[7][string-length(text()) = 0]")
    WebElement diaryAppointment;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr[1]/td[3]")
    WebElement firstDiaryAppointmentDate;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT_wrapper\"]//span[contains(.,'Complete')]")
    WebElement diaryAppointmentCompleteButtom;

    @FindBy(xpath = "//*[@id=\"AppointmentsDT_wrapper\"]//span[contains(.,'Insert')]")
    WebElement diaryAppointmentInsertButton;

    @FindBy(xpath = "//div[@id=\"topBreadcrumb\"]//*[@id=\"jobUpdateBreadcrumb\"]")
    WebElement jobUpdatePageTitle;

    @FindBy(xpath = "//*[@id=\"matches_table\"]/tbody/tr[1]/td[1]")
    WebElement activeClaim;

    @FindBy(xpath = "//div[@class='DTTT_container']//span[contains(.,'View Job Details')]")
    WebElement viewJobButton;

    @FindBy(xpath = "//*[@id=\"AppointmentOutcome\"]")
    WebElement selectOutcomeOfAppointment;

    @FindBy(xpath = "//*[@id=\"engArrivalTime\"]")
    WebElement enterArrivalTime;

    @FindBy(xpath = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-hours']//td[contains(.,'08')]")
    WebElement timeArrivedHours;

    @FindBy(xpath = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-minutes']//td[contains(.,'10')]")
    WebElement timeArrivedMins;

    @FindBy(xpath = "//div[@role='dialog']//span[contains(.,'Submit')]")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"ServiceReport\"]")
    WebElement serviceReportText;
    @FindBy(xpath = "//*[@id=\"engineerName\"]")
    WebElement engineerName;
    @FindBy(xpath = "//*[@id=\"dgdamtp\"][contains(@onclick,'Partial Breakdown')]")
    WebElement partialBreakdownRadiobutton;
    @FindBy(xpath = "//img[contains(@onclick,'serialChange')]")
    WebElement serialNumberChange;
    @FindBy(xpath = "//*[@id=\"ppf_SerialNo\"]")
    WebElement serialNumber;
    @FindBy(xpath = "//*[@id=\"ppf_SerialUpdateReason\"]")
    WebElement serialUpdateReason;
    @FindBy(xpath = "//*[@id=\"popUpModelUpdateForm\"]//button[contains(.,'Finish')]")
    WebElement serialUpdateFinishBtn;

    @FindBy(xpath = "//button[@class=\"btnStandard createEstimateButton\"]")
    WebElement createEstimateButton;
    @FindBy(xpath = "//div[@role='dialog']//span[contains(.,'Proceed')]")
    WebElement poppupToProceed;
    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[1]/select")
    WebElement labourChargeSectionB;
    @FindBy(xpath = "//*[@id=\"dgFaultcodeJobHolder\"]/div[2]/select")
    WebElement labourChanrgeFaultCode;
    @FindBy(xpath = "//a[contains(.,'Add Adjustment')]")
    WebElement addAdjustmentButton;
    @FindBy(xpath = "//table[@id='LitePartsTable']//tr[td//input[contains(@value,'ADJUSTMENT ONLY')][@type='text']]//td[3]/div/select[@name='DgPartFaultCodeID']")
    WebElement addAdjustmentFaultCode;
    @FindBy(xpath = "//button[contains(.,'Lock Estimate')]")
    WebElement lockEstimateButton;
    @FindBy(xpath = "//div[@role='dialog']//span[contains(.,'Continue')]")
    WebElement lockEstimateWarningContinueBtn;
    @FindBy(xpath = "//div[@role='dialog']//span[contains(.,'Proceed')]")
    WebElement estimateAcceptedProceedButton;
    @FindBy(xpath = "//button[contains(.,'Estimate Revision')]")
    WebElement estimateRevisionButton;
    @FindBy(xpath = "//*[@id=\"completeJobBut\"]")
    WebElement completeJobButton;
    @FindBy(xpath = "//*[@id=\"completionForm\"]/div/div[1]/div[1]/span[2]/a/span[1]")
    WebElement serviceCategoryStatusDropdown;
    @FindBy(xpath = "//*[@id=\"completionForm\"]/div/div[1]/div[2]/span[2]/a/span[1]")
    WebElement completionStatusDropdown;
    @FindBy(xpath = "//*[@id=\"jobCompleteBtn\"]/a")
    WebElement confirmJobCompletionBtn;
    @FindBy(xpath = "//div[@role='dialog']//span[contains(.,'No')]")
    WebElement eInvoiceRequiredNo;
    @FindBy(xpath = "//*[@id=\"JobStatusText\"]/b")
    WebElement jobCompletedStatusText;

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//span[substring-after(.,'(')][substring-before(.,')')]/text()")
    WebElement firstAppointmentBookedTime;
    @FindBy(xpath = "//*[@id=\"AppointmentsDT\"]//tr[1]/td[3]")
    WebElement firstAppointmentDate;

    @FindBy(xpath = "//*[@id=\"AppointmentsCount\"]/text()")
    WebElement totalAppointments;
    @FindBy(xpath = "//*[@id=\"ToolTables_AppointmentsDT_0\"]/span")
    WebElement insertButton;
    @FindBy(xpath = "//table[@id=\"AppointmentsDT\"]/tbody/tr/td[contains(.,\"No data available in table\")]")
    WebElement zeroAppointmentsExist;
    @FindBy(xpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][1]")
    WebElement firstAvailableDate;

    @FindBy(xpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][2]")
    WebElement nextAvailableDateForCC;

    @FindBy(xpath = "//button[@id=\"juBookJobAppB3\"][contains(.,\"Book Appointment\")]")
    WebElement bookAppointmentButton;

    private final String pathForTotalAppointments = "//*[@id=\"AppointmentsCount\"]/text()";

    private final String xPathForTimeHours = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-hours']//td[contains(.,\"$(input)\")]";
    private final String xPathForTimeMins = "//*[@id=\"ui-timepicker-div\"]//td[@class='ui-timepicker-minutes']//td[contains(.,\"$(input)\")]";

    private final String visitComplete = "Callout / Visit Complete";
    private final String partsNeeded = "Parts Needed";


    public RepairerJobUpdate() {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isJobUpdatePageLanded() {
        boolean status = false;
        try {
            if (jobUpdatePageTitle.getText().contains("Job Update")) {
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

    public void clickOpenDiaryAppointment() {
        base.waitTillElementFound(diaryAppointment);
        diaryAppointment.click();
    }

    public boolean checkIfAppointmentIsOpen(int index) {
        boolean status = false;
        try {
            String path = "//*[@id=\"AppointmentsDT\"]//tr[idx]/td[7][string-length(text()) = 0]";
            path = path.replace("idx", Integer.toString(index));
            WebElement appointment = driver.findElement(By.xpath(path));
            if (appointment.isDisplayed()) {
                status = true;
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
            Thread.sleep(2000);
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
        diaryAppointmentInsertButton.click();
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

    public void performRepairComplete() throws InterruptedException {
        completeServiceReport();
        Thread.sleep(2000);
        completeLabourAndParts();
        Thread.sleep(3000);
        completeJobProcess();
        Thread.sleep(3000);
    }

    public void completeLabourAndParts() throws InterruptedException {
        engineerName.sendKeys("TestEngineer");
        Thread.sleep(2000);
        partialBreakdownRadiobutton.click();
        Thread.sleep(2000);
        serialNumberChange.click();
        Thread.sleep(2000);
        serialNumber.sendKeys("AKNRV");
        Thread.sleep(2000);
        serialUpdateReason.sendKeys("Test");
        Thread.sleep(2000);
        serialUpdateFinishBtn.click();
        Thread.sleep(5000);
        base.waitForPageToLoad();
        base.waitForElementVisible(createEstimateButton);
        createEstimateButton.click();
        base.waitForElementVisible(poppupToProceed);
        poppupToProceed.click();
        Thread.sleep(15000);
        base.waitForElementVisible(labourChargeSectionB);
        base.selectTextByVisibleText(labourChargeSectionB, "103 - No heating");
        Thread.sleep(5000);
        base.selectTextByVisibleText(labourChanrgeFaultCode, "BREAKDOWN - ");
        Thread.sleep(5000);
        base.waitForElementVisible(addAdjustmentButton);
        addAdjustmentButton.click();
        base.waitForElementVisible(addAdjustmentFaultCode);
        base.selectTextByVisibleText(addAdjustmentFaultCode, "A01 - Adjustment - Electrical");
        Thread.sleep(5000);
        lockEstimateButton.click();
        Thread.sleep(5000);
        base.waitForElementVisible(lockEstimateButton);
        lockEstimateWarningContinueBtn.click();
        Thread.sleep(5000);
        estimateAcceptedProceedButton.click();
        Thread.sleep(10000);
    }

    public void completeJobProcess() throws InterruptedException {
        completeJobButton.click();
        base.waitForElementVisible(serviceCategoryStatusDropdown);
        selectCombibox(serviceCategoryStatusDropdown, "Physical");
        Thread.sleep(3000);
        selectCombibox(completionStatusDropdown, "Technical Fix");
        Thread.sleep(3000);
        confirmJobCompletionBtn.click();
        Thread.sleep(5000);
        eInvoiceRequiredNo.click();
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
                insertButton.click();
                base.checkIfELementIsAvailable(firstAvailableDate);
                firstAvailableDate.click();
                base.waitToLoadElement();
                base.checkIfELementIsAvailable(bookAppointmentButton);
                bookAppointmentButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
