package com.test.pages.CCAgent_OLDUI;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ServiceOptionsPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private ServiceProviderAvailabilityPopup availabilityPopup;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//*[@id=\"section_66\"]//legend[contains(.,\"Service Options\")]")
    private WebElement serviceOptionsPageHeading;

    @FindBy(xpath = "//*[@id=\"confirmJobServiceOptionBtn\"]")
    private WebElement confirmServiceOptionButton;

    @FindBy(xpath = "//*[@id=\"section_66_c\"]/div/div[contains(.,\"Additional Information\")]")
    private WebElement additionalInformationSection;

    private final String additionalInfo_serviceOptionsMessageCheckBoxPath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Service Option Message\")]/td[4]/input";
    @FindBy(xpath = additionalInfo_serviceOptionsMessageCheckBoxPath)
    private WebElement additionalInfo_serviceOptionsMessageCheckBox;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[4]/input")
    private WebElement additionalInfo_ConfirmEmailAddressCheckBox;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[4]/input")
    private WebElement additionalInfo_ConfirmContactNumberCheckBox;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[4]/input")
    private WebElement additionalInfo_ConfirmMobileNumberCheckBox;

    private final String additionalInfo_ConfirmReturnAddress_Path = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Return Address\")]/td[4]/input";
    @FindBy(xpath = additionalInfo_ConfirmReturnAddress_Path)
    private WebElement additionalInfo_ConfirmReturnAddress;

    private final String additionalInfo_JiffyBgXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Send Jiffy Bag\")]/td[4]/input";
    @FindBy(xpath = additionalInfo_JiffyBgXpath)
    private WebElement additionalInfo_SendJiffyBag;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Service Option Message\")]/td[2]")
    private WebElement additionalInfo_serviceOptionsMessageExist;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[2]")
    private WebElement additionalInfo_ConfirmEmailAddressExist;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[2]")
    private WebElement additionalInfo_ConfirmContactNumberExist;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,'Confirm Mobile Number')]/td[2]")
    private WebElement additionalInfo_ConfirmMobileNumberExist;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[3]/a")
    private WebElement additionalInfo_ConfirmMobileNumberChange;

    //    @FindBy(xpath = "//*[@id=\"OpdDataMobileSpan\"]")
    @FindBy(xpath = "//*[@id=\"OpdDataMobile\"]")
    private WebElement additionalInfo_ConfirmMobileNumber_Clear;

    @FindBy(xpath = "//table[@id=\"ServiceOptionsTable3\"]//tbody/tr")
    private List<WebElement> additionalInfoList;

    //    private final String popupAdditionalInfoXpath = "//div[@role=\"dialog\"]//span[contains(.,\"Close\")]";
    private final String popupAdditionalInfoXpath = "//div[@role=\"dialog\"]//div[@class=\"ui-dialog-buttonset\"]/button[contains(.,\"Close\")]";
    @FindBy(xpath = popupAdditionalInfoXpath)
    private WebElement popupClose;

    private final String fieldIsBlankDialogBoxPath = "//div[@role=\"dialog\"]//span[contains(.,\"Field is Blank\")]";
    @FindBy(xpath = fieldIsBlankDialogBoxPath)
    private WebElement fieldIsBlankDialogBox;

    private final String firstAvailableDateXpath = "//*[@id=\"MainICCollectionCalendar\"]//tr/td[contains(@class,\"dayAvailable\")][1]";
    @FindBy(xpath = firstAvailableDateXpath)
    private WebElement firstAvailableDate;
    //
