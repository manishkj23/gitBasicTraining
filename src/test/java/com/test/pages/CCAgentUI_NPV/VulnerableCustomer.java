package com.test.pages.CCAgentUI_NPV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VulnerableCustomer {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public VulnerableCustomer(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id=\"JobVulnerabilityForm\"]//legend[contains(.,\"Vulnerable Customer\")]")
    private WebElement pageHeading;

    @FindBy(xpath = "//p[contains(.,\"Vulnerability Categories\")]//button/span[1]")
    private WebElement buttonToSelectCategory;

    private static final String xpathToCaptureCategory = "//ul//span[contains(.,\"$(value)\")]/../input";
//    @FindBy(xpath = xpathToCaptureCategory)

    @FindBy(xpath = "//a[contains(.,\"Save\")]")
    private WebElement saveButtonCategory;

    @FindBy(id = "Distressed")
    private WebElement distressedOption;

    @FindBy(id="save_btn3")
    private WebElement saveButtonMain;


}
