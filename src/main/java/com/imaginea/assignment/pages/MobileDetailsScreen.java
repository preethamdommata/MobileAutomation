package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileDetailsScreen extends AbstractScreen{

    public MobileDetailsScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    String highlightsXpath = "//*[@text='Highlights']/parent::*";
    String highlights = "//android.widget.LinearLayout/android.widget.TextView";
    String products_accessId = "//*[@content-desc=\"product container\"]";

    /**
     * Prints product details of a product
     */
    public void printProductDetails(){
        WebElement highlightsElement = scrollIntoView(highlightsXpath);
        waitForElementVisible(highlightsElement);
        List<WebElement> highlightAllTextElements = driver.findElements(By.xpath(highlights));
        for(WebElement element:highlightAllTextElements){
            System.out.println(element.getText());
        }
    }

    /**
     * Gets the mobile elements in the mobile detail screen (Incase of multiple mobiles presents)
     * @return
     */
    public List<WebElement> getMobileElements(){
        List<WebElement> mobileElements = driver.findElements(By.xpath(products_accessId));
        return mobileElements;
    }

    /**
     * Gets all the details of all the mobiles present in Mobile details screen
     * @param mobileElements
     */
    public void getDetailsOfAllMobiles(List<WebElement> mobileElements){
        for(WebElement element:mobileElements){
            element.click();
            printProductDetails();
            driver.pressKeyCode(AndroidKeyCode.BACK);
        }

    }

}
