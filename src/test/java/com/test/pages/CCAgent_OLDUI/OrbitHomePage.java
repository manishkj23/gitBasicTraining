package com.test.pages.CCAgent_OLDUI;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.nio.charset.Charset;

public class OrbitHomePage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private static final String PLAN_WRITE_OFF = "Plan Write Off";
    @FindBy(xpath = "//img[@alt=\"Create Claim\"]")
    private WebElement createClaim;

    @FindBy(xpath = "//div[@class=\"sidr_tab_text\"][(contains(.,\"Search\"))]")
    private WebElement searchTab;

    @FindBy(xpath = "//input[@id=\"jobnoSearch\"]")
    private WebElement claimNumber;

    @FindBy(xpath = "//img[contains(@onclick,\"goToSearchJob\")]")
    private WebElement claimSearchIcon;

    @FindBy(xpath = "//*[@id=\"centrex-menu\"]//button[contains(@onclick,\"ScottishPowerScorecard\")]")
    private WebElement scoreCardUrl;

    @FindBy(xpath = "//*[@id=\"centrex-menu\"]//button[contains(@onclick,\"siteMap\")]")
    private WebElement siteMapButton;

    @FindBy(xpath = "//*[@id=\"JobTypeID_42\"]/img[contains(@alt,\"Create Claim\")]")
    private WebElement createClaimButton;

    @FindBy(xpath = "//div[@id=\"jbTpDet\"]/div//table//tr[contains(.,\"Service Options\")]")
    private WebElement clickServiceOptionsTab;

    @FindBy(xpath = "//div[@id=\"jbTpDet\"]/div//table//tr[contains(.,\"Review Claim\")]")
    private WebElement clickReviewClaimTab;

    @FindBy(xpath = "//div[@id=\"jbTpDet\"]/div//table//tr[contains(.,\"Claim Analysis\")]")
    private WebElement clickClaimAnalysisTab;

    @FindBy(xpath = "//*[@id=\"jobSearch\"]")
    private WebElement planNumberSearchInput;

    @FindBy(xpath = "//*[@id=\"jobSearchForm\"]//div[contains(.,\"Plan Number\")]/img")
    private WebElement planNumberSearchButton;

    private final String currentClaimNumberXpath = "//*[@id=\"matches_table\"]/tbody/tr[1]/td[1]";
    @FindBy(xpath = currentClaimNumberXpath)
    private WebElement currentClaimNumber;

    private final String currentMatchedClaimNumberXpath = "//*[@id=\"matches_table\"]/tbody/tr[contains(.,\"${value}\")]/td[1]";
    @FindBy(xpath = currentMatchedClaimNumberXpath)
    private WebElement currentMatchedClaimNumber;

    @FindBy(xpath = "//*[@id=\"menuContainer\"]//label[contains(.,\"Report Generator\")]")
    private WebElement reportGeneratorMenu;

    @FindBy(xpath = "//table[@id=\"reportTable\"]/tbody/tr[1]")
    private WebElement  tableContainsReports;

    @FindBy(xpath = "//*[@class=\"DTTT_button DTTT_button_text\"]/span[contains(.,\"Run\")]")
    private WebElement runReportButton;

    @FindBy(xpath = "//a[@class=\"btnConfirm\" and @id=\"run\"]")
    private WebElement runReportButtonLevel2;

    @FindBy(id="dateFrom")
    private WebElement reportFromDate;

    @FindBy(id="dateTo")
    private WebElement reportDateTo;

    @FindBy(xpath = "//label[@for=\"jobDateBooked\"]")
    private WebElement filterByJobDateBooked;

    @FindBy(xpath = "//div[@id=\"reportTable_filter\"]//input")
    private WebElement reportSearchFilterInput;

    @FindBy(xpath = "//a[@id=\"run\"]")
    private WebElement runBtn;

    //Colour and Capacity :
    @FindBy(xpath = "//*[@id=\"LoadColorCapacityDetails\"]/div[1]/span/input")
