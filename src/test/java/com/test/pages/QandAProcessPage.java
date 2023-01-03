package com.test.pages;

import com.test.pages.ExcessPayment.CardPaymentPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class QandAProcessPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private CardPaymentPage cardPaymentPage;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    // Local Constants for Page validations
    private static final String CLAIM_NO_HEADING = "Claim No";

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//span[contains(.,\"Claim No\")]")
    WebElement claimNoHeading;

    @FindBy(xpath = "//*[@id=\"jbTpDet\"]//div[contains(.,\"Claim No\")]/span[2]")
    WebElement claimNo;

    @FindBy(xpath = "//*[@id=\"IcqAnswerButton\"][contains(@onclick,\"SubmitAnswerData\")]")
    WebElement submitButtonQA;

    @FindBy(xpath = "//*[@id=\"IcqAnswerText\"]")
    WebElement answerDateField;

    @FindBy(xpath = "//*[@id=\"IcqAnswerTextArea\"]")
    WebElement answerResponseField;

    @FindBy(xpath = "//*[@id=\"IcqB54R\"]/div/div[contains(.,\"CLAIM ACCEPTED\")]")
    WebElement claimAccepted;

    @FindBy(xpath = "//*[@id=\"icqTabs-2\"]//div[contains(.,\"CLAIM REJECTED\")]")
    WebElement claimRejected;

    @FindBy(xpath = "//*[@id=\"IcqB54R\"]//a[contains(.,\"Select Service Option\")]")
    WebElement selectServiceOptionUrl;

    @FindBy(xpath = "//select[@name=\"IcqGroupQuestionAnswerTypeID\"]")
