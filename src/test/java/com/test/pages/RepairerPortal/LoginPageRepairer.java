package com.test.pages.RepairerPortal;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPageRepairer {

    @FindBy(xpath = "//input[@id=\"name\"]")
    private WebElement RPUser;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement RPPassword;

    @FindBy(xpath = "//*[@id=\"displayLoginButton\"]/button")
    private WebElement LoginButton;

    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName() );

    public LoginPageRepairer(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginPageDisplayed() {
        boolean status = false;
        try {
            if (LoginButton.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void loginToRPPortal(String user, String password){
        base.waitForElementVisible(RPUser);
        RPUser.sendKeys(user);

        base.waitForElementVisible(RPPassword);
        RPPassword.sendKeys(password);

        try {
            Thread.sleep(3000);
            LoginButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}