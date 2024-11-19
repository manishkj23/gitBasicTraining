package com.test.steps;


import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.ExcessPaymentDue;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgentUI_NPV.ServiceOptionsPageNPV;
import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.CCAgent_OLDUI.ServiceOptionsPage;
import com.test.pages.ExcessPayment.CallOutChargePaymentPage;
import com.test.pages.ExcessPayment.PaymentDuePopup;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceOptionsStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private ServiceOptionsPage serviceOptionsPage;
    private ServiceOptionsPageNPV serviceOptionsPageNPV;
    private CallOutChargePaymentPage callOutChargePaymentPage;
    private OrbitHomePage homePage;
    private PlanDetails planDetails;
    private PaymentDuePopup paymentDuePopup;
    private ExcessPaymentDue excessPaymentDue;


    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceOptionsStepDef.class);

    public ServiceOptionsStepDef(BasePage basePage, SeleniumHelper seleniumHelper, ServiceOptionsPage serviceOptionsPage,
                                 CallOutChargePaymentPage callOutChargePaymentPage, OrbitHomePage homePage, PlanDetails planDetails,
                                 PaymentDuePopup paymentDuePopup, ExcessPaymentDue excessPaymentDue, ServiceOptionsPageNPV serviceOptionsPageNPV) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.serviceOptionsPage = serviceOptionsPage;
        this.callOutChargePaymentPage = callOutChargePaymentPage;
        this.homePage = homePage;
        this.planDetails = planDetails;
        this.paymentDuePopup = paymentDuePopup;
        this.excessPaymentDue = excessPaymentDue;
        this.serviceOptionsPageNPV = serviceOptionsPageNPV;

    }


    @When("^I confirm the service option as \"([^\"]*)\" and enter the additional information$")
    public void iConfirmTheServiceOptionAsAndEnterTheAdditionalInformation(String serviceOption) throws InterruptedException {

        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serviceOptionsPage.isAvaiabilityPopupStillDisplaying();
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());
        serviceOptionsPage.enterAdditionalInformationData();
        Thread.sleep(3000);


    }


    @When("^I confirm the additional information$")
    public void iConfirmTheAdditionalInformation() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serviceOptionsPage.isAvaiabilityPopupStillDisplaying();
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());
        serviceOptionsPage.enterAdditionalInformationData();


    }

    @When("^I enter the additional information only$")
    public void iEnterAdditionalInformationOnly() {
        Assert.assertTrue("Additional Information Section not Loaded", serviceOptionsPage.isAdditionalInformationSectionLoaded());
        serviceOptionsPage.enterAdditionalInformationData();


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
//        base.handleSoftAssert("Calender not available ", serviceOptionsPage.isCalendarDisplayed());
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
        base.hardWait("5000");

    }

    @And("^I Book with an Appointment and confirm appointment$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithappointment() {
        Assert.assertTrue("Unable to verify Calender", serviceOptionsPage.isCalendarDisplayed());
//        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
//        serviceOptionsPage.clickConfirmOptionDetailsButtonWithOutAppointment();
        serviceOptionsPage.clickConfirmOptionDetailsButton();


    }

    @And("^I Book without an Appointment and confirm appointment$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithoutappointment() {
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
        serviceOptionsPage.clickConfirmOptionDetailsButtonWithOutAppointment();


    }

    @And("^I Book without an Appointment and confirm appointment for \"([^\"]*)\"$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithoutappointmentForSP(String spName) {
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
        serviceOptionsPage.clickConfirmOptionDetailsButtonWithOutAppointment(spName);


    }

    @And("^I Book without an Appointment and put On Hold$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentwithoutappointmentOnHold() {
        serviceOptionsPage.putClaimOnHold();
        base.hardWait("10000");
        Assert.assertTrue("Unable to verify HomePageNPV", homePage.isHomePageLoaded());

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

    @Then("^I Verify the Calendar displayed for \"([^\"]*)\"$")
    public void iVerifyTheCalendarDisplayedFor(String sp) {
        Assert.assertTrue("Unable to Verify the Service provider name : " + sp, serviceOptionsPage.isServiceProviderNameDisplayed(sp));
    }
    @Then("^I Verify the Calendar not displayed for \"([^\"]*)\"$")
    public void iVerifyTheCalendarNotDisplayedFor() {
        Assert.assertFalse("Calendar is available", serviceOptionsPage.isCalendarnotDisplayed());
    }


    @Then("^I navigate to jobupdate page for the \"([^\"]*)\" for \"([^\"]*)\"$")
    public void iVerifyTheCalendarDisplayedForTheFor(String claimNo, String sp) {

        base.navigateToPage(base.prop.getProperty("jobupdatePage") + claimNo);
        Assert.assertTrue("Verify the ServiceOptions Page Loaded", serviceOptionsPage.isServiceOptionsPageLoaded());

    }

    @When("^I confirm the service option as \"([^\"]*)\" and verify the service cost is displayed$")
    public void iConfirmTheServiceOptionAsAndVerifyTheServiceCostIsDisplayed(String serviceOption) {
        serviceOptionsPage.selectAvailableServiceOptionAndConfirmTheServiceCost(serviceOption);
        base.waitForPageToLoad();
    }

    @When("^I verify the service cost is displayed and confirm the service option as \"([^\"]*)\"$")
    public void iVerifyTheServiceCostIsDisplayedAndConfirmTheServiceOptionAs(String serviceOption) {
        Assert.assertTrue("ServiceCost Amount not displayed", serviceOptionsPage.isServiceProviderCostDisplayed(serviceOption));
        serviceOptionsPage.selectAvailableServiceOptionAndConfirm(serviceOption);
        base.waitForPageToLoad();
        Assert.assertTrue("Unable to Verify the Payment Due Page", paymentDuePopup.isPaymentDuePageLoaded());
    }

    @Then("^I verify the service cost displayed on the payment basket and take the payment for the service cost$")
    public void iVerifyTheServiceCostDisplayedOnThePaymentBasketAndTakeThePaymentForTheServiceCost() {
        Assert.assertTrue("Unable to verify the Service Cost on the Payment Due page", paymentDuePopup.isServiceOptionCostDisplayed());
        paymentDuePopup.takePayment();
        base.waitForPageToLoad();

        Assert.assertTrue("Excess Payment not verified", serviceOptionsPage.isServiceOptionPaymentPaid());
    }

    @When("^I change the ServiceProvider as \"([^\"]*)\"$")
    public void iChangeTheServiceProviderAs(String sp) {
        serviceOptionsPage.selectAnotherServiceProvider(sp);
    }

    @And("^I click confirm option details button$")
    public void iClickConfirmOptionDetailsButton() {
        serviceOptionsPage.clickConfirmOptionDetails();
    }

    @Then("^I select the different ServiceProvider as \"([^\"]*)\"$")
    public void selectDifferentServiceProvider(String serviceprovider) throws InterruptedException {
        serviceOptionsPage.selectDifferentServiceProvider(serviceprovider);
        Thread.sleep(3000);
        serviceOptionsPage.enterAdditionalInformationData();
        Thread.sleep(3000);
    }

    @Then("^I verify the Excess Amount is Paid for NPV$")
    public void iProcessTheExcessPaymentVerifyTheExcessAmountIsPaidNPV() {
//        if (excessPaymentDue.isExcessPaymentPageDisplayed()) {
//            excessPaymentDue.takeExcessPayment();
//            base.hardWait("3000");
//            callOutChargePaymentPage.confirmPaymentSuccessfulPopup();
//        } else {
//            LOGGER.info("Unable to process payment");
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Excess Payment not verified", excessPaymentDue.isPaymentSuccessfulBannerDisplayed());
    }

    @And("I Verify No availability message is displayed")
    public void iVerifyNoAvailabilityMessageIsDisplayed() {
        Assert.assertTrue("Unable to verify No availability message", serviceOptionsPageNPV.VerifyNoAvailabilityMessage());
    }

    @And("^I select the second Available Appointment if exist and confirm appointment$")
    public void iSelectTheSecondAvailableAppointmentAndConfirmAppointment() {
        if (serviceOptionsPage.isCalendarDisplayed()) {
            Assert.assertTrue("Unable to verify Calender", serviceOptionsPage.isCalendarDisplayed());
            serviceOptionsPage.selectSecondAvailableAppointmentDate();
        }
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
        serviceOptionsPage.clickConfirmOptionDetailsButton();
        base.hardWait("5000");

    }

    @Then("I verify the BlockedServiceProvider is not displayed")
    public void iVerifyTheBlockedServiceProviderIsNotDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Blocked SP is Displayed", serviceOptionsPageNPV.isBlockedSPDisplayed());

    }


    @And("I confirm the color of available days on the calendar is set to orange for PrimarySP")
    public void iConfirmTheColorOfAvailableDaysOnTheCalendarIsSetToOrangeForPrimarySP() throws InterruptedException {
        Thread.sleep(3000);
        base.waitForPageToLoad();
//        Assert.assertTrue("Unable to verify Calender", serviceOptionsPage.isCalendarDisplayed());
//        Assert.assertTrue("Color is n", serviceOptionsPageNPV.verifyTheColorOfPrimarySP());
        serviceOptionsPageNPV.verifyTheColorOfPrimarySP();
    }

    @Then("I verify the flying toolbox9 is displayed and BlockedServiceProvider is not displayed")
    public void iVerifyTheFlyingToolbox9IsDisplayedAndBlockedServiceProviderIsNotDisplayed() {
        Assert.assertTrue("Extra Availability SP 'FTB-9' isn't displayed.", serviceOptionsPageNPV.isFTB9Displayed());
        Assert.assertTrue("Blocked SP is Displayed", serviceOptionsPageNPV.isBlockedSPDisplayed());

    }

    @Then("I verify the flying toolbox9 is not displayed and BlockedServiceProvider is displayed")
    public void iVerifyTheFlyingToolbox9IsNotDisplayedAndBlockedServiceProviderIsDisplayed() {
        Assert.assertTrue("Extra Availability SP 'FTB-9' is displayed.", serviceOptionsPageNPV.ftb9IsNotDisplayed());
        Assert.assertTrue("Blocked SP is Not Displayed", serviceOptionsPageNPV.blockedSPIsDisplayed());

    }

    @And("^I select the Available Appointment if exist and confirm appointment for \"([^\"]*)\"$")
    public void iSelectTheFirstAvailableAppointmentAndConfirmAppointmentFor(String spName) {
        if (serviceOptionsPageNPV.isServiceProverDisplayed(spName))
        {
            serviceOptionsPageNPV.selectTheSeviceProvder(spName);
            serviceOptionsPageNPV.clickRequestAvailabilityButton();
        }
        if (serviceOptionsPage.isCalendarDisplayed()) {
            Assert.assertTrue("Unable to verify Calender", serviceOptionsPage.isCalendarDisplayed());
            serviceOptionsPage.selectFirstAvailableAppointmentDate();
        }
        Assert.assertTrue("Unable to verify Confirmation Button", serviceOptionsPage.isConfirmOptionDetailsButtonDisplayed());
        serviceOptionsPage.clickConfirmOptionDetailsButton();
        base.hardWait("5000");

    }

}