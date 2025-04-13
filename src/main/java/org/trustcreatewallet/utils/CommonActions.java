package org.trustcreatewallet.utils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import static org.trustcreatewallet.utils.Constants.APPIUM_DRIVER_TIMEOUT;

public class CommonActions {
    static WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, APPIUM_DRIVER_TIMEOUT), this);
    }

    protected void click(WebElement element, String elementName) {
        element.click();
        logger.info("Clicked on element:" + elementName);
    }

    public boolean checkElementVisibility(WebElement element, String elementName) {
        try {
            logger.info(elementName + " is visible");
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected String getText(WebElement webElement) {
        logger.info(webElement.getText() + "GET Text of this element");
        return webElement.getText();
    }

    public void getPasscodeDigit() {
        for (int i = 1; i < 7; i++) {
            String xpath = "//android.widget.TextView[@text='" + String.valueOf(i) + "']";
            driver.findElement(By.xpath(xpath)).click();
        }
    }

    public void getmismatchPasscodeDigit() {
        for (int i = 0; i < 6; i++) {
            String xpath = "//android.widget.TextView[@text='" + String.valueOf(i) + "']";
            driver.findElement(By.xpath(xpath)).click();
        }
    }

}

