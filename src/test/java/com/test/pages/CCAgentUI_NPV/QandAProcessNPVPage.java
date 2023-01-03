package com.test.pages.CCAgentUI_NPV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QandAProcessNPVPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private PlanDetails planDetails;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    // Local Constants for Page validations
    private static final String CLAIM_NO_HEADING = "Claim No";

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//span[contains(.,\"Claim No\")]")
    private WebElement claimNoHeading;

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//div[contains(.,\"Claim No\")]/span[2]")
    private WebElement claimNo;

    //    @FindBy(xpath = "//*[@id=\"IcqAnswerButton\"][contains(@onclick,\"SubmitAnswerData\")]")
    @FindBy(xpath = "//div[@id=\"IcqNextButton\"]/button")
    private WebElement submitButtonQA;

    //    @FindBy(xpath = "//*[@id=\"IcqAnswerText\"]")
    @FindBy(xpath = "//*[@class=\"icqTextInput hasDatepicker\"]")
    private WebElement answerDateField;

    @FindBy(xpath = "//*[@id=\"IcqAnswerTextArea\"]")
    private WebElement answerResponseField;

    @FindBy(xpath = "//*[@id=\"UserClaimRef\"]")
    private WebElement answerUserCrimeRefField;

    @FindBy(xpath = "//*[@id=\"IcqB54R\"]/div/div[contains(.,\"CLAIM ACCEPTED\")]")
    WebElement claimAccepted;

    //    @FindBy(xpath = "//*[@id=\"icqTabs-2\"]//div[contains(.,\"CLAIM REJECTED\")]")
    @FindBy(xpath = "//td/div[contains(.,\"CLAIM REJECTED\")]")
    private WebElement claimRejected;

    @FindBy(xpath = "//*[@id=\"IcqB54R\"]//a[contains(.,\"Select Service Option\")]")
    private WebElement selectServiceOptionUrl;

    @FindBy(xpath = "//select[@name=\"IcqGroupQuestionAnswerTypeID\"]")
//    @FindBy(xpath = "//*[@id=\"IcqAnswerTextDropDown\"]")
    private WebElement answerDropdownParentAnswer;

    @FindBy(xpath = "//*[@id=\"IcqAnswerResponseInput\"]/label")
    private WebElement childQuestionLabel;

    @FindBy(xpath = "//select[@id=\"IcqAnswerTextDropDown\"]")
    private WebElement answerDropdownChildAnswer;

    @FindBy(xpath = "//div[@id=\"JuBarStatusName\"][@title=\"CLAIM CREATED\"]")
    private WebElement claimCreatedStatusName;

    @FindBy(xpath = "//div[@id=\"IcqB54R\"]/div/div[contains(.,\"Claim Status Message\")]")
    private WebElement claimStatusMessageText;

    private static final String answerResponseMultiDropdownPath = "//*[@id=\"brdrLnDiv\"][contains(.,\"Answer Response Message\")]/div[@id=\"IcqAnswerResponseInput\"]/select";
    @FindBy(xpath = answerResponseMultiDropdownPath)
    private WebElement multiDropdown;

    private static final String answerResponseMultiMessageUnderstoodPath = "//*[@id=\"IcqDeclarationHolder\"]/div[2]/div[1]/input";
    @FindBy(xpath = answerResponseMultiMessageUnderstoodPath)
    private WebElement multiMsgUnderstood;

    @FindBy(xpath = "//*[@id=\"icqQuestion\"]")
    private WebElement questionSection;

    private static final String qa_SubQa_DeclarationConfirmXpath = "//*[@id=\"IcqDeclarationHolder\"][//span[@id=\"IcqIcqDeclarationConfirmalConfirm\"]]//input[@value=\"Confirm\"]";
    @FindBy(xpath = qa_SubQa_DeclarationConfirmXpath)
    private WebElement qa_SubQa_DeclarationConfirmButton;

    private static final String qa_SubQa_DeclarationCancelXpath = "//*[@id=\"IcqDeclarationHolder\"][//span[@id=\"IcqIcqDeclarationConfirmalConfirm\"]]//input[@value=\"Confirm\"]";
    @FindBy(xpath = qa_SubQa_DeclarationCancelXpath)
    private WebElement qa_SubQa_DeclarationCancelButton;

    private static final String qa_SubQa_DeclarationXpath = "//*[@id=\"IcqDeclarationHolder\"][//span[@id=\"IcqIcqDeclarationConfirmalConfirm\"]]";
    @FindBy(xpath = qa_SubQa_DeclarationXpath)
    private WebElement qa_SubQa_DeclarationQuestion;

    // Commented : @Veera : the Xpath has been now changed on the DOM : SRV-10616
