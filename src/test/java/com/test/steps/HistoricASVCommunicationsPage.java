package com.test.steps;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoricASVCommunicationsPage {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public HistoricASVCommunicationsPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//div//b[contains(.,\"Historic ASV Communications\")]")
    private WebElement ASVpageHeading;

    @FindBy(xpath = "//div[@id=\"HistoricASVComms\"]/p/b")
    private WebElement SMS;

    @FindBy(xpath = "//div[@id='allSMS']//following::*[name()='b'][1]")
    private WebElement Email;

    @FindBy(xpath = "//div[@id='limitedEmails']/br")
    private WebElement Emailcomms;

    @FindBy(xpath = "//*[text()='Email']//following::span[text()=' View ALL'][last()]")
    private WebElement EmailViewAll;

    @FindBy(xpath = "//div[@id='allEmails']")
    private WebElement EmailViewAllComms;



    public boolean isHistoricASVCommunicationsDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(ASVpageHeading))

            {
                base.highlightElement(ASVpageHeading);
                base.highlightElement(SMS);
                base.highlightElement(Email);
                if (Emailcomms.isDisplayed()) {
                    base.clickElement(EmailViewAll);
                    base.highlightElement(EmailViewAllComms);
                    EmailViewAllComms.isDisplayed();
                }
            }

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
