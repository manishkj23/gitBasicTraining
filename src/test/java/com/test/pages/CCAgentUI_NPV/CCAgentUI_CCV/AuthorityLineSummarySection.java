package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorityLineSummarySection {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public AuthorityLineSummarySection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@id=\"ServiceReportpop\"]")
    private WebElement serviceReportTextArea;

    @FindBy(xpath = "//input[@id=\"engineerName\"]")
    private WebElement engineerName;


    public void fillServiceReport() {
        try {
            if (base.checkIfELementIsAvailable(serviceReportTextArea)) {
                base.sendFieldInputData(serviceReportTextArea, "TEST AUTOMATION");

            } else {
                LOGGER.info("Service report section not displayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
