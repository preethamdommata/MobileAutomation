package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ElectronicsScreen extends AbstractScreen{

    public ElectronicsScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.flipkart.android:id/title\").text(\"Mobiles\")")
    private WebElement mobilesButton;

    /**
     * Enters into Mobiles section by clicking on the Mobile button from Menu
     * @return - MobilesScreen
     * @throws InterruptedException
     */
    public MobilesScreen enterMobileSection() throws InterruptedException {
        waitForElementVisible(mobilesButton);
        waitForElementClickable(mobilesButton);
        mobilesButton.click();
        return new MobilesScreen(driver);
    }

}
