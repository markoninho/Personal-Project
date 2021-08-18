package advanced;
import com.botsify.www.HomePageBotsify;
import org.junit.Test;

public class botConversationAndResponseCheck {

    @Test
    public void botConversationAndResponseCheck() {

        HomePageBotsify hPage = new HomePageBotsify();

        hPage.setUpBotsify();
        hPage.openBotConversation();
        hPage.switchToIFrame();
        hPage.enterNameAndEmailAndClickToStartConversation();
        hPage.clickOnFeatures();
        hPage.checkResponses();
        hPage.checkResponseText();
        hPage.clickOnMainMenuInChatBotAndDelete();
        hPage.checkIfWelcomeToBotsifyIsDisplayed();
        hPage.closeBrowser();
    }
}
