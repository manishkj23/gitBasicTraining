package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class SiteMapPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    @FindBy(xpath = "//*[@id=\"centrex-menu\"]//button[contains(@onclick,\"siteMap\")]")
    WebElement siteMapButton;

    @FindBy(xpath = "//input[@id=\"SearchKey\"][@name=\"SearchKey\"]")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"menuContainer\"]/div/span/p[contains(.,\"SMS Messages\")]")
    WebElement smsMessagesWizard;

    @FindBy(xpath = "//*[@id=\"menuContainer\"]/div/span/p[contains(.,\"Email Messages\")]")
    WebElement emailMessagesWizard;

    private static final String useRedEyeLabelXPathSms = "//*[@id=\"smsForm\"]//label[contains(.,\"Use RedEye\")]";
    private static final String useRedEyeLabelXPathEmail = "//label[contains(.,\"Use RedEye\")]";
    @FindBy(xpath = useRedEyeLabelXPathSms)
    WebElement useRedEyeLabelSms;

    @FindBy(xpath = "//table[@id=\"smsResults\"]/tbody/tr")
    List<WebElement> smsResultsSet;

    @FindBy(xpath = "//table[@id=\"emailMessagesResults\"]/tbody/tr/td[2]")
    List<WebElement> emailResultsSet;

    @FindBy(xpath = "//label[contains(.,\"Send To CCM\")]")
    WebElement updatePage;

    @FindBy(xpath = "//*[@id=\"cancel_btn\"]")
    WebElement cancelButton;

    private static String pathToSmsMessagesConfigRule = "//*[@id=\"smsResults\"]//tr[contains(.,\"${value}\")]";
    private static String pathToEmailMessagesConfigRule = "//*[@id=\"emailMessagesResults\"]//tr[contains(.,\"${value}\")]";

    @FindBy(xpath = "//p[contains(text(),'ASV/LSC Dashboard')]")
    WebElement clickASVLSCDashboardPane;

    @FindBy(xpath = "//p[contains(text(),'Service Providers')]")
    WebElement dg_clickOnServiceProvidersWizard;

    @FindBy(xpath = "//div[@class='AdminItemPanel']//p[@class='secondParaSA']")
    WebElement clickDAndGCustomReportDashboardPane;

    @FindBy(xpath = "//legend[contains(text(),'Dashboard ASV/LSC')]")
    WebElement pageASVLSCDashboard;

    @FindBy(xpath = "//button[@id='filterSearchBtn']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@id='saveNewGroupBtn']")
    WebElement saveAsNewGroupBtn;

    @FindBy(xpath = "//button[@id='updateGroupBtn']")
    WebElement updateGroupBtn;

    @FindBy(xpath = "//button[contains(text(),'YTD')]")
    WebElement YTDBtn;

    @FindBy(xpath = "//div[@id='fsDashboard_filter']//label//input[@type='text' and @aria-controls='fsDashboard']")
    WebElement searchWithinResultTxtBox;

    @FindBy(xpath = "//input[@id='dateBooked']")
    WebElement dateBookedRadioBtn;

    @FindBy(xpath = "//input[@id='dateReleased']")
    WebElement dateReleasedRadioBtn;

    @FindBy(xpath = "//input[@id='showAllClaims']")
    WebElement showAllClaimsCheckbox;

    @FindBy(xpath = "//label[@for='dateBooked']")
    WebElement dateBookedLabel;

    @FindBy(xpath = "//label[@for='dateReleased']")
    WebElement dateReleasedLabel;

    @FindBy(xpath = "//label[@for='showAllClaims']")
    WebElement showAllClaimsLabel;

    @FindBy(xpath = "//input[@id='dateBooked']")
    WebElement dateBookedRadioButton;

    @FindBy(xpath = "//button[contains(text(),'MTD')]")
    WebElement mtdButtonAutoSelect;

    @FindBy(xpath = "//div[@class='DTTT_container']")
    WebElement dtttContainerFiveButtons;

    private final String reassignSPButtonPath = "//a[@id='ToolTables_fsDashboard_1']//span[contains(text(),'Reassign SP')]";
    @FindBy(xpath = reassignSPButtonPath)
    WebElement reassignSPButton;

    private final String deemedDoneButtonPath = "//a[@id='ToolTables_fsDashboard_2']//span[contains(text(),'Deemed Done')]";
    @FindBy(xpath = deemedDoneButtonPath)
    WebElement deemedDoneButton;

    private final String cancelClaimButtonPath = "//a[@id='ToolTables_fsDashboard_3']//span[contains(text(),'Cancel')]";
    @FindBy(xpath = cancelClaimButtonPath)
    WebElement cancelClaimButton;

    @FindBy(xpath = "//th[contains(text(),'Business Partner ID')]")
    WebElement newColumnBusinessPartnerId;

    @FindBy(xpath = "//th[contains(text(),'ISU Contract ID')]")
    WebElement newColumnIsuContractId;

    private final String dgCustomReportFormPath = "//form[@id='dgCustReportForm']";
    @FindBy(xpath = dgCustomReportFormPath)
    WebElement dgCustomReportForm;

    private final String dgCustomReport_ReportTypeFieldPath = "//label[contains(text(),'Report Type')]";
    @FindBy(xpath = dgCustomReport_ReportTypeFieldPath)
    WebElement dgCustomReport_ReportTypeField;

    private final String dgCustomReport_ReportTypeDropdownPath = "//select[@id='reportType']";
    @FindBy(xpath = dgCustomReport_ReportTypeDropdownPath)
    WebElement dgCustomReport_ReportTypeDropdown;

    private final String dgCustomReport_dateFromInputPath = "//select[@id='reportType']";
    @FindBy(xpath = dgCustomReport_dateFromInputPath)
    WebElement dgCustomReport_dateFromInput;

    //input[@id='DateFrom']

    private final String dgServiceProvider_FormPath = "//form[@id='ServiceProvidersTopForm']//legend[contains(text(),'Service Providers')]";
    @FindBy(xpath = dgServiceProvider_FormPath)
    WebElement dgServiceProvider_Form;


    private final String dgServiceProvider_TableGridPath = "//table[@id='ServiceProvidersResults']";
    @FindBy(xpath = dgServiceProvider_TableGridPath)
    WebElement dgServiceProvider_TableGrid;

    private final String dgServiceProvider_CompanyNamePath = "//table[@id='ServiceProvidersResults']//thead//tr[@id='filterRow']/th[1]/span[1]/input[1]";
    @FindBy(xpath = dgServiceProvider_CompanyNamePath)
    WebElement dgServiceProvider_CompanyName;

    private final String dgServiceProvider_clickFirstRowPath = "//table[@id='ServiceProvidersResults']//tbody[contains(@role,'alert')]//tr[1]/td[1]";
    @FindBy(xpath = dgServiceProvider_clickFirstRowPath)
    WebElement dgServiceProvider_clickFirstRow;

    private final String dgServiceProvider_clickOnEditButtonPath = "//button[@id='updateButtonId']//span[contains(text(),'Edit')]";
    @FindBy(xpath = dgServiceProvider_clickOnEditButtonPath)
    WebElement dgServiceProvider_clickOnEditButton;

    private final String dgServiceProvider_UpdateServiceProviderPath = "//fieldset[@id='SPFormFieldset']//legend[contains(text(),'Update Service Provider')]";
    @FindBy(xpath = dgServiceProvider_UpdateServiceProviderPath)
    WebElement dgServiceProvider_UpdateServiceProvider;

    private final String dgServiceProvider_newIndicatorPath = "//label[contains(text(),'Always Block Bookings Without Appt:')]";
    @FindBy(xpath = dgServiceProvider_newIndicatorPath)
    WebElement dgServiceProvider_newIndicator;

    private final String dgServiceProvider_newIndicatorYesRadioButtonPath = "//div[@id='Dynamictabs-1']//p/input[@type='radio'][@name='BlockBookingWithoutAppt'][@value='Yes']";
    @FindBy(xpath = dgServiceProvider_newIndicatorYesRadioButtonPath)
    WebElement dgServiceProvider_newIndicatorYesRadioButton;

    private final String dgServiceProvider_newIndicatorNoRadioButtonPath = "//div[@id='Dynamictabs-1']//p/input[@type='radio'][@name='BlockBookingWithoutAppt'][@value='No']";
    @FindBy(xpath = dgServiceProvider_newIndicatorNoRadioButtonPath)
    WebElement dgServiceProvider_newIndicatorNoRadioButton;

    private final String dgServiceProvider_SaveButtonPath = "//input[@id='ValidateBtn'][@value='Save']";
    @FindBy(xpath = dgServiceProvider_SaveButtonPath)
    WebElement dgServiceProvider_SaveButton;

    private final String dgServiceProvider_OkButtonPath = "//input[@id='cancel_btn'][@value='Ok'][@type='submit']";
    @FindBy(xpath = dgServiceProvider_OkButtonPath)
    WebElement dgServiceProvider_OkButton;

    private final String dgDashboardFilterGroup_DashboardPath = "//legend[contains(text(),'Dashboard Filter Group')]";
    @FindBy(xpath = dgDashboardFilterGroup_DashboardPath)
    WebElement dgDashboardFilterGroup_Dashboard;

    private final String dgDashboardFilterGroup_wizardPath = "//p[contains(text(),'Dashboard Filter')]";
    @FindBy(xpath = dgDashboardFilterGroup_wizardPath)
    WebElement dgDashboardFilterGroup_wizard;

    private final String dgDashboardFilterGroup_insertButtonPath = "//button[contains(text(),'Insert')]";
    @FindBy(xpath = dgDashboardFilterGroup_insertButtonPath)
    WebElement dgDashboardFilterGroup_insertButton;

    private final String dgDashboardFilterGroup_saveButtonPath = "//form[@id='DashboardFilterGroupForm']//span[@class='bottomButtons']//button[@id='save_btn']";
    @FindBy(xpath = dgDashboardFilterGroup_saveButtonPath)
    WebElement dgDashboardFilterGroup_saveButton;

    private final String dgDashboardFilterGroup_groupNameErrorPath = "//p[@class='hideClassFormGen']//label[@class='fieldError'][contains(.,'Group Name')]";
    @FindBy(xpath = dgDashboardFilterGroup_groupNameErrorPath)
    WebElement dgDashboardFilterGroup_groupNameError;

    private final String dgDashboardFilterGroup_dashboardErrorPath = "//label[@id='DashboardIDError'][contains(.,'least 1 Dashboard')][@class='customFieldError']";
    @FindBy(xpath = dgDashboardFilterGroup_dashboardErrorPath)
    WebElement dgDashboardFilterGroup_dashboardError;

    private final String dgDashboardFilterGroup_dashboardDropdownPath = "//div[@id='DashboardFilterGroupFormPanel']/form[@id='DashboardFilterGroupForm']/fieldset/p[4]/button[1]/span[1]";
    @FindBy(xpath = dgDashboardFilterGroup_dashboardDropdownPath)
    WebElement dgDashboardFilterGroup_dashboardDropdown;

    private final String dgDashboardFilterGroup_dashboardDropdownSelectOptionPath = "//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//input[@id='ui-multiselect-DashboardID-option-0']";
    @FindBy(xpath = dgDashboardFilterGroup_dashboardDropdownSelectOptionPath)
    WebElement dgDashboardFilterGroup_dashboardDropdownSelectOption;





    public SiteMapPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isSmsMessagesWizardDisplayed() {
        try {
            base.waitForPageToLoad();
            base.waitTillElementFound(smsMessagesWizard);
            base.highlightElement(smsMessagesWizard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (smsMessagesWizard.isDisplayed()) ? true : false;
    }

    public boolean isEmailMessagesWizardDisplayed() {
        try {
            base.waitForPageToLoad();
            base.waitTillElementFound(emailMessagesWizard);
            base.highlightElement(emailMessagesWizard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (emailMessagesWizard.isDisplayed()) ? true : false;
    }

    public boolean isSmsMessagesPageLoaded() {
        boolean status = false;
        try {
            if (smsResultsSet.size() > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isEmailMessagesPageLoaded() {
        boolean status = false;
        try {
            if (emailResultsSet.size() > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean smsCheckRedEyeNotExist() {
        boolean status = true;
        try {
            Iterator<WebElement> record = smsResultsSet.iterator();
            while (record.hasNext()) {
                WebElement messageRow = record.next();
                if (messageRow != null) {
                    base.highlightElement(messageRow);
                    seleniumHelper.doubleClickElement(messageRow);
                    base.waitTillElementFound(updatePage);
                    base.highlightElement(updatePage);
                    seleniumHelper.captureScreeshot();
                    if (base.getElementByXpathJS(useRedEyeLabelXPathSms) != null) {
//                        base.highlightElement();
                        status = false;
                        break;
                    }
                    base.clickWithJsExecutor(cancelButton);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    public boolean emailCheckRedEyeNotExist() {
        boolean status = true;
        try {
            Iterator<WebElement> record = emailResultsSet.iterator();
            while (record.hasNext()) {
                WebElement messageRow = record.next();
                if (messageRow != null) {
                    base.highlightElement(messageRow);
                    seleniumHelper.doubleClickElement(messageRow);
                    base.waitTillElementFound(updatePage);
                    base.highlightElement(updatePage);
                    seleniumHelper.captureScreeshot();
                    if (base.getElementByXpathJS(useRedEyeLabelXPathEmail) != null) {
                        status = false;
                        break;
                    }
                    base.clickWithJsExecutor(cancelButton);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    public boolean isSiteMapPageLoaded() {
        boolean status = false;
        try {
            if (searchBox.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void searchAndClickConfigWizard(String value) {
        try {
            if (value.contains("SMS")) {
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(smsMessagesWizard);
                base.clickWithJsExecutor(smsMessagesWizard);
                base.waitForPageToLoad();

            } else if (value.contains("EMAIL")) {
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(emailMessagesWizard);
                base.clickWithJsExecutor(emailMessagesWizard);
                base.waitForPageToLoad();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*Manish Kumar Jain, Dated: 2nd July 2021,
    ASV/LSC Dashboard Changes part of R31 SRV 5124*/
    public void searchAndClickWizard(String value) {
        try {
            if (value.contains("ASV/LSC")) {
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(clickASVLSCDashboardPane);
                base.clickWithJsExecutor(clickASVLSCDashboardPane);
                base.waitForPageToLoad();
            } else if (value.contains("D&G Custom Report")) {
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(clickDAndGCustomReportDashboardPane);
                base.clickWithJsExecutor(clickDAndGCustomReportDashboardPane);
                base.waitForPageToLoad();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Manish Kumar Jain, Dated: 2nd July 2021,
    ASV/LSC Dashboard Changes part of R31 SRV 5124*/
    public boolean isAsvLscDashboardLoaded() {
        boolean status = false;
        try {
            if (pageASVLSCDashboard.isDisplayed()) {
                base.highlightElement(pageASVLSCDashboard);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*Manish Kumar Jain, Dated: 2nd July 2021,
    ASV/LSC Dashboard Changes part of R31 SRV 5124*/
    public boolean isAllButtonAndBoxEnabled() {
        boolean status = false;
        try {
            if (dateBookedLabel.isDisplayed()) {
                base.highlightElement(dateBookedLabel);
                status = true;
            }
            Thread.sleep(2000);
            if (dateReleasedLabel.isDisplayed()) {
                base.highlightElement(dateReleasedLabel);
                status = true;
            }
            Thread.sleep(2000);
            if (showAllClaimsLabel.isDisplayed()) {
                base.highlightElement(showAllClaimsLabel);
                status = true;
            }
            Thread.sleep(2000);
            if (searchWithinResultTxtBox.isDisplayed()) {
                base.highlightElement(searchWithinResultTxtBox);
                status = true;
            }
            Thread.sleep(2000);
            if (YTDBtn.isEnabled()) {
                base.highlightElement(YTDBtn);
                status = true;
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /*Manish Kumar Jain, Dated: 2nd July 2021,
    ASV/LSC Dashboard Changes part of R31 SRV 5124*/
    public boolean isDateBookedRadioButtonMTDButtonSelected() {
        boolean status = false;
        try {
            if (dateBookedRadioButton.isSelected()) {
                base.highlightElement(dateBookedRadioButton);
                status = true;
            } else {
                base.clickElement(dateBookedRadioButton);
                Thread.sleep(2000);
            }
            if (mtdButtonAutoSelect.isEnabled()) {
                base.highlightElement(mtdButtonAutoSelect);
                status = true;
            } else {
                base.clickElement(mtdButtonAutoSelect);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /* Manish Kumar Jain, Dated: 31st August 2021,
    ASV/LSC Dashboard Changes part of R33
    SRV 2649 - ASV - Scottish Power Identifiers - ASV Operational Dashboard */
    public boolean verifyTwoNewColumnAddedInAsvDashboard() {
        boolean status = false;
        try {
            if (base.waitForElementVisible(newColumnBusinessPartnerId) && base.checkIfELementIsAvailable(newColumnBusinessPartnerId)) {
                base.highlightElement(newColumnBusinessPartnerId);
                status = true;
            }
            if (base.waitForElementVisible(newColumnIsuContractId) && base.checkIfELementIsAvailable(newColumnIsuContractId)) {
                base.highlightElement(newColumnIsuContractId);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean verifyReassignSPDeemedDoneCancelButtonEnabled() {
        boolean status = false;
        if (base.checkIfELementIsAvailable(dtttContainerFiveButtons) && base.waitForElementVisible(dtttContainerFiveButtons)) {
            try {
                if (reassignSPButton.isEnabled()) {
                    base.highlightElement(reassignSPButton);
                    status = true;
                }
                Thread.sleep(2000);
                if (deemedDoneButton.isEnabled()) {
                    base.highlightElement(deemedDoneButton);
                    status = true;
                }
                Thread.sleep(2000);
                if (cancelClaimButton.isEnabled()) {
                    base.highlightElement(cancelClaimButton);
                    status = true;
                }
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

//    public void clickCreateClaim() {
//        try {
//            base.waitForElementVisible(createClaimButton);
//           if(base.checkIfELementIsAvailable(createClaimButton) & base.isClickable(createClaimButton)){
//               base.clickWithJsExecutor(createClaimButton);
//           }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.info("======>>>>> Unable to click Create Claim icon");
//        }
//    }

    /* Manish Kumar Jain, Dated: 13th December 2021,
    Inflight Repair Report
    SRV-11317 Inflight Repair Contact Reporting */
    public void verifyDGCustomReportForm() {
        if (base.waitForElementVisible(dgCustomReportForm) && base.isElementAvilable(dgCustomReportForm)) {
            base.highlightElement(dgCustomReportForm);
            System.out.println("D&G Custom Report pop up displayed successfully");
        } else {
            base.waitForPageToLoad();
            base.highlightElement(dgCustomReportForm);
            System.out.println("D&G Custom Report pop up displayed successfully after sometime");
        }
    }

    /* Manish Kumar Jain, Dated: 13th December 2021,
    Inflight Repair Report
    SRV-11317 Inflight Repair Contact Reporting */
    public void verifyReportTypeAndDropdownDisplayed() {
        if (base.waitForElementVisible(dgCustomReport_ReportTypeField) && base.isElementAvilable(dgCustomReport_ReportTypeDropdown)) {
            base.highlightElement(dgCustomReport_ReportTypeField);
            base.highlightElement(dgCustomReport_ReportTypeDropdown);
            System.out.println("Report Type and Dropdown are available in D&G Custom Report");
        } else {
            System.out.println("D&G Custom Report pop up is not displayed");
        }
    }

    /* Manish Kumar Jain, Dated: 13th December 2021,
    Inflight Repair Report
    SRV-11317 Inflight Repair Contact Reporting */
    public void clickOnReportTypeDropdownAndVerifyInFlightReport(String inFlightDropdownValue) {
        if (base.waitForElementVisible(dgCustomReport_ReportTypeDropdown)) {
            base.highlightElement(dgCustomReport_ReportTypeDropdown);
            Select inFlightDropdown = new Select((driver.findElement(By.xpath(dgCustomReport_ReportTypeDropdownPath))));
            inFlightDropdown.selectByVisibleText(inFlightDropdownValue);
            System.out.println("Able to select the value from the dropdown");
        } else {
            System.out.println("D&G Custom Report pop up is not displayed");
        }
    }


    /* Manish Kumar Jain, Dated: 29th June 2022,
    Searech for the Service Provider and click on the wizard
    SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void searchAndClickonServiceProviderWizard(String value) {
        try {
            if (value.contains("Service")) {
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(dg_clickOnServiceProvidersWizard);
                base.clickWithJsExecutor(dg_clickOnServiceProvidersWizard);
                base.waitForPageToLoad();
            } else {
                base.waitForPageToLoad();
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(dg_clickOnServiceProvidersWizard);
                base.clickWithJsExecutor(dg_clickOnServiceProvidersWizard);
                base.waitForPageToLoad();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* Manish Kumar Jain, Dated: 29th June 2022,
    Verify Service Provider page displayed successfully.
    SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void verifyServiceProviderForm() {
        if (base.waitForElementVisible(dgServiceProvider_Form)) {
            base.highlightElement(dgServiceProvider_Form);
            LOGGER.info("Service Provider page loaded successfully");
        } else {
            base.waitForPageToLoad();
            base.highlightElement(dgServiceProvider_Form);
            LOGGER.info("Service Provider wizard takes time to load the page");
        }
    }

    /* Manish Kumar Jain, Dated: 29th June 2022,
    Verify Service Provider page displayed successfully.
    SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public boolean isServiceProviderPageDisplayed() {

        boolean status = false;
        try {
            if (dgServiceProvider_Form.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /* Manish Kumar Jain, Dated: 29th June 2022,
    Enter Company name and click on the row
    SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void enterCompanyNameInTheServiceProviderGrid(String companyName) {
        if (base.waitForElementVisible(dgServiceProvider_TableGrid) && base.checkIfELementIsAvailable(dgServiceProvider_TableGrid)) {
            base.sendFieldInputData(dgServiceProvider_CompanyName, companyName);
        } else {
            base.waitToLoadElement();
            base.sendFieldInputData(dgServiceProvider_CompanyName, companyName);
        }

    }

    /* Manish Kumar Jain, Dated: 29th June 2022,
    Enter Company name and click on the row
    SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void clickOnTheRowInTheServiceProviderGrid() throws InterruptedException {
        if (base.waitForElementVisible(dgServiceProvider_TableGrid) && base.checkIfELementIsAvailable(dgServiceProvider_TableGrid)) {
            base.highlightElement(dgServiceProvider_clickFirstRow);
            base.clickWithJsExecutor(dgServiceProvider_clickFirstRow);
        } else {
            base.waitToLoadElement();
            base.highlightElement(dgServiceProvider_clickFirstRow);
            base.clickWithJsExecutor(dgServiceProvider_clickFirstRow);
        }
        Thread.sleep(3000);
        base.clickWithJsExecutor(dgServiceProvider_clickOnEditButton);

    }

    /* Manish Kumar Jain, Dated: 30th June 2022,
       Verify the new indicator is present in the form
       SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void verifyNewIndicatorUpdateServiceProvider() {
        if (base.waitForElementVisible(dgServiceProvider_UpdateServiceProvider) && base.checkIfELementIsAvailable(dgServiceProvider_UpdateServiceProvider)) {
            base.highlightElement(dgServiceProvider_newIndicator);
            LOGGER.info("New Indicator is present in the Service Provider form");
        } else {
            base.waitToLoadElement();
            base.highlightElement(dgServiceProvider_newIndicator);
        }
        String newIndicator = driver.findElement(By.xpath(dgServiceProvider_newIndicatorPath)).getText();
        System.out.println("New indicator is present in the SP form: " + newIndicator);
    }


    /* Manish Kumar Jain, Dated: 30th June 2022,
       Verify the new indicator is present in the form
       SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public boolean clickOnYesRadioButtonToSetNewIndicator() {
        boolean status = false;
        try {
            if (dgServiceProvider_newIndicatorYesRadioButton.isSelected()) {
                status = true;
            }
            else
            {
                base.highlightElement(dgServiceProvider_newIndicatorYesRadioButton);
                base.clickWithJsExecutor(dgServiceProvider_newIndicatorYesRadioButton);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /* Manish Kumar Jain, Dated: 30th June 2022,
       Click on Save and Ok button in the form
       SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void clickOnSaveButtonInServiceProviderForm() throws InterruptedException {
        if(base.waitForElementVisible(dgServiceProvider_SaveButton))
        {
            base.highlightElement(dgServiceProvider_SaveButton);
            base.clickWithJsExecutor(dgServiceProvider_SaveButton);
        }
        else
        {
            base.waitToLoadElement();
            base.highlightElement(dgServiceProvider_SaveButton);
            base.clickWithJsExecutor(dgServiceProvider_SaveButton);
        }
        Thread.sleep(3000);
        base.highlightElement(dgServiceProvider_OkButton);
        base.clickWithJsExecutor(dgServiceProvider_OkButton);
    }

    /* Manish Kumar Jain, Dated: 8th July 2022,
       Verify the new indicator is present in the form: Click on No button
       SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public boolean clickOnNoRadioButtonToSetNewIndicator() {
        boolean status = false;
        try {
            if (dgServiceProvider_newIndicatorNoRadioButton.isSelected()) {
                base.highlightElement(dgServiceProvider_newIndicatorNoRadioButton);
                status = true;
            }
            else
            {
                base.highlightElement(dgServiceProvider_newIndicatorNoRadioButton);
                base.clickWithJsExecutor(dgServiceProvider_newIndicatorNoRadioButton);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /* Manish Kumar Jain, Dated: 29th June 2022,
        Searech for the Service Provider and click on the wizard
        SRV-13266 - WB Integration - Prevent claims without appointment being booked */
    public void searchAndClickonDashboardWizard(String value) {
        try {
            if (base.checkIfELementIsAvailable(searchBox)) {
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(dgDashboardFilterGroup_wizard);
                base.clickWithJsExecutor(dgDashboardFilterGroup_wizard);
                base.waitForPageToLoad();
            } else {
                base.waitForPageToLoad();
                base.sendFieldInputData(searchBox, value);
                base.isElementAvilable(dgDashboardFilterGroup_wizard);
                base.clickWithJsExecutor(dgDashboardFilterGroup_wizard);
                base.waitForPageToLoad();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Manish Kumar Jain, Dated: 12th July 2022,
        Click on Insert button in Dashboard Filter Group page
        SRV-10472 - Dynamic Refresh Upgrade */
    public void clickOnInsertButtonInDashboardFilterGroup() throws InterruptedException {
        base.waitForPageToLoad();
        base.clickWithJsExecutor(dgDashboardFilterGroup_insertButton);
        Thread.sleep(3000);
    }

    /* Manish Kumar Jain, Dated: 12th July 2022,
        Click on Insert button in Dashboard Filter Group page
        SRV-10472 - Dynamic Refresh Upgrade */
    public void clickOnSaveButtonInDashboardFilterGroup() throws InterruptedException {
        base.waitForPageToLoad();
        base.clickWithJsExecutor(dgDashboardFilterGroup_saveButton);
        Thread.sleep(3000);
    }

    /*Manish Kumar Jain, Dated: 12th July 2022,
    Dashboard Filter group error message validation part of R40 release
    CR :--- SRV-10472 - Dynamic Refresh Upgrade*/
    public boolean isDashboardFilterGroupPageLoaded() {
        boolean status = false;
        try {
            if (dgDashboardFilterGroup_Dashboard.isDisplayed()) {
                base.highlightElement(dgDashboardFilterGroup_Dashboard);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /* Manish Kumar Jain, Dated: 12th July 2022,
        Click on Insert button in Dashboard Filter Group page
        SRV-10472 - Dynamic Refresh Upgrade */
    public void verifyErrorMessageInDashboardFilterGroup() throws InterruptedException {
        if(base.checkIfELementIsAvailable(dgDashboardFilterGroup_groupNameError) && base.waitForElementVisible(dgDashboardFilterGroup_dashboardError))
        {
            base.highlightElement(dgDashboardFilterGroup_groupNameError);
            String groupNameError = driver.findElement(By.xpath(dgDashboardFilterGroup_groupNameErrorPath)).getText();
            LOGGER.info("Group name error displayed: " + groupNameError);
            Thread.sleep(3000);
            base.highlightElement(dgDashboardFilterGroup_dashboardError);
            String DashboardFilterError = driver.findElement(By.xpath(dgDashboardFilterGroup_dashboardErrorPath)).getText();
            LOGGER.info("Group name error displayed: " + DashboardFilterError);
            Thread.sleep(3000);
        }
        else
        {
            base.waitTillElementFound(dgDashboardFilterGroup_groupNameError);
            base.highlightElement(dgDashboardFilterGroup_groupNameError);
            String groupNameError = driver.findElement(By.xpath(dgDashboardFilterGroup_groupNameErrorPath)).getText();
            LOGGER.info("Group name error displayed: " + groupNameError);
            Thread.sleep(3000);
            base.highlightElement(dgDashboardFilterGroup_dashboardError);
            String DashboardFilterError = driver.findElement(By.xpath(dgDashboardFilterGroup_dashboardErrorPath)).getText();
            LOGGER.info("Group name error displayed: " + DashboardFilterError);
            Thread.sleep(3000);

        }
    }


    /* Manish Kumar Jain, Dated: 27th July 2022,
    Click on Dashboards dropdown and select ASV option
    SRV-10472 - Dynamic Refresh Upgrade */
    public void clickOnDashboardsDropdown() throws InterruptedException {
        Thread.sleep(5000);
        base.clickWithJsExecutor(dgDashboardFilterGroup_dashboardDropdown);
        Thread.sleep(3000);
        base.checkIfELementIsAvailable(dgDashboardFilterGroup_dashboardDropdownSelectOption);
        base.clickWithJsExecutor(dgDashboardFilterGroup_dashboardDropdownSelectOption);
        base.clickOutside();
        Thread.sleep(3000);
    }

    /* Manish Kumar Jain, Dated: 27th July 2022,
    Verify error message disappear in the Dashboard dropdown
    SRV-10472 - Dynamic Refresh Upgrade */
    public void verifyErrorMessageDisappearInDashboardsDropdown() throws InterruptedException {
        if(dgDashboardFilterGroup_dashboardError.getText().isEmpty())
            LOGGER.info("Error Message disappear");
        else{
            LOGGER.info("Error message is not disappear");
        }
    }




}
