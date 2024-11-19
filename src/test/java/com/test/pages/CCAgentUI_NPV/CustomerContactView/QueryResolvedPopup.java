package com.test.pages.CCAgentUI_NPV.CustomerContactView;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryResolvedPopup {
    BasePage base;
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public QueryResolvedPopup(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@role=\"dialog\"]//span[contains(.,\"Query Resolved\")]")
    private WebElement queryResolvedPopupPageTitle;

    @FindBy(id="resolvedReason")
    private WebElement resolvedReason;

    @FindBy(id="resolvedNote")
    private WebElement resolvedNotes;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"Confirm\")]")
    private WebElement confirmBtn;


    @FindBy(xpath = "//div[@role=\"dialog\"]//button[contains(.,\"No\")]")
    private WebElement declineBtn;

}