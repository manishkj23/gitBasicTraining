package com.test.pages.CCAgentUI_NPV.BookingOverview;

import com.test.steps.Steps_NPV.NPVHomePageStepDef;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerDetailsSection {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private static final Logger LOGGER = LoggerFactory.getLogger(NPVHomePageStepDef.class);


    public CustomerDetailsSection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(.,\"Vulnerabilities:\")]/div[2]/strong[contains(.,\"Yes\")]")
    private List<WebElement> vulnerabilitiesCheck;


    public boolean isVulnerabilitiesYes() {
        boolean status = false;
        try {

            for (WebElement option : vulnerabilitiesCheck) {
                try {
                    if (option != null) {
                        status = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
