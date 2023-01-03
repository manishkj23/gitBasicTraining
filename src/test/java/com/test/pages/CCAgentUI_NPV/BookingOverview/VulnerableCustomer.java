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
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class VulnerableCustomer {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private static final Logger LOGGER = LoggerFactory.getLogger(NPVHomePageStepDef.class);


    public VulnerableCustomer(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//legend[contains(.,\"Vulnerable Customer\")]")
    private WebElement pageTitle;

    @FindBy(xpath = "//select[@id=\"VulnerabilityCategories\"]/../button")
    private WebElement vulnerableCategoryInput;


    private final String accessoryListXpath = "//b[contains(.,\"Accessories\")]/../ul/li[contains(.,\"${value}\")]";
    @FindBy(xpath = "//b[contains(.,\"Accessories\")]/../ul/li")
    private List<WebElement> accessoriesList;

    @FindBy(xpath = "//b[contains(.,\"Accessories\")]/../button[contains(.,\"Ok\")]")
    private WebElement okBtn;

    @FindBy(xpath = "//input[@id=\"Distressed\"]")
    private WebElement distressed;

    @FindBy(xpath = "//input[@name=\"save_btn3\"]")
    private WebElement saveBtn;

    @FindBy(xpath = "//a[contains(.,\"Save\")]")
    private WebElement dropdownSaveBtn;


    private final String vulnerableSelectiveCategoryXpath = "//ul[@class=\"ui-multiselect-checkboxes ui-helper-reset\"]/li[contains(.,\"${value}\")]//input";


    public void updateVulnerableCategory(String category) {
        if (isVulnerableCustomerPageDisplayed()) {
            base.clickElement(vulnerableCategoryInput);
            List<String> optionsList = Stream.of(category.split(","))
                    .map(String::trim)
                    .collect(toList());
            for (String option : optionsList) {
                try {
                    WebElement selectedOption = seleniumHelper.getCustomElementByXpath(vulnerableSelectiveCategoryXpath, option);
                    if (selectedOption != null) {
                        base.clickElement(selectedOption);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            base.clickElement(dropdownSaveBtn);
            base.clickElement(distressed);
            base.clickElement(saveBtn);
        } else {
            LOGGER.info("Unable to update Vulnerable Customer details");
        }

    }


    public boolean isVulnerableCustomerPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(pageTitle)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}