//    @FindBy(xpath = "//*[@id=\"confirmOptionDetailsButton\"]")
    @FindBy(xpath = "//button[contains(.,\"Confirm Option Details\")]")
    private WebElement confirmOptionDetailsButton;

    @FindBy(xpath = "//button[contains(.,\"Confirm Option Details\")]")
    private WebElement confirmOptionDetailsButton1;

    @FindBy(xpath = "//button[contains(.,\"Place On-hold\")]")
    private WebElement placeOnHoldButton;

    @FindBy(xpath = "//textarea[@id=\"IcqAutosetClaimStatusNote\" and @placeholder=\"RA Notes\"]")
    private WebElement onHoldTextArea;

    @FindBy(xpath = "//*[@id=\"CallBackForm\"]//button[contains(.,\"Save\")]")
    private WebElement onHoldTextAreaSaveButton;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Book without Appointment\")]")
    private WebElement confirmWithoutAnAppointmentButton;

    //    @FindBy(xpath = "//*[@id=\"cboxLoadedContent\"]//td/div[contains(.,'Confirm Service Options & Payment Details')]")
    @FindBy(xpath = "//*[@id=\"cboxLoadedContent\"]/div/div[contains(.,\"Plan Details\")]")
    private WebElement confirmCheckOutProcessPage;

    private final String checkOutProcessConfirmationButtonXpath = "//*[@id=\"icPaymentConfirmButV1s\"]";
    @FindBy(xpath = checkOutProcessConfirmationButtonXpath)
    private WebElement checkOutProcessConfirmButton;

    private final String popup_MobileNoErrorXpath = "//span[contains(.,\"Mobile Number Error\")]";
    @FindBy(xpath = popup_MobileNoErrorXpath)
    private WebElement popup_MobileNoError;

    private final String OEMCompanyNameXpath = "//div[@id=\"ApTabContent1066\"]//span[@id=\"CompanyName\"]";
    @FindBy(xpath = OEMCompanyNameXpath)
    private WebElement oemCompanyName;

    private final String waiveExcessPaymentPath = "//*[@id=\"ExcessPaymentTable\"]/tbody/tr/td[contains(.,\"Payment has been waived\")]";
    @FindBy(xpath = waiveExcessPaymentPath)
    private WebElement waiveExcessPayment;

    private final String excessPayOptionPath = "//*[@id=\"ExcessPaymentTable\"]/tbody/tr[contains(.,\"Payment is required in order to complete the booking of this claim\")]/td[4]";
    @FindBy(xpath = excessPayOptionPath)
    private WebElement excessPayOption;

    private final String excessPaymentMadePath = "//*[@id=\"ExcessPaymentTable\"]//tbody/tr/td[contains(.,\"Payment has been made\")]";
    @FindBy(xpath = excessPaymentMadePath)
    private WebElement excessPaymentMade;

    private final String serviceCostPaymentMadeAmountXpath = "//*[@id=\"ServiceOptionsTable\"]//tbody/tr/td[3]";
    /**
     * --Service Option - Contact Details Changes: --
     */
    // Email
    private final String serviceOptions_emailAddressChangeXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[contains(.,\"Change\")]";
    @FindBy(xpath = serviceOptions_emailAddressChangeXpath)
    private WebElement serviceOptionEmailAddressChangeButton;

    private final String serviceOptions_emailAddressInputXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[2]/input";
    @FindBy(xpath = serviceOptions_emailAddressInputXpath)
    private WebElement serviceOptionEmailAddressInput;

    // HomeTel
    private final String serviceOptions_homeTelChangeXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[contains(.,\"Change\")]";
    @FindBy(xpath = serviceOptions_homeTelChangeXpath)
    private WebElement serviceOptionHomeTelChangeButton;

    private final String serviceOptions_homeTelInputXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[2]/input";
    @FindBy(xpath = serviceOptions_homeTelInputXpath)
    private WebElement serviceOptionHomeTelInput;

    // Mobile No
    private final String serviceOptions_mobileNoChangeXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[contains(.,\"Change\")]";
    @FindBy(xpath = serviceOptions_mobileNoChangeXpath)
    private WebElement serviceOptionmobileNoChangeButton;

    private final String serviceOptions_mobileNoInputXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[2]/input";
    @FindBy(xpath = serviceOptions_mobileNoInputXpath)
    private WebElement serviceOptionmobileNoInput;

    @FindBy(xpath = "//*[@id=\"ServiceProviderIframe\"]")
    private WebElement serviceProviderDetailsIframe;

    private final String currentSPNameDynamicXpath = "//div[@class=\"ApTabContent\"][@style!=\"display:none\"]//span[@id=\"CompanyName\"][contains(.,\"${value}\")]";
    private final String currentSPNameXpath = "//div[@class=\"ApTabContent\"][@style=\"\"]//span[@id=\"CompanyName\"]";
    @FindBy(xpath = currentSPNameXpath)
    private WebElement currentAllocatedServiceProviderName;


    private final String availabilityPopupXpath = "//*[@id=\"modP\"]";
    private final String serviceProviderSelectionByName = "//*[@id=\"AllocatedSpRadiobuttons\"]//span[contains(.,\"${value}\")]/../label/input";

    private final String serviceOptions_emailAddressXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Email Address\")]/td[2]";
    private final String serviceOptions_homeTelXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Contact Number\")]/td[2]";
    private final String serviceOptions_mobileNoXpath = "//table[@id=\"ServiceOptionsTable3\"]//tr[contains(.,\"Confirm Mobile Number\")]/td[2]";
    private static final String availableServiceOptionXpath = "//*[@id=\"ServiceOptionsTable\"]//tr[contains(.,\"${value}\")]/td[4]";
    private static final String availableServiceOptionGetCostXpath = "//table[@id=\"ServiceOptionsTable\"]//tr[contains(.,\"${value}\")]/td[3]";
    public int serviceOptionCost = 0;


    @FindBy(xpath = "//*[@id=\"section_66_c\"]/div/div[6]/button[3]")
    private WebElement findAllServiceProvidersButton;

    @FindBy(id = "viewAllSPselect")
    private WebElement listOfServiceProviders;

    private final String listOfServiceProvidersDropdownPath = "//select[@id=\"viewAllSPselect\"]";
    @FindBy(xpath = listOfServiceProvidersDropdownPath)
    private WebElement listOfServiceProvidersDropdown;

    @FindBy(xpath = "//*[@id=\"viewAllSPs\"]")
    private WebElement viewAllSpsCheckbox;


    public ServiceOptionsPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils, ServiceProviderAvailabilityPopup availabilityPopup) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.availabilityPopup = availabilityPopup;
        PageFactory.initElements(driver, this);
    }

    public void selectAdditionalInformation() {
        base.checkElementPresence(additionalInfo_serviceOptionsMessageCheckBox);
        base.clickElement(additionalInfo_serviceOptionsMessageCheckBox);

    }

    // method to check the Service options page loaded
    public boolean isServiceOptionsPageLoaded() {
        base.waitTillElementFound(serviceOptionsPageHeading);
        return (serviceOptionsPageHeading.isDisplayed()) ? true : false;
    }

    public boolean isAvaiabilityPopupStillDisplaying() {
        boolean status = false;
        WebElement popup = null;
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        try {
            popup = base.getElementFromXpath(availabilityPopupXpath);
            if (popup != null && wait.until(ExpectedConditions.invisibilityOf(popup))) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return status;
        }
    }

    //Method : Select ServiceOption
    public void selectAvailableServiceOptionAndConfirm(String value) {
        WebElement serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        base.clickWithJsExecutor(serviceOption);
        base.highlightElementWithScreenshot(serviceOption, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
        base.clickWithJsExecutor(confirmServiceOptionButton);
        base.waitForPageToLoad();
    }

    //Method : Select ServiceOption
    public void selectAvailableServiceOptionAndConfirmTheServiceCost(String value) {
        WebElement serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionXpath, value);
        base.clickWithJsExecutor(serviceOption);
        base.highlightElementWithScreenshot(serviceOption, "ServiceOptionSelected_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
        base.clickWithJsExecutor(confirmServiceOptionButton);
        base.waitForPageToLoad();
        // get the service option cost
        this.serviceOptionCost = getServiceProviderCost(value);
    }

    // Method : Check if additional info section loaded
    public boolean isAdditionalInformationSectionLoaded() {
        base.waitTillElementFound(additionalInformationSection);  // wait time needed to load the calendar
        base.highlightElement(additionalInformationSection);
        return (additionalInformationSection.isDisplayed()) ? true : false;
    }

    public void putClaimOnHold() {
        base.waitForPageToLoad();
        base.checkIfELementIsAvailable(placeOnHoldButton);
        base.clickWithJsExecutor(placeOnHoldButton);
        base.hardWait("2000");
        base.checkIfELementIsAvailable(onHoldTextArea);
        base.sendFieldInputData(onHoldTextArea, "CLAIM ON HOLD");
        base.clickWithJsExecutor(onHoldTextAreaSaveButton);
        base.hardWait("5000");
        base.waitForPageToLoad();
        base.refreshPage();
    }

    public void enterAdditionalInformationData() {
        try {
            if (availabilityPopup.isPopUpDisplayed()) {
                availabilityPopup.closePopup();
            } else {
//            base.hardWait("5000");
                base.hardWait("1000");
                if (availabilityPopup.isPopUpDisplayed()) {
                    availabilityPopup.closePopup();
                }
            }
            //ServiceOptionsMessage
            if (base.getElementFromXpath(additionalInfo_serviceOptionsMessageCheckBoxPath).isDisplayed()) {
                if (additionalInfo_serviceOptionsMessageCheckBox.isDisplayed()) {
                    base.highlightElement(additionalInfo_serviceOptionsMessageCheckBox);
                    base.isClickable(additionalInfo_serviceOptionsMessageCheckBox);
                    base.clickWithJsExecutor(additionalInfo_serviceOptionsMessageCheckBox);
                }
            }
            //Email
            if (additionalInfo_ConfirmEmailAddressCheckBox != null) {
                if (additionalInfo_ConfirmEmailAddressCheckBox.isDisplayed()) {
                    base.highlightElement(additionalInfo_ConfirmEmailAddressCheckBox);
                    base.isClickable(additionalInfo_ConfirmEmailAddressCheckBox);
                    base.clickWithJsExecutor(additionalInfo_ConfirmEmailAddressCheckBox);
                }


                if (additionalInfo_ConfirmEmailAddressExist.getText().equalsIgnoreCase("Email:")) {
                    closeAdditionalInfoPopup();
                }
// If the field is blank popup displayed
                if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
                    base.clickElement(popupClose);
                }
            }
            //Contact Number
            if (additionalInfo_ConfirmContactNumberCheckBox != null) {
                if (additionalInfo_ConfirmContactNumberCheckBox.isDisplayed()) {
                    base.highlightElement(additionalInfo_ConfirmContactNumberCheckBox);
                    base.isClickable(additionalInfo_ConfirmContactNumberCheckBox);
                    base.clickWithJsExecutor(additionalInfo_ConfirmContactNumberCheckBox);
                }
                if (additionalInfo_ConfirmContactNumberExist.getText().isEmpty()) {
                    closeAdditionalInfoPopup();
                }
// If the field is blank popup displayed
                if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
                    base.clickElement(popupClose);
                }
            }
            //Send Jiffy
            if (base.getElementFromXpath(additionalInfo_JiffyBgXpath) != null) {
                base.highlightElement(additionalInfo_SendJiffyBag);
                base.isClickable(additionalInfo_SendJiffyBag);
                base.clickWithJsExecutor(additionalInfo_SendJiffyBag);
            }
            // If the field is blank popup displayed
            if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
                base.clickElement(popupClose);
            }

            //Confirm Return Address
            if (base.getElementFromXpath(additionalInfo_ConfirmReturnAddress_Path) != null) {
                base.highlightElement(additionalInfo_ConfirmReturnAddress);
                base.isClickable(additionalInfo_ConfirmReturnAddress);
                base.clickWithJsExecutor(additionalInfo_ConfirmReturnAddress);
            }
// If the field is blank popup displayed
            if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
                base.clickElement(popupClose);
            }
            //Mobile Number
            if (additionalInfo_ConfirmMobileNumberCheckBox != null) {
                if (additionalInfo_ConfirmMobileNumberCheckBox.isDisplayed()) {
                    base.highlightElement(additionalInfo_ConfirmMobileNumberCheckBox);
                    base.isClickable(additionalInfo_ConfirmMobileNumberCheckBox);
                    base.clickWithJsExecutor(additionalInfo_ConfirmMobileNumberCheckBox);

                }

// Mobile phone number validation error
                if (base.getElementFromXpath(popup_MobileNoErrorXpath) != null) {
                    base.clickElement(popupClose);
                    base.checkIfELementIsAvailable(additionalInfo_ConfirmMobileNumberChange);
                    base.clickElement(additionalInfo_ConfirmMobileNumberChange);
//
                    Actions act = new Actions(driver);
                    act.doubleClick(additionalInfo_ConfirmMobileNumber_Clear).build().perform();
                    act.sendKeys(Keys.DELETE).build().perform();
                    base.clickWithJsExecutor(additionalInfo_ConfirmMobileNumberCheckBox);
                }
// If the field is blank popup displayed
                if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
                    base.clickElement(popupClose);
                }
////        if (additionalInfo_ConfirmMobileNumberExist.getText().isEmpty()) {
//        if (additionalInfo_ConfirmMobileNumber_Clear.getText().isEmpty()) {
//            closeAdditionalInfoPopup();
//        }
            }
            base.waitToLoadElement();
        } catch (Exception el) {
            el.printStackTrace();
        }
    }

    public void enterAdditionalInformationDataNew() {

        if (availabilityPopup.isPopUpDisplayed()) {
            availabilityPopup.closePopup();
        } else {
            base.hardWait("5000");
            if (availabilityPopup.isPopUpDisplayed()) {
                availabilityPopup.closePopup();
            }
        }
        //ServiceOptionsMessage
        if (base.getElementFromXpath(additionalInfo_serviceOptionsMessageCheckBoxPath).isDisplayed()) {
            if (additionalInfo_serviceOptionsMessageCheckBox.isDisplayed()) {
                base.highlightElement(additionalInfo_serviceOptionsMessageCheckBox);
                base.isClickable(additionalInfo_serviceOptionsMessageCheckBox);
                base.clickWithJsExecutor(additionalInfo_serviceOptionsMessageCheckBox);
            }
        }
        //Email
        if (additionalInfo_ConfirmEmailAddressCheckBox.isDisplayed()) {
            base.highlightElement(additionalInfo_ConfirmEmailAddressCheckBox);
            base.isClickable(additionalInfo_ConfirmEmailAddressCheckBox);
            base.clickWithJsExecutor(additionalInfo_ConfirmEmailAddressCheckBox);
        }

        if (additionalInfo_ConfirmEmailAddressExist.getText().equalsIgnoreCase("Email:")) {
            closeAdditionalInfoPopup();
        }
// If the field is blank popup displayed
        if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
            base.clickElement(popupClose);
        }

        //Contact Number
        if (additionalInfo_ConfirmContactNumberCheckBox.isDisplayed()) {
            base.highlightElement(additionalInfo_ConfirmContactNumberCheckBox);
            base.isClickable(additionalInfo_ConfirmContactNumberCheckBox);
            base.clickWithJsExecutor(additionalInfo_ConfirmContactNumberCheckBox);
        }
        if (additionalInfo_ConfirmContactNumberExist.getText().isEmpty()) {
            closeAdditionalInfoPopup();
        }
