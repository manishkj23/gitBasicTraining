package com.test.steps;


import com.test.pages.CCAgentUI_NPV.BookingConfirmedPage;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanWriteOff;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.RepairInformationPage;
import com.test.pages.CCAgentUI_NPV.HomePageNPV;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgent_OLDUI.*;
import com.test.pages.CCAgent_OLDUI.DialogPopups.ConfirmIMEIOverrideOnADifferentPlan;
import com.test.pages.CCAgent_OLDUI.DialogPopups.RepeatRepairNotice;
import com.test.pages.CCAgent_OLDUI.ProductConfirmationSections.ProductConfirmationMobile;
import com.test.pages.DataTools.SessionCachePage;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitJobImports.Whirlpool.JobImportUtilityWhirlpool;
import com.test.utils.OrbitUtils.IMEI;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class OrbitHomePageStepDef {

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
    private BookingConfirmedPage bookingConfirmedPage;
    private RepairInformationPage repairInformation;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public OrbitHomePageStepDef(BasePage basePage,
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
                                BookingConfirmedPage bookingConfirmedPage,
                                RepairInformationPage repairInformation) {
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
        this.bookingConfirmedPage = bookingConfirmedPage;
        this.repairInformation = repairInformation;

    }

    @Then("^I verify the Login is successful$")
    public void iVerifyTheLoginIsSuccessful() {
        Assert.assertTrue("LoginFailed", homePage.isHomePageLoaded());
        seleniumHelper.captureScreeshot();

    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearch(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
//        claimPage.searchForAPlan(planNo);
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }
//        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.isPageHeaderTitleDisplayed());

    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search for WrittenOff$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearchForWrittenOff(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" to search$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClicktoSearch(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {

            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" to search for Plan View$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClicktoSearchForPlanView(String planNo) throws InterruptedException {
        Thread.sleep(10000);
        homePage.clickCreateClaim();
        base.hardWait("10000");
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        Thread.sleep(10000);
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            Thread.sleep(10000);
            claimPage.searchForAPlan(planDetails.getPlanNumber());
            Thread.sleep(10000);
        } else {
            try {
                if (!commonUtils.cancelAnOpenClaim(planNo)) {
                    if (planViewPageNPV.cancelJobFromUI(planNo)) {
                        planViewPageNPV.clickOnDnGLogoForNPV();
                        homePage.clickCreateClaim();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                claimPage.searchForAPlan(planNo);
            }
//            claimPage.searchForAPlan(planNo);
        }
        base.hardWait("10000");
        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.isPageHeaderTitleDisplayed());

    }

    @Given("^I enter plan number \"([^\"]*)\" to search for Plan View$")
    public void iEnterPlanNumberAndClicktoSearchForPlanView(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.isPageHeaderTitleDisplayed());

    }

    @Given("^I enter master plan number \"([^\"]*)\" to search for Plan View$")
    public void iEnterMasterPlanNumberAndClicktoSearchForPlanView(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }
//        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.babyPlanViewPage.isBabyPlanPageDisplayed());

    }


    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search for \"([^\"]*)\" times$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearchForNTimes(String planNo, String noOfTimes) {
        for (int i = 1; i <= Integer.valueOf(noOfTimes); i++) {
            reviewClaimPage.clickDandGLogo();
            base.hardWait("3000");
            homePage.clickCreateClaim();
            Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
            seleniumHelper.captureScreeshot();
            if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
                claimPage.searchForAPlan(planDetails.getPlanNumber());
            } else {
                claimPage.searchForAPlan(planNo);
            }
            Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
        }
    }


    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search for WrittenOff for \"([^\"]*)\"$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearchForWrittenOffForWHP(String planNo, String oem) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber(oem));
        } else {
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search for WrittenOff for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearchForWrittenOffForWHP(String planNo, String oem, String schemeCode) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber(oem, schemeCode));
        } else {
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @Then("^I Verify the \"([^\"]*)\" details displayed$")
    public void iVerifyTheDetailsDisplayed(String planNo) throws Exception {
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
        commonUtils.cancelAnOpenClaim(planNo);
    }

    @Then("^I Verify the \"([^\"]*)\" details displayed for WrittenOff$")
    public void iVerifyTheDetailsDisplayedForWrittenOff(String planNo) {
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
        try {
            if (!planNo.equals("CRT")) {
                commonUtils.cancelAnOpenClaim(planNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I Verify the PlanNo \"([^\"]*)\" details are displayed$")
    public void iVerifyTheDetailsDisplayedNPV(String planNo) {
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
        try {
            if (!(planNo.equals("CRT") || planNo.isEmpty())) {
                commonUtils.cancelAnOpenClaim(planNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I verify the \"([^\"]*)\" is in Live Status$")
    public void iVerifyTheIsInLiveStatus(String planNo) {
        Assert.assertTrue("Plan is not in Live Status", claimPage.isPlanInLiveStatus(planNo));
//        Assert.assertTrue("Plan is not in Live Status", claimPage.isPlanInLiveStatusForMasterPlan(planNo));
    }

    @And("^I verify the \"([^\"]*)\" is in Live Status for MasterPlan$")
    public void iVerifyTheIsInLiveStatusForMasterplan(String planNo) {
//        Assert.assertTrue("Plan is not in Live Status", claimPage.isPlanInLiveStatus());
        Assert.assertTrue("Plan is not in Live Status", claimPage.isPlanInLiveStatusForMasterPlan(planNo));
    }

    @When("^I select the product \"([^\"]*)\" and click the claim type \"([^\"]*)\"$")
    public void iSelectTheProductAndClickTheClaimType(String planNo, String claimType) {
//        claimPage.clickSelectProduct(planNo);
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.clickSelectProduct(planDetails.getPlanNumber());
        } else {
            claimPage.clickSelectProduct(planNo);
        }
        claimPage.selectClaimType(claimType);
        Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
    }

    @When("^I select the product for WrittenOff \"([^\"]*)\" and click the claim type \"([^\"]*)\"$")
    public void iSelectTheProductAndClickTheClaimTypeForWrittenOff(String planNo, String claimType) {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.clickSelectProduct(planDetails.getPlanNumber());
        } else {
            claimPage.clickSelectProduct(planNo);
        }
        claimPage.selectClaimType(claimType);
        Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
    }


    @When("^I select the product \"([^\"]*)\" and click the claim type \"([^\"]*)\" in warranty period$")
    public void iSelectTheProductAndClickTheClaimTypeInWarrantyPeriod(String planNo, String claimType) {
        claimPage.clickSelectProduct(planNo);
        claimPage.selectClaimType(claimType);
        Assert.assertTrue("Unable to check Plan in Warranty", claimPage.isPlanInWarranty());
    }


    @When("^I select the product \"([^\"]*)\" and verify the claim status as \"([^\"]*)\" $")
    public void iSelectTheProductAndVerifyTheClaimStatus(String planNo, String status) {
        claimPage.clickSelectProduct(planNo);
        if (status.equalsIgnoreCase("CANCELLED")) {
            Assert.assertTrue("Create Request button not Enabled", claimPage.isPlanInCancelledStatus());
        } else if (status.equalsIgnoreCase("LAPSED")) {
//            Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
        }
    }

    @When("^I select the product \"([^\"]*)\" and verify the claim status as \"([^\"]*)\"$")
    public void iSelectTheProductAndVerifyTheClaimStatusAs(String planNo, String status) {
        claimPage.clickSelectProduct(planNo);
        if (status.equalsIgnoreCase("CANCELLED")) {
            Assert.assertTrue("Claim is not in Cancelled State", claimPage.isPlanCancelledPopupExist());
        } else if (status.equalsIgnoreCase("LAPSED")) {
            Assert.assertTrue("Claim is not in Lapsed State", claimPage.isPlanLapsedPopupExist());
        } else {
            Assert.assertTrue("Claim Status not verified", false);
        }
    }

    @Then("^I verify the Claim is Cancelled for \"([^\"]*)\" and  \"([^\"]*)\"$")
    public void iVerifyTheClaimIsCancelledForAnd(String planNo, String claimType) throws Throwable {
        if (openJobAlert.isPopUpDisplayed()) {
            openJobAlert.goToOpenClaim();
            reviewClaimPage.clickMenuOption();
            if (cancelClaimPage.isFunctionMenuPageDisplayed()) {
                cancelClaimPage.clickCancelClaimAction();
                cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");
                Assert.assertTrue("Open Claim not cancelled ", cancelClaimPage.isJobCancelledSuccefully());
                reviewClaimPage.clickDandGLogo();
            }

        }
    }

    @Then("^I verify the claim type selected and Confirm Product section displayed$")
    public void iVerifyTheClaimTypeSelectedAndConfirmProductSectionDisplayed() {
        Assert.assertTrue("Confirm Product Details Section not Displayed", claimPage.isConfirmProductDetailsSectionLoaded());
    }

    @When("^I enter Model number \"([^\"]*)\" fault code \"([^\"]*)\" and problem code \"([^\"]*)\"$")
    public void iEnterModelNumberFaultCodeAndProblemCode(String model, String fault, String problem) throws Throwable {
        claimPage.enterAndConfirmProductDetails(model, fault, problem);
        Assert.assertTrue("Failed to fill the FaultCode details", claimPage.checkIfFaultDetailsEnteredSuccessfully());

    }


    @And("^I click create request button$")
    public void iClickCreateRequestButton() {
        claimPage.clickCreateRequest();
        Assert.assertTrue("Unable to verify the Claim Status as Claim Created", qandAProcessPage.isClaimCreated());
    }

    @Then("^I verify if has open claim and cancel the claim for \"([^\"]*)\" claim type \"([^\"]*)\"$")
    public void iVerifyIfHasOpenClaimAndCancelTheClaimFor(String planNo, String claimType) {
        if (openJobAlert.isPopUpDisplayed()) {
            openJobAlert.goToOpenClaim();
            if (availabilityPopup.isPopUpDisplayed()) {
                availabilityPopup.closePopup();
            }
            reviewClaimPage.clickMenuOption();
            if (cancelClaimPage.isFunctionMenuPageDisplayed()) {
                cancelClaimPage.clickCancelClaimAction();
                cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");

                base.waitForPageToLoad();
                Assert.assertTrue("Open Claim not cancelled ", cancelClaimPage.isJobCancelledSuccefully());
                reviewClaimPage.clickDandGLogo();
            }
            homePage.clickCreateClaim();
            Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
            seleniumHelper.captureScreeshot();
            claimPage.searchForAPlan(planNo);
            claimPage.clickSelectProduct(planNo);
            claimPage.selectClaimType(claimType);
        }
//        Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
    }

    @Then("^I cancel the claim for \"([^\"]*)\" claim type \"([^\"]*)\"$")
    public void iCancelTheClaimFor(String planNo, String claimType) {
        Assert.assertTrue("QA Page not displayed", qandAProcessPage.isQandAPageLoaded());
        reviewClaimPage.clickMenuOption();
        Assert.assertTrue("Menu Page not Displayed", cancelClaimPage.isFunctionMenuPageDisplayed());
        cancelClaimPage.clickCancelClaimAction();
        cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");
        base.waitForPageToLoad();
        Assert.assertTrue("Open Claim not cancelled ", cancelClaimPage.isJobCancelledSuccefully());

    }

    @Then("^I enter \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String fault, String problemCode, String model) throws InterruptedException {

        WebElement isPncAvailable = driver.findElement(By.xpath("//*[@id=\"electroluxHolder\"]/div/div[1]/p[1]"));
        WebElement pncYes = driver.findElement(By.xpath("//*[@id=\"electroluxHolder\"]/div/div[1]/p[2]/input[1]"));
        base.checkIfELementIsAvailable(pncYes);
        pncYes.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement pncNumberListButton = driver.findElement(By.xpath("//*[@id=\"pncNoCode\"]/div/span/a"));
        WebElement pncSelectBox = driver.findElement(By.xpath("//*[@id=\"pncNoCode\"]/div/span/input"));
        pncNumberListButton.click();

        Thread.sleep(2000);

        seleniumHelper.actionToMoveDownOnList(pncSelectBox, 5);

        Thread.sleep(2000);


    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url) {
        driver.navigate().to(url);
//        base.waitForPageToLoad();
//        Assert.assertTrue("ServiceOptionPage not displayed",serviceOptionsPage.isServiceOptionsPageLoaded());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebElement elm = (WebElement) base.jsExecutor.executeScript("return document.evaluate('//*[@id=\"stepMenuTitleSpan\"][contains(.,\"SERVICE OPTIONS\")]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
//        LOGGER.info("elm Text : " + elm.getText());
    }

    @Then("^I enter \"([^\"]*)\" on the product confirmation section$")
    public void iEnterOnTheProductConfirmationSection(String model) {
        if (productConfirmationPage.isPopUpDisplayed()) {
            productConfirmationPage.confirmTheMake(model);
        } else {
            LOGGER.info("Product Confirmation Page not Displayed");
        }
    }

    @Then("^I enter \"([^\"]*)\" and \"([^\"]*)\" on the product confirmation section$")
    public void iEnterOnTheProductConfirmationSection(String model, String productType) {
        if (productConfirmationPage.isPopUpDisplayed()) {
            productConfirmationPage.confirmTheMake(model);
        } else {
            LOGGER.info("Product Confirmation Page not Displayed");
        }
    }


    @And("^I click create request button for Heating Goods$")
    public void iClickCreateRequestButtonForHeatingGoods() {
        claimPage.clickCreateRequest();

    }

    @And("^I click create request button for MobileClaims$")
    public void iClickCreateRequestButtonForRecipero() {
        claimPage.clickCreateRequest();
        overrideClaim.overrideIMEIonClaim();
        repairNotice.handleRepeatRepairNotice();


    }

    @And("^I click create request button for Goods$")
    public void iClickCreateRequestButtonForGoods() {
        claimPage.clickCreateRequest();

    }

    @And("^I waive off the Excess Pay$")
    public void iWaiveOffTheExcessPay() {
        Assert.assertTrue("WaiveExcess Page not displayed", callOutChargePopupPage.isPopUpDisplayed());
        callOutChargePopupPage.proceedToWaiveCharge();
        repairNotice.handleRepeatRepairNotice();

    }

    @And("^I waive off the Excess fee for Mobile$")
    public void iWaiveOffTheExcessPayMobile() {
        Assert.assertTrue("WaiveExcess Page not displayed", callOutChargePopupPage.excessFeePaymentDuePage.isPopUpDisplayed());
        callOutChargePopupPage.excessFeePaymentDuePage.proceedToWaiveCharge();
        repairNotice.handleRepeatRepairNotice();


    }

    @And("^I click process excess payment$")
    public void iClickProcessExcessPayment() {
        callOutChargePopupPage.proceedToExcessPay();
    }

    @And("^I verify the \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iVerifyTheIsCancelled(String planNo, String status) {
        if (status == "CANCELLED") {
            Assert.assertTrue("Plan is not in Cancelled Status", claimPage.isPlanInCancelledStatus());
        } else if (status == "LAPSED") {
            Assert.assertTrue("Plan is not in LAPSED Status", claimPage.isPlanInLapsedStatus());
        }
    }

    @Then("^I enter \"([^\"]*)\" on the product confirmation section for Television$")
    public void iEnterOnTheProductConfirmationSectionForTelevision(String model) {
        productConfirmationPage.setTheProductFromList(1); // Model
    }

    @Then("^I enter the Product details section \"([^\"]*)\" and serial number details$")
    public void iEnterTheProductDetailsSectionAndSerialNumberDetails(String pnc) {
        base.hardWait("5000");
        if (claimPage.checkIfProvidePNCIsNotChecked()) {
            claimPage.tickProvidePNCifNotChecked();
        }
        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        claimPage.enterConfirmProductDetailsSectionForPNC(pnc);
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("^I enter the Model Number in Product details section$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetails() {
//        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        claimPage.enterCorrectModel();
        claimPage.enterFaultCode();
        claimPage.enterProblemCode();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("^I enter the Model Number in NPV Product details section for HooverCandy$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsHc() {
//        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        planViewPageNPV.productConfirmationHoover.enterModelNumber();
        planViewPageNPV.productConfirmationHoover.enterFault();
        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.qandAProcessNPVPage.isQASectionPageDisplayed());

    }

//    @Then("^I enter the Model Number in Product details section for HooverCandy$")
//    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsHoov() {
////        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
////        claimPage.enterCorrectModel();
//        claimPage.enterFaultCode();
//        claimPage.enterProblemCode();
//        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());
//
//    }

    @Then("^I enter the Model Number in Product details section for Hoover$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsForHoov() {
//        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        claimPage.enterFirstModelFromList();
        claimPage.enterFirstFaultCodeFromList();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("^I enter the Model Number in Product details section for Whirlpool$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsForWhp() {
        claimPage.enterFirstModelFromListWhirlpool();
        claimPage.enterFirstFaultFromListWhirlpool();
        claimPage.enterProblemCodeFromListWhirlpool();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("^I enter the Model Number \"([^\"]*)\" in Product details section$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsWithModel(String model) {
//        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        claimPage.enterCorrectModel(model);
        claimPage.enterFaultCode();
        claimPage.enterProblemCode();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("^I enter the Model Number in Product details section for Boiler$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsForBoiler() throws InterruptedException {
        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        claimPage.enterCorrectModelForBoiler();
        claimPage.enterFaultOnly();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }


    @Then("^I enter the Product details section for any Model or \"([^\"]*)\" and serial number details$")
    public void iEnterTheProductDetailsSectionForModelAndSerialNumberDetails(String model) {
        base.waitForPageToLoad();
        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayedForModel());
        claimPage.enterConfirmProductDetailsSectionForModel(model);
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("^I verify the Plan is in warranty period$")
    public void iVerifyThePlanIsInWarrantyPeriod() {
        Assert.assertTrue("Unable to check Plan in Warranty", claimPage.isPlanInWarranty());
    }

    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessful(String planNo, String outCome) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }
        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed());
        Assert.assertTrue("DA Appointment status not verified", reviewClaimPage.verifyTheCurrentDiaryApointmentStatus(outCome));

    }

    @Then("^I Verify the Job Status in Orbit is writtenOff for the Plan \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheJobtatusOrbitIsSuccessful(String planNo, String outCome) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.contains("CRT") || (planNo.contains("") || (planNo.contains("CREATE_NEW_PLAN")))) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }
        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed());
        Assert.assertTrue("DA Appointment status not verified", reviewClaimPage.isClaimWrittenOff(outCome));

    }

    @Then("^I Verify the Job Status in Orbit is RepairCompleted for the Plan \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheJobtatusOrbitIsSuccessfulComplete(String planNo, String outCome) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }
        homePage.clickReviewClaimTab();
        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed());
        Assert.assertTrue("DA Appointment status not verified", reviewClaimPage.isClaimWrittenOff(outCome));

    }

    @When("^I search the claim for the Plan \"([^\"]*)\"$")
    public void iSearchTheClaimForThePlan(String planNo) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }

    }

    @When("^I search the claim for the Plan NPV \"([^\"]*)\"$")
    public void iSearchTheClaimForThePlanNPV(String planNo) throws Exception {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingClaimNo(commonUtils.getOpenClaimNo(planDetails.getPlanNumber()));
        } else {
            homePage.searchForAClaimUsingClaimNo(commonUtils.getOpenClaimNo(planNo));
        }

    }


    @Then("^I verify the review claim page displayed$")
    public void iVerifyTheReviewClaimPageDisplayed() {
        Assert.assertTrue("Review claim page not loaded", reviewClaimPage.isReviewClaimJobStatusDisplayed());
//        homePage.clickReviewClaimTab();
    }


    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan \"([^\"]*)\" and \"([^\"]*)\" for writtenoff$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessfulforwrittenoff(String planNo, String outCome) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }
        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed(outCome));

    }

    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan \"([^\"]*)\" and \"([^\"]*)\" for writtenoff in CC Page$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessfulforwrittenoffCC(String planNo, String outCome) {
        Assert.assertTrue(outCome + "in review claim page not verified", reviewClaimPage.isReviewClaimJobStatusDisplayed(outCome));

    }

    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for writtenoff in CC Page$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessfulforwrittenoffCC(String planNo, String outCome, String additionalStatus) {
        Assert.assertTrue(outCome + "in review claim page not verified", reviewClaimPage.isReviewClaimJobStatusDisplayed(outCome, additionalStatus));

    }

    @Then("^I enter PNC Details \"([^\"]*)\" on the product confirmation section$")
    public void iEnterPNCDetailsOnTheProductConfirmationSection(String pnc) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^I Confirm user is able to Run and generate a claim report$")
    public void iConfirmUserIsAbleToRunAndGenerateAClaimReport() {
        homePage.navigateToReportGenerator();
        Assert.assertTrue("Reports List Not Appeared", homePage.isReportGenertorSectionLoaded());
//        Assert.assertTrue("User can't run the Report",homePage.checkRunReportGeneratorReport());
    }

    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for writtenoff$")
    public void iVerifyTheJobCompletedStatusInOrbitIsSuccessfulForThePlanAndAndForWrittenoff(String planNo, String outCome, String additionalStatusCheck) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }

        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed(outCome, additionalStatusCheck));
    }

    @Then("^I enter the product confirmation section for the product type \"([^\"]*)\"$")
    public void iEnterTheProductConfirmationSectionForTheProductType(String productType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I search for the CacheLog for the \"([^\"]*)\" ran for \"([^\"]*)\"$")
    public void iSearchForTheCacheLogForThe(String planNo, String noOfTimes) {
        String currentPlanNo;

//        if (planNo.contains("CRT")) {
//            currentPlanNo = planDetails.getPlanNumber();
//        } else {
//           currentPlanNo = planNo;
//        }

        base.navigateToPage(base.prop.getProperty("CACHETOOL"));
        Assert.assertTrue("Failed to Load Session Cache Page", cachePage.isSessionCachePageLoaded());
        Assert.assertTrue("Cache Counter Value not matched", cachePage.isSessionCounterValueMatched(noOfTimes));


    }

    @Then("^I search for no CacheLog for the \"([^\"]*)\" ran for \"([^\"]*)\"$")
    public void iSearchForNoCacheLogForThe(String planNo, String noOfTimes) {
        String currentPlanNo;

//        if (planNo.contains("CRT")) {
//            currentPlanNo = planDetails.getPlanNumber();
//        } else {
//           currentPlanNo = planNo;
//        }

        base.navigateToPage(base.prop.getProperty("CACHETOOL"));
        Assert.assertTrue("Failed to Load Session Cache Page", cachePage.isSessionCachePageLoaded());
        Assert.assertTrue("Cache Counter Value not matched", cachePage.isSessionCounterValueNotToBeMatched(noOfTimes));


    }

    @When("^I wait for \"([^\"]*)\" seconds$")
    public void iWaitForSeconds(String secs) {
        base.hardWait(secs);
    }

    @Then("^I set the Recipero hook for \"([^\"]*)\"$")
    public void iSetTheReciperoHookFor(String url) {
        try {
            IMEI getIMEI = commonUtils.getRandomIMEI("Apple");
        } catch (Exception e) {
            e.printStackTrace();
        }
        apiHook.setNewApiHookForReciperoSearch(url);
        base.waitForPageToLoad();
        Assert.assertTrue("============>>>>>>> Hook Url not updated", apiHook.isReciperoSearchUrlUpdated(url));
    }


    @Given("^I createPerson$")
    public void iCreatePerson() throws IOException {
//        commonUtils.createPersonAPI();


    }

    @Given("^I am on the Home sreen$")
    public void iAmOnTheHomeSreen() {

    }

    @When("^I capture the colour and capacity$")
    public void iCaptureTheColourAndCapacity() {

    }

    @And("^I enter the contact details$")
    public void iEnterTheContactDetails() {

    }

    @When("^I capture the colour as \"([^\"]*)\"and capacity as \"([^\"]*)\"$")
    public void iCaptureTheColourAsAndCapacityAs(String colour, String capacity) {
        homePage.enterColourAndCapacity(colour, capacity);
        base.hardWait("3000");
//       Assert.assertTrue("Unable to Verify the Colour and Capacity",homePage.verifyTheColourAndCapacityIsEntered());
    }

    @And("^I enter the contact details \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterTheContactDetailsAnd(String email, String phone, String mobile) {

        homePage.enterCustomerContactDetails(email, phone, mobile);
//        Assert.assertTrue("Unable to Verify the Customer contact information Section",);
    }

    @And("^I Verify if the claim has to be override$")
    public void iVerifyIfTheClaimHasToBeOverride() {
        overrideClaim.overrideIMEIonClaim();
    }

    @Given("^I setup the hook for Recipero \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSetupTheHookForRecipero(String claimType, String make, String model) {
        apiHook.setNewApiHookForReciperoSearchInANewChromeTab(claimType, make, model);
        String updatedUrl = apiHook.getReciperoURL(claimType) + "?make=" + make + "&model=" + model.replace(" ", "+");
        base.waitForPageToLoad();
        base.hardWait("5000");
        Assert.assertTrue("============>>>>>>> Hook Url not updated", apiHook.isReciperoSearchUrlUpdated(updatedUrl));
        base.navigateToMainTab();
    }

    @Given("^I setup the hook for Recipero for FMI Status as \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSetupTheHookForReciperoFMI(String fmiStatus, String claimType, String make, String model) {
        String fmi = "notapplicable";
        if (!fmiStatus.isEmpty()) {
            fmi = fmiStatus;
        }
        apiHook.setNewApiHookForReciperoSearchInANewChromeTab(claimType, make, model, fmi);
        String updatedUrl = apiHook.getReciperoURL(claimType) + "?make=" + make + "&model=" + model.replace(" ", "+") + "&fmipstatus=" + fmi;
        base.waitForPageToLoad();
        Assert.assertTrue("============>>>>>>> Hook Url not updated", apiHook.isReciperoSearchUrlUpdated(updatedUrl));
        base.navigateToMainTab();
    }

    @When("^I perform the product confirmation section for Mobile$")
    public void iPerformTheProductConfirmationSectionForMobile() {
        mobileProductConfirmation.confirmIMEI();
    }


    @And("^I revert the Recipero hook to the live URL$")
    public void iRevertTheReciperoHookToTheLiveURL() {
        apiHook.setNewApiHookForReciperoSearchInANewChromeTab(base.prop.getProperty("RECIPERO_SEARCH_API"));
        base.waitForPageToLoad();
        Assert.assertTrue("============>>>>>>> Hook Url not updated", apiHook.isReciperoSearchUrlUpdated(base.prop.getProperty("RECIPERO_SEARCH_API")));
        base.navigateToMainTab();
    }

    @Given("^I click the PlanWriteOff Button on the Header menu$")
    public void iClickThePlanWriteOffButtonOnTheHeaderMenu() {
        homePage.clickPlanWriteOffMenu();
    }

    @When("^I verify the PlanWriteOff Page is now displayed$")
    public void iVerifyThePlanWriteOffPageIsNowDisplayed() {
        Assert.assertTrue("Plan Write Off Page not displayed", planWriteOff.isPlanWriteOffPageDisplayed());
    }

    @Then("^I write off the \"([^\"]*)\" with the write off status as \"([^\"]*)\" for \"([^\"]*)\"$")
    public void iWriteOffTheWithTheWriteOffStatusAs(String planNo, String outCome, String oEM) throws InterruptedException {
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            Thread.sleep(10000);
            planWriteOff.writeOffPlan(planDetails.getPlanNumber(oEM), outCome, oEM);

        } else {
            Thread.sleep(10000);
            planWriteOff.writeOffPlan(planNo, outCome, oEM);
        }
    }

    @Then("^I verify the Plan has been written off Successfully$")
    public void iVerifyThePlanHasBeenWrittenOffSuccessfully() {
        Assert.assertTrue("Failed to Write Off Plan", planWriteOff.isPlanSuccessfullyWrittenOff());
    }

    //Manish Kumar Jain: Dated - 21st June 2021, Method to prepopulate the PNC.
    @Then("^I verify that Number \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" pre-populates in the dropdown$")
    public void iVerifyPNCMLSNNumberPrePopulates(Integer pnc, Integer ml, Integer sn) throws InterruptedException {
        homePage.verifyPncPrePopulates();
        Thread.sleep(2000);
        homePage.verifyMlCodePrePopulates();
        Thread.sleep(2000);
        homePage.verifySNPrePopulates();
        Thread.sleep(2000);
    }

    //Manish Kumar Jain: Dated - 22nd June 2021, Method to click on the Radio Buttonand select the PNC.
    @Then("^I click on the PNC radio button and select the PNC value from the dropdown$")
    public void iClickOnThePncRadioButton() throws InterruptedException {
        Thread.sleep(3000);
        homePage.clickOnPncRadioButton();
        Thread.sleep(3000);
    }

    /*Manish Kumar Jain: Dated - 17th Nov 2021
    Scenario: Search claim no. from the Orbit Home Page.
     */
    @Given("^I enter claim number \"([^\"]*)\" and click search button for Whirlpool OEM$")
    public void i_enter_claim_number_and_click_search_button_for_Whirlpool_OEM(String claimno) throws InterruptedException {
        Thread.sleep(3000);
        homePage.searchForAClaimUsingClaimNo(claimno);
    }


    @Given("^I test orbit$")
    public void iTestOrbit() {
        System.out.println("Test");
    }

    @Then("^I verify the test is pass$")
    public void iVerifyTheTestIsPass() {
        Assert.assertTrue("TEST FAILED", true);
    }

    @Then("^I verify the test is fail$")
    public void iVerifyTheTestIsFail() {
        Assert.assertTrue("TEST FAILED", false);
    }

    @When("^I download the file to target folder$")
    public void iDownloadTheFileToTargetFolder() {
        homePage.runReportGeneratorReport("SPSC", "01/01/2021", "10/03/2021");
        Assert.assertTrue("ReportGenerator file not downloaded", homePage.isReportGeneratorPageDisplayed("SPSC"));
    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" to search for Plan View for \"([^\"]*)\"$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClicktoSearchForPlanView(String planNo, String oEM) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber(oEM));
        } else {
            try {
                if (!commonUtils.cancelAnOpenClaim(planNo)) {
                    iCancelTheClaimForNPV(planNo);
                }
                ;
            } catch (Exception e) {
                e.printStackTrace();
            }
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.isPageHeaderTitleDisplayed());

    }

    @Then("^I cancel the open claim for NPV\"([^\"]*)\"$")
    public void iCancelTheClaimForNPV(String planNo) throws Exception {

        if (commonUtils.getOpenClaimNo(planNo) != null) {
            base.navigateToPage(" https://www.skylinecms.co.uk/domgenprelive/index/canceljob/" + commonUtils.getOpenClaimNo(planNo));
            cancelClaimPage.clickCancelClaimAction();
            cancelClaimPage.confirmClaimCancellation("DUPLICATE CLAIM", "Test");
            base.waitForPageToLoad();
            Assert.assertTrue("Open Claim not cancelled ", cancelClaimPage.isJobCancelledSuccefully());
        }

    }

    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessfulNPV(String planNo, String outCome) throws Exception {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchForAClaimUsingClaimNo(commonUtils.getOpenClaimNo(planDetails.getPlanNumber()));

        } else {
            homePage.searchForAClaimUsingClaimNo(commonUtils.getOpenClaimNo(planNo));
        }
