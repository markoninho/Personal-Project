package com.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.baseClass.ReadFileData.getConfigProperties;

public class BasePageObject {
    public WebDriver driver;
    public JavascriptExecutor js;
    public int timeOut = 120;
    public WebElement iFrameLocator;
    public Properties prop;

     public void initDriver() {
        //BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        js = (JavascriptExecutor) driver;
        prop = getConfigProperties();
    }

    public void closeBrowser(){
        pause(5000);
        driver.quit();
    }

    public void goBack(){
        js.executeScript("window.history.go(-1)");
    }

    // Open page with given URL
    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected void waitToBeClickableAndClick(By locator){
        waitFor(ExpectedConditions.elementToBeClickable(locator),timeOut);
        click(locator);
    }

    protected void type(String text, By locator){
        waitForVisibilityOf(locator,5);
        find(locator).sendKeys(text);
    }

    // Get URL of current page from browser
    public String getCurrentUrl() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Wait for specific ExpectedCondition for the given amount of time in seconds
    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    // Wait for given number of seconds for element with given locator to be visibile on the page
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds).length > 0 ? timeOutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException e){
                e.printStackTrace();
            }
            attempts++;
        }
    }
    // Check if element is Displayed and print inner text
    public void isDisplayed(By locator){
        waitForVisibilityOf(locator,timeOut);
        String pText = find(locator).getText();
        boolean element = find(locator).isDisplayed();
        if(element){
            System.out.println("Response: Succesfull " + pText);
        }
    }

    // Switching to next Tab in browser
    public void switchToNextTab(){
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
    }

    // Get page Title and print it
    public void getTitle() {
        String getTitle = driver.getTitle();
        System.out.println(getTitle);
    }
}
