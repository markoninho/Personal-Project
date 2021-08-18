package medium;
import com.amazon.www.HomePageAmazon;
import com.baseClass.BasePageObject;
import org.junit.Assert;
import org.junit.Test;

public class VerifyingPageTitle extends BasePageObject {

    @Test
    public void gettingPageTitleAndVerifyingIt() {

        HomePageAmazon homePage = new HomePageAmazon();

        homePage.setUpAmazon();
        String title1 = homePage.getPageTitle();
        homePage.clickOnSignIn();
        homePage.goBack();
        String title2 = homePage.getPageTitle();
        Assert.assertEquals(title1,title2);
        homePage.closeBrowser();
    }

}
