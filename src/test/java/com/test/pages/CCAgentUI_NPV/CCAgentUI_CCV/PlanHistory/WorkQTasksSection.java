package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanHistory;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkQTasksSection {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;


    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Task Reference\")]/../../..//tbody//tr[1]/td[1]//b")
    private WebElement currentWorkQTaskID;

    @FindBy(xpath ="//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Task Reference\")]/../../..//tbody//tr[1]/td[3]/a")
    private WebElement currentCustomerInteractionID;

    public WorkQTasksSection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }



}