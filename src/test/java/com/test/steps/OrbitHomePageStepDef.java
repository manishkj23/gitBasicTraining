package com.test.steps;


import com.test.pages.*;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanWriteOff;
import com.test.pages.CCAgentUI_NPV.HomePageNPV;
import com.test.pages.CCAgentUI_NPV.PlanViewPageNPV;
import com.test.pages.CCAgent_OLDUI.APIIntegrator;
import com.test.pages.CCAgent_OLDUI.DialogPopups.ConfirmIMEIOverrideOnADifferentPlan;
import com.test.pages.CCAgent_OLDUI.DialogPopups.RepeatRepairNotice;
import com.test.pages.CCAgent_OLDUI.ProductConfirmationSections.ProductConfirmationMobile;
import com.test.pages.DataTools.SessionCachePage;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.OrbitUtils.QuestionDatabase;
import com.test.utils.SeleniumHelper;
import cucumber.api.PendingException;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
    private QuestionDatabase qaUtil;
    private PlanDetails planDetails;
    private PlanViewPageNPV planViewPageNPV;
    private CommonUtils commonUtils;
    private SessionCachePage cachePage;
    private APIIntegrator apiHook;
    private ConfirmIMEIOverrideOnADifferentPlan overrideClaim;
    private ProductConfirmationMobile mobileProductConfirmation;
    private RepeatRepairNotice repairNotice;
    private PlanWriteOff planWriteOff;
    private HomePageNPV homePageNPV;


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
                                QuestionDatabase qaUtil,
                                PlanDetails planDetails,PlanViewPageNPV planViewPageNPV) {
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
        this.qaUtil = qaUtil;
        this.planDetails = planDetails;
        this.planViewPageNPV = planViewPageNPV;
    }

    @Then("^I verify the Login is successful$")
    public void iVerifyTheLoginIsSuccessful() {
        Assert.assertTrue("LoginFailed", homePage.isHomePageLoaded());
        LOGGER.info("==========>>>>>>>>>> Login Page to be Verified with valid credentials");
        seleniumHelper.captureScreeshot();
    }


    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search for WrittenOff$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearchForWrittenOff(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @Then("^I Verify the \"([^\"]*)\" details displayed$")
    public void iVerifyTheDetailsDisplayed(String planNo) {
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @Then("^I Verify the \"([^\"]*)\" details displayed for WrittenOff$")
    public void iVerifyTheDetailsDisplayedForWrittenOff(String planNo) {
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @And("^I verify the \"([^\"]*)\" is in Live Status$")
    public void iVerifyTheIsInLiveStatus(String planNo) {
        Assert.assertTrue("Plan is not in Live Status", claimPage.isPlanInLiveStatus());
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
        if (planNo.equals("CRT")) {
            claimPage.clickSelectProduct(planDetails.getPlanNumber());
        } else {
            claimPage.clickSelectProduct(planNo);
        }
        claimPage.selectClaimType(claimType);
        Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
    }

    @When("^I select the product for WrittenOff \"([^\"]*)\" and click the claim type \"([^\"]*)\"$")
    public void iSelectTheProductAndClickTheClaimTypeForWrittenOff(String planNo, String claimType) {
        if (planNo.equals("CRT")) {
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
        if (status == "CANCELLED") {
            Assert.assertTrue("Create Request button not Enabled", claimPage.isPlanInCancelledStatus());
        } else if (status == "LAPSED") {
//            Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
        }
    }

    @When("^I select the product \"([^\"]*)\" and verify the claim status as \"([^\"]*)\"$")
    public void iSelectTheProductAndVerifyTheClaimStatusAs(String planNo, String status) {
        claimPage.clickSelectProduct(planNo);
        if (status == "CANCELLED") {
            Assert.assertTrue("Claim is not in Cancelled State", claimPage.isPlanCancelledPopupExist());
        } else if (status == "LAPSED") {
            Assert.assertTrue("Claim is not in Lapsed State", claimPage.isPlanLapsedPopupExist());
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


    @And("^I click create request button for Heating Goods$")
    public void iClickCreateRequestButtonForHeatingGoods() {
        claimPage.clickCreateRequest();

    }

    @And("^I click create request button for Goods$")
    public void iClickCreateRequestButtonForGoods() {
        claimPage.clickCreateRequest();

    }

    @And("^I waive off the Excess Pay$")
    public void iWaiveOffTheExcessPay() {
        Assert.assertTrue("WaiveExcess Page not displayed", callOutChargePopupPage.isPopUpDisplayed());
        callOutChargePopupPage.proceedToWaiveCharge();


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
            Assert.assertTrue("Plan is not in LAPSED Status", claimPage.isPlanInCancelledStatus());
        }
    }

    @Then("^I enter \"([^\"]*)\" on the product confirmation section for Television$")
    public void iEnterOnTheProductConfirmationSectionForTelevision(String model) {
        productConfirmationPage.setTheProductFromList(1); // Model
    }

    @Then("^I enter the Product details section \"([^\"]*)\" and serial number details$")
    public void iEnterTheProductDetailsSectionAndSerialNumberDetails(String pnc) {
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
        if (planNo.contains("CRT")) {
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
        if (planNo.contains("CRT")) {
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
        if (planNo.contains("CRT")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }
        homePage.clickReviewClaimTab();
        Assert.assertTrue("Review Claim page not displayed", reviewClaimPage.isReviewClaimJobStatusDisplayed());
        Assert.assertTrue("DA Appointment status not verified", reviewClaimPage.isClaimWrittenOff(outCome));

    }

    @Then("^I Verify the Job Completed Status in Orbit is Successful for the Plan \"([^\"]*)\" and \"([^\"]*)\" for writtenoff$")
    public void iVerifyTheJobCompletedStatusOrbitIsSuccessfulforwrittenoff(String planNo, String outCome) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.contains("CRT")) {
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

    @Then("^I enter PNC Details \"([^\"]*)\" on the product confirmation section$")
    public void iEnterPNCDetailsOnTheProductConfirmationSection(String pnc) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^I Confirm user is able to Run and generate a claim report$")
    public void iConfirmUserIsAbleToRunAndGenerateAClaimReport() {
        homePage.navigateToReportGenerator();
        Assert.assertTrue("Reports List Not Appeared",homePage.isReportGenertorSectionLoaded());
        Assert.assertTrue("User can't run the Report",homePage.checkRunReportGeneratorReport());
    }

    //Manish Kumar Jain
    @Then("^I verify that Number \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" pre-populates in the dropdown$")
    public void iVerifyPNCNumberPrePopulates(Integer pnc, Integer ml, Integer sn) throws InterruptedException {
        homePage.verifyPncPrePopulates();
        Thread.sleep(2000);
        homePage.verifyMlCodePrePopulates();
        Thread.sleep(2000);
        homePage.verifySNPrePopulates();
        Thread.sleep(2000);
    }

    //Manish Kumar Jain
    @Then("^I click on the PNC radio button and select the PNC value from the dropdown$")
    public void iClickOnThePncRadioButton() throws InterruptedException {
        Thread.sleep(3000);
        homePage.clickOnPncRadioButton();
        Thread.sleep(3000);
    }

    @Given("^I search the claim for the Plan \"([^\"]*)\"$")
    public void iSearchTheClaimForThePlan(String planNo) {
        Assert.assertTrue("Home page not loaded", homePage.isHomePageLoaded());
        if (planNo.contains("CRT")) {
            homePage.searchForAClaimUsingPlanNo(planDetails.getPlanNumber());
        } else {
            homePage.searchForAClaimUsingPlanNo(planNo);
        }

    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" and click search$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClickSearch(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
//        claimPage.searchForAPlan(planNo);
        if (planNo.equals("CRT")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
        } else {
            claimPage.searchForAPlan(planNo);
        }}

    @Then("^I enter the Model Number in Product details section for Boiler$")
    public void iEnterTheModelProductDetailsSectionAndSerialNumberDetailsForBoiler() {
//        Assert.assertTrue("Confirm Product Details section not displayed", claimPage.isConfirmProductDetailsSectionDisplayed());
        claimPage.enterCorrectModelForBoiler();
        claimPage.enterFaultOnly();
        Assert.assertTrue("Create Request Button not Enabled", claimPage.isCreateRequestButtonEnabled());

    }

    @Given("^I click create claim and I enter plan number \"([^\"]*)\" to search for Plan View$")
    public void iClickCreateClaimAndIEnterPlanNumberAndClicktoSearchForPlanView(String planNo) {
        homePage.clickCreateClaim();
        Assert.assertTrue("Plan Search section not displayed", claimPage.isPlanSearchTitleExist());
        seleniumHelper.captureScreeshot();
        if (planNo.equals("CRT") || planNo.isEmpty() || planNo.contains("CREATE_NEW_PLAN")) {
            claimPage.searchForAPlan(planDetails.getPlanNumber());
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
            }
            claimPage.searchForAPlan(planNo);
        }
        Assert.assertTrue("Plan Details section not displayed", planViewPageNPV.isPageHeaderTitleDisplayed());

    }
}
