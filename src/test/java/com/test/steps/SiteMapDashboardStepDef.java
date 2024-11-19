package com.test.steps;

import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.SiteMapPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteMapDashboardStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private SiteMapPage siteMap;
    private OrbitHomePage orbitHomePage;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClaimStepDef.class);

    public SiteMapDashboardStepDef(BasePage basePage, SeleniumHelper seleniumHelper, SiteMapPage siteMap, OrbitHomePage orbitHomePage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.siteMap = siteMap;
        this.orbitHomePage = orbitHomePage;
    }

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click search and click wizard$")
    public void i_click_sitemap_and_i_enter_something_and_click_search_and_click_wizard(String searchValue){
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isSiteMapPageLoaded());
        siteMap.searchAndClickWizard(searchValue);
    }

    @And("^I verify ASV-LSC dashboard page loaded successfully$")
    public void iVerifyAsvLscDashboardLoadedSuccessfully() throws InterruptedException {
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isAsvLscDashboardLoaded());
        Thread.sleep(5000);
    }

    @Then("^I verify all buttons are present and enabled$")
    public void iVerifyAllButtonsArePresentAndEnabled() throws InterruptedException {
        siteMap.isAllButtonAndBoxEnabled();
        Thread.sleep(3000);
    }

    @Then("^I verify Date Booked Radio button and MTD auto select or not$")
    public void i_verify_date_booked_radio_button_auto_select_or_not() throws InterruptedException {
        siteMap.isDateBookedRadioButtonMTDButtonSelected();
        Thread.sleep(3000);
    }

    @Then("^I verify new column added successfully$")
    public void i_verify_new_column_added_successfully() throws InterruptedException {
        Assert.assertTrue("New Columns are not added in the ASV Dashboard",siteMap.verifyTwoNewColumnAddedInAsvDashboard());
        Thread.sleep(3000);
    }

    @Then("^I verify Reassign SP DeemedDone Cancel buttons are available$")
    public void i_verify_reassign_sp_deemeddone_cancel_buttons_are_available(){
        siteMap.verifyReassignSPDeemedDoneCancelButtonEnabled();
    }

    @Then("^I verify D&G Custom Report pop up displayed successfully$")
    public void i_verify_dg_custom_report_pop_up_displayed_successfully() throws InterruptedException {
        siteMap.verifyDGCustomReportForm();
        Thread.sleep(2000);
    }

    @Then("^I verify Report Type field and dropdown is available$")
    public void i_verify_report_type_field_and_dropdown_is_available(){
        siteMap.verifyReportTypeAndDropdownDisplayed();
    }

    @And("^I click on Report Type dropdown and verify \"([^\"]*)\" is present$")
    public void i_click_on_report_type_field_dropdown_verify_something_is_present(String dropdownValue){
        siteMap.clickOnReportTypeDropdownAndVerifyInFlightReport(dropdownValue);
    }

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click on the wizard$")
    public void i_click_sitemap_and_i_enter_something_and_click_on_the_wizard(String searchvalue) throws Throwable {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isSiteMapPageLoaded());
        siteMap.searchAndClickonServiceProviderWizard(searchvalue);
    }

    @And("^I verify Service Provider page loaded successfully$")
    public void i_verify_service_provider_page_loaded_successfully() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Service provider page is not displayed",siteMap.isServiceProviderPageDisplayed());
    }

    @Then("^I enter \"([^\"]*)\" in the Company Name column in Service Provider grid$")
    public void i_enter_something_in_the_company_name_column_in_service_provider_grid(String companyname) throws Throwable {

        Thread.sleep(4000);
        siteMap.enterCompanyNameInTheServiceProviderGrid(companyname);
    }

    @And("^I select the first row in the Service Provider grid and click on Edit button$")
    public void i_select_the_first_row_in_the_service_provider_grid_and_click_on_edit_button() throws Throwable {
        Thread.sleep(4000);
        siteMap.clickOnTheRowInTheServiceProviderGrid();
    }

    @Then("^I verify the new Indicator present in Update Service Provider$")
    public void i_verify_the_new_indicator_present_in_update_service_provider() throws Throwable {
        Thread.sleep(30000);
       siteMap.verifyNewIndicatorUpdateServiceProvider();
    }

    @Then("^I click on YES radio button to set the new indicator and save it$")
    public void i_click_on_yes_radio_button_to_set_the_new_indicator_and_save_it() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Not able to click on YES radio button",siteMap.clickOnYesRadioButtonToSetNewIndicator());
        Thread.sleep(3000);
        siteMap.clickOnSaveButtonInServiceProviderForm();
        Thread.sleep(10000);
    }

    @Then("^I click on NO radio button to set the new indicator and save it$")
    public void i_click_on_no_radio_button_to_set_the_new_indicator_and_save_it() throws Throwable {
        Thread.sleep(3000);
        Assert.assertTrue("Not able to click on NO radio button",siteMap.clickOnNoRadioButtonToSetNewIndicator());
        Thread.sleep(3000);
        siteMap.clickOnSaveButtonInServiceProviderForm();
        Thread.sleep(10000);
    }

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click on the Dashboard wizard$")
    public void iClickSitemapAndClickDashboardWizard(String searchvalue) throws Throwable {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isSiteMapPageLoaded());
        siteMap.searchAndClickonDashboardWizard(searchvalue);
    }

    @And("^I verify Dashboard Filter Group page loaded successfully$")
    public void i_verify_dashboard_filter_group_page_loaded_successfully() throws Throwable {
        Assert.assertTrue("SiteMap Page not Loaded",siteMap.isDashboardFilterGroupPageLoaded());
        Thread.sleep(3000);
    }

    @Then("^I click on Insert button in Dashboard Filter group$")
    public void i_click_on_insert_button_in_dashboard_filter_group() throws Throwable {
        siteMap.clickOnInsertButtonInDashboardFilterGroup();
        Thread.sleep(3000);
    }


    @And("^I click on Save button in Insert Dashboard Filter Group form$")
    public void i_click_on_save_button_in_insert_dashboard_filter_group_form() throws Throwable {
        siteMap.clickOnSaveButtonInDashboardFilterGroup();
        Thread.sleep(3000);
    }

    @Then("^I verify error message appear after I click on Save button$")
    public void i_verify_error_message_appear_after_i_click_on_save_button() throws Throwable {
        siteMap.verifyErrorMessageInDashboardFilterGroup();
        Thread.sleep(3000);

    }

    @Then("^I select the option from Dashboards dropdown$")
    public void i_select_the_option_from_dashboards_dropdown() throws Throwable {
        siteMap.clickOnDashboardsDropdown();
    }

    @And("^I verify error message disappear$")
    public void i_verify_error_message_disappear() throws Throwable {
        siteMap.verifyErrorMessageDisappearInDashboardsDropdown();
    }

    @And("^I verify Access Level Manager board loaded successfully$")
    public void iVerifyAccessLevelManagerBoardLoadedSuccessfully() throws InterruptedException {
        Assert.assertTrue("Access Level Manager Page not Loaded successfully",siteMap.isAccessLevelManagerBoardLoaded());
        Thread.sleep(5000);
    }

    @Then("^I click on Access Level Manager Insert button$")
    public void i_click_on_insert_button_and_verify_insert_dg_access_level_pop_up() throws InterruptedException {
        siteMap.clickOnInsertButtonAccessLevelManager();
        Thread.sleep(5000);
    }

    @And("^I verify Access Level Manager table present in the grid$")
    public void i_verify_access_level_manager_table_present_in_the_grid() throws InterruptedException {
        Assert.assertTrue("Access Level Manager table is not present",siteMap.isAccessLevelManagerTableDisplayed());
        Thread.sleep(5000);
    }

    @And("^I verify Edit and Insert buttons are present$")
    public void i_verify_edit_and_insert_buttons_are_present() throws InterruptedException {
        Assert.assertTrue("Edit & Insert button not displayed in Access Level Manager table",siteMap.verifyEditAndInsertButtonsDisplayed());
        Thread.sleep(5000);
    }

    @And("^I verify Insert D&G Access Level pop up displayed$")
    public void i_verify_insert_dg_access_level_pop_up_displayed() throws InterruptedException {
        siteMap.verifyInsertPopUpDisplayed();
        Thread.sleep(5000);
    }

    @Then("^I verify access level dropdown present in the pop up$")
    public void i_verify_access_level_dropdown_present_in_the_pop_up() throws InterruptedException {
//        siteMap.verifyAccessLevelOption();
        siteMap.verifyAccessLevelDropdownOptionAndClick();
        Thread.sleep(5000);
    }


    @Then("^I click on D&G Client Group Insert button$")
    public void i_click_on_dg_client_group_insert_button() throws InterruptedException {
        siteMap.clickOnDGClientGroupInsertButton();
        Thread.sleep(5000);
    }

    @Then("^I verify new fields are present in the pop up$")
    public void i_verify_new_fields_are_present_in_the_pop_up() throws InterruptedException {
        Assert.assertTrue("New fields are not present in the D&G Client Group",siteMap.verifyNewFieldDisplayedInDGClientGroup());
        Thread.sleep(3000);
    }

    @And("^I verify D&G Client Group header loaded successfully$")
    public void i_verify_dg_client_group_header_loaded_successfully() throws InterruptedException {
        Assert.assertTrue("D&G Client Group Page not Loaded successfully",siteMap.isDGClientGroupBoardLoaded());
        Thread.sleep(5000);
    }

    @And("^I verify D&G Client Group table present in the grid$")
    public void i_verify_dg_client_group_table_present_in_the_grid() throws InterruptedException {
        Assert.assertTrue("D&G Client Group table is not present",siteMap.isDGClientGroupTableDisplayed());
        Thread.sleep(5000);
    }

    @And("^I verify Edit and Insert buttons are present in D&G Client Group table$")
    public void i_verify_edit_and_insert_buttons_are_present_in_dg_client_group_table() throws InterruptedException {
        Assert.assertTrue("Edit & Insert button not displayed in Access Level Manager table",siteMap.verifyDGClientGroupEditAndInsertButtonsDisplayed());
        Thread.sleep(5000);
    }

    @And("^I verify D&G Client Group pop up displayed$")
    public void i_verify_dg_client_group_pop_up_displayed() throws InterruptedException {
        Assert.assertTrue("D&G Client Group Pop Up not displayed",siteMap.verifyDGClientGroupInsertPopUpDisplayed());
        Thread.sleep(5000);
    }

    @Then("^I verify Export and Insert buttons are enabled in Generic Appliance Data Wizard$")
    public void i_verify_export_and_insert_buttons_are_enabled_in_generic_appliance_data_wizard(){
        System.out.println("Merging concept in GIT");

    }

    @And("^I verify Generic Appliance Data wizard loaded successfully$")
    public void i_verify_generic_appliance_data_wizard_loaded_successfully(){

    }

    @And("^I verify Export and Insert buttons are present in Generic Appliance Data wizard$")
    public void i_verify_export_and_insert_buttons_are_present_in_generic_appliance_data_wizard() {

    }

}
