package com.test.steps;

import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.CCAgent_OLDUI.SiteMapPage;
import com.test.pages.CCAgentUI_NPV.OrbitSiteMapPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class SiteMapDashboardStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private SiteMapPage siteMap;
    private OrbitHomePage orbitHomePage;
    private OrbitSiteMapPage orbitSiteMap;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClaimStepDef.class);

    public SiteMapDashboardStepDef(BasePage basePage, SeleniumHelper seleniumHelper, SiteMapPage siteMap, OrbitHomePage orbitHomePage, OrbitSiteMapPage orbitSiteMap) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.siteMap = siteMap;
        this.orbitHomePage = orbitHomePage;
        this.orbitSiteMap = orbitSiteMap;
    }

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click search$")
    public void i_click_sitemap_and_i_enter_something_and_click_search(String searchValue) throws InterruptedException {
        orbitHomePage.clickSiteMap();
        Thread.sleep(5000);
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isSiteMapPageLoaded());
        Thread.sleep(5000);
        orbitSiteMap.searchAndClickWizard(searchValue);
    }

    @And("^I verify ASV-LSC dashboard page loaded successfully$")
    public void iVerifyAsvLscDashboardLoadedSuccessfully() throws InterruptedException {
        Assert.assertTrue("SiteMap Page Loaded", orbitSiteMap.isAsvLscDashboardLoaded());
        Thread.sleep(5000);
    }

    @Then("^I verify all buttons are present and enabled$")
    public void iVerifyAllButtonsArePresentAndEnabled() throws InterruptedException {
        orbitSiteMap.isAllButtonAndBoxEnabled();
        Thread.sleep(3000);
    }

    @Then("^I verify Date Booked Radio button and MTD auto select or not$")
    public void i_verify_date_booked_radio_button_auto_select_or_not() throws InterruptedException {
        orbitSiteMap.isDateBookedRadioButtonMTDButtonSelected();
        Thread.sleep(3000);
    }

    @Then("^I verify new column added successfully$")
    public void i_verify_new_column_added_successfully() throws InterruptedException {
        Assert.assertTrue("New Columns are not added in the ASV Dashboard", orbitSiteMap.verifyTwoNewColumnAddedInAsvDashboard());
        Thread.sleep(3000);
    }

    @Then("^I verify Reassign SP DeemedDone Cancel buttons are available$")
    public void i_verify_reassign_sp_deemeddone_cancel_buttons_are_available() {
        orbitSiteMap.verifyReassignSPDeemedDoneCancelButtonEnabled();
    }

    @Then("^I verify D&G Custom Report pop up displayed successfully$")
    public void i_verify_dg_custom_report_pop_up_displayed_successfully() throws InterruptedException {
        orbitSiteMap.verifyDGCustomReportForm();
        Thread.sleep(2000);
    }

    @Then("^I verify Report Type field and dropdown is available$")
    public void i_verify_report_type_field_and_dropdown_is_available() {
        orbitSiteMap.verifyReportTypeAndDropdownDisplayed();
    }

    @And("^I click on Report Type dropdown and verify \"([^\"]*)\" is present$")
    public void i_click_on_report_type_field_dropdown_verify_something_is_present(String dropdownValue) {
        orbitSiteMap.clickOnReportTypeDropdownAndVerifyInFlightReport(dropdownValue);
    }

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click on the wizard$")
    public void i_click_sitemap_and_i_enter_something_and_click_on_the_wizard(String searchvalue) throws Throwable {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded", siteMap.isSiteMapPageLoaded());
        Thread.sleep(3000);
        orbitSiteMap.searchAndClickonServiceProviderWizard(searchvalue);
        Thread.sleep(3000);
    }

    @And("^I verify Service Provider page loaded successfully$")
    public void i_verify_service_provider_page_loaded_successfully() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Service provider page is not displayed", orbitSiteMap.isServiceProviderPageDisplayed());
    }

    @Then("^I enter \"([^\"]*)\" in the Company Name column in Service Provider grid$")
    public void i_enter_something_in_the_company_name_column_in_service_provider_grid(String companyname) throws Throwable {
        Thread.sleep(4000);
        orbitSiteMap.enterCompanyNameInTheServiceProviderGrid(companyname);
    }

    @And("^I select the first row in the Service Provider grid and click on Edit button$")
    public void i_select_the_first_row_in_the_service_provider_grid_and_click_on_edit_button() throws Throwable {
        Thread.sleep(4000);
        orbitSiteMap.clickOnTheRowInTheServiceProviderGrid();
    }

    @Then("^I verify the new Indicator present in Update Service Provider$")
    public void i_verify_the_new_indicator_present_in_update_service_provider() throws Throwable {
        Thread.sleep(30000);
        orbitSiteMap.verifyNewIndicatorUpdateServiceProvider();
    }

    @Then("^I click on YES radio button to set the new indicator and save it$")
    public void i_click_on_yes_radio_button_to_set_the_new_indicator_and_save_it() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Not able to click on YES radio button", orbitSiteMap.clickOnYesRadioButtonToSetNewIndicator());
        Thread.sleep(3000);
        orbitSiteMap.clickOnSaveButtonInServiceProviderForm();
        Thread.sleep(10000);
    }

    @Then("^I click on NO radio button to set the new indicator and save it$")
    public void i_click_on_no_radio_button_to_set_the_new_indicator_and_save_it() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Not able to click on NO radio button", orbitSiteMap.clickOnNoRadioButtonToSetNewIndicator());
        Thread.sleep(3000);
        orbitSiteMap.clickOnSaveButtonInServiceProviderForm();
        Thread.sleep(10000);
    }

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click on the Dashboard wizard$")
    public void iClickSitemapAndClickDashboardWizard(String searchvalue) throws Throwable {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded", siteMap.isSiteMapPageLoaded());
        orbitSiteMap.searchAndClickonDashboardWizard(searchvalue);
    }

    @And("^I verify Dashboard Filter Group page loaded successfully$")
    public void i_verify_dashboard_filter_group_page_loaded_successfully() throws Throwable {
        Assert.assertTrue("SiteMap Page not Loaded", orbitSiteMap.isDashboardFilterGroupPageLoaded());
        Thread.sleep(3000);
    }

    @Then("^I click on Insert button in Dashboard Filter group$")
    public void i_click_on_insert_button_in_dashboard_filter_group() throws Throwable {
        orbitSiteMap.clickOnInsertButtonInDashboardFilterGroup();
        Thread.sleep(3000);
    }


    @And("^I click on Save button in Insert Dashboard Filter Group form$")
    public void i_click_on_save_button_in_insert_dashboard_filter_group_form() throws Throwable {
        orbitSiteMap.clickOnSaveButtonInDashboardFilterGroup();
        Thread.sleep(3000);
    }

    @Then("^I verify error message appear after I click on Save button$")
    public void i_verify_error_message_appear_after_i_click_on_save_button() throws Throwable {
        orbitSiteMap.verifyErrorMessageInDashboardFilterGroup();
        Thread.sleep(3000);

    }

    @Then("^I select the option from Dashboards dropdown$")
    public void i_select_the_option_from_dashboards_dropdown() throws Throwable {
        orbitSiteMap.clickOnDashboardsDropdown();
    }

    @And("^I verify error message disappear$")
    public void i_verify_error_message_disappear() throws Throwable {
        orbitSiteMap.verifyErrorMessageDisappearInDashboardsDropdown();
    }

    @Then("I verify the DG Warranty Days field is present in Update Service Provider")
    public void iVerifyTheDGWarrantyDaysFieldIsPresentInUpdateServiceProvider() throws Throwable {
        Thread.sleep(30000);
        orbitSiteMap.verifyDGWarrantyDaysInUpdateServiceProvider();
    }

    @Then("I enter DG warranty days set to {string} and save it")
    public void iEnterDGWarrantyDaysSetToAndSaveIt(String dgWarrantyDays) throws InterruptedException {
        orbitSiteMap.enterDGWarrantyDays(dgWarrantyDays);
        orbitSiteMap.clickOnSaveButtonInServiceProviderForm();
        Thread.sleep(10000);
    }

    @And("^I verify Whirlpool Job Import Wizard popup loaded successfully$")
    public void iVerifyWhirlpoolJobImportWizardPopupLoadedSuccessfully() throws InterruptedException {
        Assert.assertTrue("Whirlpool Job Import Wizard popup loaded successfully",orbitSiteMap.isWHPJobImportWizardLoaded());
        Thread.sleep(5000);
    }

    @And("^I upload the WHP Tracking file$")
    public void iUploadTheWHPTrackingFile() throws InterruptedException, AWTException {
        orbitSiteMap.uploadWHPTrackingFile();
        Assert.assertTrue("Whirlpool Job Import done successfully",orbitSiteMap.verifyJobImportConfirmationPopup());
    }

    @Given("I click SiteMap and I enter {string} and click on Overflow Rules UI wizard")
    public void iClickSiteMapAndIEnterAndClickOnOverflowRulesUIWizard(String searchvalue) throws Throwable {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded", siteMap.isSiteMapPageLoaded());
        Thread.sleep(3000);
        orbitSiteMap.searchAndClickonOverFlowRulesUIWizard(searchvalue);
        Thread.sleep(3000);
    }

    @And("I verify D&G Overflow Rules page loaded successfully")
    public void iVerifyDGOverflowRulesPageLoadedSuccessfully() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("OverFlow Rules UI page is not displayed", orbitSiteMap.isOverFlowRuleUIPageDisplayed());
    }

    @Then("I click Show Inactive checkbox D&G Overflow Rules page")
    public void iClickShowInactiveCheckboxDGOverflowRulesPage() throws Throwable {
        Thread.sleep(4000);
        orbitSiteMap.clickOnShowInactiveCheckBox();
    }

    @Then("I enter RuleID {string} in the ID column and select the first row in the DG OverFlow UI grid and click on Edit button")
    public void iEnterRuleIDInTheIDColumnAndSelectTheFirstRowInTheDGOverFlowUIGridAndClickOnEditButton(String ruleID) throws Throwable {
        Thread.sleep(1000);
        orbitSiteMap.enterRuleIDinOverFlowUIGrid(ruleID);
        orbitSiteMap.clickOnTheRowInOverFlowUIGrid();

    }


    @Then("I verify Update Overflow Rule popup loaded successfully and set status")
    public void iVerifyUpdateOverflowRulePopupLoadedSuccessfullyAndSetStatus()throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Unable to set the status", orbitSiteMap.setStatusToActiveInUpdateOverFlowRule());

    }

    @Then("I click on save button for Update Overflow Rule")
    public void iClickOnSaveButtonForUpdateOverflowRule() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue("Unable to click save button", orbitSiteMap.clickOnSaveButtonInUpdateDGOverFlowRule());
    }

    @Given("I click SiteMap and I enter {string} and click on Risk Rules wizard")
    public void iClickSiteMapAndIEnterAndClickOnRiskRulesWizard(String searchvalue) throws Throwable {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded", siteMap.isSiteMapPageLoaded());
        Thread.sleep(3000);
        orbitSiteMap.searchAndClickonRiskRulesWizard(searchvalue);
        Thread.sleep(3000);
    }

    @And("I verify Risk Rules page loaded successfully")
    public void iVerifyRiskRulesPageLoadedSuccessfully() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Risk Rules page is not displayed", orbitSiteMap.isRiskRulesPageDisplayed()); }

    @Then("I click Show Inactive checkbox Risk Rules page")
    public void iClickShowInactiveCheckboxRiskRulesPage()throws Throwable {
        Thread.sleep(4000);
        orbitSiteMap.clickOnShowInactiveCheckBox();
    }

    @Then("I enter RuleID {string} in the ID column and select the first row in the Risk Rule grid and click on Edit button")
    public void iEnterRuleIDInTheIDColumnAndSelectTheFirstRowInTheRiskRuleGridAndClickOnEditButton(String ruleID)  throws Throwable {
        Thread.sleep(1000);
        orbitSiteMap.enterRuleIDinRiskRulesGrid(ruleID);
        orbitSiteMap.clickOnTheRowInRiskRulesGrid();

    }

    @Then("I verify Update Risk Rule popup loaded successfully and Edit Plan Age as {string} and set status")
    public void iVerifyUpdateRiskRulePopupLoadedSuccessfullyAndEditPlanAgeAsAndSetStatus(String planAge) throws Throwable {
        Thread.sleep(3000);
        orbitSiteMap.editPlanAge(planAge);
        Assert.assertTrue("Unable to set the status", orbitSiteMap.setStatusToActiveInUpdateRiskRule());
    }

    @Then("I click on save button for Update Risk Rule")
    public void iClickOnSaveButtonForUpdateRiskRule() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue("Unable to click save button", orbitSiteMap.clickOnSaveButtonInUpdateRiskRule());
    }

    @And("^I verify Whirlpool Write Off Wizard popup loaded successfully$")
    public void iVerifyWhirlpoolWriteOffWizardPopupLoadedSuccessfully() throws InterruptedException {
        Assert.assertTrue("Whirlpool Write Off Wizard popup loaded successfully",orbitSiteMap.isWHPWriteOffWizardLoaded());
        Thread.sleep(5000);
    }

    @And("^I upload the WHP Exchange file$")
    public void iUploadTheWHPExchangeFile() throws InterruptedException, AWTException {
        orbitSiteMap.uploadWHPExchangeFile();
        Assert.assertTrue("Whirlpool Job Import done successfully",orbitSiteMap.verifyJobImportConfirmationPopup());
    }

}
