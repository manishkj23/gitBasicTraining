package com.test.pages.CCAgentUI_NPV.FaultSection;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FaultCodeSectionPage {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private final String faultAreaInputXpath = "//*[@id=\"ejFc\"]/div[1]/span/input";
    private final String faultAreaPath = "//*[@id=\"ejFc\"]/div[1]/span/a";
    @FindBy(xpath = faultAreaPath)
    private WebElement faultArea;

    private final String faultInputXpath = "//div[@id=\"elecJfLook\"][contains(.,\"Fault\")]//input";
    private final String faultXpath = "//div[@id=\"elecJfLook\"][contains(.,\"Fault\")]//a";
    @FindBy(xpath = faultXpath)
    private WebElement faultListBox;

    private final String faultCodeXpath = "//*[@id=\"whirlpoolFCHolder\"]/span/a/span[1]";
    @FindBy(xpath = faultCodeXpath)
    private WebElement faultCodeListBox;

    private final String problemCodeXpath = "//*[@id=\"whirlpoolFCLookupHolder\"]/span/a/span[1]";
    @FindBy(xpath = problemCodeXpath)
    private WebElement problemCodeListBox;


    public FaultCodeSectionPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }


    public void enterFaultArea() {
        try {
            if (base.getElementFromXpath(faultAreaPath) == null) {
                base.waitForElementAndReturnJS(faultAreaPath);
            }
            base.clickWithJsExecutor(faultArea);
            seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            if (base.getElementFromXpath(faultAreaInputXpath).getAttribute("value") == null) {
                base.hardWait("2000");
                base.clickWithJsExecutor(faultArea);
                seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterFault() {
        try {
            if (base.getElementFromXpath(faultXpath) != null) {
                base.getElementFromXpath(faultXpath).click();
                seleniumHelper.actionToMoveDownOnList(base.getElementFromXpath(faultXpath), 0);
                if (base.getElementFromXpath(faultInputXpath).getAttribute("value") == null) {
                    base.hardWait("2000");
                    base.clickWithJsExecutor(base.getElementFromXpath(faultXpath));
                    seleniumHelper.actionToMoveDownOnList(base.getElementFromXpath(faultXpath), 0);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterProblemCode() {

        try {
            if (base.getElementFromXpath(problemCodeXpath) == null) {
                base.waitForElementAndReturnJS(problemCodeXpath);
            }
            base.clickWithJsExecutor(problemCodeListBox);
            seleniumHelper.actionToMoveDownOnList(problemCodeListBox, 0);
            if (!problemCodeListBox.isSelected()) {
                base.hardWait("2000");
                base.clickWithJsExecutor(problemCodeListBox);
                seleniumHelper.actionToMoveDownOnList(problemCodeListBox, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}