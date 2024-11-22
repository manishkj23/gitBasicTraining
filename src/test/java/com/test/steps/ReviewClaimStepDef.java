package com.test.steps;


import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewPage;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanHistory.PlanHistoryPage;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgent_OLDUI.ClaimAnalysisPage;
import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.CCAgent_OLDUI.ReciperoView.ReciperoViewPage;
import com.test.pages.CCAgent_OLDUI.ReviewClaimPage;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class ReviewClaimStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private ReviewClaimPage reviewClaim;
    private ClaimAnalysisPage claimAnalysis;
    private OrbitHomePage homePage;
    private ReciperoViewPage reciperoViewPage;
    private BookingOverviewPage bookingOverviewPage;
    private PlanViewPageNPV planViewPageNPV;
    private PlanDetails planDetails;
    private PlanHistoryPage planHistoryPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClaimStepDef.class);

    public ReviewClaimStepDef(BasePage basePage, SeleniumHelper seleniumHelper, ReviewClaimPage reviewClaim,
                              ClaimAnalysisPage claimAnalysis, OrbitHomePage homePage, ReciperoViewPage reciperoViewPage,
                              BookingOverviewPage bookingOverview, PlanViewPageNPV planViewPageNPV,  PlanDetails planDetails, PlanHistoryPage planHistoryPage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.reviewClaim = reviewClaim;
        this.claimAnalysis = claimAnalysis;
        this.homePage = homePage;
        this.reciperoViewPage = reciperoViewPage;
        this.bookingOverviewPage = bookingOverview;
        this.planViewPageNPV = planViewPageNPV;
        this.planDetails = planDetails;
        this.planHistoryPage = planHistoryPage;
    }


    @Then("^I verify the Appointment booked successfully from the Review claim section$")
    public void iVerifyTheAppointmentBookedSuccessfullyFromTheReviewClaimSection() {
        Assert.assertTrue("Review Claim Page not loaded", reviewClaim.isReviewClaimJobStatusDisplayed());
    }

    @Given("^I'm on the Review Claim Page on CC Agent Portal$")
    public void iMOnTheReviewClaimPageOnCCAgentPortal() {
        reviewClaim.checkAndCloseAnyPopupDisplayed();

    }

    @Then("^I verify the CustomerCommunications messages are generated$")
    public void iVerifyTheCustomerCommunicationsMessagesAreGenerated() {
        Assert.assertTrue("Customer Communications Email section not loaded", reviewClaim.isCustomerCommunicationsEmailSectionDisplayed());
        Assert.assertTrue("Customer Communications SMS section not loaded", reviewClaim.isCustomerCommunicationsSmsSectionDisplayed());
    }

    @Then("^I verify the CustomerCommunications messages on New Plan View are generated$")
    public void iVerifyTheCustomerCommunicationsMessagesAreGeneratedNPV() {
        Assert.assertTrue("Customer Communications Email section not loaded", reviewClaim.isCustomerCommunicationsEmailSectionDisplayed());
        Assert.assertTrue("Customer Communications SMS section not loaded", reviewClaim.isCustomerCommunicationsSmsSectionDisplayed());
    }

    @Then("^I process the Claim to WrittenOff with the status as \"([^\"]*)\"$")
    public void iProcessTheClaimToWrittenOffWithTheStatusAs(String writtenOffStatus) throws Throwable {
        reviewClaim.processWrittenOff(writtenOffStatus);
        Assert.assertTrue(writtenOffStatus + " - Not Verified", reviewClaim.isReviewClaimJobStatusDisplayed(writtenOffStatus));
    }

    @Then("^I verify and confirm that einvoice cost matches Claim Analysis section$")
    public void iVerifyAndConfirmThatEinvoiceCostMatchesClaimAnalysisSection() {
        base.waitForPageToLoad();
        homePage.clickReviewClaimTab();
        String serviceCost = seleniumHelper.removeWhiteSpaces(reviewClaim.getServiceCostValue());
        homePage.clickClaimAnalysisTab();
        String claimTotalCost = seleniumHelper.removeWhiteSpaces(claimAnalysis.getTotalCostValue());
        Assert.assertTrue("Einvoice Amount not Verified", serviceCost.equals(claimTotalCost));
        homePage.clickReviewClaimTab();
    }

    @Then("^I verify the Status Changes are logged in ORB when Status Changes in RP$")
    public void iVerifyTheStatusChangesAreLoggedInORBWhenStatusChangesInRP() {
//        homePage.clickReviewClaimTab();
        Assert.assertTrue("Status Changes not Verified", reviewClaim.isStatusChangesUpdated());
    }

    @Then("^I verify the new status's are logged in ORB under Request Authorisation, when changes are made to RP$")
    public void iVerifyTheNewStatusSAreLoggedInORBUnderRequestAuthorisationWhenChangesAreMadeToRP() {
        Assert.assertTrue("RA Status Changes not verified", reviewClaim.isRAHistoryStatusChangesUpdated());
    }

    @Then("^I Confirm that system notes display correctly and user can add a note in ORB$")
    public void iConfirmThatSystemNotesDisplayCorrectlyAndUserCanAddANoteInORB() {
        Assert.assertTrue("System Noted added successfully", reviewClaim.addAndVerifyNewSystemNotesAdded());
    }

    @Then("^I Confirm that fault code is updated in ORB when updated in RP$")
    public void iConfirmThatFaultCodeIsUpdatedInORBWhenUpdatedInRP() {
        Assert.assertTrue("Fault section updated successfully", reviewClaim.isFaultSectionUpdated());
    }

    @Then("^I Confirm that workflow status is updated in ORB when updated in RP$")
    public void iConfirmThatWorkflowStatusIsUpdatedInORBWhenUpdatedInRP() {
        Assert.assertTrue("Workflow Status Updated ", reviewClaim.isWokflowStatusUpdated());
    }

    @Then("^I Confirm that Job Completion status is updated in ORB when updated in RP$")
    public void iConfirmThatJobCompletionStatusIsUpdatedInORBWhenUpdatedInRP() {
        Assert.assertTrue("Job Completed Status Updated", reviewClaim.isJobCompletionStatusInWorkflowUpdated());
    }

    @Then("^I process the Claim to WrittenOff with the status as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iProcessTheClaimToWrittenOffWithTheStatusAsAnd(String writtenOffStatus, String additionalStatus) throws Throwable {
        reviewClaim.processWrittenOff(writtenOffStatus);
        Assert.assertTrue(writtenOffStatus + " - Not Verified", reviewClaim.isReviewClaimJobStatusDisplayed(writtenOffStatus, additionalStatus));
    }

    @Then("^I verify the claim status is as CLAIM ON HOLD$")
    public void iVerifyTheClaimStatusIsAsCLAIMONHOLD() {
        Assert.assertTrue("Unable to Verify CLAIM ON HOLD", reviewClaim.isClaimOnHoldInRAHistoryTab());
    }

    @Then("^I Verify the job has been booked with serviceProvider \"([^\"]*)\"$")
    public void iVerifyTheJobHasBeenBookedWithServiceProvider(String spName) {
        Assert.assertTrue("Unable to verify the Service Provider name ", reviewClaim.isServiceProviderNameDisplayed(spName));
    }

    @Then("^I Verify the service Provider Job No is different from the current claim number$")
    public void iVerifyTheServiceProviderJobNoIsDifferentFromTheCurrentClaimNumber() {
        Assert.assertTrue("Unable to verify the Service Provider Job Number ", reviewClaim.isServiceProviderJobisDifferentFromClaimNo());
    }


    @Then("^I click recipero view on the review claim page$")
    public void iClickReciperoViewOnTheReviewClaimPage() {
        reviewClaim.clickReciperoViewIcon();
        Assert.assertTrue("Unable to load the ReciperoViewPage", reciperoViewPage.isReciperoViewPageDisplayed());
    }

    /*Manish Kumar Jain: Dated - 17th Nov 2021
    Scenario: Rebook an appointment with same Service Provider for Whirlpool Plan in Old UI
     */

    @Then("^I Verify the Review Claim Page displayed for the given claimID$")
    public void i_verify_the_review_claim_page_displayed_for_the_given_claimid() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Review page not displayed", reviewClaim.isReviewClaimJobStatusDisplayed());
    }

    @Then("^I click on Dairy Appointment from the Review Claim page$")
    public void i_click_on_dairy_appointment_from_the_review_claim_page() throws InterruptedException {
        Thread.sleep(3000);
        reviewClaim.clickOnDiaryAppointmentArrow();
    }

    @And("^I click on Find New Appointment button to Rebook or Reselect an appointment$")
    public void i_click_on_find_new_appointment_button_to_rebook_reselect_an_appointment() {
        reviewClaim.clickOnFindNewAppointmentButton();
    }

    @And("^I verify Find New Appointment pop up with the calendar displayed$")
    public void i_verify_find_new_appointment_pop_up_with_the_calendar_displayed() {
        reviewClaim.clickOnStartAppointmentSearchFindNewAppointmentPopUpAndVerifyCalendarToRebook();
    }

    @Then("^I select the Available date and specific timeslot and click on Confirm Rebooking button$")
    public void i_select_the_available_date_and_specific_timeslot() throws InterruptedException {
        reviewClaim.selectFifthAvailableAppointmentDateAndConfirmRebookButton();
    }

    @And("^I click on Confirm button in Confirm Rebooking Pop up box$")
    public void i_click_on_confirm_button_in_confirm_rebooking_pop_up_box() throws InterruptedException {
        reviewClaim.finalConfirmRebookingPopUpDisplayAndConfirmButton();
        Thread.sleep(5000);
    }

    @Then("^I verify the status of the job changed to \"([^\"]*)\"$")
    public void i_verify_the_status_of_the_job_changed_to_something(String claimJobStatus) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(10000);
        reviewClaim.claimJobStatusDisplayedAfterRebooked(claimJobStatus);
        Thread.sleep(5000);
    }

    @And("^I verify the old Appointment updated with status \"([^\"]*)\"$")
    public void i_verify_the_old_appointment_updated_with_status_as_something(String appointmentstatus) throws InterruptedException {
        Thread.sleep(10000);
        reviewClaim.verifyAppointmentOutcomeStatusAfterRebooked(appointmentstatus);
    }

    /*Name: Manish Kumar Jain
    Whirlpool CR - SRV 8027 Rebook an Appointment
    Scenario: Reselect an appointment with different SP from orbit by CC Agent team for Whirlpool plan
    */

    @Then("^I click on Search Other Service Provider button and select the Available date from the Field Call Calendar$")
    public void i_click_on_search_other_service_provider_button_and_select_the_Available_date_from_the_Field_Call_Calendar() throws InterruptedException {
        reviewClaim.clickOnSearchOtherServiceProviderButtonAndSelectAvailableDate();
        Thread.sleep(3000);
    }

    @And("^I select the Service Provider radio button to reselect an appointment and click on Rebook button$")
    public void i_select_the_service_provider_radio_button_to_reselect_an_appointment_and_click_on_Rebook_button() throws InterruptedException {
        Thread.sleep(2000);
        reviewClaim.selectAvailableServiceProviderRadioButtonAndClickOnRebookButton();
    }

    @Then("^I verify Alert pop up and click on Yes button in Confirmation Alert pop up box$")
    public void I_verify_Alert_pop_up_and_click_on_Yes_button_in_Confirmation_Alert_pop_up_box() throws InterruptedException {
        reviewClaim.verifyAlertPopUpAndClickOnYesButton();
        Thread.sleep(35000);
    }

    @And("^I verify the new Appointment booked with different Service provider from the Review claim section$")
    public void i_verify_the_new_appointment_booked_with_different_service_provider_from_the_review_claim_section() throws InterruptedException {
        Thread.sleep(8000);
        Assert.assertTrue("Review page not displayed", reviewClaim.verifyNewServiceProviderNameInReviewClaimAfterReselect());
    }

    @Then("^I verify the status of the Job \"([^\"]*)\" after Reselection$")
    public void i_verify_the_status_of_the_job_changed_with_something_after_reselection(String reselectJobStatus) throws Throwable {
        Thread.sleep(8000);
        Assert.assertTrue("Review page not displayed", reviewClaim.claimJobStatusDisplayedAfterReselectServiceProvider(reselectJobStatus));
    }

    @Then("^I verify that the new claim ID created and compared with the old ClaimID \"([^\"]*)\"$")
    public void i_verify_that_the_new_claim_id_created_and_compared_with_the_old_claimid_something(String claimNo) throws InterruptedException {
        reviewClaim.oldClaimIdComparedWithNewClaimId(claimNo);
        Thread.sleep(3000);
    }

    @Then("^I verify the old claim \"([^\"]*)\" updated with status \"([^\"]*)\" from the Review Claim section$")
    public void i_verify_the_old_claim_something_updated_with_status_something_from_the_review_claim_section(String claimNo, String reviewClaimStatus) throws InterruptedException {
        Thread.sleep(5000);
        reviewClaim.clickOnDAndGLogo();
        Thread.sleep(5000);
        if (claimNo.isEmpty() || claimNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingClaimNo(planDetails.getClaimNumber());
        } else {
            homePage.searchForAClaimUsingClaimNo(claimNo);
        }

        Thread.sleep(3000);
        reviewClaim.oldClaimJobReassignedStatus(reviewClaimStatus);
    }

    @And("^I verify the old claim closed with updated status as \"([^\"]*)\" under Diary Appointment$")
    public void i_verify_the_old_claim_closed_with_updated_status_as_something_under_diary_appointment(String appointmentJobStatus) throws InterruptedException {
        Thread.sleep(3000);
        reviewClaim.clickOnReviewClaimTab();
        Thread.sleep(2000);
        reviewClaim.clickOnDiaryAppointmentArrow();
        Thread.sleep(2000);
        reviewClaim.validateDiaryAppointmentJobReassignedStatus(appointmentJobStatus);
    }

    @Then("^I verify Review Claim Page displayed$")
    public void i_verify_review_claim_page_displayed() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        base.clickOutside();
        Thread.sleep(3000);
        Assert.assertTrue("Unable to verify the Booking Overview Header Title", bookingOverviewPage.isBookingOverviewHeaderDisplayed());
    }

    @And("I verify the Repair Paused pop-up being displayed")
    public void iVerifyTheRepairPausedPopUpBeingDisplayed() {
        Assert.assertTrue("Unable to Verify Repair Paused pop-up being displayed", reviewClaim.repairPausedPopUpBeingDisplayed());
    }

    @Then("I Click on the close button")
    public void iClickOnTheCloseButton() {
        Assert.assertTrue("Unable to Click on the close button", reviewClaim.clickOnTheCloseButton());
    }

    @Then("I Click on the click here link")
    public void iClickOnTheClickHereLink() {
        Assert.assertTrue("Unable to Click on the click here link", reviewClaim.clickOnTheClickhereLink());
    }

    @Then("I Verify Repair Paused Toaster Message being displayed")
    public void iVerifyRepairPausedToasterMessageBeingDisplayed() {
        Assert.assertTrue("Unable to Verify Repair Paused Toaster Message being displayed", reviewClaim.repairPausedToasterMessageBeingDisplayed());

    }

    @Then("I verify the model {string} matched on the review claim page")
    public void iVerifyTheModelMatchedOnTheReviewClaimPage(String modelNo) throws InterruptedException {
        Assert.assertTrue("Model Number not matched in the Review claim page",reviewClaim.modelNumberMatchedInReviewClaimPage(modelNo));
    }

    @Then("I verify Customer HTW field is present in Booking overview")
    public void i_verify_customer_htw_field_is_present_in_booking_overview() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Customer Happy to Wait field is not present",reviewClaim.verifyHappyToWaitFieldInBookingOverviewDisplayed());
    }

    @Then("I verify Edit button is enable and clickable")
    public void i_verify_edit_button_is_enable_and_clickable() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Customer Happy to Wait field is not present",reviewClaim.verifyHappyToWaitButtonInBookingOverviewAndClickable());
    }

    @Then("I verify Customer Happy To Wait pop up launched")
    public void i_verify_customer_happy_to_wait_pop_up_launched() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("Customer Happy to Wait pop up not displayed",reviewClaim.verifyCustomerHappyToWaitPopUpDisplayed());
    }

    @Then("I click on Yes button and select Customer HTW date from date picker")
    public void i_click_on_yes_button_and_select_Customer_HTW_date_from_date_picker() throws InterruptedException {
        Thread.sleep(2000);
        reviewClaim.clickOnYesButtonAndSelectDateAndSave();
    }

    @Then("I verify Customer HTW updated with Yes flag in Review Claim page")
    public void i_verify_customer_htw_updated_with_yes_flag_in_review_claim_page() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("CCA having issue while updating the HTW flag", reviewClaim.verifyHtwFlagUpdatedInReviewClaimPage());
    }

    @And("I verify the new \"([^\"]*)\" updated in Review Claim Page")
    public void iVerifyTheNewClaimTypeUdatedInReviewClaimPage(String claimType) throws InterruptedException {
        Assert.assertTrue("Claim Type OOR is not updated in the Review claim page",reviewClaim.verifyClaimTypeNameIdInReviewClaimPage(claimType));

    }

    @And("I click on the Plan No link")
    public void I_click_on_the_Plan_No_link ()
    {
        reviewClaim.clickOnPlanNoLink();
        base.navigateToRecentTab();
        base.waitForPageToLoad();
        base.hardWait("2000");
    }

    @Then("^I verify that the new claim ID created and compared with the old ClaimID \"([^\"]*)\" in the Review Claim page$")
    public void i_verify_that_the_new_claim_id_created_and_compared_with_the_old_claimid_in_the_Review_Claim_page(String claimNo) throws InterruptedException {

        if (claimNo.isEmpty() || claimNo.contains("CREATE_NEW_PLAN")) {
            reviewClaim.compareOldClaimIdWithNewClaimId(planDetails.getClaimNumber());
        } else {
            reviewClaim.compareOldClaimIdWithNewClaimId(claimNo);
        }
    }

    @Then("I click on the Claim No link from the popup")
    public void i_click_on_the_cliam_no_link_from_the_popup() {
        planViewPageNPV.bookingOverviewPage.clickOnClaimNoLink();

        base.navigateToRecentTab();
        base.waitForPageToLoad();
        base.hardWait("2000");
    }

    @Then("I verify the claim status in Review Claim page as {string}")
    public void i_verify_the_claim_status_in_review_claim_page_as(String status) {
        base.hardWait("5000");
        Assert.assertTrue("Claim status is not updated", planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(status));
    }

    @Then("click on the Remedial Work Complete link")
    public void click_on_the_remedial_work_complete_link() {
        planViewPageNPV.bookingOverviewPage.clickOnRemedialWorkCompleteIcon();
    }

    @Then("I enter Notes as {string} and click on Submit button")
    public void i_enter_notes_as_and_click_on_submit_button(String notes) {
        planViewPageNPV.bookingOverviewPage.completeRemedialWorkCompletePopup(notes);
    }

    @Then("I Verify the System note with type {string} added as {string}")
    public void i_verify_the_System_note_with_Type_added_as(String noteType, String note) {
        Assert.assertTrue("System note is not updated as " +note,planViewPageNPV.bookingOverviewPage.reviewClaimPage.verifySystemNoteWithTypeAs(noteType, note));
    }

    @And("I verify Find New Appointment pop up with the calendar displayed for Beko")
    public void iVerifyFindNewAppointmentPopUpWithTheCalendarDisplayedForBeko() {
        reviewClaim.clickOnStartAppointmentSearchFindNewAppointmentPopUpAndVerifyCalendarToRebookForBeko();
    }

}




