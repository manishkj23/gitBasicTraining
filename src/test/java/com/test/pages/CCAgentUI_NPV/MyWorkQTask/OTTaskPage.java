package com.test.pages.CCAgentUI_NPV.MyWorkQTask;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OTTaskPage {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private String workQTaskID = null;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private static String maskedSortCodeXpath = "//div[@class=\"modal-content\"]//span[contains(.,\"Sort Code\")][contains(.,\"***${value}\")]";
    private static String maskedAccountNoXpath = "//div[@class=\"modal-content\"]//span[contains(.,\"Account Number\")][contains(.,\"***${value}\")]";
    private static String revealedSortCodeXpath = "//div[@class=\"modal-content\"]//span[contains(.,\"Sort Code\")][contains(.,\"${value}\")]";
    private static String revealedAccountNoXpath = "//div[@class=\"modal-content\"]//span[contains(.,\"Account Number\")][contains(.,\"${value}\")]";

    @FindBy(xpath = "//div[@class=\"modal-content\"]//h5[contains(.,\"Task\")]")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='modal-footer']//button[contains(text(),'Mark Completed')]")
    private WebElement markCompletedButton;

    @FindBy(xpath = "//button[@id=\"revealBtn5\"]")
    private WebElement revealBankDetailsBtn;

    private static String taskTypeXpath = "//table[@id=\"PlanView_PlanData_Table\"]//tbody//td[contains(.,\"TYPE\")][contains(.,\"${value}\")]";

    @FindBy(xpath = "//div[@class=\"modal-content\"]//td[contains(.,\"D&G Customer ID\")]")
    private WebElement CustomerID;

    public OTTaskPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }
    @Before
    private void setQTaskID(){
        this.workQTaskID = pageHeader.getText().replace("Task ","").trim();
    }

    public boolean isBankAccountdetailsSectionMasked(String sortCode, String accntNo){
        boolean status = false;
        try{
            if(seleniumHelper.getCustomElementByXpath(maskedSortCodeXpath,sortCode.replace("-","").substring(3,6)).isDisplayed()
                    && seleniumHelper.getCustomElementByXpath(maskedAccountNoXpath,accntNo.substring(4,8)).isDisplayed()){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public boolean isBankAccountdetailsSectionRevealed(String sortCode, String accntNo){
        boolean status = false;
        try{
            base.clickElement(revealBankDetailsBtn);
            if(seleniumHelper.getCustomElementByXpath(revealedSortCodeXpath,sortCode.replace("-","")).isDisplayed()
                    && seleniumHelper.getCustomElementByXpath(revealedAccountNoXpath,accntNo).isDisplayed()){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public void clickMarkCompletedButton(){
        base.clickElement(markCompletedButton);
    }

    public boolean isTaskTypeDisplayed(String queryType){
        boolean status = false;
        try{
            if(seleniumHelper.getCustomElementByXpath(taskTypeXpath,queryType).isDisplayed()){
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public boolean isCustomerIDFieldIsPresent(){
        boolean status = false;
        try{
            String custIDField=CustomerID.getText();
            int index = custIDField.lastIndexOf("D&G Customer ID: ");
            String custID=custIDField.substring(index+17).trim();
            if(!custID.equals(null))
                status = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
