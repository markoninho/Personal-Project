package com.goDaddy.www;
import com.baseClass.BasePageObject;
import org.openqa.selenium.By;

public class HomePageGoDaddy extends BasePageObject {

    private static final By signInLocator = By.xpath("//details[@id='id-68aad88a-f732-425d-b4c3-d14407a0aa2a']");
    private static final By createAccountLocator = By.xpath("//a[@data-track-name='create_account_link']");
    public static final By facebookLocator = By.id("facebook_auth");
    public static final By googleLocator = By.id("google_auth");
    public static final By emailLocator = By.id("sign-up-email");

    public void setUpGoDaddyHomePage() {
        initDriver();
        driver.get(prop.getProperty("GO_DADDY_URL"));
    }

    public void clickSignIn(){
        waitToBeClickableAndClick(signInLocator);
    }

    public void clickCreateAccount(){
        waitToBeClickableAndClick(createAccountLocator);
    }

    public void validateAllElements(){
        isDisplayed(facebookLocator);
        isDisplayed(googleLocator);
        isDisplayed(emailLocator);
    }

    public void getPageSource() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }
}
