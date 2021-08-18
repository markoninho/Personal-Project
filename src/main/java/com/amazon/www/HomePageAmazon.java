package com.amazon.www;
import com.baseClass.BasePageObject;
import org.openqa.selenium.By;

public class HomePageAmazon extends BasePageObject {

    private final By allListLocator = By.id("nav-hamburger-menu");
    private final By signInLocator = By.xpath("//a[@id='nav-link-accountList']");
    private final By createAccountLocator = By.id("createAccountSubmit");
    private final By searchBarLocator = By.id("twotabsearchtextbox");
    private final By searchBarButtonLocator = By.id("nav-search-submit-text");
    private final By firstSearchResultLocator = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[2]//div[1]//span[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//div[1]//h2[1]//a[1]//span[1]");
    private final By giftCardsLocator = By.xpath("//a[@data-menu-id='27']");
    private final By allGiftCardsLocator = By.xpath("//*[@id=\"hmenu-content\"]/ul[27]/li[3]/a");
    private final By seeAllLocator = By.xpath("//a[@aria-label='Find Gift Cards for All Occasions']");
    private final By justBecauseLocator = By.xpath("//a[@aria-label='Just Because']");
    private final By giftCardGreetingCardLocator = By.xpath("//*[@id=\"acs-product-block-17\"]/div[1]/a/img");
    private final By nextButtonLocator = By.xpath("//*[@id=\"a-autoid-4\"]/span");
    private final By priceLocator = By.xpath("//*[@id=\"priceblock_ourprice\"]");
    private final By isDisplayedName = By.id("ap_customer_name");
    private final By isDisplayedEmail = By.id("ap_email");
    private final By isDisplayedPassword = By.id("ap_password");
    private final By isDisplayedRePassword = By.id("ap_password_check");
    private final By isDisplayedCreateAccount = By.id("a-autoid-0");

    public HomePageAmazon(){
    }

    public void setUpAmazon() {
        initDriver();
        driver.get(prop.getProperty("AMAZON_URL"));

    }

    public void clickOnGiftCardGreetingCard(){
        click(nextButtonLocator);
        click(nextButtonLocator);
        waitToBeClickableAndClick(giftCardGreetingCardLocator);
        String price = find(priceLocator).getText();
        System.out.println("Greeting Card price is: " + price);

    }
    public void clickOnSeeAll(){
        waitToBeClickableAndClick(seeAllLocator);
    }

    public void clickOnJustBecause(){
        waitToBeClickableAndClick(justBecauseLocator);
    }

    public void clickOnAllGiftCards(){
        waitToBeClickableAndClick(allGiftCardsLocator);
    }

    public void clickOnGiftCard(){
        waitToBeClickableAndClick(giftCardsLocator);
    }

    // Checking if the first result contains word that you searched for
    public void checkingIfFirstResultContainsSearchedWord(String searchedWord){
        String result = find(firstSearchResultLocator).getText();
        if(result.contains(searchedWord)){
            System.out.println("It contains searched word");
        }else{
            System.out.println("Doesn't contain searched word");
        }
    }

    // Type in search bar required word
    public void inputTextIntoSearchBar(){
        String search = "Oculus";
        type(search,searchBarLocator);
        click(searchBarButtonLocator);

    }

    // Getting Page Title
    public String getPageTitle(){
        // Getting Page title and printing
        String getTitle = driver.getTitle();
        System.out.println(getTitle);
        return getTitle;
    }

    // Locate Create Account button and click on it
    public void createAmazonAccount(){
        waitToBeClickableAndClick(createAccountLocator);
    }

    public  void clickOnAllList(){
        waitToBeClickableAndClick(allListLocator);
    }

    public void clickOnSignIn(){
        waitToBeClickableAndClick(signInLocator);
    }

    // Checking presence of All elements on Create Account page
    public void createAccountElementPresence() {
        isDisplayed(isDisplayedName);
        isDisplayed(isDisplayedEmail);
        isDisplayed(isDisplayedPassword);
        isDisplayed(isDisplayedRePassword);
        isDisplayed(isDisplayedCreateAccount);
    }
}
