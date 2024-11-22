package com.test.steps;

import com.test.pages.CCAgentUI_NPV.CustomerContact.BankAccountDetailsCapturePage;
import com.test.pages.CCAgentUI_NPV.HomePageNPV;
import com.test.pages.CCAgentUI_NPV.MyWorkQTask.WorkQTask;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgent_OLDUI.*;
import com.test.pages.CCAgent_OLDUI.DialogPopups.ConfirmIMEIOverrideOnADifferentPlan;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkQTaskStepDef {

    private BasePage base;
    private OrbitHomePage homePage;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private ProductConfirmationPage productConfirmationPage;
    private CallOutChargePopupPage callOutChargePopupPage;
    private PlanDetails planDetails;
    private CommonUtils commonUtils;
    private ConfirmIMEIOverrideOnADifferentPlan overrideClaim;
    private PlanViewPageNPV planViewPageNPV;
    private HomePageNPV homePageNPV;
    private WorkQTask workQTask;
    public BankAccountDetailsCapturePage bankAccountDetailsCapturePage;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public WorkQTaskStepDef(BasePage basePage,
                            SeleniumHelper seleniumHelper,
                            OrbitHomePage homePage,
                            ProductConfirmationPage productConfirmationPage,
                            CallOutChargePopupPage callOutChargePopupPage,
                            CommonUtils commonUtils,
                            PlanDetails planDetails,
                            ConfirmIMEIOverrideOnADifferentPlan overrideClaim,
                            PlanViewPageNPV planViewPageNPV,
                            HomePageNPV homePageNPV,
                            WorkQTask workQTaskPage,
                            BankAccountDetailsCapturePage bankAccountDetailsCapturePage) {
        this.base = basePage;
        this.homePage = homePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.productConfirmationPage = productConfirmationPage;
        this.callOutChargePopupPage = callOutChargePopupPage;
        this.planDetails = planDetails;
        this.commonUtils = commonUtils;
        this.overrideClaim = overrideClaim;
        this.planViewPageNPV = planViewPageNPV;
        this.homePageNPV = homePageNPV;
        this.workQTask = workQTaskPage;
        this.bankAccountDetailsCapturePage = bankAccountDetailsCapturePage;

    }

    @And("^I verify the WorkQ task Alert confirmation pop up displayed$")
    public void i_verify_the_workq_task_alert_confirmation_pop_up_displayed() throws Throwable {
        Assert.assertTrue("Unable to verify WQTask Alert popup ", workQTask.isWorkQAlertConfirmPopUpDisplayed());
        workQTask.clickOnWorkQConfirmPopUp();
    }

    @Then("^I click on the WorkQ Task tab in the Plan History section$")
    public void i_click_on_the_workq_task_tab_in_the_plan_history_section() throws Throwable {
        workQTask.clickOnWorkQTaskTabPlanHistory();
        Assert.assertTrue("Unable to verify WQTask ID", workQTask.isWorkQTaskOnPlanHistorySectionDisplayed());
    }

    @And("^I verify the WorkQ task created via customer contact present in MyWorkQ Task and mark it completed$")
    public void i_verify_the_workq_task_created_via_customer_contact_present_in_myworkq_task_and_mark_it_completed() throws Throwable {
        workQTask.verifyTaskReferenceWithMyWorkQTaskAndCompletedNew();
        Assert.assertTrue("Unable to verify WQTask completed", workQTask.isCurrentWorkQTaskDisplayed());
    }

    @Then("I verify the Bank account validation error message displayed")
    public void iVerifyTheBankAccountValidationErrorMessageDisplayed() {
        Assert.assertTrue("Unable to verify", bankAccountDetailsCapturePage.isBankDetailsInvalidErrorDisplayed());
    }

    @And("^I navigate to WorkQ task created$")
    public void i_NavigateTomywork_task() throws Throwable {
        workQTask.clickCurrentWorkQTaskReference();
        Assert.assertTrue("Unable to verify WQTask detailed page", workQTask.isTaskDetailsSectionPageDisplayed());
    }

    @Then("I verify the Bank account details Masked {string}")
    public void iVerifyTheBankAccountDetailsMasked(String sortCode_BankAccnt) {
        String[] bankDetails = sortCode_BankAccnt.split("\\,");
        Assert.assertTrue("Unable to verify bank details",
                workQTask.otTaskPage.isBankAccountdetailsSectionMasked(bankDetails[0].replace("-", ""), bankDetails[1]));
    }

    @And("I verify the Bank account details revealed {string}")
    public void iVerifyTheBankAccountDetailsRevealed(String sortCode_BankAccnt) {
        String[] bankDetails = sortCode_BankAccnt.split("\\,");
        Assert.assertTrue("Unable to verify bank details",
                workQTask.otTaskPage.isBankAccountdetailsSectionRevealed(bankDetails[0].replace("-", ""), bankDetails[1]));
    }

    @And("I mark the workQ task as completed")
    public void iMarkTheWorkQTaskAsCompleted() {
        workQTask.otTaskPage.clickMarkCompletedButton();
        Assert.assertTrue("Unable to verify WQTask completed", workQTask.isCurrentWorkQTaskDisplayed());

    }

    @Then("I verify task has been created on the WorkQ Task tab in the Plan History section")
    public void iVerifyTaskHasBeenCreatedOnTheWorkQTaskTabInThePlanHistorySection() {
        workQTask.clickOnWorkQTaskTabPlanHistory();
        Assert.assertTrue("Unable to verify WQTask ID", workQTask.isWorkQTaskOnPlanHistorySectionDisplayed());
    }

    @And("I verify the D&G Customer ID field is present")
    public void iVerifyTheCustomerIDFieldIsPresent() {
        Assert.assertTrue("Unable to verify D&G Customer ID",
                workQTask.otTaskPage.isCustomerIDFieldIsPresent());
    }
}
