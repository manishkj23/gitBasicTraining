package com.test.steps.Steps_NPV;


import com.test.pages.CCAgentUI_NPV.Aquant.AquantHomePage;
import com.test.pages.CCAgentUI_NPV.Aquant.AquantLoginPage;
import com.test.pages.CCAgentUI_NPV.BabyPlanViewPage;
import com.test.pages.CCAgentUI_NPV.BookingConfirmedPage;
import com.test.pages.CCAgentUI_NPV.BookingOverview.ViewAccessories;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewPage;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanHistory.PlanHistoryPage;
import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.ExcessPaymentDue;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationMobileColorAndCapacity;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationPNC;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationTelevision;
import com.test.pages.CCAgentUI_NPV.RepairManager.RepairManagerSections;
import com.test.pages.CCAgent_OLDUI.CancelClaimPage;
import com.test.pages.CCAgent_OLDUI.ProductConfirmationSections.ProductConfirmationMobile;
import com.test.pages.CCAgent_OLDUI.ReciperoView.ReciperoViewPage;
import com.test.pages.CCAgent_OLDUI.ReviewClaimPage;
import com.test.pages.ExcessPayment.ExcessFeePaymentDuePage;
import com.test.pages.ExcessPayment.PaymentDuePopup;
import com.test.pages.RepairerPortal.RepairerJobUpdate;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.constraints.AssertTrue;


