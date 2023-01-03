package com.test.steps;


import com.test.pages.*;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.pages.RepairerPortal.AppointmentDetailsPage;
import com.test.pages.RepairerPortal.RepairerHomePage;
import com.test.pages.RepairerPortal.RepairerJobUpdate;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.OrbitUtils.QuestionDatabase;
import com.test.utils.SeleniumHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(RepairerPortalStepsDef.class);

    public RepairerPortalStepsDef(BasePage basePage,
                                  SeleniumHelper seleniumHelper,
                                  RepairerHomePage repairerHomePage,
                                  RepairerJobUpdate repairerJobUpdate,
                                  AppointmentDetailsPage appointmentDetailsPage,
                                  PlanDetails planDetails) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.appointmentDetailsPage = appointmentDetailsPage;
        this.repairerHomePage = repairerHomePage;
        this.repairerJobUpdate = repairerJobUpdate;
        this.driver = basePage.getDriver();
        this.planDetails = planDetails;

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
        if (planNo.equals("CRT")) {
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
            repairerJobUpdate.insertNewAppointment();
            base.refreshPage();
            base.waitForPageToLoad();
        }
        Assert.assertTrue("Appointment is not Open",repairerJobUpdate.checkIfAppointmentIsOpen());
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
        Assert.assertTrue("Current Appointment Status not verified",repairerJobUpdate.getCurrentAppointmentStatus().contains(outCome));
    }

    @Then("^I Verify the Job Completed Status in RP is Successful for \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedStatusIsSuccessful(String outCome) {
        Assert.assertTrue("Unable to Verify Status as Written Off - Unrepairable",repairerJobUpdate.isRAJobStatusisSetToWrittenOff(outCome));
    }
    @Then("^I Verify the Job Completed Status in Diary Appiontment Section in RP is Successful for \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedDAStatusIsSuccessful(String outCome) {
        base.hardWait("2000");
        Assert.assertTrue("Unable to Verify Current Job Status",repairerJobUpdate.isCurrentJobStatusisSet(outCome));
    }


    @And("^I confirm the Labour and Parts section for \"([^\"]*)\"$")
    public void iConfirmTheLabourAndPartsSectionFor(String writtenOffStatus) {
        repairerJobUpdate.completeServiceReport();
        switch (writtenOffStatus){
            case "WRITTEN OFF - PART ETA":{
                repairerJobUpdate.completeLabourAndPartsForPartEta();
                break;
            }
            case "WRITTEN OFF - UNREPAIRABLE":{
                repairerJobUpdate.completeLabourAndPartsForUnRepairable();
                break;
            }
            case "WRITTEN OFF - PNLA":{
                repairerJobUpdate.completeLabourAndPartsForPNLA();
                break;
            }
        }

        Assert.assertTrue("Unable to Verify Status as Written Off - Unrepairable",repairerJobUpdate.isRAJobStatusisSetToWrittenOff(writtenOffStatus));
    }

    @Then("^I confirm the Labour and charge for completing the claim with status as \"([^\"]*)\"$")
    public void iConfirmTheLabourAndChargeForCompleteingTheClaimWithStatusAs(String outCome) {

        try {
//            repairerJobUpdate.performRepairComplete();
            repairerJobUpdate.performRepairCompleteWithoutSerialNo();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("",repairerJobUpdate.isJobCompleted());

    }

    /*
    Manish Kumar Jain
    Date: 11th Nov
    Scenario: Click on No Appointment booked pop up and update Labour & Charge section in Repairer Portal
     */
    @Then("^I confirm the Labour and charge for completing the Hotpoint claim$")
    public void iConfirmTheLabourAndChargeForCompleteingTheHotpointClaim() {

        try {
            repairerJobUpdate.performRepairCompleteWithoutSerialNoHotpoint("COMPLETE JOB");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}