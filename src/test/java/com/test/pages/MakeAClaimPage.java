package com.test.pages;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import cucumber.api.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakeAClaimPage {

    private BasePage base;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    // Local Constants for Page validations
    private static final String PLAN_SEARCH_HEADING = "Plan Search";
    private static final String PLAN_STATUS_LIVE = "LIVE";
    private static final String PLAN_STATUS_CANCELLED = "CANCELLED";
    private static final String PLAN_STATUS_LAPSED = "LAPSED";
    private static final String PRODUCT_DETAILS_HEADING = "Plan & Product Details";
    private static final String CONFIRM_PRODUCT_DETAILS_HEADING = "Confirm Product Details";

    @FindBy(xpath = "//*[@id=\"Icq_policySearchInput\"]")
    WebElement planNumberToSearch;

    @FindBy(xpath = "//a[contains(@onclick,\"PolicySearch\")]/img")
    WebElement searchButtonIcon;

    @FindBy(xpath = "//*[@id=\"sec60_search\"]//button")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"section_60\"]//fieldset/legend")
    WebElement planSearchTitle;

    @FindBy(xpath = "//*[@id=\"section_63\"]/div[1]/fieldset/legend")
    WebElement productDetailsHeading;

    private String pathToSelectPlan = "//table[@id=\"IcqPolicyProductsTable\"]//tbody/tr[contains(.,\"${value}\")]/td[7]/input";
    private String pathToSelectedPlanStatus = "//table[@id=\"IcqPolicyProductsTable\"]//tbody/tr[contains(.,\"${value}\")]/td[4]";
    @FindBy(xpath = "//*[@id=\"apl0\"]")
    WebElement productDetailsRowDisplayed;

    private static final String planStatusXpath = "";
    @FindBy(xpath = "//*[@id=\"apl0\"]/td[4]")
    WebElement planStatus;

    @FindBy(xpath = "//*[@id=\"ToolTables_IcqPolicyProductsTable_0\"]/span")
    WebElement selectProductButton;

    @FindBy(xpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/input")
    WebElement selectModelNumber;

    @FindBy(xpath = "//*[@id=\"ModleID\"]")
    WebElement modelNumberSelectBox;

    @FindBy(xpath = "//*[@id=\"whirlpoolFCHolder\"]/span/input")
    WebElement faultCode;

    @FindBy(xpath = "//*[@id=\"JobFaultCodeID\"]")
    WebElement faultCodeSelectBox;

    @FindBy(xpath = "//*[@id=\"whirlpoolFCLookupHolder\"]/span/input")
    WebElement problemCode;

    @FindBy(xpath = "//*[@id=\"JobFaultCodeLookupID\"]")
    WebElement problemCodeSelectBox;

    private final String createRequestButtonPath = "//*[@id=\"makeClaimBut\"]/button";
    @FindBy(xpath = createRequestButtonPath)
    WebElement createRequestButton;

    @FindBy(xpath = "//*[@id=\"productConfirmDetails\"]/fieldset/legend")
    WebElement confirmProductDetailsHeading;

    private final String planCancelledStatusPath = "//*[@id=\"ui-id-5\"][contains(.,\"PLAN CANCELLED\")]";
    @FindBy(xpath = planCancelledStatusPath)
    private WebElement planCancelledStatus;

    private final String planLapsedStatusPath = "//*[@id=\"ui-id-5\"][contains(.,\"PLAN LAPSED\")]";
    @FindBy(xpath = planLapsedStatusPath)
    private WebElement planLapsedStatus;

    private final String pncNumberCodePath = "//*[@id=\"pncNoCode\"]//span/input";
    @FindBy(xpath = pncNumberCodePath)
    private WebElement pncNumberCode;


    private final String pncIconPath = "//*[@id=\"pncNoCode\"]/div[1]/span/a/span[1]";
    @FindBy(xpath = pncIconPath)
    private WebElement pncIcon;

    private final String mlCodePath = "//*[@id=\"mlcCode\"]";
    @FindBy(xpath = mlCodePath)
    private WebElement mlCode;

    private final String serialCodePath = "//*[@id=\"pncSerial\"]";
    @FindBy(xpath = serialCodePath)
    private WebElement serialCode;

    private final String correctModelXpath = "//*[@id=\"SubUnitTypeSelectionFormID\"]/span/a";
    @FindBy(xpath = correctModelXpath)
    private WebElement corectModelListBox;

    private final String faultCodeXpath = "//*[@id=\"whirlpoolFCHolder\"]/span/a/span[1]";
    @FindBy(xpath = faultCodeXpath)
    private WebElement faultCodeListBox;

    private final String problemCodeXpath = "//*[@id=\"whirlpoolFCLookupHolder\"]/span/a/span[1]";
    @FindBy(xpath = problemCodeXpath)
    private WebElement problemCodeListBox;

    private final String faultAreaPath = "//*[@id=\"ejFc\"]/div[1]/span/a";
    @FindBy(xpath = faultAreaPath)
    private WebElement faultArea;

    private final String faultPath = "//*[@id=\"elecJfLook\"]/span/a/span[1]";
    @FindBy(xpath = faultPath)
    private WebElement fault;

    private final String modelNumberCodePath = "//*[@id=\"pncModelSerial\"]/div/span/a/span[1]";
    @FindBy(xpath = modelNumberCodePath)
    private WebElement modelNumberCode;

    private static final String inWarrantyClaimPath = "//div[@id=\"modP\"][contains(text(),\"This product is within the manufacturer warranty period\")]";
    @FindBy(xpath = inWarrantyClaimPath)
    private WebElement inWarrantClaim;

    private static final String isPNCNumberYes_Xpath="//*[@id=\"electroluxHolder\"]//input[@name=\"pncnyn\" and @value=\"yes\"]";
    @FindBy(xpath = isPNCNumberYes_Xpath)
    private WebElement isPNCNumberYes;

    @FindBy(xpath = "//div[@id=\"pncNoCode\"][div[contains(.,\"PNC Number\")]]//a")
    private WebElement pncIconNPV;

    private final String correctModelForBoilerXpath = "//*[@id=\"pncModelSerial\"]/div/span/a/span[1]";
    @FindBy(xpath = correctModelForBoilerXpath)
    private WebElement corectModelListBoxForBoiler;

    String selectClaimTypeXpath = "//*[@id=\"ClaimTypesloadSpan\"]/div[contains(.,\"${value}\")]//img";

    public MakeAClaimPage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public void searchForAPlan(String planNo) {
        try {
            base.waitTillElementFound(planNumberToSearch);
            base.sendFieldInputData(planNumberToSearch, planNo);
            base.waitTillElementFound(searchButtonIcon);
            if (searchButtonIcon.isDisplayed()) {
                searchButtonIcon.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPlanSearchTitleExist() {
        base.waitTillElementFound(planSearchTitle);
        return (planSearchTitle.getText().contains(PLAN_SEARCH_HEADING)) ? true : false;
    }

    public boolean checkIfFaultDetailsEnteredSuccessfully() {
        return (problemCode.isDisplayed()) ? true : false;
    }

    public boolean isConfirmProductDetailsSectionLoaded() {
        base.waitTillElementFound(confirmProductDetailsHeading);
        return (confirmProductDetailsHeading.getText().contains(CONFIRM_PRODUCT_DETAILS_HEADING)) ? true : false;
    }

    public boolean isPlanDetailsDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(productDetailsHeading);
            base.waitTillElementFound(productDetailsRowDisplayed);
            if (productDetailsHeading.getText().contains(PRODUCT_DETAILS_HEADING) & productDetailsRowDisplayed.isDisplayed()) {
                base.highlightElementWithScreenshot(productDetailsHeading, "productDetailsHeading_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private void tickPlanOnPlanDetailsifNotChecked(String planNo) {
        try {
            WebElement selectPlanCheckBox = seleniumHelper.getCustomElementByXpath(pathToSelectPlan, planNo);
            base.waitTillElementFound(selectPlanCheckBox);
            if (!selectPlanCheckBox.isSelected()) {
                selectPlanCheckBox.click();
                LOGGER.info("======>>>>>>> Selected a plan on Plan Details ");
            } else {
                LOGGER.info("======>>>>>>> Select a Plan from the Plan details already checked ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkIfProvidePNCIsNotChecked() {
        boolean status = false;
        try {
            WebElement isPNC = base.getElementFromXpath(isPNCNumberYes_Xpath);
            base.waitTillElementFound(isPNC);
            if (isPNC.isDisplayed()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public void tickProvidePNCifNotChecked() {
        try {
            WebElement isPNC = base.getElementFromXpath(isPNCNumberYes_Xpath);
            base.waitTillElementFound(isPNC);
            if (!isPNC.isSelected()) {
                isPNC.click();
                LOGGER.info("======>>>>>>> Clicked Provide PNC Number to Yes");
            } else {
                LOGGER.info("======>>>>>>> Unable to click Provide PNC Number to Yes ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isPlanInLiveStatusForMasterPlan(String planNo) {
        boolean status = false;
        try {
            WebElement selectedPlanStatus = seleniumHelper.getCustomElementByXpath(pathToSelectedPlanStatus, planNo);
            base.waitTillElementFound(selectedPlanStatus);
            if (selectedPlanStatus != null && selectedPlanStatus.isDisplayed()) {
                base.highlightElement(selectedPlanStatus);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isPlanInLiveStatus() {
        base.waitTillElementFound(planStatus);
        base.highlightElementWithScreenshot(planStatus, "PlanStatus");
        return (planStatus.getText().contains(PLAN_STATUS_LIVE)) ? true : false;

    }

    public boolean isPlanInCancelledStatus() {
        base.waitTillElementFound(planStatus);
        return (planStatus.getText().contains(PLAN_STATUS_CANCELLED)) ? true : false;

    }

    public boolean isPlanInLapsedStatus() {
        base.waitTillElementFound(planStatus);
        return (planStatus.getText().contains(PLAN_STATUS_LAPSED)) ? true : false;

    }

    public void clickSelectProduct(String planNo) {
        try {
            tickPlanOnPlanDetailsifNotChecked(planNo);
            base.waitTillElementFound(selectProductButton);
            if (base.checkIfELementIsAvailable(selectProductButton)) {
                selectProductButton.click();
            }
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectClaimType(String type) {

        WebElement claimType = seleniumHelper.getCustomElementByXpath(selectClaimTypeXpath, type);
        if (claimType != null) {
            base.waitTillElementFound(claimType);
            base.clickWithJsExecutor(claimType);
        } else {
            LOGGER.info("========>>>>>> Element not found for the Claim Type : " + type.toString());

        }

    }

    public void enterAndConfirmProductDetails(String modelNumber, String faultCode, String problemCode) {
        enterModelNumber(modelNumber);
        enterFaultCode(faultCode);
        enterProblemCode(problemCode);
        base.waitToLoadElement();
    }

    public void clickCreateRequest() {
        if (isCreateRequestButtonEnabled()) {
            base.clickWithJsExecutor(createRequestButton);
        }
    }

    public boolean isCreateRequestButtonEnabled() {
        WebElement button = base.getElementFromXpath(createRequestButtonPath);
        base.highlightElementWithScreenshot(button, "CreateRequestButton_" + seleniumHelper.getCurrentDate("dd_MM_yyyy"));
        return (button != null && button.isEnabled()) ? true : false;
    }

    public boolean isPlanInWarranty() {
        WebElement warranty = base.getElementFromXpath(inWarrantyClaimPath);
        base.highlightElementWithScreenshot(warranty, "PlanInWarranty");
        return (warranty != null && warranty.isDisplayed()) ? true : false;
    }

    private void enterModelNumber(String value) {
        try {
            base.waitTillElementFound(selectModelNumber);
            if (selectModelNumber.isDisplayed() & selectModelNumber.getText() == null) {
                base.clearText(selectModelNumber);
                base.sendFieldInputData(selectModelNumber, value);
                seleniumHelper.actionToMoveDownOnList(selectModelNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("====>>>>> Unable to find the Model Number : " + value);
        }

    }

    private void enterFaultCode(String value) {
        try {
            base.waitToLoadElement();
            if (faultCode.isDisplayed()) {
                base.sendFieldInputData(faultCode, value);
                base.waitToLoadElement();
                seleniumHelper.actionToMoveDownOnList(faultCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("====>>>>> Unable to find the Fault Code contains value : " + value);
        }

    }

    private void enterProblemCode(String value) {
        try {
            base.waitToLoadElement();
            if (problemCode.isDisplayed()) {
                base.sendFieldInputData(problemCode, value);
                base.waitToLoadElement();
                seleniumHelper.actionToMoveDownOnList(problemCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("====>>>>> Unable to find the Fault Code contains value : " + value);
        }

    }

    public boolean isPlanCancelledPopupExist() {
        boolean status = false;
        WebElement element = null;
        try {
            element = base.getElementFromXpath(planCancelledStatusPath);
            if (element != null && element.isDisplayed()) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean isPlanLapsedPopupExist() {
        boolean status = false;
        WebElement element = null;
        try {
            element = base.getElementFromXpath(planLapsedStatusPath);
            if (element != null && element.isDisplayed()) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isConfirmProductDetailsSectionDisplayed() {
        boolean status = false;
        WebElement element = null;
        try {
            element = base.getElementFromXpath(pncNumberCodePath);
            if (element != null && element.isDisplayed()) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isConfirmProductDetailsSectionDisplayedForModel() {
        boolean status = false;
        WebElement element = null;
        try {
            element = base.quickWait(modelNumberCodePath);
            if (element != null && element.isDisplayed()) {
                status = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void enterCorrectModel(){
//        base.waitForElementAndReturnJS(correctModelXpath);
        try{
            if (base.getElementFromXpath(correctModelXpath) == null) {
                base.waitForElementAndReturnJS(correctModelXpath);
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

    public void enterFaultCode(){
//        base.waitForElementAndReturnJS(faultCodeXpath);
        try{
            if (base.getElementFromXpath(faultCodeXpath) == null) {
                base.waitForElementAndReturnJS(faultCodeXpath);
            }
            base.clickWithJsExecutor(faultCodeListBox);
            seleniumHelper.actionToMoveDownOnList(faultCodeListBox, 0);
            if (!faultCodeListBox.isSelected()) {
                base.hardWait("2000");
                base.clickWithJsExecutor(faultCodeListBox);
                seleniumHelper.actionToMoveDownOnList(faultCodeListBox, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterProblemCode(){

        try{
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

    public void enterConfirmProductDetailsSectionForPNC(String pncNumber) {

//        base.sendFieldInputData(pncNumberCode, pncNumber);
        try {
            base.clickWithJsExecutor(pncIcon);
            seleniumHelper.actionToMoveDownOnList(pncNumberCode,0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        base.sendFieldInputData(mlCode, "03");
        base.sendFieldInputData(serialCode, "1234");
//        base.waitForElementAndReturnJS(faultAreaPath);
        try {
            if (base.getElementFromXpath(faultAreaPath) == null) {
                base.waitForElementAndReturnJS(faultAreaPath);
            }
            base.clickWithJsExecutor(faultArea);
            seleniumHelper.actionToMoveDownOnList(faultArea, 0);

            if (!faultArea.isSelected()) {
                base.clickWithJsExecutor(faultArea);
                seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            }
//            base.waitForElementAndReturnJS(faultPath);
            if (base.getElementFromXpath(faultPath) == null) {
                base.waitForElementAndReturnJS(faultPath);
            }
            base.clickWithJsExecutor(fault);
            seleniumHelper.actionToMoveDownOnList(fault, 0);
            if (!fault.isSelected()) {
                base.clickWithJsExecutor(fault);
                seleniumHelper.actionToMoveDownOnList(fault, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterConfirmProductDetailsSectionForModel(String modelCode) {
        try {
            base.waitForElementAndReturnJS(modelNumberCodePath);
            base.clickWithJsExecutor(modelNumberCode);
            seleniumHelper.actionToMoveDownOnList(modelNumberCode, 1);
            base.waitForElementAndReturnJS(faultPath);
            base.clickWithJsExecutor(fault);
            seleniumHelper.actionToMoveDownOnList(fault, 1);
            if (!fault.isSelected()) {
                base.clickWithJsExecutor(fault);
                seleniumHelper.actionToMoveDownOnList(fault, 1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterConfirmProductDetailsSectionForPNCForNPV(String pncNumber) {

//        base.sendFieldInputData(pncNumberCode, pncNumber);
        try {
            base.clickWithJsExecutor(pncIconNPV);
            seleniumHelper.actionToMoveDownOnList(pncNumberCode, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        base.sendFieldInputData(mlCode, "03");
        base.sendFieldInputData(serialCode, "1234");
//        base.waitForElementAndReturnJS(faultAreaPath);
        try {
            if (base.getElementFromXpath(faultAreaPath) == null) {
                base.waitForElementAndReturnJS(faultAreaPath);
            }
            base.clickWithJsExecutor(faultArea);
            seleniumHelper.actionToMoveDownOnList(faultArea, 0);

            if (!faultArea.isSelected()) {
                base.clickWithJsExecutor(faultArea);
                seleniumHelper.actionToMoveDownOnList(faultArea, 0);
            }
//            base.waitForElementAndReturnJS(faultPath);
            if (base.getElementFromXpath(faultPath) == null) {
                base.waitForElementAndReturnJS(faultPath);
            }
            base.clickWithJsExecutor(fault);
            seleniumHelper.actionToMoveDownOnList(fault, 0);
            if (!fault.isSelected()) {
                base.clickWithJsExecutor(fault);
                seleniumHelper.actionToMoveDownOnList(fault, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterCorrectModelForBoiler() {
//        base.waitForElementAndReturnJS(correctModelXpath);
        try {
            if (base.getElementFromXpath(correctModelForBoilerXpath) == null) {
                base.waitForElementAndReturnJS(correctModelForBoilerXpath);
            }
            base.clickWithJsExecutor(corectModelListBoxForBoiler);
            seleniumHelper.actionToMoveDownOnList(corectModelListBoxForBoiler, 0);
            if (!corectModelListBoxForBoiler.isSelected()) {
                base.hardWait("2000");
                base.clickWithJsExecutor(corectModelListBoxForBoiler);
                seleniumHelper.actionToMoveDownOnList(corectModelListBoxForBoiler, 0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterFaultOnly() {
//        base.waitForElementAndReturnJS(faultCodeXpath);
        try {

            if (base.getElementFromXpath(faultPath) != null) {
                base.getElementFromXpath(faultPath).click();
                seleniumHelper.actionToMoveDownOnList(base.getElementFromXpath(faultPath), 0);
                if (!base.getElementFromXpath(faultPath).isSelected()) {
                    base.hardWait("2000");
                    base.clickWithJsExecutor(base.getElementFromXpath(faultPath));
                    seleniumHelper.actionToMoveDownOnList(base.getElementFromXpath(faultPath), 0);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
