package com.test.utils;


//import cucumber.api.Scenario;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
//import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
//import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {

    private WebDriver driver;
    //    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public Properties prop;
    public JavascriptExecutor jsExecutor;
    private WebDriverWait wait;
    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    private static final int PAGE_LOAD_TIMEOUT = 60;
    private static final int WAIT_TIME = 30;
    public String scenarioName;
    public byte[] allScreenshots = null;
    public Scenario myScenario;
    public SoftAssert softAssert = new SoftAssert();
    public BrowserMobProxy proxy = new BrowserMobProxyServer();
    private ArrayList<String> tabs;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    private Set<Cookie> loginCookies;

    /**
     * @ Veera - Orbit
     * Usage of PropertyInjector Class
     * - Use the PropertyInjector Class instead of Properties.
     * - The Class methods are all inherited from Properties and has some additional option.
     * - Enables the properties to load from either system or from the class path during runtime
     */

    public void loadProperties() {
        try {
            Properties configProp = new PropertyInjector();
            FileInputStream cp = new FileInputStream(System.getProperty("user.dir") + ProjectDefaults.PROP_CONFIG_FILE_LOCATION);
            configProp.load(cp);
            cp.close();

            LOGGER.info("==============>>>>>> Environment to Execute: " + configProp.getProperty("ENV"));

            String filePath = "/src/test/resources/properties/" + configProp.getProperty("ENV").toLowerCase() + ".properties";
            LOGGER.info("==============>>>>>> Path to the Properties File : " + filePath);

            this.prop = new PropertyInjector();
            FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
            this.prop.load(fs);
            fs.close();
            LOGGER.info("==============>>>>>> Properties file Loaded ");
            LOGGER.info("==============>>>>>> Test Started ");

        } catch (FileNotFoundException e) {
            LOGGER.info("=====> No Properties file found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void storeLoginCookies(Set<Cookie> cookie) {
        this.loginCookies = cookie;
    }

    public void setLoginCookies() {

    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.INFO);
        loggingprefs.enable(LogType.PERFORMANCE, Level.INFO);
        Map<String, Object> prefs = new HashMap<String, Object>();
        String downloadFilepath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "downloadFiles";
        prefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
//        options.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        options.setCapability("unexpectedAlertBehaviour", "accept");
        if (prop.getProperty("browserState").contains("headless")) {
            options.addArguments("window-size=1400,800");
            options.addArguments("--headless");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        return options;
    }

    public void loadDriver() {

        loadProperties();   //Load the Property File

        LOGGER.info("==============>>>>>> Browser to Launch : " + prop.getProperty("browser"));
        switch (prop.getProperty("browser")) {
            case "chrome":
            default: {
//                if (prop.getProperty("isWebdriverManager").equalsIgnoreCase("X") && prop.getProperty("browserState") == null) {
                if (prop.getProperty("isWebdriverManager").equalsIgnoreCase("X")) {
                    WebDriverManager.chromedriver().clearDriverCache().setup();
//                    WebDriverManager.chromedriver().driverVersion("122");
//                    WebDriverManager.chromedriver().setup();
                    LOGGER.info("==============>>>>>> Launched from Chrome Driver Manager");
                    driver = new ChromeDriver(getChromeOptions());
                    driver.manage().window().maximize();
//                    if(prop.getProperty("setWindowSize").equals("X")){
////                        driver.manage().window().setSize(new Dimension(Integer.valueOf(prop.getProperty("setWindowWidth")),Integer.valueOf(prop.getProperty("setWindowHeight"))));
//                    }
                    driver.manage().deleteAllCookies();
                } else {
                    String path = System.getProperty("user.dir") + ProjectDefaults.LOCATION_CHROME_DRIVER;
                    System.setProperty(ProjectDefaults.WEBDRIVER_CHROME_DRIVER, path);
                    driver = new ChromeDriver(getChromeOptions());
                    driver.manage().window().maximize();
//                    if(prop.getProperty("setWindowSize").equals("X")){
//                        driver.manage().window().setSize(new Dimension(Integer.valueOf(prop.getProperty("setWindowWidth")),Integer.valueOf(prop.getProperty("setWindowHeight"))));
//                    }
                    driver.manage().deleteAllCookies();
//                this.proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//                this.proxy.newHar("file_"+ LocalDateTime.now());
                }
                break;
            }
            case "firefox": {
                if (prop.getProperty("isWebdriverManager").equalsIgnoreCase("X")) {
                    WebDriverManager.firefoxdriver().setup();
                    LOGGER.info("==============>>>>>> Launched from Firefox Driver Manager");
                } else {
                    String path = System.getProperty("user.dir") + ProjectDefaults.LOCATION_FIREFOX_DRIVER;
                    System.setProperty(ProjectDefaults.WEBDRIVER_FIREFOX_DRIVER, path);
                }
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
//                if(prop.getProperty("setWindowSize").equals("X")){
//                    driver.manage().window().setSize(new Dimension(Integer.valueOf(prop.getProperty("setWindowWidth")),Integer.valueOf(prop.getProperty("setWindowHeight"))));
//                }
                driver.manage().deleteAllCookies();

                break;
            }
            case "jenkins":
                System.setProperty("webdriver.chrome.driver", ProjectDefaults.JENKINS_CHROME_LOCATION);
                driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;

            case "remote":
                try {
                    driver = new RemoteWebDriver(new URL(ProjectDefaults.JENKINS_SELENIUM_GRID_URL), getChromeOptions());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;
        }
        if (driver != null) {
            loadJS(driver);           // Load JavaScript Executor - use where ever required in the container
        }
    }

    private JavascriptExecutor loadJS(WebDriver driver) {
        if (this.jsExecutor == null) {
            return this.jsExecutor = (JavascriptExecutor) driver;
        } else {
            return this.jsExecutor;
        }
    }

    /**
     * Get webdriver instance
     */
    public WebDriver getDriver() {
        if (driver == null) {
            loadDriver();
        }
        return driver;
    }

    //    public void navigateToLandingPage() {
//        try {
//            driver.get(prop.getProperty("baseurl"));
//            waitForPageToLoad();
//            LOGGER.info("==============>>>>>> Page Loaded : " + prop.getProperty("baseurl"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.info("Unable to Navigate to Page : " + prop.getProperty("baseurl"));
//        }
//
//    }
    public void navigateToLandingPage() {
        try {
            driver.get(prop.getProperty("baseurl"));
            driver.get(prop.getProperty("baseurl"));
            waitForPageToLoad();
            LOGGER.info("==============>>>>>> Page Loaded : " + prop.getProperty("baseurl"));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to Navigate to Page : " + prop.getProperty("baseurl"));
        }

    }
    public void navigateToCCVLandingPage() {
        try {
            driver.get(prop.getProperty("baseurl_newui"));
            waitForPageToLoad();
            LOGGER.info("==============>>>>>> Page Loaded : " + prop.getProperty("baseurl_newui"));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to Navigate to Page : " + prop.getProperty("baseurl_newui"));
        }

    }

    public void navigateToPage(String url) {
        try {
            driver.get(url);
            waitForPageToLoad();
            LOGGER.info("==============>>>>>> Page navigated to  : " + url);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to Navigate to Page : " + url);
        }

    }

    public void navigateToaNewTab(String url) {
        hardWait("1000");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        this.tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to(url);
    }

    public void switchToNextTab() {
        hardWait("1000");
        this.tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToDefaultTab() {
        driver.switchTo().window(tabs.get(0));
    }

    public void navigateToMainTab() {
        driver.close();
        LOGGER.info("...... Closing the existing tab");
        hardWait("1000");
        driver.switchTo().window(this.tabs.get(0));
    }

    public void navigateToRecentTab() {
        hardWait("1000");
        this.tabs = new ArrayList<String>(driver.getWindowHandles());
        int tabIndex=tabs.size()-1;
        driver.switchTo().window(this.tabs.get(tabIndex));
    }

    public void navigateToPreviousTab() {
        hardWait("1000");
        this.tabs = new ArrayList<String>(driver.getWindowHandles());
        int tabIndex=tabs.size()-2;
        driver.switchTo().window(this.tabs.get(tabIndex));
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
            waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to refresh the Page : ");
        }

    }

    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"});", element);
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Unable to scroll to the Element : " + element.getText());
        }

    }

    public void waitForPageToLoad() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT)).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            LOGGER.info("Failed to wait for Page to load ");
            e.printStackTrace();
        }
    }

    public void waitFor() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
            LOGGER.info("==============>>>>>> Wait for " + WAIT_TIME + " Seconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitToLoadElement() {
        try {
//            driver.manage().timeouts().implicitlyWait(WAIT_TIME, SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
            LOGGER.info("==============>>>>>> " + WAIT_TIME + " Seconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearCookies() {
        try {
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void captureScreeshot(String scrName) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/screenshots/" + scenarioName + "/scr_"
                    + scrName + "_" + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public boolean checkIfELementIsAvailable(WebElement element) {
        boolean elementExist = waitForElementVisible(element);
        return (elementExist) ? true : false;


    }

    public boolean checkIfElementIsNotNull(WebElement element) {
        return (element != null) ? true : false;
    }

    public boolean checkElementIsAvailableByXpath(String path) {
        boolean status = false;
        List<WebElement> elements = driver.findElements(By.xpath(path));
        if (elements.size() > 0) {
            status = true;
        }
        return status;
    }

    public void sendFieldInputData(WebElement el, String value) {
        if (checkIfELementIsAvailable(el)) {
            if (!el.getText().isEmpty()) {
                el.clear();
            }
            try {
                el.sendKeys(Keys.CONTROL + "a");
                el.sendKeys(Keys.DELETE);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (el != null) {
                LOGGER.info("==============>>>>>> Delete existing value on the Input Field .");
            }
            el.sendKeys(value);
            if (el != null) {
                LOGGER.info("==============>>>>>> Input Entered for the WebElement with Input : " + value);
            }
        } else {
            LOGGER.info("==============>>>>>> Failed to Key in the data");
        }
    }

    public void clickElement(WebElement element) {
        String elementName = null;
        try {
            if (isClickable(element)) {
                highlightElement(element);
                elementName = element.getText();
                element.click();
                if (elementName != null) {
                    LOGGER.info("==============>>>>>> Clicked WebElement : " + elementName);
                }
            } else {
                LOGGER.info("==============>>>>>> Unable to click the Element : " + element.getText());
            }
        } catch (NoSuchElementException e) {
            LOGGER.info("==============>>>>>> Unable to click the Element : " + element.getText());
        }
    }

    public boolean waitForElementVisible(WebElement element) {
        boolean status = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOf(element));
            LOGGER.info("==============>>>>>> Waiting for Element Visible ");
            status = true;
        } catch (NoSuchElementException ns) {
            ns.printStackTrace();
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Failed to wait to for the WebElement to be visible");
        }
        return status;
    }

    public void waitTillElementFound(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        try {
            WebElement el = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    for (int i = 1; i <= 3; i++) {
                        wait.until(ExpectedConditions.visibilityOf(element));
                        if (element.isDisplayed()) {
                            break;
                        } else {
                            hardWait("3000");
//                            driver.manage().timeouts().implicitlyWait(1, SECONDS);
                        }
                    }
                    return (element.isDisplayed()) ? element : null;
                }
            });
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException st) {
            st.printStackTrace();
        }

    }

    public boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME + 30));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            LOGGER.info("Element : " + element.getText() + "not found at the moment");
            return false;
        }
    }

    public void hardWait(String msecs) {
        try {
            Thread.sleep(Long.valueOf(msecs));
            LOGGER.info("==============>>>>>> Wait for " + msecs + " for the WebElement to be Visible");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Click the element with JavaScript executor.
     *
     * @param element
     */
    public void clickWithJsExecutor(WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            scrollToElement(element);
            highlightElement(element);
            isClickable(element);
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to click Element ");
        }
    }

    public void selectTextByVisibleText(WebElement element, String value) {
        try {
            if (checkIfELementIsAvailable(element)) {
                Select select = new Select(element);
                select.selectByVisibleText(value);
            } else {
                waitTillElementFound(element);
                Select select = new Select(element);
                select.selectByVisibleText(value);
            }
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Element not Visible to Select");
        }
    }

    public String getValueOfSelectListBox(WebElement element) {
        String value = null;
        try {
            if (checkIfELementIsAvailable(element)) {
                Select select = new Select(element);
                value = select.getFirstSelectedOption().getText();
            } else {
                waitTillElementFound(element);
                Select select = new Select(element);
                value = select.getFirstSelectedOption().getText();
            }
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Element not Visible to Select");
        }
        return value;
    }

    public void selectTextByIndex(WebElement element, int idx) {
        try {
            if (checkIfELementIsAvailable(element)) {
                Select select = new Select(element);
                select.selectByIndex(idx);
            } else {
                waitTillElementFound(element);
                Select select = new Select(element);
                select.selectByIndex(idx);
            }
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Element not Visible to Select");
        }
    }

    public void clearText(WebElement element) {
        try {
            if (checkIfELementIsAvailable(element) && !element.getText().isEmpty()) {
                element.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Element not Visible to Clear");
        }
    }

    public void selectTextByPartialText(WebElement element, String partialText) {
        try {
            if (checkIfELementIsAvailable(element)) {
                Select select = new Select(element);
                select.getOptions()
                        .stream()
                        .filter(option -> option.getText()
                                .toLowerCase().contains(partialText.toLowerCase())).findFirst().ifPresent(option -> select.selectByValue(option.getAttribute("value")));
            } else {
                waitTillElementFound(element);
                Select select = new Select(element);
                select.getOptions()
                        .stream()
                        .filter(option -> option.getText()
                                .toLowerCase().contains(partialText.toLowerCase())).findFirst().ifPresent(option -> select.selectByValue(option.getAttribute("value")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Element not Visible to Select");
        }
    }


    public void selectTextByValue(WebElement element, String value) {
        try {
            if (checkIfELementIsAvailable(element)) {
                Select select = new Select(element);
                select.selectByValue(value);
            } else {
                waitTillElementFound(element);
                Select select = new Select(element);
                select.selectByValue(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Element not Visible to Select");
        }
    }

    public void statusMessage(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> No Text selected to Highlight");
        }
    }


    public void highlightElement(WebElement element) {
        try {
            scrollToElement(element);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 1; i++) {
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 2px solid red;background-color: yellow;animation: blinker 5s linear infinite;");
                Thread.sleep(50);
                if (i == 0 && prop.getProperty("enableScreenshotWhenHighlighted").contains("true")) {
                    captureScreeshot(scenarioName);
                }
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> No Text selected to Highlight");
        }
    }


    public void changeStyle(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "style.border = '3px dotted blue'");
    }

    public void highlightElementWithScreenshot(WebElement element, String screenshotName) {
        try {
            scrollToElement(element);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 1; i++) {
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 2px solid red;background-color: yellow;animation: blinker 5s linear infinite;");
                Thread.sleep(50);
                if (i == 0 && prop.getProperty("enableScreenshotWhenHighlighted").contains("true")) {
                    captureScreeshot(screenshotName);
                }
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            }
//            shootWebElement(element);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> No Text selected to Highlight");
        }
    }

    public WebElement quickWait(String path) {
        WebElement element = null;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(org.openqa.selenium.NoSuchElementException.class).ignoring(org.openqa.selenium.TimeoutException.class);

        try {
            element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath(path));
                }

            });
        } catch (org.openqa.selenium.TimeoutException el) {
            LOGGER.info("==============>>>>>> Unable to find element : " + path);
        }

        return (element != null) ? element : null;
    }

    public List<WebElement> quickWaitForListOfElements(String path) {
        List<WebElement> element = null;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(org.openqa.selenium.NoSuchElementException.class).ignoring(org.openqa.selenium.TimeoutException.class);

        try {
            element = wait.until(new Function<WebDriver, List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(By.xpath(path));
                }

            });
        } catch (org.openqa.selenium.TimeoutException el) {
            LOGGER.info("==============>>>>>> Unable to find element : " + path);
        }

        return (element != null) ? element : null;
    }

    public WebElement getElementFromXpath(String path) {
        WebElement element = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i <= 3; i++) {

            try {
                element = (WebElement) js.executeScript("return document.evaluate('" + path + "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
                if (element != null) {
                    break;
                } else {
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                }
            } catch (TimeoutException el) {
                LOGGER.info("==============>>>>>> Unable to find element : " + path);
            } catch (NoSuchElementException el1) {
                el1.printStackTrace();
                LOGGER.info("======>>>>> Unable to find element - Attempt : " + i + "Path:" + path);
            }

        }
        return (element != null) ? element : null;
    }

    public boolean isElementAvailable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(org.openqa.selenium.NoSuchElementException.class).ignoring(org.openqa.selenium.TimeoutException.class);
        WebElement el = null;
        try {
            el = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("==============>>>>>> Unable to find element : " + element.getText());
        }

        return (el != null) ? true : false;
    }


    public WebElement waitForElementAndReturnJS(String path) {
        WebElement element = null;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        try {
            element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return getElementByXpathJS(path);
                }

            });
        } catch (org.openqa.selenium.TimeoutException el) {
            el.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to find element : " + path);
        }

        return (element != null) ? element : null;
    }

    public WebElement getElementByXpathJS(String xPath) {
        WebElement element = null;
        try {
            hardWait("1000");
            element = (WebElement) (((JavascriptExecutor) driver).executeScript("document.evaluate(" + xPath + ",document, null, XPathResult.ANY_TYPE, null )"));
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Unable to Load the element with Path :" + xPath);
        }
        return (element != null) ? element : null;
    }

    public void scrollToElementAndClick(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
            highlightElement(element);
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("==============>>>>>> Unable to Click the element : " + element.toString());
        }
    }

    public void checkElementPresence(WebElement element) {
        new WebDriverWaitWithMessage(driver, WAIT_TIME)
                .failWith("No Element found")
                .until(new ExpectedCondition<Boolean>() {
                           @Override
                           public Boolean apply(WebDriver webDriver) {
                               try {
                                   return element.isDisplayed();
                               } catch (NoSuchElementException ignored) {
                                   return false;
                               } catch (StaleElementReferenceException ignored) {
                                   return false;
                               }
                           }
                       }
                );

    }

    public WebElement findElementUtil(String locatorType, String locator) {
        WebElement el = null;
        try {
            switch (locatorType.toLowerCase()) {

                case "id":
                    el = driver.findElement(By.id(locator));
                    break;

                case "css":
                    el = driver.findElement(By.cssSelector(locator));
                    break;

                case "link":
                    el = driver.findElement(By.linkText(locator));
                    break;

                case "className":
                    el = driver.findElement(By.className(locator));
                    break;

                case "name":
                    el = driver.findElement(By.name(locator));
                    break;

                case "tagName":
                    el = driver.findElement(By.tagName(locator));
                    break;

                case "xpath":
                    el = driver.findElement(By.xpath(locator));
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return el;
    }

    public void handleSoftAssert(String message, boolean status) {
        softAssert.assertTrue(status, message);
    }

    public void shootWebElement(WebElement element) {

        File screen = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        Point p = element.getLocation();

        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        BufferedImage img = null;
        try {
            img = ImageIO.read(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,
                height);

        try {
            ImageIO.write(dest, "png", screen);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileUtils.copyFile(screen, new File(System.getProperty("user.dir") + "/target/screenshots/" + this.scenarioName + "/scr_"
                    + this.scenarioName + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getWebElementValue(WebElement element) {
        String value = null;
        try {
            if (element != null && element.isDisplayed()) {
                value = element.getAttribute("value");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public void selectDropdownValueFromFilterList(WebElement el, String value) {
        if (checkIfELementIsAvailable(el)) {
            if (!el.getText().isEmpty()) {
                el.clear();
            }
            try {
                el.sendKeys(Keys.CONTROL + "a");
                el.sendKeys(Keys.DELETE);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (el != null) {
                LOGGER.info("==============>>>>>> Delete existing value on the Input Field .");
            }
            el.sendKeys(value);
            hardWait("1000");
            el.sendKeys(Keys.ARROW_DOWN);
            el.sendKeys(Keys.ENTER);
            if (el != null) {
                LOGGER.info("==============>>>>>> Input Entered for the WebElement with Input : " + value);
            }
        } else {
            LOGGER.info("==============>>>>>> Failed to Key in the data");
        }
    }

    public boolean isAlertPresent() {
        boolean status = false;
        try {
            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void navigateToPopup() {
        try {

            String myWindowHandle = driver.getWindowHandle();
            driver.switchTo().window(myWindowHandle);

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    public WebElement getElementByReplaceXpathJS(String path, String value) {
        WebElement element = null;
        try {
            String xPath = path.replace("${value}", value);
            hardWait("1000");
            element = (WebElement) (((JavascriptExecutor) driver).executeScript("document.evaluate(" + xPath + ",document, null, XPathResult.ANY_TYPE, null )"));
        } catch (Exception e) {
            LOGGER.info("==============>>>>>> Unable to Load the element with Path :" + path);
        }
        return (element != null) ? element : null;
    }

    public String getAlphaNumericString(int i) {
        String serialnumber = RandomStringUtils.randomAlphanumeric(i);
        return serialnumber;
    }

    public String generateSerialNumber() {
        int int_random = ThreadLocalRandom.current().nextInt();
        String serialNum = Integer.toString(int_random);
        return serialNum;
    }

    public void goBack() {
        try {
            driver.navigate().back();
            waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to go to back Page : ");
        }

    }

    public void goForward() {
        try {
            driver.navigate().forward();
            waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to go to forward Page : ");
        }

    }

    public static String generateRandomAlphabetForBaxi() {
        StringBuilder randomAlphabet = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (new Random().nextInt(26) + 'A');
            randomAlphabet.append(randomChar);
        }
        return randomAlphabet.toString();
    }

    public static String generateRandomSNForBeko() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
        int year = currentYear - 2;
        String monthPart = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        StringBuilder randomDigits = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            randomDigits.append(random.nextInt(10));
        }
        return String.valueOf(year) + randomDigits + monthPart;

    }

    public static String generateRandomNum() {
        String randomNumber = new String();

        Random random = new Random();
        long randomNum = random.nextLong();
        randomNum = Math.abs(randomNum);
        randomNum = randomNum % 10000000000L;
        randomNumber = String.valueOf(randomNum);

        return randomNumber;
    }

    public void navigateToTOTPTokenGeneratorPage() {
        try {
            driver.get(prop.getProperty("totpurl"));
            driver.get(prop.getProperty("totpurl"));
            waitForPageToLoad();
            LOGGER.info("==============>>>>>>TOTP Page Loaded : " + prop.getProperty("totpurl"));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Unable to Navigate to TOTP Page : " + prop.getProperty("totpurl"));
        }
    }

}