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

    @FindBy(xpath = "//div[@id='loginOuter']//button[@id='signInBtn']")
    private WebElement SignInButton;

    @FindBy(xpath = "//*//input[@id='username']")
    private WebElement SignInCCUser;

    @FindBy(xpath = "//*//input[@id='password']")
    private WebElement SignInCCPassword;



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
        base.clickElement(SignInButton);

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

}