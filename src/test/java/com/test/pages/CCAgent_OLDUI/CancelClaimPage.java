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

public class CancelClaimPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName() );

    @FindBy(xpath = "//*[@id=\"FunctionsMenuDiv\"]//legend[contains(.,\"Functions Menu\")]")
    WebElement functionsMenuHeading;

    @FindBy(xpath = "//*[@id=\"FunctionsMenuDiv\"]//label[contains(.,\"Cancel Claim\")]")
    WebElement cancelClaimLabel;

    @FindBy(xpath = "//*[@id=\"CancelJobForm\"]/fieldset/p[2]/span/input")
    WebElement cancellationReason;

    @FindBy(xpath = "//*[@id=\"CancelReason\"]")
    WebElement cancellationComment;

    @FindBy(xpath = "//*[@id=\"update_save_btn\"]")
    WebElement cancelJobButton;

    @FindBy(xpath = "//*[@id=\"topBreadcrumb\"]/div/p[contains(.,\"CANCELLED JOB\")]")
    WebElement checkJobCancelled;

    @FindBy(xpath = "//*[@id=\"menuIconHolder\"]/a[contains(.,\"Menu\")]/div")
    WebElement menuButton;


    public CancelClaimPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public void clickMenuOption(){
        base.waitTillElementFound(menuButton);
        base.clickElement(menuButton);
    }
    public boolean isFunctionMenuPageDisplayed(){
        base.waitTillElementFound(functionsMenuHeading);
        return (functionsMenuHeading.isDisplayed()) ? true : false;
    }


    public void clickCancelClaimAction(){
        base.waitTillElementFound(cancelClaimLabel);
        base.clickElement(cancelClaimLabel);
    }

    public void confirmClaimCancellation(String reason, String comment){
        base.waitTillElementFound(cancellationReason);
        base.sendFieldInputData(cancellationReason,reason);
        base.waitTillElementFound(cancellationComment);
        base.sendFieldInputData(cancellationComment,comment);
        base.waitToLoadElement();
        base.highlightElement(cancelJobButton);
        base.clickWithJsExecutor(cancelJobButton);
        base.waitForPageToLoad();
    }

    public boolean isJobCancelledSuccefully(){
        base.waitForPageToLoad();
        base.waitTillElementFound(checkJobCancelled);
        base.highlightElement(checkJobCancelled);
        return (checkJobCancelled.isDisplayed())?true:false;
    }
}
