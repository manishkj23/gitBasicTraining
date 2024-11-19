package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanHistory;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInteractionsSection {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;


    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//td[contains(.,\"Customer Contact\")]/../..//tr[1]")
    private WebElement currentCCInteractionRecord;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//td[contains(.,\"Customer Contact\")]/../..//tr[1]/td[1]/span")
    private WebElement currentCCInteractionRecordStatus;



    @FindBy(xpath = "//div[@id=\"PlanHistory_Claims\"]//table//tbody/tr[1]/td[1]")
    private WebElement currentClaimDisplayed;

    public CustomerInteractionsSection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }



}