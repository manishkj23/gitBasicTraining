package com.test.pages.CCAgent_OLDUI;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class SiteMapPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    @FindBy(xpath = "//*[@id=\"centrex-menu\"]//button[contains(@onclick,\"siteMap\")]")
    WebElement siteMapButton;

    @FindBy(xpath = "//input[@id=\"SearchKey\"]")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"menuContainer\"]/div/span/p[contains(.,\"SMS Messages\")]")
    WebElement smsMessagesWizard;

    @FindBy(xpath = "//*[@id=\"menuContainer\"]/div/span/p[contains(.,\"Email Messages\")]")
    WebElement emailMessagesWizard;

    private static final String useRedEyeLabelXPathSms = "//*[@id=\"smsForm\"]//label[contains(.,\"Use RedEye\")]";
    private static final String useRedEyeLabelXPathEmail = "//label[contains(.,\"Use RedEye\")]";
    @FindBy(xpath = useRedEyeLabelXPathSms)
    WebElement useRedEyeLabelSms;

    @FindBy(xpath = "//table[@id=\"smsResults\"]/tbody/tr")
    List<WebElement> smsResultsSet;

    @FindBy(xpath = "//table[@id=\"emailMessagesResults\"]/tbody/tr/td[2]")
    List<WebElement> emailResultsSet;

    @FindBy(xpath = "//label[contains(.,\"Send To CCM\")]")
    WebElement updatePage;

    @FindBy(xpath = "//*[@id=\"cancel_btn\"]")
    WebElement cancelButton;

    private static String pathToSmsMessagesConfigRule = "//*[@id=\"smsResults\"]//tr[contains(.,\"${value}\")]";
    private static String pathToEmailMessagesConfigRule = "//*[@id=\"emailMessagesResults\"]//tr[contains(.,\"${value}\")]";

    public SiteMapPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isSmsMessagesWizardDisplayed() {
        try {
            base.waitForPageToLoad();
            base.waitTillElementFound(smsMessagesWizard);
            base.highlightElement(smsMessagesWizard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (smsMessagesWizard.isDisplayed()) ? true : false;
    }

    public boolean isEmailMessagesWizardDisplayed() {
        try {
            base.waitForPageToLoad();
            base.waitTillElementFound(emailMessagesWizard);
            base.highlightElement(emailMessagesWizard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (emailMessagesWizard.isDisplayed()) ? true : false;
    }

    public boolean isSmsMessagesPageLoaded() {
        boolean status = false;
        try {
            if (smsResultsSet.size() > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isEmailMessagesPageLoaded() {
        boolean status = false;
        try {
            if (emailResultsSet.size() > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean smsCheckRedEyeNotExist() {
        boolean status = true;
        try {
            Iterator<WebElement> record = smsResultsSet.iterator();
            while (record.hasNext()) {
                WebElement messageRow = record.next();
                if (messageRow != null) {
                    base.highlightElement(messageRow);
                    seleniumHelper.doubleClickElement(messageRow);
                    base.waitTillElementFound(updatePage);
                    base.highlightElement(updatePage);
                    seleniumHelper.captureScreeshot();
                    if (base.getElementByXpathJS(useRedEyeLabelXPathSms)!= null) {
//                        base.highlightElement();
                        status = false;
                        break;
                    }
                    base.clickWithJsExecutor(cancelButton);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    public boolean emailCheckRedEyeNotExist() {
        boolean status = true;
        try {
            Iterator<WebElement> record = emailResultsSet.iterator();
            while (record.hasNext()) {
                WebElement messageRow = record.next();
                if (messageRow != null) {
                    base.highlightElement(messageRow);
                    seleniumHelper.doubleClickElement(messageRow);
                    base.waitTillElementFound(updatePage);
                    base.highlightElement(updatePage);
                    seleniumHelper.captureScreeshot();
                    if (base.getElementByXpathJS(useRedEyeLabelXPathEmail)!= null) {
                        status = false;
                        break;
                    }
                    base.clickWithJsExecutor(cancelButton);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    public boolean isSiteMapPageLoaded() {
        boolean status = false;
        try {
            if (searchBox.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void searchAndClickConfigWizard(String value) {
        try {
            if (value.contains("SMS")) {
                base.sendFieldInputData(searchBox,value);
                base.isElementAvailable(smsMessagesWizard);
                base.clickWithJsExecutor(smsMessagesWizard);
                base.waitForPageToLoad();

            } else if(value.contains("EMAIL")) {
                base.sendFieldInputData(searchBox,value);
                base.isElementAvailable(emailMessagesWizard);
                base.clickWithJsExecutor(emailMessagesWizard);
                base.waitForPageToLoad();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void clickCreateClaim() {
//        try {
//            base.waitForElementVisible(createClaimButton);
//           if(base.checkIfELementIsAvailable(createClaimButton) & base.isClickable(createClaimButton)){
//               base.clickWithJsExecutor(createClaimButton);
//           }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.info("======>>>>> Unable to click Create Claim icon");
//        }
//    }


}