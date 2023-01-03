package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.PlanDetails;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanWriteOff {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private PlanDetails planDetails;


    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public PlanWriteOff(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, PlanDetails planDetails) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.planDetails = planDetails;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"centrex-menu\"]//button[contains(@onclick,\"planWriteOff\")]")
    private WebElement menuItem_PlanWriteOff;


    @FindBy(name = "pwoPlanNo")
    private WebElement planNumberToWriteOff;

    @FindBy(id = "pwoCustomer")
    private WebElement customerSurname;

    @FindBy(id = "pwoPostcode")
    private WebElement postCode;

    @FindBy(id = "pwoSearch")
    private WebElement searchButton;

    @FindBy(xpath = "//table[@id=\"pwoPolicyProductsTable\"]/tbody/tr[1]/td[7]")
    private WebElement planNumberDisplayed;

    @FindBy(xpath = "//span[contains(.,\"Select Product\")]")
    private WebElement selectProductButton;

    @FindBy(xpath = "//div[span[contains(.,\"Select a Reason\")]]//a")
    private WebElement selectAReasonDropDownButton;

    @FindBy(xpath = "//select[@id=\"writeOffReason\"]/../span/input")
    private WebElement selectAreasonInput;

    @FindBy(xpath = "//input[@id=\"PWOQ1\"][@value=\"Yes\"]")
    private WebElement q1_isModelInGenioYes;

    @FindBy(xpath = "//input[@id=\"PWOQ2\"][@value=\"Yes\"]")
    private WebElement q2_hasRepairHistoryCheckedYes;

    @FindBy(xpath = "//input[@id=\"PWOQ3\"][@value=\"No\"]")
    private WebElement q3_teamLeaderAuthorityRequiredNo;

    @FindBy(xpath = "//input[@id=\"PWOQ4\"][@value=\"Full\"]")
    private WebElement q4_FullBreakdown;

    @FindBy(xpath = "//input[@id=\"PWOQ5\"][@value=\"Yes\"]")
    private WebElement q5_isEssentialYes;

    @FindBy(xpath = "//input[@id=\"PWOQ6\"][@value=\"Yes\"]")
    private WebElement q6_isVulnerableYes;

    @FindBy(xpath = "//input[@id=\"PWOQ7\"]")
    private WebElement q7_valueOfAppliance;

    @FindBy(xpath = "//input[@id=\"PWOQ8\"][@value=\"Yes\"]")
    private WebElement q8_ContactedRaYes;

    @FindBy(xpath = "//textarea[@id=\"PWOQ9\"]")
    private WebElement q9_additionalText;

    @FindBy(id = "pworBtn")
    private WebElement planWriteOffButton;


    // Popup
    @FindBy(xpath = "//div[@role=\"dialog\"]//div[contains(.,\"This plan has been successfully written off\")]")
    private WebElement planWriteOffSuccessfullPopup;


    public boolean isPlanWriteOffPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(planNumberToWriteOff)) {
                status = true;
            } else {
                LOGGER.info("Unable to verify the Plan Write Off Page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void writeOffPlan(String planNumber, String writeOffStatus, String oEM) {

        base.sendFieldInputData(planNumberToWriteOff, planDetails.getPlanNumber(oEM));
        base.sendFieldInputData(customerSurname, planDetails.getCustomerSurnameOnTheAPIRequest(oEM));
        base.sendFieldInputData(postCode, planDetails.getCustomerPostcodeOnTheAPIRequest(oEM));
        base.clickElement(searchButton);
        base.clickElement(planNumberDisplayed);
        base.clickElement(selectProductButton);
        base.sendFieldInputData(selectAreasonInput, writeOffStatus);
        try {
            seleniumHelper.actionToMoveDownOnList(selectAreasonInput, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        base.clickElement(q1_isModelInGenioYes);
        base.clickElement(q2_hasRepairHistoryCheckedYes);
        base.clickElement(q3_teamLeaderAuthorityRequiredNo);
        base.clickElement(q4_FullBreakdown);
        base.clickElement(q5_isEssentialYes);
        base.clickElement(q6_isVulnerableYes);
        base.sendFieldInputData(q7_valueOfAppliance, "499");
        base.clickElement(q8_ContactedRaYes);
        base.sendFieldInputData(q9_additionalText, "Test data WO");
        base.clickElement(planWriteOffButton);
        base.waitForPageToLoad();
        base.hardWait("10000");
    }

    public boolean isPlanSuccessfullyWrittenOff() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(planWriteOffSuccessfullPopup)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