// If the field is blank popup displayed
        if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
            base.clickElement(popupClose);
        }
        //Send Jiffy
        if (base.getElementFromXpath(additionalInfo_JiffyBgXpath) != null) {
            base.highlightElement(additionalInfo_SendJiffyBag);
            base.isClickable(additionalInfo_SendJiffyBag);
            base.clickWithJsExecutor(additionalInfo_SendJiffyBag);
        }
        // If the field is blank popup displayed
        if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
            base.clickElement(popupClose);
        }

        //Confirm Return Address
        if (base.getElementFromXpath(additionalInfo_ConfirmReturnAddress_Path) != null) {
            base.highlightElement(additionalInfo_ConfirmReturnAddress);
            base.isClickable(additionalInfo_ConfirmReturnAddress);
            base.clickWithJsExecutor(additionalInfo_ConfirmReturnAddress);
        }
// If the field is blank popup displayed
        if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
            base.clickElement(popupClose);
        }
        //Mobile Number
        if (additionalInfo_ConfirmMobileNumberCheckBox.isDisplayed()) {
            base.highlightElement(additionalInfo_ConfirmMobileNumberCheckBox);
            base.isClickable(additionalInfo_ConfirmMobileNumberCheckBox);
            base.clickWithJsExecutor(additionalInfo_ConfirmMobileNumberCheckBox);

        }

