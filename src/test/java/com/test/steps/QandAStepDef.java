package com.test.steps;


import com.test.pages.CCAgentUI_NPV.Aquant.AquantHomePage;
import com.test.pages.CCAgentUI_NPV.ReciperoQATree.QApopups.FMIEnabledPopup;
import com.test.pages.CCAgent_OLDUI.QandAProcessPage;
import com.test.pages.CCAgent_OLDUI.ServiceOptionsPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class QandAStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private QandAProcessPage qaPage;
    private ServiceOptionsPage serviceOptionsPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(QandAStepDef.class);
    private FMIEnabledPopup fmiEnabledPopup;
    private AquantHomePage aquantHomePage;

    public QandAStepDef(BasePage basePage, SeleniumHelper seleniumHelper, QandAProcessPage qaPage, ServiceOptionsPage serviceOptionsPage, FMIEnabledPopup fmiEnabledPopup, AquantHomePage aquantHomePage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.qaPage = qaPage;
        this.serviceOptionsPage = serviceOptionsPage;
        this.fmiEnabledPopup = fmiEnabledPopup;
        this.aquantHomePage = aquantHomePage;
    }


    @And("^I enter the QA section with below$")
    public void iEnterTheQASectionWithBelow(DataTable dt) {
        List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
        for (int i = 0; i < questions.size(); i++) {
            Assert.assertTrue("Question not loaded:", qaPage.isQuestionDisplayed(questions.get(i).get("Question")));
            qaPage.setAnswer(questions.get(i).get("Answer"), questions.get(i).get("AnswerType"));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (questions.get(i).get("SubQuestion") != null) {
                if (questions.get(i).get("SubQuestion").isEmpty()) {
                    qaPage.clickSubmitAnswerButton();
                }
            } else {
                if (qaPage.isAnswerTextAreaAvailable()) {
                    qaPage.enterAnswerTextArea("Automation");
                }
                qaPage.clickSubmitAnswerButton();
            }
        }
//        Assert.assertTrue("Question Tree Not Completed",qaPage.isQuestionTreeCompleted());
    }

    @Then("^I verify claim is in Accepted status$")
    public void iVerifyClaimIsInAcceptedStatus() {
        Assert.assertTrue("Claim is not in Accepted Status", qaPage.isClaimInAcceptedStatus());
    }

    @Then("^I verify claim is in Rejected status$")
    public void iVerifyClaimIsInRejectedStatus() {
        Assert.assertTrue("Claim is not in Accepted Status", qaPage.isClaimInRejectedStatus());
    }

    @Then("^I click service option and verify service optionsPage loaded$")
    public void iClickServiceOptionAndVerifyServiceOptionsPageLoaded() {
        qaPage.selectServiceOptionUrl();
        Assert.assertTrue("Service Options Page not displayed", serviceOptionsPage.isServiceOptionsPageLoaded());

    }

    @Then("^I verify the Claim Created$")
    public void iVerifyTheClaimCreated() {
        Assert.assertTrue("Unable to verify Claim Number", qaPage.isClaimNoDisplayed());
    }

    @And("^I enter the NPV QA section with below$")
    public void iEnterTheNPVQASectionWithBelow(DataTable dt) {
        base.hardWait("9000");
        List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
        for (int i = 0; i < questions.size(); i++) {
            Assert.assertTrue("Question not loaded:", qaPage.isQuestionDisplayed(questions.get(i).get("Question")));
            base.hardWait("10000");
            qaPage.setAnswer(questions.get(i).get("Answer"), questions.get(i).get("AnswerType"));
            if (questions.get(i).get("SubQuestion") != null) {
                if (questions.get(i).get("SubQuestion").isEmpty()) {
                    qaPage.clickSubmitAnswerButton();
                }
            } else {
                if (qaPage.isAnswerTextAreaAvailableExtended()) {
                    qaPage.enterAnswerTextArea("Automation");
                }
                qaPage.clickSubmitAnswerButton();
            }
        }

    }

    @And("^I enter the NPV QA section with below for Triage$")
    public void iEnterTheNPVQASectionWithBelowForTriage(DataTable dt) {
        List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
        for (int i = 0; i < questions.size(); i++) {
            Assert.assertTrue("Question not loaded:", qaPage.isQuestionDisplayed(questions.get(i).get("Question")));
            qaPage.setAnswer(questions.get(i).get("Answer"), questions.get(i).get("AnswerType"));
            if (questions.get(i).get("SubQuestion") != null) {
                if (questions.get(i).get("SubQuestion").isEmpty()) {
                    qaPage.clickSubmitAnswerButton();
                }
            } else {
                if (qaPage.isAnswerTextAreaAvailableExtended()) {
                    qaPage.enterAnswerTextArea("Automation");
                }
                qaPage.clickSubmitAnswerButton();
            }
        }

    }

    @And("^I enter the QA for Aquant and save$")
    public void iEnterTheQASectionForAquantTriage(DataTable dt) {
        List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
        for (int i = 0; i < questions.size(); i++) {
            aquantHomePage.setAnswerAquantQA(questions.get(i).get("AnswerType")
                    , questions.get(i).get("Question")
                    , questions.get(i).get("Answer"));
        }

    }

    @When("I verify the FMIEnabled popup displayed with fmi status as lost")
    public void iVerifyTheFMIEnabledPopupDisplayedWithFmiStatusAsLost() {
        base.navigateToPopup();
        Assert.assertTrue("Unable to verify fmI enabled popup", fmiEnabledPopup.isFmiLostMessageDisplayed());
        fmiEnabledPopup.continueToClaim();
        base.waitForPageToLoad();
    }

    @And("I verify the claim status displayed as {string} and the claim message contains {string}")
    public void iVerifyTheClaimStatusDisplayedAsAndTheClaimMessageContains(String claimStatus, String statusMsg) {
        base.hardWait("2000");
        Assert.assertTrue("Unable to verify the Claim status :" + claimStatus, qaPage.isClaimStatusVerified(claimStatus, statusMsg));
    }

    @And("^I enter the Customer Contact QA section with below$")
    public void iEnterTheCustomerContactQASectionWithBelow(DataTable dt) throws InterruptedException {
        List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
        for (int i = 0; i < questions.size(); i++) {
            Thread.sleep(12000);
            qaPage.setAnswer(questions.get(i).get("Answer"), questions.get(i).get("AnswerType"));
            qaPage.clickSubmitAnswerButtonCC();
        }
    }

    @And("I answer a query for Accessory capture and save")
    public void iAnswerAQueryForAccessoryCaptureAndSave() throws InterruptedException {
        qaPage.answerForAccessoryCapture();
    }
}
