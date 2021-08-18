package advanced;
import com.amazon.www.HomePageAmazon;
import org.junit.Test;

public class navigateToGiftCardGetPriceAndPrintIt {

    @Test
    public void navigateToGiftCardGetPriceAndPrintIt() {
        HomePageAmazon hPage = new HomePageAmazon();
        hPage.setUpAmazon();

        hPage.clickOnAllList();
        hPage.clickOnGiftCard();
        hPage.clickOnAllGiftCards();
        hPage.clickOnSeeAll();
        hPage.clickOnJustBecause();
        hPage.clickOnGiftCardGreetingCard();
        hPage.closeBrowser();
    }
}
