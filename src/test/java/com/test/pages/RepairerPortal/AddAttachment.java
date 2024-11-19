package com.test.pages.RepairerPortal;

import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class AddAttachment {
    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;
    private CommonUtils commonUtils;
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());


    public AddAttachment(BasePage base, SeleniumHelper seleniumHelper, CommonUtils commonUtils) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
        this.commonUtils = commonUtils;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "AttachmentType")
    private WebElement attachmentType;

    @FindBy(xpath = "//textarea[@id=\"AdditionalInformation\"]")
    // @FindBy(id= "AdditionalInformation")
    private WebElement attachmentInfo;

    @FindBy(xpath = "//span[contains(.,\"Choose a file\")]")
    private WebElement chooseAFile;

    @FindBy(xpath = "//div[@id=\"AttachmentsTable_wrapper\"]//span[contains(.,\"Insert\")]")
    private WebElement insertButton;

    @FindBy(xpath = "//*[@id=\"JobUpdateAttachmentimage1\"]")
    private WebElement uploadFile;

    @FindBy(xpath = "//input[@id=\"attachment_insert_save_btnx\"]")
    private WebElement save;

    @FindBy(xpath = "//table[@id=\"tmpImgTable\"]//tbody/tr[1]")
    private WebElement uploadedFileonTable;


    public boolean isAttachmentUploaded() {
        boolean status = false;
        try {
            base.selectTextByIndex(attachmentType, 1);
            base.sendFieldInputData(attachmentInfo, "TESTDATASETUPREQUIRED");
            base.sendFieldInputData(uploadFile, "System.getProperty(\"user.dir\")+\"/src/test/resources/documentation/00_DGOrbit.png\"");
            base.waitForPageToLoad();
            base.waitTillElementFound(uploadedFileonTable);
            if (base.checkIfElementIsNotNull(uploadedFileonTable)) {
                status = true;
            }
            base.clickElement(save);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }


    public void uploadAttachment() {
        try {
            base.sendFieldInputData(attachmentType, "text");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.TAB).build().perform();
            base.sendFieldInputData(attachmentInfo, "TESTDATASETUPREQUIRED");

            //  base.sendFieldInputData(uploadFile, "System.getProperty(\"user.dir\")+\"/src/test/resources/documentation/00_DGOrbit.png\"");
            //   base.waitForPageToLoad();
            //  base.waitTillElementFound(uploadedFileonTable);
            base.clickElement(save);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}