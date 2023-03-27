package com.test.steps;

import com.test.pages.OrbitHomePage;
import com.test.pages.SiteMapPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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

    @Given("^I click SiteMap and I enter \"([^\"]*)\" and click search$")
    public void i_click_sitemap_and_i_enter_something_and_click_search(String searchValue){
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

}
