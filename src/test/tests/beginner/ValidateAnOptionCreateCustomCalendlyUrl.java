package beginner;
import com.baseClass.BasePageObject;
import com.calendly.www.HomePageCalendly;
import org.junit.Test;

public class ValidateAnOptionCreateCustomCalendlyUrl extends BasePageObject {

    @Test
    public void creatingAccount() {

        HomePageCalendly homePageCalendly = new HomePageCalendly();
        homePageCalendly.setUpCalendly();
        homePageCalendly.signUp();
        homePageCalendly.enterEmailAddress();
        homePageCalendly.enterFullName();
        homePageCalendly.enterPassword();
        homePageCalendly.Continue();
        homePageCalendly.openMailinator();
        homePageCalendly.verifyEmail();
        homePageCalendly.repeatPassword();
        homePageCalendly.validateCustomCalendlyOption();
        homePageCalendly.closeBrowser();
            }
}
