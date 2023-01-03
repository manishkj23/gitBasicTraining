package com.test.steps;


import com.test.pages.LoginPage;
import com.test.pages.RepairerPortal.LoginPageRepairer;
import com.test.pages.RepairerPortal.RepairerHomePage;
import com.test.pages.RepairerPortal.RepairerJobUpdate;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginStepDef {

    private BasePage base;
    private LoginPage loginPage;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private LoginPageRepairer repairerLogin;
    private RepairerHomePage repairerHomePage;
    private RepairerJobUpdate repairerJobUpdate;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepDef.class);

    public LoginStepDef(BasePage basePage,
                        SeleniumHelper seleniumHelper,
                        LoginPage loginPage,
                        LoginPageRepairer repairerLogin,
                        RepairerHomePage repairerHomePage,
                        RepairerJobUpdate repairerJobUpdate) {
        this.base = basePage;
        this.loginPage = loginPage;
        this.seleniumHelper = seleniumHelper;
        this.repairerLogin = repairerLogin;
        this.repairerHomePage = repairerHomePage;
        this.repairerJobUpdate = repairerJobUpdate;
        this.driver = basePage.getDriver();
    }

    @Given("^I navigate to D&G CC Agent Portal$")
    public void iNavigateToDGCCAgentPortal() {
        base.clearCookies();
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Login Not Successful",loginPage.isLoginPageDisplayed());

    }
    @Given("^I navigate to D&G Repairer Portal$")
    public void iNavigateToDGRepAgentPortal() {
        base.clearCookies();
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Login Not Successful",loginPage.isLoginPageDisplayed());


    }

    @When("^I enter repairer username and password and click Login$")
    public void iEnterRepairerUsernameAndPasswordAndClickLogin() throws InterruptedException {
        repairerLogin.loginToRPPortal(base.prop.getProperty("RP_User"), base.prop.getProperty("RP_Password"));
        seleniumHelper.waitForPageLoaded();
        seleniumHelper.captureScreeshot();
        Thread.sleep(2000);
        Assert.assertTrue("Repairer Home Page Failed to Launch", repairerHomePage.isRepairerHomePageDisplayed());
    }
    @When("^I enter username and password and click Login$")
    public void iEnterUsernameAndPasswordAndClickLogin() {
        loginPage.loginToCCAgent(base.prop.getProperty("CC_User"), base.prop.getProperty("CC_Password"));
        seleniumHelper.waitForPageLoaded();

    }

    @When("^I enter repairer username and password and click Login for Hotpoint$")
    public void iEnterRepairerUsernameAndPasswordAndClickLoginForHotpoint() throws InterruptedException {
        repairerLogin.loginToRPPortal(base.prop.getProperty("Hot_User"), base.prop.getProperty("Hot_Password"));
        seleniumHelper.waitForPageLoaded();
        seleniumHelper.captureScreeshot();
        Thread.sleep(2000);
        Assert.assertTrue("Repairer Home Page Failed to Launch", repairerHomePage.isRepairerHomePageDisplayed());
    }

    @When("^I enter username and password and click Login for New Plan View$")
    public void iEnterUsernameAndPasswordAndClickLoginNPV() {
        loginPage.loginToCCAgent(base.prop.getProperty("CC_UserNPV"), base.prop.getProperty("CC_PasswordNPV"));
        seleniumHelper.waitForPageLoaded();

    }


}
