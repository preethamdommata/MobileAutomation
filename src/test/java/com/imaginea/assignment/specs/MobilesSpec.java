package com.imaginea.assignment.specs;

import com.imaginea.assignment.pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class MobilesSpec {

    private AndroidDriver driver;
    private SignUpScreen signup;
    private LoginScreen login;
    private HomeScreen home;
    private ElectronicsScreen electronic;
    private MobilesScreen mobiles;
    private MobileDetailsScreen mobileDetailsScreen;


    @BeforeMethod
    public void setup() throws MalformedURLException, InterruptedException {
        driver = BaseSpec.start();
    }

    @Test
    public void getMobiles() throws InterruptedException {

        signup = new SignUpScreen(driver);
        home = signup.closeExistingUserScreen();
        electronic = home.enterElectronics();
        mobiles = electronic.enterMobileSection();
        mobiles.scrollToNewLaunchesSection();
        List<WebElement> mobileIcons =  mobiles.getAllMobileElements();
        for(WebElement mobileElement:mobileIcons){
            mobiles.navigateToProductDetailsPage(mobileElement);
            driver.pressKeyCode(AndroidKeyCode.BACK);
        }

    }

    @AfterMethod
    public void clean(){
        driver.quit();
    }
}
