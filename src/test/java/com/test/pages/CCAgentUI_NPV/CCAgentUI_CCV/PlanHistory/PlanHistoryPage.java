package com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanHistory;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlanHistoryPage {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;


    @FindBy(xpath = "//div[@id=\"PlanHistory_Claims\"]//table//tbody/tr[1]/td[4][contains(.,\"Repair Completed via Triage\")]")
    private WebElement claimCompletedStatus;

    @FindBy(xpath = "//div[@id=\"PlanHistory_Claims\"]//table//tbody/tr[1]/td[1]")
    private WebElement currentClaimDisplayed;

    //Main Functionality
    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Header\"]")
    private WebElement planHistoryTabPageHeading;

    @FindBy(id = "PlanHistory_Tabs_Claims")
    private WebElement claimsTab;

    @FindBy(xpath = "//button[@id=\"PlanHistory_Tabs_Interactions\"][contains(.,\"Customer Interactions\")]")
    private WebElement customerInteractionsTab;

    @FindBy(xpath = "//button[@id=\"PlanHistory_Tabs_Interactions\"][contains(.,\"WorkQ Tasks\")]")
    private WebElement workQTaskTab;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody")
    private WebElement claimsTableBodyAllClaims;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody//tr[1]")
    private WebElement currentClaimOnClaimsTab;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody//tr[1]/td[1]/a")
    private WebElement currentClaimUrlBtn;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody//tr[1]/td[1]/span/i")
    private WebElement currentClaimStatusProgressBar;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody//tr[1]/td[2]/span")
    private WebElement currentClaimType;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody//tr[1]/td[4]")
    private WebElement currentClaimStatus;

    @FindBy(xpath = "//div[@id=\"PlanView_PlanHistory_Content\"]//table//th[contains(.,\"Claim No\")]/../../..//tbody//tr[1]/td[5]")
    private WebElement currentClaimServiceProvider;

    @FindBy(xpath = "//div[@id=\"PlanHistory_Claims\"]//span[contains(text(),\"COMPLETED\")]//parent::td//following-sibling::td[3]")
    private WebElement completedClaimStatus;

    @FindBy(xpath = "//div[@id=\"PlanHistory_Claims\"]//span[contains(text(),\"IN PROGRESS\")]//parent::td//following-sibling::td[3]")
    private WebElement inprogressClaimStatus;

    private static final String OpenClaimWithStatusXpath = "//div[@id=\"PlanHistory_Claims\"]//td[text()=\"${value}\"]//preceding-sibling::td//a";

    @FindBy(xpath = "//div[@id=\"PlanHistory_Claims\"]//span[contains(text(),\"Product Replacement\")]")
    private WebElement verifyPRClaim;

    private static final String OpenClaimWithTypeXpath ="//div[@id=\"PlanHistory_Claims\"]//span[contains(text(),\"${value}\")]//parent::td//preceding-sibling::td//a[contains(@onclick,'openClaim')]";

    private static final String PRClaimStatus= "//div[@id='PlanHistory_Claims']//th[text()='Service Provider']//following::tr[${value}]//td[4]" ;

    @FindBy(xpath = "//div[@id='PlanHistory_Claims']//span[contains(text(),'Product Replacement')]//following::td[3]")
    private WebElement serviceProvider;

    @FindBy(xpath = "//a[@id=\"OpenClaimBtn\"]")
    private WebElement openClaimBtn;

    public PlanHistoryPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isPlanHistorySectionDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(currentClaimDisplayed);
            if (currentClaimDisplayed.isDisplayed()) {
                base.highlightElement(currentClaimDisplayed);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean isClaimStatusDisplayedAsRepairCompletedViaTriage() {
        boolean status = false;
        try {
            base.waitTillElementFound(claimCompletedStatus);
            if (claimCompletedStatus.isDisplayed()) {
                base.highlightElement(claimCompletedStatus);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickCustomerInteractionsTab(){
        base.clickWithJsExecutor(customerInteractionsTab);
    }

    public boolean hasCustomerInteractionsTabDisplayed(){
        boolean status = false;
        try {
            base.waitTillElementFound(currentClaimDisplayed);
            if (currentClaimDisplayed.isDisplayed()) {
                base.highlightElement(currentClaimDisplayed);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void clickClaimNoLinkWithStatusAS(String claimStatus)

    {
        WebElement claimNoLink = seleniumHelper.getCustomElementByXpath(OpenClaimWithStatusXpath, claimStatus);
        base.clickWithJsExecutor(claimNoLink);

    }
    public boolean verifyIfPRClaimCreated() {
        boolean status = false;
        try {
            if (base.isElementAvailable(verifyPRClaim)) {
                base.highlightElement(verifyPRClaim);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void openClaimWithTypeAs(String claimType)
    {
        WebElement claimNoLink = seleniumHelper.getCustomElementByXpath(OpenClaimWithTypeXpath, claimType);
        base.clickWithJsExecutor(claimNoLink);
        if (base.checkIfELementIsAvailable(openClaimBtn) && base.isClickable(openClaimBtn)) {
            base.highlightElement(openClaimBtn);
            base.clickElement(openClaimBtn);
            base.switchToNextTab();
            base.waitForPageToLoad();
        }

    }

    public boolean verifyClaimStatus(String claimStatus) {
        boolean statusFound = false;
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='PlanHistory_Claims']//th[text()='Service Provider']//following::tr//td[4]"));
        try {
            for(int i=1; i<=rows.size(); i++)
            {
                WebElement status = seleniumHelper.getCustomElementByXpath(PRClaimStatus, String.valueOf(i));
                if (status.getText().equals(claimStatus)) {
                    base.highlightElement(status);
                    statusFound = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusFound;
    }

    public boolean verifyPRServiceProvider(String sp) {
        boolean status = false;
        try {
            base.waitTillElementFound(serviceProvider);
            seleniumHelper.actionToMoveToElement(serviceProvider);
            if (serviceProvider.getText().equals(sp)) {
                base.highlightElement(serviceProvider);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}