//        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed());
        Assert.assertTrue("DA Appointment status not verified", planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(outCome));

    }

    @Then("^I Verify the job status for NPV \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessfulNPVJobStat(String planNo, String outCome) throws Exception {
        base.refreshPage();
        base.waitForPageToLoad();
        base.hardWait("2000");
        Assert.assertTrue("DA Appointment status not verified", planViewPageNPV.bookingOverviewPage.isJobStatusUpdated(outCome));

    }

    @Given("I click create claim and I create a plan number using {string} {string} {string} {string} and {string} to search for Plan View")
    public void iClickCreateClaimAndICreateAPlanNumberUsingAndToSearchForPlanView(String planNo, String oem, String scheme, String itemCode, String makerCode) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber(oem, scheme, itemCode, makerCode));
        } else {
            try {
                if (!commonUtils.cancelAnOpenClaim(planNo)) {
                    if (planViewPageNPV.cancelJobFromUI(planNo)) {
                        planViewPageNPV.clickOnDnGLogoForNPV();
                        homePage.clickCreateClaim();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                claimPage.searchForAPlan(planNo);
            }
//            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.isPageHeaderTitleDisplayed());

    }

    @And("^I enter the fault code in Product details section and continue$")
    public void iEnterTheFaultCode() {
        claimPage.enterFaultCode();
        planViewPageNPV.productConfirmationPNC.enterContinueButton();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Then("I enter the Model Number {string} and fault in Product details section for Boiler for NPV")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsForBoilerNPV(String model) {
        claimPage.enterModelOnly(model);
        planViewPageNPV.productConfirmationPNC.enterFaultOnly();
        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }

    @Then("I enter the Model Number {string} only in Product details section for NPV")
    public void iEnterTheModelProductDetailsSectionOnly(String model) {
        claimPage.enterModelOnly(model);
        planViewPageNPV.productConfirmationPNC.enterFaultOnly();
        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }

    @Then("I enter the just the Model Number {string} only in Product details section for NPV")
    public void iEnterJustTheModelProductDetailsSectionOnly(String model) {
        claimPage.enterModelOnly(model);
    }

    @Then("I enter the fault only in Product details section for NPV")
    public void iEnterTheFaultOnlyProductDetailsSectionOnly() {
        planViewPageNPV.productConfirmationPNC.enterFaultOnly();
//        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }

    @Then("I enter the problem code only in Product details section for NPV")
    public void iEnterTheProblemCodeOnlyProductDetailsSectionOnly() {
        planViewPageNPV.productConfirmationPNC.enterProblemCodeOnly();
//        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }

    @Then("I click continue button in Product details section for NPV")
    public void iClickContinueBtnInProductDetailsSectionOnly() {
        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }

    @Given("I create the WHP Tracking file")
    public void iCreateTheWHPTrackingFile() {

        whirlpoolImportFile.createImportFile("NEW REPAIR", planDetails.getPlanNumber("Whirlpool").substring(0, 3), planDetails.getPlanNumber("Whirlpool").substring(3, 10)
                , seleniumHelper.mockData.faker.number().digits(8), "ABRT", "1", seleniumHelper.currentDate());
    }

    @When("I load the import file for whirlpool jobimport")
    public void iLoadTheImportFileForWhirlpoolJobimport() {

        Assert.assertTrue("Page not laoded", whirlpoolJobImportPage.isJobImportPageLoaded());
        whirlpoolJobImportPage.loadImportFile();
//        seleniumHelper.uploadFile();
    }

    @When("I navigate to Whirlpool import wizard")
    public void iNavigateToWhirlpoolImportWizard() {
//        homePage.navigateTSiteMap();
        base.navigateToPage(base.prop.getProperty("JOBIMPORT_WHP"));
    }

    @Given("^I enter Plan number \"([^\"]*)\" and click search button in Track Repair or Claim$")
    public void i_enter_plan_number_something_and_click_search_button_in_track_repair_or_claim(String PlanNo) throws InterruptedException {
        Thread.sleep(3000);
        homePage.searchForAClaimUsingPlanNo(PlanNo);
    }

    @Then("I enter the WHPL Model Number {string} only in Product confirmation section for NPV")
    public void iEnterWhplModelProductDetailsSectionOnly(String model) {
        claimPage.enterWhplModelOnly(model);
    }

    @Then("I enter the WHPL fault only in Product confirmation section for NPV")
    public void iEnterTheWhplFaultOnlyProductConfirmationSectionOnly() {
        planViewPageNPV.productConfirmationPNC.enterWhplFaultOnly();
//        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();
    }

    @Then("I enter the WHPL problem code only in Product confirmation section for NPV")
    public void iEnterTheWhplProblemCodeOnlyProductConfirmationSectionOnly() {
        planViewPageNPV.productConfirmationPNC.enterWhplProblemCodeOnly();
//        Assert.assertTrue("Create Request Button not Enabled", planViewPageNPV.productConfirmationPNC.isContinueButtonEnabled());
//        planViewPageNPV.productConfirmationPNC.enterContinueButton();

    }


    @When("I click on Plan Write Off button")
    public void iClickOnPlanWriteOffButton() {
        Assert.assertTrue("Unable to click on Plan Write Off button", homePage.clickPlanWriteOffButton());
    }

    @Given("I enter claim number {string} and click search button")
    public void iEnterClaimNumberAndClickSearchButton(String claimNo) throws InterruptedException {
        Thread.sleep(3000);
        homePage.searchForAClaimUsingClaimNo(claimNo);
    }

    @Then("I enter Skipped Plan Number {string}, Customer Surname {string} and Customer Postcode {string}")
    public void iEnterSkippedPlanNumberCustomerSurnameAndCustomerPostcode(String skippedPlanNumber, String customerSurname, String customerPostcode) {
        Assert.assertTrue("Unable to enter Customer details to plan write off", planWriteOff.enterPlanWriteOffDetails(skippedPlanNumber, customerSurname, customerPostcode));
    }

    @Then("I click on Search button")
    public void iClickOnSearchButton() {
        planWriteOff.clickOnSearchButton();
    }

    @And("I Verify the {string} is not matching in Plan & Product Details section")
    public void iVerifyTheIsNotMatchingInPlanProductDetailsSection(String skippedPlanNumber) {
        Assert.assertNotEquals(planWriteOff.planNumberCheck(), skippedPlanNumber);
    }

    @And("I Verify the {string} is matching in Plan & Product Details section")
    public void iVeifyTheIsMatchingInPlanProductDetailsSection(String newPlanNumber) {
        Assert.assertTrue("New plan no. is not present in the plan details", planWriteOff.newPlanNumberCheck(newPlanNumber));
    }


    @And("I confirm the appliance is still in usable condition")
    public void iConfirmTheApplianceIsStillInUsableCondition() {
        planViewPageNPV.productConfirmationPNC.verifyTheApplianceStillInUsableCondition();
    }

    @Then("I verify the Make {string} Use generic model checkbox and enter ModelNumber {string} on product confirmation")
    public void iVerifyTheMakeUseGenericModelCheckboxAndEnterModelNumberOnProductConfirmation(String make, String modelNumber) {
        Assert.assertTrue(" Product confirmation section is not loaded successfully ", planViewPageNPV.productConfirmationPNC.verifyTheMakeAndUseGenericModelCheckboxAndEnterTheModelNumber(make, modelNumber));
    }

    @Given("^I verify the \"([^\"]*)\" and the Use generic model checkbox are displayed on the product confirmation for WHPL SP")
    public void iVerifyMakeAndUseGenericModelCheckboxInProductConfirmationOnly(String make) throws InterruptedException {
        Thread.sleep(3000);
        homePage.isMakeWhplMBOrNonWhplMB(make);
    }


    @Then("I open the WHP Tracking file and update the field {string} as {string}")
    public void i_open_the_WHP_Tracking_file_and_update_the_field_as(String column, String value) throws IOException {
        homePage.updateWHPTrackingFile(column, value);
    }

    @Then("I navigate to the previous tab")
    public void i_navigate_to_the_previous_tab() {
        base.navigateToPreviousTab();
        base.waitForPageToLoad();
        base.hardWait("2000");
    }

    @Given("I open the WHP Tracking file and update the field {string}")
    public void i_open_the_WHP_Tracking_file_and_update_the_field(String column) throws IOException {
        String value = "";

        switch (column) {
            case "RepairUniqueID":
                value = bookingConfirmedPage.repairerRefNo;
                break;
            case "SchemeCode":
                value = planDetails.getPlanNumber().substring(0, 3);
                break;
            case "PlanNumber":
                value = planDetails.getPlanNumber().substring(3, 10);
                break;
            case "EngineerApptDate":
                value = bookingConfirmedPage.apptDate.replaceAll("[^0-9/]", "").replaceAll("/", "-");
                break;
            case "VisitNo":
                value = "1";
                break;
            case "EngineerApptFromTime":
                value = "07:15";
                break;
            case "EngineerApptToTime":
                value = "13:00";
                break;
        }
        homePage.updateWHPTrackingFile(column, value);

    }

    @Given("I open the WHP Tracking file and update the field {string} for the Repair Status {string}")
    public void i_open_the_WHP_Tracking_file_and_update_the_field_JobCompletionRef_for_the_Repair_Status(String column, String repairStatus) throws IOException {
        String value="";
        if(repairStatus.equalsIgnoreCase("COMP")) {
            value=base.generateRandomNum();
            homePage.updateWHPTrackingFile(column, value);
        }
        // homePage.updateWHPTrackingfilewithRandomNum(column, repairStatus);
    }

//    @Then("I select the WHPL model number \"([^\"]*)\" from the dropdown")
//    public void i_select_the_WHPL_model_number_from_the_dropdown(String modelNumber) {
//
//    }

    @Then("I select the WHPL model number {string} from the dropdown")
    public void i_select_the_whpl_model_number_from_the_dropdown(String modelNumber) {
        Assert.assertTrue(" Product confirmation section is not loaded successfully ", planViewPageNPV.productConfirmationPNC.selectWhplModel(modelNumber));
    }

    @Then("I enter the text in WHPL Fault Search box and click on search icon")
    public void i_enter_the_text_in_WHPL_fault_search_box_and_click_on_search_icon() throws InterruptedException {
        planViewPageNPV.productConfirmationPNC.enterTextInWhplTextSearchBox();
        Thread.sleep(3000);
    }

    @Then("I select Use generic model checkbox")
    public void iSelectUseGenericModelCheckbox() {
        Assert.assertTrue(" Product confirmation section is not loaded successfully ", planViewPageNPV.productConfirmationPNC.selectUseGenericModelCheckbox());
    }

    @Then("I open the WHP Exchange file and update the field {string}")
    public void i_open_the_WHP_Exchange_file_and_update_the_field(String column) throws IOException {
        String value = "";

        switch (column) {
            case "Customer":
                value = planViewPageNPV.custName;
                break;
            case "Address":
                value = planViewPageNPV.custAddrLine1;
                break;
            case "Postcode":
                value = planViewPageNPV.custpostCode;
                break;
            case "Mobile Phone":
                value = planViewPageNPV.custMobileNum;
                break;
            case "Current Model":
                value = planViewPageNPV.planModel;
                break;
            case "Purchase Date":
                value = repairInformation.purchaseDate.replaceAll("/", ".");
                break;
            case "Authority Number":
                value = base.generateRandomNum();
                break;
            case "Policy Number":
                value = planDetails.getPlanNumber();
                break;
            case "Email ID":
                value = planViewPageNPV.custEmail;
                break;
        }
        homePage.updateWHPExchangeFile(column, value);
    }

    @Then("I get the Customer details from the Plan View screen")
    public void i_get_the_Customer_details_from_the_Plan_View_screen() throws IOException {
        planViewPageNPV.getCustomerDetails();
    }

    @Then("I open the WHP Exchange file and update the field {string} as {string}")
    public void i_open_the_WHP_Exchange_file_and_update_the_field_as(String column, String value) throws IOException {
        homePage.updateWHPExchangeFile(column, value);
    }


    @And("I click on Flagged Risk Claims Hotspot")
    public void iClickOnFlaggedRiskClaimsHotspot() {
        homePage.clickFlaggedRiskClaimsHotspot();
    }

    @Then("I Confirm Flagged Risk Claims Grid is displayed and search for the claim using {string}")
    public void iConfirmFlaggedRiskClaimsGridIsDisplayedAndSearchForTheClaimUsing(String planNo) throws Exception {
        Assert.assertTrue("Flagged Risk Claims Hotspot Grid not loaded ",homePage.isFlaggedRiskClaimsHotspotGridLoaded());
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            homePage.searchReferredClaimInRiskClaimsHotspot(commonUtils.getOpenClaimNo(planDetails.getPlanNumber()));

        } else {
            homePage.searchReferredClaimInRiskClaimsHotspot(commonUtils.getOpenClaimNo(planNo));
        }
//        homePage.searchForAClaimUsingPlanNoInRiskClaimsHotspot(planNo);
    }

    @And("I verify referred claim is updated in the grid")
    public void iVerifyReferredClaimIsUpdatedInTheGrid() {
        Assert.assertTrue(" Referred claim is not displayed in Flagged Risk Claims Hotspot Grid",homePage.isReferredClaimDisplayed());
    }

    @Then("I click on Repair Authority tab and verify page loaded successfully")
    public void iClickOnRepairAuthorityTabAndVerifyPageLoadedSuccessfully() throws InterruptedException {
        reviewClaimPage.clickRepairAuthority();
    }
}