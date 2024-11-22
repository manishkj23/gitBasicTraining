package com.test.steps;

import com.test.pages.CCAgentUI_NPV.RepairManager.RADataPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RepairManagerNPVStepDef {

    private RADataPage RAData;

    public RepairManagerNPVStepDef(RADataPage RAData) {

        this.RAData = RAData;
    }

    @Then("^I select plan option \"([^\"]*)\" from RA Data panel and verify Expiry date \"([^\"]*)\" is displayed$")
    public void i_select_plan_option_from_ra_data_panel_and_verify_Expiry_date_is_displayed(String planOption,String expiryDate) throws InterruptedException {
        Assert.assertTrue("Expiry date is not displayed ", RAData.VerifyExpiryDate(planOption,expiryDate));
    }

    @Then("^I validate \"([^\"]*)\" under Plan Expiry Date$")
    public void i_validate_expiry_date_value_under_plan_expiry_date(String expiryDateValue) throws InterruptedException {
        Assert.assertTrue("Expiry Date is mismatched ", RAData.isPlanDateValueDisplayed(expiryDateValue));
    }
    @Then("^I click Open claim and navigate to Repair Authority page$")
    public void iClickOpenClaimAndNavigateToRepairAuthorityPage() {
        RAData.clickOpenCliam();

    }

    @Then("^I select Authority Line summary page option$")
    public void iSelectAuthorityLineSummaryPageOption() throws InterruptedException {
        Thread.sleep(3000);
        RAData.clickSummaryLink();
        Thread.sleep(3000);

    }

    @Then("I select Scheme and verify renewal {string}")
    public void iSelectSchemeAndVerifyRenewal(String date) throws InterruptedException {
        RAData.clickSchemeAndVerifyRenewalDate(date);

    }


    @Then("I select {string} and {string} and click on Start New Interaction")
    public void iSelectAndAndClickOnStartNewInteraction(String ddpropdown1, String dropdown2) {
    }


}

