package com.test.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;


public class SeleniumHelper {

    private BasePage base;
    private WebDriver driver;
    public  ScreenRecorder screenRecorder;
    public MockData mockData;

    public static final Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public SeleniumHelper(BasePage base) {
        this.base = base;
        this.driver = base.getDriver();
        this.mockData = new MockData();
    }

    public void captureScreeshot(){

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/screenshots/"+base.scenarioName+"/scr_"
                    + base.scenarioName +System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void captureScreeshotInFolder(String folder,String fileName){

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/screenshots/"+folder+"/"+fileName+base.scenarioName+"_scr_"
                    + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getAbsoluteXPath(WebElement element)
    {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "function absoluteXPath(element) {"+
                        "var comp, comps = [];"+
                        "var parent = null;"+
                        "var xpath = '';"+
                        "var getPos = function(element) {"+
                        "var position = 1, curNode;"+
                        "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
                        "return null;"+
                        "}"+
                        "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
                        "if (curNode.nodeName == element.nodeName) {"+
                        "++position;"+
                        "}"+
                        "}"+
                        "return position;"+
                        "};"+

                        "if (element instanceof Document) {"+
                        "return '/';"+
                        "}"+

                        "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
                        "comp = comps[comps.length] = {};"+
                        "switch (element.nodeType) {"+
                        "case Node.TEXT_NODE:"+
                        "comp.name = 'text()';"+
                        "break;"+
                        "case Node.ATTRIBUTE_NODE:"+
                        "comp.name = '@' + element.nodeName;"+
                        "break;"+
                        "case Node.PROCESSING_INSTRUCTION_NODE:"+
                        "comp.name = 'processing-instruction()';"+
                        "break;"+
                        "case Node.COMMENT_NODE:"+
                        "comp.name = 'comment()';"+
                        "break;"+
                        "case Node.ELEMENT_NODE:"+
                        "comp.name = element.nodeName;"+
                        "break;"+
                        "}"+
                        "comp.position = getPos(element);"+
                        "}"+

                        "for (var i = comps.length - 1; i >= 0; i--) {"+
                        "comp = comps[i];"+
                        "xpath += '/' + comp.name.toLowerCase();"+
                        "if (comp.position !== null) {"+
                        "xpath += '[' + comp.position + ']';"+
                        "}"+
                        "}"+

                        "return xpath;"+

                        "} return absoluteXPath(arguments[0]);", element);
    }
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     * Method to Check if the Element Exist and then Click
     * Verifies the existence of Element and then it will click the element
     * @param element
     */
    public boolean checkIfELementIsAvailable(WebElement element) {
        boolean elementExist = base.waitForElementVisible(element);
        return (elementExist) ? true : false;

    }

    public void pressKeyDownAction(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    public void pressEnterAction(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }


    public void clickDeleteButtononAction(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DELETE).build().perform();
    }

    public void doubleClickElement(WebElement element){
        Actions action = new Actions(driver);
        base.waitTillElementFound(element);
        action.doubleClick(element).build().perform();
    }

    public void actionToDelete(WebElement element){
        Actions action = new Actions(driver);
        base.waitTillElementFound(element);
        action.sendKeys(Keys.DELETE).build().perform();
    }

    public void actionSelectAllAndDelete(WebElement element){
        Actions action = new Actions(driver);
        action.click(element);
        action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
        action.sendKeys(Keys.DELETE).build().perform();
    }

    public void actionSelectAll(WebElement element){
        Actions action = new Actions(driver);
        action.click(element);
        action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
    }

    public void actionToPasteData(WebElement element){
        Actions action = new Actions(driver);
        action.click(element);
        action.keyDown(Keys.CONTROL).sendKeys("V").perform();
    }

    public void actionToCopyDataFromTextAreaCTRL_C(WebElement element){
        Actions action = new Actions(driver);
        action.click(element);
        actionSelectAll(element);
        action.keyDown(Keys.CONTROL).sendKeys("C").perform();
    }
    public void clickElementIfExist(WebElement element){

        try {
            if (checkIfELementIsAvailable(element)) {
                if (element.isEnabled()) {
                    element.click();
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Failed to Click the Element : " + element);
        }

    }
    public void back() {
        driver.navigate().back();

    }

    public void forward() {
        driver.navigate().forward();

    }

    public void refresh() {
        driver.navigate().refresh();

    }


    public void windowMaximize() {
        driver.manage().window().maximize();
    }
    public void switchToParentWithClose() {
        List<String> win = new ArrayList<String>(driver.getWindowHandles());

        for(int i = 1; i < win.size(); i++){
            driver.switchTo().window(win.get(i));
            driver.close();
        }
        driver.switchTo().window(win.get(0));

    }
    public void switchTo(int index) {
        try {
            List<String> win = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(win.get(index));
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Invalid Window Index : " + index);
        }

    }

    public boolean checkIfPopupWindowDisplayed(){
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        boolean status = false;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);

        try {
            if (!subWindowHandler.isEmpty()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        driver.switchTo().window(parentWindowHandler);
        return status;
    }

    public void closePopupWindow(WebElement element){
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);

        try {
            if (element.isEnabled()) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        driver.switchTo().window(parentWindowHandler);
    }

    public void closePopup(){
        actionClickEnter();
    }
    public void actionClickEnter(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        LOGGER.info("==============>>>>>> Action : Clicked Enter");
    }

    public void actionToMoveDownOnList(WebElement element) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        LOGGER.info("==============>>>>>> Action : Move To Down on List Box");
    }

    public void actionToMoveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        base.highlightElement(element);
        LOGGER.info("==============>>>>>> Action : Move To Element");

    }
    public String removeWhiteSpaces(String value){
        return value.replaceAll("\\s+","");
    }
    public void actionToMoveDownOnList(WebElement element, int number) throws InterruptedException {
        Actions action = new Actions(driver);
        for (int i = 0; i <= number; i++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        Thread.sleep(3000);
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        LOGGER.info("==============>>>>>> Action : Move To Down on List Box");
    }
    public int getNumericValueFromString(String value){
        return Integer.parseInt(value);
    }

    public String extractSubstringFromSpecialChars(String str, String from, String to){
        return StringUtils.substringBetween(str, from, to);
    }

    public String getCurrentDate(){
        SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
        return formDate.format(new Date());

    }
    public String getCurrentDate(String format){
        SimpleDateFormat formDate = new SimpleDateFormat(format);
        return formDate.format(new Date());

    }
    public Map<String, String> getCurrentTime(){
        Map<String,String> timeHHmm = new HashMap<>();
        LocalTime time = LocalTime.now();
        String tH = time.format(DateTimeFormatter.ofPattern("HH"));
        String tM = time.format(DateTimeFormatter.ofPattern("mm"));
        timeHHmm.put(tH,tM);
        return timeHHmm;
    }
    public String getCurrentTime(String value){
        String timeHHmm = null;
        LocalTime time = LocalTime.now();
        if(value.contains("HH")) {
            timeHHmm = time.format(DateTimeFormatter.ofPattern("HH"));
        } else if(value.contains("mm"))
            timeHHmm = time.format(DateTimeFormatter.ofPattern("mm"));
        return timeHHmm;
    }

    public String getCurrentTimeRoundOff(String value){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int round = calendar.get(Calendar.MINUTE) % 15;
        calendar.add(Calendar.MINUTE, round < 8 ? -round : (15-round));
        calendar.set( Calendar.SECOND, 0 );
        // return String.valueOf(calendar.getTime().getMinutes());
        return String.valueOf(calendar.get(calendar.MINUTE));
    }

    public WebElement getCustomElementByXpath(String path, String value){
        WebElement element = null;
        try{
            String xPath = path.replace("${value}",value);
            element = base.quickWait(xPath);
//            element = base.getElementFromXpath(xPath);
        } catch (Exception e){
            e.printStackTrace();
        }

        return (element != null) ? element : null;
    }

    public List<WebElement> getCustomListOfElementsByXpath(String path, String value){
        List<WebElement> element = null;
        try{
            String xPath = path.replace("${value}",value);
            element = base.quickWaitForListOfElements(xPath);
//            element = base.getElementFromXpath(xPath);
        } catch (Exception e){
            e.printStackTrace();
        }

        return (element != null) ? element : null;
    }

    public String getValueOnTheElement(WebElement element){

        if(element != null)
            return element.getAttribute("value");
        else return null;

    }
    public String searchStringRegex(String regx, String str){
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            LOGGER.info("==============>>>>>> Regex Match Found :"+matcher.group(1));
            return matcher.group(1);
        }
        return null;
    }

    public String printTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).toString();
    }


    public void generateBDDReport(){
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");
        String buildNo = "1";
        Configuration configuration = new Configuration(reportOutputDirectory, "ORBIT UI Automation Pack");
        configuration.setBuildNumber(buildNo);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }

    public void generateBDDReport(String projName){
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");
        String buildNo = "1";
        Configuration configuration = new Configuration(reportOutputDirectory, projName);
        configuration.setBuildNumber(buildNo);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }


    public void startRecording(String methodName) throws Exception
    {
        File file = new File("./target/test-recordings/");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();
        screenRecorder = new ScreenRecorderUtil(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);
        screenRecorder.start();
    }
    public void stopRecording() throws Exception
    {
        this.screenRecorder.stop();
    }

    public String getOnlyNumericCharsFromString(String value){
        return value.replaceAll("\\D+","");
    }

    public String currentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).toString();
    }

    private String getAFutureDate(int daysInFuture){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();
        return dtf.format(today.plusDays(daysInFuture)).toString();
    }

    public void uploadFile(WebElement uploadFileBtn, String file) {
        try {
            base.sendFieldInputData(uploadFileBtn, file);
            base.waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}