// Mobile phone number validation error
        if (base.getElementFromXpath(popup_MobileNoErrorXpath) != null) {
            base.clickElement(popupClose);
            base.checkIfELementIsAvailable(additionalInfo_ConfirmMobileNumberChange);
            base.clickElement(additionalInfo_ConfirmMobileNumberChange);
//
            Actions act = new Actions(driver);
            act.doubleClick(additionalInfo_ConfirmMobileNumber_Clear).build().perform();
            act.sendKeys(Keys.DELETE).build().perform();
            base.clickWithJsExecutor(additionalInfo_ConfirmMobileNumberCheckBox);
        }
// If the field is blank popup displayed
        if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
            base.clickElement(popupClose);
        }
////        if (additionalInfo_ConfirmMobileNumberExist.getText().isEmpty()) {
//        if (additionalInfo_ConfirmMobileNumber_Clear.getText().isEmpty()) {
//            closeAdditionalInfoPopup();
//        }
        base.waitToLoadElement();
    }

    // Method : Additional info section with Contact details updated.
    public void enterAdditionalInformationDataWithContactDetails(String email, String homeTel, String mobileNo) {

        base.hardWait("5000");
        if (availabilityPopup.isPopUpDisplayed()) {
            availabilityPopup.closePopup();
        }
        //ServiceOptionsMessage
        if (base.getElementFromXpath(additionalInfo_serviceOptionsMessageCheckBoxPath).isDisplayed()) {
            if (additionalInfo_serviceOptionsMessageCheckBox.isDisplayed()) {
                base.highlightElement(additionalInfo_serviceOptionsMessageCheckBox);
                base.isClickable(additionalInfo_serviceOptionsMessageCheckBox);
                base.clickWithJsExecutor(additionalInfo_serviceOptionsMessageCheckBox);
            }
        }
        //Email
        if (additionalInfo_ConfirmEmailAddressCheckBox.isDisplayed()) {
            if (base.checkIfELementIsAvailable(serviceOptionEmailAddressChangeButton) && base.isClickable(serviceOptionEmailAddressChangeButton)) {
                base.clickElement(serviceOptionEmailAddressChangeButton);
                base.waitTillElementFound(serviceOptionEmailAddressInput);
                base.sendFieldInputData(serviceOptionEmailAddressInput, email);
            } else {
                base.hardWait("3000");
                base.clickElement(serviceOptionEmailAddressChangeButton);
                base.waitTillElementFound(serviceOptionEmailAddressInput);
                base.sendFieldInputData(serviceOptionEmailAddressInput, email);
            }

            base.highlightElement(additionalInfo_ConfirmEmailAddressCheckBox);
            base.isClickable(additionalInfo_ConfirmEmailAddressCheckBox);
            base.clickWithJsExecutor(additionalInfo_ConfirmEmailAddressCheckBox);
        }

// If the field is blank popup displayed
        if (base.getElementFromXpath(fieldIsBlankDialogBoxPath) != null) {
            base.clickElement(popupClose);
        }

        //Contact Number
        if (additionalInfo_ConfirmContactNumberCheckBox.isDisplayed()) {
            if (base.checkIfELementIsAvailable(serviceOptionHomeTelChangeButton) && (base.isClickable(serviceOptionHomeTelChangeButton))) {
                base.clickElement(serviceOptionHomeTelChangeButton);
                serviceOptionHomeTelChangeButton.click();
                base.sendFieldInputData(serviceOptionHomeTelInput, homeTel);
            } else {
                base.hardWait("2000");
                base.clickElement(serviceOptionHomeTelChangeButton);
                serviceOptionHomeTelChangeButton.click();
                base.sendFieldInputData(serviceOptionHomeTelInput, homeTel);
            }
            base.highlightElement(additionalInfo_ConfirmContactNumberCheckBox);
            base.isClickable(additionalInfo_ConfirmContactNumberCheckBox);
            base.clickWithJsExecutor(additionalInfo_ConfirmContactNumberCheckBox);
        }

        // Mobile phone number
        if (base.checkIfELementIsAvailable(serviceOptionmobileNoChangeButton) && base.isClickable(serviceOptionmobileNoChangeButton)) {
            base.clickElement(serviceOptionmobileNoChangeButton);
            serviceOptionmobileNoChangeButton.click();
            base.waitTillElementFound(serviceOptionmobileNoInput);
            base.sendFieldInputData(serviceOptionmobileNoInput, mobileNo);
        } else {
            base.hardWait("2000");
            base.clickElement(serviceOptionmobileNoChangeButton);
            serviceOptionmobileNoChangeButton.click();
            base.waitTillElementFound(serviceOptionmobileNoInput);
            base.sendFieldInputData(serviceOptionmobileNoInput, mobileNo);
        }
        base.clickWithJsExecutor(additionalInfo_ConfirmMobileNumberCheckBox);

        base.waitToLoadElement();
    }

    // Method : Close the popup for additional info
    private void closeAdditionalInfoPopup() {
        try {
            base.hardWait("2000");
            base.checkElementPresence(popupClose);
            if (popupClose.isDisplayed()) {
                base.clickElement(popupClose);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean isServiceProviderCostDisplayed(String claimType) {

        boolean status = false;
        WebElement serviceOption = null;
        String serviceCost = null;
        try {
            serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionGetCostXpath, claimType);
            if (serviceOption != null) {
                serviceCost = serviceOption.getText().toString();
                serviceCost = serviceCost.replaceAll("£", "").replaceAll(".00", "");

            }
            if (Integer.valueOf(serviceCost) >= 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    private int getServiceProviderCost(String claimType) {
        WebElement serviceOption = null;
        String serviceCost = null;
        try {
            serviceOption = seleniumHelper.getCustomElementByXpath(availableServiceOptionGetCostXpath, claimType);
            if (serviceOption != null) {
                serviceCost = serviceOption.getText().toString();
                serviceCost = serviceCost.replaceAll("£", "").replaceAll(".00", "");
                base.highlightElement(serviceOption);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Integer.valueOf(serviceCost) > 0) {
            return Integer.valueOf(serviceCost);
        } else {
            return 0;
        }
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
            Thread.sleep(5000);
            for (String serviceProvider : spList) {

                spNameDynamic = seleniumHelper.getCustomElementByXpath(currentSPNameDynamicXpath, serviceProvider);
                Thread.sleep(5000);
                if (base.checkIfELementIsAvailable(spNameDynamic) &&
                        (spNameDynamic.getText().toUpperCase().contains(serviceProvider.toUpperCase()))) {
                    base.highlightElement(spNameDynamic);
                    Thread.sleep(5000);
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

    //Method : Verify if Calender is displayed
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

    //Method : Select First available date on the calendar
    public void selectFirstAvailableAppointmentDate() {
        base.waitTillElementFound(firstAvailableDate);
        base.clickWithJsExecutor(firstAvailableDate);
    }

    public void clickConfirmOptionDetailsButton() {
        base.waitTillElementFound(confirmOptionDetailsButton);
        base.clickWithJsExecutor(confirmOptionDetailsButton);
        base.waitForPageToLoad();
    }

    public void clickConfirmOptionDetailsButtonWithOutAppointment() {
        base.waitTillElementFound(confirmOptionDetailsButton);
        base.clickWithJsExecutor(confirmOptionDetailsButton);
        base.waitForPageToLoad();
        if (base.checkIfELementIsAvailable(confirmWithoutAnAppointmentButton)) {
            base.waitTillElementFound(confirmWithoutAnAppointmentButton);
            base.clickWithJsExecutor(confirmWithoutAnAppointmentButton);
        }
        base.waitForPageToLoad();
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

    public void clickConfirmOptionDetails() {
        base.clickElement(confirmOptionDetailsButton1);
        base.waitForPageToLoad();
//        if (base.checkIfELementIsAvailable(confirmWithoutAnAppointmentButton)) {
//            base.waitTillElementFound(confirmWithoutAnAppointmentButton);
//            base.clickWithJsExecutor(confirmWithoutAnAppointmentButton);
//        }
//        base.waitForPageToLoad();
    }

    public boolean isConfirmOptionDetailsButtonDisplayed() {
        base.highlightElementWithScreenshot(confirmOptionDetailsButton, "ConfirmOptionDetails");
        return (base.isElementAvilable(confirmOptionDetailsButton)) ? true : false;
    }

    public boolean isCheckOutProcessPageLoaded() {
        boolean status = false;
        try {
            if (!base.checkIfELementIsAvailable(confirmCheckOutProcessPage)) {
                base.hardWait("2000");
            }
            base.waitTillElementFound(confirmCheckOutProcessPage);
            if (base.checkIfELementIsAvailable(confirmCheckOutProcessPage)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean ischeckOutProcessConfirmButtonDisplayed() {
        if (!base.checkIfELementIsAvailable(base.quickWait(checkOutProcessConfirmationButtonXpath))) {
            base.hardWait("3000");
        }
        return (base.quickWait(checkOutProcessConfirmationButtonXpath) != null) ? true : false;
    }

    public void confirmCheckoutprocess() {
        base.waitTillElementFound(checkOutProcessConfirmButton);
        base.clickWithJsExecutor(checkOutProcessConfirmButton);
    }

    public void putOnHoldCheckoutprocess() {
        base.waitTillElementFound(checkOutProcessConfirmButton);
        base.clickWithJsExecutor(checkOutProcessConfirmButton);
    }

    /**
     * Call out Charge payment - Waive Charge
     */


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

    public boolean isExcessPaymentRequired() {
        boolean status = false;
        WebElement excessPaymentReq = null;
        try {
            excessPaymentReq = base.getElementFromXpath(excessPayOptionPath);
            if (excessPaymentReq != null && excessPaymentReq.isEnabled()) {
                status = true;
            }
        } catch (NoSuchElementException | java.util.NoSuchElementException el) {
            el.printStackTrace();
        }
        return status;
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

    public boolean isExcessPaymentPaid() {
        WebElement excessPaymentText = null;
        boolean status = false;
        try {
            excessPaymentText = base.getElementFromXpath(excessPaymentMadePath);
            if (excessPaymentText != null && excessPaymentText.isDisplayed()) {
                base.highlightElementWithScreenshot(excessPaymentText, "ExcessPaymentMade_" + seleniumHelper.getCurrentDate());
                status = true;
            }
        } catch (NoSuchElementException | java.util.NoSuchElementException el) {
            el.printStackTrace();
        }
        return status;
    }

    public boolean isServiceOptionPaymentPaid() {
        WebElement paymentMade = null;
        boolean status = false;
        try {
            paymentMade = base.getElementFromXpath(serviceCostPaymentMadeAmountXpath);
            if (paymentMade != null && paymentMade.isDisplayed() && paymentMade.getText().contains(String.valueOf(this.serviceOptionCost))) {
                base.highlightElementWithScreenshot(paymentMade, "ExcessPaymentMade_" + seleniumHelper.getCurrentDate());
                status = true;
            }
        } catch (NoSuchElementException | java.util.NoSuchElementException el) {
            el.printStackTrace();
        }
        return status;
    }

    public boolean isEmailUpdatedonServiceOptionsPage(String email) {
        boolean status = false;
        try {
            if (base.getElementFromXpath(serviceOptions_emailAddressXpath).getText().contains(email)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isHomeTelUpdatedonServiceOptionsPage(String homeTel) {
        boolean status = false;
        try {
            if (base.getElementFromXpath(serviceOptions_homeTelXpath).getText().contains(homeTel)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isMobileNoUpdatedonServiceOptionsPage(String mobileNo) {
        boolean status = false;
        try {
            if (base.getElementFromXpath(serviceOptions_mobileNoXpath).getText().contains(mobileNo)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //Method : to check if the serviceProvider is displayed.

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
    //Method : if the serviceprovider exist select the service provider

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

    public void selectAnotherServiceProvider(String sp) {
        try {
            base.checkIfELementIsAvailable(findAllServiceProvidersButton);
            base.clickWithJsExecutor(findAllServiceProvidersButton);
            base.clickWithJsExecutor(viewAllSpsCheckbox);
            base.selectTextByVisibleText(listOfServiceProviders, sp);
            this.enterAdditionalInformationData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Date: 11th Nov 2021
    Name: Manish Kumar Jain
    Scenario: Click on View All Service Provider button to select different SP while creating claim.
     */
    public void selectDifferentServiceProvider(String sp) {
        try {
            base.checkIfELementIsAvailable(findAllServiceProvidersButton);
            base.clickWithJsExecutor(findAllServiceProvidersButton);
            base.clickWithJsExecutor(viewAllSpsCheckbox);
            Select se = new Select(driver.findElement(By.xpath(listOfServiceProvidersDropdownPath)));
            se.selectByVisibleText(sp);
            Thread.sleep(3000);
            // this.enterAdditionalInformationData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Date: 7th Feb 2021
    Name: Manish Kumar Jain
    Scenario: Verify Service provider name displayed in Service option section for Vokera OEM.
     */
    public void serviceProviderNameDisplayedForVokera(String sp) {
        boolean status = false;
        WebElement spNameDynamic = null;

        try {
            base.waitTillElementFound(serviceProviderDetailsIframe);
            if (!base.checkIfELementIsAvailable(serviceProviderDetailsIframe)) {
                base.waitTillElementFound(serviceProviderDetailsIframe);
            }
            driver.switchTo().frame(serviceProviderDetailsIframe);

            Thread.sleep(5000);
            spNameDynamic = seleniumHelper.getCustomElementByXpath(currentSPNameDynamicXpath, sp);
            String SPName = spNameDynamic.getText();
            System.out.println("Service provider name is: " + SPName);
            Thread.sleep(5000);
            if (base.checkIfELementIsAvailable(spNameDynamic) &&
                    (spNameDynamic.getText().toUpperCase().contains(sp))) {
                base.highlightElement(spNameDynamic);
                Thread.sleep(5000);
//                    status = true;
//                    break;
            }
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return status;
    }


}