public class NPVHomePageStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private PlanDetails planDetails;
    private CommonUtils commonUtils;
    private PlanViewPageNPV planViewPageNPV;
    private ReviewClaimPage reviewClaim;
    private ProductConfirmationPNC productConfirmationPNC;
    private BookingConfirmedPage bookingConfirmedPage;
    private ProductConfirmationMobile mobileProductConfirmation;
    private ProductConfirmationMobileColorAndCapacity productConfirmationMobileColorAndCapacity;
    private BookingOverviewPage bookingOverviewPage;
    private ReciperoViewPage reciperoPage;
    private ExcessPaymentDue excessPaymentDue;
    private ProductConfirmationTelevision productConfirmationTelevision;
    private RepairerJobUpdate repairJobUpdate;
    private CancelClaimPage cancelClaimPage;
    private BabyPlanViewPage babyPlanViewPage;
    private AquantLoginPage aquantLoginPage;
    private AquantHomePage aquantHomePage;
    private PlanHistoryPage planHistoryPage;
    private PaymentDuePopup paymentDuePopup;
    private ExcessFeePaymentDuePage excessFeePaymentDuePage;
    private ViewAccessories viewAccessories;
    private RepairManagerSections repairManagerSections;


    private static final Logger LOGGER = LoggerFactory.getLogger(NPVHomePageStepDef.class);

    public NPVHomePageStepDef(BasePage basePage,
                              SeleniumHelper seleniumHelper,
                              CommonUtils commonUtils,
                              PlanDetails planDetails,
                              PlanViewPageNPV planViewPageNPV,
                              ReviewClaimPage reviewClaim,
                              ProductConfirmationPNC productConfirmationPNC,
                              BookingConfirmedPage bookingConfirmedPage,
                              ProductConfirmationMobile mobileProductConfirmation,
                              ProductConfirmationMobileColorAndCapacity productConfirmationMobileColorAndCapacity,
                              BookingOverviewPage bookingOverviewPage,
                              ReciperoViewPage reciperoPage,
                              ExcessPaymentDue excessPaymentDue,
                              ProductConfirmationTelevision productConfirmationTelevision,
                              RepairerJobUpdate repairerJobUpdate,
                              CancelClaimPage cancelClaimPage,
                              BabyPlanViewPage babyPlanViewPage,
                              AquantHomePage aquantHomePage,
                              AquantLoginPage aquantLoginPage,
                              PlanHistoryPage planHistoryPage,
                              PaymentDuePopup paymentDuePopup,
                              RepairManagerSections repairManagerSections,
                              ViewAccessories viewAccessories) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.planDetails = planDetails;
        this.commonUtils = commonUtils;
        this.planViewPageNPV = planViewPageNPV;
        this.reviewClaim = reviewClaim;
        this.productConfirmationPNC = productConfirmationPNC;
        this.bookingConfirmedPage = bookingConfirmedPage;
        this.mobileProductConfirmation = mobileProductConfirmation;
        this.productConfirmationMobileColorAndCapacity = productConfirmationMobileColorAndCapacity;
        this.bookingOverviewPage = bookingOverviewPage;
        this.reciperoPage = reciperoPage;
        this.excessPaymentDue = excessPaymentDue;
        this.productConfirmationTelevision = productConfirmationTelevision;
        this.repairJobUpdate = repairerJobUpdate;
        this.cancelClaimPage = cancelClaimPage;
        this.cancelClaimPage = cancelClaimPage;
        this.babyPlanViewPage = babyPlanViewPage;
        this.aquantHomePage = aquantHomePage;
        this.aquantLoginPage = aquantLoginPage;
        this.planHistoryPage = planHistoryPage;
        this.paymentDuePopup = paymentDuePopup;
        this.repairManagerSections = repairManagerSections;
        this.viewAccessories =  viewAccessories;
    }


    @When("^I verify the claim page is opened when I click the recent Claim number on Booking Overview page$")
    public void iVerifyTheClaimPageIsOpenedWhenIClickTheRecentClaimNumberOnBookingOverviewPage() {
        Assert.assertTrue("Unable to verify the Plan view page", planViewPageNPV.isPageHeaderTitleDisplayed());
        planViewPageNPV.clickCurrentClaimNumber();
        base.switchToNextTab();
        base.waitForPageToLoad();
        Assert.assertTrue("Claim View Page displayed", planViewPageNPV.bookingOverviewPage.isBookingOverviewSectionDisplayed());
    }

    @Then("^I click on customer communications section on the New Plan View$")
    public void iClickOnCustomerCommunicationsSectionOnTheNewPlanView() {
        planViewPageNPV.bookingOverviewPage.clickCustomerCommunicationsSection();


    }


    @Then("^I verify customer communications section on the New Plan View is displayed$")
    public void iClickOnCustomerCommunicationsSectionOnTheNewPlanViewdisplayed() {
        Assert.assertTrue("Customer Communications Email section not loaded", reviewClaim.isCustomerCommunicationsEmailSectionDisplayed());
        Assert.assertTrue("Customer Communications SMS section not loaded", reviewClaim.isCustomerCommunicationsSmsSectionDisplayed());

    }

    @Then("^I click on \"([^\"]*)\" section on the New Plan View$")
    public void iClickOnSectionOnTheNewPlanView(String menuItem) {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem(menuItem);
    }

    @Then("^I verify the new plan view page displayed$")
    public void iVerifyTheNewPlanViewPageDisplayed() {
        Assert.assertTrue("Unable to Verify Plan View Header", planViewPageNPV.isPageHeaderTitleDisplayed());

    }

    @When("^I select the Claim Type as \"([^\"]*)\"$")
    public void iSelectTheClaimTypeAs(String claimType) throws Exception {
//        if(planViewPageNPV.isClaimTypeHasOpenClaimMsgShowing("Breakdown") || planViewPageNPV.isClaimTypeHasOpenClaimMsgShowing("Repair")) {
//           commonUtils.cancelAnOpenClaim(planDetails.getPlanNumber());
//        }
        Assert.assertTrue("ClaimType is not Enabled : " + claimType, planViewPageNPV.isClaimTypeEnabled(claimType));
        Thread.sleep(4000);
        planViewPageNPV.selectClaimType(claimType);
    }

    @When("^I select the Claim Type as \"([^\"]*)\" and verify claim already exist$")
    public void iSelectTheClaimTypeAsClaimExist(String claimType) throws Exception {
        Assert.assertTrue("ClaimType is not Enabled : " + claimType, planViewPageNPV.isClaimTypeHasOpenClaimMsgShowing(claimType));
    }

    @And("^I enter the contact info$")
    public void iEnterTheContactInfo() throws InterruptedException {
        planViewPageNPV.confirmContactInformation();
        Thread.sleep(9000);
        // planViewPageNPV.confirmContactInformation() ;
        // Thread.sleep(3000);
    }

    @And("^I enter the contact info with email as \"([^\"]*)\"$")
    public void iEnterTheContactInfoWithEmail() {
        planViewPageNPV.confirmContactInformation();


    }

    @When("^I enter the PNC Details and fault data and click continue$")
    public void iEnterThePNCDetails() {
        base.hardWait("10000");
        planViewPageNPV.productConfirmationPNC.enterPNCDetails();
        base.hardWait("10000");
        planViewPageNPV.productConfirmationPNC.enterFaultData();
        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isFaultDataEntered());
        base.hardWait("10000");
        if (planViewPageNPV.productConfirmationHeating.isCXApplianceUsableFieldDisplayed()) {
            Assert.assertTrue("CX Appliance usable field is not present", planViewPageNPV.productConfirmationHeating.verifyCxApplianceUsableSelect());
            planViewPageNPV.productConfirmationPNC.enterContinueButton();
        }else{
            planViewPageNPV.productConfirmationPNC.enterContinueButton();
        }
    }

    @When("^I click continue with product confirmation$")
    public void iConfirmProductConfirmation() {
        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }

    @Then("^I verify the Booking Confirmed Page is displayed for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheBookingConfirmedPageIsDisplyed(String claimType, String spName) {
        Assert.assertTrue("Unable to verify ClaimNumber", planViewPageNPV.bookingConfirmedPageNPV.isClaimNumberDisplayed());
        Assert.assertTrue("Unable to verify the REPAIRER INFO", planViewPageNPV.bookingConfirmedPageNPV.isRepairerDisplayed(spName));
        Assert.assertTrue("Unable to verify the REPAIRER REFERENCE", planViewPageNPV.bookingConfirmedPageNPV.isRepairReferenceDisplayed());
        Assert.assertTrue("Unable to verify the Button Go to Claim ", planViewPageNPV.bookingConfirmedPageNPV.isGotoClaimButtonDisplayed(claimType));
    }

    @And("^I waive off the Excess Pay for New Plan View$")
    public void iWaiveOffTheExcessPayNPV() throws InterruptedException {
        if (planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed()) {
            Assert.assertTrue("WaiveExcess Page not displayed", planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed());
            planViewPageNPV.claimPaymentRequiredPage.clickContinueForClaimRequiredPopup();
//            planViewPageNPV.claimPaymentRequiredPage.proceedToWaiveCharge();
        } else {
            LOGGER.info("Step Skipped : No Excess waive popup displayed");
        }

//        repairNotice.handleRepeatRepairNotice();

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

    @When("^I perform the product confirmation section for Mobile for NPV$")
    public void iPerformTheProductConfirmationSectionForMobile() throws InterruptedException {
//        productConfirmationMobileColorAndCapacity.confirmSNumber();
        Thread.sleep(10000);
        productConfirmationMobileColorAndCapacity.confirmSerialNumber();
        productConfirmationMobileColorAndCapacity.confirmColorAndCapacity();
        mobileProductConfirmation.confirmIMEI();
//        productConfirmationMobileColorAndCapacity.confirmSerialNumber();
//        productConfirmationMobileColorAndCapacity.confirmSNumber();
//        productConfirmationMobileColorAndCapacity.confirmColorAndCapacity();
    }

    @And("^I enter fault section for the new plan view and click continue$")
    public void iEnterFaultSectionForTheNewPlanView() {
//        planViewPageNPV.enterFaultDetailsAndContinue();
    }

    @And("^I Book without an Appointment and confirm appointment for \"([^\"]*)\" in New Plan View$")
    public void iBookWithoutAnAppointmentAndConfirmAppointmentForInNewPlanView(String spName) {
        Assert.assertTrue("Unable to verify Confirmation Button", planViewPageNPV.serviceOptionsPageNPV.isConfirmOptionDetailsButtonDisplayed());
        planViewPageNPV.serviceOptionsPageNPV.clickConfirmOptionDetailsButtonWithOutAppointment(spName);

    }

    @And("^I confirm appointment booking for \"([^\"]*)\" in New Plan View for Mobile$")
    public void iBookWithoutAnAppointmentAndConfirmAppointmentForInNewPlanViewMob(String spName) {
        Assert.assertTrue("Unable to verify Confirmation Button", planViewPageNPV.serviceOptionsPageNPV.isConfirmOptionDetailsButtonDisplayed());
        planViewPageNPV.serviceOptionsPageNPV.clickConfirmOptionDetailsButtonForMobile(spName);

    }

    @Then("^I confirm the service option as \"([^\"]*)\" for New Plan View$")
    public void iConfirmTheServiceOptionAsForNewPlanView(String serviceOption) throws Throwable {
        planDetails.getClaimNumber();
        Thread.sleep(10000);
        planViewPageNPV.serviceOptionsPageNPV.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", planViewPageNPV.serviceOptionsPageNPV.isAdditionalInformationSectionDisplayed());
    }

    @Then("^I confirm the service option as \"([^\"]*)\" for New Plan View with Excess Payment$")
    public void iConfirmTheServiceOptionAsForNewPlanViewWithServiceExcess(String serviceOption) throws Throwable {
        Thread.sleep(5000);
        planDetails.getClaimNumber();
        Thread.sleep(5000);
        if (planViewPageNPV.claimPaymentRequiredPage.isWaiveExcessChargeButtonDisplayed()) {
            Thread.sleep(5000);
            Assert.assertTrue("WaiveExcess popup not displayed", planViewPageNPV.claimPaymentRequiredPage.isWaiveExcessPopUpDisplayedAtServiceOptionSection());
            planViewPageNPV.claimPaymentRequiredPage.proceedToWaiveCallOutChargePayment();
        } else {
            planViewPageNPV.serviceOptionsPageNPV.selectAvailableServiceOptionAndConfirm(serviceOption);
        }
        planViewPageNPV.serviceOptionsPageNPV.selectAvailableServiceOptionAndConfirm(serviceOption);
//        Assert.assertTrue("Unable to Verify the Payment Due Page", paymentDuePopup.isPaymentDuePageLoaded());
//        paymentDuePopup.takePayment();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", planViewPageNPV.serviceOptionsPageNPV.isAdditionalInformationSectionDisplayed());
    }

    @And("^I enter the additional information for Service Option Message$")
    public void iEnterTheAdditionalInformationForServiceOptionMessage() {
        planViewPageNPV.serviceOptionsPageNPV.enterAdditionalInformation();
    }

    @And("^I enter the additional information for all Service Option Message$")
    public void iEnterTheAdditionalInformationForAllServiceOptionMessage() throws InterruptedException {
        planViewPageNPV.serviceOptionsPageNPV.enterAdditionalInformationAll();
    }

    @Then("^I verify the claim is accepted on the plan view page$")
    public void iVerifyTheClaimIsAcceptedOnThePlanViewPage() {
        Assert.assertTrue("Claim Accepted not verified", planViewPageNPV.isClaimInAcceptedStatus());
        planViewPageNPV.cliclServiceOptionSection();
    }

    @When("^I enter the Model \"([^\"]*)\" and confirm product confirmation for Heating appliance$")
    public void iEnterTheModelAndConfirmProductConfirmationForHeatingAppliance(String model) throws InterruptedException {
        Assert.assertTrue("Product confirmation page not displayed", planViewPageNPV.productConfirmationHeating.isPageDisplayed());
        planViewPageNPV.productConfirmationHeating.confirmModel(model);
    }

    @And("^I navigate to Claim Page on New Plan View$")
    public void iNavigateToClaimPageOnNewPlanView() {
        bookingConfirmedPage.cickGotoClaim();
        Assert.assertTrue("Booking Overview Page not verified", bookingOverviewPage.isBookingOverviewSectionDisplayed());
    }

    @When("^I verify the recipero page displyed$")
    public void iVerifyTheReciperoPageDisplyed() {
        bookingOverviewPage.clickReciperoIcon();
        Assert.assertTrue("Unable to load Page", reciperoPage.isReciperoViewPageDisplayed());

    }

    @Then("^I confirm the ExcessPayment for New Plan View$")
    public void iConfirmExcessForNewPlanView() throws Throwable {
        Assert.assertTrue("Excess pay Section not Loaded", planViewPageNPV.serviceOptionsPageNPV.isPaymentRequired());
        planViewPageNPV.serviceOptionsPageNPV.selectExcessPyment();

    }

    @Then("^I confirm the service option as \"([^\"]*)\" for New Plan View with Excess$")
    public void iConfirmTheServiceOptionAsForNewPlanViewWithExcess(String serviceOption) throws Throwable {
//        iConfirmExcessForNewPlanView();
        planViewPageNPV.serviceOptionsPageNPV.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Assert.assertTrue("Additional Information Section not Loaded", excessPaymentDue.isExcessPaymentPageDisplayed());
    }

    @Then("^I enter \"([^\"]*)\" on the product confirmation section for Television for NPV$")
    public void iEnterOnTheProductConfirmationSectionForTelevision(String model) {
        productConfirmationTelevision.confirmDefaultSizeModel();
    }

    @Then("^I enter \"([^\"]*)\" on the product confirmation section for Cooker for NPV$")
    public void iEnterOnTheProductConfirmationSectionForCooker(String model) throws InterruptedException {
        planViewPageNPV.productConfirmationCooker.confirmDefaultModel();
        Assert.assertTrue("Product confirmation not successful", planViewPageNPV.productConfirmationPNC.isPNCSectionLoaded());
    }

    @Then("^I enter \"([^\"]*)\" on the product confirmation section for Heating for NPV$")
    public void iEnterOnTheProductConfirmationSection(String model) throws InterruptedException {
        Thread.sleep(3000);
//        if (planViewPageNPV.productConfirmationHeating.isPageDisplayed()) {
        planViewPageNPV.productConfirmationHeating.confirmModel(model);
//        } else {
//            LOGGER.info("Product Confirmation Page not Displayed");
//        }
    }

    @Then("^I verify the new status's are logged in ORB NPV under Request Authorisation, when changes are made to RP$")
    public void iVerifyTheNewStatusSAreLoggedInORBUnderRequestAuthorisationWhenChangesAreMadeToRPNPV() {
        planViewPageNPV.bookingOverviewPage.clickRepairAuthoritySection();
        Assert.assertTrue("RA Status Changes not verified", planViewPageNPV.bookingOverviewPage.repairAuthority.isRAHistoryStatusChangesUpdated());
    }

    @Then("^I verify the Job status in ORB NPV under Request Authorisation matched to RP as \"([^\"]*)\"$")
    public void iVerifyTheNewStatusSAreLoggedInORBUnderRequestAuthorisationWhenChangesAreMadeToRPNPVStatus(String outCome) {
        planViewPageNPV.bookingOverviewPage.clickRepairAuthoritySection();
        Assert.assertTrue("RA Status Changes not verified", planViewPageNPV.bookingOverviewPage.repairAuthority.isRAJobStatusUpdated(outCome));
    }

    @Then("^I Confirm that system notes display correctly and user can add a note in ORB NPV$")
    public void iConfirmThatSystemNotesDisplayCorrectlyAndUserCanAddANoteInORBNPV() {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem("System Note");
        Assert.assertTrue("System Noted added successfully", planViewPageNPV.bookingOverviewPage.reviewClaimPage.addAndVerifyNewSystemNotesAdded());
    }

    @Then("^I verify the NPV CustomerCommunications messages are generated$")
    public void iVerifyTheCustomerCommunicationsMessagesAreGenerated() {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem("Customer Communications");
        base.hardWait("2000");
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem("Customer Communications");
        Assert.assertTrue("Customer Communications Email section not loaded", planViewPageNPV.bookingOverviewPage.reviewClaimPage.isCustomerCommunicationsEmailSectionDisplayed());
        base.hardWait("60000");
        Assert.assertTrue("Customer Communications SMS section not loaded", planViewPageNPV.bookingOverviewPage.reviewClaimPage.isCustomerCommunicationsSmsSectionDisplayed());
    }

    @Then("^I navigate to Booking Overview Page for the Open Claim for Plan \"([^\"]*)\"$")
    public void iNavigateToBookingOverviewPageForTheOpenClaimForPlan(String planNo) throws Throwable {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            base.navigateToPage(base.prop.getProperty("jobupdatePage") + commonUtils.getOpenClaimNo(planDetails.getPlanNumber()));
        } else {
            base.navigateToPage(base.prop.getProperty("jobupdatePage") + commonUtils.getOpenClaimNo(planNo));
        }
    }

    @Then("^I navigate to Booking Overview Page for the Open Claim using claim no \"([^\"]*)\"$")
    public void iNavigateToBookingOverviewPageForTheOpenClaimForClaim(String claimNo) throws Throwable {
        base.navigateToPage(base.prop.getProperty("jobupdatePage") + claimNo);
    }

    @When("^I select the Claim Type as \"([^\"]*)\" and verify Plan is InWarranty$")
    public void iSelectTheClaimTypeAsInWarranty(String claimType) {
        Assert.assertTrue("ClaimType is not Enabled : " + claimType, planViewPageNPV.isClaimTypeShowsPlanInWarranty(claimType));
    }

    @When("^I select the Claim Type as \"([^\"]*)\" and verify Plan is Cancelled$")
    public void iSelectTheClaimTypeAsCanc(String claimType) {
        Assert.assertTrue("Unable to Verify plan cancelled : " + claimType, planViewPageNPV.isPlanCancelled(claimType));
    }

    @When("^I select the Claim Type as \"([^\"]*)\" and verify Plan is Lapsed$")
    public void iSelectTheClaimTypeAsLapsed(String claimType) {
        Assert.assertTrue("Unable to Verify plan lapsed : " + claimType, planViewPageNPV.isPlanLapsed(claimType));
    }

    @When("^I select the Claim Type as \"([^\"]*)\" and verify Plan has ONE-OFF-REPAIR completed 90 days before$")
    public void iSelectTheClaimTypeOOR(String claimType) {
        Assert.assertTrue("Unable to Verify plan lapsed : " + claimType, planViewPageNPV.isPlanNotEligibleForOneOffRepair(claimType));
    }

    @Given("^I create a Claim from API for \"([^\"]*)\"$")
    public void iCreateAClaimFromAPIFor(String planNo) throws Throwable {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            commonUtils.createClaimFromAPI(planDetails.getPlanNumber("HOOVER"),
                    "SYCAMOREogbcc",
                    "AL1 4XT", "3", "CAND");

            Assert.assertTrue("Claim not verified", !commonUtils.getOpenClaimNo(planDetails.getPlanNumber()).isEmpty());
        } else {
            //LOGGER.info("Claim can only be created for the plan created with in the Framework");
            commonUtils.cancelAnOpenClaim(planNo);
            commonUtils.createClaimFromAPI(planNo,
                    "SYCAMOREogbcc",
                    "AL1 4XT", "3", "CAND");
        }
    }

    @Given("^I create a Claim from API for \"([^\"]*)\" for a manufacturer \"([^\"]*)\"$")
    public void iCreateAClaimFromAPIForOEM(String planNo, String oem) throws Throwable {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            switch (oem.toUpperCase()) {
                case "WHIRLPOOL":
                    commonUtils.createClaimFromAPI(planDetails.getPlanNumber(oem),
                            "REPAIRPLUSONE",
                            "PE2 7AB", "3", "INDE");
                    break;

                default:
                    commonUtils.createClaimFromAPI(planDetails.getPlanNumber("HOOVER"),
                            "SYCAMOREogbcc",
                            "AL1 4XT", "3", "CAND");
            }


            Assert.assertTrue("Claim not verified", !commonUtils.getOpenClaimNo(planDetails.getPlanNumber()).isEmpty());
        } else {
            LOGGER.info("Claim can only be created for the plan created with in the Framework");
        }
    }

    @When("^I set the fault codes in Repair Section in NPV$")
    public void iSetFaultCodesInRepair() throws Throwable {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem("Repair Information");
        repairJobUpdate.updateRepairFaultCodeAndProblemCode();
    }

    @Then("^I process the Claim to WrittenOff with the status as \"([^\"]*)\" and \"([^\"]*)\" in NPV$")
    public void iProcessTheClaimToWrittenOffWithTheStatusAsAnd(String writtenOffStatus, String additionalStatus) throws Throwable {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem("Repair Authority");
        planViewPageNPV.bookingOverviewPage.reviewClaimPage.processWrittenOff(writtenOffStatus);
//        Assert.assertTrue(writtenOffStatus+" - Not Verified", planViewPageNPV.bookingOverviewPage.reviewClaimPage.isRACurrentJobStatusDisplayed(writtenOffStatus));
        Assert.assertTrue("DA Appointment status not verified", planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(writtenOffStatus));
    }

    @When("^I perform the Write off from writeoffauthorization panel for \"([^\"]*)\" and RA Status \"([^\"]*)\"$")
    public void iPerformTheWriteOffFromWriteoffauthorizationPanelFor(String outCome, String raStatus) throws Throwable {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem("Write Off Authorization");
        base.waitForPageToLoad();
        Assert.assertTrue("Write Off Authorization Panel not displayed", planViewPageNPV.writeOffAuthorizationPage.isWriteOffAuthorizationPanelDisplayed());
        planViewPageNPV.writeOffAuthorizationPage.updateWriteOffData("Freestanding", raStatus);
        Assert.assertTrue("Unable to verify the WO Status", planViewPageNPV.writeOffAuthorizationPage.isNewRAStatusMsgPopupDisplayed(raStatus));
        planViewPageNPV.writeOffAuthorizationPage.confirmNewRAStatus();
        Assert.assertTrue("Unable to verify the Success Message for WO", planViewPageNPV.writeOffAuthorizationPage.isWriteOffSuccessMsgPopupDisplayed());
        planViewPageNPV.writeOffAuthorizationPage.confirmWriteOffSuccessMsg();


    }

    @Then("^I attach the service certificate for ASV$")
    public void iAttachTheServiceCertificateForASV() {
        repairJobUpdate.addAttachment();
        Assert.assertTrue("Unable to verify attachment", repairJobUpdate.isAttachmentUploaded());
    }

    @Then("^I cancel the open claim for \"([^\"]*)\"$")
    public void iCancelTheClaimFor(String planNo) throws Exception {

        if (commonUtils.getOpenClaimNo(planNo) != null) {
            base.navigateToPage(" https://www.skylinecms.co.uk/domgenprelive/index/canceljob/" + commonUtils.getOpenClaimNo(planNo));
            cancelClaimPage.clickCancelClaimAction();
            cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");
            base.waitForPageToLoad();
            Assert.assertTrue("Open Claim not cancelled ", cancelClaimPage.isJobCancelledSuccefully());
        }

    }

    @Then("^I select the WB \"([^\"]*)\" & \"([^\"]*)\" from the dropdown and click Continue$")
    public void i_select_the_wb_something_something_from_the_dropdown_and_click_continue(String model, String fault) throws Throwable {
        if (planViewPageNPV.productConfirmationHeating.isWBProductConfirmationPageDisplayed()) {
            Assert.assertTrue("WB Product Confirmation Page not displayed", planViewPageNPV.productConfirmationHeating.isWBProductConfirmationPageDisplayed());
            planViewPageNPV.productConfirmationHeating.confirmModelAndFaultForWorcesterBosch(model,fault);
        } else {
            LOGGER.info("Step Skipped : No Model and Fault selected from the dropdown");
        }
        Thread.sleep(3000);

    }

    @Then("^I confirm the service option as \"([^\"]*)\" for NPV$")
    public void clickOnServiceOptionAsForNewPlanView(String serviceOption) throws Throwable {
        Thread.sleep(2000);
        planViewPageNPV.serviceOptionsPageNPV.selectServiceOptionAndConfirm(serviceOption);
    }

    @Then("^I click on the WB no availability pop up$")
    public void i_click_on_the_wb_no_availability_pop_up() throws Throwable {
        planViewPageNPV.serviceOptionsPageNPV.clickOnWBNoAvailabilityPopUp();
        Thread.sleep(5000);
    }

    @Then("^I click on Confirm Option Details button and verify the pop up")
    public void iClickOnConfirmOptionDetailsAndVerifyThePopUp() throws Throwable {
//        Assert.assertTrue("Unable to verify Confirmation Button", planViewPageNPV.serviceOptionsPageNPV.isConfirmOptionDetailsButtonDisplayed());
        planViewPageNPV.serviceOptionsPageNPV.iClickOnConfirmOptionDetailsButtonVerifyWarningPopUp();
        Thread.sleep(4000);

    }

    @Then("^I click on the open claim no in the Plan History section$")
    public void i_click_on_the_open_claim_no_in_the_plan_history_section() throws Throwable {
        Thread.sleep(3000);
        planViewPageNPV.clickOnOpenClaimNoLinkInPlanHistory();
        Thread.sleep(3000);
    }

    @And("^I click on the Open Claim button in the Inflight Repair Summary$")
    public void i_click_on_the_open_claim_button_in_the_inflight_repair_summary() throws Throwable {
        Thread.sleep(3000);
        planViewPageNPV.clickOnOpenClaimButtonInInflightRepairSummary();
    }

    @And("I select the {string} from the baby plan view page")
    public void iSelectTheFromTheBabyPlanViewPage(String babyPlanNo) {
        Assert.assertTrue(" Baby plan view page is not displayedt", babyPlanViewPage.isBabyPlanTableIsDisplayed());
//        Assert.assertTrue("Unable to verify the Baby Plan View Page", babyPlanViewPage.isBabyPlanPageDisplayed());
        babyPlanViewPage.navigateToBabyPlan(babyPlanNo);
        Assert.assertTrue("Unable to Verify Plan View Header", planViewPageNPV.isPageHeaderTitleDisplayed());
    }

    @When("I enter the free text for {string} on the product confirmation section")
    public void iEnterTheFreeTextForOnTheProductConfirmationSection(String model) {
//        planViewPageNPV.productConfirmationPNC.enterPNCDetails();
//        planViewPageNPV.productConfirmationPNC.enterFaultData();
//        planViewPageNPV.product
//        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isFaultDataEntered());
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }

    @Given("I enter the {string} {string} {string} and {string} and call the API")
    public void iEnterThePostcodeAndCallTheAPI(String firstName, String surname, String addressLane1, String postcode) throws Throwable {
        String planNo;
        planNo = commonUtils.createContractFor4HHWithCustomDetails(firstName, surname, addressLane1, postcode);
    }

    @Given("I create Plan using {string} {string} {string} and {string} and call the API")
    public void iCreatePlanUsingDetails(String firstName, String surname, String addressLane1, String postcode) throws Throwable {
        String planNo;
        planNo = commonUtils.createContractFor4HHWithCustomDetails(firstName, surname, addressLane1, postcode);
    }

    @Then("I verify the plan is created")
    public void iVerifyThePlanIsCreated() {

    }


    @When("I verify the evidence block for {string} is displayed")
    public void iVerifyTheEvidenceBlockForIsDisplayed(String evidenceString) {
        Assert.assertTrue("Unable to verify Evidence labels on Aquant", aquantHomePage.isEvidenceSectionLoaded(evidenceString));
    }

    @And("I confirm the solution as {string} and save")
    public void iConfirmTheSolutionAsAndSave(String solutionLbl) {
        aquantHomePage.confirmSolution(solutionLbl);
        Assert.assertTrue("Unable to verify the Solved Status", aquantHomePage.isSolutionMarkedAsSolved(solutionLbl));
        aquantHomePage.clickSaveAquantJourney();
    }

    @Then("I verify claim is completed via Triage")
    public void iVerifyClaimIsCompletedViaTriage() {
        base.switchToDefaultTab();
        Assert.assertTrue("Unable to Verify Claim status", planHistoryPage.isClaimStatusDisplayedAsRepairCompletedViaTriage());
    }

    @And("I enter the actual model number and the Fault as {string} and continue")
    public void iEnterTheActualModelNumberAndTheFaultAsAndContinue(String fault)throws InterruptedException {
        Thread.sleep(10000);
        planViewPageNPV.productConfirmationHeating.enterHeatingModelFromDropdwn();
        Thread.sleep(10000);
        planViewPageNPV.productConfirmationHeating.enterFaultInputDataDropdown(fault);
        if (planViewPageNPV.productConfirmationHeating.isCXApplianceUsableFieldDisplayed()) {
            Assert.assertTrue("CX Appliance usable field is not present", planViewPageNPV.productConfirmationHeating.verifyCxApplianceUsableSelect());
            planViewPageNPV.productConfirmationPNC.enterContinueButton();
        }else{
            planViewPageNPV.productConfirmationPNC.enterContinueButton();
        }
    }

    @And("I enter the Observation section with {string} and click next")
    public void iEnterTheObservationSectionWithAndClickNext(String observationLabel) {
        base.waitForPageToLoad();
        aquantHomePage.enterSearchObservation(observationLabel);
    }

    @And("I confirm the Excess paid matches with the expected Excess amount {string}")
    public void iConfirmTheExcessPaidMatchesWithTheExpectedExcessAmount(String excessAmount) {
        Assert.assertTrue("unable to match excess amount content",planViewPageNPV.bookingOverviewPage.systemNotePage.isExcessPaymentDisplayedOnSystemNote(excessAmount.substring(0,2)));
    }

    @When("I confirm booking for a self signposted claim {string}")
    public void iSubmitTheDataToConfirmBookingForASelfSignpostedClaim(String status) {
        Assert.assertTrue("Failed to verify Booking src",bookingOverviewPage.bookingOverviewSubSection.isBookingSourceMatched(status));
    }


    @And("I navigate to the booking overview subsection menu {string}")
    public void iNavigateToTheBookingOverviewSubsectionMenu(String menuItem) {
        bookingOverviewPage.clickLeftMenuItem(menuItem);
    }

    @And("I confirm the System notes with claim booked via self signposting")
    public void iConfirmTheSystemNotesWithClaimBookedViaSelfSignposting() {
        Assert.assertTrue("unable to find claim self signposted message",planViewPageNPV.bookingOverviewPage.systemNotePage.isSystemNoteShowsClaimBookedViaSelfSignposting());

    }

    @And("I verify the scheme message Stamped for Excess collection")
    public void iVerifyTheSchemeMessageStampedForExcessCollection() {
        bookingOverviewPage.clickLeftMenuItem("Repair Authority");
        Assert.assertTrue("Unable to verify Repair Authority Section",bookingOverviewPage.repairAuthoritySectionPage.isRepairAuthorityPageDisplayed());
        bookingOverviewPage.repairAuthoritySectionPage.clickAuthorityLineSummaryLink();
        Assert.assertTrue("Unable to verify Authority Summary Line Page Section",bookingOverviewPage.repairAuthoritySectionPage.authorityLineSummaryPage.isAuthorityLineSummaryPageDisplayed());
        planDetails.getClaimNumber();
        Assert.assertTrue("Unable to verify Excess Collected Amount stamped in scheme",bookingOverviewPage.repairAuthoritySectionPage.authorityLineSummaryPage.isExcessPaymentStampedOnScheme(planDetails.getClaimNumber()));
    }

    @And("I verify the scheme message Stamped for Excess collection for plan number {string}")
    public void iVerifyTheSchemeMessageStampedForExcessCollectionString(String planNo) throws Exception {
        bookingOverviewPage.clickLeftMenuItem("Repair Authority");
        Assert.assertTrue("Unable to verify Repair Authority Section",bookingOverviewPage.repairAuthoritySectionPage.isRepairAuthorityPageDisplayed());
        bookingOverviewPage.repairAuthoritySectionPage.clickAuthorityLineSummaryLink();
        Assert.assertTrue("Unable to verify Authority Summary Line Page Section",bookingOverviewPage.repairAuthoritySectionPage.authorityLineSummaryPage.isAuthorityLineSummaryPageDisplayed());
//        commonUtils.getOpenClaimNo(planNo);
        Assert.assertTrue("Unable to verify Excess Collected Amount stamped in scheme",bookingOverviewPage.repairAuthoritySectionPage.authorityLineSummaryPage.isExcessPaymentStampedOnScheme(commonUtils.getOpenClaimNo(planNo)));
    }

    @Then("^I enter \"([^\"]*)\" and \"([^\"]*)\" on the product confirmation section for Heating for NPV$")
    public void iEnterOnTheProductConfirmationSectionforNonOemBoilers(String modelNumber, String faultCode) throws InterruptedException {
        Thread.sleep(3000);
        if (planViewPageNPV.productConfirmationHeating.isProductConfirmationPageDisplayed()) {
            planViewPageNPV.productConfirmationHeating.confirmModelAndBoilerFaultForNonOemBoilersPlans(modelNumber,faultCode);
        } else {
            LOGGER.info("Product Confirmation Page not Displayed");
        }
//        planViewPageNPV.productConfirmationHeating.verifyCxApplianceUsableSelect();
        Assert.assertTrue("Model not selected from the dropdown",planViewPageNPV.productConfirmationHeating.isProductConfirmationPageDisplayed());
    }

    @Given("^I create a Claim from API for WHPL \"([^\"]*)\"$")
    public void iCreateAClaimFromAPIForWhpl(String planNo) throws Throwable {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            commonUtils.createClaimFromAPI(planDetails.getPlanNumber("WHIRLPOOL"),
                    "REPAIRPLUSONE",
                    "PE2 7AB", "3", "INDE");

            Assert.assertTrue("Claim not verified", !commonUtils.getOpenClaimNo(planDetails.getPlanNumber()).isEmpty());
        } else {
            LOGGER.info("Claim can only be created for the plan created with in the Framework");
        }
    }

    @Then("I Verify the claim Status in plan history section as {string}")
    public void i_verify_the_claim_status_in_plan_history_section_as(String claimStatus) {
        if (!(planHistoryPage.isPlanHistorySectionDisplayed())) {
            Assert.assertTrue("Completed Claim status Verification failed in Claim history page, Expected claim status:" + claimStatus, planHistoryPage.verifyClaimStatus(claimStatus));
        }
        else
        {
            LOGGER.info("Plan History page is not displayed");
        }
    }
    @Then("I click on the claim number in plan history section and verify the claim status as {string}")
    public void i_click_on_the_claim_number_in_plan_history_section_and_verify_the_claim_status_as(String claimStatus) {
        planHistoryPage.clickClaimNoLinkWithStatusAS(claimStatus);
        if(!(planViewPageNPV.bookingOverviewPage.isBookingOverviewSectionDisplayed()))
        {
            base.switchToNextTab();
            Assert.assertTrue("Claim status Verification failed in Booking Overview page, Expected claim status:" +claimStatus , planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(claimStatus));
            base.navigateToMainTab();
        }
        else
        {
            LOGGER.info("Unable to open the claim with Status:"+claimStatus);
        }
    }
    @Then("I Verify the In-progress claim Job Status in plan history section {string}")
    public void i_verify_the_in_progress_claim_job_status_in_plan_history_section(String claimStatus) {
        if(!(planHistoryPage.isPlanHistorySectionDisplayed())) {
            base.navigateToMainTab();
            Assert.assertTrue("InProgress Claim status verification failed, Expected claim status:" + claimStatus, planHistoryPage.verifyClaimStatus(claimStatus));
        }
        else
        {
            LOGGER.info("Plan View page is not displayed");
        }
    }
    @Then("I click on the In-progress claim and verify the pop up {string}")
    public void i_click_on_the_in_progress_claim_and_verify_the_pop_up(String claimStatus) {

        planHistoryPage.clickClaimNoLinkWithStatusAS(claimStatus);
        if(!(planViewPageNPV.bookingOverviewPage.isBookingOverviewSectionDisplayed())) {
            base.switchToNextTab();
            Assert.assertTrue("Remedial Work Required Popup is not displayed", planViewPageNPV.bookingOverviewPage.verifyRemedialWorkRequiredPopUp());
        }
        else
        {
            LOGGER.info("Unable to open the claim with Status:"+claimStatus);
        }
    }


    @Then("I verify the Model id is prepopulated and enter fault code and click continue")
    public void i_verify_the_model_id_is_prepopulated_and_enter_fault_data_and_click_continue() {
        Assert.assertTrue("Model ID is not PrePopulated",  planViewPageNPV.productConfirmationPNC.verifyIfModelIdisPopulated());
        planViewPageNPV.productConfirmationPNC.enterFaultOnly();
        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }

    @And("^I click on Close Window button on Booking Overview Popup$")
    public void I_click_on_Close_Window_button_on_Booking_Overview_Popup() {
        bookingConfirmedPage.clickOnCloseWindowButton();
        Assert.assertTrue("Unable to verify the Plan view page", planViewPageNPV.isPageHeaderTitleDisplayed());
    }


    @And("^I click on the Open Claim button in the Plan View page$")
    public void I_click_on_the_Open_Claim_button_in_the_Plan_View_page() throws Throwable {
        Thread.sleep(3000);
        repairManagerSections.navigateToClaimOnNewTab();
    }

    @And("I verify the new plan number displayed correctly after clicking the Go to new plan button")
    public void iVerifyTheNewPlanNumberDisplayed() {
        Assert.assertTrue("New plan number not matching", planViewPageNPV.verifyNewPlanNumber());
    }


    @Then("I verify the previous plan number displayed correctly after clicking the Go to previous plan button")
    public void iVerifyThePreviousPlanNumberDisplayed() {
        Assert.assertTrue(" Previous plannumber not matching", planViewPageNPV.verifyPreviousPlanNumber());
    }

    @And("I enter {string} and confirm appliance details on the product confirmation section for Heating for NPV")
    public void iEnterOnTheProductConfirmationSectionForAsvOrLlscHeatingPlansForNPV(String make) {
        planViewPageNPV.productConfirmationHeating.confirmApplianceDetails(make);
    }
    @And("I enter {string} on the product confirmation section for ASV or LLSC Heating plans for NPV")
    public void iEnterOnTheProductConfirmationSectionForHeatingPlansForNPV(String modelNumber) throws InterruptedException {
        planViewPageNPV.productConfirmationHeating.confirmModelNumberForBoilerPlans(modelNumber);
    }

    @And("I verify boiler fault code section is not present on the product confirmation section")
    public void iVerifyBoilerFaultCodeSectionIsNotPresentOnTheProductConfirmationSection() {
        Assert.assertTrue(" Boiler fault code section is present", planViewPageNPV.productConfirmationHeating.verifyBoilerFaultCodeSectionIsNotPresent());
    }
    @And("I enter the actual model number and the Fault as {string}")
    public void iEnterTheActualModelNumberAndTheFaultAs(String fault) {
        planViewPageNPV.productConfirmationHeating.enterHeatingModelFromDropdwn();
        planViewPageNPV.productConfirmationHeating.enterFaultInputDataDropdown(fault);
    }

    @Then("I select the first open claim from Claim History popup")
    public void i_select_the_first_open_claim_from_Claim_History_popup() {
        repairManagerSections.selectClaimForInteraction();
    }

    @Then("I select the call reason")
    public void i_select_the_call_reason() {
        repairManagerSections.selectCallReason();
    }

    @Then("I click on Start New Interaction button")
    public void i_click_on_start_new_interaction_button() {
        repairManagerSections.clickOnStartNewInteractionButton();
    }

    @Then("I click on open Toolbox button")
    public void  i_click_on_open_Toolbox_button() {
        repairManagerSections.clickOnToolboxButton();
    }

    @And("I close New Appointment Reselection popup if still open")
    public void i_close_New_Appointment_Reselection_popup_if_still_open() {
        repairManagerSections.closeApptReselectionPopup();
    }

    @When("I click see other plans button and verify baby plan table is displayed")
    public void iClickSeeOtherPlansButtonAndVerifyBabyPlanTableIsDisplayed() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(" Baby plan view page is not displayed", planViewPageNPV.clickSeeOtherPlansButton());
        Thread.sleep(10000);
        Assert.assertTrue(" Baby plan view page is not displayed", babyPlanViewPage.isBabyPlanTableIsDisplayed());
    }

    @And("I verify PNC capture text has a valid description")
    public void iVerifyPNCCaptureTextHasAValidDescription() {
        Assert.assertTrue(" Baby plan view page is not displayedt", productConfirmationPNC.isPNCDescriptionDisplayed());
    }

    @When("I select no for PNC number and enter fault data and click continue")
    public void iSelectNoForPNCNumberAndEnterFaultDataAndClickContinue() {
        Assert.assertTrue("Unable to click PNC Y/N radio button or select appliance",  planViewPageNPV.productConfirmationPNC.enterPNCDetailsForNoToPNC());
//        planViewPageNPV.productConfirmationPNC.enterFaultData();
//        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isFaultDataEntered());
        planViewPageNPV.productConfirmationPNC.enterFaultDetailsForNoPNC();
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }

    @Then("I enter details on the product confirmation section for Fridge Freezer for NPV")
    public void iEnterDetailsOnTheProductConfirmationSectionForFridgeFreezerForNPV() {
        planViewPageNPV.productConfirmationWHP.confirmModel();
        planViewPageNPV.productConfirmationWHP.confirmFaultCode();
        planViewPageNPV.productConfirmationWHP.confirmProblemCode();
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }

    @Then("I verify the pop up for Accessory Only Exchange")
    public void iVerifyThePopUpForAccessoryOnlyExchange() {
        Assert.assertTrue("Unable to verify AOE Title", viewAccessories.isAccessoriesPageDisplayed());

    }

    @Then("I verify CX Appliance Usable field is displayed")
    public void iVerifyCXApplianceUsableFieldIsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue("CX Appliance field is not displayed",planViewPageNPV.productConfirmationHeating.isCXApplianceUsableFieldDisplayed());

    }

    @Then("I verify SN is prepopulated on the SN capture field for {string}")
    public void iVerifySNIsPrepopulatedOnTheSNCaptureFieldFor(String oem) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("SN field is not prepopulated", planViewPageNPV.productConfirmationHeating.isSNCaptureFieldPrePopulated());

    }


    @And("I enter the {string} and the {string}")
    public void iEnterTheAndThe(String model, String fault) {
        planViewPageNPV.productConfirmationHeating.isProductConfirmationPageDisplayed();
        planViewPageNPV.productConfirmationHeating.enterHeatingModelFromDropdwn();
        planViewPageNPV.productConfirmationHeating.enterFaultInputDataDropdown(fault);
    }

    @And("I select CX Appliance Usable as Yes and click on Continue")
    public void iSelectCXApplianceUsableAsYesAndClickOnContinue() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue("CX Appliance usable field is not present", planViewPageNPV.productConfirmationHeating.verifyCxApplianceUsableSelect());
        Thread.sleep(2000);
        planViewPageNPV.productConfirmationHeating.enterContinueButton();
        Thread.sleep(3000);
    }

    @Then("I check if SN is present on the getplandetails")
    public void iCheckIfSNIsPresentOnTheGetplandetails()  throws InterruptedException{
        Assert.assertTrue("SN is Avialble",planViewPageNPV.productConfirmationHeating.verifyIfSNIsPresentOnThePlan());
        Thread.sleep(2000);
    }

    @Then("I click on Yes button to provide the boilers serial number for {string} and enter SN")
    public void iClickOnYesButtonToProvideTheBoilersSerialNumberForAndEnterSN(String yesorno)throws InterruptedException {
        Thread.sleep(2000);
        planViewPageNPV.productConfirmationHeating.enterSNDetails(yesorno);
        Thread.sleep(2000);

    }


    @Then("I confirm view rule button is displayed on service option section")
    public void iConfirmViewRuleButtonIsDisplayedOnServiceOptionSection() {
        Assert.assertTrue("View rules button not displayed", planViewPageNPV.serviceOptionsPageNPV.isViewRuleIsDisplayed());
    }

    @And("I click on ViewRule button and verify RuleTable is displayed before selecting a Service Option")
    public void iClickOnViewRuleButtonAndVerifyRuleTableIsDisplayedBeforeSelectingAServiceOption() {
        planViewPageNPV.serviceOptionsPageNPV.clickOnViewRule();
        planViewPageNPV.serviceOptionsPageNPV.verifyRuleTableIsDisplayedBeforeSelectingAServiceOption();

    }

    @Then("I verify {string} and {string} on RuleTable before selecting a Service Option and close RuleTable popup")
    public void iVerifyAndOnRuleTableBeforeSelectingAServiceOptionAndCloseRuleTablePopup(String ruleID, String spAcronym) {
        planViewPageNPV.serviceOptionsPageNPV.verifyRuleIDAndServiceOption(ruleID,spAcronym);
        Assert.assertTrue("Unable to Click on the close button",  planViewPageNPV.serviceOptionsPageNPV.clickOnTheCloseButton());
    }

    @And("I click on confirm service option and proceed payment if asked")
    public void iClickOnConfirmServiceOptionAndProceedPaymentIfAsked(){
        planViewPageNPV.serviceOptionsPageNPV.clickOnConfirmServcieOptionOnReviewClaimPage();
    }

    @And("I select the <{string}> and click on view rule button")
    public void iSelectTheAndClickOnViewRuleButton(String serviceOption) {
//        planViewPageNPV.serviceOptionsPageNPV.selectServiceOption(serviceOption);
        planViewPageNPV.serviceOptionsPageNPV.clickOnViewRule();
    }

    @Then("I select {string} and verify view rule button is displayed")
    public void iSelectAndVerifyViewRuleButtonIsDisplayed(String serviceOption)throws InterruptedException {
        Thread.sleep(3000);
        planViewPageNPV.serviceOptionsPageNPV.selectServiceOption(serviceOption);
        Thread.sleep(3000);
        Assert.assertTrue("View rules button not displayed", planViewPageNPV.serviceOptionsPageNPV.isViewRuleIsDisplayed());
    }

    @Then("I click on ViewRule button and verify {string} towards {string} and Overflow Rule is displayed")
    public void iClickOnViewRuleButtonAndVerifyTowardsAndOverflowRuleIsDisplayed(String ruleID,String spAcronym)throws InterruptedException {
        planViewPageNPV.serviceOptionsPageNPV.clickOnViewRule();
        Thread.sleep(3000);
        planViewPageNPV.serviceOptionsPageNPV.verifyRuleIDAndServiceOption(ruleID,spAcronym);
        Thread.sleep(3000);
        planViewPageNPV.serviceOptionsPageNPV.verifyoverFlowRuleColumn();

    }

    @Then("I verify Additional OverFlow Rule ID and Table is dispalyed on RuleTable after selecting a Service Option and close RuleTable popup")
    public void iVerifyAdditionalOverFlowRuleIDAndTableIsDispalyedOnRuleTableAfterSelectingAServiceOptionAndCloseRuleTablePopup()throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Unable to verify OverFlow Rule Column",planViewPageNPV.serviceOptionsPageNPV.verifyOverFlowRuleID());
        Thread.sleep(3000);
        Assert.assertTrue("Unable to verify Additional OverFlow Rule Table",planViewPageNPV.serviceOptionsPageNPV.additionalOverflowRuleTableAfterSelectingAServiceOption());
        Thread.sleep(3000);
        Assert.assertTrue("Unable to Click on the close button",  planViewPageNPV.serviceOptionsPageNPV.clickOnTheCloseButton());
    }

    @And("I verify SPWarranty message and Override button is displayed")
    public void iVerifySPWarrantyMessageAndOverrideButtonIsDisplayed() {
        planViewPageNPV.serviceOptionsPageNPV.isSPWarrantyMessageDisplayed();
        planViewPageNPV.serviceOptionsPageNPV.isOverrideButtonDisplayed();
    }

    @And("I click on Override button to enter {string} and confirm to proceed")
    public void iClickOnOverrideButtonToEnterAndConfirmToProceed(String overrideReason) throws InterruptedException {
        planViewPageNPV.serviceOptionsPageNPV.clickOnOverrideButton();
        planViewPageNPV.serviceOptionsPageNPV.selectOverrideReason(overrideReason);
        Thread.sleep(5000);
    }

    @And("I click on Close window button on Booking confirmation popup")
    public void iClickOnCloseWindowButtonOnBookingConfirmationPopup() {
        Assert.assertTrue("Unable to click the Button Close window ", planViewPageNPV.bookingConfirmedPageNPV.clickOnCloseWindowButton());
    }

    @And("I verify the DG Warranty repair icon displayed and click the icon to verify the previous claim details is displayed")
    public void iVerifyTheDGWarrantyRepairIconDisplayedAndClickTheIconToVerifyThePreviousClaimDetailsIsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue("DG warranty Icon not present",planViewPageNPV.bookingOverviewPage.verifyIfDgWarrantyIconDisplayed());
        Assert.assertTrue("DG warranty popup not displayed",planViewPageNPV.bookingOverviewPage.verifyDgWarrantyDetailsPopup());
        Assert.assertTrue("Service notes on DG warranty popup dosen't matched",planViewPageNPV.bookingOverviewPage.verifyServiceReportNotes());
        Assert.assertTrue("Claim number on DG warranty popup does not match with the previous claim details",planViewPageNPV.bookingOverviewPage.verifyPreviousClaimDetailsOnDgWarrantyRepairPopup());
    }

    @Then("I verify that the Product Replacement claim is created in plan history section")
    public void i_verify_that_the_product_replacement_claim_is_created_in_plan_history_section() {
        Assert.assertTrue("Product Replacement claim is not created",planHistoryPage.verifyIfPRClaimCreated());
    }
    @Then("I enter the Hoover Candy Fault Data and click continue")
    public void iEnterHooverCandyFaultData() throws InterruptedException {
        Thread.sleep(2000);
        planViewPageNPV.productConfirmationHoover.enterFault();
        Thread.sleep(2000);
        if (planViewPageNPV.productConfirmationHeating.isCXApplianceUsableFieldDisplayed()) {
            Assert.assertTrue("CX Appliance usable field is not present", planViewPageNPV.productConfirmationHeating.verifyCxApplianceUsableSelect());
            planViewPageNPV.productConfirmationPNC.enterContinueButton();
        }else{
            planViewPageNPV.productConfirmationPNC.enterContinueButton();
        }
//        Assert.assertTrue("DG warranty Icon not present",planViewPageNPV.bookingOverviewPage.verifyIfDgWarrantyIconDisplayed());
    }
    @And("I enter valid serial number for Baxi")
    public void iEnterValidSerialNumberForBaxi() {
        Assert.assertTrue("Unable to validate Serial Number", planViewPageNPV.productConfirmationHeating.enterSNDetailsForBaxi());
    }

    @Then("I open the claim with Type {string}")
    public void I_open_the_claim_with_Type (String claimType) {
        planHistoryPage.openClaimWithTypeAs(claimType);
    }


    @When("^I enter the PNC Details and fault data and click continue for Cooker$")
    public void iEnterThePNCDetailsForCooker() throws InterruptedException {
        planViewPageNPV.productConfirmationPNC.enterPNCDetails();
        Thread.sleep(5000);
        planViewPageNPV.productConfirmationPNC.enterFaultDataforCooker();
//        Assert.assertTrue("Fault data not entered", planViewPageNPV.productConfirmationPNC.isFaultDataEntered());
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }


    @Then("I click on Repair Manager button in plan view page")
    public void iClickOnRepairManagerButtonInPlanViewPage() {
        repairManagerSections.clickOnRepairManagerButtonInPlanView();
    }
    @And("I enter valid serial number for Beko")
    public void iEnterValidSerialNumberForBeko() {
        planViewPageNPV.productConfirmationHeating.enterSNDetailsForBeko();
    }

    @And("I click {string} radio button to provide the boilers serial number")
    public void iClickRadioButtonToProvideTheBoilersSerialNumber(String yesOrNoToSN) {
        planViewPageNPV.productConfirmationHeating.clickYesOrNoToProvideBoilersSerialNumber(yesOrNoToSN);
    }


    @Then("select the first open claim from Claim History popup")
    public void select_the_first_open_claim_from_Claim_History_popup() {
        repairManagerSections.selectClaimForInteraction();
    }

    @Then("select the call reason")
    public void select_the_call_reason() {
        repairManagerSections.selectCallReason();
    }

    @Then("click on Start New Interaction button")
    public void click_on_start_new_interaction_button() {
        repairManagerSections.clickOnStartNewInteractionButton();
    }

    @Then("click on open Toolbox button")
    public void click_on_open_Toolbox_button() {
        repairManagerSections.clickOnToolboxButton();
    }

    @And("^I click on Reselection button to Rebook or Reselect an appointment$")
    public void i_click_on_Reselection_button_to_rebook_reselect_an_appointment() {
        repairManagerSections.clickOnReselectionButton();
    }

    @And("close New Appointment Reselection popup if still open")
    public void close_New_Appointment_Reselection_popup_if_still_open() {
        repairManagerSections.closeApptReselectionPopup();
    }

    @Then("I click claim number with {string}")
    public void iClickClaimNumberWith(String claimStatus) {
        planHistoryPage.clickClaimNoLinkWithStatusAS(claimStatus);
        base.switchToNextTab();
    }

    @And("I verify and close the Alert Popup if present")
    public void I_verify_and_close_the_Alert_Popup_if_present() {
        planViewPageNPV.verifyAndCloseAlertPopup();
    }

    @And("^I click on Continue button in Call Out Charge Pop up for New Plan View$")
    public void clickOnContinueButtonInCallOutChargePopUp() throws InterruptedException {
        if (planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed()) {
            Assert.assertTrue("WaiveExcess Page not displayed", planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed());
//            planViewPageNPV.claimPaymentRequiredPage.clickOnContinueButtonInCallOutChargePopUp();
        } else {
            LOGGER.info("Step Skipped : No Excess waive popup displayed");
        }
    }

    @And("^I waive off the Call Out Charges via Waive Charges link in Service Option for NPV$")
    public void iClickOnWaiveChargesLinkInServiceOption() throws InterruptedException {
        planViewPageNPV.claimPaymentRequiredPage.clickOnWaiveChargesLinkinServiceOption();
//            Assert.assertTrue("Waive Call Out Charge Pop Up Page not displayed", planViewPageNPV.claimPaymentRequiredPage.isPopUpDisplayed());
        planViewPageNPV.claimPaymentRequiredPage.proceedToWaiveCallOutCharge();
        Thread.sleep(4000);
//        } else {
//            LOGGER.info("Step Skipped : No Excess waive popup displayed");
//        }
    }


    @Then("I open the claim with Status {string}")
    public void I_open_the_claim_with_Status (String claimStatus) {
        base.hardWait("3000");
        planHistoryPage.clickClaimNoLinkWithStatusAS(claimStatus);
        base.navigateToRecentTab();
    }

    @Then("I get the Repairer Reference no and Appointment Date")
    public void I_get_the_Repairer_Reference_no_and_Appointment_Date () {
        bookingConfirmedPage.getRepairReferenceNo();
        bookingConfirmedPage.getAppointmentDate();
    }

    @Then("I verify the claim status as {string}")
    public void I_verify_the_claim_status_as(String claimStatus) {
        if(!(planViewPageNPV.bookingOverviewPage.isBookingOverviewSectionDisplayed()))
        {
            base.switchToNextTab();
            Assert.assertTrue("Claim status Verification failed in Booking Overview page, Expected claim status:" +claimStatus , planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(claimStatus));
        }
        else
        {
            LOGGER.info("Unable to open the claim with Status:"+claimStatus);
        }
    }
}