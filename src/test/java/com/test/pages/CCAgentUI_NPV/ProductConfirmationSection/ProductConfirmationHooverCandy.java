package com.test.pages.CCAgentUI_NPV.ProductConfirmationSection;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductConfirmationHooverCandy {


    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public ProductConfirmationHooverCandy(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//legend[contains(.,\"Product Confirmation\")]")
    private WebElement pageHeader;


    @FindBy(xpath = "//div[@id=\"productConfirmDetails\"]//select[contains(@id,\"Mod\")]/../span/a")
    private WebElement corectModelListBox;


    @FindBy(xpath = "//div[@id=\"elecJfLook\"]//span/a")
    private WebElement fault;

    @FindBy(xpath = "//button[@id=\"makeClaimBut\"]")
    private WebElement contunie_Btn;

    public boolean isPageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(pageHeader);
            if (base.checkIfELementIsAvailable(pageHeader)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterModelNumber() {
        if (isPageDisplayed()) {
            try {
                if (!base.checkIfELementIsAvailable(corectModelListBox)) {
                    base.hardWait("2000");
                }
                base.clickWithJsExecutor(corectModelListBox);
                seleniumHelper.actionToMoveDownOnList(corectModelListBox, 0);
                if (!corectModelListBox.isSelected()) {
                    base.hardWait("2000");
                    base.clickWithJsExecutor(corectModelListBox);
                    seleniumHelper.actionToMoveDownOnList(corectModelListBox, 0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void enterFault() {

        try {
            if (!base.checkIfELementIsAvailable(fault)) {
                base.hardWait("3000");
            }
            base.clickWithJsExecutor(fault);
            seleniumHelper.actionToMoveDownOnList(fault, 0);
            if (!fault.isSelected()) {
                base.hardWait("2000");
                base.clickWithJsExecutor(fault);
                seleniumHelper.actionToMoveDownOnList(fault, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickContinueButton() {
        try {
            if (base.checkIfELementIsAvailable(contunie_Btn) && base.isClickable(contunie_Btn)) {
                base.clickElement(contunie_Btn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}