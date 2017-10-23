package com.imaginea.assignment.specs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSpec {

    private static AndroidDriver driver;

    /**
     * Initializes the Android driver as per the capabilities passed
     * @return driver
     * @throws MalformedURLException
     * @throws InterruptedException
     */
    public static AndroidDriver start() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nexus51");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.flipkart.android");
        capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
    capabilities.setCapability("BROWSER_NAME", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    Thread.sleep(5000);
    return driver;

    }

}
