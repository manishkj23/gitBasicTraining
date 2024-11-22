package com.test.steps;


import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanWriteOff;
import com.test.pages.CCAgentUI_NPV.CustomerContact.BankAccountDetailsCapturePage;
import com.test.pages.CCAgentUI_NPV.HomePageNPV;
import com.test.pages.CCAgentUI_NPV.MyWorkQTask.WorkQTask;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgent_OLDUI.*;
import com.test.pages.CCAgent_OLDUI.DialogPopups.ConfirmIMEIOverrideOnADifferentPlan;
import com.test.pages.CCAgent_OLDUI.DialogPopups.RepeatRepairNotice;
import com.test.pages.CCAgent_OLDUI.ProductConfirmationSections.ProductConfirmationMobile;
import com.test.pages.DataTools.SessionCachePage;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.pages.SiteMap.Whirlpoolimport.ImportJobWhirlpool;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitJobImports.Whirlpool.JobImportUtilityWhirlpool;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerContactStepDef {

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
    private CommonUtils commonUtils;
    private SessionCachePage cachePage;
    private APIIntegrator apiHook;
    private ConfirmIMEIOverrideOnADifferentPlan overrideClaim;
    private ProductConfirmationMobile mobileProductConfirmation;
    private RepeatRepairNotice repairNotice;
    private PlanWriteOff planWriteOff;
    private PlanViewPageNPV planViewPageNPV;
    private HomePageNPV homePageNPV;
    private JobImportUtilityWhirlpool whirlpoolImportFile;
    private ImportJobWhirlpool whirlpoolJobImportPage;
    private WorkQTask workQTask;
    public HistoricASVCommunicationsPage historicASVCommunicationsPage;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public CustomerContactStepDef(BasePage basePage,
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
                                  CommonUtils commonUtils,
                                  PlanDetails planDetails,
                                  SessionCachePage cachePage,
                                  APIIntegrator apiHook,
                                  ConfirmIMEIOverrideOnADifferentPlan overrideClaim,
                                  ProductConfirmationMobile mobileProductConfirmation,
                                  RepeatRepairNotice repairNotice,
                                  PlanWriteOff planWriteOff,
                                  PlanViewPageNPV planViewPageNPV,
                                  HomePageNPV homePageNPV,
                                  JobImportUtilityWhirlpool whirlpoolImportFile,
                                  ImportJobWhirlpool whirlpoolJobImportPage,
                                  WorkQTask workQTaskPage) {
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
        this.commonUtils = commonUtils;
        this.cachePage = cachePage;
        this.apiHook = apiHook;
        this.overrideClaim = overrideClaim;
        this.mobileProductConfirmation = mobileProductConfirmation;
        this.repairNotice = repairNotice;
        this.planWriteOff = planWriteOff;
        this.planViewPageNPV = planViewPageNPV;
        this.homePageNPV = homePageNPV;
        this.whirlpoolImportFile = whirlpoolImportFile;
        this.whirlpoolJobImportPage = whirlpoolJobImportPage;
        this.workQTask = workQTaskPage;
        this.historicASVCommunicationsPage = historicASVCommunicationsPage;

    }

    @Then("^I click on Customer Contact button in plan view page$")
    public void _click_on_customer_contact_button_in_plan_view_page() throws Throwable {
        planViewPageNPV.clickOnCustomerContactButtonInPlanView();
        Thread.sleep(10000);
    }

    @Then("^I verify Q&A section display for WorldPay Credit Card Payment$")
    public void i_verify_qa_section_display_for_worldpay_credit_card_payment() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Unable to verify WorldPay QA tree",qandAProcessPage.hasWorldPayQuestionSectionDisplayed());
    }

    @And("^I verify Value to Collect textbox having amount greater than zero and click on Next Button in WorldPay QA$")
    public void i_verify_value_to_collect_textbox_having_amount_greater_than_zero() throws Throwable {
        Assert.assertTrue("Unable to click on Next button in WorldPay QA",qandAProcessPage.isWorldPayQANextButtonEnabled());
        qandAProcessPage.verifyPaymentAmountAndClickOnNextButton();
    }

    @Then("^I click on Take Payment and enter Billing details and Confirm in Payment Due pop up$")
    public void i_click_on_take_payment_and_enter_billing_details_and_confirm_in_payment_due_pop_up() throws Throwable {
        Assert.assertTrue("Unable to click on Take Button",planViewPageNPV.claimPaymentRequiredPage.isWorldPayTakePaymentButtonDisplayed());
        planViewPageNPV.claimPaymentRequiredPage.enterPaymentDetailsAndConfirm();
    }
    @And("^I enter the card details in the WorldPay Card Payment page$")
    public void i_enter_the_card_details_in_the_worldpay_card_payment_page() throws Throwable {
        planViewPageNPV.claimPaymentRequiredPage.outstandingDDPaymentProcess();
    }


    @Then("I verify Historic ASV comms are displayed along with plan number and claim number")
    public void iVerifyHistoricASVCommsAreDisplayedAlongWithPlanNumberAndClaimNumber() {
        Assert.assertTrue("Unable to verify", historicASVCommunicationsPage.isHistoricASVCommunicationsDisplayed());

    }
}
