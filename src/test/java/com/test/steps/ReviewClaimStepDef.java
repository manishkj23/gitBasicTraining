package com.test.steps;


import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.CCAgent_OLDUI.ReviewClaimPage;
import com.test.pages.ClaimAnalysisPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReviewClaimStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private ReviewClaimPage reviewClaim;
    private ClaimAnalysisPage claimAnalysis;
    private OrbitHomePage homePage;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClaimStepDef.class);

    public ReviewClaimStepDef(BasePage basePage, SeleniumHelper seleniumHelper, ReviewClaimPage reviewClaim, ClaimAnalysisPage claimAnalysis, OrbitHomePage homePage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.reviewClaim = reviewClaim;
        this.claimAnalysis = claimAnalysis;
        this.homePage = homePage;
    }

    @Then("^I verify the Appointment booked successfully from the Review claim section$")
    public void iVerifyTheAppointmentBookedSuccessfullyFromTheReviewClaimSection() {
        Assert.assertTrue("Review Claim Page not loaded",reviewClaim.isReviewClaimJobStatusDisplayed());
    }

    @Given("^I'm on the Review Claim Page on CC Agent Portal$")
    public void iMOnTheReviewClaimPageOnCCAgentPortal() {
        reviewClaim.checkAndCloseAnyPopupDisplayed();

    }

    @Then("^I verify the CustomerCommunications messages are generated$")
    public void iVerifyTheCustomerCommunicationsMessagesAreGenerated() {
        Assert.assertTrue("Customer Communications Email section not loaded",reviewClaim.isCustomerCommunicationsEmailSectionDisplayed());
        Assert.assertTrue("Customer Communications SMS section not loaded",reviewClaim.isCustomerCommunicationsSmsSectionDisplayed());
    }

    @Then("^I process the Claim to WrittenOff with the status as \"([^\"]*)\"$")
    public void iProcessTheClaimToWrittenOffWithTheStatusAs(String writtenOffStatus) throws Throwable {
        reviewClaim.processWrittenOff(writtenOffStatus);
        Assert.assertTrue(writtenOffStatus+" - Not Verified",reviewClaim.isReviewClaimJobStatusDisplayed(writtenOffStatus));
    }

    @Then("^I verify and confirm that einvoice cost matches Claim Analysis section$")
    public void iVerifyAndConfirmThatEinvoiceCostMatchesClaimAnalysisSection() {
        base.waitForPageToLoad();
        homePage.clickReviewClaimTab();
        String serviceCost = seleniumHelper.removeWhiteSpaces(reviewClaim.getServiceCostValue());
        homePage.clickClaimAnalysisTab();
        String claimTotalCost =  seleniumHelper.removeWhiteSpaces(claimAnalysis.getTotalCostValue());
        Assert.assertTrue("Einvoice Amount not Verified",serviceCost.equals(claimTotalCost));
        homePage.clickReviewClaimTab();
    }

    @Then("^I verify the Status Changes are logged in ORB when Status Changes in RP$")
    public void iVerifyTheStatusChangesAreLoggedInORBWhenStatusChangesInRP() {
//        homePage.clickReviewClaimTab();
        Assert.assertTrue("Status Changes not Verified",reviewClaim.isStatusChangesUpdated());
    }

    @Then("^I verify the new status's are logged in ORB under Request Authorisation, when changes are made to RP$")
    public void iVerifyTheNewStatusSAreLoggedInORBUnderRequestAuthorisationWhenChangesAreMadeToRP() {
        Assert.assertTrue("RA Status Changes not verified", reviewClaim.isRAHistoryStatusChangesUpdated());
    }

    @Then("^I Confirm that system notes display correctly and user can add a note in ORB$")
    public void iConfirmThatSystemNotesDisplayCorrectlyAndUserCanAddANoteInORB() {
        Assert.assertTrue("System Noted added successfully",reviewClaim.addAndVerifyNewSystemNotesAdded());
    }

    @Then("^I Confirm that fault code is updated in ORB when updated in RP$")
    public void iConfirmThatFaultCodeIsUpdatedInORBWhenUpdatedInRP() {
        Assert.assertTrue("Fault section updated successfully",reviewClaim.isFaultSectionUpdated());
    }

    @Then("^I Confirm that workflow status is updated in ORB when updated in RP$")
    public void iConfirmThatWorkflowStatusIsUpdatedInORBWhenUpdatedInRP() {
        Assert.assertTrue("Workflow Status Updated ",reviewClaim.isWokflowStatusUpdated());
    }

    @Then("^I Confirm that Job Completion status is updated in ORB when updated in RP$")
    public void iConfirmThatJobCompletionStatusIsUpdatedInORBWhenUpdatedInRP() {
        Assert.assertTrue("Job Completed Status Updated",reviewClaim.isJobCompletionStatusInWorkflowUpdated());
    }


}