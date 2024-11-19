package com.test.pages.RepairerPortal;

import com.test.pages.RepairerPortal.Excess.ExcessAlertPage;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewRepairBookingPage {

    @FindBy(name = "PolicyNo")
    private WebElement dandgPlanNo;

    @FindBy(xpath= "//form[@id=\"DGJobBookingForm\"]//input[@id=\"CustomerSurname\"]")
    private WebElement custSurname;

    @FindBy(xpath = "//form[@id=\"DGJobBookingForm\"]//input[@id=\"CustomerPostcode\"]")
    private WebElement custPostcode;

    @FindBy(xpath = "//form[@id=\"DGJobBookingForm\"]//p[@id=\"buttonNext\"]//button[@id=\"save_btn\"]")
    private WebElement saveBtn;

    @FindBy(name = "ManualRef")
    private WebElement referralNoMNR;

    @FindBy(name = "AppointmentDate")
    private WebElement appointmentDate;

    @FindBy(id = "ReportedFault")
    private WebElement reportFault;

    @FindBy(xpath = "//form[@id=\"DGJobBookingForm\"]//span[@id=\"nextPartForm\"]//button[@id=\"save_btn\"]")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@id=\"modP\"][contains(.,\"There is an existing Open Claim with this Policy Number\")]")
    private WebElement alrtExistingClaimOnPlan;

    @FindBy(xpath = "//div[@role=\"dialog\"]//div[@class=\"ui-dialog-buttonset\"]//button[contains(.,\"Close\")]")
    private WebElement alrtCloseBtn;

    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    public ExcessAlertPage excessAlertPage;
    public NewJobBookingSuccessfulPopupPage jobBookingSuccessfulPopup;
    public NewRepairBookingPage(BasePage base, SeleniumHelper seleniumHelper, ExcessAlertPage excessAlertPage,NewJobBookingSuccessfulPopupPage jobBookingSuccessfulPopup) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        this.excessAlertPage = excessAlertPage;
        this.jobBookingSuccessfulPopup = jobBookingSuccessfulPopup;
        PageFactory.initElements(driver, this);
    }


    public boolean isNewRepairBookingPageDisplayed() {

        boolean status = false;
        try {
            if (dandgPlanNo.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void enterDataForCreatingASelfSignpostedClaim(String planNo, String surname, String postCode, String apptDate){
        base.sendFieldInputData(dandgPlanNo,planNo);
        base.sendFieldInputData(custSurname,surname);
        base.sendFieldInputData(custPostcode,postCode);
        base.clickWithJsExecutor(saveBtn);
        base.sendFieldInputData(appointmentDate,apptDate);
        base.sendFieldInputData(reportFault,"TEST FAULT CODE");
        base.clickWithJsExecutor(submitBtn);
//        if(excessAlertPage.isExcessAlertPageDisplayed()){
//            excessAlertPage.confirmExcessPayment();
//        } else {
//            LOGGER.info("No Excess required (or) Unable to create claim with out Excess");
//        }

    }

    public void confirmExcessAlert(){
        if(excessAlertPage.isExcessAlertPageDisplayed()){
            excessAlertPage.confirmExcessPayment();
        } else {
            LOGGER.info("No Excess required (or) Unable to create claim with out Excess");
        }
    }
//
//    public void createASelfSignpostedClaim(String planNo, String surname, String postCode, String apptDate){
////        base.sendFieldInputData(dandgPlanNo,planNo);
////        base.sendFieldInputData(custSurname,surname);
////        base.sendFieldInputData(custPostcode,postCode);
////        base.clickWithJsExecutor(saveBtn);
////        base.sendFieldInputData(appointmentDate,apptDate);
////        base.sendFieldInputData(reportFault,"TEST FAULT CODE");
////        base.clickWithJsExecutor(saveBtn);
////        if(excessAlertPage.isExcessAlertPageDisplayed()){
////            excessAlertPage.confirmExcessPayment();
////        } else {
////        LOGGER.info("No Excess required (or) Unable to create claim with out Excess");
////        }
//        confirmExcessAlert();

//    }

}
