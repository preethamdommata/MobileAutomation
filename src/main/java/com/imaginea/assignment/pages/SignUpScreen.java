package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends AbstractScreen {

    public SignUpScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    @AndroidFindBy(id = "com.flipkart.android:id/btn_mlogin")
    private WebElement existingUserButton;

    @AndroidFindBy(id = "com.flipkart.android:id/btn_skip")
    private WebElement skipButton;

    /**
     * Clicks on Exisiting user button on SignUp screen
     * @return - Login screen
     * @throws InterruptedException
     */
    public LoginScreen clickOnExisitingUserButton() throws InterruptedException {
        waitForElementVisible(existingUserButton);
        existingUserButton.click();
        return new LoginScreen(driver);
    }

    /**
     * Closes the exisiting user screen
     * @return - HomeScreen
     */
    public HomeScreen closeExistingUserScreen(){
        waitForElementVisible(existingUserButton);
        waitForElementClickable(skipButton);
        skipButton.click();
        return new HomeScreen(driver);
    }

}
