package com.test.steps;

import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanHistory.PlanHistoryPage;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class HeatingReplacementJobStepDef {

    private BasePage base;
    private OrbitHomePage homePage;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    public HeatingReplacementPage heatingReplacementPage;
    private PlanViewPageNPV planViewPageNPV;
    private PlanHistoryPage planHistoryPage;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public HeatingReplacementJobStepDef(BasePage basePage,
                                        OrbitHomePage homePage,
                                        SeleniumHelper seleniumHelper,
                                        HeatingReplacementPage heatingReplacementPage,
                                        PlanViewPageNPV planViewPageNPV,
                                        PlanHistoryPage planHistoryPage) {
        this.base = basePage;
        this.homePage = homePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.heatingReplacementPage = heatingReplacementPage;
        this.planViewPageNPV = planViewPageNPV;
        this.planHistoryPage = planHistoryPage;
    }

    @Then("I click on {string} tab")
    public void i_click_on_heating_Replacement_tab(String tabName) {
        planViewPageNPV.bookingOverviewPage.clickLeftMenuItem(tabName);
        base.hardWait("3000");
    }

    @Then("I update the Replacement Job status as {string}")
    public void i_update_the_Replacement_Job_status_as(String status) throws InterruptedException {
        heatingReplacementPage.updateStatusAs(status);
    }

    @Then("I verify the Replacement Job status is updated as {string}")
    public void i_verify_the_Replacement_Job_status_is_updated_as(String status) {
        base.hardWait("3000");
        Assert.assertTrue("Replacement Job status is not updated", planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(status));
    }

    @Then("I verify the claim status is updated as {string} in plan history section")
    public void i_verify_the_claim_status_is_updated_as_in_plan_history_section(String status) {
        base.navigateToMainTab();
        base.refreshPage();
        Assert.assertTrue("Replacement Job status is not updated", planHistoryPage.verifyClaimStatus(status));
    }

    @Then("I enter the reason for Quote Rejection as {string}")
    public void i_enter_the_reason_for_Quote_Rejection_as(String reason) {
        heatingReplacementPage.updateRejectionReasonAs(reason);
    }

    @Then("I add Manual customer communication as {string} with type {string} and outcome {string}")
    public void i_add_manual_customer_communication_as_with_type_and_outcome(String notes, String type, String outcome) {
        heatingReplacementPage.addManualCommunication(notes, type, outcome);
    }

    @Then("I enter the Boiler details in update status dialog as")
    public void i_enter_the_boiler_details_in_update_status_dialog_as(DataTable dataTable) {
        List<Map<String, String>> fields = dataTable.asMaps(String.class, String.class);
        System.out.println(fields.get(1));
        heatingReplacementPage.fillNewBoilerDetails(fields.get(0).get("Data"),fields.get(1).get("Data"),fields.get(2).get("Data"),fields.get(3).get("Data"));
    }

    @Then("I verify the Service Provider of the PR job as {string} in plan history section")
    public void i_verify_the_Service_Provider_of_the_PR_job_as_in_plan_history_section(String sp) {
        Assert.assertTrue("Service Provider verified successfully", planHistoryPage.verifyPRServiceProvider(sp));
    }
}