//    private static String questionPath = "//*[@id=\"icqQuestion\"][contains(.,\"${value}\")]";
    private static String questionPath = "//form[@id=\"IcqMainForm\"]//div/div[@id=\"icqQuestion\"][contains(.,\"${value}\")]";
    private static String questionPathSub = "//form[@id=\"IcqMainForm\"]//div/*[contains(.,\"${value}\")]";
    //    private static String answerRadiobuttonXpath = "//*[@id=\"icqAnswerHolder\"]//*[contains(.,\"${value}\")]//*[@name=\"IcqGroupQuestionAnswerTypeID\"]";
    private static String answerRadiobuttonXpath = "//span[@onclick=\"spanRadioSelect(this)\"][contains(text(),\"${value}\")]/../../input";

    // End of change
    private static String answerDateFieldXpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td[contains(.,\"${value}\")]/a";
    private final String CLAIM_STATUS_MESSAGE_TEXT = "Claim Status Message";
    private final String answerTextArea = "//*[@id=\"IcqAnswerTextArea\"]";

    public QandAProcessNPVPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, PlanDetails planDetails) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
        this.planDetails = planDetails;
    }

    public boolean isClaimNoDisplayed() {
        base.waitTillElementFound(claimNo);
        return (claimNo.isDisplayed()) ? true : false;
    }

    public boolean isClaimCreated() {
        base.checkIfELementIsAvailable(claimCreatedStatusName);
        return (claimCreatedStatusName.isDisplayed()) ? true : false;
    }

    public boolean isQuestionTreeCompleted() {
        base.checkIfELementIsAvailable(claimStatusMessageText);
        return (claimStatusMessageText.getText() == CLAIM_STATUS_MESSAGE_TEXT) ? true : false;
    }

    public boolean isQandAPageLoaded() {
        base.waitTillElementFound(claimNoHeading);
        return (claimNoHeading.getText().contains(CLAIM_NO_HEADING)) ? true : false;
    }

    public boolean isQuestionDisplayed(String qa) {
        boolean status = false;
        WebElement question = seleniumHelper.getCustomElementByXpath(questionPath, qa);
        if (question == null) {
            if (questionSection.getText().contains(qa) | !questionSection.getText().isEmpty()) {
                status = true;
            } else if(seleniumHelper.getCustomElementByXpath(questionPathSub, qa) != null &&
                    seleniumHelper.getCustomElementByXpath(questionPathSub, qa).getText().contains(qa)){
                status = true;
            }
        } else {
            status = true;
        }
        return status;
//        return (question.isDisplayed()) ? true : false;
    }

    public boolean hasSubQeustionSectionAsDeclaration() {
        boolean status = false;
        try {
            if (base.getElementFromXpath(qa_SubQa_DeclarationXpath).isDisplayed() &&
                    base.getElementFromXpath(qa_SubQa_DeclarationConfirmXpath).isDisplayed()) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void setAnswer(String ans, String ansType) {

        switch (ansType.toUpperCase()) {
            case "RADIOBUTTON": {
                WebElement answer = seleniumHelper.getCustomElementByXpath(answerRadiobuttonXpath, ans);
                base.clickWithJsExecutor(answer);
                break;
            }
            case "DATE": {
                base.waitTillElementFound(answerDateField);
                base.isClickable(answerDateField);
//                base.clickWithJsExecutor(answerDateField);
                answerDateField.click();
                WebElement answer = seleniumHelper.getCustomElementByXpath(answerDateFieldXpath, seleniumHelper.getCurrentDate().substring(0, 2).replaceAll("^0+", "").trim());
                base.clickWithJsExecutor(answer);
                break;
            }
            case "RESPONSEFIELD": {
                base.checkIfELementIsAvailable(answerResponseField);
                base.sendFieldInputData(answerResponseField, ans);
                break;
            }
            case "DROPDOWN": {
                if (base.checkIfELementIsAvailable(answerDropdownParentAnswer)) {
                    base.selectTextByVisibleText(answerDropdownParentAnswer, ans);
                } else {
                    base.checkIfELementIsAvailable(answerDropdownChildAnswer);
                    base.selectTextByVisibleText(answerDropdownChildAnswer, ans);
                }
                break;
            }
            case "SUBDROPDOWN": {
                base.checkIfELementIsAvailable(answerDropdownChildAnswer);
                base.selectTextByVisibleText(answerDropdownChildAnswer, ans);
                break;
            }
            case "MULTI": {
                WebElement answer = seleniumHelper.getCustomElementByXpath(answerRadiobuttonXpath, ans);
                base.clickWithJsExecutor(answer);
                WebElement multiDropdownElement = base.getElementFromXpath(answerResponseMultiDropdownPath);
                if (base.checkIfELementIsAvailable(multiDropdownElement)) {
                    base.selectTextByVisibleText(multiDropdownElement, "UK (excl NI & IOM) - 0800 111 999");
                    if (multiMsgUnderstood != null && base.isClickable(multiMsgUnderstood))
                        base.clickWithJsExecutor(multiMsgUnderstood);
                }
                break;
            }
            case "DECLARATION": {
                if (hasSubQeustionSectionAsDeclaration()) {
                    WebElement answer = base.getElementFromXpath(qa_SubQa_DeclarationConfirmXpath);
                    base.clickWithJsExecutor(answer);
                }

                break;
            }
            case "CALLRECIPERO":
            case "RECIPERO":
            case "MOBILE":
            case "STOLEN":
            case "MOCK":{
                switch (ans.toUpperCase()){
                    case "THEFTREFNO":
                    case "THEFT":{
                        base.checkIfELementIsAvailable(answerUserCrimeRefField);
                        base.sendFieldInputData(answerUserCrimeRefField,planDetails.getCurrentClaimNumber());
                        break;
                    }
                    default :{
                        base.checkIfELementIsAvailable(answerResponseField);
                        base.sendFieldInputData(answerResponseField, ans);
                        break;
                    }
                }
                break;
            }

        }
    }

    public void clickSubmitAnswerButton() {
        base.waitTillElementFound(submitButtonQA);
        base.clickWithJsExecutor(submitButtonQA);
    }

    public boolean isClaimInAcceptedStatus() {
        base.waitTillElementFound(claimAccepted);
        base.highlightElement(claimAccepted);
        return (claimAccepted.isDisplayed()) ? true : false;
    }

    public boolean isClaimInRejectedStatus() {
        base.waitTillElementFound(claimRejected);
        base.highlightElement(claimRejected);
        return (claimRejected.isDisplayed()) ? true : false;
    }

    public void selectServiceOptionUrl() {
        base.waitTillElementFound(selectServiceOptionUrl);
        base.clickWithJsExecutor(selectServiceOptionUrl);
        base.waitForPageToLoad();
    }

    public boolean isAnswerTextAreaAvailable() {
        boolean status = false;
        try {
            if (base.checkElementIsAvailableByXpath(answerTextArea)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterAnswerTextArea(String value) {
        WebElement el = null;
        try {
            el = base.getElementFromXpath(answerTextArea);
            if (el != null && isAnswerTextAreaAvailable()) {
                base.sendFieldInputData(el, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
