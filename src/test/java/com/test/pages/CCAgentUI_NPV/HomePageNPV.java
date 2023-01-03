package com.test.pages.CCAgentUI_NPV;

import com.test.pages.CCAgentUI_NPV.ProductConfirmationSection.ProductConfirmationPNC;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageNPV {

    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;
    private ProductConfirmationPNC productConfirmationPNC;

    //Find elements
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement name;

    @FindBy(xpath = "//*[@id=\"displayLoginButton\"]/button")
    WebElement loginButton;

    @FindBy(id="PlanView_Header")
    private WebElement planViewHeaderText;

    @FindBy(xpath = "//img[@alt=\"Create Claim\"]")
    private WebElement createClaim;

    @FindBy(xpath = "//div[@class=\"sidr_tab_text\"][(contains(.,\"Search\"))]")
    private WebElement searchTab;

    @FindBy(xpath = "//input[@id=\"jobnoSearch\"]")
    private WebElement claimNumber;

    @FindBy(xpath = "//img[contains(@onclick,\"goToSearchJob\")]")
    private WebElement claimSearchIcon;

    @FindBy(xpath = "//span/a[contains(.,\"Logout\")]")
    private WebElement logoutButon;


    private static final String directReferral_WarningPopUpBoxPath = "//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-systemMessages ui-dialog-buttons ui_Warning']";
    @FindBy(xpath = directReferral_WarningPopUpBoxPath)
    private WebElement directReferral_WarningPopUpBox;

    private static final String directReferral_WarningPopUpHeadingPath = "//span[@id='ui-id-1'][contains(text(),'Admin Only Plan - Direct Referral')]";
    @FindBy(xpath = directReferral_WarningPopUpHeadingPath)
    private WebElement directReferral_WarningPopUpHeading;

    private static final String directReferral_WarningPopUpCompanyNamePath = "//span[@id='CompanyName']";
    @FindBy(xpath = directReferral_WarningPopUpCompanyNamePath)
    private WebElement directReferral_WarningPopUpCompanyName;

    private static final String directReferral_WarningPopUpTelephoneNumberPath = "//h3[contains(text(),'TELEPHONE NUMBERS')]";
    @FindBy(xpath = directReferral_WarningPopUpTelephoneNumberPath)
    private WebElement directReferral_WarningPopUpTelephoneNumber;

    private static final String directReferral_WarningPopUpCloseButtonPath = "//div[@class=\"ui-dialog-buttonpane ui-widget-content ui-helper-clearfix\"]//div[@class=\"ui-dialog-buttonset\"]//button[contains(text(),'Close')]";
    @FindBy(xpath = directReferral_WarningPopUpCloseButtonPath)
    private WebElement directReferral_WarningPopUpCloseButton;

    private static final String directReferral_WarningPopUpGoToURLButtonPath = "//div[@class='ui-dialog-buttonset']//button[@class=\"btnStandard ui_Warning\" and contains(text(),'Go to Referral')]";
    @FindBy(xpath = directReferral_WarningPopUpGoToURLButtonPath)
    private WebElement directReferral_WarningPopUpGoToReferralButton;

    private static final String answerResponseMultiDropdownPath = "//*[@id=\"brdrLnDiv\"][contains(.,\"Answer Response Message\")]/div[@id=\"IcqAnswerResponseInput\"]/select";
    @FindBy(xpath = answerResponseMultiDropdownPath)
    private WebElement multiDropdown;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    public static final String claimTypeXpath = "//div[@id=\"BookingTypeHolder\"]/div[contains(.,\"${value}\")]";
    public HomePageNPV(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils,ProductConfirmationPNC productConfirmationPNC) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        this.productConfirmationPNC = productConfirmationPNC;
        PageFactory.initElements(driver, this);
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


    public void logout(){
        try{
            if(base.checkIfELementIsAvailable(logoutButon) && base.isClickable(logoutButon)){
                base.highlightElement(logoutButon);
                base.clickElement(logoutButon);
            }else{
                LOGGER.error("Unable to verify the Logout function");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isNewPlanViewHeaderLoaded(){
        return (planViewHeaderText.isDisplayed())?true:false;
    }

    public boolean isClaimTypeEnabled(String claimType){
        return (seleniumHelper.getCustomElementByXpath(claimTypeXpath,claimType).isEnabled())?true:false;
    }

    public void selectClaimType(String claimType){
        if(isClaimTypeEnabled(claimType)){
            base.clickWithJsExecutor(seleniumHelper.getCustomElementByXpath(claimTypeXpath,claimType));
        } else {
            LOGGER.info("Unable to click the Claim Type");
        }
    }

    /* Name : Manish Kumar Jain
    Scenario: Verify Direct Referral pop up display for Company E Admin Plans
    Date: 3rd Feb 2022e*/
    public void verifyPopUpWarningForAdminPlans() throws InterruptedException {
        try {
            if (base.checkIfELementIsAvailable(directReferral_WarningPopUpBox))
            {
                base.highlightElement(directReferral_WarningPopUpCompanyName);
                Thread.sleep(3000);
                base.highlightElement(directReferral_WarningPopUpTelephoneNumber);
                Thread.sleep(3000);
                base.highlightElement(directReferral_WarningPopUpGoToReferralButton);
                Thread.sleep(3000);
                base.highlightElement(directReferral_WarningPopUpCloseButton);
                Thread.sleep(3000);
                //base.clickWithJsExecutor(directReferral_WarningPopUpCloseButton);
            } else {
                LOGGER.error("Unable to click on Close button");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Name : Manish Kumar Jain
    Scenario: Verify OEM website page open after clicking on Go to Referral button
    Date: 3rd Feb 2022e*/
    public void verifyDirectReferralGoToUrlOpensOEMWebsite()
    {
        try {
            if (base.checkIfELementIsAvailable(directReferral_WarningPopUpBox))
            {
                if(base.checkIfELementIsAvailable(directReferral_WarningPopUpGoToReferralButton))
                {
                    base.highlightElement(directReferral_WarningPopUpGoToReferralButton);
                    Thread.sleep(3000);
                    base.clickWithJsExecutor(directReferral_WarningPopUpGoToReferralButton);
                }
                else {
                    LOGGER.error("Unable to click on Go To Referral button");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}
