package com.test.steps;


import com.test.pages.CCAgent_OLDUI.ServiceOptionsPage;
import com.test.pages.ExcessPayment.PaymentDuePopup;
import com.test.pages.QandAProcessPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
    private PaymentDuePopup paymentDuePopup;
    private static final Logger LOGGER = LoggerFactory.getLogger(QandAStepDef.class);

    public QandAStepDef(BasePage basePage, SeleniumHelper seleniumHelper, QandAProcessPage qaPage, ServiceOptionsPage serviceOptionsPage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.qaPage = qaPage;
        this.serviceOptionsPage = serviceOptionsPage;
    }


    @And("^I enter the NPV QA section with below$")
    public void iEnterTheQASectionWithBelow1(DataTable dt) {
        List<Map<String, String>> questions = dt.asMaps(String.class, String.class);
        for(int i=0; i<questions.size(); i++) {
            Assert.assertTrue("Question not loaded:",qaPage.isQuestionDisplayed(questions.get(i).get("Question")));
            qaPage.setAnswer(questions.get(i).get("Answer"),questions.get(i).get("AnswerType"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(questions.get(i).get("SubQuestion") != null) {
                if (questions.get(i).get("SubQuestion").isEmpty()) {
                    qaPage.clickSubmitAnswerButton();
                }
            } else {
                qaPage.clickSubmitAnswerButton();
            }
        }
//        Assert.assertTrue("Question Tree Not Completed",qaPage.isQuestionTreeCompleted());
    }

    @Then("^I verify claim is in Accepted status$")
    public void iVerifyClaimIsInAcceptedStatus() {
        Assert.assertTrue("Claim is not in Accepted Status",qaPage.isClaimInAcceptedStatus());
    }

    @Then("^I verify claim is in Rejected status$")
    public void iVerifyClaimIsInRejectedStatus() {
        Assert.assertTrue("Claim is not in Accepted Status",qaPage.isClaimInRejectedStatus());
    }

    @Then("^I click service option and verify service optionsPage loaded$")
    public void iClickServiceOptionAndVerifyServiceOptionsPageLoaded() {
        qaPage.selectServiceOptionUrl();
        Assert.assertTrue("Service Options Page not displayed",serviceOptionsPage.isServiceOptionsPageLoaded());

    }

    @Then("^I verify the Claim Created$")
    public void iVerifyTheClaimCreated() {
        Assert.assertTrue("Unable to verify Claim Number",qaPage.isClaimNoDisplayed());
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

    @And("^I enter the Customer Contact QA section with below$")
    public void iEnterTheCustomerContactQASectionWithBelow(DataTable dt) {
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

    @Then("^I verify Q&A section display for WorldPay Credit Card Payment$")
    public void i_verify_qa_section_display_for_worldpay_credit_card_payment() throws Throwable {
        Thread.sleep(3000);
        qaPage.hasWorldPayQuestionSectionDisplayed();
    }

    @And("^I verify Value to Collect textbox having amount greater than zero and click on Next Button in WorldPay QA$")
    public void i_verify_value_to_collect_textbox_having_amount_greater_than_zero() throws Throwable {
        Thread.sleep(3000);
        qaPage.verifyPaymentAmountAndClickOnNextButton();
    }

    @Then("^I click on Next button in WorldPay QA section$")
    public void i_click_on_next_button_in_worldpay_qa_section() throws Throwable {

    }

    @Then("^I click on Take Payment and enter Billing details and Confirm in Payment Due pop up$")
    public void i_click_on_take_payment_and_enter_billing_details_and_confirm_in_payment_due_pop_up() throws Throwable {
        Thread.sleep(3000);
        qaPage.enterPaymentDetailsAndConfirm();
    }

    @And("^I enter the card details in the WorldPay Card Payment page$")
    public void i_enter_the_card_details_in_the_worldpay_card_payment_page() throws Throwable {
        Thread.sleep(3000);
        qaPage.outstandingDDPaymentProcess();
    }


    @And("^I verify the WorkQ task Alert confirmation pop up displayed$")
    public void i_verify_the_workq_task_alert_confirmation_pop_up_displayed() throws Throwable {
        Thread.sleep(3000);
        qaPage.clickOnWorkQConfirmPopUp();
    }

    @Then("^I click on the WorkQ Task tab in the Plan History section$")
    public void i_click_on_the_workq_task_tab_in_the_plan_history_section() throws Throwable {
        Thread.sleep(3000);
        qaPage.clickOnWorkQTaskTabPlanHistory();
    }

    @And("^I verify the WorkQ task created via customer contact present in MyWorkQ Task and mark it completed$")
    public void i_verify_the_workq_task_created_via_customer_contact_present_in_myworkq_task_and_mark_it_completed() throws Throwable {
        qaPage.verifyTaskReferenceWithMyWorkQTaskAndCompleted();
        Thread.sleep(20000);


    }


}
