package beginner;
import com.baseClass.BasePageObject;
import com.goDaddy.www.HomePageGoDaddy;
import org.junit.Test;

public class GettingTitleAndPageSource extends BasePageObject {

    @Test
    public void gettingTitleAndPageSource() {

        HomePageGoDaddy homePage = new HomePageGoDaddy();

        homePage.setUpGoDaddyHomePage();
        homePage.getTitle();
        homePage.getPageSource();
        homePage.closeBrowser();


    }
}
