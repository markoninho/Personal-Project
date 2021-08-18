package com.botsify.www;
import com.baseClass.BasePageObject;
import org.openqa.selenium.By;

public class HomePageBotsify extends BasePageObject {

    private static final By botLocator = By.id("wpic-launcher-child");
    private static final By nameLocator = By.id("wpic-username");
    private static final By emailLocator = By.id("wpic-email");
    private static final By startConversationButtonLocator = By.id("wpic-login");
    private static final By featuresLocator = By.xpath("//button[@data-qr-payload='Features']");
    private static final By p1Locator = By.xpath("//p[contains(text(),'Botsify has tons')]");
    private static final By p2Locator = By.xpath("//p[contains(text(),'One more important feature')]");
    private static final By p3Locator = By.xpath("//p[contains(text(),'Do you need help with anything else?')]");
    private static final By yesLocator = By.xpath("//button[contains(text(),'Yes')]");
    private static final By noLocator = By.xpath("//button[contains(text(),'No')]");
    private static final By textLocator = By.xpath("//div[contains(text(),'Thanks for interacting!')]");
    private static final By pickASlotLocator = By.xpath("//a[contains(text(),'Pick a slot')]");
    private static final By mainMenuLocator = By.id("main-menu");
    private static final By deleteConversationLocator = By.id("delete-conversation");
    private static final By welcomeToBotsify = By.xpath("//div[@id='wp-intercom-slack']/div[1]/div[@class='wpic-chatter']/div[@class='wpic-conversation']//p[.='Welcome to Botsify, feel free to ask me anything.']");

    // Initialize driver and go to https://botsify.com/
    public void setUpBotsify() {
        initDriver();
        driver.get(prop.getProperty("BOTSIFY_URL"));
    }

    // Start conversation with bot, locate element and click
    public void openBotConversation(){
        waitToBeClickableAndClick(botLocator);
    }

    // Switch to Iframe so u can access to modal elements
    public void switchToIFrame(){
        iFrameLocator = driver.findElement(By.id("botsify-chat-widget-frame"));
        driver.switchTo().frame(iFrameLocator);
    }

    public void enterNameAndEmailAndClickToStartConversation(){
        waitForVisibilityOf(nameLocator,timeOut);
        type(prop.getProperty("name"), nameLocator);
        waitForVisibilityOf(emailLocator,timeOut);
        type(prop.getProperty("email"), emailLocator);
        waitToBeClickableAndClick(startConversationButtonLocator);
    }

    public void clickOnFeatures(){
        waitToBeClickableAndClick(featuresLocator);
    }

    public void checkResponses(){
        isDisplayed(p1Locator);
        isDisplayed(p2Locator);
        isDisplayed(p3Locator);
        isDisplayed(yesLocator);
        isDisplayed(noLocator);
        waitToBeClickableAndClick(noLocator);
    }

    public void checkResponseText(){
        isDisplayed(textLocator);
        isDisplayed(pickASlotLocator);
    }

    public void clickOnMainMenuInChatBotAndDelete(){
        waitToBeClickableAndClick(mainMenuLocator);
        waitToBeClickableAndClick(deleteConversationLocator);
        waitToBeClickableAndClick(deleteConversationLocator);
    }

    public void checkIfWelcomeToBotsifyIsDisplayed(){
        isDisplayed(welcomeToBotsify);
    }

}
