package advanced;

import com.calendly.www.HomePageCalendly;
import org.junit.Test;

public class signUpAndValidateEmail {

    @Test
    public void signUpAndValidateEmail() {

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
        homePageCalendly.continueWithOutCalendar();
        homePageCalendly.availableHours();
        homePageCalendly.availableDays();
        homePageCalendly.chooseTestConsultantAndContinue();
        homePageCalendly.finish();
        homePageCalendly.validateThatYouAreRedirectedToHomePage();
        homePageCalendly.closeBrowser();
    }
}
