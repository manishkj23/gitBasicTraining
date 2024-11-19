package com.test.pages.CCAgent_OLDUI;

import com.test.pages.CCAgentUI_NPV.CustomerContact.BankAccountDetailsCapturePage;
import com.test.pages.CCAgentUI_NPV.ReciperoQATree.QApopups.FMIEnabledPopup;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class QandAProcessPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private PlanDetails planDetails;
    private FMIEnabledPopup fmiEnabledPopup;
    private BankAccountDetailsCapturePage bankAccountDetailsCapturePage;
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

    private final String answerResponseFieldXpath = "//*[@id=\"IcqAnswerTextArea\"]";
    @FindBy(xpath = answerResponseFieldXpath)
    private WebElement answerResponseField;

    private final String answerTextArea2Xpath = "//*[@id=\"IcqAnswerText\"]";
    @FindBy(xpath = answerTextArea2Xpath)
    private WebElement answerTextArea2;

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

    //Accessories :
    @FindBy(xpath = "//select[@id=\"accessorylist\"]/../button")
    private WebElement accessoryDropdown;

    @FindBy(xpath = "//ul[@class=\"ui-multiselect-checkboxes ui-helper-reset\"]//input")
    private List<WebElement> options;
    private final String accessoryOptionSelectiveXpath = "//ul[@class=\"ui-multiselect-checkboxes ui-helper-reset\"]//label[contains(.,\"${value}\")]/input";
    @FindBy(xpath = "//a[contains(.,\"Save\")]")
    private WebElement saveAccessory;

//    @FindBy(xpath = "//div[@id='icqTabs']//div[contains(text(),'CLAIM ON HOLD')]")
//    private WebElement claimOnHoldStatus;

    private static String claimOnHoldStatusXpath = "//div[@id='icqTabs']//div[contains(text(),\"${value}\")]";
    private static String claimOnHoldMessageXPath = "//div[@id='icqTabs']//div[contains(text(),\"${value}\")]";

    // Commented : @Veera : the Xpath has been now changed on the DOM : SRV-10616
