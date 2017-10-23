package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public abstract class AbstractScreen {

    public AndroidDriver driver;

    public AbstractScreen(AndroidDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public void loadPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Waits for the element until that is clickable
     * @param element - Element to wait for
     * @return
     */
    public WebElement waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement some = wait.until(ExpectedConditions.elementToBeClickable(element));
        return some;
    }

    /**
     * Waits for element until it is visible
     * @param element - Element to wait for
     * @return
     */
    public WebElement waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement some = wait.until(ExpectedConditions.visibilityOf(element));
        return some;
    }

    /**
     * Scrolls to a particular element into zview
     * @param xpathLocator - Locator of the element to scroll to.
     * @return
     */
    public WebElement scrollIntoView(String xpathLocator){
        while(driver.findElements(By.xpath(xpathLocator)).size()==0)
        {
            Dimension dimensions = driver.manage().window().getSize();
            Double screenHeightStart = dimensions.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimensions.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            driver.swipe(0,scrollStart,0,scrollEnd,2000);
        }
        List<WebElement> webElements = driver.findElements(By.xpath(xpathLocator));
        return webElements.get(0);
    }
}
