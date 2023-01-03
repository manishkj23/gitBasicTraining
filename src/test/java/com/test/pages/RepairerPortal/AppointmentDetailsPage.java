package com.test.pages.RepairerPortal;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppointmentDetailsPage {

    private static String pgMainHeading = "Appointment Details";
    public String pathForAvailableDatePath = "//*[@id=\"mainAppointmentCalendarTable\"]//tr/td[contains(@class,\"dayAvailable\")][${input}]";

    @FindBy(xpath = "//*[@id=\"mainAppointmentCalendarTable\"]//tr/td[contains(@class,'dayAvailable')][1]")
    private WebElement firstAvailableAppointment;

    @FindBy(xpath = "//*[@id=\"appointmentDetailsHolder\"]/fieldset/legend/text()")
    private WebElement pageHeading;

    @FindBy(xpath = "//*[@id=\"juBookJobAppB3\"]")
    private WebElement bookAppointmentButton;

    private WebDriver driver;
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName() );

    public AppointmentDetailsPage(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isAppointmentDetailsPageLoaded(){
        boolean status = false;
        try {
            if (pageHeading.getText() == pgMainHeading) {
                status = true;
            }
        } catch ( Exception e) {
            LOGGER.error("Unable to load the Appointment Details Page");
        }
        return status;
    }

    public void bookFirstAvailableAppointment() throws InterruptedException {
        base.checkIfELementIsAvailable(firstAvailableAppointment);
        Thread.sleep(5000);
        firstAvailableAppointment.click();
        Thread.sleep(2000);
        base.checkIfELementIsAvailable(bookAppointmentButton);
        bookAppointmentButton.click();
        Thread.sleep(2000);

    }

    public void bookAppoimentForCC(String days) {

        try{
            WebElement nextAvailableAppointment = driver.findElement(By.xpath(pathForAvailableDatePath.replace("${input}",days)));
            if(nextAvailableAppointment.isDisplayed()) {
                base.waitForElementVisible(nextAvailableAppointment);
                nextAvailableAppointment.click();
                Thread.sleep(3000);
                base.checkIfELementIsAvailable(bookAppointmentButton);
                bookAppointmentButton.click();
            } else {
                LOGGER.error("Unable to Load Next Available Appointment");            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}