package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Srv8027WhirlpoolRebookingAndReselection {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage makeAClaim;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//input[@id='jobnoSearch']")
    private WebElement claimNumberSearchInput;

    @FindBy(xpath = "//input[@id='jobSearch']")
    private WebElement planNumberSearchInput;

    @FindBy(xpath = "//div[@style='float:left; margin-bottom: 10px; width: 100%;']//img[@onclick='goToSearchJob();']")
    private WebElement claimNumberSearchButton;

    @FindBy(xpath = "//div[@style='float:left;margin-bottom: -1px;position: relative;width:100%']//img[@onclick='planNumberSearch();']")
    private WebElement planNumberSearchButton;

//    @FindBy(xpath = "//tr[@class='odd DTTT_selected']")
//    private WebElement firstRowGridJobSearch;

    private final String viewJobDetailsTablePath="//table[@id='matches_table'][@class='browse dataTable DTTT_selectable']";
    @FindBy(xpath = viewJobDetailsTablePath)
    private WebElement viewJobDetailsTable;

    private final String checkBoxFirstRowGridPath="//table[@id='matches_table']/tbody[@role='alert']/tr[1]/td[12]/input[1]";
    @FindBy(xpath = checkBoxFirstRowGridPath)
    private WebElement checkBoxFirstRowGrid;

    private final String viewJobDetailsButtonPath = "//div[@class='DTTT_container']//a[@id='ToolTables_matches_table_0']//span[contains(text(),'View Job Details')]";
    @FindBy(xpath = viewJobDetailsButtonPath)
    private WebElement viewJobDetailsButton;









    @FindBy(xpath = "//*[@id=\"Appointments\"]/fieldset/img[contains(@onclick,\"toggleSection\")]")
    private WebElement enableDiaryAppointmentSection;

    @FindBy(xpath = "//a[@id='ToolTables_AppointmentsDT_1'][@class='DTTT_button btnStandardInsert findnewDGAppointmnent']")
    private WebElement findNewAppointmentButton;

    //div[@class='DTTT_container']//a[@id='ToolTables_AppointmentsDT_0']//span[contains(text(),'Find New Appointment')]
    //a[@id='ToolTables_AppointmentsDT_2'][@class='DTTT_button btnStandardInsert findnewDGAppointmnent']
    //a[@id='ToolTables_AppointmentsDT_0'][@class='DTTT_button btnStandardInsert findnewDGAppointmnent']
    //*[@id='apptHolder']//div[@id='AppointmentsPanel']//div[@class='DTTT_container']//a[@id='ToolTables_AppointmentsDT_0']

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

    private final String searchOtherServiceProviderDisabled = "//input[@id='showotherspscal' and @class=\"btnStandard rounded disabled\" and @disabled=\"disabled\"]";
    @FindBy(xpath = searchOtherServiceProviderDisabled)
    private WebElement findNewAppointment_searchOtherServicepPoviderButtonDisabled;

    private final String fieldCallCalendarAvailability = "//*[@id='claimRebkAppt_rSp']//tr/td[contains(@class,\"dayAvailable\")][9]";
    @FindBy(xpath = fieldCallCalendarAvailability)
    private WebElement findNewAppointment_fieldCallCalendarNinthDayAvailability;

    private final String claimJobStatusPath = "//div[@id='ui2_top_header']//b[@id='JobStatusName']";
    @FindBy(xpath = claimJobStatusPath)
    WebElement jobStatus;

    @FindBy(xpath = "//div[@id='ui2_top_header']//b[@id='JobStatusName']")
    WebElement jobStatusAny;

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
    @FindBy(xpath=DAndGLogoPath)
    private WebElement DAndGLogo;

    private final String reviewClaimBookingOverviewPath = "//div[@id='ui2_wrapper']//div[@id='ui2_right']//div[@id='ui2_right_header']";
    @FindBy(xpath=reviewClaimBookingOverviewPath)
    private WebElement reviewClaimBookingOverview;

    private final String payAndClaimConfirmationPagePath = "//div[@style='width:100%; text-align: center; float: left;']";
    @FindBy(xpath=payAndClaimConfirmationPagePath)
    private WebElement payAndClaimConfirmationPage;

    private final String multipleClaimBoxPath = "//div[@id='toast-container']//div[@class='toast toast-info']//div[@class='toast-title']";
    @FindBy(xpath=multipleClaimBoxPath)
    private WebElement multipleClaimBox;

    private final String multipleClaimBoxCrossPath = "//div[@class='toast toast-info']//button[contains(text(),'×')]";
    @FindBy(xpath=multipleClaimBoxCrossPath)
    private WebElement multipleClaimBoxCross;







    public Srv8027WhirlpoolRebookingAndReselection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage makeAClaim) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.makeAClaim = makeAClaim;
        PageFactory.initElements(driver, this);
    }

    public void searchForAClaimUsingClaimNo(String ClaimNo) {
        try {
            base.waitForElementVisible(claimNumberSearchInput);
            if (base.checkIfELementIsAvailable(claimNumberSearchInput) & base.isElementAvilable(claimNumberSearchInput)) {
                base.sendFieldInputData(claimNumberSearchInput, ClaimNo);
                Thread.sleep(3000);
            }
            base.waitTillElementFound(claimNumberSearchButton);
            if (base.checkIfELementIsAvailable(claimNumberSearchButton) & base.isElementAvilable(claimNumberSearchButton)) {
                base.clickWithJsExecutor(claimNumberSearchButton);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to load the Review claim page for the given Claim Number");
        }
    }

    public void searchForAClaimUsingPlanNo(String PlanNo) {
        try {
            base.waitForElementVisible(planNumberSearchButton);
            if (base.checkIfELementIsAvailable(planNumberSearchInput) & base.isElementAvilable(planNumberSearchInput)) {
                base.sendFieldInputData(planNumberSearchInput, PlanNo);
                Thread.sleep(3000);
            }
            base.waitTillElementFound(planNumberSearchButton);
            if (base.checkIfELementIsAvailable(planNumberSearchButton) & base.isElementAvilable(planNumberSearchButton)) {
                base.clickWithJsExecutor(planNumberSearchButton);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to load the Job search page for the given Plan Number");
        }
    }

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
                Thread.sleep(3000);

            } else {
                base.waitToLoadElement();
                base.waitForElementVisible(findNewAppointmentButton);
                if (base.isElementAvilable(findNewAppointmentButton) & findNewAppointmentButton.isDisplayed()) {
//                    base.highlightElementWithScreenshot(findNewAppointmentButton, "Click on Find New Appointment button");
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
                if (base.checkIfELementIsAvailable(findNewAppointment_StartAppointmentSearchButton) && findNewAppointment_StartAppointmentSearchButton.isEnabled())
                {
                    base.clickWithJsExecutor(findNewAppointment_StartAppointmentSearchButton);
                    Thread.sleep(2000);
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability))
                    {
                        base.highlightElementWithScreenshot(findNewAppointment_rebookCalendarAvailability, "Whirlpool Calendar For Rebooking");
                        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
                        Thread.sleep(3000);
                    }
                    else
                    {
                        base.waitForElementAndReturnJS(rebookCalendarAvailability);
                        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
                        Thread.sleep(3000);
                    }
                } else
                {
                    if (base.waitForElementVisible(findNewAppointment_rebookCalendarAvailability) && base.checkIfELementIsAvailable(findNewAppointment_rebookCalendarAvailability))
                    {
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


    public void selectNinethAvailableAppointmentDateAndConfirmRebookButton() throws InterruptedException {
        base.waitTillElementFound(findNewAppointment_NinethAvailableDate);
        base.clickWithJsExecutor(findNewAppointment_NinethAvailableDate);
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
        System.out.println("No of columns in a table : " + columnCount);

        //Find a total no of rows in a web table.
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='AppointmentsDT_wrapper']/table/tbody/tr/td[1]"));
        int rowCount = rows.size();
        System.out.println("No of rows in a table : " + rowCount);

        String columnNull = driver.findElement(By.xpath(before_xpath + rowCount + after_xpath)).getText();
        if (columnNull == ApptCompletionStatus) {
            System.out.println("Appointment completion status is ---> " + columnNull + " which means appointment rebooked successfully");
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

    public void clickOnSearchOtherServiceProviderButtonAndSelectAvailableDate() throws InterruptedException {
        if (base.waitForElementVisible(findNewAppointment_searchOtherServicepPoviderButton) & findNewAppointment_searchOtherServicepPoviderButton.isEnabled()) {
            base.isElementAvilable(findNewAppointment_searchOtherServicepPoviderButton);
            base.highlightElement(findNewAppointment_searchOtherServicepPoviderButton);
            base.clickWithJsExecutor(findNewAppointment_searchOtherServicepPoviderButton);
            Thread.sleep(3000);
            if (base.waitForElementVisible(findNewAppointment_fieldCallCalendarNinthDayAvailability) & base.checkIfELementIsAvailable(findNewAppointment_fieldCallCalendarNinthDayAvailability)) {
                base.isElementAvilable(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.highlightElement(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.clickWithJsExecutor(findNewAppointment_fieldCallCalendarNinthDayAvailability);
            }
        } else {
            System.out.println("Search other Service provider button is disabled");
            if (base.waitForElementVisible(findNewAppointment_fieldCallCalendarNinthDayAvailability) & base.checkIfELementIsAvailable(findNewAppointment_fieldCallCalendarNinthDayAvailability)) {
                base.isElementAvilable(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.highlightElement(findNewAppointment_fieldCallCalendarNinthDayAvailability);
                base.clickWithJsExecutor(findNewAppointment_fieldCallCalendarNinthDayAvailability);
            }
        }

    }

    public void selectAvailableServiceProviderRadioButtonAndClickOnRebookButton() throws InterruptedException {
        if (base.waitForElementVisible(findNewAppointment_availableServiceProviderRadioButton) && base.checkIfELementIsAvailable(findNewAppointment_availableServiceProviderRadioButton)) {
            base.isElementAvilable(findNewAppointment_availableServiceProviderRadioButton);
            base.highlightElement(findNewAppointment_availableServiceProviderRadioButton);
            base.clickWithJsExecutor(findNewAppointment_availableServiceProviderRadioButton);
        }
        if (base.waitForElementVisible(findNewAppointment_rebookButtonForReselectionSP) && base.checkIfELementIsAvailable(findNewAppointment_rebookButtonForReselectionSP)) {
            base.isElementAvilable(findNewAppointment_rebookButtonForReselectionSP);
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
            base.isElementAvilable(findNewAppointment_confirmationAlertPopUpYes);
            base.highlightElement(findNewAppointment_confirmationAlertPopUpYes);
            base.clickWithJsExecutor(findNewAppointment_confirmationAlertPopUpYes);
        }
    }

    public boolean verifyNewServiceProviderNameInReviewClaimAfterReselect() {
        String oldServiceProvider = "WHIRLPOOL UK APPLIANCE LTD";
        String newServiceProviderName;
        boolean status = false;
        base.waitForPageToLoad();
        base.waitTillElementFound(reselect_newServiceProviderName);
        if (base.checkIfELementIsAvailable(reselect_newServiceProviderName) && base.isElementAvilable(reselect_newServiceProviderName)) {
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

    public boolean claimJobStatusDisplayedAfterReselectServiceProvider(String reselectjobstatus) {
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
    public void oldClaimIdComparedWithNewClaimId(String claimNo) {
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

    public boolean oldClaimJobReassignedStatus(String reviewClaimStatus) {
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

    public void clickOnReviewClaimTab() throws InterruptedException {
        Thread.sleep(2000);
        if (base.checkIfELementIsAvailable(reviewClaimPage_reviewClaimTab) && base.isElementAvilable(reviewClaimPage_reviewClaimTab)) {
            base.getElementByXpathJS(reviewClaimTab).click();
            Thread.sleep(2000);
        } else {
            System.out.println("Review Claim tab is not present");
        }
    }

    public boolean validateDiaryAppointmentJobReassignedStatus(String appointmentJobStatus) {
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
    public void specificSlotSelection() {
        base.waitForElementVisible(findNewAppointment_preferredDateDisplay);
        base.checkIfELementIsAvailable(findNewAppointment_preferredDateDisplay);
        String preDate = base.getElementFromXpath(preferredDateForSpecificSlot).getText().toString();
        if (preDate.length() >= 2) {
            int specificDate = Integer.parseInt(preDate.substring(0, 2));
        } else {
            System.out.println("Date not selected for specific timeslot");
        }
        //  driver.findElement(By.xpath("//div[@id='spApptTimeSlot']//span[@id='nextButtonAppointmentSlots']//span[@id='spApptTimeSlotData_'+"specificDate"]//input[@type='radio' and @value='06:00-22:00']"));

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

    public void verifyReviewClaimBookingPanel() throws InterruptedException {
        base.waitForElementVisible(reviewClaimBookingOverview);
        base.highlightElement(reviewClaimBookingOverview);


    }

    public boolean isBookingOverviewHeaderDisplayed() {
        boolean status = false;
        try {
//            if(driver.findElement(By.xpath(multipleClaimBoxPath)).isDisplayed())
            if(base.checkIfELementIsAvailable(multipleClaimBox) && base.waitForElementVisible(multipleClaimBox))
            {
                base.clickWithJsExecutor(multipleClaimBoxCross);
                base.highlightElement(reviewClaimBookingOverview);
            }
            else
            {
                Thread.sleep(3000);
                base.clickOutside();
                base.highlightElement(reviewClaimBookingOverview);
                base.clickWithJsExecutor(reviewClaimBookingOverview);
            }
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
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





}
