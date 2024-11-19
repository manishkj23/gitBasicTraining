package com.test.steps;

import com.test.pages.*;
import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.CCAgent_OLDUI.ReviewClaimPage;
import com.test.pages.CCAgent_OLDUI.ServiceOptionsPage;
import com.test.pages.ExcessPayment.CallOutChargePopupPage;
import com.test.utils.BasePage;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.OrbitUtils.QuestionDatabase;
import com.test.utils.SeleniumHelper;
import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class Srv9487BekoFaultCodeStepDef {

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
    private Srv9487BekoFaultCode srv9487BekoFaultCode;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrbitHomePageStepDef.class);

    public Srv9487BekoFaultCodeStepDef(BasePage basePage,
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
                                PlanDetails planDetails,
                                Srv9487BekoFaultCode srv9487BekoFaultCode) {
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
        this.srv9487BekoFaultCode=srv9487BekoFaultCode;
    }

    @Given("^I click create claim and I enter BEKO plan number \"([^\"]*)\" and click search$")
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

    @Then("^I Verify the \"([^\"]*)\" details displayed in Plan & Product Details$")
    public void iVerifyTheDetailsDisplayed(String planNo) {
        Assert.assertTrue("Plan Details section not displayed", claimPage.isPlanDetailsDisplayed());
    }

    @When("^I select the product for BEKO \"([^\"]*)\" and click the claim type \"([^\"]*)\"$")
    public void iSelectTheProductAndClickTheClaimTypeForBekoPlan(String planNo, String claimType) {
        if (planNo.equals("CRT")) {
            claimPage.clickSelectProduct(planDetails.getPlanNumber());
        } else {
            claimPage.clickSelectProduct(planNo);
        }
        claimPage.selectClaimType(claimType);
        Assert.assertTrue("Create Request button not Enabled", claimPage.isCreateRequestButtonEnabled());
    }

    @Then("^I verify the claim type selected and Confirm Product Details section displayed$")
    public void iVerifyTheClaimTypeSelectedAndConfirmProductSectionDisplayed() {
        Assert.assertTrue("Confirm Product Details Section not Displayed", claimPage.isConfirmProductDetailsSectionLoaded());
    }

    @Then("^I select the Model from the dropdown in Product details section for the respective OEM$")
    public void i_select_the_model_something_from_the_dropdown_in_product_details_section_for_the_respective_oem(){
    srv9487BekoFaultCode.enterConfirmProductDetailsSectionForBekoModelCode();
    }

    @Then("^I select the Fault option from the Beko fault description Dropdown$")
    public void i_select_the_fault_option_from_the_fault_description_dropdown(){
    srv9487BekoFaultCode.enterConfirmProductDetailsSectionForBekoFaultCodeDescription();
    }

    @And("^I Click on Create Request Button$")
    public void iClickCreateRequestButton() {
        //claimPage.clickCreateRequest();
        srv9487BekoFaultCode.clickOnCreateRequestButton();
        Assert.assertTrue("Unable to verify the Claim Status as Claim Created", qandAProcessPage.isClaimCreated());
    }

    @Then("^I verify the Claim Created successfully$")
    public void iVerifyTheClaimCreated() {
        Assert.assertTrue("Unable to verify Claim Number",qandAProcessPage.isClaimNoDisplayed());
    }

    @When("^I enter the QA section with below tree for Beko plan$")
        public void iEnterTheQASectionWithBelow(DataTable dt) {
            List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
            for(int i=0; i<questions.size(); i++) {
                Assert.assertTrue("Question not loaded:",srv9487BekoFaultCode.isQuestionDisplayed(questions.get(i).get("Question")));
                srv9487BekoFaultCode.setAnswer(questions.get(i).get("Answer"),questions.get(i).get("AnswerType"));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(questions.get(i).get("SubQuestion") != null) {
                    if (questions.get(i).get("SubQuestion").isEmpty()) {
                        qandAProcessPage.clickSubmitAnswerButton();
                    }
                } else {
                    qandAProcessPage.clickSubmitAnswerButton();
                }
            }
    }

    @Then("^I verify claim is Accepted successfully$")
        public void iVerifyClaimIsInAcceptedStatus() {
            Assert.assertTrue("Claim is not in Accepted Status",qandAProcessPage.isClaimInAcceptedStatus());
        }

}
