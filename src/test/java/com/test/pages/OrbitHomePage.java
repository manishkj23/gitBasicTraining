package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrbitHomePage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//img[@alt=\"Create Claim\"]")
    WebElement createClaim;

    @FindBy(xpath = "//div[@class=\"sidr_tab_text\"][(contains(.,\"Search\"))]")
    WebElement searchTab;

    @FindBy(xpath = "//input[@id=\"jobnoSearch\"]")
    WebElement claimNumber;

    @FindBy(xpath = "//img[contains(@onclick,\"goToSearchJob\")]")
    WebElement claimSearchIcon;

    @FindBy(xpath = "//*[@id=\"centrex-menu\"]//button[contains(@onclick,\"ScottishPowerScorecard\")]")
    WebElement scoreCardUrl;

    @FindBy(xpath = "//*[@id=\"centrex-menu\"]//button[contains(@onclick,\"siteMap\")]")
    WebElement siteMapButton;

    @FindBy(xpath = "//*[@id=\"JobTypeID_42\"]/img[contains(@alt,\"Create Claim\")]")
    WebElement createClaimButton;

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

    @FindBy(xpath = "//*[@id=\"matches_table\"]/tbody/tr[1]/td[1]")
    private WebElement currentClaimNumber;

//    @FindBy(xpath = "//*[@id=\"menu\"]//button[contains(.,\"Site\") and contains(.,\"Map\")]")
//    private WebElement siteMapButton;

    @FindBy(xpath = "//*[@id=\"menuContainer\"]//label[contains(.,\"Report Generator\")]")
    private WebElement reportGeneratorMenu;

    @FindBy(xpath = "//table[@id=\"reportTable\"]/tbody/tr[1]")
    private WebElement tableContainsReports;

    @FindBy(xpath = "//*[@class=\"DTTT_button DTTT_button_text\"]/span[contains(.,\"Run\")]")
    private WebElement runReportButton;

    @FindBy(xpath = "//a[@class=\"btnConfirm\" and @id=\"run\"]")
    private WebElement runReportButtonLevel2;

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
            LOGGER.info("======>>>>> Unable to click Create Claim icon");
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
            LOGGER.info("======>>>>> Unable to click SiteMap");
        }
    }

    public void searchForAClaimUsingPlanNo(String planNo) {
        try {
            base.waitForElementVisible(planNumberSearchInput);
            if (base.checkIfELementIsAvailable(planNumberSearchInput) & base.isClickable(planNumberSearchInput)) {
                base.sendFieldInputData(planNumberSearchInput, planNo);
                base.clickWithJsExecutor(planNumberSearchButton);
                if (base.checkIfELementIsAvailable(currentClaimNumber)) {
                    base.highlightElement(currentClaimNumber);
                    seleniumHelper.doubleClickElement(currentClaimNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to load the Claim Number");
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
    public void verifyPncPrePopulates()
    {
        try
        {
            base.waitForElementVisible(CustomerPNCSectionAvailable);
            if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvilable(PNCRadioButtonYes)) {
                if (PNCPrePopulates != null)
                {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement inpElement = driver.findElement(By.xpath(PNCPrePopulatesDropdownPath));
                    String pncNumber = (String) js.executeScript("return arguments[0].value", inpElement);
                    System.out.println("PNC value pre-populates " + pncNumber);
                    LOGGER.info("=====> PNC values pre-populate in the dropdown" + pncNumber);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //<Manish> Verify PNC pre-populates for the plan having claim history in orbit under Confirm Product Detail section .
    //Dated: 24-06-2021
    //Changes part of SRV 9173 user stories.
    public void verifyMlCodePrePopulates()
    {
        try
        {
            base.waitForElementVisible(CustomerPNCSectionAvailable);
            if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvilable(MLPrePopulates)) {
                if (MLPrePopulates != null)
                {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement inpElement = driver.findElement(By.xpath(MLCodePrePopulatesTextBoxPath));
                    String mlCodeNumber = (String) js.executeScript("return arguments[0].value", inpElement);
                    System.out.println("ML Code value pre-populates " + mlCodeNumber);
                    LOGGER.info("=====> ML code Pre populates for the plan" + mlCodeNumber);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //<Manish> Verify PNC pre-populates for the plan having claim history in orbit under Confirm Product Detail section .
    //Dated: 24-06-2021
    //Changes part of SRV 9173 user stories.
    public void verifySNPrePopulates()
    {
        try
        {
            base.waitForElementVisible(CustomerPNCSectionAvailable);
            if (base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvilable(SNPrePopulates)) {
                if (SNPrePopulates != null)
                {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement inpElement = driver.findElement(By.xpath(SNPrePopulatesTextBoxPath));
                    String snNumber = (String) js.executeScript("return arguments[0].value", inpElement);
                    System.out.println("Serial Number value pre-populates " + snNumber);
                    LOGGER.info("=====> Serial Number value Pre populates for the plan" + snNumber);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //<Manish> Verify PNC pre-populates for the plan having claim history in orbit under Confirm Product Detail section .
    //Dated: 24-06-2021
    //Changes part of SRV 9173 user stories.
    public void clickOnPncRadioButton() throws InterruptedException
    {
        base.waitForElementVisible(CustomerPNCSectionAvailable);
        if(base.checkIfELementIsAvailable(CustomerPNCSectionAvailable) & base.isElementAvilable(YesNoElementAvailable))
        {
            Thread.sleep(3000);
            WebElement radioElement = driver.findElement(By.xpath(PNCRadioButton));
            String javascript = "arguments[0].click()";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(javascript, radioElement);
            Thread.sleep(3000);
        }
    }

    public void searchForAClaimUsingClaimNo(String ClaimNo) {
        try {
            base.waitForElementVisible(claimNumberSearchInput);
            if (base.checkIfELementIsAvailable(claimNumberSearchInput) & base.isElementAvilable(claimNumberSearchInput)) {
                base.sendFieldInputData(claimNumberSearchInput, ClaimNo);
                Thread.sleep(3000);
            }
            base.waitTillElementFound(claimNumberSearchButton);
            if(base.checkIfELementIsAvailable(claimNumberSearchButton) & base.isElementAvilable(claimNumberSearchButton)) {
                base.clickWithJsExecutor(claimNumberSearchButton);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("======>>>>> Unable to load the Review claim page for the given Claim Number");
        }
    }


}

