package com.test.pages.CCAgentUI_NPV;

//import com.test.pages.CCAgent_OLDUI.ServiceProviderAvailabilityPopup;
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
//    private ServiceProviderAvailabilityPopup availabilityPopup;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ServiceOptionsPageNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
//        this.availabilityPopup = availabilityPopup;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(.,\"Waive Charge\")]")
    private WebElement waiveExcessChargeSection;

    @FindBy(id = "ServiceOptionsTable")
    private WebElement serviceOptionsTable;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Service Option Message\")]/td[4]/input")
    private WebElement additonalInformation_ServiceOptionMessageCheckbox;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//td[4]/input")
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
    @FindBy(xpath=WB_noAvailabilityOkButtonPath)
    private WebElement WB_noAvailabilityOkButton;

    private final String WB_noAvailabilityPopUpPath = "//span[@id='ui-id-2'][@class='ui-dialog-title ui_Alert'][contains(text(),'Worcester Bosch No Availability')]";
    @FindBy(xpath=WB_noAvailabilityPopUpPath)
    private WebElement WB_noAvailabilityPopUp;

    private final String WB_notEligibleWarningPopUpPath = "//div[contains(@class,\"ui_Warning\")]";
    @FindBy(xpath=WB_notEligibleWarningPopUpPath)
    private WebElement WB_notEligibleWarningPopUp;

    private final String WB_notEligibleServiceProviderTextPopUpPath = "//div[@id='modP'][@class='ui-dialog-content ui-widget-content'][contains(.,'without an Appointment')]";
    @FindBy(xpath=WB_notEligibleServiceProviderTextPopUpPath)
    private WebElement WB_notEligibleServiceProviderTextPopUp;

    private final String WB_warningPopUpCloseButtonPath = "//div[contains(@class,'ui_Warning')]//button[contains(.,'Close')]";
    @FindBy(xpath=WB_warningPopUpCloseButtonPath)
    private WebElement WB_warningPopUpCloseButton;










    private final String serviceOptions_emailAddressXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[2]";
    private final String serviceOptions_homeTelXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[2]";
    private final String serviceOptions_mobileNoXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[2]";
    private static final String availableServiceOptionXpath = "//*[@id=\"ServiceOptionsTable\"]//tr[contains(.,\"${value}\")]/td[4]";
    private static final String availableServiceOptionGetCostXpath = "//table[@id=\"ServiceOptionsTable\"]//tr[contains(.,\"${value}\")]/td[3]";
    public int serviceOptionCost = 0;

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

    private boolean isServiceProverDisplayed(String sPName) {
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
        return (base.isElementAvilable(confirmOptionDetailsButton)) ? true : false;
    }

    //Method : Select ServiceOption
    public void selectAvailableServiceOptionAndConfirm(String value) {
        WebElement serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        base.clickWithJsExecutor(serviceOption);
        base.highlightElementWithScreenshot(serviceOption, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
        base.clickWithJsExecutor(confirmServiceOptionButton);
        base.waitForPageToLoad();
    }

    public void enterAdditionalInformation() {
        base.isClickable(additonalInformation_ServiceOptionMessageCheckbox);
        base.clickElement(additonalInformation_ServiceOptionMessageCheckbox);
    }

    public void enterAdditionalInformationAll() {
        for (WebElement option : servOptions) {
            base.isClickable(option);
            base.hardWait("1000");
            try {
                base.clickElement(option);
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                base.waitTillElementFound(option);
                base.clickElement(option);
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
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List <WebElement> rows = driver.findElements(By.xpath(".//table[@id='ServiceOptionsTable']//tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());

        for (int i=1;i<=rows.size();i++)
        {
                String serviceName = driver.findElement(By.xpath(a_xpath+i+b_xpath)).getText();
                System.out.println(serviceName);
                if(serviceName.contains(value))
                {
                    WebElement serviceRadioButton = driver.findElement(By.xpath(a_xpath+i+c_path));
                    Thread.sleep(3000);
                    base.clickWithJsExecutor(serviceRadioButton);
                    Thread.sleep(3000);
                    base.highlightElementWithScreenshot(serviceRadioButton, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
                    base.clickWithJsExecutor(confirmServiceOptionButton);
                }
                else
                {
                    base.waitToLoadElement();
                    WebElement serviceRadioButton = driver.findElement(By.xpath(a_xpath+i+c_path));
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

    public void clickOnWBNoAvailabilityPopUp()
    {
        if(base.checkIfELementIsAvailable(WB_noAvailabilityPopUp))
        {
            base.highlightElement(WB_noAvailabilityOkButton);
            base.clickWithJsExecutor(WB_noAvailabilityOkButton);
        }
        else
        {
            base.waitForPageToLoad();
            base.highlightElement(WB_noAvailabilityOkButton);
            base.clickWithJsExecutor(WB_noAvailabilityOkButton);
        }

    }

    public void selectAvailableServiceOption(String value) {
        WebElement serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        base.clickWithJsExecutor(serviceOption);
        base.highlightElementWithScreenshot(serviceOption, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
        base.clickWithJsExecutor(confirmServiceOptionButton);
        base.waitForPageToLoad();
    }


    public void iClickOnConfirmOptionDetailsButtonVerifyWarningPopUp() throws InterruptedException {
        String newText = "This Service Provider is not eligible to have jobs completed without an Appointment";
        base.waitTillElementFound(confirmOptionDetailsButton);
        base.clickWithJsExecutor(confirmOptionDetailsButton);
        Thread.sleep(4000);
        if(WB_notEligibleWarningPopUp.isDisplayed())
        {
//            String warningText = base.getElementFromXpath(WB_notEligibleServiceProviderTextPopUpPath).getText();
            String warningText = driver.findElement(By.xpath(WB_notEligibleServiceProviderTextPopUpPath)).getText();
            System.out.println(warningText);
            LOGGER.info("New text displayed in the pop up: " + warningText);
            Thread.sleep(4000);
            if(warningText.equalsIgnoreCase(newText)) {
                base.clickWithJsExecutor(WB_warningPopUpCloseButton);
                Thread.sleep(2000);
                LOGGER.info("New pop up displayed when appointment was not selected for WB plan");
            }else
            {
                System.out.println("Not able to close the warning pop up");
            }
        }
    }

}
