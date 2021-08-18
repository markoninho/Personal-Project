package medium;
import com.amazon.www.HomePageAmazon;
import com.baseClass.BasePageObject;
import org.junit.Test;

public class ValidatingElementsOnRegistrationPage extends BasePageObject {

    @Test
    public void validatingAllElementsOfRegistrationPage() {

        HomePageAmazon homePage = new HomePageAmazon();
        homePage.setUpAmazon();
        homePage.clickOnSignIn();
        homePage.createAmazonAccount();
        homePage.createAccountElementPresence();
        homePage.closeBrowser();
    }

}
