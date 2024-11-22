package com.test.pages.CCAgentUI_NPV.WorkQTask;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWorkQTaskPage {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;


    private static String teamTasksContentXpath = "//div[@id=\"WorkQ_Content\"]/div//div[1][@id=\"WorkQ_MyTasks_Content\"]";

    @FindBy(xpath = "//div[@id=\"selectTeamPanel\"]//button[contains(.,\"Go\")]")
    private WebElement selectTeamGoBtn;


    public MyWorkQTaskPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

}