//    private static String questionPath = "//*[@id=\"icqQuestion\"][contains(.,\"${value}\")]";
    private static String questionPath = "//form[@id=\"IcqMainForm\"]//div/div[contains(.,\"${value}\")]";
    private static String questionPathSub = "//form[@id=\"IcqMainForm\"]//div/*[contains(.,\"${value}\")]";
    //    private static String answerRadiobuttonXpath = "//*[@id=\"icqAnswerHolder\"]//*[contains(.,\"${value}\")]//*[@name=\"IcqGroupQuestionAnswerTypeID\"]";
    private static String answerRadiobuttonXpath = "//span[@onclick=\"spanRadioSelect(this)\"][contains(text(),\"${value}\")]/../../input";

    // End of change
    private static String answerDateFieldXpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td[contains(.,\"${value}\")]/a";
    private final String CLAIM_STATUS_MESSAGE_TEXT = "Claim Status Message";
    private final String answerTextArea = "//*[@id=\"IcqAnswerTextArea\"]";

    //Commented: @Manish : Xpath added for the WorldPay Credit Card Q&A section via Customer Contact
    private static final String worldpay_ccWorldPayQAPath = "//form[@id='IcqMainForm']//div[@id='icqHelpAndAdvice'][contains(.,'WorldPay')]";
    @FindBy(xpath = worldpay_ccWorldPayQAPath)
    WebElement worldpay_ccWorldPayQA;

    private static final String worldpay_ccPaymentAmountTextPath = "//form[@id='IcqMainForm']//div//b[contains(text(),'Value to Collect')]";
    @FindBy(xpath = worldpay_ccPaymentAmountTextPath)
    WebElement worldpay_ccPaymentAmountText;

    private static final String worldpay_ccPaymentAmountTextboxPath = "//div[@id='icqTabs']//div[@id='icqTabs-99']//form[@id='IcqMainForm']//div[@id=\"WorldPaymentPaymentcheckDiv\"]//p//input[@id=\"paymentAmount\"]";
    @FindBy(xpath = worldpay_ccPaymentAmountTextboxPath)
    WebElement worldpay_ccPaymentAmountTextbox;

    private static final String worldpay_ccWorldPayQANextButtonPath = "//div[@id='IcqNextButton']//button[@id='IcqAnswerButton'][contains(text(),'Next')]";
    @FindBy(xpath = worldpay_ccWorldPayQANextButtonPath)
    WebElement worldpay_ccWorldPayQANextButton;

    private static final String worldpay_TakePaymentButtonPath = "//div[@id='cboxLoadedContent']//button[@onclick='getWorlPayBillingAddressData()'][contains(.,'Take Payment')]";
    @FindBy(xpath = worldpay_TakePaymentButtonPath)
    WebElement worldpay_TakePaymentButton;

    private static final String worldpay_billingDetailsYesEmailRadioButtonPath = "//div[@id='cboxLoadedContent']//div[@id='ManualRefDiv']//input[@id='emailYes']";
    @FindBy(xpath = worldpay_billingDetailsYesEmailRadioButtonPath)
    WebElement worldpay_billingDetailsYesEmailRadioButton;

    private static final String worldpay_billingDetailsYesAddressRadioButtonPath = "//div[@id='cboxLoadedContent']//div[@id='ManualRefDiv']//input[@id='addressYes'][1]";
    @FindBy(xpath = worldpay_billingDetailsYesAddressRadioButtonPath)
    WebElement worldpay_billingDetailsYesAddressRadioButton;

    private static final String worldpay_billingDetailsAddressLine2TextBoxPath = "//div[@id='addressFields']//input[@id='addressLine2'][1]";
    @FindBy(xpath = worldpay_billingDetailsAddressLine2TextBoxPath)
    WebElement worldpay_billingDetailsAddressLine2TextBox;

    private static final String worldpay_billingDetailsAddressLine3TextBoxPath = "//div[@id='addressFields']//input[@id='addressLine3'][1]";
    @FindBy(xpath = worldpay_billingDetailsAddressLine3TextBoxPath)
    WebElement worldpay_billingDetailsAddressLine3TextBox;

    private static final String worldpay_billingDetailsConfirmButtonPath = "//div[@id='cboxLoadedContent']//div[@id='ManualRefDiv']//button[contains(.,'Confirm')]";
    @FindBy(xpath = worldpay_billingDetailsConfirmButtonPath)
    WebElement worldpay_billingDetailsConfirmButton;


    public QandAProcessPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, PlanDetails planDetails, FMIEnabledPopup fmiEnabledPopup
            ,BankAccountDetailsCapturePage bankAccountDetailsCapturePage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
        this.planDetails = planDetails;
        this.fmiEnabledPopup = fmiEnabledPopup;
        this.bankAccountDetailsCapturePage = bankAccountDetailsCapturePage;
    }

    public boolean isClaimNoDisplayed() {
        base.waitTillElementFound(claimNo);
        if (!claimNo.isDisplayed() || claimNo == null) {
            base.hardWait("2000");
            base.waitTillElementFound(claimNo);
        }
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
        base.hardWait("10000");
        WebElement question = seleniumHelper.getCustomElementByXpath(questionPath, qa);
//        WebElement question = base.getElementByReplaceXpathJS(questionPath, qa);
        if (question == null) {
            if (questionSection.getText().contains(qa) | !questionSection.getText().isEmpty()) {
                status = true;
//            } else if (seleniumHelper.getCustomElementByXpath(questionPathSub, qa) != null &&
//                    seleniumHelper.getCustomElementByXpath(questionPathSub, qa).getText().contains(qa)) {
//                status = true;
            } else if (base.getElementByReplaceXpathJS(questionPathSub, qa) != null &&
                    base.getElementByReplaceXpathJS(questionPathSub, qa).getText().contains(qa)) {
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
//                base.clickWithJsExecutor(answer);
                base.clickElement(answer);
                break;
            }
            case "RESPONSEFIELD": {
                if (base.checkIfELementIsAvailable(answerResponseField)) {
                    base.sendFieldInputData(answerResponseField, ans);
                } else if (base.getElementFromXpath(answerTextArea2Xpath) != null) {
                    base.sendFieldInputData(answerTextArea2, ans);
                }
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

            case "ACCESSORYDROPDOWN": {
                if (base.getElementFromXpath(answerTextArea2Xpath) != null) {
                    base.sendFieldInputData(answerTextArea2, "Test");
                }
                if (base.checkIfELementIsAvailable(accessoryDropdown)) {
                    base.clickElement(accessoryDropdown);
                    List<String> optionsList = Stream.of(ans.split(","))
                            .map(String::trim)
                            .collect(toList());
                    for (String option : optionsList) {
                        try {
                            WebElement selectedOption = seleniumHelper.getCustomElementByXpath(accessoryOptionSelectiveXpath, option);
                            if (selectedOption != null) {
                                base.clickElement(selectedOption);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
//                    base.clickElement(saveAccessory);
                    base.clickWithJsExecutor(saveAccessory);
                }
                break;
            }
            case "TRIAGE":
            case "NA":{
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
            case "MOCK": {
                switch (ans.toUpperCase()) {
                    case "THEFTREFNO":
                    case "THEFT": {
                        base.checkIfELementIsAvailable(answerUserCrimeRefField);
                        base.sendFieldInputData(answerUserCrimeRefField, planDetails.getCurrentClaimNumber());
                        break;
                    }
                    default: {
                        base.checkIfELementIsAvailable(answerResponseField);
                        base.sendFieldInputData(answerResponseField, ans);
                        break;
                    }
                }
                break;
            }
            case "BANKDETAILS": {
                String[] bankDetails = ans.split("\\,");
                if (bankAccountDetailsCapturePage.isBankDetailsCapturePageDisplayed()) {
                    bankAccountDetailsCapturePage.enterBankDetailsProvided(bankDetails[0].trim(),bankDetails[1].trim());
                }

                break;
            }

        }
    }

    public void clickSubmitAnswerButton() {
        base.clickWithJsExecutor(submitButtonQA);
    }
    public void clickSubmitAnswerButtonCC() {
        try {
            base.clickElement(submitButtonQA);
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public boolean isAnswerTextAreaAvailableExtended() {
        boolean status = false;
        try {
            if (base.getElementByXpathJS(answerTextArea) != null) {
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

    public boolean isFMIEnabledPopupDisplayed(String fmiValue) {
        boolean status = false;
        if (fmiValue.equalsIgnoreCase("lost")) {
            if (fmiEnabledPopup.isFmiLostMessageDisplayed()) {
                fmiEnabledPopup.continueToClaim();
                status = true;
            } else {
                LOGGER.info("Unable to verify the FMIP Status alert");
            }
        } else {
            // FMI other checks
            LOGGER.info("Implement other FMIP Status alerts required - TEST AUTOMATION");
        }
        return status;
    }

    public boolean isClaimStatusVerified(String claimStatus, String claimStatusMsg) {
        boolean status = false;
        if (base.checkIfELementIsAvailable(seleniumHelper.getCustomElementByXpath(claimOnHoldStatusXpath, claimStatus)) &&
                (seleniumHelper.getCustomElementByXpath(claimOnHoldMessageXPath, claimStatusMsg).isDisplayed())) {
            base.highlightElement(seleniumHelper.getCustomElementByXpath(claimOnHoldStatusXpath, claimStatus));
            status = true;
        } else {
            LOGGER.info("Unable to verify the FMIP Status alert");
        }
        return status;
    }

    public boolean hasWorldPayQuestionSectionDisplayed() {
        boolean status = false;
        try {
            if (driver.findElement(By.xpath(worldpay_ccWorldPayQAPath)).isDisplayed() &&
                    driver.findElement(By.xpath(worldpay_ccPaymentAmountTextPath)).isDisplayed()) {
                base.highlightElement(worldpay_ccWorldPayQA);
                base.highlightElement(worldpay_ccPaymentAmountText);
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isWorldPayQANextButtonEnabled()
    {
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(worldpay_ccWorldPayQANextButton) && worldpay_ccWorldPayQANextButton.isEnabled()){
                status = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void verifyPaymentAmountAndClickOnNextButton() throws InterruptedException {
        try {
            String valueToCollect = driver.findElement(By.xpath(worldpay_ccPaymentAmountTextboxPath)).getAttribute("value");
            LOGGER.info("outstanding DD Amount is: " + valueToCollect);
            double str1 = Double.parseDouble(valueToCollect);
            int paymentAmountValue = (int) str1;
            LOGGER.info("outstanding DD Amount is after parsing: " + paymentAmountValue);
            if (paymentAmountValue > 0) {
                LOGGER.info("Outstanding DD Amount is greater than zero");
                base.highlightElement(worldpay_ccWorldPayQANextButton);
                base.clickWithJsExecutor(worldpay_ccWorldPayQANextButton);
                Thread.sleep(3000);
            } else {
                LOGGER.info("Outstanding DD Amount is less than or equal to zero");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}