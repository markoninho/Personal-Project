package medium;
import com.amazon.www.HomePageAmazon;
import com.baseClass.BasePageObject;
import org.junit.Test;

public class CheckingFirstResultSearch extends BasePageObject {


    @Test
    public void checkingIfTheFirstResultContainsWordThatWasSearchedFor() {

            HomePageAmazon homePage = new HomePageAmazon();
            homePage.setUpAmazon();
            homePage.inputTextIntoSearchBar();
            homePage.checkingIfFirstResultContainsSearchedWord("Oculus");
            homePage.closeBrowser();
    }
}
