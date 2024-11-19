package com.test.pages.CCAgentUI_NPV.Aquant;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AquantLoginPage {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;


    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement userName;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwordAquant;

    @FindBy(xpath = "//input[@id=\"Login\"]")
    private WebElement loginButton;

    public AquantLoginPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isAquantLoginPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(loginButton);
            if (loginButton.isDisplayed()) {
                base.highlightElement(loginButton);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void loginToAquant(String user, String password){
        base.waitForElementVisible(userName);
        base.sendFieldInputData(userName,user);

        base.waitForElementVisible(passwordAquant);
        base.sendFieldInputData(passwordAquant,password);
        base.clickElement(loginButton);

    }

}