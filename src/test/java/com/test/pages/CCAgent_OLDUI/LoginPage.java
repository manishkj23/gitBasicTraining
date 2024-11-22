package com.test.pages.CCAgent_OLDUI;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;

    public String defaultLoginName = "VEERAV";

    @FindBy(xpath = "//input[@id=\"name\"]")
    private WebElement CCUser;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement CCPassword;

    @FindBy(xpath = "//*[@id=\"displayLoginButton\"]/button")
    private WebElement LoginButton;

    //    @FindBy(xpath = "//div[@id='loginOuter']//button[@id='signInBtn']")
    @FindBy(xpath = "//button[@class='btnStandardLogin']")
    private WebElement SignInButton;



    //    @FindBy(xpath = "//*//input[@id='username']")
    @FindBy(xpath = "//*//input[@id='name']")
    private WebElement SignInCCUser;

    @FindBy(xpath = "//*//input[@id='password']")
    private WebElement SignInCCPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div/h1[contains(text(),'TOTP Token Generator')]")
    private WebElement tokenGeneratorPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[@class='control']/input")
    private WebElement SecretKey;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[@class='control']/input")
    private WebElement tokenPeriod;

    @FindBy(xpath = "//*[@id=\"token\"]")
    private WebElement tokenNumber;

    @FindBy(xpath = "//*[@id=\"idTxtBx_SAOTCC_OTC\"]")
    private WebElement authenticationCode;

    @FindBy(xpath = "//*[@id=\"idSubmit_SAOTCC_Continue\"]")
    private WebElement verifyButton;

    //*[@id="idSubmit_SAOTCC_Continue"]

    private final String TokenPeriodInSeconds = "100";

    public LoginPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(LoginButton);
            if (LoginButton.isDisplayed()) {
                base.highlightElement(LoginButton);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void loginToCCAgent(String user, String password) {
        base.waitForElementVisible(CCUser);
        base.sendFieldInputData(CCUser, user);

        base.waitForElementVisible(CCPassword);
        base.sendFieldInputData(CCPassword, password);
        base.clickElement(LoginButton);

    }

    public boolean isSignInPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(SignInButton);
            if (SignInButton.isDisplayed()) {
                base.highlightElement(SignInButton);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void signInToCCAgent(String user, String password) {
        base.waitForElementVisible(SignInCCUser);
        base.sendFieldInputData(SignInCCUser, user);

        base.waitForElementVisible(SignInCCPassword);
        base.sendFieldInputData(SignInCCPassword, password);
//        base.clickElement(SignInButton);
        base.clickWithJsExecutor(SignInButton);

    }

    public boolean isSigninPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(LoginButton);
            if (LoginButton.isDisplayed()) {
                base.highlightElement(LoginButton);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isTOTPPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(tokenGeneratorPage);
            if (tokenGeneratorPage.isDisplayed()) {
                base.highlightElement(tokenGeneratorPage);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterSecretKey(String totpSecretKey) {
        base.checkIfELementIsAvailable(SecretKey);
        base.clearText(SecretKey);
        base.sendFieldInputData(SecretKey, totpSecretKey);

    }

    public void adjustTheTokenPeriods() {
        base.clearText(tokenPeriod);
        base.sendFieldInputData(tokenPeriod, TokenPeriodInSeconds);
    }

    public boolean fetchAndEnterTOTP() {
        boolean status = false;
        try {
            String token;
            token = tokenNumber.getText();
            base.navigateToLandingPage();
            seleniumHelper.waitForPageLoaded();
            base.sendFieldInputData(authenticationCode, token);
            base.clickWithJsExecutor(verifyButton);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}
