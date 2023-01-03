package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Srv9487BekoFaultCode {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage makeAClaim;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    // Local Constants for Page validations
    private static final String PLAN_SEARCH_HEADING = "Plan Search";
    private static final String PLAN_STATUS_LIVE = "LIVE";
    private static final String PLAN_STATUS_CANCELLED = "CANCELLED";
    private static final String PLAN_STATUS_LAPSED = "LAPSED";
    private static final String PRODUCT_DETAILS_HEADING = "Plan & Product Details";
    private static final String CONFIRM_PRODUCT_DETAILS_HEADING = "Confirm Product Details";

    private String pathToSelectPlan = "//table[@id=\"IcqPolicyProductsTable\"]//tbody/tr[contains(.,\"${value}\")]/td[7]/input";
    private String pathToSelectedPlanStatus = "//table[@id=\"IcqPolicyProductsTable\"]//tbody/tr[contains(.,\"${value}\")]/td[4]";

    /*
    Manish Kumar Jain-SRV 9487
    To verify the Please Select Model section displayed
    */
    private final String bekoModelCodePath = "//*[@id=\"pncModelSerial\"]//span/input";
    @FindBy(xpath = bekoModelCodePath)
    private WebElement bekoModelCode;

    /*
    Manish Kumar Jain-SRV 9487
    To verify the Please Select Model dropdown displayed and clickable
    */
    private final String bekoModelDropdownButtonPath = "//*[@id=\"pncModelSerial\"]//span/a/span[@class=\"ui-button-icon ui-icon ui-icon-triangle-1-s\"]";
    @FindBy(xpath = bekoModelDropdownButtonPath)
    private WebElement bekoModelDropdownButton;

    /*
    Manish Kumar Jain-SRV 9487
    To verify the Beko Fault Code section displayed
    */
    private final String bekoFaultCodePath = "//div[@id='elecJfLook']//span[@class='ui-combobox']/input";
    @FindBy(xpath = bekoFaultCodePath)
    private WebElement bekoFaultCode;

    /*
    Manish Kumar Jain-SRV 9487
    To verify the Beko Fault Code section displayed
    */
    private final String bekoFaultCodeDropdownPath = "//div[@id='elecJfLook']//span/a[@role=\"button\" and @title=\"Show All Items\"]";
    @FindBy(xpath = bekoFaultCodeDropdownPath)
    private WebElement bekoFaultCodeDropdown;

    @FindBy(xpath="//div[@id='makeClaimBut']//button[@type='button'][contains(text(),'Create Request')]")
    private WebElement createClaimRequestButton;

    String selectClaimTypeXpath = "//*[@id=\"ClaimTypesloadSpan\"]/div[contains(.,\"${value}\")]//img";

    @FindBy (xpath = "//*[@id=\"icqQuestion\"]")
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

    @FindBy(xpath = "//*[@id=\"IcqAnswerText\"]")
    WebElement answerDateField;

    @FindBy(xpath = "//*[@id=\"IcqAnswerTextArea\"]")
    WebElement answerResponseField;

    @FindBy(xpath = "//select[@id=\"IcqAnswerTextDropDown\"]")
    WebElement answerDropdownChildAnswer;

    @FindBy(xpath = "//select[@name=\"IcqGroupQuestionAnswerTypeID\"]")
    WebElement answerDropdownParentAnswer;

    private static final String answerResponseMultiDropdownPath = "//*[@id=\"brdrLnDiv\"][contains(.,\"Answer Response Message\")]/div[@id=\"IcqAnswerResponseInput\"]/select";
    @FindBy(xpath = answerResponseMultiDropdownPath)
    private WebElement multiDropdown;

    private static final String answerResponseMultiMessageUnderstoodPath = "//*[@id=\"IcqDeclarationHolder\"]/div[2]/div[1]/input";
    @FindBy(xpath = answerResponseMultiMessageUnderstoodPath)
    private WebElement multiMsgUnderstood;

    private static String questionPath = "//*[@id=\"icqQuestion\"][contains(.,\"${value}\")]";
    private static String answerRadiobuttonXpath = "//*[@id=\"icqAnswerHolder\"]//*[contains(.,\"${value}\")]//*[@id=\"AT_RadioButton1\" and @name=\"IcqGroupQuestionAnswerTypeID\"]";
    private static String answerDateFieldXpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td[contains(.,\"${value}\")]/a";
    private final String CLAIM_STATUS_MESSAGE_TEXT = "Claim Status Message";

    public Srv9487BekoFaultCode(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, MakeAClaimPage makeAClaim) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.makeAClaim = makeAClaim;
        PageFactory.initElements(driver, this);
    }

    /*
    Name: Manish Kumar Jain
    Date: 9th Aug 2021
    Description: This function will select the Beko Model Code from "Please Select Model" dropdown
    User Stories: SRV 9487
     */
    public void enterConfirmProductDetailsSectionForBekoModelCode() {
        try {
            if(base.waitForElementVisible(bekoModelCode) && base.checkIfELementIsAvailable(bekoModelCode)) {
                base.waitForElementAndReturnJS(bekoModelDropdownButtonPath);
                base.clickWithJsExecutor(bekoModelDropdownButton);
                seleniumHelper.actionToMoveDownOnList(bekoModelDropdownButton, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
    Name: Manish Kumar Jain
    Date: 9th Aug 2021
    Description: This function will select the Beko Fault Code Description from "Fault" dropdown
    User Stories: SRV 9487
     */
    public void enterConfirmProductDetailsSectionForBekoFaultCodeDescription() {
        try {
            if(base.waitForElementVisible(bekoFaultCode) && base.checkIfELementIsAvailable(bekoFaultCode))
            {
                base.waitForElementAndReturnJS(bekoFaultCodeDropdownPath);
                base.clickWithJsExecutor(bekoFaultCodeDropdown);
                seleniumHelper.actionToMoveDownOnList(bekoModelDropdownButton, 0);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }


    /*
    Name: Manish Kumar Jain
    Date: 9th Aug 2021
    Description: This function will select the Beko Fault Code Description from "Fault" dropdown
    User Stories: SRV 9487
     */
    public void clickOnCreateRequestButton()
    {
        try {
            if
            (base.checkIfELementIsAvailable(createClaimRequestButton) & base.isElementAvilable(createClaimRequestButton))
            {
                base.waitForElementVisible(createClaimRequestButton);
                base.clickWithJsExecutor(createClaimRequestButton);
                Thread.sleep(2000);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    /*
    Name: Manish Kumar Jain
    Date: 9th Aug 2021
    Description: This function will check whether Q&A section displayed or not for BEKO Plan.
    User Stories: SRV 9487
     */
    public boolean isQuestionDisplayed(String qa) {
        boolean status = false;
        WebElement question = seleniumHelper.getCustomElementByXpath(questionPath, qa);
        if(question == null ) {
            if (questionSection.getText().contains(qa) | !questionSection.getText().isEmpty() ) {
                status = true;
            }
        } else {
            status = true;
        }
        return status;
    }


    /*
    Name: Manish Kumar Jain
    Date: 9th Aug 2021
    Description: This function will select the Beko Fault Code Description from "Fault" dropdown
    User Stories: SRV 9487
     */
    public boolean hasSubQeustionSectionAsDeclaration(){
        boolean status = false;
        try{
            if(base.getElementFromXpath(qa_SubQa_DeclarationXpath).isDisplayed() &&
                    base.getElementFromXpath(qa_SubQa_DeclarationConfirmXpath).isDisplayed()) {
                status = true;
            }
        }catch (NoSuchElementException e ) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return status;
    }


    /*
    Name: Manish Kumar Jain
    Date: 9th Aug 2021
    Description: This function will set the answer based upon the case and Q&A set by config team for the plan and Scheme.
    User Stories: SRV 9487
     */
    public void setAnswer(String ans, String ansType) {

        switch (ansType) {
            case "RadioButton": {
                WebElement answer = seleniumHelper.getCustomElementByXpath(answerRadiobuttonXpath, ans);
                base.clickWithJsExecutor(answer);
                break;
            }
            case "Date": {
                base.waitTillElementFound(answerDateField);
                base.isClickable(answerDateField);
                base.clickWithJsExecutor(answerDateField);
                answerDateField.click();
                WebElement answer = seleniumHelper.getCustomElementByXpath(answerDateFieldXpath, seleniumHelper.getCurrentDate().substring(0, 2).replaceAll("^0+","").trim());
                base.clickWithJsExecutor(answer);
                break;
            }
            case "ResponseField": {
                base.checkIfELementIsAvailable(answerResponseField);
                base.sendFieldInputData(answerResponseField, ans);
                break;
            }
            case "Dropdown": {
                if (base.checkIfELementIsAvailable(answerDropdownParentAnswer)) {
                    base.selectTextByVisibleText(answerDropdownParentAnswer, ans);
                } else {
                    base.checkIfELementIsAvailable(answerDropdownChildAnswer);
                    base.selectTextByVisibleText(answerDropdownChildAnswer, ans);
                }
                break;
            }
            case "SubDropdown": {
                base.checkIfELementIsAvailable(answerDropdownChildAnswer);
                base.selectTextByVisibleText(answerDropdownChildAnswer, ans);
                break;
            }
            case "multi":
            case "Multi":
            {
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
            case "Declaration": {
                if(hasSubQeustionSectionAsDeclaration()) {
                    WebElement answer = base.getElementFromXpath(qa_SubQa_DeclarationConfirmXpath);
                    base.clickWithJsExecutor(answer);
                }
                break;
            }
        }
    }
}
