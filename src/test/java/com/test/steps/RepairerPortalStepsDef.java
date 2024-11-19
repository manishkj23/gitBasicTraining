package com.test.steps;


import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.AuthorityLineSummarySection;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewPage;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.RepairAuthoritySection;
import com.test.pages.RepairerPortal.AppointmentDetailsPage;
import com.test.pages.RepairerPortal.NewRepairBookingPage;
import com.test.pages.RepairerPortal.RepairerHomePage;
import com.test.pages.RepairerPortal.RepairerJobUpdate;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.GetContractDetails.GCDTemplate;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RepairerPortalStepsDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private RepairerHomePage repairerHomePage;
    private RepairerJobUpdate repairerJobUpdate;
    private AppointmentDetailsPage appointmentDetailsPage;
    private PlanDetails planDetails;
    private AuthorityLineSummarySection authorityLineSummarySectionNewUI;
    private RepairAuthoritySection repairAuthoritySectionNewUI;
    private BookingOverviewPage bookingOverviewPageNewUI;
    private NewRepairBookingPage newRepairBookingPage;
    private CommonUtils commonUtils;


    private static final Logger LOGGER = LoggerFactory.getLogger(RepairerPortalStepsDef.class);

    public RepairerPortalStepsDef(BasePage basePage,
                                  SeleniumHelper seleniumHelper,
                                  RepairerHomePage repairerHomePage,
                                  RepairerJobUpdate repairerJobUpdate,
                                  AppointmentDetailsPage appointmentDetailsPage,
                                  PlanDetails planDetails,
                                  AuthorityLineSummarySection authorityLineSummarySectionNewUI,
                                  RepairAuthoritySection repairAuthoritySectionNewUI,
                                  BookingOverviewPage bookingOverviewPageNewUI,
                                  NewRepairBookingPage newRepairBookingPage,
                                  CommonUtils commonUtils) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.appointmentDetailsPage = appointmentDetailsPage;
        this.repairerHomePage = repairerHomePage;
        this.repairerJobUpdate = repairerJobUpdate;
        this.driver = basePage.getDriver();
        this.planDetails = planDetails;
        this.authorityLineSummarySectionNewUI = authorityLineSummarySectionNewUI;
        this.repairAuthoritySectionNewUI = repairAuthoritySectionNewUI;
        this.bookingOverviewPageNewUI = bookingOverviewPageNewUI;
        this.newRepairBookingPage = newRepairBookingPage;
        this.commonUtils = commonUtils;
    }


    @Then("^I search for a claim using \"([^\"]*)\" and search$")
    public void iSearchForAClaimUsingAndSearch(String planNo) throws Throwable {
        repairerHomePage.searchPlan(planNo);
        repairerHomePage.clickLatestClaim();
        Thread.sleep(3000);
        base.waitForPageToLoad();
        Assert.assertTrue("Unable to launch Job Update Page ", repairerJobUpdate.isJobUpdatePageLanded());

    }


    @Then("^I search for a claim using \"([^\"]*)\" and search for WrittenOff$")
    public void iSearchForAClaimUsingAndSearchForWrittenOff(String planNo) throws Throwable {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            repairerHomePage.searchPlan(planDetails.getPlanNumber());
        } else {
            repairerHomePage.searchPlan(planNo);
        }

        repairerHomePage.clickLatestClaim();
        Thread.sleep(3000);
        base.waitForPageToLoad();
        Assert.assertTrue("Unable to launch Job Update Page ", repairerJobUpdate.isJobUpdatePageLanded());
        Thread.sleep(3000);

    }

    @Then("^I search for a claim using \"([^\"]*)\" and search for Repairer$")
    public void iSearchForAClaimUsingAndSearchForWrittenOffRepairer(String planNo) throws Throwable {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            repairerHomePage.searchPlan(planDetails.getPlanNumber());
        } else {
            repairerHomePage.searchPlan(planNo);
        }

        repairerHomePage.clickLatestClaim();
        Thread.sleep(3000);
        base.waitForPageToLoad();
        Assert.assertTrue("Unable to launch Job Update Page ", repairerJobUpdate.isJobUpdatePageLanded());
        Thread.sleep(3000);

    }

    @Then("^I complete the DiaryAppointment \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and outcome as \"([^\"]*)\"$")
    public void iCompleteTheDiaryAppointmentAs(String ref, String hours, String mins, String days, String outCome) throws Throwable {

        base.waitForPageToLoad();
        if (repairerJobUpdate.checkIfAppointmentIsOpen(1)) {
            repairerJobUpdate.clickFirstAppointment();
            repairerJobUpdate.completeAppointmentIfAppointmentSelected(hours, mins);
            Thread.sleep(3000);
            repairerJobUpdate.performRepairComplete();
        } else if (repairerJobUpdate.checkIfZeroAppointmentsExists()) {
            base.waitForPageToLoad();
            repairerJobUpdate.clickInsertNewAppointmentButton();
            appointmentDetailsPage.bookFirstAvailableAppointment();
//                    repairerJobUpdate.insertNewAppointment();
        }

    }

    @Then("^I complete the DiaryAppointment with outcome as \"([^\"]*)\"$")
    public void iCompleteTheDiaryAppointmentWithOutcomeAs(String outCome) throws Throwable {

        base.waitForPageToLoad();
        if (!repairerJobUpdate.checkIfAppointmentIsOpen()) {
            base.waitForPageToLoad();
            repairerJobUpdate.insertNewAppointment();

            base.refreshPage();
            base.waitForPageToLoad();
        }
        Assert.assertTrue("Appointment is not Open", repairerJobUpdate.checkIfAppointmentIsOpen());
        if (repairerJobUpdate.checkIfAppointmentIsOpen()) {
            repairerJobUpdate.clickIfAppointmentIsOpen();
            repairerJobUpdate.completeAppointmentAs(seleniumHelper.getCurrentTime("HH"), seleniumHelper.getCurrentTime("mm"), outCome);
            base.hardWait("3000");


//            repairerJobUpdate.performRepairComplete();
        } else if (repairerJobUpdate.checkIfZeroAppointmentsExists()) {
            base.waitForPageToLoad();
            repairerJobUpdate.clickInsertNewAppointmentButton();
            appointmentDetailsPage.bookFirstAvailableAppointment();
//                    repairerJobUpdate.insertNewAppointment();
        }
        Assert.assertTrue("Current Appointment Status not verified", repairerJobUpdate.getCurrentAppointmentStatus().contains(outCome));
    }

    @Then("^I Verify the Job Completed Status in RP is Successful for \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedStatusIsSuccessful(String outCome) {
        Assert.assertTrue("Unable to Verify Status as Written Off - Unrepairable", repairerJobUpdate.isRAJobStatusisSetToWrittenOff(outCome));
    }

    @Then("^I Verify the Job Completed Status in Diary Appiontment Section in RP is Successful for \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedDAStatusIsSuccessful(String outCome) {
        base.hardWait("2000");
        Assert.assertTrue("Unable to Verify Current Job Status", repairerJobUpdate.isCurrentJobStatusisSet(outCome));
    }


    @And("^I confirm the Labour and Parts section for \"([^\"]*)\"$")
    public void iConfirmTheLabourAndPartsSectionFor(String writtenOffStatus) {
        repairerJobUpdate.completeServiceReport();
        switch (writtenOffStatus) {
            case "WRITTEN OFF - PART ETA": {
                repairerJobUpdate.completeLabourAndPartsForPartEta();
                break;
            }
            case "WRITTEN OFF - UNREPAIRABLE": {
                repairerJobUpdate.completeLabourAndPartsForUnRepairable();
                break;
            }
            case "WRITTEN OFF - PNLA": {
                repairerJobUpdate.completeLabourAndPartsForPNLA();
                break;
            }
        }

        Assert.assertTrue("Unable to Verify Status as Written Off - Unrepairable", repairerJobUpdate.isRAJobStatusisSetToWrittenOff(writtenOffStatus));
    }

    @And("^I confirm the Labour and Parts section for \"([^\"]*)\" from Autohority Line Summary Page$")
    public void iConfirmTheLabourAndPartsSectionForAuthorityLineSummary(String writtenOffStatus) {
        authorityLineSummarySectionNewUI.fillServiceReport();
        switch (writtenOffStatus) {
            case "WRITTEN OFF - PART ETA": {
                repairerJobUpdate.completeLabourAndPartsForPartEta();
                break;
            }
            case "WRITTEN OFF - UNREPAIRABLE": {
                repairerJobUpdate.completeLabourAndPartsForUnRepairable();
                break;
            }
            case "WRITTEN OFF - PNLA": {
                repairerJobUpdate.completeLabourAndPartsForPNLA();
                break;
            }
        }
        base.refreshPage();
        bookingOverviewPageNewUI.clickRepairAuthoritySection();
        Assert.assertTrue("Unable to Verify Status as Written Off - Unrepairable", repairerJobUpdate.isRAJobStatusisSetToWrittenOff(writtenOffStatus));
    }

    @Then("^I confirm the Labour and charge for completing the claim with status as \"([^\"]*)\"$")
    public void iConfirmTheLabourAndChargeForCompleteingTheClaimWithStatusAs(String status) {

        try {
//            repairerJobUpdate.performRepairComplete();
            repairerJobUpdate.performRepairCompleteWithoutSerialNo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("", repairerJobUpdate.isJobCompleted());

    }

    @Then("^I confirm the Labour and charge for completing the claim with status as Remediation Work Required")
    public void iConfirmTheLabourAndChargeForCompleteingTheClaimWithStatusAsRemediationWorkRequired() {

        try {
            repairerJobUpdate.performRepairCompleteWithoutSerialNo("Remediation Work Required");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I confirm the Labour and charge for completing the claim with status as \"([^\"]*)\" with serial number updated$")
    public void iConfirmTheLabourAndChargeForCompleteingTheClaimWithSrStatusAs(String outCome) {

        try {
            repairerJobUpdate.performRepairCompleteWithSerialNo();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("", repairerJobUpdate.isJobCompleted());

    }

    @Then("^I confirm the Labour and charge for completing the claim$")
    public void iConfirmTheLabourAndChargeForCompleteingTheClaim() {

        try {
//            repairerJobUpdate.performRepairComplete();
            repairerJobUpdate.performRepairCompleteWithoutSerialNo("COMPLETE JOB");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Assert.assertTrue("",repairerJobUpdate.isJobCompleted());

    }

    /*
    Manish Kumar Jain
    Date: 11th Nov
    Scenario: Click on No Appointment booked pop up and update Labour & Charge section in Repairer Portal
     */
    @Then("^I confirm the Labour and charge for completing the Hotpoint claim$")
    public void iConfirmTheLabourAndChargeForCompleteingTheHotpointClaim() {

        try {
            repairerJobUpdate.performRepairCompleteWithoutSerialNoHotpoint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I complete job for ASV \"([^\"]*)\" with serial number updated$")
    public void iConfirmTheLabourTheClaimWithSrStatusAs(String outCome) {

        try {
            repairerJobUpdate.completeLabourAndPartsWithSerialNo();
            repairerJobUpdate.setAddAttachment();
            repairerJobUpdate.completeJobWithSerialNo();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Unable to Complete the Job", repairerJobUpdate.isJobCompleted());

    }

    @Given("I enter the plan no {string} to create a self signposted claim with {string} with ExcessAmount {string}")
    public void iEnterThePlanNoToCreateASelfSignpostedClaimWith(String planNo, String spName, String excessAmount) {
        repairerHomePage.clickNewJobBooking();
        Assert.assertTrue("Plan Search section not displayed", newRepairBookingPage.isNewRepairBookingPageDisplayed());
        seleniumHelper.captureScreeshot();
        String planNumber=null;
        GCDTemplate gcd=null;
        try {

            if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
                planNumber = planDetails.getPlanNumber();
            } else {
                commonUtils.cancelAnOpenClaim(planNo);
                planNumber = planNo;
            }
            gcd = commonUtils.getContractDetails("",planNumber.substring(0,3),planNumber.substring(3,10));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

//            newRepairBookingPage.enterDataForCreatingASelfSignpostedClaim(planNumber, "SYCAMORElxrrp", "SW19 4JS", seleniumHelper.getCurrentDate());
            newRepairBookingPage.enterDataForCreatingASelfSignpostedClaim(planNumber, gcd.Surname, gcd.PostalCode, seleniumHelper.getCurrentDate());
            Assert.assertTrue("Unable to verify Excess Alert popup",newRepairBookingPage.excessAlertPage.isExcessAlertPageDisplayed());
            Assert.assertTrue("Unable to verify Excess Alert Text Matched",newRepairBookingPage.excessAlertPage.isExcessAlertTextMatched(excessAmount));
            Assert.assertTrue("Unable to verify Excess Alert Amount Matched",newRepairBookingPage.excessAlertPage.isExcessAmountMatched(excessAmount));
            newRepairBookingPage.confirmExcessAlert();
            Assert.assertTrue("Claim creation failed", newRepairBookingPage.jobBookingSuccessfulPopup.isJobSuccessfulPopupDisplayed());
        }


    }

    @And("I click the open job created from Repairer portal")
    public void iClickTheOpenJobCreatedFromRepairerPortal() {
        newRepairBookingPage.jobBookingSuccessfulPopup.clickOpenJobButton();
    }

    @And("I verify the system notes on repairer portal to match the ExcessAmount {string}")
    public void iVerifyTheSystemNotesOnRepairerPortalToMatchTheExcessAmount(String excessAmount) {
        Assert.assertTrue("Failed to verify system notes",repairerHomePage.isExcessPaymentSystemNoteDisplayed(excessAmount));
    }

    @Then("I click the Function Menu from the homepage")
    public void iClickTheFunctionMenuFromTheHomepage() {
        repairerHomePage.clickFunctionMenu();

    }
    @Then("I click on Cancel claim to cancel the job from Function menu")
    public void iClickOnCancelClaimToCancelTheJobFromFunctionMenu() {
        repairerHomePage.clickOnCancelClaim();
    }

    @Then("I confirm the Labour and Parts charge")
    public void iConfirmTheLabourAndPartsCharge() {
        try {
            repairerJobUpdate.completeLabourAndPartsWithoutSerialNo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I complete the claim with status as \"([^\"]*)\"$")
    public void irCompleteiTheClaimWithStatusAs(String status) {

        try {
            repairerJobUpdate.completeJobProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("", repairerJobUpdate.isJobCompleted());

    }

    @Then("^I check if no Appointment exists and insert new DairyAppointment$")
    public void icheckIfNoAppointmentExistsAndInsertNewDiaryAppointment() throws Throwable {

        base.waitForPageToLoad();
        if (!repairerJobUpdate.checkIfAppointmentIsOpen()) {
            base.waitForPageToLoad();
            repairerJobUpdate.insertNewAppointment();

            base.refreshPage();
            base.waitForPageToLoad();
        }
        Assert.assertTrue("Appointment is not Open", repairerJobUpdate.checkIfAppointmentIsOpen());
    }
}