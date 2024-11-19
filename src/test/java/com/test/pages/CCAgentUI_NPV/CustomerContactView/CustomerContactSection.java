package com.test.pages.CCAgentUI_NPV.CustomerContactView;

import com.test.pages.CCAgent_OLDUI.MakeAClaimPage;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerContactSection {
    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    private MakeAClaimPage claimPage;

    private static String CUSTOMER_CONTACT_PAGE_HEADING = "Customer Contact";

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public CustomerContactSection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id=\"PlanView_CustomerContact_Header\"]/span")
    private WebElement customerContactHeadingText;

    private static String callTypeXpath = "//div[@id=\"PlanView_CustomerContact_Content\"]//b[contains(.,\"Select a Call Type\")]/../../span/span[contains(.,\"${value}\")]";


    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//h5[contains(.,\"Customer Contact\")]/../div[1]/span")
    private WebElement latestCustomerContactClaim;



    @FindBy(id = "IcqAnswerButton")
    private WebElement nextButton;

    public boolean isNextButtonEnabled() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(nextButton) &&
                    base.isClickable(nextButton)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}