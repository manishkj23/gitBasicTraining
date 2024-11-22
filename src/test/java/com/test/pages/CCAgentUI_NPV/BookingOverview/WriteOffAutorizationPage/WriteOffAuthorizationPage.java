package com.test.pages.CCAgentUI_NPV.BookingOverview.WriteOffAutorizationPage;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteOffAuthorizationPage {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;
    private UpdateColor updateColorPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public WriteOffAuthorizationPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, UpdateColor updateColor) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.updateColorPage = updateColor;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id=\"ui2_right_header\"][contains(.,\"Write Off Authorization\")]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@title=\"Live job\"][contains(.,\"Live job\")]/../..//div[@class=\"PspGreenCircle\"]")
    private WebElement isLiveJob;

    @FindBy(xpath = "//form[@id=\"OverrideWriteoffAns\"]/input[@type=\"radio\"][@value=\"Yes\"][@name=\"CustomerReplacement\"]")
    private WebElement customerReplacementRadioBtn;

    @FindBy(xpath = "//form[@id=\"OverrideWriteoffAns\"]/input[@type=\"radio\"][@value=\"Yes\"][@name=\"RepairHistory\"]")
    private WebElement repairHistoryRadioBtn;

    @FindBy(xpath = "//form[@id=\"OverrideWriteoffAns\"]/input[@type=\"radio\"][@value=\"Yes\"][@name=\"CustomerCaused\"]")
    private WebElement customerCausedRadioBtn;


    @FindBy(xpath = "//form[@id=\"OverrideWriteoffAns\"]/input[@type=\"radio\"][@value=\"Yes\"][@name=\"CustomerModelNo\"]")
    private WebElement isModelInGenioRadioBtn;

    @FindBy(xpath = "//select[@id=\"CustomerConstruction\"]/../span/Input")
    private WebElement constructionInput;

    @FindBy(xpath = "//img[@onclick=\"ColourChangeForm();\"]")
    private WebElement updateColor;

    @FindBy(xpath = "//*[@id=\"raJobsForm\"]/span[2]/input")
    private WebElement writeOffStatus;

    @FindBy(xpath = "//textarea[@id=\"RANotes\"]")
    private WebElement raNotes;

    @FindBy(xpath = "//button[@id=\"PlanWriteoff\"]")
    private WebElement planWOBtn;

    @FindBy(xpath = "//span[@id=\"juNewRaStatus\"]")
    private WebElement newRAStatusOnPopup;

    @FindBy(xpath = "//a[contains(@onclick,\"juraStatusUpdateApiCalls\")]")
    private WebElement applyNewRA_ContinueBtn;

    @FindBy(xpath = "//div[@id=\"modP\"][contains(.,\"The plan has been successfully written off\")]")
    private WebElement planWOSuccessMsg;

    @FindBy(xpath = "//div[@role=\"dialog\"]/div[@id=\"modP\"]/..//button[contains(.,\"OK\")]")
    private WebElement planWOSuccessOkBtn;

    @FindBy(xpath = "//div[@title='Essential/ Non Essential']")
    private WebElement essNonEssQnA;

    @FindBy(xpath = "//a[contains(@onclick,'EssentialNonEss')]")
    private WebElement essNonEssLink;

    @FindBy(xpath = "//select[@id='EssentialNonEss']")
    private WebElement essNonEssDD;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement essNonEssSaveBtn;


    public boolean isWriteOffAuthorizationPanelDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(pageTitle)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void updateWriteOffData(String construction, String raStatus) {
        base.clickElement(customerReplacementRadioBtn);
        base.clickElement(repairHistoryRadioBtn);
        base.clickElement(customerCausedRadioBtn);
        base.clickElement(isModelInGenioRadioBtn);
        base.sendFieldInputData(constructionInput, construction);
        if(essNonEssQnA.getAttribute("class").equals("PspRedCircle"))
        {
            base.clickElement(essNonEssLink);
            base.selectTextByVisibleText(essNonEssDD, "Essential");
            base.clickWithJsExecutor(essNonEssSaveBtn);
        }
        base.hardWait("3000");
        base.sendFieldInputData(writeOffStatus, raStatus);
        base.sendFieldInputData(raNotes, raStatus);
        base.isClickable(updateColor);
        base.clickElement(updateColor);
        if (updateColorPage.isUpdateColorPopupScreenAppeared()) {
            updateColorPage.updateColour();
        }
        base.isClickable(planWOBtn);
        base.clickElement(planWOBtn);
    }

    public boolean isNewRAStatusMsgPopupDisplayed(String outcome) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(newRAStatusOnPopup) && newRAStatusOnPopup.getText().toUpperCase().contains(outcome.toUpperCase())) {
                base.highlightElement(newRAStatusOnPopup);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmNewRAStatus() {
        base.clickElement(applyNewRA_ContinueBtn);
    }

    public boolean isWriteOffSuccessMsgPopupDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(planWOSuccessMsg)) {
                base.highlightElement(planWOSuccessMsg);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmWriteOffSuccessMsg() {
        isWriteOffSuccessMsgPopupDisplayed();
        base.clickElement(planWOSuccessOkBtn);

    }
}
