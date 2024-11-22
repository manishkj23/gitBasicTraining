package com.test.pages.CCAgentUI_NPV.MyWorkQTask;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkQTask {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;
    public String workQTaskID = null;
    public OTTaskPage otTaskPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'Confirm')]")
    WebElement workQ_alertConfirmPopUp;

    @FindBy(xpath = "//div[@id='modP'][contains(.,'Request')]")
    WebElement workQ_requestTextConfirmPopUp;

    @FindBy(xpath = "//li[@class='nav-item']//button[@id='PlanHistory_Tabs_Tasks'][contains(.,'WorkQ Tasks')]")
    WebElement workQ_workQTaskTabPlanHistory;

    @FindBy(xpath = "//div[@id='PlanHistory_Tabs_Content']/div[@id='PlanHistory_Tasks']/table[@class='table']/tbody/tr[1]/td[1]/span[1]/b[1]")
    WebElement workQtask_taskReferenceValue;

    @FindBy(xpath = "//div[@id='headerBackGroundColor']//div[@id='centrex-menu']//div[@id='menu']//button[contains(.,'WorkQ')]/span[1]")
    WebElement myWorkQtask_myWorkQTaskLink;

    @FindBy(xpath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@class='workq-tasks-header']/div[@class='toggle-container']//div[@id='button-1']/input[@id='taskAssigned']")
    WebElement myWorkQtask_myWorkQTaskAllToggleButton;

    @FindBy(xpath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@id='WorkQ_MyTasks_Content']")
    WebElement myWorkQtask_myWorkQTaskTable;

    @FindBy(xpath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@id='WorkQ_MyTasks_Content']//div[contains(.,'Task')]/span[contains(.,'OT')]/b")
    WebElement myWorkQtask_taskReferenceValueInTable;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='modal-footer']//button[contains(text(),'Mark Completed')]")
    WebElement myWorkQtask_workQtaskMarkCompletedButton;

    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Confirm')]")
    WebElement myWorkQtask_workQtaskConfirmButtonPopUp;

    @FindBy(xpath = "//span[@class='ui-dialog-title'][contains(.,'Completed')]")
    WebElement myWorkQtask_workQtaskCompletedTextInPopUp;

    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'Close')]")
    WebElement myWorkQtask_workQtaskCloseButtonPopUp;

    @FindBy(xpath = "//div[@id='WorkQ_MyTasks_Wrapper']//div[@class='workq-tasks-header']/div[@class='toggle-container']//div[@id='button-1']/input[@id='taskStatus']")
    WebElement myWorkQtask_myWorkQTaskCompletedToggleButton;

    private final static String currentWorkQTaskSection = "//div[@id=\"WorkQ_MyTasks_Wrapper\"]//div[@id=\"WorkQ_MyTasks_Content\"]/div[contains(.,\"${value}\")]/span[1]";

    public WorkQTask(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, OTTaskPage otTaskPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.otTaskPage = otTaskPage;
        PageFactory.initElements(driver, this);

    }

    public boolean isWorkQAlertConfirmPopUpDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(workQ_alertConfirmPopUp) && workQ_alertConfirmPopUp.isDisplayed()){
                status = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
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

    public boolean isWorkQTaskOnPlanHistorySectionDisplayed(){
        boolean status = false;
        try{
            if(base.checkIfELementIsAvailable(workQtask_taskReferenceValue) && workQtask_taskReferenceValue.isDisplayed()){
                status = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getWorkQTaskID() {
        return this.workQTaskID;
    }

    public void setWorkQTaskID(String taskID) {
        if (this.workQTaskID == null && taskID != null) {
            this.workQTaskID = taskID;
        }
    }

    //To search the OT Task number and click on the it.
    public void verifyTaskReferenceWithMyWorkQTaskAndCompleted() throws InterruptedException {
        String taskrReference, workQTaskValue, completedWorkQTaskValue;
        Thread.sleep(4000);
        base.highlightElement(workQtask_taskReferenceValue);
//        taskrReference = driver.findElement(By.xpath(workQtask_taskReferenceValue)).getText();
//        LOGGER.info("task reference value is: " + taskrReference);
        Thread.sleep(3000);
        base.isClickable(myWorkQtask_myWorkQTaskLink);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskLink);
        Thread.sleep(3000);
        base.highlightElement(myWorkQtask_myWorkQTaskAllToggleButton);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskAllToggleButton);
        Thread.sleep(15000);

        if (base.waitForElementVisible(myWorkQtask_myWorkQTaskTable)) {
//            List<WebElement> workData = driver.findElements(By.xpath(myWorkQtask_taskReferenceValueInTablePath));
//            int noOfTaskPresent = workData.size();
//            LOGGER.info("No. of WorkQ task present: " + noOfTaskPresent);
//            for (WebElement ele : workData) {
//                workQTaskValue = ele.getText();
//                LOGGER.info("task value: " + workQTaskValue);
//                if (workQTaskValue.contains(taskrReference)) {
//                    LOGGER.info("Task Reference value is : " + workQTaskValue);
//                    ele.click();
            Thread.sleep(3000);
            base.waitForElementVisible(myWorkQtask_workQtaskMarkCompletedButton);
            base.clickWithJsExecutor(myWorkQtask_workQtaskMarkCompletedButton);
            base.clickWithJsExecutor(myWorkQtask_workQtaskConfirmButtonPopUp);
            Thread.sleep(3000);
            if (base.waitForElementVisible(myWorkQtask_workQtaskCompletedTextInPopUp)) {
//                        String taskCompletedValue = driver.findElement(By.xpath(myWorkQtask_workQtaskCompletedTextInPopUpPath)).getText();
//                        if (taskCompletedValue.contains(taskrReference)) {
//                            LOGGER.info("WorkQ task" + taskCompletedValue + "successfully marked as completed");
//                        }
                base.clickWithJsExecutor(myWorkQtask_workQtaskCloseButtonPopUp);
            }
        }
        Thread.sleep(5000);
        base.highlightElement(myWorkQtask_myWorkQTaskCompletedToggleButton);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskCompletedToggleButton);
        Thread.sleep(15000);
        if (base.waitForElementVisible(myWorkQtask_myWorkQTaskTable)) {
//                    List<WebElement> completedTaskData = driver.findElements(By.xpath(myWorkQtask_taskReferenceValueInTablePath));
//                    int noOfCompletedTaskPresent = completedTaskData.size();
//                    LOGGER.info("No. of Completed WorkQ task present: " + noOfCompletedTaskPresent);
//                    for (WebElement completedTaskElement : completedTaskData) {
//                        completedWorkQTaskValue = completedTaskElement.getText();
//                        LOGGER.info("task value: " + completedWorkQTaskValue);
//                        if (completedWorkQTaskValue.contains(taskrReference)) {
//                            LOGGER.info("Task Reference value: " + workQTaskValue + "present in WorkQ task Completed section");
//                            break;
//                        }
        }
    }
//            }


    public void verifyTaskReferenceWithMyWorkQTaskAndCompletedNew() throws InterruptedException {
        base.highlightElement(workQtask_taskReferenceValue);
        setWorkQTaskID(workQtask_taskReferenceValue.getText());
        base.isClickable(myWorkQtask_myWorkQTaskLink);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskLink);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskAllToggleButton);

        if (base.waitForElementVisible(myWorkQtask_myWorkQTaskTable)) {
            base.clickElement(seleniumHelper.getCustomElementByXpath(currentWorkQTaskSection, this.workQTaskID));
            base.waitForElementVisible(myWorkQtask_workQtaskMarkCompletedButton);
            base.clickWithJsExecutor(myWorkQtask_workQtaskMarkCompletedButton);
            base.clickWithJsExecutor(myWorkQtask_workQtaskConfirmButtonPopUp);
            if (base.waitForElementVisible(myWorkQtask_workQtaskCompletedTextInPopUp)) {
                if (myWorkQtask_workQtaskCompletedTextInPopUp.getText().contains(this.workQTaskID)) {
                    LOGGER.info("WorkQ task" + myWorkQtask_workQtaskCompletedTextInPopUp.getText() + "successfully marked as completed");
                }
                base.clickWithJsExecutor(myWorkQtask_workQtaskCloseButtonPopUp);
            }
            base.clickWithJsExecutor(myWorkQtask_myWorkQTaskCompletedToggleButton);
            base.checkIfELementIsAvailable(seleniumHelper.getCustomElementByXpath(currentWorkQTaskSection, this.workQTaskID));
        }
    }

    public boolean isCurrentWorkQTaskDisplayed(){
        boolean status = false;
        try{
            if( base.checkIfELementIsAvailable(seleniumHelper.getCustomElementByXpath(currentWorkQTaskSection,this.workQTaskID))){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }


    public void clickCurrentWorkQTaskReference() throws InterruptedException {
        base.highlightElement(workQtask_taskReferenceValue);
        setWorkQTaskID(workQtask_taskReferenceValue.getText());
        base.isClickable(myWorkQtask_myWorkQTaskLink);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskLink);
        base.clickWithJsExecutor(myWorkQtask_myWorkQTaskAllToggleButton);

        if (base.waitForElementVisible(myWorkQtask_myWorkQTaskTable)) {
            base.clickElement(seleniumHelper.getCustomElementByXpath(currentWorkQTaskSection, this.workQTaskID));
            base.waitForElementVisible(myWorkQtask_workQtaskMarkCompletedButton);

        }
    }

    public boolean isTaskDetailsSectionPageDisplayed(){
        boolean status = false;
        try{
            if(base.waitForElementVisible(myWorkQtask_workQtaskMarkCompletedButton)){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

}
