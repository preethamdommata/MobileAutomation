package com.imaginea.assignment.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MobilesScreen extends AbstractScreen {

    public MobilesScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.flipkart.android:id/title_action_bar\").text(\"Mobiles Destination\")")
    private WebElement mobileHeading;

    public String allowLocationAccessPopUp = "//*[@resource-id='com.flipkart.android:id/permission_title']";
    public String notNowButton = "//*[@resource-id='com.flipkart.android:id/not_now_button']";
    public String xpathFirstCard = "//android.widget.LinearLayout/android.widget.ImageView[contains(@resource-id,'com.flipkart.android:id/firstCreativeCard')]";
    public String xpathSecondCard = "//android.widget.LinearLayout/android.widget.ImageView[contains(@resource-id,'com.flipkart.android:id/secondCreativeCard')]";
    public String xpathThirdCard = "//android.widget.LinearLayout/android.widget.ImageView[contains(@resource-id,'com.flipkart.android:id/thirdCreativeCard')]";
    String products_accessId = "//*[@content-desc=\"product container\"]";

    /**
     * Scrolls to New Launches Section
     * @throws InterruptedException
     */
    public void scrollToNewLaunchesSection() throws InterruptedException {
        waitForElementVisible(mobileHeading);
        scrollToNewLaunchesSection(xpathFirstCard);
    }

    /**
     * Returns the mobiles present under the New Launches section
     * @return - Elements under new Launches section
     */
    public List<WebElement> getAllMobileElements(){
        List<WebElement> mobileElements = new ArrayList<WebElement>();
        List<WebElement> primaryCards = driver.findElements(By.xpath(xpathFirstCard));
        List<WebElement> secondCards = driver.findElements(By.xpath(xpathSecondCard));
        List<WebElement> thirdCards = driver.findElements(By.xpath(xpathThirdCard));

        mobileElements.add(primaryCards.get(2));
        mobileElements.add(primaryCards.get(3));
        mobileElements.add(secondCards.get(2));
        mobileElements.add(secondCards.get(3));
        mobileElements.add(thirdCards.get(2));
        mobileElements.add(thirdCards.get(3));
        return mobileElements;

    }

    /**
     * Navigates to the Mobiles details page of all mobiles present under each mobile present under the New Mobile Launches section
     * @param element - Mobile Icon under New Launches section
     * @return
     * @throws InterruptedException
     */
    public MobileDetailsScreen navigateToProductDetailsPage(WebElement element) throws InterruptedException {
            waitForElementVisible(element);
            element.click();
            Thread.sleep(5000);
        if(driver.findElements(By.xpath(allowLocationAccessPopUp)).size()!=0){
            driver.findElement(By.xpath(notNowButton)).click();
        }
        Thread.sleep(3000);
        MobileDetailsScreen mobileScreen = new MobileDetailsScreen(driver);
            if(driver.findElements(By.xpath(products_accessId)).size() == 0){
                mobileScreen.printProductDetails();
            }
            else {
                Thread.sleep(5000);
                List<WebElement> mobiles = mobileScreen.getMobileElements();
                mobileScreen.getDetailsOfAllMobiles(mobiles);
            }
            return mobileScreen;
    }

    /**
     * Scrolls to New Launches section using scroll
     * @param item
     * @throws InterruptedException
     */
    public void scrollToNewLaunchesSection(String item) throws InterruptedException {
            Thread.sleep(3000);
            Dimension dim = driver.manage().window().getSize();
            Double ss = dim.getHeight()*0.8;
            int scroll = ss.intValue();
            Double sh = dim.getHeight()*0.2;
            int end = sh.intValue();
            for(int i=0;i<30;i++)
            {

                List<WebElement> elelist = driver.findElements(By.xpath(item));
                if(elelist.size()==5 | elelist.size()==4)
                {
                    break;

                }
                else
                {
                    ((AndroidDriver) driver).swipe(0, scroll, 0, end, 9000);

                }
            }


    }

}
