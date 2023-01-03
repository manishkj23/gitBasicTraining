package com.test.pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import javax.swing.plaf.basic.BasicArrowButton;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class tutorial {

        public WebDriver driver;
        private Instant wait1;
        private WebDriverWait wait;

        @FindBy(id = "name")
        WebElement userName;
        @FindBy(id = "password")
        WebElement password;
        @FindBy(xpath = "//*[@id=\"displayLoginButton\"]/button")
        WebElement loginBtn;
        @FindBy(xpath = "/html/body/div[4]/div[1]/div[5]/div[3]/div[1]/div/form/fieldset/table/tbody/tr/td/span/div/div/a/img")
        WebElement createClaim;
        @FindBy(id = "Icq_policySearchInput")
        WebElement policySearch;
        @FindBy(xpath = "//*[@id=\"sec60_search\"]/div/table/tbody/tr/td[1]/div[2]/a")
        WebElement searchButton;
        @FindBy(xpath = "//div[@id=\"BookingTypeHolder\"]/div[@id=\"BookingType_AD\"]")
        WebElement damageClaim;
        @FindBy(xpath = "//*[@id=\"CustomerMobile\"]")
        WebElement mobileNumber;
        @FindBy(xpath = "//*[@id=\"nextBtnCustomer\"]")
        WebElement continueButton;



        @Test
        public void damageClaim() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            this.driver = new ChromeDriver();
            driver.navigate().to("https://www.skylinecms.co.uk/domgenprelive/Login");

            // main important statement
            PageFactory.initElements(driver, this);
            if (userName.isDisplayed()) {
                userName.sendKeys("OrbitAutoPauline");
            } else {
                wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.visibilityOf(userName));
                userName.sendKeys("Test");
            }
            if (password.isDisplayed()) {
                password.sendKeys("Automation1");
            } else {
                wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.visibilityOf(password));
                userName.sendKeys("Automation1");
            }
            if (loginBtn.isDisplayed()) {
                loginBtn.click();
            } else {
                wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.visibilityOf(loginBtn));
                loginBtn.click();
            }
            wait = new WebDriverWait(driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(createClaim));

            if (createClaim.isDisplayed()) {
                createClaim.click();
            } else {
                wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(createClaim));
                createClaim.click();
            }
            if (policySearch.isDisplayed()) {
                policySearch.sendKeys("4HH0482825");
            } else {
                wait = new WebDriverWait(driver,60);
                wait.until(ExpectedConditions.visibilityOf(policySearch));
                policySearch.sendKeys("4HH0482825");

            }
            if (searchButton.isDisplayed()){
                searchButton.click();
            }else {
                wait = new WebDriverWait(driver,60);
                wait.until(ExpectedConditions.elementToBeClickable(searchButton));
                searchButton.click();
            }
//            wait = new WebDriverWait(driver, 150);
//            wait.until(ExpectedConditions.elementToBeClickable(damageClaim));
//
//            if (damageClaim.isSelected()){
//                damageClaim.click();
//            } else {
//                wait = new WebDriverWait(driver,120);
//                wait.until(ExpectedConditions.elementToBeClickable(damageClaim));
//                damageClaim.click();
//            }

            Thread.sleep(5000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", damageClaim);

            if (mobileNumber.isDisplayed()) {
                mobileNumber.sendKeys("07774337828");
            } else {
                wait = new WebDriverWait(driver,60);
                wait.until(ExpectedConditions.visibilityOf(mobileNumber));
            }
            if (continueButton.isDisplayed()) {
                continueButton.click();
            } else {
                wait = new WebDriverWait(driver,60);
                wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            }
        }

}
