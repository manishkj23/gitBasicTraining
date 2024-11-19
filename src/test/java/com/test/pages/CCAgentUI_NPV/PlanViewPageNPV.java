package com.test.pages.CCAgentUI_NPV;

import com.test.pages.CCAgentUI_NPV.BookingOverview.WriteOffAutorizationPage.WriteOffAuthorizationPage;
import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewPage;
import com.test.pages.CCAgentUI_NPV.CustomerContactView.CustomerContactSection;
import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.ClaimPaymentRequired;
import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.WaiveCallOutChargePaymentNPV;
import com.test.pages.CCAgentUI_NPV.FaultSection.FaultCodeSectionPage;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.*;
import com.test.pages.CCAgent_OLDUI.QandAProcessPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PlanViewPageNPV {


    private static BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public ProductConfirmationPNC productConfirmationPNC;
    public ProductConfirmationHeating productConfirmationHeating;
    public QandAProcessPage qandAProcessPage;
    public FaultCodeSectionPage faultSection;
    public ClaimPaymentRequired claimPaymentRequiredPage;
    public WaiveCallOutChargePaymentNPV waiveExcessNPV;
    public BookingConfirmedPage bookingConfirmedPageNPV;
    public BookingOverviewPage bookingOverviewPage;
    public ServiceOptionsPageNPV serviceOptionsPageNPV;
    public ProductConfirmationHooverCandy productConfirmationHoover;
    public QandAProcessNPVPage qandAProcessNPVPage;
    public ProductConfirmationMobileColorAndCapacity productConfirmationMobileColorAndCapacity;
    public ProductConfirmationCooker productConfirmationCooker;
    public WriteOffAuthorizationPage writeOffAuthorizationPage;
    public BabyPlanViewPage babyPlanViewPage;
    public VulnerableCustomer vulnerableCustomer;
    public CustomerContactSection customerContactSection;
    public ProductConfirmationWHP productConfirmationWHP;


    private static final String getClaimStatusOnClaimHistoryXpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//u[contains(.,\"Claim $(value)\")]/../../..//b[contains(.,\"Status\")]/../text()[7]";
    private static final String availableClaimTypeXpath = "//div[contains(@id,\"BookingTypeHolder\")]//*[contains(@onclick,\"startBooking\")]//span[contains(.,\"$(value)\")]";
    private static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    private static final String HEADER_TITLE = "Plan View";
    private static final String PLAN_HISTORY_HEADER_TITLE = "Plan History";

    public PlanViewPageNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils,
                           ProductConfirmationPNC productConfirmationPNC, QandAProcessPage qandAProcessPage,
                           FaultCodeSectionPage faultSection,
                           ClaimPaymentRequired claimPaymentRequiredPage,
                           WaiveCallOutChargePaymentNPV waiveExcessNPV,
                           BookingConfirmedPage bookingConfirmedPageNPV,
                           BookingOverviewPage bookingOverviewPage,
                           ServiceOptionsPageNPV serviceOptionsPageNPV,
                           ProductConfirmationHeating productConfirmationHeating,
                           ProductConfirmationHooverCandy productConfirmationHoover,
                           QandAProcessNPVPage qandAProcessNPVPage,
                           ProductConfirmationMobileColorAndCapacity productConfirmationMobileColorAndCapacity,
                           ProductConfirmationCooker productConfirmationCooker,
                           WriteOffAuthorizationPage writeOffAuthorizationPage,
                           BabyPlanViewPage babyPlanViewPage,
                           VulnerableCustomer vulnerableCustomer,
                           ProductConfirmationWHP productConfirmationWHP) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
        this.productConfirmationPNC = productConfirmationPNC;
        this.qandAProcessPage = qandAProcessPage;
        this.faultSection = faultSection;
        this.waiveExcessNPV = waiveExcessNPV;
        this.claimPaymentRequiredPage = claimPaymentRequiredPage;
        this.bookingConfirmedPageNPV = bookingConfirmedPageNPV;
        this.bookingOverviewPage = bookingOverviewPage;
        this.serviceOptionsPageNPV = serviceOptionsPageNPV;
        this.productConfirmationHeating = productConfirmationHeating;
        this.productConfirmationHoover = productConfirmationHoover;
        this.qandAProcessNPVPage = qandAProcessNPVPage;
        this.productConfirmationMobileColorAndCapacity = productConfirmationMobileColorAndCapacity;
        this.productConfirmationCooker = productConfirmationCooker;
        this.writeOffAuthorizationPage = writeOffAuthorizationPage;
        this.babyPlanViewPage = babyPlanViewPage;
        this.vulnerableCustomer = vulnerableCustomer;
        this.productConfirmationWHP = productConfirmationWHP;

    }


    @FindBy(xpath = "//*[@id=\"PlanView_Header\"]/span[1]")
    private WebElement headerTitle;

    @FindBy(xpath = "//*[@id=\"PlanView_Header\"]/span[2]")
    private WebElement planNumberHeaderView;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Header\"]")
    private WebElement planViewHistoryHeaderTitle;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//b[contains(.,\"Claims & Repairs\")]")
    private WebElement claimsAndRepairsSectionHeader;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//b[contains(.,\"Customer Contact\")]")
    private WebElement customerContactSectionHeader;

    // @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Customer Name\")]/br/../text()")
    @FindBy(xpath = "//b[contains(text(),'Customer Name')]//parent::td[@class='PlanDataField']")
    private WebElement customerNameField;

    //@FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(b,\"Address\")]/br/../text()[2]")
    @FindBy(xpath = "//b[contains(text(),'Address')]//parent::td[@class='PlanDataField']")
    private WebElement cutomerAddressField;

    //@FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Email\")]/br/../text()")
    @FindBy(xpath = "//b[contains(text(),'Email')]//parent::td[@class='PlanDataField']")
    private WebElement customerEmailField;

    //@FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Mobile\")]/br/../text()")
    @FindBy(xpath = "//b[contains(text(),'Mobile')]//parent::td[@class='PlanDataField']")
    private WebElement customerMobileNumberField;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Home Telephone\")]/br/../text()")
    private WebElement customerHomeTelInfo;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Work Telephone\")]/br/../text()")
    private WebElement customerWorkTelInfo;

    // @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Make\")]/br/../text()")
    @FindBy(xpath = "//b[contains(text(),'Make')]//parent::td[@class='PlanDataField']")
    private WebElement make;

    //@FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Model\")]/br/../text()")
    @FindBy(xpath = "//b[contains(text(),'Model')]//parent::td[@class='PlanDataField']")
    private WebElement modelField;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Serial\")]/br/../text()")
    private WebElement serialNumber;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//u[contains(.,\"Claim\")]")
    private List<WebElement> previousClaims;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]")
    private WebElement claimHistoryContents;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//div[1]/span[1]/b/u")
    private WebElement recentClaimOnPlan;

    // Claim Type
