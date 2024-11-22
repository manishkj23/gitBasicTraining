package com.test.steps;

import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.RepairInformationPage;
import com.test.pages.CCAgent_OLDUI.*;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairInformationSectionNewUIStepDef {

    private BasePage base;
    private OrbitHomePage homePage;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private MakeAClaimPage claimPage;
    private OpenJobAlertPopup openJobAlert;
    private ServiceProviderAvailabilityPopup availabilityPopup;
    private CancelClaimPage cancelClaimPage;
    private ReviewClaimPage reviewClaimPage;
    private ServiceOptionsPage serviceOptionsPage;
    private QandAProcessPage qandAProcessPage;
    private ProductConfirmationPage productConfirmationPage;
    private CallOutChargePopupPage callOutChargePopupPage;
    private PlanDetails planDetails;
    private RepairInformationPage repairInformation;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public RepairInformationSectionNewUIStepDef(BasePage basePage,
                                                SeleniumHelper seleniumHelper,
                                                OrbitHomePage homePage,
                                                MakeAClaimPage claimPage,
                                                OpenJobAlertPopup openJobAlert,
                                                CancelClaimPage cancelClaimPage,
                                                ReviewClaimPage reviewClaimPage,
                                                ServiceProviderAvailabilityPopup availabilityPopup,
                                                ServiceOptionsPage serviceOptionsPage,
                                                QandAProcessPage qandAProcessPage,
                                                ProductConfirmationPage productConfirmationPage,
                                                CallOutChargePopupPage callOutChargePopupPage,
                                                PlanDetails planDetails,
                                                RepairInformationPage repairInformation) {
        this.base = basePage;
        this.homePage = homePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.claimPage = claimPage;
        this.openJobAlert = openJobAlert;
        this.cancelClaimPage = cancelClaimPage;
        this.reviewClaimPage = reviewClaimPage;
        this.availabilityPopup = availabilityPopup;
        this.serviceOptionsPage = serviceOptionsPage;
        this.qandAProcessPage = qandAProcessPage;
        this.productConfirmationPage = productConfirmationPage;
        this.callOutChargePopupPage = callOutChargePopupPage;
        this.planDetails = planDetails;
        this.repairInformation = repairInformation;
    }


//############################################## 4th Scenario #################################################################################################################

    @Then("^I Verify the Booking Overview Page displayed for the given claimID$")
    public void i_verify_the_booking_overview_page_displayed_for_the_given_claimid() throws InterruptedException {
        repairInformation.verifyIfNewUIPageIsLoaded();
    }

    @Then("^I click on Repair Information tab and verify page loaded successfully$")
    public void i_click_on_repair_information_tab_and_verify_page_loaded_successfully() throws InterruptedException {
        repairInformation.clickOnRepairInformationTab();
        Thread.sleep(5000);

    }

    @Then("^I click and select a row having open appointment on the claim$")
    public void i_select_a_row_having_open_appointment_on_the_claim() throws InterruptedException {
        repairInformation.selectAnOpenAppointmentRow();
        Thread.sleep(2000);
    }

    @Then("^I click on Cancel button to cancel an appointment$")
    public void i_click_on_cancel_button_to_cancel_an_appointment() throws InterruptedException {
        repairInformation.clickOnCancelButton();
        Thread.sleep(2000);
    }

    @And("^I click on Yes button in cancel confirmation pop up$")
    public void i_click_on_yes_button_in_cancel_confirmation_pop_up() throws InterruptedException {
        repairInformation.clickOnYesInCancelAppointmentPopUp();
    }

    @Then("^I verify Cancel Appointment pop up loaded successfully$")
    public void i_verify_cancel_appointment_pop_up_loaded_successfully() {
        repairInformation.verifyCancelAppointmentPopUpBoxLoaded();
    }

    @Then("^I select the Completion Status from the drop down and enter notes$")
    public void i_select_the_completion_status_from_the_drop_down_and_enter_notes() throws InterruptedException {
        repairInformation.selectCompletionStatusValueAndNotes();
    }

    @And("^I click on Confirm button to cancel an appointment$")
    public void i_click_on_confirm_button_to_cancel_an_appointment() throws InterruptedException {
        repairInformation.clickOnCancelAppointmentConfirmButton();
    }

    @Then("^I verify the order cancelled pop up displayed successfully$")
    public void i_verify_the_order_cancelled_pop_up_displayed_successfully() throws InterruptedException {
        repairInformation.cancelAppointmentSuccessfulWithCloseButtonPopUp();
    }

    @Then("^I verify the Appointment Completion Status column updated with \"([^\"]*)\"$")
    public void i_verify_the_appointment_completion_status_column_updated_with_something(String appointmentCompletionStatus) throws InterruptedException {
        repairInformation.clickOnRepairInformationTab();
        Thread.sleep(4000);
        repairInformation.cancelAppointment_AppointmentCompletionStatus(appointmentCompletionStatus);
    }

//###############################################4th Scenario##############################################################################################################

    @And("^I verify the Appointment updated with new status \"([^\"]*)\"$")
    public void i_verify_the_appointment_updated_with_new_status_something(String appointmentstatus) throws InterruptedException {
        Thread.sleep(10000);
        repairInformation.verifyAppointmentOutcomeStatusAfterRebookedInRepairInformationNewUI(appointmentstatus);
    }

//############################################## Reselect an appointment - 5th Scenario #################################################################################################################

    @Then("^I click on Search Other Service Provider button and select the date from the Field Call Calendar$")
    public void i_click_on_search_other_service_provider_button_and_select_the_date_from_the_field_call_calendar() throws Throwable {
        repairInformation.clickOnSearchOtherServiceProviderButtonAndSelectAvailableDate();
        Thread.sleep(2000);
    }

    @Then("^I click on the Service Provider radio button to reselect an appointment and click on Rebook button$")
    public void i_click_on_the_service_provider_radio_button_to_reselect_an_appointment_and_click_on_rebook_button() throws Throwable {
        repairInformation.reselectServiceProviderAppointmentRadioButtonAndClickOnRebookButton();
        Thread.sleep(2000);
    }

    @And("^I verify the new Appointment booked with different Service provider in Repair Information section$")
    public void i_verify_the_new_appointment_booked_with_different_service_provider_in_repair_information_section() throws Throwable {
        Thread.sleep(8000);
        Assert.assertTrue("New service provider not updated", repairInformation.verifyNewServiceProviderNameInBookingOverviewAfterReselect());
        Thread.sleep(2000);
    }

    @Then("^I verify the status of the job changed to \"([^\"]*)\" in Booking Overview$")
    public void i_verify_the_status_of_the_job_changed_to_something_in_booking_overview(String reselectjobstatus) throws Throwable {
        Thread.sleep(8000);
        Assert.assertTrue("Review page not displayed", repairInformation.claimJobStatusBookingOverviewAfterReselectServiceProvider(reselectjobstatus));
    }

    @Then("^I verify the new claim ID created and compared with the old ClaimID \"([^\"]*)\"$")
    public void i_verify_that_the_new_claim_id_created_and_compared_with_the_old_claimid_something(String claimNo) throws InterruptedException {
        repairInformation.oldClaimIdComparedWithNewClaimId(claimNo);
        Thread.sleep(3000);
    }

    @Then("^I click on D&G Logo and navigate to Orbit homepage$")
    public void i_click_on_dg_logo_and_navigate_to_orbit_homepage() throws Throwable {
        repairInformation.clickOnDnGLogo();
        Thread.sleep(15000);
    }

    @Then("^I verify the old claim number \"([^\"]*)\" updated with status \"([^\"]*)\" in Booking Overview page$")
    public void i_verify_the_old_claim_something_updated_with_status_something_from_the_review_claim_section(String claimNo, String oldClaimIdStatus) throws Throwable {
//        Thread.sleep(3000);
//        homePage.searchForAClaimUsingClaimNo(claimNo);
//        Thread.sleep(8000);
        repairInformation.oldClaimJobReassignedStatus(oldClaimIdStatus);
        Thread.sleep(3000);
    }

    @And("^I verify the old claim closed with updated status as \"([^\"]*)\" under Appointment$")
    public void i_verify_the_old_claim_closed_with_updated_status_as_something_under_appointment(String appointmentjobstatus) throws Throwable {
        repairInformation.verifyOldClaimIdAppointmentCompletionStatusBookingOverview(appointmentjobstatus);

    }

    @Then("^I click on Search Other Service Providers and Continue and Pay Claim button$")
    public void i_click_on_search_other_service_providers_and_continue_and_pay_claim_button() throws InterruptedException {
        repairInformation.clickOnSearchOtherServiceProviderAndPayAndClaim();
    }

    @And("^I click on the Customer has confirmed to the Pay and Claim Options checkbox$")
    public void i_click_on_the_customer_has_confirmed_to_the_pay_and_claim_options_checkbox() throws InterruptedException {
        repairInformation.clickOnPayAndClaimOptionsCheckboxAndConfirmRebookButton();
    }

    @Then("^I click on Yes button in Confirm Pop Up to confirm Pay And Claim$")
    public void i_click_on_yes_button_in_confirm_pop_up_to_confirm_pay_and_claim() throws InterruptedException {
        repairInformation.clickOnPayAndClaimConfirmButton();
    }

    @Then("^I verify Pay and Claim confirmation page displayed$")
    public void i_verify_pay_and_claim_confirmation_page_displayed() throws InterruptedException {
        Thread.sleep(3000);
        repairInformation.isPayAndClaimConfirmationDisplayed();
    }

    @Then("^I click on the checkbox present in the first row of the grid$")
    public void i_click_on_the_checkbox_present_in_the_first_row_of_the_grid() throws InterruptedException {
        repairInformation.clickOnCheckboxInJobSearchGrid();
    }

    @And("^I click on View Job Details button$")
    public void i_click_on_view_job_details_button() throws InterruptedException {
        Thread.sleep(3000);
        repairInformation.clickOnViewJobDetailsButton();
    }
    @And("I verify the model {string} matched on the Repair Information")
    public void iVerifyTheModelMatchedOnTheRepairInformation(String modelNo) throws InterruptedException {
        Assert.assertTrue("Model Number not matching in Repair Information section ",repairInformation.modelNumberMatchedInRepairInformation(modelNo));
    }

    @Then("I click Go to Breakdown Claim button and I Verify the Booking Overview Page displayed for the given claimID")
    public void iClickGoToBreakdownClaimButtonAndIVerifyTheBookingOverviewPageDisplayedForTheGivenClaimID() throws InterruptedException {
        repairInformation.cliclOnGoToBreakdownCliamButton();
    }

    @Then("I click on Cancel claim to cancel the job")
    public void iClickOnCancelClaimToCancelTheJob() throws InterruptedException {
        repairInformation.clickOnCancelClaim();
        Thread.sleep(2000);
    }

    @Then("^I verify Cancel Job pop up loaded successfully$")
    public void i_verify_cancel_job_pop_up_loaded_successfully() {
        repairInformation.verifyCancelJobPopUpBoxLoaded();
    }

    @Then("^I select the Cancellation reason from the drop down and enter notes$")
    public void i_select_the_cancellation_reason_from_the_drop_down_and_enter_notes() throws InterruptedException {
        repairInformation.selectCancellationReasonValueAndNotes();
    }

    @And("I click on Cancel job button to cancel an job")
    public void iClickOnCancelJobButtonToCancelAnJob() throws InterruptedException {
        repairInformation.clickOnCancelJobButton();
    }

    @Then("I verify the Appointment Completion Status column updated with AppointmentCompletionStatus{int} and AppointmentCompletionStatus{int}\"")
    public void iVerifyTheAppointmentCompletionStatusColumnUpdatedWithAppointmentCompletionStatusAndAppointmentCompletionStatus(int arg0, int arg1) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        repairInformation.clickOnRepairInformationTab();
        Thread.sleep(4000);
        repairInformation.verifyAppointmentCompleteionStatus();
    }

    @Then("I select the Cancellation reason from the drop down and enter notes from pccs portal")
    public void iSelectTheCancellationReasonFromTheDropDownAndEnterNotesFromPccsPortal() throws InterruptedException {
        repairInformation.selectCancellationReasonValuefromdropdownAndNotes();

    }

    @And("I verify CX Appliance Usable field and flag is displayed on Repairer Information page")
    public void iVerifyCXApplianceUsableFieldAndFlagIsDisplayedOnRepairerInformationPage() {
        Assert.assertTrue("Unable to verify CX Appliance usable field", repairInformation.isCXApplianceUsableFieldDisplayed());
        repairInformation.ifCXApplianceUsableIsYes();
    }

    @Then("I verify SN is displayed with valid SN")
    public void iVerifySNIsDisplayedWithValidSN() throws InterruptedException {
        Thread.sleep(3000);
        repairInformation.ifSNisDisplayed();
    }

    @And("I click on Service Option tab and verify page loaded successfully")
    public void iClickOnServiceOptionTabAndVerifyPageLoadedSuccessfully()throws InterruptedException {
        repairInformation.clickOnServiceOptionTab();
        Thread.sleep(5000);

    }

    @Then("I verify rule column and view rule hyperlink is displayed on the service option table")
    public void iVerifyRuleColumnAndViewRuleHyperlinkIsDisplayedOnTheServiceOptionTable() {
        repairInformation.verifyRuleandViewRuleHyperLink();
    }

    @Then("I click on view rule hyperlink and verify the {string}is displayed")
    public void iClickOnViewRuleHyperlinkAndVerifyTheIsDisplayed(String allocationruleID) {
        repairInformation.verifyAllocationandOverFlowRuleID(allocationruleID);
        repairInformation.clickOnTheCloseButton();
    }

    @Then("I click Reselect Service option and confirm the reselect service option popup")
    public void iClickReselectServiceOptionAndConfirmTheReselectServiceOptionPopup() throws InterruptedException {
        repairInformation.clickAndConfirmReselectServiceOption();
    }

    @Then("I verify ViewRule button is displayed on Review claim page")
    public void iVerifyViewRuleButtonIsDisplayedOnReviewClaimPage() {
        Assert.assertTrue("View rules button not displayed",repairInformation.isViewRuleButtonDisplayed());
    }

    @And("I click on ViewRule button and verify RuleTable is displayed before selecting a Service Option on Review Claim Page")
    public void iClickOnViewRuleButtonAndVerifyRuleTableIsDisplayedBeforeSelectingAServiceOptionOnReviewClaimPage() {
        repairInformation.clickOnViewRule();
        repairInformation.verifyRuleTableIsDisplayedBeforeSelectingAServiceOption();
    }

    @Then("I verify {string} on RuleTable before selecting a Service Option on Review Claim page")
    public void iVerifyOnRuleTableBeforeSelectingAServiceOptionOnReviewClaimPage(String ruleID) {
        repairInformation.verifyallocationRuleIDandServiceOption(ruleID);
    }

    @And("I click continue on Checkout Process popup window On Review Claim Page to confirm the Service Provider Reselection")
    public void iClickContinueOnCheckoutProcessPopupWindowOnReviewClaimPageToConfirmTheServiceProviderReselection() {
        repairInformation.clickOnConfirmForCheckoutProcess();
    }

    @Then("I Verify the Appointment Completion Status as {string}")
    public void i_verify_the_appointment_completion_status_as(String apptCompStatus) {
        Assert.assertTrue("Appointment Completion status is not updated as " +apptCompStatus,repairInformation.verifyAppointmentCompleteionStatusAs(apptCompStatus));
    }

    @Then("I get the product purchase date")
    public void I_get_the_product_purchase_date () {
        repairInformation.getProductPurchaseDate();
    }

}


