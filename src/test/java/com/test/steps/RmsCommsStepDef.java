package com.test.steps;

import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.SiteMapPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RmsCommsStepDef {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private SiteMapPage siteMap;
    private OrbitHomePage orbitHomePage;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClaimStepDef.class);

    public RmsCommsStepDef(BasePage basePage, SeleniumHelper seleniumHelper, SiteMapPage siteMap, OrbitHomePage orbitHomePage) {
        this.base = basePage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.siteMap = siteMap;
        this.orbitHomePage = orbitHomePage;
    }

    @When("^I click on SMS Message Config in SiteMap$")
    public void iClickOnSMSMessageConfiginSiteMap() {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isSiteMapPageLoaded());
        siteMap.searchAndClickConfigWizard("SMS");


    }

    @Then("^I verify the SMS Message Config Page displayed$")
    public void iVerifyTheSMSMessageConfigPageDisplayed() {
        Assert.assertTrue("SMS Configuration Page not Loaded",siteMap.isSmsMessagesPageLoaded());
    }

    @Then("^I verify if Use Red Eye config is removed$")
    public void iVerifyIfUseRedEyeConfigIsRemoved() {
        Assert.assertTrue("SMS Messages - Use RedEye Config Still Exist",siteMap.smsCheckRedEyeNotExist());
    }

    @Then("^I verify the Email Message Config Page displayed$")
    public void iVerifyTheEmailMessageConfigPageDisplayed() {
        Assert.assertTrue("Email Configuration Page not Loaded",siteMap.isEmailMessagesPageLoaded());
    }

    @Then("^I verify if Use Red Eye config is removed for Email$")
    public void iVerifyIfUseRedEyeConfigIsRemovedForEmail() {
        Assert.assertTrue("Email Messages - Use RedEye Config Still Exist",siteMap.emailCheckRedEyeNotExist());
    }

    @When("^I click on Email Message Config in SiteMap$")
    public void iClickOnEmailMessageConfigInSiteMap() {
        orbitHomePage.clickSiteMap();
        Assert.assertTrue("SiteMap Page Loaded",siteMap.isSiteMapPageLoaded());
        siteMap.searchAndClickConfigWizard("EMAIL");

    }
}
