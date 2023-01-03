package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairAuthoritySection {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public RepairAuthoritySection(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"ui2_right\"][contains(.,\"Repair Authority\")]")
    private WebElement repairAuthorityPanelView;

    @FindBy(xpath = "//a[@id=\"raAuthLineSummLink\"]")
    private WebElement AuthorityLineSummaryLink;

    @FindBy(xpath = "//table[@id=\"RAHistory\"]/tbody/tr[count(*)>0]/..")
    private WebElement raHistortyTableWithStatusChange;

    @FindBy(xpath = "//span[@id=\"JobStatusText\"]")
    private WebElement jobStatus;

    public boolean isRAHistoryStatusChangesUpdated() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(raHistortyTableWithStatusChange)) {
                base.highlightElement(raHistortyTableWithStatusChange);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(raHistortyTableWithStatusChange)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(raHistortyTableWithStatusChange)) {
                    base.highlightElement(raHistortyTableWithStatusChange);
                    status = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isRAJobStatusUpdated(String outCome) {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains(outCome)) {
                base.highlightElement(jobStatus);
                status = true;
            } else {
                if (!base.checkIfELementIsAvailable(jobStatus)) {
                    base.hardWait("2000");
                }
                base.waitForPageToLoad();
                if (base.checkIfELementIsAvailable(jobStatus) && jobStatus.getText().contains(outCome)) {
                    base.highlightElement(jobStatus);
                    status = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
