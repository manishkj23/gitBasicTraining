package com.test.utils;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SelectiveScreenshot {


    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;
    private String scenario;

    public SelectiveScreenshot(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        this.commonUtils = commonUtils;
    }

    public void shootWebElement(WebElement element) throws IOException {

        File screen = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        Point p = element.getLocation();

        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        BufferedImage img = ImageIO.read(screen);

        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,
                height);

        ImageIO.write(dest, "png", screen);
//
//        File f = new File("S:\\ome\\where\\over\\the\\rainbow");
//
//        FileUtils.copyFile(screen, f);
        FileUtils.copyFile(screen, new File(System.getProperty("user.dir") + "/target/screenshots/" + base.scenarioName + "/scr_"
                + base.scenarioName + System.currentTimeMillis() + ".jpg"));

    }

}