package com.test.pages.CCAgentUI_NPV;

import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.BookingOverviewPage;
import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.ClaimPaymentRequired;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationHeating;
import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationPNC;
import com.test.pages.QandAProcessPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PlanViewPageNPV {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public ProductConfirmationPNC productConfirmationPNC;
    public QandAProcessPage qandAProcessPage;
    public ClaimPaymentRequired claimPaymentRequiredPage;
    public ProductConfirmationHeating productConfirmationHeatingPage;
    public ServiceOptionsPageNPV serviceOptionsPageNPV;
    public BookingOverviewPage bookingOverviewPage;

//    private ProductConfirmationModelNumber;

    //Find elements
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

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Customer Name\")]/br/../text()")
    private WebElement customerNameField;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(b,\"Address\")]/br/../text()[2]")
    private WebElement cutomerAddressField;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Email\")]/br/../text()")
    private WebElement customerEmailInfo;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Mobile\")]/br/../text()")
    private WebElement customerMobileNumberInfo;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Home Telephone\")]/br/../text()")
    private WebElement customerHomeTelInfo;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Work Telephone\")]/br/../text()")
    private WebElement customerWorkTelInfo;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Make\")]/br/../text()")
    private WebElement make;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Model\")]/br/../text()")
    private WebElement model;

    @FindBy(xpath = "//table[@id=\"PlanView_PlanData_Table\"]//td[contains(.,\"Serial\")]/br/../text()")
    private WebElement serialNumber;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//u[contains(.,\"Claim\")]")
    private List<WebElement> previousClaims;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]")
    private WebElement claimHistoryContents;

    @FindBy(xpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//div[1]/span[1]/b/u")
    private WebElement recentClaimOnPlan;

    // Claim Type :
    private final String claimTypeXpath = "//div[@id=\"PlanView_StartNew_Content\"]//span[contains(.,\"${value}\")]";
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

    @FindBy(xpath = "//button[@id='nextBtnCustomer']")
    private WebElement contactContinueButton;

    // Product Confirmation
    @FindBy(xpath = "//button[contains(.,\"Product Confirmation\")]")
    private WebElement productConfirmationSectionButton;

    // Claims QA
    @FindBy(xpath = "//button[contains(.,\"Claim Q&A\")]")
    private WebElement claimQASectionButton;

    private static final String customerContactButtonPath="//div[@id='PlanView_StartNew_Content']//div[@id='ActionTypeHolder']//div[@id='BookingType_CC']";
    @FindBy(xpath=customerContactButtonPath)
    private WebElement customerContactButton;

//
//    // Contact info - update from Agent
//    @FindBy(id = "CustomerEmail")
//    private WebElement customerEmailAddress;
//
//    @FindBy(id = "CustomerMobile")
//    private WebElement customerMobileNumber;
//
//    @FindBy(id = "CustomerLandline")
//    private WebElement customerLandlineNumber;
//
//    @FindBy(id = "nextBtnCustomer")
//    private WebElement continueButtonCustomerInfoSection;
//
//    // Product Confirmation Section
//    @FindBy(id = "makeClaimBut")
//    private WebElement continueButtonProductConfirmationSection;


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

    //Inflight Repair Summary Header
    private final String inflightRepairSummaryHeaderPath = "//div[@id='InflightRepairs_Header']//span[@id='InflightRepairsHeaderLabel']";
    @FindBy(xpath = inflightRepairSummaryHeaderPath)
    private WebElement inflightRepairSummaryHeader;

    //Recent Open Claim Number Path section
    private final String recentOpenClaimNumberPath = "//div[@id=\"PlanView_PlanHistory_Content\"]//div[contains(@class,'border shadow')]/span[@onClick]";
    @FindBy(xpath = recentOpenClaimNumberPath)
    private WebElement recentOpenClaimNumber;

    //Customer Interaction History Header section
    private final String customerInteractionHistoryHeaderPath = "//b[contains(text(),'Customer Interaction History')]";
    @FindBy(xpath = customerInteractionHistoryHeaderPath)
    private WebElement customerInteractionHistoryHeader;

    //RA Data Button section
    private final String verifyRADataButtonPath = "//div[@id='RepairSummaryOuter']/div[@id='RepairSummaryInner']/div[contains(@class,'dataTabs')]//button[contains(text(),'RA Data')]";
    @FindBy(xpath = verifyRADataButtonPath)
    private WebElement verifyRADataButton;

    //Agent Input Button section
    private final String verifyAgentInputButtonPath = "//div[@id='RepairSummaryOuter']/div[@id='RepairSummaryInner']/div[contains(@class,'dataTabs')]//button[contains(text(),'Agent In')]";
    @FindBy(xpath = verifyAgentInputButtonPath)
    private WebElement verifyAgentInputButton;

    //Open Claim Button Display
    private final String verifyOpenClaimButtonPath = "//div[@id='InflightRepairs_Header']//a[@id='OpenClaimBtn']";
    @FindBy(xpath = verifyOpenClaimButtonPath)
    private WebElement verifyOpenClaimButton;

    //Click On Inflight Repair Workflow
    private final String clickOnInflightRepairWorkflowPath = "//div[@id='InflightRepairSummaryPage']/div[contains(@class,'col-12')]/table[contains(@class,'table table-light')]/tbody/tr[1]/th[1]/span[1]";
    @FindBy(xpath = clickOnInflightRepairWorkflowPath)
    private WebElement clickOnInflightRepairWorkflow;

    //Workflow Details section
    private final String verifyWorkflowDetailsHeaderPath = "//div[@id='InflightRepairSummaryFirstPage']//b[contains(text(),'Workflow Details')]";
    @FindBy(xpath = verifyWorkflowDetailsHeaderPath)
    private WebElement verifyWorkflowDetailsHeader;

    @FindBy(xpath = "//b[contains(text(),'Started')]")
    private WebElement workflowDetailsSubLabelStarted;

    @FindBy(xpath = "//b[contains(text(),'Finished')]")
    private WebElement workflowDetailsSubLabelFinished;

    @FindBy(xpath = "//b[contains(text(),'Duration')]")
    private WebElement workflowDetailsSubLabelDuration;

    @FindBy(xpath = "//div[@id=\"headerBackGroundColor\"]//*[@id=\"header\"]/table//td//div[contains(@onclick,\"/domgenprelive/index\")]")
    private WebElement dgLogoNPV;

    private final String workflowDetails_StartedDateTimePath = "/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]";
    @FindBy(xpath = workflowDetails_StartedDateTimePath)
    private WebElement workflowDetails_StartedDateTime;

    private final String workflowDetails_FinishedDateTimePath = "/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]";
    @FindBy(xpath = workflowDetails_FinishedDateTimePath)
    private WebElement workflowDetails_FinishedDateTime;

    private final String workflowDetails_DurationDateTimePath = "/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]";
    @FindBy(xpath = workflowDetails_DurationDateTimePath)
    private WebElement workflowDetails_DurationDateTime;

    @FindBy(xpath = "//span[contains(text(),'Length of repair')]")
    private WebElement RAData_LengthOfRepairPath;

    @FindBy(xpath = "//span[contains(text(),'Fault Reported')]")
    private WebElement RAData_FaultReportedPath;

    @FindBy(xpath = "//span[contains(text(),'Parts Ordered')]")
    private WebElement RAData_PartsOrderedPath;

    @FindBy(xpath = "//span[contains(text(),'Parts ETA')]")
    private WebElement RAData_PartsETAPath;

    @FindBy(xpath = "//span[contains(text(),'Part Name')]")
    private WebElement RAData_PartNamePath;

    @FindBy(xpath = "//span[contains(text(),'Last RA Update')]")
    private WebElement RAData_LastRAUpdatePath;

    @FindBy(xpath = "//span[contains(text(),'Estimated time to complete repair')]")
    private WebElement RAData_EstimatedTimeToCompleteRepairPath;

    @FindBy(xpath = "//span[contains(text(),'Appliance Type')]")
    private WebElement RAData_ApplianceTypePath;

    private final String RAData_CustomerVulnerabilityLoggedPath = "//span[contains(text(),'Customer Vulnerability Logged')]";
    @FindBy(xpath = RAData_CustomerVulnerabilityLoggedPath)
    private WebElement RAData_CustomerVulnerabilityLogged;

    private final String RAData_VulnerabilitesPath = "//span[contains(text(),'Vulnerabilites')]";
    @FindBy(xpath = RAData_VulnerabilitesPath)
    private WebElement RAData_Vulnerabilites;

    private final String RAData_TablePath = "//div[@id='raData'][@class='tabContent']";
    @FindBy(xpath = RAData_TablePath)
    private WebElement RAData_Table;

    // WB Contact Information tab

    private final String WB_CustomerEmailPath="//input[@id='CustomerEmail']";
    @FindBy(xpath = WB_CustomerEmailPath)
    private WebElement WB_CustomerEmail;


    private static final String getClaimStatusOnClaimHistoryXpath = "//*[@id=\"PlanView_PlanHistory_Content\"]//u[contains(.,\"Claim $(value)\")]/../../..//b[contains(.,\"Status\")]/../text()[7]";
    //    private static final String claimTypeXpath = "//div[contains(@id,\"BookingTypeHolder\")]//span[contains(.,\"$(value)\")]";
    private static final String availableClaimTypeXpath = "//div[contains(@id,\"BookingTypeHolder\")]//*[contains(@onclick,\"startBooking\")]//span[contains(.,\"$(value)\")]";

    private static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    private static final String HEADER_TITLE = "Plan View";
    private static final String PLAN_HISTORY_HEADER_TITLE = "Plan History";


    public PlanViewPageNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils,
                           ProductConfirmationPNC productConfirmationPNC, QandAProcessPage qandAProcessPage, ClaimPaymentRequired claimPaymentRequiredPage,
    ProductConfirmationHeating productConfirmationHeatingPage,ServiceOptionsPageNPV serviceOptionsPageNPV
    ,BookingOverviewPage bookingOverviewPage) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
        this.productConfirmationPNC = productConfirmationPNC;
        this.qandAProcessPage = qandAProcessPage;
        this.claimPaymentRequiredPage = claimPaymentRequiredPage;
        this.productConfirmationHeatingPage = productConfirmationHeatingPage;
        this.serviceOptionsPageNPV = serviceOptionsPageNPV;
        this.bookingOverviewPage = bookingOverviewPage;
    }

    public boolean isPageHeaderTitleDisplayed() {

        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(headerTitle) && headerTitle.getText().equalsIgnoreCase(HEADER_TITLE)) {
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

    public void clickCurrentClaimNumber() {
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

    public boolean isPlanNumberDisplayedOnHeader(String planNo) {

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

    public boolean isClaimTypeEligibleForClaim(String clTyp) {

        boolean status = false;
        try {
            WebElement claimType = seleniumHelper.getCustomElementByXpath(availableClaimTypeXpath, clTyp);
            if (claimType != null && claimType.getText().contains(clTyp)) {
                status = true;
            } else {
                LOGGER.error("Claim Type selected is not available to process the claim");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isClaimAndRepairHistorySectionDisplayed() {

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

    public String getClaimStatusOnClaimHistory(String claimNumber) {

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

    public void navigateToClaimPage(String claimNumber) {
        base.navigateToPage(base.prop.getProperty("jobupdatePage") + claimNumber);
    }

    public boolean isRepairBookingHeaderDisplayed() {
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

    public boolean isClaimInAcceptedStatus() {
        base.clickElement(claimQandASection);
        base.waitForPageToLoad();
        base.waitTillElementFound(claimAccepted);
        base.highlightElement(claimAccepted);
        return (claimAccepted.isDisplayed()) ? true : false;
    }

    public void cliclServiceOptionSection() {
        base.clickElement(serviceOptionSection);
    }

    public void confirmContactInformation() {

        if (base.checkIfELementIsAvailable(contactEmail) && base.getWebElementValue(contactEmail).isEmpty()) {
            base.sendFieldInputData(contactEmail, seleniumHelper.mockData.getEmailAddress());
        }

        base.clickWithJsExecutor(contactContinueButton);
    }

    /*
    Manish Kumar Jain
    Scenario: Click on Recent Open claim link
    Date: 6th Dec 2021
     */
    public void clickOpenClaimNumber() {
        try {
            if (base.checkIfELementIsAvailable(recentOpenClaimNumber)) {
                base.clickWithJsExecutor(recentOpenClaimNumber);
            } else {
                LOGGER.error("Unable to navigate the the recent claim number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Manish Kumar Jain
    Scenario: Verify the Inflight Repair Summary Header
    Date: 6th Dec 2021
     */

    public boolean verifyInFlightSummaryHeader() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(inflightRepairSummaryHeader) && inflightRepairSummaryHeader.isDisplayed()) {
                base.highlightElement(inflightRepairSummaryHeader);
                status = true;
            } else {
                LOGGER.error("Unable to display the Inflight Repair Summary Header");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*
    Manish Kumar Jain
    Scenario: Verify Customer Interaction History Header
    Date: 7th Dec 2021
     */
    public boolean verifyCustomerInteractionHistoryHeaderDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(customerInteractionHistoryHeader) && customerInteractionHistoryHeader.isDisplayed()) {
                base.highlightElement(customerInteractionHistoryHeader);
                status = true;
            } else {
                LOGGER.error("Unable to display the Inflight Repair Summary Header");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*Manish Kumar Jain
    Scenario: Verify RA Data, Agent Input, Open Claim Button display
    Date: 7th Dec 2021*/
    public boolean verifyRADataAgentInputOpenClaimButtonDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(verifyRADataButton) && verifyRADataButton.isDisplayed()) {
                base.highlightElement(verifyRADataButton);
                status = true;
            } else {
                LOGGER.error("Unable to display the Inflight Repair Summary Header");
            }
            Thread.sleep(2000);
            if (base.checkIfELementIsAvailable(verifyAgentInputButton) && verifyAgentInputButton.isDisplayed()) {
                base.highlightElement(verifyAgentInputButton);
                status = true;
            } else {
                LOGGER.error("Unable to display the Inflight Repair Summary Header");
            }
            Thread.sleep(2000);
            if (base.checkIfELementIsAvailable(verifyOpenClaimButton) && verifyOpenClaimButton.isEnabled()) {
                base.highlightElement(verifyOpenClaimButton);
                status = true;
            } else {
                LOGGER.error("Unable to display the Inflight Repair Summary Header");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    /*Manish Kumar Jain
    Scenario: Verify Inflight Repair Workflow Link is enabled and clickable
    Date: 7th Dec 2021*/
    public void clickInflightRepairWorkflowLink() {
        try {
            if (base.checkIfELementIsAvailable(clickOnInflightRepairWorkflow)) {
                base.clickWithJsExecutor(clickOnInflightRepairWorkflow);
            } else {
                LOGGER.error("Unable to Click On Inflight Repair Workflow link");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Manish Kumar Jain
    Scenario: Verify Workflow Details summary loaded successfully
    Date: 7th Dec 2021*/
    public boolean verifyWorkflowDetailsSummaryHeader() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(verifyWorkflowDetailsHeader) && verifyWorkflowDetailsHeader.isDisplayed()) {
                base.highlightElement(verifyWorkflowDetailsHeader);
                status = true;
            } else {
                LOGGER.error("Unable to display the Workflow Details Header");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*Manish Kumar Jain
    Scenario: Verify Workflow Details summary loaded successfully
    Date: 7th Dec 2021*/
    public boolean verifyWorkflowDetailsSummarySubLabelDisplay() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(workflowDetailsSubLabelStarted) && workflowDetailsSubLabelStarted.isDisplayed()) {
                base.highlightElement(workflowDetailsSubLabelStarted);
                status = true;
            } else {
                LOGGER.error("Unable to display the Workflow Details Header");
            }

            if (base.checkIfELementIsAvailable(workflowDetailsSubLabelFinished) && workflowDetailsSubLabelFinished.isDisplayed()) {
                base.highlightElement(workflowDetailsSubLabelFinished);
                status = true;
            } else {
                LOGGER.error("Unable to display the Workflow Details Header");
            }

            if (base.checkIfELementIsAvailable(workflowDetailsSubLabelDuration) && workflowDetailsSubLabelDuration.isDisplayed()) {
                base.highlightElement(workflowDetailsSubLabelDuration);
                status = true;
            } else {
                LOGGER.error("Unable to display the Workflow Details Summary Sub Labels");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*Manish Kumar Jain
    Scenario: Verify Started Finished matched with Duration in Workflow Details summary
    Date: 9th Dec 2021*/
    public void verifyStartedFinishedDurationMatches() throws InterruptedException {
        String Started = null;
        String Finished = null;
        String Duration = null;

        if (base.checkIfELementIsAvailable(workflowDetails_StartedDateTime) && workflowDetails_StartedDateTime.isDisplayed()) {
            Started = driver.findElement(By.xpath(workflowDetails_StartedDateTimePath)).getText().substring(8, 27);
            System.out.println("Started time captured: " + Started);
            Thread.sleep(2000);
        }

        if (base.checkIfELementIsAvailable(workflowDetails_FinishedDateTime) && workflowDetails_FinishedDateTime.isDisplayed()) {
            Finished = driver.findElement(By.xpath(workflowDetails_FinishedDateTimePath)).getText().substring(9, 28);
            System.out.println("Finished time captured: " + Finished);
            Thread.sleep(2000);
        }

        if (base.checkIfELementIsAvailable(workflowDetails_DurationDateTime) && workflowDetails_DurationDateTime.isDisplayed()) {
            Duration = driver.findElement(By.xpath(workflowDetails_DurationDateTimePath)).getText().substring(9, 17);
            System.out.println("Duration time captured: " + Duration);
            Thread.sleep(2000);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        try {
            // parse method is used to parse the text from a string to produce the date
            Date d1 = sdf.parse(Started);
            Date d2 = sdf.parse(Finished);

            // Calculate time difference in milliseconds
            long difference_In_Time = d2.getTime() - d1.getTime();

            // Calculate time difference in seconds,minutes, hours, years, and days
            long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
            long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
            long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;

            System.out.print("Difference" + " between two dates is: ");
            String durationDiff = difference_In_Hours + ":" + difference_In_Minutes + ":" + difference_In_Seconds;
            System.out.println(durationDiff);

            Date d3 = sdf1.parse(durationDiff);
            Date d4 = sdf1.parse(Duration);
            long difference = d4.getTime() - d3.getTime();

            if (difference > 0)
                System.out.println("Actual Duration value is greater than the difference between Started & Finished call");
            else if (difference == 0)
                System.out.println("Actual Duration is equal to Started & Finished call difference");
            else
                System.out.println("Actual Duration is less than the difference between Started & Finished call");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*Manish Kumar Jain
    Scenario: Verify Started Finished Duration Matches in Workflow Details summary
    Date: 9th Dec 2021*/
    public boolean verifyAllLabelsUnderRADataSectionAndCustomerVulnerabilities() {
        String CustomerVulnerability = null;
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(RAData_Table) && RAData_Table.isDisplayed()) {
//                base.highlightElement(RAData_LengthOfRepairPath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_FaultReportedPath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_PartsOrderedPath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_PartsETAPath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_PartNamePath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_LastRAUpdatePath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_EstimatedTimeToCompleteRepairPath);
//                Thread.sleep(1000);
//                base.highlightElement(RAData_ApplianceTypePath);
//                Thread.sleep(1000);
                base.highlightElement(RAData_CustomerVulnerabilityLogged);
                Thread.sleep(1000);
                base.highlightElement(RAData_Vulnerabilites);
                Thread.sleep(1000);
                status = true;

                //CustomerVulnerability = driver.findElement(By.xpath("//div[@id=\"raData\"]//child::br[25]")).getAttribute("innerHTML");
                //CustomerVulnerability = driver.findElement(By.xpath("//*[@id=\"raData\"]/text()[9]")).getText();
                //CustomerVulnerability = driver.findElement(By.xpath("//div[@id='RepairSummaryOuter']/div[@id='RepairSummaryInner']/div[@id='raData']/br[25]")).getText().substring(32,34);
                //CustomerVulnerability=driver.findElement(By.xpath("//div[@id=\"raData\"]//child::br[25]")).getText()
                WebElement element = driver.findElement(By.xpath(RAData_CustomerVulnerabilityLoggedPath));
                CustomerVulnerability = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", element);
                System.out.println("Customer vulnerability with Yes or No: " + CustomerVulnerability);
                if (CustomerVulnerability == "Yes") {
                    System.out.println("Customer is vulnerable");
                } else {
                    System.out.println("Customer is non vulnerable");
                }

            } else {
                LOGGER.error("Unable to display the RA Data Table");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*Manish Kumar Jain
        Scenario: Verify new tab open with review claim page after clicking on Open claim button
        Date: 9th Dec 2021*/
    public void clickOnOpenClaimButton() {
        try {
            if (base.checkIfELementIsAvailable(verifyOpenClaimButton) && base.isClickable(verifyOpenClaimButton)) {
                base.clickWithJsExecutor(verifyOpenClaimButton);
            } else {
                LOGGER.error("Unable to navigate to the review claim page as button is not clickable");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Manish Kumar Jain
    Scenario: Enter Contact information for WB Plan
    Date: 7th July 2022
     */
    public void confirmContactInformationForWBPlan()
    {
        if(base.checkIfELementIsAvailable(WB_CustomerEmail))
        {
            driver.findElement(By.xpath(WB_CustomerEmailPath)).clear();
            base.sendFieldInputData(WB_CustomerEmail,"mmm@mail.com");
        }
        else
        {
            base.waitToLoadElement();
            driver.findElement(By.xpath(WB_CustomerEmailPath)).clear();
            base.sendFieldInputData(WB_CustomerEmail,"mmm@mail.com");
        }
        base.clickWithJsExecutor(contactContinueButton);
    }

    /*
    Manish Kumar Jain
    Scenario: Click on Booking Imcomplete Button
    Date: 8th July 2022
     */
    public void clickOnBookingIncompleteButton()
    {
        WebElement bookingIncomplete = driver.findElement(By.xpath("//div[@id='PlanView_PlanHistory_Content']//div[@class='bg-gradient'][contains(text(),'BOOKING INCOMPLETE')]"));
        base.clickWithJsExecutor(bookingIncomplete);
    }

    /*
    Manish Kumar Jain
    Scenario: Click on the open claim no. in the Plan History section
    Date: 8th July 2022
     */
    public void clickOnOpenClaimNoLinkInPlanHistory()
    {
        WebElement openClaimLink = driver.findElement(By.xpath("//div[@id='PlanHistory_Claims']//table[@class='table']//tbody/tr[1]/td[1]/a"));
        base.clickWithJsExecutor(openClaimLink);
    }

    /*
    Manish Kumar Jain
    Scenario: Click on the Open Claim button in the Inflight Repair Summary
    Date: 8th July 2022
     */
    public void clickOnOpenClaimButtonInInflightRepairSummary()
    {
        WebElement openClaimButton = driver.findElement(By.xpath("//div[@id='InflightRepairs_Header']//a[@id='OpenClaimBtn']"));
        base.clickWithJsExecutor(openClaimButton);
    }

    /*
        Manish Kumar Jain
        Scenario: Click on the Customer Contact button in plan view
        Date: 25th August 2022
         */
    public void clickOnCustomerContactButtonInPlanView()
    {
        WebElement customerContactButton = driver.findElement(By.xpath("//div[@id='PlanView_StartNew_Content']//div[@id='ActionTypeHolder']//div[@id='BookingType_CC']"));
        base.clickWithJsExecutor(customerContactButton);
    }

    public boolean cancelJobFromUI(String planNo) throws Exception {
        boolean status = false;
        if (commonUtils.getOpenClaimsIfNotCancelled(planNo) != null) {
            status = true;
            base.navigateToPage(base.prop.getProperty("cancelJob") + commonUtils.getOpenClaimNo(planNo));
            bookingOverviewPage.cancelClaimOnly();
            if (!bookingOverviewPage.isJobStatusUpdated("cancelled")) {
                base.waitForPageToLoad();
            }
        }
        return status;

    }

    public void clickOnDnGLogoForNPV() {
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



}
