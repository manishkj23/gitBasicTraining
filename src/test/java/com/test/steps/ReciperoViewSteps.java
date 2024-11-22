package com.test.steps;

import com.test.pages.CCAgent_OLDUI.ClaimAnalysisPage;
import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.CCAgent_OLDUI.ReciperoView.ReciperoViewPage;
import com.test.pages.CCAgent_OLDUI.ReviewClaimPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReciperoViewSteps {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private ReviewClaimPage reviewClaim;
    private ClaimAnalysisPage claimAnalysis;
    private OrbitHomePage homePage;
    private ReciperoViewPage reciperoViewPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClaimStepDef.class);

    public ReciperoViewSteps(BasePage basePage, SeleniumHelper seleniumHelper, ReviewClaimPage reviewClaim,
                             ClaimAnalysisPage claimAnalysis, OrbitHomePage homePage, ReciperoViewPage reciperoViewPage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.reviewClaim = reviewClaim;
        this.claimAnalysis = claimAnalysis;
        this.homePage = homePage;
        this.reciperoViewPage = reciperoViewPage;
    }


    @Then("^I verify the IMEI is Blocked$")
    public void iVerifyTheBlockedStatusOfTheIMEIIs() {
        Assert.assertTrue("Unable to verify the status of the IMEI as Blocked", reciperoViewPage.isIMEIBlocked());
    }

    @And("^I verify the blocked record Exist on recipero view$")
    public void iVerifyTheBlockedRecordExistOnReciperoView() {
        Assert.assertTrue("Unable to verify the Blocked record history ", reciperoViewPage.hasBlockedHistoryRecordsExist());
    }

    @Then("^I verify the Loss Record History exists on recipero view$")
    public void iVerifyTheLossRecordHistoryExistsOnReciperoView() {
        Assert.assertTrue("Unable to verify the Loss record history ", reciperoViewPage.hasLossRecordsHistoryExist());
    }

    @Then("^I verify the model \"([^\"]*)\" matched on the recipero view page$")
    public void iVerifyTheModelMatchedOnTheReciperoViewPage(String model) {
        Assert.assertTrue("Unable to verify the Model on Recipero View Page", reciperoViewPage.getModelDetails().toLowerCase().contains(model.toLowerCase()));
    }
}
