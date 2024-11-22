package com.test.steps;


import com.test.pages.CCAgentUI_NPV.Aquant.AquantHomePage;
import com.test.pages.CCAgentUI_NPV.Aquant.AquantLoginPage;
import com.test.pages.CCAgent_OLDUI.LoginPage;
import com.test.pages.CCAgent_OLDUI.OrbitHomePage;
import com.test.pages.RepairerPortal.LoginPageRepairer;
import com.test.pages.RepairerPortal.RepairerHomePage;
import com.test.pages.RepairerPortal.RepairerJobUpdate;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    private OrbitHomePage homePage;
    private AquantLoginPage aquantLoginPage;
    private AquantHomePage aquantHomePage;


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepDef.class);

    public LoginStepDef(BasePage basePage,
                        SeleniumHelper seleniumHelper,
                        LoginPage loginPage,
                        LoginPageRepairer repairerLogin,
                        RepairerHomePage repairerHomePage,
                        RepairerJobUpdate repairerJobUpdate,
                        OrbitHomePage homePage,
                        AquantLoginPage aquantLoginPage,
                        AquantHomePage aquantHomePage) {
        this.base = basePage;
        this.loginPage = loginPage;
        this.seleniumHelper = seleniumHelper;
        this.repairerLogin = repairerLogin;
        this.repairerHomePage = repairerHomePage;
        this.repairerJobUpdate = repairerJobUpdate;
        this.driver = basePage.getDriver();
        this.homePage = homePage;
        this.aquantLoginPage = aquantLoginPage;
        this.aquantHomePage = aquantHomePage;
    }


    @Given("^I navigate to D&G CC Agent Portal$")
    public void iNavigateToDGCCAgentPortal() {
        base.clearCookies();
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Login Not Successful", loginPage.isLoginPageDisplayed());

    }

    @Given("^I navigate to D&G CC Agent Portal New UI$")
    public void iNavigateToDGCCAgentPortalNewUI() {
        base.clearCookies();
        base.navigateToPage(base.prop.getProperty("BASEURL_CCV"));
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Login Not Successful", loginPage.isLoginPageDisplayed());

    }

    @Given("^I re-navigate to D&G CC Agent Portal$")
    public void iReNavigateToDGCCAgentPortal() {
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Home Page Not Loaded", homePage.isHomePageLoaded());

    }

    @Given("^I navigate to D&G Repairer Portal$")
    public void iNavigateToDGRepAgentPortal() {
        base.clearCookies();
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
//        Assert.assertTrue("Login Not Successful", loginPage.isLoginPageDisplayed());
        Assert.assertTrue("Login Not Successful", loginPage.isSignInPageDisplayed());


    }

    @Given("^Im on the D&G Repairer Portal$")
    public void iNavigateToDGRepAgentPortalLogin() {
        base.clearCookies();
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
//        Assert.assertTrue("Login Not Successful", loginPage.isLoginPageDisplayed());
        Assert.assertTrue("Login Not Successful", loginPage.isSignInPageDisplayed());
        try {
            iEnterRepairerUsernameAndPasswordAndClickLogin();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @When("^I enter repairer username and password and click Login$")
    public void iEnterRepairerUsernameAndPasswordAndClickLogin() throws InterruptedException {
//        repairerLogin.loginToRPPortal(base.prop.getProperty("RP_User"), base.prop.getProperty("RP_Password"));
        repairerLogin.SigninToRPPortal(base.prop.getProperty("RP_User"), base.prop.getProperty("RP_Password"));
        seleniumHelper.waitForPageLoaded();
        seleniumHelper.captureScreeshot();
        Thread.sleep(2000);
        Assert.assertTrue("Repairer Home Page Failed to Launch", repairerHomePage.isRepairerHomePageDisplayed());
    }

    @When("^I enter repairer username and password and click Login for Sedgewicks$")
    public void iEnterRepairerUsernameAndPasswordAndClickLoginSedgewicks() throws InterruptedException {
        repairerLogin.loginToRPPortal(base.prop.getProperty("SW_User"), base.prop.getProperty("SW_Password"));
        seleniumHelper.waitForPageLoaded();
        seleniumHelper.captureScreeshot();
        Thread.sleep(2000);
        Assert.assertTrue("Repairer Home Page Failed to Launch", repairerHomePage.isRepairerHomePageDisplayed());
    }
    @When("^I enter repairer username and password and click Login for Hoover$")
    public void iEnterRepairerUsernameAndPasswordAndClickLoginForHoover() throws InterruptedException {
        repairerLogin.loginToRPPortal(base.prop.getProperty("Hoov_User"), base.prop.getProperty("Hoov_Password"));
        seleniumHelper.waitForPageLoaded();
        seleniumHelper.captureScreeshot();
        Thread.sleep(2000);
        Assert.assertTrue("Repairer Home Page Failed to Launch", repairerHomePage.isRepairerHomePageDisplayed());
    }

    @When("^I enter repairer username and password and click Login for Hotpoint$")
    public void iEnterRepairerUsernameAndPasswordAndClickLoginForHotpoint() throws InterruptedException {
        repairerLogin.loginToRPPortal(base.prop.getProperty("Hot_User"), base.prop.getProperty("Hot_Password"));
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

    @When("^I enter username and password and click Login for New Plan View$")
    public void iEnterUsernameAndPasswordAndClickLoginNPV() {
        loginPage.loginToCCAgent(base.prop.getProperty("CC_UserNPV"), base.prop.getProperty("CC_PasswordNPV"));
        seleniumHelper.waitForPageLoaded();

    }


    @Given("^I login to CC AgentPortal$")
    public void iLoginToCCAgentPortal() {
        iNavigateToDGCCAgentPortal();
        iEnterUsernameAndPasswordAndClickLogin();

    }

    @When("^I enter repairer username and password and click Login for FTB$")
    public void iEnterRepairerUsernameAndPasswordAndClickLoginFTB() throws InterruptedException {
        repairerLogin.loginToRPPortal(base.prop.getProperty("RP_User"), base.prop.getProperty("RP_Password"));
        seleniumHelper.waitForPageLoaded();
        seleniumHelper.captureScreeshot();
        Thread.sleep(2000);
        Assert.assertTrue("Repairer Home Page Failed to Launch", repairerHomePage.isRepairerHomePageDisplayed());
    }

    @When("I navigate to AquantTab and Login")
    public void iNavigateToAquantTabAndLogin() {
        base.switchToNextTab();
        aquantLoginPage.loginToAquant(base.prop.getProperty("AQ_User"),base.prop.getProperty("AQ_Password"));
        Assert.assertTrue("Unable to login to Aquant",aquantHomePage.isAquantHomePageDisplayed());
    }

    @Given("^I navigate to new D&G CC Agent Portal$")
    public void iNavigateToNewDGCCAgentPortal() {
        base.clearCookies();
        base.navigateToLandingPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Login Not Successful", loginPage.isSignInPageDisplayed());

    }

    @When("^I enter username and password and click SignIn for New Plan View$")
    public void iEnterUsernameAndPasswordAndClickSignInNPV() throws InterruptedException {
        Thread.sleep(10000);
        loginPage.signInToCCAgent(base.prop.getProperty("CC_UserNPV"), base.prop.getProperty("CC_PasswordNPV"));
        Thread.sleep(10000);
        seleniumHelper.waitForPageLoaded();

    }

    @Then("I navigate to TOTP Generator page and enter secret Key")
    public void iNavigateToTOTPGeneratorPageAndEnterSecretKey() throws InterruptedException {
        base.clearCookies();
        base.navigateToTOTPTokenGeneratorPage();
        base.waitForPageToLoad();
        base.waitToLoadElement();
        Assert.assertTrue("Login Not Successful", loginPage.isTOTPPageDisplayed());
        Thread.sleep(10000);
//        loginPage.signInToCCAgent(base.prop.getProperty("CC_UserNPV"), base.prop.getProperty("CC_PasswordNPV"));
        loginPage.enterSecretKey(base.prop.getProperty("TOTPSecretKey"));
        Thread.sleep(3000);
        seleniumHelper.waitForPageLoaded();
    }


    @Then("I fetch the TOTP and enter token on NPV authentication page and click verify")
    public void iFetchTheTOTPAndEnterTokenOnNPVAuthenticationPageAndClickVerify() {
        loginPage.adjustTheTokenPeriods();
        Assert.assertTrue("Unable to enter the TOTP", loginPage.fetchAndEnterTOTP());
    }
}