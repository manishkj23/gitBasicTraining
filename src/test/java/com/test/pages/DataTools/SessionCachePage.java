package com.test.pages.DataTools;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionCachePage {
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    //    private final String counterRegexPath = "\\[COUNTER] =>\\s(.*?\\s)";
    private final String counterRegexPath = "\\[COUNTER] =>\\s(.*)";

    @FindBy(xpath = "//pre")
    private WebElement cacheResultArray;

    public SessionCachePage(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    public boolean isSessionCachePageLoaded() {
        boolean status = false;
        try {
            if (base.checkIfELementIsAvailable(cacheResultArray)) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public String findTheCounterValueFromTheSessionCache() {
        String result = seleniumHelper.searchStringRegex(counterRegexPath, cacheResultArray.getText());
        LOGGER.info("==============>>>>>> Session Cache Result : " + result);
        return (!result.isEmpty()) ? result : null;
    }

    public boolean isSessionCounterValueMatched(String noOfTimes) {
        boolean status = false;
        try {
            if (Integer.valueOf(findTheCounterValueFromTheSessionCache()) > 0 && Integer.valueOf(findTheCounterValueFromTheSessionCache()) <= Integer.valueOf(noOfTimes)) {
                status = true;
                LOGGER.info("=================>>>>>>>> Session Cache [COUNTER] => :" + findTheCounterValueFromTheSessionCache());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean isSessionCounterValueNotToBeMatched(String noOfTimes) {
        boolean status = false;
        try {
            if (Integer.valueOf(findTheCounterValueFromTheSessionCache()) == 0 && Integer.valueOf(findTheCounterValueFromTheSessionCache()) < Integer.valueOf(noOfTimes)) {
                status = true;
                LOGGER.info("=================>>>>>>>> Session Cache [COUNTER] => :" + findTheCounterValueFromTheSessionCache());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