//    @FindBy(xpath = "//*[@id=\"IcqAnswerTextDropDown\"]")
    WebElement answerDropdownParentAnswer;

    @FindBy(xpath = "//*[@id=\"IcqAnswerResponseInput\"]/label")
    WebElement childQuestionLabel;

    @FindBy(xpath = "//select[@id=\"IcqAnswerTextDropDown\"]")
    WebElement answerDropdownChildAnswer;

    @FindBy(xpath = "//div[@id=\"JuBarStatusName\"][@title=\"CLAIM CREATED\"]")
    WebElement claimCreatedStatusName;

    @FindBy(xpath = "//div[@id=\"IcqB54R\"]/div/div[contains(.,\"Claim Status Message\")]")
    WebElement claimStatusMessageText;

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

    private static final String worldpay_ccWorldPayQAPath = "//form[@id='IcqMainForm']//div[@id='icqHelpAndAdvice'][contains(.,'WorldPay')]";
    @FindBy(xpath = worldpay_ccWorldPayQAPath)
    WebElement worldpay_ccWorldPayQA;

    private static final String worldpay_ccPaymentAmountTextPath = "//form[@id='IcqMainForm']//div//b[contains(text(),'cost of milk, bread and butter pack')]";
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

    private final String paymentFramePath = "//iframe[@title=\"Payment Pages\"]";
    @FindBy(xpath = paymentFramePath)
    WebElement paymentFrame;

    private final String workQ_alertConfirmPopUpPath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'Confirm')]";
    @FindBy(xpath = workQ_alertConfirmPopUpPath)
    WebElement workQ_alertConfirmPopUp;

    private final String workQ_requestTextConfirmPopUpPath = "//div[@id='modP'][contains(.,'Request')]";
    @FindBy(xpath = workQ_requestTextConfirmPopUpPath)
    WebElement workQ_requestTextConfirmPopUp;

    private final String workQ_workQTaskTabPlanHistoryPath = "//li[@class='nav-item']//button[@id='PlanHistory_Tabs_Tasks'][contains(.,'WorkQ Tasks')]";
    @FindBy(xpath = workQ_workQTaskTabPlanHistoryPath)
    WebElement workQ_workQTaskTabPlanHistory;

    public final String workQtask_taskReferenceValuePath = "//div[@id='PlanHistory_Tabs_Content']/div[@id='PlanHistory_Tasks']/table[@class='table']/tbody/tr[1]/td[1]/span[1]/b[1]";
    @FindBy(xpath = workQtask_taskReferenceValuePath)
    WebElement workQtask_taskReferenceValue;

    public final String myWorkQtask_myWorkQTaskLinkPath = "//div[@id='headerBackGroundColor']//div[@id='centrex-menu']//div[@id='menu']//button[contains(.,'WorkQ')]/span[1]";
    @FindBy(xpath = myWorkQtask_myWorkQTaskLinkPath)
    WebElement myWorkQtask_myWorkQTaskLink;

    public final String myWorkQtask_myWorkQTaskAllToggleButtonPath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@class='workq-tasks-header']/div[@class='toggle-container']//div[@id='button-1']/input[@id='taskAssigned']";
    @FindBy(xpath = myWorkQtask_myWorkQTaskAllToggleButtonPath)
    WebElement myWorkQtask_myWorkQTaskAllToggleButton;

    public final String myWorkQtask_myWorkQTaskTablePath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@id='WorkQ_MyTasks_Content']";
    @FindBy(xpath = myWorkQtask_myWorkQTaskTablePath)
    WebElement myWorkQtask_myWorkQTaskTable;

    public final String myWorkQtask_taskReferenceValueInTablePath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@id='WorkQ_MyTasks_Content']//div[contains(.,'Task')]/span[contains(.,'OT')]/b";
    @FindBy(xpath = myWorkQtask_taskReferenceValueInTablePath)
    WebElement myWorkQtask_taskReferenceValueInTable;

    public final String myWorkQtask_workQtaskMarkCompletedButtonPath = "//div[@class='modal-content']//div[@class='modal-footer']//button[contains(text(),'Mark Completed')]";
    @FindBy(xpath = myWorkQtask_workQtaskMarkCompletedButtonPath)
    WebElement myWorkQtask_workQtaskMarkCompletedButton;

    public final String myWorkQtask_workQtaskConfirmButtonPopUpPath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Confirm')]";
    @FindBy(xpath = myWorkQtask_workQtaskConfirmButtonPopUpPath)
    WebElement myWorkQtask_workQtaskConfirmButtonPopUp;

    public final String myWorkQtask_workQtaskCompletedTextInPopUpPath = "//span[@class='ui-dialog-title'][contains(.,'Completed')]";
    @FindBy(xpath = myWorkQtask_workQtaskCompletedTextInPopUpPath)
    WebElement myWorkQtask_workQtaskCompletedTextInPopUp;

    public final String myWorkQtask_workQtaskCloseButtonPopUpPath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'Close')]";
    @FindBy(xpath = myWorkQtask_workQtaskCloseButtonPopUpPath)
    WebElement myWorkQtask_workQtaskCloseButtonPopUp;


    public final String myWorkQtask_myWorkQTaskCompletedToggleButtonPath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@class='workq-tasks-header']/div[@class='toggle-container']//div[@id='button-1']/input[@id='taskStatus']";
    @FindBy(xpath = myWorkQtask_myWorkQTaskCompletedToggleButtonPath)
    WebElement myWorkQtask_myWorkQTaskCompletedToggleButton;









    private static String questionPath_old = "//*[@id=\"icqQuestion\"][contains(.,\"${value}\")]";
    private static String questionPath = "//form[@id=\"IcqMainForm\"]//div//div[@id='questionPanel']/div[contains(.,\"${value}\")]";
    private static String questionPathSub = "//form[@id=\"IcqMainForm\"]//div/*[contains(.,\"${value}\")]";
    private static String answerRadiobuttonXpath = "//*[@id=\"icqAnswerHolder\"]//*[contains(.,\"${value}\")]//*[@name=\"IcqGroupQuestionAnswerTypeID\"][@label=\"${value}\"]";
    private static String answerDateFieldXpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td[contains(.,\"${value}\")]/a";
    private final String CLAIM_STATUS_MESSAGE_TEXT = "Claim Status Message";
    private final String answerTextArea = "//*[@id=\"IcqAnswerTextArea\"]";

    public QandAProcessPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils,
                            CardPaymentPage cardPaymentPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.cardPaymentPage = cardPaymentPage;
        PageFactory.initElements(driver, this);
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
            } else if (seleniumHelper.getCustomElementByXpath(questionPathSub, qa) != null &&
                    seleniumHelper.getCustomElementByXpath(questionPathSub, qa).getText().contains(qa)) {
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
                WebElement answer = seleniumHelper.getCustomElementByXpath(answerDateFieldXpath, seleniumHelper.getCurrentDate().substring(0, 2).replaceAll("^0+", "").trim());
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
            case "Multi": {
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
                if (hasSubQeustionSectionAsDeclaration()) {
                    WebElement answer = base.getElementFromXpath(qa_SubQa_DeclarationConfirmXpath);
                    base.clickWithJsExecutor(answer);
                }

                break;
            }
            case "PaymentField": {
                if (hasWorldPayQuestionSectionDisplayed()) {
                    WebElement paymentAmountValue = base.getElementFromXpath(worldpay_ccPaymentAmountTextboxPath);
                    String paymentAmount = paymentAmountValue.getText();
                    int paymentValue = Integer.parseInt(paymentAmount);
                    if (paymentValue != 0) {
                        LOGGER.info("Outstanding DD Amount is greater than zero");
                        base.highlightElement(worldpay_ccWorldPayQANextButton);
                        base.clickWithJsExecutor(worldpay_ccWorldPayQANextButton);
                    } else {
                        driver.findElement(By.xpath(worldpay_ccPaymentAmountTextboxPath)).clear();
                        driver.findElement(By.xpath(worldpay_ccPaymentAmountTextboxPath)).sendKeys("1.00");
                        base.highlightElement(worldpay_ccWorldPayQANextButton);
                        base.clickWithJsExecutor(worldpay_ccWorldPayQANextButton);
                    }

                }
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

    public void enterPaymentDetailsAndConfirm() throws InterruptedException {
        base.highlightElement(worldpay_TakePaymentButton);
        base.clickWithJsExecutor(worldpay_TakePaymentButton);
        Thread.sleep(3000);
        base.highlightElement(worldpay_billingDetailsYesEmailRadioButton);
        base.clickWithJsExecutor(worldpay_billingDetailsYesEmailRadioButton);
        Thread.sleep(2000);
        base.highlightElement(worldpay_billingDetailsYesAddressRadioButton);
        base.clickWithJsExecutor(worldpay_billingDetailsYesAddressRadioButton);
        Thread.sleep(3000);
        base.highlightElement(worldpay_billingDetailsAddressLine2TextBox);
        String addr2TextRetrieved = driver.findElement(By.name("addressLine2")).getAttribute("value");
        LOGGER.info("Address line 2 is : " + addr2TextRetrieved);
        Thread.sleep(4000);
        base.highlightElement(worldpay_billingDetailsAddressLine3TextBox);
        driver.findElement(By.xpath(worldpay_billingDetailsAddressLine3TextBoxPath)).sendKeys(addr2TextRetrieved);
        String addr3TextRetrieved = driver.findElement(By.name("addressLine3")).getAttribute("value");
        LOGGER.info("Address line 3 is : " + addr3TextRetrieved);
        Thread.sleep(2000);
        base.clickWithJsExecutor(worldpay_billingDetailsConfirmButton);
        Thread.sleep(3000);
    }

    public void outstandingDDPaymentProcess() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(paymentFrame);
        if (cardPaymentPage.isPopUpDisplayed()) {
            cardPaymentPage.processPayment();
            base.hardWait("5000");

        } else {
            LOGGER.info("Card Payment Page is not Displayed");
        }
        driver.switchTo().defaultContent();
    }

    public void clickOnWorkQConfirmPopUp() {
        if (base.waitForElementVisible(workQ_requestTextConfirmPopUp) && base.checkIfELementIsAvailable(workQ_requestTextConfirmPopUp)) {
            base.highlightElement(workQ_alertConfirmPopUp);
            base.clickWithJsExecutor(workQ_alertConfirmPopUp);
        } else {
            base.waitForPageToLoad();
            base.highlightElement(workQ_alertConfirmPopUp);
            base.clickWithJsExecutor(workQ_alertConfirmPopUp);
        }

    }

    public void clickOnWorkQTaskTabPlanHistory() {
        if (base.waitForElementVisible(workQ_workQTaskTabPlanHistory)) {
            base.highlightElement(workQ_workQTaskTabPlanHistory);
            base.clickWithJsExecutor(workQ_workQTaskTabPlanHistory);
        } else {
            base.waitForPageToLoad();
            base.highlightElement(workQ_workQTaskTabPlanHistory);
            base.clickWithJsExecutor(workQ_workQTaskTabPlanHistory);
        }

    }


    public void verifyTaskReferenceWithMyWorkQTaskAndCompleted() throws InterruptedException {
        String taskrReference, workQTaskValue, completedWorkQTaskValue;
        Thread.sleep(4000);
        base.highlightElement(workQtask_taskReferenceValue);
        taskrReference = driver.findElement(By.xpath(workQtask_taskReferenceValuePath)).getText();
        LOGGER.info("task reference value is: " + taskrReference);
        Thread.sleep(3000);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskLink);
        Thread.sleep(3000);
        base.highlightElement(myWorkQtask_myWorkQTaskAllToggleButton);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskAllToggleButton);
        Thread.sleep(15000);

        if (base.waitForElementVisible(myWorkQtask_myWorkQTaskTable)) {
            List<WebElement> workData = driver.findElements(By.xpath(myWorkQtask_taskReferenceValueInTablePath));
            int noOfTaskPresent = workData.size();
            LOGGER.info("No. of WorkQ task present: " + noOfTaskPresent);
            for (WebElement ele : workData) {
                workQTaskValue = ele.getText();
                LOGGER.info("task value: " + workQTaskValue);
                if (workQTaskValue.contains(taskrReference)) {
                    LOGGER.info("Task Reference value is : " + workQTaskValue);
                    ele.click();
                    Thread.sleep(3000);
                    base.waitForElementVisible(myWorkQtask_workQtaskMarkCompletedButton);
                    base.clickWithJsExecutor(myWorkQtask_workQtaskMarkCompletedButton);
                    base.clickWithJsExecutor(myWorkQtask_workQtaskConfirmButtonPopUp);
                    Thread.sleep(3000);
                    if (base.waitForElementVisible(myWorkQtask_workQtaskCompletedTextInPopUp)) {
                        String taskCompletedValue = driver.findElement(By.xpath(myWorkQtask_workQtaskCompletedTextInPopUpPath)).getText();
                        if (taskCompletedValue.contains(taskrReference)) {
                            LOGGER.info("WorkQ task" + taskCompletedValue + "successfully marked as completed");
                        }
                        base.clickWithJsExecutor(myWorkQtask_workQtaskCloseButtonPopUp);
                    }
                }
                Thread.sleep(5000);
                base.highlightElement(myWorkQtask_myWorkQTaskCompletedToggleButton);
                base.clickWithJsExecutor(myWorkQtask_myWorkQTaskCompletedToggleButton);
                Thread.sleep(15000);
                if (base.waitForElementVisible(myWorkQtask_myWorkQTaskTable)) {
                    List<WebElement> completedTaskData = driver.findElements(By.xpath(myWorkQtask_taskReferenceValueInTablePath));
                    int noOfCompletedTaskPresent = completedTaskData.size();
                    LOGGER.info("No. of Completed WorkQ task present: " + noOfCompletedTaskPresent);
                    for (WebElement completedTaskElement : completedTaskData) {
                        completedWorkQTaskValue = completedTaskElement.getText();
                        LOGGER.info("task value: " + completedWorkQTaskValue);
                        if (completedWorkQTaskValue.contains(taskrReference)) {
                            LOGGER.info("Task Reference value: " + workQTaskValue + "present in WorkQ task Completed section");
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
}

