package com.test.pages.CCAgentUI_NPV;

import com.test.pages.CCAgentUI_NPV.ExcessPaymentNPV.ExcessPaymentDue;
import com.test.pages.CCAgent_OLDUI.ServiceOptionsPage;
import com.test.pages.CCAgent_OLDUI.ServiceProviderAvailabilityPopup;
import com.test.pages.ExcessPayment.CallOutChargePaymentPage;
import com.test.pages.ExcessPayment.PaymentDuePopup;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ServiceOptionsPageNPV {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private ServiceProviderAvailabilityPopup availabilityPopup;
    private ExcessPaymentDue excessPaymentDue;
    private CallOutChargePaymentPage callOutChargePaymentPage;
    private PaymentDuePopup paymentDuePopup;
    private ServiceOptionsPage serviceOptionsPage;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ServiceOptionsPageNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, ServiceProviderAvailabilityPopup availabilityPopup, ExcessPaymentDue excessPaymentDue,
                                 CallOutChargePaymentPage callOutChargePaymentPage, PaymentDuePopup paymentDuePopup) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.availabilityPopup = availabilityPopup;
        this.excessPaymentDue = excessPaymentDue;
        this.callOutChargePaymentPage = callOutChargePaymentPage;
        this.paymentDuePopup = paymentDuePopup;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(.,\"Waive Charge\")]")
    private WebElement waiveExcessChargeSection;

    @FindBy(id = "ServiceOptionsTable")
    private WebElement serviceOptionsTable;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Service Option Message\")]/td[4]/input")
    private WebElement additonalInformation_ServiceOptionMessageCheckbox;

    @FindBy(xpath = "//div[@id='ServiceOptionsMainDiv']//table[@id=\"ServiceOptionsTable3\"]//td[4]/input[@class='IcServiceOptionProcessID'][@type='checkbox']")
    private List<WebElement> servOptions;

    @FindBy(xpath = "//*[@id=\"ServiceProviderIframe\"]")
    private WebElement serviceProviderDetailsIframe;

    private final String currentSPNameDynamicXpath = "//div[@class=\"ApTabContent\"][@style!=\"display:none\"]//span[@id=\"CompanyName\"][contains(.,\"${value}\")]";
    private final String currentSPNameXpath = "//div[@class=\"ApTabContent\"][@style=\"\"]//span[@id=\"CompanyName\"]";
    @FindBy(xpath = currentSPNameXpath)
    private WebElement currentAllocatedServiceProviderName;

    private final String firstAvailableDateXpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][1]";
    @FindBy(xpath = firstAvailableDateXpath)
    private WebElement firstAvailableDate;

    private final String waiveExcessPaymentPath = "//*[@id=\"ExcessPaymentTable\"]/tbody/tr/td[contains(.,\"Payment has been waived\")]";
    @FindBy(xpath = waiveExcessPaymentPath)

    private WebElement waiveExcessPayment;
    private final String availabilityPopupXpath = "//*[@id=\"modP\"]";
    private final String serviceProviderSelectionByName = "//*[@id=\"AllocatedSpRadiobuttons\"]//span[contains(.,\"${value}\")]/../label/input";


    private final String excessPayOptionPath = "//*[@id=\"ExcessPaymentTable\"]/tbody/tr[contains(.,\"Payment is required in order to complete the booking of this claim\")]/td[4]";
    @FindBy(xpath = excessPayOptionPath)
    private WebElement excessPayOption;

    @FindBy(xpath = "//button[contains(.,\"Confirm Option Details\")]")
    private WebElement confirmOptionDetailsButton;

    @FindBy(xpath = "//button[contains(.,\"Place On-hold\")]")
    private WebElement placeOnHoldButton;

    @FindBy(xpath = "//textarea[@id=\"IcqAutosetClaimStatusNote\" and @placeholder=\"RA Notes\"]")
    private WebElement onHoldTextArea;

    @FindBy(xpath = "//*[@id=\"CallBackForm\"]//button[contains(.,\"Save\")]")
    private WebElement onHoldTextAreaSaveButton;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Book without Appointment\")]")
    private WebElement confirmWithoutAnAppointmentButton;


    @FindBy(xpath = "//*[@id=\"confirmJobServiceOptionBtn\"]")
    private WebElement confirmServiceOptionButton;

    @FindBy(xpath = "//table[@id=\"ExcessPaymentTable\"]//tr[contains(.,\"Payment Required\")]/td[4]/input")
    private WebElement paymentRequiredCheckbox;

    private final String WB_noAvailabilityOkButtonPath = "//div[@class='ui-dialog-buttonset']//button[@type='button'][contains(text(),'OK')]";
    @FindBy(xpath = WB_noAvailabilityOkButtonPath)
    private WebElement WB_noAvailabilityOkButton;

    private final String WB_noAvailabilityPopUpPath = "//span[@id='ui-id-2'][@class='ui-dialog-title ui_Alert'][contains(text(),'Worcester Bosch No Availability')]";
    @FindBy(xpath = WB_noAvailabilityPopUpPath)
    private WebElement WB_noAvailabilityPopUp;

    private final String WB_notEligibleWarningPopUpPath = "//div[contains(@class,\"ui_Warning\")]";
    @FindBy(xpath = WB_notEligibleWarningPopUpPath)
    private WebElement WB_notEligibleWarningPopUp;

    private final String WB_notEligibleServiceProviderTextPopUpPath = "//div[@id='modP'][@class='ui-dialog-content ui-widget-content'][contains(.,'without an Appointment')]";
    @FindBy(xpath = WB_notEligibleServiceProviderTextPopUpPath)
    private WebElement WB_notEligibleServiceProviderTextPopUp;

    private final String WB_warningPopUpCloseButtonPath = "//div[contains(@class,'ui_Warning')]//button[contains(.,'Close')]";
    @FindBy(xpath = WB_warningPopUpCloseButtonPath)
    private WebElement WB_warningPopUpCloseButton;

    @FindBy(xpath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Error']")
    private WebElement availabilityErrorMessagePopUp;

    @FindBy(xpath = "//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//div[@class='ui-dialog-buttonset']//button[contains(text(),'Alright!')]")
    private WebElement availabilityErrorMessagePopUpButton;

    @FindBy(xpath = "//div[@id=\"spNoAvailabilityMessage\"]//p")
    private WebElement noAvailabilityMessage;

    @FindBy(xpath = ".//table[@id='Allocations']//tbody/tr/td[2]")
    private List<WebElement> rows;

    @FindBy(xpath = "//*[@id=\"ServiceOptionsMainDiv\"]/div//button[@onclick=\"viewRules();\"]")
    private WebElement viewRuleButton;

    @FindBy(xpath = "//*[@id='cboxLoadedContent']//table[@id='Allocations']")
    private WebElement allocationRuleTable;

    @FindBy(xpath = "//table[@id=\"Allocations\"]/thead/tr/th[@class='Overflow']")
    private WebElement overFlowRuleColumn;

    @FindBy(xpath = "//*[@id=\"Overflow\"]/thead/tr/th[@class='Overflow Rule ID']")
    private WebElement overFlowRuleID;

    @FindBy(xpath = "//div[@id=\"cboxContent\"]//table[@id=\"Allocations\"]/tbody/tr[1]/td[2]")
    private WebElement allocationRuleID;

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]/span/button[contains(text(),'Close')]")
    private WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"Allocations\"]/tbody/tr/td[3]")
    private WebElement serviceOptionsCol;

    @FindBy(xpath = "//*[@id='cboxLoadedContent']//table[@id='Overflow']")
    private WebElement overFlowRuleTable;

    @FindBy(xpath = "//div[@id=\"spWarrantyRepairMessageDiv\"]")
    private WebElement spWarrantyMessage;

    @FindBy(xpath = "//div[@id=\"spWarrantyRepairMessageDiv\"]/span/button[contains(.,'Override')]")
    private WebElement overrideButton;

    @FindBy(xpath = "//select[@id=\"OverrideReason\"]/..//input")
    private WebElement overrideReasonInputField;

    @FindBy(xpath = "//div//button[@class='btnStandardInsert'][contains(.,'Proceed')]")
    private WebElement clickOnProceed;

    @FindBy(xpath = "//div[@id=\"parSpDiv1\"]/span[contains(.,'FLYINGTOOLBOX RESPOND')]")
    private WebElement blockedSP;

    private final String primarySPfirstAvailableDateXpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][1]";
    @FindBy(xpath = primarySPfirstAvailableDateXpath)
    private WebElement primarySPfirstAvailableDate;

    @FindBy(xpath = "//div[@class=\"SpMapRadioBut\"]/span[contains(.,'FLYINGTOOLBOX 9')]")
    private WebElement ftb9;

    @FindBy(xpath = "//button[@id='callDynamicAvailabilityLoadingID']")
    private WebElement requestAvailabilityButton;

    private static final String allocationSP = "//*[@id='Allocations']/tbody/tr[contains(.,\"${value}\")]";
    private final String serviceOptions_emailAddressXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[2]";
    private final String serviceOptions_homeTelXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[2]";
    private final String serviceOptions_mobileNoXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[2]";
    private static final String availableServiceOptionXpath = "//*[@id=\"ServiceOptionsTable\"]//tr[contains(.,\"${value}\")]/td[4]";
    private static final String availableServiceOptionGetCostXpath = "//table[@id=\"ServiceOptionsTable\"]//tr[contains(.,\"${value}\")]/td[3]";
    public int serviceOptionCost = 0;
    private static final String CLOSE = "Close";
    private static final String colorOfPrimarySPAvailableDays_Orange = "rgba(255, 92, 2, 1)";

    public boolean isAdditionalInformationSectionDisplayed() {
        boolean status = false;
        try {
            if (additonalInformation_ServiceOptionMessageCheckbox.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isServiceProviderNameDisplayed(String sp) {
        boolean status = false;
        WebElement spNameDynamic = null;

        try {
            base.waitTillElementFound(serviceProviderDetailsIframe);
            if (!base.checkIfELementIsAvailable(serviceProviderDetailsIframe)) {
                base.waitTillElementFound(serviceProviderDetailsIframe);
            }
            driver.switchTo().frame(serviceProviderDetailsIframe);
            List<String> spList = Stream.of(sp.split(","))
                    .map(String::trim)
                    .collect(toList());
            for (String serviceProvider : spList) {

                spNameDynamic = seleniumHelper.getCustomElementByXpath(currentSPNameDynamicXpath, serviceProvider);
                if (base.checkIfELementIsAvailable(spNameDynamic) &&
                        (spNameDynamic.getText().toUpperCase().contains(serviceProvider))) {
                    base.highlightElement(spNameDynamic);
                    status = true;
                    break;
                }
            }

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isCalendarDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(base.getElementFromXpath(firstAvailableDateXpath))) {
                base.hardWait("3000");
                base.highlightElement(base.getElementFromXpath(firstAvailableDateXpath));
                base.getElementFromXpath(firstAvailableDateXpath).click();
                status = true;
            } else {

                for (int lp = 0; lp <= 3; lp++) {
                    base.hardWait("3000");
                    if (base.checkIfELementIsAvailable(base.getElementFromXpath(firstAvailableDateXpath))) {
                        base.highlightElement(base.getElementFromXpath(firstAvailableDateXpath));
                        base.getElementFromXpath(firstAvailableDateXpath).click();
                        status = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void selectFirstAvailableAppointmentDate() {
        base.waitTillElementFound(firstAvailableDate);
        base.clickWithJsExecutor(firstAvailableDate);
    }

    public void selectExcessPaymentToProcess() {
        WebElement excessPaymentCheckbox = null;
        try {
            excessPaymentCheckbox = base.getElementFromXpath(excessPayOptionPath);
            if (excessPaymentCheckbox != null && excessPaymentCheckbox.isEnabled()) {
                base.clickElement(excessPaymentCheckbox);
            }
        } catch (NoSuchElementException | java.util.NoSuchElementException el) {
            el.printStackTrace();
        }
    }

    public boolean isExcessPaymentWaivedOff() {
        boolean status = false;
        WebElement excessWaived = null;
        try {
            excessWaived = base.getElementFromXpath(waiveExcessPaymentPath);
            if (excessWaived != null && excessWaived.isDisplayed()) {
                status = true;
            }
        } catch (NoSuchElementException | java.util.NoSuchElementException el) {
            el.printStackTrace();
        }
        return status;
    }

    public boolean isServiceProverDisplayed(String sPName) {
        boolean status = false;
        try {
            WebElement el = seleniumHelper.getCustomElementByXpath(serviceProviderSelectionByName, sPName);
            if (el != null && el.isDisplayed()) {
                status = true;
                base.highlightElement(el);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void selectTheSeviceProvder(String spName) {

        try {
            if (isServiceProverDisplayed(spName)) {
                base.clickElement(seleniumHelper.getCustomElementByXpath(serviceProviderSelectionByName, spName));
            } else {
                // Pick the existing one
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void clickConfirmOptionDetailsButtonWithOutAppointment(String spName) {
        if (isServiceProverDisplayed(spName)) {
            selectTheSeviceProvder(spName);
        }
        base.waitTillElementFound(confirmOptionDetailsButton);
        base.clickWithJsExecutor(confirmOptionDetailsButton);
        base.waitForPageToLoad();
        if (base.checkIfELementIsAvailable(confirmWithoutAnAppointmentButton)) {
            base.waitTillElementFound(confirmWithoutAnAppointmentButton);
            base.clickWithJsExecutor(confirmWithoutAnAppointmentButton);
        }
        base.waitForPageToLoad();
    }

    public void clickConfirmOptionDetailsButtonForMobile(String spName) {
        base.clickWithJsExecutor(confirmOptionDetailsButton);
    }

    public boolean isConfirmOptionDetailsButtonDisplayed() {
        base.highlightElementWithScreenshot(confirmOptionDetailsButton, "ConfirmOptionDetails");
        return (base.isElementAvailable(confirmOptionDetailsButton)) ? true : false;
    }

    //Method : Select ServiceOption
    public void selectAvailableServiceOptionAndConfirm(String value) {
        WebElement serviceOption1 = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        base.clickWithJsExecutor(serviceOption1);
        base.highlightElementWithScreenshot(serviceOption1, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
        base.clickWithJsExecutor(confirmServiceOptionButton);
        base.waitForPageToLoad();
        if (excessPaymentDue.isExcessPaymentPageDisplayed()) {
            excessPaymentDue.takeExcessPayment();
            base.hardWait("3000");
            callOutChargePaymentPage.confirmPaymentSuccessfulPopup();
            base.hardWait("3000");
        } else if (paymentDuePopup.isPaymentDuePageLoaded()) {
            paymentDuePopup.takeServiceCostPayment();
            base.hardWait("3000");
            callOutChargePaymentPage.confirmPaymentSuccessfulPopup();
            base.hardWait("3000");
        } else {
            LOGGER.info("No payment page displayed & Service Option confirmed successfully");
        }
        WebElement serviceOption2 = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        if(!serviceOption2.isSelected()) {
            base.hardWait("9000");
            base.clickElement(serviceOption2);
            base.highlightElementWithScreenshot(serviceOption2, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
            base.clickWithJsExecutor(confirmServiceOptionButton);
            base.waitForPageToLoad();
        }
    }

    public void enterAdditionalInformation() {
        base.isClickable(additonalInformation_ServiceOptionMessageCheckbox);
        base.clickWithJsExecutor(additonalInformation_ServiceOptionMessageCheckbox);
    }

    public void enterAdditionalInformationAll() throws InterruptedException {
//        Thread.sleep(3000);
//        if(availabilityErrorMessagePopUp.isDisplayed() && base.checkIfELementIsAvailable(availabilityErrorMessagePopUp))
//        {
//            base.clickWithJsExecutor(availabilityErrorMessagePopUpButton);
//        }
//        else
//        {
//            LOGGER.info("Availability error message pop up not displayed and user clicked on service option checkbox ");
//        }
        for (WebElement option : servOptions) {
            base.isClickable(option);
//            base.clickWithJsExecutor(option);
            base.hardWait("1000");
            try {
//                base.clickElement(option);
                base.clickWithJsExecutor(option);
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                base.waitTillElementFound(option);
//                base.clickElement(option);
                base.clickWithJsExecutor(option);
            }

        }

    }

    public boolean isPaymentRequired() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(paymentRequiredCheckbox) && base.isClickable(paymentRequiredCheckbox)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void selectExcessPyment() {
        base.waitTillElementFound(paymentRequiredCheckbox);
        base.clickElement(paymentRequiredCheckbox);
    }

    public void confirmCalendarBooking(String spName) {
        if (!isCalendarDisplayed()) {
            base.hardWait("10000");
        }

    }

    /*
    Manish Kumar Jain
    Date: 8th July 2022
    Scenario: Select Service Option radio button and click on Confirm Service Option button
     */
    public void selectServiceOptionAndConfirm(String value) throws InterruptedException {
        String a_xpath = "//*[@id=\"ServiceOptionsTable\"]//tr[";
        String b_xpath = "]/td[1]";
        String c_path = "]/td[4]//input[contains(@type,'radio')]";

        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath(".//*[@id='ServiceOptionsTable_wrapper']//table[@id='ServiceOptionsTable']//th"));
        System.out.println("No of cols are : " + col.size());
        //No.of rows
        List<WebElement> rows = driver.findElements(By.xpath(".//table[@id='ServiceOptionsTable']//tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());

        for (int i = 1; i <= rows.size(); i++) {
            String serviceName = driver.findElement(By.xpath(a_xpath + i + b_xpath)).getText();
            System.out.println(serviceName);
            if (serviceName.contains(value)) {
                WebElement serviceRadioButton = driver.findElement(By.xpath(a_xpath + i + c_path));
                Thread.sleep(3000);
                base.clickWithJsExecutor(serviceRadioButton);
                Thread.sleep(3000);
                base.highlightElementWithScreenshot(serviceRadioButton, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
                base.clickWithJsExecutor(confirmServiceOptionButton);
            } else {
                base.waitToLoadElement();
                WebElement serviceRadioButton = driver.findElement(By.xpath(a_xpath + i + c_path));
                Thread.sleep(3000);
                base.clickWithJsExecutor(serviceRadioButton);
                Thread.sleep(3000);
                base.highlightElementWithScreenshot(serviceRadioButton, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
                base.clickWithJsExecutor(confirmServiceOptionButton);
            }
        }
    }

    /*
    Manish Kumar Jain
    Date:8th July 2022
    Steps: Click on Worcester Bosch no availability Pop up box
     */

    public void clickOnWBNoAvailabilityPopUp() {
        if (base.checkIfELementIsAvailable(WB_noAvailabilityPopUp)) {
            base.highlightElement(WB_noAvailabilityOkButton);
            base.clickWithJsExecutor(WB_noAvailabilityOkButton);
        } else {
            base.waitForPageToLoad();
            base.highlightElement(WB_noAvailabilityOkButton);
            base.clickWithJsExecutor(WB_noAvailabilityOkButton);
        }

    }

    public void iClickOnConfirmOptionDetailsButtonVerifyWarningPopUp() throws InterruptedException {
        String newText = "This Service Provider is not eligible to have jobs completed without an Appointment";
        base.waitTillElementFound(confirmOptionDetailsButton);
        base.clickWithJsExecutor(confirmOptionDetailsButton);
        Thread.sleep(4000);
        if (WB_notEligibleWarningPopUp.isDisplayed()) {
//            String warningText = base.getElementFromXpath(WB_notEligibleServiceProviderTextPopUpPath).getText();
            String warningText = driver.findElement(By.xpath(WB_notEligibleServiceProviderTextPopUpPath)).getText();
            System.out.println(warningText);
            LOGGER.info("New text displayed in the pop up: " + warningText);
            Thread.sleep(4000);
            if (warningText.equalsIgnoreCase(newText)) {
                base.clickWithJsExecutor(WB_warningPopUpCloseButton);
                Thread.sleep(2000);
                LOGGER.info("New pop up displayed when appointment was not selected for WB plan");
            } else {
                System.out.println("Not able to close the warning pop up");
            }
        }
    }

    public boolean VerifyNoAvailabilityMessage() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(noAvailabilityMessage)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isViewRuleIsDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(viewRuleButton)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOnViewRule() {
        base.clickWithJsExecutor(viewRuleButton);
    }

    public void verifyRuleTableIsDisplayedBeforeSelectingAServiceOption() {

        base.waitForElementVisible(allocationRuleTable);

        if (base.isElementAvailable(allocationRuleTable)) {
            base.highlightElement(allocationRuleTable);
        } else {

            LOGGER.info("Allocation rule table is not available.");
        }
    }


//    public boolean verifyRuleIDAndServiceOption(String ruleID, String spAcronym) {
//        boolean status = false;
//
//        try {
//            base.clickWithJsExecutor(viewRuleButton);
//
//            if (base.isElementAvailable(allocationRuleTable)) {
//                base.highlightElement(allocationRuleTable);
//
//                List<WebElement> rows = driver.findElements(By.xpath(".//table[@id='Allocations']//tbody/tr/td[2]"));
//                LOGGER.info("**************************Available Service options are " + rows.size());
//                Thread.sleep(3000);
//                WebElement allocationServiceProvider = seleniumHelper.getCustomElementByXpath(allocationSP, ruleID);
//                Thread.sleep(3000);
//                String allocationSPTowardsRule = allocationServiceProvider.getText();
//                LOGGER.info("Available Service option towards rule ID " + allocationSPTowardsRule);
//
//
//                StringBuilder allocationIDBuilder = new StringBuilder();
//
//                for (WebElement allocationRuleID : rows) {
//                    String allocationID = allocationRuleID.getText();
//                    allocationIDBuilder.append(allocationID).append(",");
//                    LOGGER.info("Added allocationRule IDs to the StringBuilder: " + allocationID);
//                }
//
//                String rule = allocationIDBuilder.toString();
//                String[] ruleArray = rule.split(",");
//
//                for (int i = 0; i < ruleArray.length; i++) {
//                    String rules = ruleArray[i];
//
//                    if (rules.contains(ruleID)) {
//                        LOGGER.info("Rule ID " + ruleID + " is present in the allocationTable.");
//
//                        if (allocationSPTowardsRule.contains(spAcronym)) {
//                            LOGGER.info("Service Provider " + spAcronym + " is present in the allocationTable toward " + ruleID);
//                        } else {
//
//                            LOGGER.error("Service Provider " + spAcronym + " is not matched towards " + ruleID);
//                        }
//
//                        status = true;
//                        break;
//                    } else {
//                        LOGGER.error("Rule ID " + ruleID + " is not present in the allocationTable.");
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//    }

    public boolean verifyRuleIDAndServiceOption(String ruleID, String spAcronym) {
        boolean status = false;
        try {

            String xpathForRow = "//table[@id='Allocations']/tbody/tr[td[1]='" + spAcronym + "']";
            WebElement row = driver.findElement(By.xpath(xpathForRow));
            String actualAllocationRule = row.findElement(By.xpath("td[2]")).getText();
            if (actualAllocationRule.equals(ruleID)) {
                LOGGER.info("Service Provider '" + spAcronym + "' has the expected Allocation Rule: '" + ruleID + "'");
            } else {
                LOGGER.info("Service Provider '" + spAcronym + "' does not have the expected Allocation Rule.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }



    public boolean clickOnTheCloseButton() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(closeButton) && closeButton.getText().equalsIgnoreCase(CLOSE)) {
                Thread.sleep(3000);
                base.highlightElement(closeButton);
                closeButton.click();
                status = true;
            } else {
                LOGGER.error("Unable to Click on the Close button");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void selectServiceOption(String value)throws InterruptedException {
        Thread.sleep(3000);
        WebElement serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        if(base.checkIfELementIsAvailable(serviceOption)){
            base.isElementAvailable(serviceOption);
            base.clickWithJsExecutor(serviceOption);
        }else{
            LOGGER.error("Unable to Click on serviceOption");
        }

    }


    public boolean verifyoverFlowRuleColumn() {
        boolean status = false;
        try {
            base.waitForElementVisible(overFlowRuleColumn);
            if (base.isElementAvailable(overFlowRuleColumn)) {
                base.highlightElement(overFlowRuleColumn);
                status = true;

            } else {
                LOGGER.error("OverFlow rule column is not available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean verifyOverFlowRuleID() {
        boolean status = false;
        try {
            base.waitForElementVisible(overFlowRuleID);
            if (base.isElementAvailable(overFlowRuleID)) {
                base.highlightElement(overFlowRuleID);
                status = true;
            } else {

                LOGGER.info("OverFlow rule ID is not available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public boolean additionalOverflowRuleTableAfterSelectingAServiceOption() {
        boolean status = false;
        try {
            base.waitForElementVisible(overFlowRuleTable);
            if (base.isElementAvailable(allocationRuleTable)) {
                base.highlightElement(allocationRuleTable);
                status = true;
            } else {

                LOGGER.info("Allocation rule table is not available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickOnConfirmServcieOptionOnReviewClaimPage() {

        base.clickWithJsExecutor(confirmServiceOptionButton);
        base.waitForPageToLoad();
        if (excessPaymentDue.isExcessPaymentPageDisplayed()) {
            excessPaymentDue.takeExcessPayment();
            base.hardWait("3000");
            callOutChargePaymentPage.confirmPaymentSuccessfulPopup();
            base.hardWait("3000");
        } else if (paymentDuePopup.isPaymentDuePageLoaded()) {
            paymentDuePopup.takeServiceCostPayment();
            base.hardWait("3000");
            callOutChargePaymentPage.confirmPaymentSuccessfulPopup();
            base.hardWait("3000");
        } else {
            LOGGER.info("No payment page displayed & Service Option confirmed successfully");
        }
    }


    public void isSPWarrantyMessageDisplayed() {
        try {
            if (base.checkIfELementIsAvailable(spWarrantyMessage)) {
                base.highlightElement(spWarrantyMessage);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isOverrideButtonDisplayed() {
        try {
            if (base.checkIfELementIsAvailable(overrideButton)) {
                base.highlightElement(overrideButton);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnOverrideButton() {
        try {
            if (base.isClickable(overrideButton) ) {
                base.highlightElement(overrideButton);
                Thread.sleep(1000);
                base.clickWithJsExecutor(overrideButton);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void selectOverrideReason(String overrideReason) {
        try {
            overrideReasonInputField.clear();
            overrideReasonInputField.sendKeys(overrideReason);
            seleniumHelper.actionToMoveDownOnList(overrideReasonInputField, 0);
            if (base.checkIfELementIsAvailable(clickOnProceed) && base.isClickable(clickOnProceed)) {
                base.highlightElement(clickOnProceed);
                Thread.sleep(1000);
                base.clickWithJsExecutor(clickOnProceed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isBlockedSPDisplayed() {
        boolean status = false;
        try {
            if (!base.checkIfELementIsAvailable(blockedSP)) {
                status = true;
                LOGGER.info("Blocked SP : FTB is not displayed.");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }


    public void verifyTheColorOfPrimarySP() {

        base.waitTillElementFound(primarySPfirstAvailableDate);

        String bgColor = primarySPfirstAvailableDate.getCssValue("background-color");

        LOGGER.info("The Background color of Primary SPs availabile days :" + bgColor);

        LOGGER.info("Status of Comparing bgColor as Orange   :" + colorOfPrimarySPAvailableDays_Orange.equalsIgnoreCase(bgColor));

    }

    public boolean isFTB9Displayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(ftb9)) {
                status = true;
                LOGGER.info("Extra Availability SP: FTB-9 is displayed.");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean ftb9IsNotDisplayed() {
        boolean status = false;
        try {
            if (!base.checkIfELementIsAvailable(ftb9)) {
                status = true;
                LOGGER.info("Extra Availability SP: FTB-9 isn't displayed.");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean blockedSPIsDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(blockedSP)) {
                status = true;
                LOGGER.info("Blocked SP : FTB Respond is displayed.");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickRequestAvailabilityButton()
    {
        try {
            if (base.checkIfELementIsAvailable(requestAvailabilityButton)) {
                base.clickElement(requestAvailabilityButton);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}