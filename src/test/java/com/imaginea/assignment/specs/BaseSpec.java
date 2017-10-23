package com.imaginea.assignment.specs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSpec {

    private static AndroidDriver driver;
    private static String PLATFORM_NAME = System.getProperty("platformName");
    private static String DEVICE_NAME = System.getProperty("deviceName");
    private static String PLATFORM_VERSION = System.getProperty("platformVersion");
    private static String APP_PACKAGE = System.getProperty("appPackage");
    private static String APP_ACTIVITY = System.getProperty("appActivity");
    private static String BROWSER_NAME = System.getProperty("browserName");

    /**
     * Initializes the Android driver as per the capabilities passed
     * @return driver
     * @throws MalformedURLException
     * @throws InterruptedException
     */
    public static AndroidDriver start() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
    capabilities.setCapability("browserName", BROWSER_NAME);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    Thread.sleep(5000);
    return driver;

    }

}
