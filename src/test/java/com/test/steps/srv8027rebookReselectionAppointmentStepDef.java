package com.test.steps;

import com.test.pages.*;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.OrbitUtils.QuestionDatabase;
import com.test.utils.SeleniumHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class srv8027rebookReselectionAppointmentStepDef {

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
    private QuestionDatabase qaUtil;
    private PlanDetails planDetails;
    private Srv8027WhirlpoolRebookingAndReselection rebookingAndReselection;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public srv8027rebookReselectionAppointmentStepDef(BasePage basePage,
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
                                       QuestionDatabase qaUtil,
                                       PlanDetails planDetails,
                                       Srv8027WhirlpoolRebookingAndReselection rebookingAndReselection) {
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
        this.qaUtil = qaUtil;
        this.planDetails = planDetails;
        this.rebookingAndReselection=rebookingAndReselection;
    }

    /*Name: Manish Kumar Jain: 12th July, 2021
    Whirlpool CR - SRV 8027 Rebook an Appointment
    Scenario: Whirlpool Rebooking flow from orbit by CC Agent team
    */

    @Given("^I enter claim number \"([^\"]*)\" and click search button for Whirlpool OEM$")
    public void i_enter_claim_number_and_click_search_button_for_Whirlpool_OEM(String ClaimNo) throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.searchForAClaimUsingClaimNo(ClaimNo);
    }

    @Given("^I enter Plan number \"([^\"]*)\" and click search button in Track Repair or Claim$")
    public void i_enter_plan_number_something_and_click_search_button_in_track_repair_or_claim(String PlanNo) throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.searchForAClaimUsingPlanNo(PlanNo);
    }

    @Then("^I click on the checkbox present in the first row of the grid$")
    public void i_click_on_the_checkbox_present_in_the_first_row_of_the_grid() throws InterruptedException {
        rebookingAndReselection.clickOnCheckboxInJobSearchGrid();
    }

    @And("^I click on View Job Details button and verify Review Claim Page displayed$")
    public void i_click_on_view_job_details_button_and_verify_review_claim_page_displayed() throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.clickOnViewJobDetailsButton();
        Thread.sleep(3000);
        Assert.assertTrue("Unable to verify the Booking Overview Header Title",rebookingAndReselection.isBookingOverviewHeaderDisplayed());
    }

    @Then("^I verify Review Claim Page displayed$")
    public void i_verify_review_claim_page_displayed() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        base.clickOutside();
        Thread.sleep(3000);
        Assert.assertTrue("Unable to verify the Booking Overview Header Title",rebookingAndReselection.isBookingOverviewHeaderDisplayed());
    }

    @And("^I click on View Job Details button$")
    public void i_click_on_view_job_details_button() throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.clickOnViewJobDetailsButton();
        }

    @Then("^I Verify the Review Claim Page displayed for the given claimID$")
    public void i_verify_the_review_claim_page_displayed_for_the_given_claimid() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Review page not displayed",reviewClaimPage.isReviewClaimJobStatusDisplayed());
    }

    @Then("^I click on Dairy Appointment from the Review Claim page$")
    public void i_click_on_dairy_appointment_from_the_review_claim_page() throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.clickOnDiaryAppointmentArrow();
    }

    @And("^I click on Find New Appointment button to Rebook or Reselect an appointment$")
    public void i_click_on_find_new_appointment_button_to_rebook_reselect_an_appointment(){
        rebookingAndReselection.clickOnFindNewAppointmentButton();
    }

    @And("^I verify Find New Appointment pop up with the calendar displayed$")
    public void i_verify_find_new_appointment_pop_up_with_the_calendar_displayed(){
        rebookingAndReselection.clickOnStartAppointmentSearchFindNewAppointmentPopUpAndVerifyCalendarToRebook();
    }

    @Then("^I select the Available date and specific timeslot and click on Confirm Rebooking button$")
    public void i_select_the_available_date_and_specific_timeslot() throws InterruptedException {
        rebookingAndReselection.selectNinethAvailableAppointmentDateAndConfirmRebookButton();
    }

    @And("^I click on Confirm button in Confirm Rebooking Pop up box$")
    public void i_click_on_confirm_button_in_confirm_rebooking_pop_up_box() throws InterruptedException {
        rebookingAndReselection.finalConfirmRebookingPopUpDisplayAndConfirmButton();
        Thread.sleep(5000);
    }

    @Then("^I verify the status of the job changed to \"([^\"]*)\"$")
    public void i_verify_the_status_of_the_job_changed_to_something(String claimJobStatus) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(10000);
        rebookingAndReselection.claimJobStatusDisplayedAfterRebooked(claimJobStatus);
        Thread.sleep(5000);
        }

    @And("^I verify the old Appointment updated with status \"([^\"]*)\"$")
    public void i_verify_the_old_appointment_updated_with_status_as_something(String appointmentstatus) throws InterruptedException {
        Thread.sleep(10000);
        rebookingAndReselection.verifyAppointmentOutcomeStatusAfterRebooked(appointmentstatus);
    }

    /*Name: Manish Kumar Jain
    Whirlpool CR - SRV 8027 Rebook an Appointment
    Scenario: Reselect an appointment with different SP from orbit by CC Agent team for Whirlpool plan
    */

    @Then("^I click on Search Other Service Provider button and select the Available date from the Field Call Calendar$")
    public void i_click_on_search_other_service_provider_button_and_select_the_Available_date_from_the_Field_Call_Calendar() throws InterruptedException {
        rebookingAndReselection.clickOnSearchOtherServiceProviderButtonAndSelectAvailableDate();
        Thread.sleep(3000);
    }

    @And("^I select the Service Provider radio button to reselect an appointment and click on Rebook button$")
    public void i_select_the_service_provider_radio_button_to_reselect_an_appointment_and_click_on_Rebook_button() throws InterruptedException {
        Thread.sleep(2000);
        rebookingAndReselection.selectAvailableServiceProviderRadioButtonAndClickOnRebookButton();
    }

    @Then("^I verify Alert pop up and click on Yes button in Confirmation Alert pop up box$")
    public void I_verify_Alert_pop_up_and_click_on_Yes_button_in_Confirmation_Alert_pop_up_box() throws InterruptedException {
        rebookingAndReselection.verifyAlertPopUpAndClickOnYesButton();
        Thread.sleep(35000);
    }

    @And("^I verify the new Appointment booked with different Service provider from the Review claim section$")
    public void i_verify_the_new_appointment_booked_with_different_service_provider_from_the_review_claim_section() throws InterruptedException
    {
        Thread.sleep(8000);
        Assert.assertTrue("Review page not displayed",rebookingAndReselection.verifyNewServiceProviderNameInReviewClaimAfterReselect());
    }

    @Then("^I verify the status of the Job \"([^\"]*)\" after Reselection$")
    public void i_verify_the_status_of_the_job_changed_with_something_after_reselection(String reselectJobStatus) throws Throwable {
        Thread.sleep(8000);
        Assert.assertTrue("Review page not displayed",rebookingAndReselection.claimJobStatusDisplayedAfterReselectServiceProvider(reselectJobStatus));
    }

    @Then("^I verify that the new claim ID created and compared with the old ClaimID \"([^\"]*)\"$")
    public void i_verify_that_the_new_claim_id_created_and_compared_with_the_old_claimid_something(String claimNo) throws InterruptedException {
        rebookingAndReselection.oldClaimIdComparedWithNewClaimId(claimNo);
        Thread.sleep(3000);
    }

    @Then("^I verify the old claim \"([^\"]*)\" updated with status \"([^\"]*)\" from the Review Claim section$")
    public void i_verify_the_old_claim_something_updated_with_status_something_from_the_review_claim_section(String claimNo, String reviewClaimStatus) throws InterruptedException {
        Thread.sleep(5000);
        rebookingAndReselection.clickOnDAndGLogo();
        Thread.sleep(3000);
        homePage.searchForAClaimUsingClaimNo(claimNo);
        Thread.sleep(3000);
        rebookingAndReselection.oldClaimJobReassignedStatus(reviewClaimStatus);
    }

    @And("^I verify the old claim closed with updated status as \"([^\"]*)\" under Diary Appointment$")
    public void i_verify_the_old_claim_closed_with_updated_status_as_something_under_diary_appointment(String appointmentJobStatus) throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.clickOnReviewClaimTab();
        Thread.sleep(2000);
        rebookingAndReselection.clickOnDiaryAppointmentArrow();
        Thread.sleep(2000);
        rebookingAndReselection.validateDiaryAppointmentJobReassignedStatus(appointmentJobStatus);
    }

    @Then("^I verify Pay and Claim confirmation page displayed$")
    public void i_verify_pay_and_claim_confirmation_page_displayed() throws InterruptedException {
        Thread.sleep(3000);
        rebookingAndReselection.isPayAndClaimConfirmationDisplayed();
    }






























}