//    @FindBy(xpath = "//select[@id=\"color\"]")
    private WebElement colourOfProduct;

    @FindBy(xpath = "//input[@id=\"Capacity\"]")
    private WebElement capacityOfProduct;

    //Customer Info :
    @FindBy(xpath = "//input[@name=\"CustEmail\"]")
    private WebElement customerEmail;

    @FindBy(xpath = "//input[@id=\"confirmContactEmail\"]")
    private WebElement confirmEmail;

    @FindBy(xpath = "//input[@id=\"CustPhone\"]")
    private WebElement customerPhone;

    @FindBy(xpath = "//input[@id=\"confirmContactPhone\"]")
    private WebElement confirmContactPhone;

    @FindBy(xpath = "//input[@id=\"CustMobile\"]")
    private WebElement customerMobile;

    @FindBy(xpath = "//input[@id=\"confirmContactMobile\"]")
    private WebElement confirmMobilePhone;

    @FindBy(xpath="//div[@id=\"centrex-menu\"]//button[contains(@onclick,\"planWriteOff\")]")
    private WebElement menuItem_PlanWriteOff;

    //Manish Kumar Jain
    //Added new Xpath for PNC related changes, Dated: 16th June 2021
    @FindBy(xpath = "//img[@id=\"logo\"]")
    private WebElement dAndgLogo;

    private static final String PNCPrePopulatesDropdownPath = "//input[@class='ui-state-default ui-combobox-input combopncNumber-input ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']";
    @FindBy(xpath = PNCPrePopulatesDropdownPath)
    private WebElement PNCPrePopulates;

    private static final String MLCodePrePopulatesTextBoxPath = "//input[@id='mlcCode']";
    @FindBy(xpath = MLCodePrePopulatesTextBoxPath)
    private WebElement MLPrePopulates;

    private static final String SNPrePopulatesTextBoxPath = "//input[@id='pncSerial']";
    @FindBy(xpath = SNPrePopulatesTextBoxPath)
    private WebElement SNPrePopulates;

    @FindBy(xpath = "//div[contains(text(),\"PNC Number\")]")
    private WebElement PNCSectionDisplayed;

    private static final String PNCRadioButton = "//*[@id=\"electroluxHolder\"]//p[@class='confirmPNR']//input[@type='radio' and @value='yes']";
    @FindBy(xpath = PNCRadioButton)
    private WebElement PNCRadioButtonYes;

    private static final String PNCDropDownClick = "//a[@class='combobutton ui-button ui-widget ui-state-default ui-button-icon-only ui-corner-right ui-combobox-toggle' and @title='Show All Items' ]//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']";
    @FindBy(xpath = PNCDropDownClick)
    private WebElement PNCNumberDropDownClick;

    private static final String CustomerPNCSection = "//p[contains(text(),'Can the customer provide the PNC Number?')]";
    @FindBy(xpath = CustomerPNCSection)
    private WebElement CustomerPNCSectionAvailable;

    private static final String PNCYesNoRadioButtonAvailable = "//body[contains(@class,'centrex-body')]/div[contains(@style,'')]/div[@id='container-main']/div/ul[@id='sectionsSortHolder']/li[@id='section_63']/form[@id='NewClaimForm']/div[@id='productConfirmDetails']/fieldset[contains(@class,'sortFieldset')]/div[@id='electroluxHolder']/div[contains(@style,'width: 100%;')]/div[contains(@style,'float: left; width: 47%;')]/p[2]";
    @FindBy(xpath=PNCYesNoRadioButtonAvailable)
    private WebElement YesNoElementAvailable;

    @FindBy(xpath="//input[@id='jobnoSearch']")
    private WebElement claimNumberSearchInput;

    @FindBy(xpath = "//div[@style='float:left; margin-bottom: 10px; width: 100%;']//img[@onclick='goToSearchJob();']")
    private WebElement claimNumberSearchButton;

    @FindBy(xpath = "(//div/button/span[@class='label '])[3]")
    private WebElement PlanWriteOffButton;
    @FindBy(xpath = "//div/input[@id='pwoCustomer']")
    private WebElement CustomerSurname;


    @FindBy(xpath = "//div[@id='PlanView_PlanData_Content']/table[@id='PlanView_PlanData_Table']/tbody/tr[6]/td[2]")
    private WebElement planViewMake;

    @FindBy(xpath = "//div[@id=\"totalIconsDisplsy\"]//div[@class=\"ClassHotSpotTitle\"]/span[contains(.,'Flagged Risk Claims')]")
    private WebElement flaggedRiskClaimsHotspot;

    @FindBy(xpath = "//div[@class=\"sortableSection\"]/fieldset[@id=\"frdChkFldSt\"]")
    private WebElement flaggedRiskClaimsHotspotGrid;

    @FindBy(xpath = "//div[@id=\"FraudCheck_filter\"]/label/input")
    private WebElement searchReferredClaimInflaggedRiskClaimsHotspot;

    @FindBy(xpath = "//table[@id=\"FraudCheck\"]/tbody/tr/td[1]")
    private WebElement referredClaimNo;


    public OrbitHomePage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public void navigateToReportGenerator() {
        if (base.isClickable(siteMapButton)) {
            base.clickWithJsExecutor(siteMapButton);

            if (!base.checkIfELementIsAvailable(reportGeneratorMenu)) {
                base.hardWait("2000");
            }
            if (base.isClickable(reportGeneratorMenu)) {
                base.clickWithJsExecutor(reportGeneratorMenu);
            }
        } else {
            base.waitForPageToLoad();
            base.checkIfELementIsAvailable(siteMapButton);
            if (base.isClickable(siteMapButton)) {
                base.clickWithJsExecutor(siteMapButton);
            }
            if (!base.checkIfELementIsAvailable(reportGeneratorMenu)) {
                base.hardWait("2000");
            }
            if (base.isClickable(reportGeneratorMenu)) {
                base.clickWithJsExecutor(reportGeneratorMenu);
            }
        }


    }

    public boolean isReportGenertorSectionLoaded() {
        boolean status = false;
        try {
            base.hardWait("3000");
            if (base.checkIfELementIsAvailable(tableContainsReports)) {
                base.highlightElement(tableContainsReports);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(tableContainsReports)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(tableContainsReports)) {
                    base.highlightElement(tableContainsReports);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }

    public void clickPlanWriteOffMenu(){
        try{
            if (base.checkIfELementIsAvailable(menuItem_PlanWriteOff)){
                base.clickElement(menuItem_PlanWriteOff);
            } else {
                LOGGER.info("Unable to click the PlanWriteOff Menu Item");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean checkRunReportGeneratorReport() {
        boolean status = false;
        try {
            base.hardWait("2000");
            if (base.checkIfELementIsAvailable(tableContainsReports) && base.isClickable(runReportButton)) {
                base.clickWithJsExecutor(tableContainsReports);
                base.isClickable(runReportButton);
                base.clickWithJsExecutor(runReportButton);
                base.hardWait("2000");
                if (base.checkIfELementIsAvailable(runReportButtonLevel2)) {
                    base.scrollToElement(runReportButtonLevel2);
                    base.highlightElement(runReportButtonLevel2);
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void runReportGeneratorReport(String repName, String dateFrom, String dateTo) {

        try {
            base.hardWait("2000");
            if (base.checkIfELementIsAvailable(tableContainsReports) && base.isClickable(runReportButton)) {
                base.waitTillElementFound(reportSearchFilterInput);
                base.sendFieldInputData(reportSearchFilterInput,repName);
                base.clickWithJsExecutor(tableContainsReports);
                base.isClickable(runReportButton);
                base.clickWithJsExecutor(runReportButton);
                base.hardWait("2000");
                if (base.checkIfELementIsAvailable(runReportButtonLevel2)) {
                    base.waitForPageToLoad();
                    base.waitTillElementFound(filterByJobDateBooked);
                    base.clickElement(filterByJobDateBooked);
                    base.isElementAvailable(reportFromDate);
                    base.isClickable(reportFromDate);
                    base.sendFieldInputData(reportFromDate,dateFrom);
                    seleniumHelper.pressEnterAction();
                    base.isElementAvailable(reportDateTo);
                    base.isClickable(reportDateTo);
                    base.sendFieldInputData(reportDateTo,dateTo);
                    seleniumHelper.pressEnterAction();
                    base.isClickable(runBtn);
                    base.hardWait("2000");
                    base.clickElement(runBtn);


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void clickServiceOptionsTab() {
        base.waitTillElementFound(clickServiceOptionsTab);
        base.clickElement(clickServiceOptionsTab);
    }

    public void clickReviewClaimTab() {
        if (!base.checkIfELementIsAvailable(clickReviewClaimTab)) {
            base.hardWait("2000");
        }
        base.waitTillElementFound(clickReviewClaimTab);
        base.clickElement(clickReviewClaimTab);
    }

    public void clickClaimAnalysisTab() {
        if (!base.checkIfELementIsAvailable(clickClaimAnalysisTab)) {
            base.hardWait("2000");
        }
        base.waitTillElementFound(clickClaimAnalysisTab);
        base.clickElement(clickClaimAnalysisTab);
    }

    public boolean isHomePageLoaded() {
        try {
            base.waitForPageToLoad();
            base.waitTillElementFound(createClaim);
            base.highlightElement(createClaim);
            LOGGER.info("==============>>>>>> Login Page Verified with valid credentials");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (createClaim.isDisplayed()) ? true : false;
    }

    public void clickCreateClaim() {
        try {
            base.waitForElementVisible(createClaimButton);
            if (base.checkIfELementIsAvailable(createClaimButton) & base.isClickable(createClaimButton)) {
                base.clickWithJsExecutor(createClaimButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to click Create Claim icon");
        }
    }

    public void clickSiteMap() {
        try {
            base.waitForElementVisible(siteMapButton);
            if (base.checkIfELementIsAvailable(siteMapButton) & base.isClickable(siteMapButton)) {
                base.clickWithJsExecutor(siteMapButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to click SiteMap");
        }
    }

    public void searchForAClaimUsingPlanNo(String planNo) {
        try {
            base.waitForElementVisible(planNumberSearchInput);
            if (base.checkIfELementIsAvailable(planNumberSearchInput) & base.isClickable(planNumberSearchInput)) {
                base.sendFieldInputData(planNumberSearchInput, planNo);
                Thread.sleep(2000);
                base.clickWithJsExecutor(planNumberSearchButton);
                Thread.sleep(2000);
//                if (base.getElementFromXpath(currentClaimNumberXpath) != null) {
                WebElement currentExistingClaimNumber = seleniumHelper.getCustomElementByXpath(currentMatchedClaimNumberXpath, commonUtils.getOpenClaimNo(planNo));
                if (currentExistingClaimNumber != null) {
//                    base.highlightElement(currentClaimNumber);
//                    seleniumHelper.doubleClickElement(currentClaimNumber);

                    base.highlightElement(currentExistingClaimNumber);
                    seleniumHelper.doubleClickElement(currentExistingClaimNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to load the Claim Number");
        }
    }

    public void enterColourAndCapacity(String colour, String capacity) {
        if (base.checkIfELementIsAvailable(colourOfProduct) && base.checkIfELementIsAvailable(capacityOfProduct)) {
            base.sendFieldInputData(colourOfProduct, colour);
            base.sendFieldInputData(capacityOfProduct, capacity);
            base.waitToLoadElement();
            base.waitForPageToLoad();

        } else {
            LOGGER.error("Colour and Capacity were not entered");
        }


    }

    public boolean verifyTheColourAndCapacityIsEntered() {
        boolean status = false;
        try {
            if (capacityOfProduct != null && !capacityOfProduct.getText().isEmpty()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterCustomerContactDetails(String email, String phone, String mobile) {

        try {
            if (base.checkIfELementIsAvailable(customerEmail) && customerEmail.getAttribute("value").isEmpty()) {
                base.sendFieldInputData(customerEmail, email);
                base.clickElement(confirmEmail);
            } else if (base.checkIfELementIsAvailable(customerEmail) && !customerEmail.getAttribute("value").isEmpty()) {
                base.clickElement(confirmEmail);
            } else {
                LOGGER.error("Unable to enter the Customer Email");
            }

            if (base.checkIfELementIsAvailable(customerPhone) && customerPhone.getAttribute("value").isEmpty()) {
                base.sendFieldInputData(customerPhone, phone);
                base.clickElement(confirmContactPhone);
            } else if (base.checkIfELementIsAvailable(customerPhone) && !customerPhone.getAttribute("value").isEmpty()) {
                base.clickElement(confirmContactPhone);
            } else {
                LOGGER.error("Unable to enter the Customer Phone");
            }


            if (base.checkIfELementIsAvailable(customerMobile) && customerMobile.getAttribute("value").isEmpty()) {
                base.sendFieldInputData(customerMobile, phone);
                base.clickElement(confirmMobilePhone);
            } else if (base.checkIfELementIsAvailable(customerMobile) && !customerMobile.getAttribute("value").isEmpty()) {
                base.clickElement(confirmMobilePhone);
            } else {
                LOGGER.error("Unable to enter the Customer Mobile Phone");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //<Manish> Click on D and G logo to launch the createClaim page again.
    //Dated: 14-06-2021
    //Changes part of SRV 9173 user stories.
    public void clickOnDnGLogo() {
        try {
            base.waitForElementVisible(dAndgLogo);
            if (base.checkIfELementIsAvailable(dAndgLogo) & base.isClickable(dAndgLogo)) {
                base.highlightElement(dAndgLogo);
                base.clickWithJsExecutor(dAndgLogo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to click on D and G logo");
        }
    }

    //<Manish> Verify PNC pre-populates for the plan having claim history in orbit under Confirm Product Detail section .
    //Dated: 21-06-2021
    //Changes part of SRV 9173 user stories.
    public void verifyPncPrePopulates() {
        try {
            base.waitForElementVisible(CustomerPNCSectionAvailable);
            if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvailable(PNCRadioButtonYes)) {
                if (PNCPrePopulates != null) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement inpElement = driver.findElement(By.xpath(PNCPrePopulatesDropdownPath));
                    String pncNumber = (String) js.executeScript("return arguments[0].value", inpElement);
                    System.out.println("PNC value pre-populates " + pncNumber);
                    LOGGER.info("=====> PNC values pre-populate in the dropdown" + pncNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyMlCodePrePopulates() {
        try {
            base.waitForElementVisible(CustomerPNCSectionAvailable);
            if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvailable(MLPrePopulates)) {
                if (MLPrePopulates != null) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement inpElement = driver.findElement(By.xpath(MLCodePrePopulatesTextBoxPath));
                    String mlCodeNumber = (String) js.executeScript("return arguments[0].value", inpElement);
                    System.out.println("ML Code value pre-populates " + mlCodeNumber);
                    LOGGER.info("=====> ML code Pre populates for the plan" + mlCodeNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifySNPrePopulates() {
        try {
            base.waitForElementVisible(CustomerPNCSectionAvailable);
            if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvailable(SNPrePopulates)) {
                if (SNPrePopulates != null) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement inpElement = driver.findElement(By.xpath(SNPrePopulatesTextBoxPath));
                    String snNumber = (String) js.executeScript("return arguments[0].value", inpElement);
                    System.out.println("Serial Number value pre-populates " + snNumber);
                    LOGGER.info("=====> Serial Number value Pre populates for the plan" + snNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnPncRadioButton() throws InterruptedException {
        base.waitForElementVisible(CustomerPNCSectionAvailable);
        if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvailable(YesNoElementAvailable)) {
            Thread.sleep(3000);
            WebElement radioElement = driver.findElement(By.xpath(PNCRadioButton));
            String javascript = "arguments[0].click()";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(javascript, radioElement);
            Thread.sleep(3000);
        }

    }

    /*
    Name: Manish Kumar Jain
    Date: 17th Nov
    Scenario: Search for a claim using Claim No.
     */
    public void searchForAClaimUsingClaimNo(String ClaimNo) {
        try {
            base.waitForElementVisible(claimNumberSearchInput);
            if (base.checkIfELementIsAvailable(claimNumberSearchInput) & base.isElementAvailable(claimNumberSearchInput)) {
                base.sendFieldInputData(claimNumberSearchInput, ClaimNo);
                Thread.sleep(3000);
            }
            base.waitTillElementFound(claimNumberSearchButton);
            if(base.checkIfELementIsAvailable(claimNumberSearchButton) & base.isElementAvailable(claimNumberSearchButton)) {
                base.clickWithJsExecutor(claimNumberSearchButton);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to load the Review claim page for the given Claim Number");
        }
    }


    public void navigateTSiteMap() {
        if (base.isClickable(siteMapButton)) {
            base.clickWithJsExecutor(siteMapButton);

        } else {
            base.waitForPageToLoad();
            base.checkIfELementIsAvailable(siteMapButton);
            if (base.isClickable(siteMapButton)) {
                base.clickWithJsExecutor(siteMapButton);
            }

        }
    }

    public boolean isReportGeneratorPageDisplayed(String value) {
        return true;
    }

    public boolean clickPlanWriteOffButton() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(PlanWriteOffButton) && PlanWriteOffButton.getText().equalsIgnoreCase(PLAN_WRITE_OFF)) {
                base.highlightElement(PlanWriteOffButton);
                Thread.sleep(3000);
                base.clickElement(PlanWriteOffButton);
                status = true;
            } else {
                LOGGER.error("Unable to click on Plan Write Off button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public void isMakeWhplMBOrNonWhplMB(String make)
    {
        if(base.checkIfELementIsAvailable(planViewMake))
        {
            String getManufacturerValue = planViewMake.getText().substring(5);
            LOGGER.info("Manufacturer Name is: " + getManufacturerValue);
        }

    }

    /*
        Name: Supriya Ramesh
        Scenario: Update WHP tracking file
        Method to update the defined column in the tracking file
     */
    public void updateWHPTrackingFile(String column, String value) throws IOException {
        File filePath = new File("src/test/resources/WhirlpoolTrackingFile/WHP_Tracking_File.csv");
        File inputFile = new File(filePath.getAbsolutePath());
        CSVReader reader = new CSVReader(new FileReader(inputFile), ';');
        List<String[]> csvBody = reader.readAll();
        for(int row=3; row<= csvBody.size()-3;row++)
        {
            for(int col=0; col<= csvBody.get(row).length;col++)
            {
                String cellValue = csvBody.get(2)[col];
                if (cellValue.equals(column)) {
                    csvBody.get(row)[col] = value;
                    break;
                }
            }
        }
        reader.close();
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ';', CSVWriter.NO_QUOTE_CHARACTER);
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    /*
    Name: Supriya Ramesh
    Scenario: Update WHP Exchange file
    Method to update the defined column in the WHP Exchange file
     */
    public void updateWHPExchangeFile(String column, String value) throws IOException {

        File filePath = new File("src/test/resources/WhirlpoolTrackingFile/WHP_Exchange_File.txt");
        File inputFile = new File(filePath.getAbsolutePath());
        CSVReader reader = new CSVReader(new FileReader(inputFile), '|');
        List<String[]> csvBody = reader.readAll();
        for(int row=1; row<= csvBody.size()-1;row++)
        {
            for(int col=0; col<= csvBody.get(row).length-1;col++)
            {
                String cellValue = csvBody.get(0)[col];
                if (cellValue.trim().contains(column.trim())) {
                    csvBody.get(row)[col] = value;
                    break;
                }
            }
        }
        reader.close();
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), '|', CSVWriter.NO_QUOTE_CHARACTER);
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    public void clickFlaggedRiskClaimsHotspot() {
        if (base.isClickable(flaggedRiskClaimsHotspot)) {
            base.clickWithJsExecutor(flaggedRiskClaimsHotspot);

        } else {
            base.waitForPageToLoad();
            base.checkIfELementIsAvailable(flaggedRiskClaimsHotspot);
            if (base.isClickable(flaggedRiskClaimsHotspot)) {
                base.clickWithJsExecutor(flaggedRiskClaimsHotspot);
            }

        }
    }

    public boolean isFlaggedRiskClaimsHotspotGridLoaded() {
        boolean status = false;
        base.waitForElementVisible(flaggedRiskClaimsHotspotGrid);
        if(base.checkIfELementIsAvailable(flaggedRiskClaimsHotspotGrid)) {
            base.highlightElement(flaggedRiskClaimsHotspotGrid);
            status = true;
        }
        else{
            LOGGER.info("Flagged Risk Claims Grid isn't loaded");

        }
        return status;
    }

//    public void searchReferredClaimInRiskClaimsHotspot(String planNo) {
//
//            base.waitForElementVisible(searchUsingPlanNoInflaggedRiskClaimsHotspot);
//            base.checkIfELementIsAvailable(searchUsingPlanNoInflaggedRiskClaimsHotspot) ;
//            base.sendFieldInputData(searchUsingPlanNoInflaggedRiskClaimsHotspot,planNo);
//        base.sendFieldInputData(searchUsingPlanNoInflaggedRiskClaimsHotspot,planNo);
//
//    }


    public boolean isReferredClaimDisplayed() {
        boolean status = false;
        base.waitForElementVisible(referredClaimNo);
        if (base.checkIfELementIsAvailable(referredClaimNo)){
            base.highlightElement(referredClaimNo);
            LOGGER.info("Referred claim number is updated on Risk claims hotspot : " + (referredClaimNo.getText()));
            status = true;
        }
        else{
            LOGGER.info("==============>>>>>> Unable to search referred claim");
        }
        return status;
    }


    public void searchReferredClaimInRiskClaimsHotspot(String ClaimNo) {
        try {
            base.waitForElementVisible(searchReferredClaimInflaggedRiskClaimsHotspot);
            if (base.checkIfELementIsAvailable(searchReferredClaimInflaggedRiskClaimsHotspot) & base.isElementAvailable(searchReferredClaimInflaggedRiskClaimsHotspot)) {
                base.sendFieldInputData(searchReferredClaimInflaggedRiskClaimsHotspot, ClaimNo);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to load the Review claim page for the given Claim Number");
        }
    }
}