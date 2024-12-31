package pages.HomePageComponents;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import driverFactory.BrowserManager;
import pages.BasePage;
import pages.OnboardingPages.CreateWatchListPage;
import pages.SearchBarPage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class HomePageGreetingsSections extends BasePage {

   private  Locator greetingsSection;


    private final String greetingsSectionXpath= "//div[@data-component='GreetingSection']";
    private final String placeHolderForTheSearchBar = "Search for financial securities, topics, countries, sectors...";

    private final String trustedByLogosXpath ="//div[contains(@class,'__trusted_by_logos___')]//img";

    private final String trustedBySection = "//div[contains(@class,'__trusted_by_logos___')]";

    private final String sectorsLocationsLinksXpath = "//div[contains(@class,'__topics_sectors_locations___')]//a";//div[text()='Bitcoin']

    private Locator chosen;
    private String hrefValue;





    public HomePageGreetingsSections(BrowserManager browserManager) {
        super(browserManager);
        browserManager.getPage().waitForSelector("//div[contains(@class,'__topics_sectors_locations___')]" );
        this.greetingsSection = browserManager.getPage().locator(greetingsSectionXpath);
    }

    public CreateWatchListPage clickOnPersonaliseBtn(){
        Locator personaliseBtn = greetingsSection.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Personalise"));
        personaliseBtn.click();
        return new CreateWatchListPage(browserManager);

    }
    public SearchBarPage clickOnTheGreetingsSectionSearchBar(){
        Locator searchBar = greetingsSection.getByPlaceholder(placeHolderForTheSearchBar);
        searchBar.click();

        return new SearchBarPage(browserManager);
    }
    public boolean theTopicsSectionHasTheSectorsLocators(){
        browserManager.getPage().waitForSelector(sectorsLocationsLinksXpath);
        Locator sectorsLocations = browserManager.getPage().locator(sectorsLocationsLinksXpath);




        return allElementsAreVisible(sectorsLocations);
    }
    public HomePageGreetingsSections clickOnAnyOfTheSectors(){

        List<Locator> sectors = browserManager.getPage().locator(sectorsLocationsLinksXpath).all();
        chosen = sectors.get(1);

         hrefValue = chosen.getAttribute("href");

        chosen.click();

        System.out.println("The problematic URL : " + getBrowserManager().getPage().url());
        System.out.println("And I am the problematic href : " + hrefValue );
        System.out.println("The url contains the href : " + getBrowserManager().getPage().url().contains(hrefValue));
        return this;


    }
    public boolean thePageRedirectsToTheChosenPage(){

        return  browserManager.getPage().url().contains(hrefValue);
    }
    public void scrollToTrustedBy(){
        scrollToElement(trustedBySection);
    }
    public boolean logosOfTheTrustedBySectionAreVisible(){
        Locator trustedByLocator = browserManager.getPage().locator(trustedByLogosXpath);
        return allElementsAreVisible(trustedByLocator);
    }








}
