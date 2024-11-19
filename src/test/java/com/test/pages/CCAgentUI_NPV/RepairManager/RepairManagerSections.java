package com.test.pages.CCAgentUI_NPV.RepairManager;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairManagerSections {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public RepairManagerSections(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    private static String selectedBabyPlanOnListXpath = "//div[@id=\"PlanView_Page\"]//table//tr[contains(.,\"${value}\")]/td[5]";

    @FindBy(xpath = "//span[@id=\"InflightRepairsHeaderLabel\"][contains(.,\"Repair Manager\")]")
    private WebElement pageHeader;

    @FindBy(xpath = "//a[@id=\"OpenClaimBtn\"]")
    private WebElement openClaimBtn;

    //Start New Interaction - Call reason section
    @FindBy(xpath = "//select[@id='DemandLevel1']//following::input")
    private WebElement callReason_DemandLvl1;

    @FindBy(xpath = "//select[@id='DemandLevel2']//following::input")
    private WebElement CallReason_DemandLvl2;

    @FindBy(xpath = "//button[contains(.,\"Start New Interaction\")]")
    private WebElement startNewInteractionBtn;

    @FindBy(xpath = "//div[contains(@id,\"nav_BookingOverview\")][contains(.,\"Booking Overview\")]")
    private WebElement bookingOverviewPageHeader;
    //RA Data
    @FindBy(xpath = "//div[@id=\"raData\"]//span/b[contains(.,\"Repair\")]")
    private WebElement raData_RepairBtn;

    @FindBy(xpath = "//div[@id=\"raData\"]//span/b[contains(.,\"Appliance\")]")
    private WebElement raData_ApplianceBtn;

    @FindBy(xpath = "//div[@id=\"raData\"]//span/b[contains(.,\"Customer Details\")]")
    private WebElement raData_CustomerDetailsBtn;

    @FindBy(xpath = "//div[@id=\"raData\"]//span/b[contains(.,\"Vulnerabilities\")]")
    private WebElement raData_VulnerabilitiesBtn;

    @FindBy(xpath = "//div[@id=\"raData\"]//span/b[contains(.,\"Plan\")]")
    private WebElement raData_PlanBtn;

    @FindBy(xpath = "//div[@id='RepairManagerHolderID']")
    private static WebElement repairManagerButton;

    @FindBy(xpath = "//button[@id='ToolboxBtnOpen']")
    private static WebElement openToolBoxButton;


    @FindBy(xpath = "//div[@id='reselection']")
    private static WebElement reselectionButton;

    @FindBy(xpath = "//div[@aria-describedby='modP']")
    private static WebElement apptReselectWarningPopup;

    @FindBy(xpath = "//div[@id='modP']//following::div//button")
    private static WebElement continueButton;

    @FindBy(xpath = "//div[@id='UICoreModal_Body']")
    private static WebElement claimHistoryPopup;

    @FindBy(xpath = "//div[@id='PlanView_PlanHistory_Wrapper']//span//u")
    private static WebElement firstOpenCLaim;

    @FindBy(xpath = "//legend[contains(text(),'Find New Appointment')]")
    private WebElement FindNewAppointmentPopUp;

    @FindBy(xpath = "//div[@id='UICoreModal_Header']//button")
    private WebElement FindNewAppointmentPopUpCloseButton;

    private boolean hasMovedToNextTab = false;

    public boolean isRepairManagerScreenDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(pageHeader)) {
                base.highlightElement(pageHeader);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //
    public void navigateToClaimOnNewTab() {
        try {
            if (base.checkIfELementIsAvailable(openClaimBtn) && base.isClickable(openClaimBtn)) {
                base.highlightElement(openClaimBtn);
                base.clickElement(openClaimBtn);
                base.waitForPageToLoad();
                base.switchToNextTab();
            } else {
                LOGGER.info("Unable to navigate to open claim no");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnToRepairManagerMainWindow() {
        if (isBookingOverPageDisplayed()) {
            base.switchToDefaultTab();
        }
    }

    public boolean isBookingOverPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(bookingOverviewPageHeader)) {
                base.highlightElement(bookingOverviewPageHeader);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOnRepairManagerButtonInPlanView() {

        try {
            if (base.checkIfELementIsAvailable(repairManagerButton)) {
                base.highlightElement(repairManagerButton);
                base.clickElement(repairManagerButton);
            } else {
                LOGGER.error("Unable to click the Repair Manager button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectClaimForInteraction() {
        try {
            if(base.checkIfELementIsAvailable(claimHistoryPopup)){
                base.highlightElement(firstOpenCLaim);
                base.clickElement(firstOpenCLaim);
            } else {
                LOGGER.error("Claim History popup not available");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCallReason() {
        try {

            base.checkElementPresence(callReason_DemandLvl1);
            callReason_DemandLvl1.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(callReason_DemandLvl1, 0);
            if (callReason_DemandLvl1.getAttribute("value").isEmpty()) {
                base.checkElementPresence(callReason_DemandLvl1);
                callReason_DemandLvl1.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(callReason_DemandLvl1, 0);
            }

            base.checkElementPresence(CallReason_DemandLvl2);
            CallReason_DemandLvl2.sendKeys(Keys.SPACE);
            base.hardWait("1000");
            seleniumHelper.actionToMoveDownOnList(CallReason_DemandLvl2, 0);
            if (CallReason_DemandLvl2.getAttribute("value").isEmpty()) {
                base.checkElementPresence(CallReason_DemandLvl2);
                CallReason_DemandLvl2.sendKeys(Keys.SPACE);
                base.hardWait("1000");
                seleniumHelper.actionToMoveDownOnList(CallReason_DemandLvl2, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickOnStartNewInteractionButton() {
        try {
            if (base.checkIfELementIsAvailable(startNewInteractionBtn)) {
                base.highlightElement(startNewInteractionBtn);
                base.clickElement(startNewInteractionBtn);
            } else {
                LOGGER.error("Unable to click the Start New InteractionBtn button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickOnToolboxButton()
    {
        try {
            if (base.checkIfELementIsAvailable(openToolBoxButton)) {
                base.highlightElement(openToolBoxButton);
                base.clickElement(openToolBoxButton);
            } else {
                LOGGER.error("Unable to click the open Toolbox button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickOnReselectionButton()
    {
        try {
            if (base.checkIfELementIsAvailable(reselectionButton)) {
                base.highlightElement(reselectionButton);
                base.clickElement(reselectionButton);
                if(base.checkIfELementIsAvailable(apptReselectWarningPopup))
                    base.clickElement(continueButton);
            } else {
                LOGGER.error("Unable to click the Reselection button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeApptReselectionPopup()
    {
        try {
            if (base.checkIfELementIsAvailable(FindNewAppointmentPopUp))
                base.clickElement(FindNewAppointmentPopUpCloseButton);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}