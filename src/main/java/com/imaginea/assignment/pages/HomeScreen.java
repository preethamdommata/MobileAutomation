package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends AbstractScreen{

    public HomeScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    @AndroidFindBy(id = "com.flipkart.android:id/offersTile")
    public WebElement electronicsButton;

    /**
     * Enters into Electronics screen by clicking on the Electronics button on Home Screen
     * @return - Electronics Screen
     * @throws InterruptedException
     */
    public ElectronicsScreen enterElectronics() throws InterruptedException {
        waitForElementVisible(electronicsButton);
        waitForElementClickable(electronicsButton);
        electronicsButton.click();
        return new ElectronicsScreen(driver);
    };

}
