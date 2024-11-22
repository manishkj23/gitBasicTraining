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

public class ViewAccessories {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private static final Logger LOGGER = LoggerFactory.getLogger(NPVHomePageStepDef.class);

    public ViewAccessories(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"cboxLoadedContent\"]/div[contains(.,\"Accessory Only Exchange\")]")
    private WebElement accessoryHeaderTitle;

    private final String accessoryListXpath = "//b[contains(.,\"Accessories\")]/../ul/li[contains(.,\"${value}\")]";
    @FindBy(xpath = "//b[contains(.,\"Accessories\")]/../ul/li")
    private List<WebElement> accessoriesList;

    @FindBy(xpath = "//b[contains(.,\"Accessories\")]/../button[contains(.,\"Ok\")]")
    private WebElement okBtn;

    @FindBy(xpath = "//b[contains(.,\"Accessories\")]/../button[contains(.,\"Ok\")]")
    private WebElement referralNumber;


    public boolean isAccessoriesPageDisplayed() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(accessoryHeaderTitle)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean checkAccessoriesSelected(List<String> accessories) {
        boolean status = false;
        try {
            if (isAccessoriesPageDisplayed()) {
                for (String option : accessories) {

                    WebElement selectedOption = seleniumHelper.getCustomElementByXpath(accessoryListXpath, option);
                    if (selectedOption != null) {
                        status = true;
                    } else {
                        status = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isReferalNumberDisplayed() {
        base.highlightElement(referralNumber);
        return (referralNumber.isDisplayed()) ? true : false;
    }



}
