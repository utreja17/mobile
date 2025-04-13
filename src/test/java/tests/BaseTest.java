package tests;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trustcreatewallet.driver.MobileDriverHolder;
import org.trustcreatewallet.driver.MobileDriverService;
import org.trustcreatewallet.utils.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static org.trustcreatewallet.driver.MobileDriverHolder.getDriver;
import static org.trustcreatewallet.driver.MobileDriverHolder.setDriver;
import static org.trustcreatewallet.utils.Constants.APPIUM_DRIVER_TIMEOUT;
import static org.trustcreatewallet.utils.Constants.MOBILE_PLATFORM_NAME;

@Listeners(TestListener.class)
public class BaseTest {
    private static final Logger logger = LogManager.getLogger();
    private final MobileDriverService driverService = new MobileDriverHolder().getDriverService();
    private AppiumDriverLocalService appiumService;

    @BeforeSuite
    public void oneTimeSetup() {
        logger.debug("Test execution platform: {}", MOBILE_PLATFORM_NAME);
    }

    @BeforeMethod
    public void openApp() {
        appiumService = driverService.startAppiumService();
        driverService.spinUpDriver(appiumService);
        setDriver(driverService.getDriver());
        getDriver().manage().timeouts().implicitlyWait(APPIUM_DRIVER_TIMEOUT);
        logger.debug("Test execution started on: {}", MOBILE_PLATFORM_NAME);
    }

    @AfterMethod
    public void closeApp() {
        driverService.closeDriver();
        driverService.stopAppiumService(appiumService);
        logger.debug("Test execution stopped on: {}", MOBILE_PLATFORM_NAME);
    }
}
