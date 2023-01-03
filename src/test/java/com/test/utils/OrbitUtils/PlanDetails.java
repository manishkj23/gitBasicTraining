package com.test.utils.OrbitUtils;

import com.gargoylesoftware.htmlunit.WebConsole;
import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import com.test.utils.CommonUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class PlanDetails {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;
    private String planNumber;
    private String claimNo;
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @FindBy(xpath = "//div[@id=\"jbTpDet\"]//div[span[contains(.,\"Claim No\")]]/span[2]")
    private WebElement currentClaimNo;

    public PlanDetails(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }


    public void setPlanNumber(String planNo) {
        this.planNumber = planNo;
    }

    public String getPlanNumber(){
        if (this.planNumber == null) {
            try {
                setPlanNumber(commonUtils.createContractApiCallForElux());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.planNumber;
        } else {
            return this.planNumber;
        }

    }

    public String getNewPlanNumber(){
        removePlanNumber();
        if (this.planNumber != null) {
            removePlanNumber();
            try {
                setPlanNumber(commonUtils.createContractApiCallForElux());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.planNumber;
        } else {
            try {
                setPlanNumber(commonUtils.createContractApiCallForElux());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.planNumber;
        }

    }
    public void removePlanNumber(){
        this.planNumber = null;
    }

    public String getCurrentClaimNumber() {
        String claimNo = null;
        try {
//            claimNo = commonUtils.getOpenClaimNo(planNumber);
            if(currentClaimNo != null && currentClaimNo.isDisplayed()){
                claimNo = currentClaimNo.getText();
            }
            LOGGER.info(" ==============>>>>>> Current Claim Number :" + claimNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimNo;

    }

    public void setClaimNumber(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getClaimNumber() {
        if (this.claimNo == null) {
            try {
                setClaimNumber(commonUtils.getOpenClaimNo(this.planNumber));
                LOGGER.info("==============>>>>>> Claim No Created : " + this.claimNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.claimNo;
        } else {
            return this.claimNo;
        }

    }

    public String getCustomerSurnameOnTheAPIRequest(String oEM) {
        String data = null;
        String filePath;
        if (oEM.equalsIgnoreCase("whirlpool")) {
            filePath = "/src/test/resources/TestDatafile/CreateContract_3BA.xml";
        } else {
            filePath = "/src/test/resources/TestDatafile/CreateContract_C1Z.xml";
        }
        FileInputStream fs = null;
        String xs = null;
        try {
            fs = new FileInputStream(System.getProperty("user.dir") + filePath);
            xs = IOUtils.toString(fs, "UTF-8");
            data = seleniumHelper.searchStringRegex("<_02:Surname>(.*?)<\\/_02:Surname>", xs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;


    }

    public String getCustomerPostcodeOnTheAPIRequest(String oEM) {
        String data = null;
        String filePath;
        if (oEM.equalsIgnoreCase("whirlpool")) {
            filePath = "/src/test/resources/TestDatafile/CreateContract_3BA.xml";
        } else {
            filePath = "/src/test/resources/TestDatafile/CreateContract_C1Z.xml";
        }
        FileInputStream fs = null;
        String xs = null;
        try {
            fs = new FileInputStream(System.getProperty("user.dir") + filePath);
            xs = IOUtils.toString(fs, "UTF-8");
            data = seleniumHelper.searchStringRegex("<_02:PostalCode>(.*?)<\\/_02:PostalCode>", xs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String getPlanNumber(String oem) {
        if (this.planNumber == null) {

            try {
                switch (oem.toUpperCase()) {
                    case "WHIRLPOOL":
                        setPlanNumber(commonUtils.createContractApiCallForWhirlpool());
                        break;
                    case "HEATING":
                        setPlanNumber(commonUtils.createContractApiCallForASV());
                        break;
                    case "HOOVER":
                        setPlanNumber(commonUtils.createContractApiCallForHoover());
                        break;
                    default:
                        setPlanNumber(commonUtils.createContractApiCallForElux());
                }
                LOGGER.info("==============>>>>>> PlanNo Created : " + this.planNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.planNumber;
        } else {
            return this.planNumber;
        }

    }

}
