package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends AbstractScreen{

    public LoginScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    @AndroidFindBy(id = "com.flipkart.android:id/mobileNo")
    private WebElement mobileNumberField;

    @AndroidFindBy(id = "com.flipkart.android:id/et_password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.flipkart.android:id/btn_mlogin")
    private WebElement signInButton;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private WebElement cancelButton;

    /**
     * Logs into the app using username and password provided
     * @param userName
     * @param password
     * @return - HomeScreen
     */
    public HomeScreen login(String userName, String password){
        enterUsername(userName);
        passwordField.sendKeys(password);
        signInButton.click();
        return new HomeScreen(driver);
    }

    /**
     * Enters username into the username field
     * @param userName
     */
    public void enterUsername(String userName){
        mobileNumberField.click();
        waitForElementClickable(cancelButton);
        cancelButton.click();
        waitForElementClickable(mobileNumberField);
        mobileNumberField.clear();
        mobileNumberField.sendKeys(userName);
    }

}
