package com.test.pages.CCAgentUI_NPV.Aquant;


import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AquantHomePage {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;


    @FindBy(xpath = "//span[@data-testid=\"workOrderValue\"]")
    private WebElement workOrderID;

    @FindBy(xpath = "//input[@id=\"model\"]")
    private WebElement modelNumber;

    @FindBy(id = "observationInput_0")
    private WebElement searchObservation;

    @FindBy(xpath = "//span[@class=\"aquiButton__text\"][contains(.,\"Next\")]")
    private WebElement searchObservationNextButton;

    @FindBy(xpath = "//h4[@id=\"nextQuestionText\"]/span")
    private WebElement questionSection;

    private static final String answerSectionXpath = "//div[@class=\"question__answer-actions\"]//span[contains(.,\"${value}\")]";
    private static final String evidenceSectionXpath = "//div[@class=\"evidences\"]//div[contains(.,\"${value}\")]";
    private static final String solveSectionXpath = "//div[@class=\"solution-list\"]/div[contains(.,\"${value}\")]//button[contains(.,\"Solve\")]";
    private static final String solvedStatusSectionXpath = "//div[@class=\"solution-list\"]/div[contains(.,\"${value}\")]//button[contains(.,\"Solved\")]";

    @FindBy(xpath = "//span[@class=\"aquiButton__text\"]/div[contains(.,\"Save\")]")
    private WebElement saveAquantJourney;


    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public AquantHomePage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isAquantHomePageDisplayed() {
        boolean status = false;
        try {
            base.waitTillElementFound(searchObservation);
            if (searchObservation.isDisplayed()) {
                base.highlightElement(searchObservation);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public void enterSearchObservation(String fault){
        base.waitForElementVisible(searchObservation);
        base.sendFieldInputData(searchObservation,fault);
        base.clickElement(searchObservationNextButton);

    }

    public boolean isQuestionSectionDisplayed(){
        boolean status = false;
        try {
            base.waitTillElementFound(questionSection);
            if (questionSection.isDisplayed()) {
                base.highlightElement(searchObservation);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isQuestionSectionDisplayed(String question){
        boolean status = false;
        try {
            base.waitTillElementFound(questionSection);
            if (questionSection.isDisplayed() && questionSection.getText().contains(question)) {
                base.highlightElement(searchObservation);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void setAnswerAquantQA(String qaType, String question, String ans) {
        if (!base.checkIfELementIsAvailable(questionSection)) {
            base.hardWait("3000");
            base.waitTillElementFound(questionSection);
        }
        switch (qaType.toUpperCase()) {
            case "OBSERVATION": {
                enterSearchObservation(ans);
                break;
            }
            case "RADIOBUTTON": {
                if (isQuestionSectionDisplayed(question)) {
                    WebElement answer = seleniumHelper.getCustomElementByXpath(answerSectionXpath, ans);
                    base.isClickable(answer);
                    base.clickElement(answer);

                } else {
                    LOGGER.info("Unable to verify the Question : " + question + " on Aquant Page ");
                }
                break;
            }
        }
    }

    public boolean isEvidenceSectionLoaded(String evidennceLabel){
        boolean status = false;
        try {
            WebElement evidence = seleniumHelper.getCustomElementByXpath(evidenceSectionXpath,evidennceLabel);
            base.waitTillElementFound(evidence);
            if (evidence.isDisplayed()) {
                base.highlightElement(searchObservation);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void confirmSolution(String solutionLabel){
        WebElement solutionToFault = seleniumHelper.getCustomElementByXpath(solveSectionXpath,solutionLabel);
        base.checkIfELementIsAvailable(solutionToFault);
        base.clickElement(solutionToFault);

    }

    public void clickSaveAquantJourney(){
        base.clickElement(saveAquantJourney);
    }

    public boolean isSolutionMarkedAsSolved(String solutionLabel){
        boolean status = false;
        try {
            WebElement solutionToFault = seleniumHelper.getCustomElementByXpath(solvedStatusSectionXpath,solutionLabel);
            base.checkIfELementIsAvailable(solutionToFault);
            if (solutionToFault.isDisplayed()) {
                base.highlightElement(searchObservation);
                status = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}