//    public static final String claimTypeXpath = "//div[@id=\"BookingTypeHolder\"]/div[contains(.,\"${value}\")]";
    public static final String claimTypeXpath = "//div[@id=\"PlanView_StartNew_Content\"]//div/span[contains(.,\"${value}\")]";
    //    private final String claimTypeXpath = "//div[@id=\"PlanView_StartNew_Content\"]//span[contains(.,\"${value}\")]";
    private final String claimFromClaimHistoryXpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//span[@onClick][contains(.,\"${value}\")]";

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//div[1]/span[@onClick]")
    private WebElement currentClaimNumber;


    // Repair Booking Frames:
    @FindBy(xpath = "//div[@id=\"PlanView_NewClaim_Header\"]/span[contains(.,\"Repair Booking\")]")
    private WebElement repairBookingHeader;

    //Contact Information
    @FindBy(xpath = "//button[contains(.,\"Contact Information\")]")
    private WebElement contactInformationSectionButton;

    @FindBy(id = "CustomerEmail")
    private WebElement contactEmail;

    @FindBy(id = "CustomerMobile")
    private WebElement contactMobileNumber;

    @FindBy(id = "CustomerLandline")
    private WebElement contactLandlineNumber;

    @FindBy(id = "nextBtnCustomer")
    private WebElement contactContinueButton;

    // Product Confirmation
    @FindBy(xpath = "//button[contains(.,\"Product Confirmation\")]")
    private WebElement productConfirmationSectionButton;

    @FindBy(id = "makeClaimBut")
    private WebElement productConfirmation_ContinueButton;

    // Claims QA
    @FindBy(xpath = "//button[contains(.,\"Claim Q&A\")]")
    private WebElement claimQASectionButton;

    // Claim Q&A Section to verify the claim is accepted : @Veera
    @FindBy(xpath = "//button[contains(.,\"Claim Q&A\")]")
    private WebElement claimQandASection;

    @FindBy(xpath = "//*[@id=\"IcqB54R\"]/div/div[contains(.,\"CLAIM ACCEPTED\")]")
    WebElement claimAccepted;

    @FindBy(xpath = "//td/div[contains(.,\"CLAIM REJECTED\")]")
    private WebElement claimRejected;

    // ServiceOptions section :
    @FindBy(xpath = "//button[contains(.,\"Service Options\")]")
    private WebElement serviceOptionSection;

    //logout section
    @FindBy(xpath = "//span/a[contains(.,\"Logout\")]")
    private WebElement logoutButon;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//div[1]/span[contains(@onclick,\"openClaim\")]/b/u")
    private WebElement openClaimOnHomePage;

    @FindBy(xpath = "//div[@id=\"headerBackGroundColor\"]//*[@id=\"header\"]/table//td//div[contains(@onclick,\"/domgenprelive/index\")]")
    private WebElement dgLogoNPV;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]/div[@class=\"row\"]/div[1][contains(@class,\"col-sm-6\")]//div[@class=\"card-body p-1\"]/div[1]/text()[7]")
    private WebElement currentClaimStatusOnUI;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]/div[@class=\"row\"]/div[1][contains(@class,\"col-sm-6\")]//div[@class=\"card-body p-1\"]/div[1]/div[contains(.,\"BOOKING INCOMPLETE\")]")
    private WebElement currentClaimBookingIncompletStatusBtn;

    @FindBy(xpath = "//div[@id=\"menu\"]/button[contains(.,\"WorkQ\")]")
    private WebElement workQMenuSection;

    @FindBy(xpath = "//span[@id=\"customerVuln\"]")
    private WebElement updateVulnerabilityBtn;

    private final String workQ_workQTaskTabPlanHistoryPath = "//li[@class='nav-item']//button[@id='PlanHistory_Tabs_Tasks'][contains(.,'WorkQ Tasks')]";
    @FindBy(xpath = workQ_workQTaskTabPlanHistoryPath)
    WebElement workQ_workQTaskTabPlanHistory;

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[contains(.,\"Request Sent\")]")
    private WebElement alertPopupForCustomerContactRequestSent;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Confirm\")]")
    private WebElement alertPopupForCustomerContact_ConfirmBtn;

    @FindBy(xpath = "//a[contains(.,\"My WorkQ\")]")
    private WebElement myWorkQTaskBtn;

    @FindBy(xpath = "//div/b[contains(text(),'Information - Plan Skipped')]")
    private static WebElement informationNewPlanNumber;

    @FindBy(xpath = "//div/b[contains(text(),'Information - Plan Skipped')]")
    private static WebElement informationPreviousPlanNumber;

    @FindBy(xpath = "//div[contains(text(),'Go to previous plan')]")
    private WebElement goToPreviousPlanButton;
    @FindBy(xpath = "//*[@id=\"PlanView_Header\"]/span[2]")
    private static WebElement previousPlanNumber;
    @FindBy(xpath = "//*[@id=\"PlanView_Header\"]/span[2]")
    private static WebElement newPlanNumber;

    @FindBy(xpath = "//div[@class='btn btn-sm btn-primary']")
    private static WebElement goToNewPlanButton;
    @FindBy(xpath = "//div[@class='btn btn-sm btn-primary'][contains(text(),'See other plans')]")
    private WebElement seeOtherPlansButton;

    @FindBy(xpath = "//div[@id='modP']")
    private WebElement alertPopup;

    @FindBy(xpath = "//div[@id='modP']//following-sibling::div//button[text()='Close']")
    private WebElement closeAlertPopup;

    private final String claimTypeWithOpenClaimMsgXpath = "//div[contains(@id,\"BookingType_\")][contains(@data-tippy-content,\"claim already open\")]/span[contains(.,\"${value}\")]";
    private final String claimTypeInWarrantyMsgXpath = "//div[contains(@id,\"BookingType_\")][contains(@data-tippy-content,\"plan does not start until\")]/span[contains(.,\"${value}\")]";
    private final String planIsCancelledXpath = "//div[contains(@id,\"BookingType_\")][contains(@data-tippy-content,\"plan is cancelled\")]/span[contains(.,\"${value}\")]";
    private final String planIsLapsedXpath = "//div[contains(@id,\"BookingType_\")][contains(@data-tippy-content,\"plan is lapsed\")]/span[contains(.,\"${value}\")]";
    private final String planIsOneOffRepair = "//div[contains(@id,\"BookingType_\")][contains(@data-tippy-content,\"plan has had a One-off Repair more than 90 days ago\")]/span[contains(.,\"${value}\")]";
    public static String custName="";
    public static String custAddrLine1="";
    public static String custpostCode="";
    public static String custEmail="";
    public static String custMobileNum="";
    public static String planModel="";

    public boolean isClaimTypeEnabled (String claimTyp){
        return (seleniumHelper.getCustomElementByXpath(claimTypeXpath, claimTyp).isEnabled()) ? true : false;
    }


    public void selectClaimType (String claimType){
        if (isClaimTypeEnabled(claimType)) {
            base.clickElement(seleniumHelper.getCustomElementByXpath(claimTypeXpath, claimType));
        } else {
            LOGGER.info("Unable to click the Claim Type");
        }
    }

    public void logout () {
        try {
            if (base.checkIfELementIsAvailable(logoutButon) && base.isClickable(logoutButon)) {
                base.highlightElement(logoutButon);
                base.clickElement(logoutButon);
            } else {
                LOGGER.error("Unable to verify the Logout function");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPlanNumberDisplayedOnHeader (String planNo){

        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(planNumberHeaderView) && planNumberHeaderView.getText().equalsIgnoreCase(planNo)) {
                base.highlightElement(planNumberHeaderView);
                status = true;
            } else {
                LOGGER.error("Unable to verify the Plan Number on the  Header Panel");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isClaimTypeEligibleForClaim (String claimTyp){

        boolean status = false;
        try {
            WebElement claimType = seleniumHelper.getCustomElementByXpath(availableClaimTypeXpath, claimTyp);
            if (claimType != null && claimType.getText().contains(claimTyp)) {
                status = true;
            } else {
                LOGGER.error("Claim Type selected is not available to process the claim");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isClaimAndRepairHistorySectionDisplayed () {

        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(claimHistoryContents) && claimHistoryContents.isDisplayed()) {
                status = true;
            } else {
                LOGGER.error("Unable to display the claim history contents");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getClaimStatusOnClaimHistory (String claimNumber){

        String recentClaim = null;
        try {
            if (isClaimAndRepairHistorySectionDisplayed() && recentClaimOnPlan != null) {
                recentClaim = recentClaimOnPlan.getText();
            }
        } catch (Exception e) {
            LOGGER.error("Unable to retrieve the recent claim number on the plan ");
            e.printStackTrace();
        }
        return recentClaim;
    }

    public void navigateToClaimPage (String claimNumber){
        base.navigateToPage(base.prop.getProperty("jobupdatePage") + claimNumber);
    }

    public boolean isRepairBookingHeaderDisplayed () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(repairBookingHeader)) {
                base.highlightElement(repairBookingHeader);
                status = true;
            } else {
                LOGGER.error("Unable to verify the Repair Booking Header Title");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isClaimInAcceptedStatus () {
        base.clickElement(claimQandASection);
        base.waitForPageToLoad();
        base.waitTillElementFound(claimAccepted);
        base.highlightElement(claimAccepted);
        return (claimAccepted.isDisplayed()) ? true : false;
    }

    public void cliclServiceOptionSection () {
        base.clickElement(serviceOptionSection);
    }

    public void confirmContactInformation () {

        if (base.checkIfELementIsAvailable(contactEmail) && base.getWebElementValue(contactEmail).isEmpty()) {
            base.sendFieldInputData(contactEmail, seleniumHelper.mockData.getEmailAddress());
        }

        if (base.checkIfELementIsAvailable(contactMobileNumber) && base.getWebElementValue(contactMobileNumber).isEmpty()) {
            base.sendFieldInputData(contactMobileNumber, "07900148812"); // Fake number
        }

        if (base.checkIfELementIsAvailable(contactLandlineNumber) && base.getWebElementValue(contactLandlineNumber).isEmpty()) {
            base.sendFieldInputData(contactLandlineNumber, "02037874735"); // DG Number
        }
        base.hardWait("3000");
        base.clickWithJsExecutor(contactContinueButton);


    }

    public void enterFaultDetailsAndContinue () {
        faultSection.enterFaultArea();
        faultSection.enterFault();
        if (productConfirmation_ContinueButton.isEnabled()) {
            productConfirmation_ContinueButton.click();
        } else {
            LOGGER.info("Failed to click the Continue button");
        }
    }


    public void clickCurrentClaimNumber () {
        try {
            if (base.checkIfELementIsAvailable(currentClaimNumber) && base.isClickable(currentClaimNumber)) {
                base.clickElement(currentClaimNumber);
            } else {
                LOGGER.error("Unable to navigate the the recent claim number");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isClaimTypeHasOpenClaimMsgShowing (String claimTyp) throws Exception {
        boolean status = false;
        try {
            if (seleniumHelper.getCustomElementByXpath(claimTypeWithOpenClaimMsgXpath, claimTyp).isEnabled()) {
                seleniumHelper.actionToMoveToElement(seleniumHelper.getCustomElementByXpath(claimTypeWithOpenClaimMsgXpath, claimTyp));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isClaimTypeShowsPlanInWarranty (String claimTyp){
        boolean status = false;
        try {
            if (seleniumHelper.getCustomElementByXpath(claimTypeInWarrantyMsgXpath, claimTyp).isEnabled()) {
                seleniumHelper.actionToMoveToElement(seleniumHelper.getCustomElementByXpath(claimTypeInWarrantyMsgXpath, claimTyp));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isPlanCancelled (String claimTyp){
        boolean status = false;
        try {
            if (seleniumHelper.getCustomElementByXpath(planIsCancelledXpath, claimTyp).isEnabled()) {
                seleniumHelper.actionToMoveToElement(seleniumHelper.getCustomElementByXpath(planIsCancelledXpath, claimTyp));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isPlanLapsed (String claimTyp){
        boolean status = false;
        try {
            if (seleniumHelper.getCustomElementByXpath(planIsLapsedXpath, claimTyp).isEnabled()) {
                seleniumHelper.actionToMoveToElement(seleniumHelper.getCustomElementByXpath(planIsLapsedXpath, claimTyp));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isPlanNotEligibleForOneOffRepair (String claimTyp){
        boolean status = false;
        try {
            if (seleniumHelper.getCustomElementByXpath(planIsOneOffRepair, claimTyp).isEnabled()) {
                seleniumHelper.actionToMoveToElement(seleniumHelper.getCustomElementByXpath(planIsOneOffRepair, claimTyp));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void getClaimNumberFromHomeScreen () {
        base.checkIfELementIsAvailable(openClaimOnHomePage);
        seleniumHelper.getOnlyNumericCharsFromString(openClaimOnHomePage.getText());

    }

    public boolean cancelJobFromUI (String planNo) throws Exception {
        boolean status = false;
        if (!commonUtils.getOpenClaimsIfNotCancelled(planNo).isEmpty() && !commonUtils.getOpenClaimNo(planNo).isEmpty()) {
            status = true;
            base.navigateToPage(base.prop.getProperty("cancelJob") + commonUtils.getOpenClaimNo(planNo));
            bookingOverviewPage.cancelClaimOnly();
            if (!bookingOverviewPage.isJobStatusUpdated("cancelled")) {
                base.waitForPageToLoad();
            }
        }
        return status;

    }

    public void clickOnDnGLogoForNPV () {
        try {
            base.waitForElementVisible(dgLogoNPV);
            if (base.checkIfELementIsAvailable(dgLogoNPV) & base.isClickable(dgLogoNPV)) {
                base.highlightElement(dgLogoNPV);
                base.clickWithJsExecutor(dgLogoNPV);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on D and G logo");
        }
    }

    /*
    Manish Kumar Jain
    Scenario: Click on the Open Claim button in the Inflight Repair Summary
    Date: 8th July 2022
     */
    public void clickOnOpenClaimButtonInInflightRepairSummary () {
        WebElement openClaimButton = driver.findElement(By.xpath("//div[@id='InflightRepairs_Header']//a[@id='OpenClaimBtn']"));
        base.clickWithJsExecutor(openClaimButton);
    }

    /*
    Manish Kumar Jain
    Scenario: Click on the open claim no. in the Plan History section
    Date: 8th July 2022
     */
    public void clickOnOpenClaimNoLinkInPlanHistory () {
        WebElement openClaimLink = driver.findElement(By.xpath("//div[@id='PlanHistory_Claims']//table[@class='table']//tbody/tr[1]/td[1]/a"));
        base.clickWithJsExecutor(openClaimLink);
    }

    public void clickOnCustomerContactButtonInPlanView () {
        WebElement customerContactButton = driver.findElement(By.xpath("//div[@id='PlanView_StartNew_Content']//div[@id='ActionTypeHolder']//div[@id='BookingType_CC']"));
        base.clickWithJsExecutor(customerContactButton);
    }


    public void clickMyWorkQTaskButton () {
        base.clickElement(myWorkQTaskBtn);
    }

    public boolean clickSeeOtherPlansButton () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(seeOtherPlansButton)) {
                base.highlightElement(seeOtherPlansButton);
                Thread.sleep(10000);
                // base.clickWithJsExecutor(seeOtherPlansButton);
                base.clickElement(seeOtherPlansButton);
                status = true;
            } else {
                LOGGER.error("Unable to verify the see other plans button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean isPageHeaderTitleDisplayed () {
        boolean status = false;
        try {
            Thread.sleep(10000);
            if (base.checkIfELementIsAvailable(headerTitle) && headerTitle.getText().equalsIgnoreCase(HEADER_TITLE)) {
                Thread.sleep(200);
                base.highlightElement(headerTitle);
                status = true;
            } else {
                LOGGER.error("Unable to verify the Plan View Header Title");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyNewPlanNumber () {
        boolean status = false;
        try {
            if (base.waitForElementVisible(informationNewPlanNumber)) {
                String InformationSkippedPlan = informationNewPlanNumber.getText();
                LOGGER.info(InformationSkippedPlan);
                InformationSkippedPlan = informationNewPlanNumber.getText().substring(30, 40);
                LOGGER.info(InformationSkippedPlan);
                Thread.sleep(3000);
                base.highlightElement(informationNewPlanNumber);
                if (base.waitForElementVisible(goToNewPlanButton)) {
                    Thread.sleep(3000);
                    base.highlightElement(goToNewPlanButton);
                    goToNewPlanButton.click();
                    if (base.checkIfELementIsAvailable(newPlanNumber)) {
                        String NewPlanNumber = newPlanNumber.getText();
                        LOGGER.info(NewPlanNumber);
                        InformationSkippedPlan.equals(NewPlanNumber);
                        Thread.sleep(3000);
                        base.highlightElement(newPlanNumber);
                        LOGGER.info("Matching the New plan number");
                        status = true;
                    } else {
                        LOGGER.info("Not matching the new plan number");
                    }
                } else {
                    LOGGER.info("Go to new plan button not clicking");
                }
            } else {
                LOGGER.info("Information - new plan number not reading");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean verifyPreviousPlanNumber () {
        boolean status = false;
        try {
            if (base.waitForElementVisible(informationPreviousPlanNumber)) {
                String InformationPreviousPlan = informationPreviousPlanNumber.getText();
                LOGGER.info(InformationPreviousPlan);
                InformationPreviousPlan = informationPreviousPlanNumber.getText().substring(32, 42);
                LOGGER.info(InformationPreviousPlan);
                Thread.sleep(3000);
                base.highlightElement(informationPreviousPlanNumber);
                if (base.waitForElementVisible(goToPreviousPlanButton)) {
                    base.highlightElement(goToPreviousPlanButton);
                    Thread.sleep(3000);
                    goToPreviousPlanButton.click();
                    if (base.waitForElementVisible(previousPlanNumber)) {
                        String PreviousPlan = previousPlanNumber.getText();
                        LOGGER.info(PreviousPlan);
                        InformationPreviousPlan.equals(PreviousPlan);
                        Thread.sleep(3000);
                        base.highlightElement(previousPlanNumber);
                        LOGGER.info("Matching the Previous plan number");

                        status = true;
                    } else {
                        LOGGER.info("Not matching the previous plan number");
                    }
                } else {
                    LOGGER.info("Go to previous plan button not clicking");
                }
            } else {
                LOGGER.info("Information - previous plan number not reading");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyAndCloseAlertPopup () {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(alertPopup) && base.waitForElementVisible(alertPopup)) {
                base.highlightElement(alertPopup);
                base.highlightElement(closeAlertPopup);
                base.clickWithJsExecutor(closeAlertPopup);
                status = true;
            } else {
                LOGGER.info("Alert popup not visible");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void getCustomerDetails() {
        try {
            if (isPageHeaderTitleDisplayed()) {
                base.checkElementPresence(customerNameField);
                String name=customerNameField.getText();
                if(!name.contains("None"))
                    custName= name.split("\n")[1];

                base.checkElementPresence(cutomerAddressField);
                String address=cutomerAddressField.getText();
                // String address=addr.split("\n")[1];
                String[] customerAddress= (address.split("\n")[1]).split(",");
                if(!address.contains("None")) {
                    custAddrLine1 = customerAddress[0];
                    custpostCode = customerAddress[customerAddress.length - 1];
                }

                base.checkElementPresence(customerEmailField);
                String email=customerEmailField.getText();
                if(!email.contains("None"))
                    custEmail= email.split("\n")[1];

                base.checkElementPresence(customerMobileNumberField);
                String mobileNum=customerMobileNumberField.getText();
                if(!mobileNum.contains("None"))
                    custMobileNum= mobileNum.split("\n")[1];

                base.waitForElementVisible(modelField);
                String model= modelField.getText();
                if(!model.contains("None"))
                    planModel=model.split("\n")[1];

            }
            else{
                LOGGER.error("Plan View page not loaded");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}