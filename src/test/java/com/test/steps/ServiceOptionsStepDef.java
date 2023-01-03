package com.test.steps;


import com.test.pages.ExcessPayment.CallOutChargePaymentPage;
import com.test.pages.OrbitHomePage;
import com.test.pages.QandAProcessPage;
import com.test.pages.ServiceOptionsPage;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class ServiceOptionsStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private ServiceOptionsPage serviceOptionsPage;
    private CallOutChargePaymentPage callOutChargePaymentPage;
    private OrbitHomePage homePage;
    private PlanDetails planDetails;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceOptionsStepDef.class);

    public ServiceOptionsStepDef(BasePage basePage, SeleniumHelper seleniumHelper, ServiceOptionsPage serviceOptionsPage, CallOutChargePaymentPage callOutChargePaymentPage, OrbitHomePage homePage, PlanDetails planDetails) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.serviceOptionsPage = serviceOptionsPage;
        this.callOutChargePaymentPage = callOutChargePaymentPage;
        this.homePage = homePage;
        this.planDetails = planDetails;
    }


    @When("^I confirm the service option as \"([^\"]*)\" and enter the additional information$")
    public void iConfirmTheServiceOptionAsAndEnterTheAdditionalInformation(String serviceOption) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());
        serviceOptionsPage.enterAdditionalInformationData();


    }

    @When("^I confirm the service option as \"([^\"]*)\" and enter the additional information for OnHold$")
    public void iConfirmTheServiceOptionAsAndEnterTheAdditionalInformationOnHold(String serviceOption) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());
        serviceOptionsPage.enterAdditionalInformationData();


    }

    @When("^I confirm the service option as \"([^\"]*)\" and enter the additional information with \"([^\"]*)\"\"([^\"]*)\" and \"([^\"]*)\"$")
    public void iConfirmTheServiceOptionAsAndEnterTheAdditionalInformationWithAnd(String serviceOption, String email, String homeTel, String mobileNo) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());
        serviceOptionsPage.enterAdditionalInformationDataWithContactDetails(email, homeTel, mobileNo);
    }

    @When("^I confirm the service option as \"([^\"]*)\" and enter the additional information as stated$")
    public void iConfirmTheServiceOptionAsAndEnterTheAdditionalInformationasstated(String serviceOption) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());

        serviceOptionsPage.enterAdditionalInformationData();


    }

    @Then("^I verify the Calendar dates are available$")
    public void iVerifyTheCalendarDatesAreAvailable() {
        Assert.assertTrue("Calender not available ", serviceOptionsPage.isCalendarDisplayed());
    }

    @And("^I select the Available Appointment if exist and confirm appointment$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointment() {
        if (serviceOptionsPage.isCalendarDisplayed()) {
            Assert.assertTrue("Unable to verify Calender", serviceOptionsPage.isCalendarDisplayed());
            serviceOptionsPage.selectFirstAvailableAppointmentDate();
        }
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
        serviceOptionsPage.clickConfirmOptionDetailsButton();

    }
    @And("^I Book with an Appointment and confirm appointment$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithappointment() {
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
//        serviceOptionsPage.clickConfirmOptionDetailsButtonWithOutAppointment();
        serviceOptionsPage.clickConfirmOptionDetailsButton();


    }

    @And("^I Book without an Appointment and confirm appointment$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithoutappointment() {
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
        serviceOptionsPage.clickConfirmOptionDetailsButtonWithOutAppointment();


    }

    @And("^I Book without an Appointment and put On Hold$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithoutappointmentOnHold() {
        serviceOptionsPage.putClaimOnHold();
        Assert.assertTrue("Unable to verify HomePage", homePage.isHomePageLoaded());

        homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
    }

    @Then("^I verify claim on Checkout Process Page$")
    public void iVerifyClaimProcessed() {
//        serviceOptionsPage.clickConfirmOptionDetailsButton();
        Assert.assertTrue("Cannot Confirm Checkout Process Page", serviceOptionsPage.isCheckOutProcessPageLoaded());

        if (serviceOptionsPage.ischeckOutProcessConfirmButtonDisplayed()) {
            serviceOptionsPage.confirmCheckoutprocess();
        }

    }

    @Then("^I verify claim on Checkout Process Page and set the claim as Hold$")
    public void iVerifyClaimProcessedWithHold() {
//        serviceOptionsPage.clickConfirmOptionDetailsButton();
        Assert.assertTrue("Cannot Confirm Checkout Process Page", serviceOptionsPage.isCheckOutProcessPageLoaded());

        if (serviceOptionsPage.ischeckOutProcessConfirmButtonDisplayed()) {
            serviceOptionsPage.confirmCheckoutprocess();
        }

    }

    @Then("^I verify the Excess Amount Waived off$")
    public void iVerifyTheExcessAmountWaivedOff() {
        Assert.assertTrue("Waive Excess not verified", serviceOptionsPage.isExcessPaymentWaivedOff());

    }

    @Then("^I process the Excess Payment verify the Excess Amount is Paid$")
    public void iProcessTheExcessPaymentVerifyTheExcessAmountIsPaid() {
        if (callOutChargePaymentPage.isPopUpDisplayed()) {
            callOutChargePaymentPage.proceedToExcessPay();
            base.waitForPageToLoad();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Excess Payment not verified", serviceOptionsPage.isExcessPaymentPaid());
    }

    @Then("^I click process the Excess Payment$")
    public void iClickProcessTheExcessPaymentVerifyTheExcessAmountIsPaid() {
        if (serviceOptionsPage.isExcessPaymentRequired()) {
            serviceOptionsPage.selectExcessPaymentToProcess();
        }
    }

    @When("^I confirm the service option as \"([^\"]*)\" and confirm$")
    public void iConfirmTheServiceOptionAsAndConfirm(String serviceOption) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        base.waitForPageToLoad();
    }

    @Then("^I click service options tab in homepage$")
    public void iClickServiceoptionsTabInHomepage() {
        homePage.clickServiceOptionsTab();
        Assert.assertTrue("Service Options Page not loaded", serviceOptionsPage.isServiceOptionsPageLoaded());
    }

    @Then("^I verify the email \"([^\"]*)\" is updated successfully$")
    public void iVerifyTheEmailIsUpdatedSuccessfully(String email) {
        Assert.assertTrue("Failed to validate Email", serviceOptionsPage.isEmailUpdatedonServiceOptionsPage(email));

    }

    @Then("^I verify the Contact no \"([^\"]*)\" is updated successfully$")
    public void iVerifyTheContactNoIsUpdatedSuccessfully(String homeTel) {
        Assert.assertTrue("Failed to validate Contact Number", serviceOptionsPage.isHomeTelUpdatedonServiceOptionsPage(homeTel));
    }

    @Then("^I verify the mobile no \"([^\"]*)\" is updated successfully$")
    public void iVerifyTheMobileNoIsUpdatedSuccessfully(String mobileNo) {
        Assert.assertTrue("Failed to validate Mobile Number", serviceOptionsPage.isMobileNoUpdatedonServiceOptionsPage(mobileNo));
    }

    @When("^I confirm the service option as \"([^\"]*)\"$")
    public void iConfirmTheServiceOptionOnly(String serviceOption) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());

    }

    @Then("^I Verify the Calendar displayed for \"([^\"]*)\"$")
    public void iVerifyTheCalendarDisplayedFor(String sp) {
        Assert.assertTrue("Unable to Verify the Service provider name : " + sp, serviceOptionsPage.isServiceProviderNameDisplayed(sp));
    }
}
