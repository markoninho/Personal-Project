package com.calendly.www;
import com.baseClass.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.Random;

public class HomePageCalendly extends BasePageObject {

//    private final By signUpLocator = By.xpath("//a[contains(text(),'Sign up')]")
    private final By signUpLocator = By.xpath("//a[@data-testid='regular-button']");
    private final By emailLocator = By.name("email");
    private final By signUpButtonLocator = By.xpath("//button[contains(text(),'Sign up')]");
    private final By fullNameLocator = By.name("name");
    private final By passwordLocator = By.name("password");
    private final By continueLocator = By.xpath("//input[@value='Continue']");
    private final By searchMailinatorInboxLocator = By.id("addOverlay");
    private final By searchMailinatorInboxButtonLocator = By.id("go-to-public");
    private final By openEmailLocator = By.xpath("//tr[@ng-repeat='email in emails']");
    private final By confirmMyEmailLocator = By.xpath("//a[@target='_other']");
    private final By repeatPasswordLocator = By.xpath("//input[@name='password']");
    private final By calendlyUrlLocator = By.name("slug");
    private final By getContinueLocator = By.xpath("//span[normalize-space()='Continue']");
    private final By continueWithOutCalendarLocator = By.xpath("//div[@class='clickable']");
    private final By mondaysLocator = By.cssSelector("label:nth-child(1)");
    private final By tuesdaysLocator = By.cssSelector("label:nth-child(2)");
    private final By thursdaysLocator = By.cssSelector("label:nth-child(4)");
    private final By fridaysLocator = By.cssSelector("label:nth-child(5)");
    private final By saturdaysLocator = By.cssSelector("label:nth-child(6)");
    private final By sundaysLocator = By.cssSelector("label:nth-child(7)");
    private final By freelanceConsultantLocator = By.xpath("//input[@value='freelance_consulting']");
    private final By finishLocator = By.xpath("//span[@class='']");
    String email = getSaltString() + "@mailinator.com";
    private final By dropDownFromLocator = By.xpath("//div[@id='time_from_chzn']//a[@class='chzn-single']");
    private final By dropDownValueFromLocator = By.xpath("//li[@id='time_from_chzn_o_10']");
    private final By dropDownToLocator = By.xpath("//div[@id='time_to_chzn']//a[@class='chzn-single']");
    private final By dropDownValueToLocator = By.xpath("//li[@id='time_to_chzn_o_15']");

    public HomePageCalendly() {
    }

    // Open browser and initialize driver
    public void setUpCalendly() {
        initDriver();
        driver.get(prop.getProperty("CALENDLY_URL"));
    }

    public void validateThatYouAreRedirectedToHomePage(){
        pause(3000);
        String URL = getCurrentUrl();
        if(URL.equalsIgnoreCase("https://calendly.com/"))
            System.out.println("Redirected to home page");
        else{
            System.out.println("Not redirected to home page");
        }
    }

    public void signUp() {
        waitToBeClickableAndClick(signUpLocator);
    }

    // Random string as a prefix for email
    protected String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public void enterEmailAddress() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(emailLocator), timeOut);
        type(email, emailLocator);
        waitToBeClickableAndClick(signUpButtonLocator);
    }

    public void enterFullName() {
        String fullName = "Petar Petrovic";
        waitFor(ExpectedConditions.visibilityOfElementLocated(fullNameLocator), timeOut);
        type(fullName, fullNameLocator);
    }

    public void enterPassword() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(passwordLocator), timeOut);
        type(prop.getProperty("password"), passwordLocator);
    }

    public void Continue() {
        waitToBeClickableAndClick(continueLocator);
        pause(2000);
    }

    public void openMailinator() {
        openUrl(prop.getProperty("MAILINATOR_URL"));
        waitFor(ExpectedConditions.visibilityOfElementLocated(searchMailinatorInboxLocator), timeOut);
        type(email, searchMailinatorInboxLocator);
        waitToBeClickableAndClick(searchMailinatorInboxButtonLocator);
        waitToBeClickableAndClick(openEmailLocator);
    }

    public void verifyEmail() {
        driver.switchTo().frame("html_msg_body");
        waitToBeClickableAndClick(confirmMyEmailLocator);
        driver.switchTo().defaultContent();
    }

    public void repeatPassword() {
        switchToNextTab();
        // Repeat password
        waitFor(ExpectedConditions.visibilityOfElementLocated(repeatPasswordLocator), timeOut);
        type(prop.getProperty("password"), repeatPasswordLocator);
        waitToBeClickableAndClick(continueLocator);

    }

    public void validateCustomCalendlyOption() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(calendlyUrlLocator), timeOut);
        isDisplayed(calendlyUrlLocator);
    }

    public void continueWithOutCalendar() {
        waitToBeClickableAndClick(getContinueLocator);
        waitToBeClickableAndClick(continueWithOutCalendarLocator);
    }

    // Select Sunday/Wednesday/Sunday for available dates
    public void availableDays() {
        waitToBeClickableAndClick(sundaysLocator);
        waitToBeClickableAndClick(mondaysLocator);
        waitToBeClickableAndClick(tuesdaysLocator);
        waitToBeClickableAndClick(thursdaysLocator);
        waitToBeClickableAndClick(fridaysLocator);
        waitToBeClickableAndClick(saturdaysLocator);
        waitToBeClickableAndClick(getContinueLocator);

    }

    // Set available hours from 10:00 till 15:00
    public void availableHours(){
        waitToBeClickableAndClick(dropDownFromLocator);
        waitToBeClickableAndClick(dropDownValueFromLocator);
        waitToBeClickableAndClick(dropDownToLocator);
        waitToBeClickableAndClick(dropDownValueToLocator);
    }

    public void chooseTestConsultantAndContinue() {
        waitToBeClickableAndClick(freelanceConsultantLocator);
    }

    public void finish() {

        waitFor(ExpectedConditions.elementToBeClickable(finishLocator),timeOut);
        click(finishLocator);
    }
}
