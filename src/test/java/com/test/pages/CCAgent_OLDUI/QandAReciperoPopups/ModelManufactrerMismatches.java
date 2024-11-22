package com.test.pages.CCAgent_OLDUI.QandAReciperoPopups;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelManufactrerMismatches {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public ModelManufactrerMismatches(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@role=\"dialog\"]//div[@id=\"UIqaRuleDiv\"]/div/div[contains(.,\"Manufacturer Mismatches\")]")
    private WebElement manufacturerMismatchDialogHeader;

    @FindBy(xpath = "//*[@role=\"dialog\"]//div[@id=\"UIqaRuleDiv\"]//table//tr[contains(.,\"Model\")]/td[2]")
    private WebElement planModelNumber;

    @FindBy(xpath = "//*[@role=\"dialog\"]//div[@id=\"UIqaRuleDiv\"]//table//tr[contains(.,\"Model\")]/td[3]")
    private WebElement reciperoModelNumber;

    @FindBy(xpath = "//*[@role=\"dialog\"]//div[@id=\"UIqaRuleDiv\"]//table//tr[contains(.,\"Manufacturer\")]/td[2]")
    private WebElement planManufacturer;

    @FindBy(xpath = "//*[@role=\"dialog\"]//div[@id=\"UIqaRuleDiv\"]//table//tr[contains(.,\"Manufacturer\")]/td[3]")
    private WebElement reciperoManufacturer;

    @FindBy(xpath = "//*[@role=\"dialog\"]//button[contains(.,\"Override\")]")
    private WebElement overrideButton;

    @FindBy(xpath = "//*[@role=\"dialog\"]//button[contains(.,\"Continue\")]")
    private WebElement continueButton;


}
