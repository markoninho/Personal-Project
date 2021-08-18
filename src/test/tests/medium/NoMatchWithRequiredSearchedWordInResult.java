package medium;

import com.amazon.www.HomePageAmazon;
import org.junit.Test;

public class NoMatchWithRequiredSearchedWordInResult {

    @Test
    public void NoMatchWithRequiredSearchedWordInResult () {

        HomePageAmazon homePage = new HomePageAmazon();
        homePage.setUpAmazon();
        homePage.inputTextIntoSearchBar();
        homePage.checkingIfFirstResultContainsSearchedWord("pain");
        homePage.closeBrowser();
    }
}
