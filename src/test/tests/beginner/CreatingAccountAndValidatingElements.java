package beginner;
import com.baseClass.BasePageObject;
import com.goDaddy.www.HomePageGoDaddy;
import org.junit.Test;

public class CreatingAccountAndValidatingElements extends BasePageObject{

    @Test
    public void creatingAccount() {

        HomePageGoDaddy hPage = new HomePageGoDaddy();
        hPage.setUpGoDaddyHomePage();

        hPage.clickSignIn();
        hPage.clickCreateAccount();
        hPage.validateAllElements();
        hPage.closeBrowser();
    }
}
