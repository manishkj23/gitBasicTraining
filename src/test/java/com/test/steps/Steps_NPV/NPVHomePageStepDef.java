package com.test.steps.Steps_NPV;


import com.test.pages.CCAgentUI_CCV.BookingOverviewPage;
import com.test.pages.CCAgentUI_NPV.BookingConfirmedPage;
import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.ClaimPaymentRequired;
import com.test.pages.CCAgentUI_NPV.HomePageNPV;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationPNC;
import com.test.pages.ReviewClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NPVHomePageStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private PlanDetails planDetails;
    private CommonUtils commonUtils;
    private HomePageNPV homePageNPV;
    private PlanViewPageNPV planViewPageNPV;
    private BookingOverviewPage bookingOverviewPage;
    private ReviewClaimPage reviewClaim;
    private ProductConfirmationPNC productConfirmationPNC;
    private BookingConfirmedPage bookingConfirmedPage;
    private ClaimPaymentRequired claimPaymentRequired;


    private static final Logger LOGGER = LoggerFactory.getLogger(NPVHomePageStepDef.class);

    public NPVHomePageStepDef(BasePage basePage,
                              SeleniumHelper seleniumHelper,
                              HomePageNPV homePageNPV,
                              CommonUtils commonUtils,
                              PlanDetails planDetails,
                              PlanViewPageNPV planViewPageNPV,
                              BookingOverviewPage bookingOverviewPage,
                              ReviewClaimPage reviewClaim,
                              ProductConfirmationPNC productConfirmationPNC,
                              BookingConfirmedPage bookingConfirmedPage,
                              ClaimPaymentRequired claimPaymentRequired) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.planDetails = planDetails;
        this.commonUtils = commonUtils;
        this.homePageNPV = homePageNPV;
        this.planViewPageNPV = planViewPageNPV;
        this.bookingOverviewPage = bookingOverviewPage;
        this.reviewClaim = reviewClaim;
        this.productConfirmationPNC = productConfirmationPNC;
        this.bookingConfirmedPage = bookingConfirmedPage;
        this.claimPaymentRequired = claimPaymentRequired;

    }


    @When("^I verify the claim page is opened when I click the recent Claim number on Booking Overview page$")
    public void iVerifyTheClaimPageIsOpenedWhenIClickTheRecentClaimNumberOnBookingOverviewPage() {
        Assert.assertTrue("Unable to verify the Plan view page",planViewPageNPV.isPageHeaderTitleDisplayed());
        planViewPageNPV.clickCurrentClaimNumber();
        base.switchToNextTab();
        base.waitForPageToLoad();
        Assert.assertTrue("Claim View Page displayed",bookingOverviewPage.isBookingOverviewSectionDisplayed());
    }

    @Then("^I click on customer communications section on the New Plan View$")
    public void iClickOnCustomerCommunicationsSectionOnTheNewPlanView() {
        bookingOverviewPage.clickCustomerCommunicationsSection();
    }


    @Then("^I verify customer communications section on the New Plan View is displayed$")
    public void iClickOnCustomerCommunicationsSectionOnTheNewPlanViewdisplayed() {
        Assert.assertTrue("Customer Communications Email section not loaded",reviewClaim.isCustomerCommunicationsEmailSectionDisplayed());
        Assert.assertTrue("Customer Communications SMS section not loaded",reviewClaim.isCustomerCommunicationsSmsSectionDisplayed());

    }

    @Then("^I click on \"([^\"]*)\" section on the New Plan View$")
    public void iClickOnSectionOnTheNewPlanView(String menuItem) {
        bookingOverviewPage.clickLeftMenuItem(menuItem);
    }

    @Then("^I verify the new plan view page displayed$")
    public void iVerifyTheNewPlanViewPageDisplayed() {
        Assert.assertTrue("Unable to Verify Plan View Header",homePageNPV.isNewPlanViewHeaderLoaded());
    }

    @When("^I select the Claim Type as \"([^\"]*)\"$")
    public void iSelectTheClaimTypeAs(String claimType) throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue("ClaimType is not Enabled : " + claimType,homePageNPV.isClaimTypeEnabled(claimType));
        homePageNPV.selectClaimType(claimType);
        Thread.sleep(5000);
    }

    @And("^I enter the contact info$")
    public void iEnterTheContactInfo() {
        planViewPageNPV.confirmContactInformation();
    }

    @When("^I enter the PNC Details$")
    public void iEnterThePNCDetails1() {
        planViewPageNPV.productConfirmationPNC.enterPNCDetails();
    }

    @Then("^I verify the Booking Confirmed Page is displayed for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheBookingConfirmedPageIsDisplyed(String claimType, String spName) {
        Assert.assertTrue("Unable to verify ClaimNumber",bookingConfirmedPage.isClaimNumberDisplayed());
        Assert.assertTrue("Unable to verify the REPAIRER INFO",bookingConfirmedPage.isRepairerDisplayed(spName));
        Assert.assertTrue("Unable to verify the REPAIRER REFERENCE",bookingConfirmedPage.isRepairReferenceDisplayed());
        Assert.assertTrue("Unable to verify the Button Go to Claim ",bookingConfirmedPage.isGotoClaimButtonDisplayed(claimType));
    }

    @And("^I waive off the Excess Pay for New Plan View$")
    public void iWaiveOffTheExcessPayNPV() {
        Assert.assertTrue("WaiveExcess Page not displayed", claimPaymentRequired.isPopUpDisplayed());
        claimPaymentRequired.proceedToWaiveCharge();
//        repairNotice.handleRepeatRepairNotice();

    }

    /*
    Manish Kumar Jain
    Date: 6th Dec 2021
    Scenario: To validate the Inflight Customer Interaction History.
     */
    @When("^I click the recent Claim number on plan history section$")
    public void i_click_the_recent_claim_number_on_plan_history_section() throws InterruptedException {
        Assert.assertTrue("Unable to verify the Plan view page",planViewPageNPV.isPageHeaderTitleDisplayed());
        planViewPageNPV.clickOpenClaimNumber();
        Thread.sleep(3000);
    }

    @Then("^I verify the Inflight Repair Summary screen launch$")
    public void i_verify_the_inflight_repair_summary_screen_launch() throws InterruptedException {
        planViewPageNPV.verifyInFlightSummaryHeader();
        Thread.sleep(2000);
    }

    @Then("^I verify RA Data Agent Input and Open Claim button displayed$")
    public void i_verify_ra_data_agent_input_and_open_claim_button_displayed() throws InterruptedException {
        planViewPageNPV.verifyRADataAgentInputOpenClaimButtonDisplayed();
    Thread.sleep(2000);
    }

    @Then("^I click on the Inflight Repair Workflow link to verify the Interaction History$")
    public void i_click_on_the_inflight_repair_workflow_link_to_verify_the_interaction_history() throws InterruptedException {
        planViewPageNPV.clickInflightRepairWorkflowLink();
        Thread.sleep(3000);
    }

    @Then("^I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value$")
    public void i_verify_the_workflow_details_have_startedfinishedduration_fields() throws InterruptedException {
        planViewPageNPV.verifyWorkflowDetailsSummaryHeader();
        Thread.sleep(3000);
        planViewPageNPV.verifyWorkflowDetailsSummarySubLabelDisplay();
        Thread.sleep(2000);
        planViewPageNPV.verifyStartedFinishedDurationMatches();
        Thread.sleep(3000);
    }

    @Then("^I verify all the labels are present under RA Data$")
    public void i_verify_all_the_labels_are_present_under_ra_data() throws InterruptedException {
        planViewPageNPV.verifyAllLabelsUnderRADataSectionAndCustomerVulnerabilities();
        Thread.sleep(2000);
    }

    @And("^I verify the Customer Interaction History section launch$")
    public void i_verify_the_customer_interaction_history_section_launch() throws InterruptedException {
        planViewPageNPV.verifyCustomerInteractionHistoryHeaderDisplayed();
        Thread.sleep(3000);
    }

    @Then("^I verify review claim page open in new tab after clicking on Open claim button$")
    public void i_verify_review_claim_page_open_in_new_tab_after_clicking_on_open_claim_button() throws InterruptedException {
        planViewPageNPV.clickOnOpenClaimButton();
        base.switchToNextTab();
        base.waitForPageToLoad();
        Assert.assertTrue("Claim View Page displayed",bookingOverviewPage.isBookingOverviewSectionDisplayed());
        Thread.sleep(2000);

    }

    /* Name : Manish Kumar Jain
    Scenario: Verify the pop up message displaying SP Contact Details URL*/
    @Then("^I verify Direct Referral pop up message displayed with SP name and Contact Details$")
    public void i_verify_direct_referral_pop_up_message_displayed_with_sp_name_and_contact_details() throws Throwable {
        homePageNPV.verifyPopUpWarningForAdminPlans();
        Thread.sleep(3000);
    }

    /* Name : Manish Kumar Jain
    Scenario: Verify OEM website page open after clicking on Go to URl button*/
    @Then("^I click on Go to Referral button to navigate to respective OEM website$")
    public void i_click_on_go_to_referral_button_to_navigate_to_respective_oem_website() throws Throwable {
        homePageNPV.verifyDirectReferralGoToUrlOpensOEMWebsite();
        Thread.sleep(3000);
    }

    @And("^I continue for Excess Pay for New Plan View$")
    public void iProceedForTheExcessPayNPV() {
        if (planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed()) {
            Assert.assertTrue("WaiveExcess Page not displayed", planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed());
            planViewPageNPV.claimPaymentRequiredPage.proceedToExcessPay();
        } else {
            LOGGER.info("Step Skipped : No Excess Payment popup displayed");
        }
//        repairNotice.handleRepeatRepairNotice();
    }

    @Then("^I select the WB \"([^\"]*)\" & \"([^\"]*)\" from the dropdown and click Continue$")
    public void i_select_the_wb_something_something_from_the_dropdown_and_click_continue(String model, String fault) throws Throwable {
        if (planViewPageNPV.productConfirmationHeatingPage.isWBProductConfirmationPageDisplayed()) {
            Assert.assertTrue("WB Product Confirmation Page not displayed", planViewPageNPV.productConfirmationHeatingPage.isWBProductConfirmationPageDisplayed());
            planViewPageNPV.productConfirmationHeatingPage.confirmModelAndFaultForWorcesterBosch(model,fault);
        } else {
            LOGGER.info("Step Skipped : No Model and Fault selected from the dropdown");
        }
        Thread.sleep(3000);

    }

    @And("^I enter the contact info for OEM plan$")
    public void enterTheContactInfoForOEMPlan() throws InterruptedException {
        planViewPageNPV.confirmContactInformationForWBPlan();
        Thread.sleep(3000);
    }

    @Then("^I confirm the service option as \"([^\"]*)\" for New Plan View$")
    public void iConfirmTheServiceOptionAsForNewPlanView(String serviceOption) throws Throwable {
        planDetails.getClaimNumber();
        planViewPageNPV.serviceOptionsPageNPV.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", planViewPageNPV.serviceOptionsPageNPV.isAdditionalInformationSectionDisplayed());
    }

    @Then("^I confirm the service option as \"([^\"]*)\" for NPV$")
    public void clickOnServiceOptionAsForNewPlanView(String serviceOption) throws Throwable {
        Thread.sleep(2000);
        planViewPageNPV.serviceOptionsPageNPV.selectServiceOptionAndConfirm(serviceOption);
    }

    @Then("^I click on Booking Incomplete button$")
    public void i_click_on_booking_incomplete_button() throws Throwable {
        Thread.sleep(3000);
        planViewPageNPV.clickOnBookingIncompleteButton();
    }

    @Then("^I click on the WB no availability pop up$")
    public void i_click_on_the_wb_no_availability_pop_up() throws Throwable {
        planViewPageNPV.serviceOptionsPageNPV.clickOnWBNoAvailabilityPopUp();
        Thread.sleep(5000);
    }

    @And("^I enter the additional information for Service Option Message$")
    public void iEnterTheAdditionalInformationForServiceOptionMessage() {
        planViewPageNPV.serviceOptionsPageNPV.enterAdditionalInformation();
    }

    @Then("^I click on Confirm Option Details button and verify the pop up")
    public void iClickOnConfirmOptionDetailsAndVerifyThePopUp() throws Throwable {
//        Assert.assertTrue("Unable to verify Confirmation Button", planViewPageNPV.serviceOptionsPageNPV.isConfirmOptionDetailsButtonDisplayed());
        planViewPageNPV.serviceOptionsPageNPV.iClickOnConfirmOptionDetailsButtonVerifyWarningPopUp();
        Thread.sleep(4000);

    }


    @When("^I enter the PNC Details and fault data and click continue$")
    public void iEnterThePNCDetails() {
        planViewPageNPV.productConfirmationPNC.enterPNCDetails();
        planViewPageNPV.productConfirmationPNC.enterFaultData();
        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isFaultDataEntered());
        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }


    @When("^I enter the PNC Details Fault \"([^\"]*)\"and \"([^\"]*)\" fault data and click continue$")
    public void iEnterPNCFaultAreaFaultAndContinue(String faultArea, String fault) throws Throwable {
        planViewPageNPV.productConfirmationPNC.enterPNCDetails();
        Thread.sleep(3000);
        planViewPageNPV.productConfirmationPNC.enterFaultAreaAndFaultAndClickContinue(faultArea,fault);
//        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isFaultDataEntered());
        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }

    @Then("^I confirm the ExcessPayment for New Plan View$")
    public void iConfirmExcessForNewPlanView() throws Throwable {
        Assert.assertTrue("Excess pay Section not Loaded", planViewPageNPV.serviceOptionsPageNPV.isPaymentRequired());
        planViewPageNPV.serviceOptionsPageNPV.selectExcessPyment();
    }


    @Then("^I click on the open claim no in the Plan History section$")
    public void i_click_on_the_open_claim_no_in_the_plan_history_section() throws Throwable {
        Thread.sleep(3000);
        planViewPageNPV.clickOnOpenClaimNoLinkInPlanHistory();
    }

    @And("^I click on the Open Claim button in the Inflight Repair Summary$")
    public void i_click_on_the_open_claim_button_in_the_inflight_repair_summary() throws Throwable {
        Thread.sleep(3000);
        planViewPageNPV.clickOnOpenClaimButtonInInflightRepairSummary();
    }

    @Then("^I click on Customer Contact button in plan view page$")
    public void i_click_on_customer_contact_button_in_plan_view_page() throws Throwable {
        planViewPageNPV.clickOnCustomerContactButtonInPlanView();
        Thread.sleep(6000);
    }



}
