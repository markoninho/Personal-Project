package beginner;
import com.baseClass.BasePageObject;
import com.goDaddy.www.HomePageGoDaddy;
import org.junit.Test;

public class LaunchBrowser extends BasePageObject {

    @Test
    public void launchBrowser() {
        HomePageGoDaddy hPage = new HomePageGoDaddy();
        hPage.setUpGoDaddyHomePage();
        hPage.closeBrowser();
    }
}


