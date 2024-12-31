package pages.HomePageComponents;

import com.microsoft.playwright.Request;
import com.microsoft.playwright.TimeoutError;
import driverFactory.BrowserManager;
import pages.BasePage;
import pages.SearchBarPage;

public class HomePage extends BasePage {

    private final String searchBar = "//div[@data-component='GreetingSection']//div/section[@data-component='SearchbarInput']";

    private final String carousalXpath = "//div[@class='main_carousel_slider']";

    private final String firstChevron = "//div[@class='main_carousel_slider']//div[contains(@class,'__arrow_fade_next___')]";





    private boolean searchTopicsRequestFromHomePageIsSent;


    private final String searchPage = "//div[text()='Basic Search']";
    public HomePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void navigateToHomePage(){
        browserManager.getPage().navigate("https://www.cityfalcon.ai/");

    }
    public SearchBarPage clickOnSearchBar(){
        Request request = null;
        try {
           request  = browserManager.getPage()
                    .waitForRequest("https://www.cityfalcon.com/webapi/v1/search/metadata/items?fuzzy_limit=20&limit=60&locations_only=false&popular_first=true&subsection=top_results", () -> {
                        browserManager.getPage().click(searchBar);
                    });
           searchTopicsRequestFromHomePageIsSent = true;
        }catch(TimeoutError  e) {
            //browserManager.getPage().locator(searchBar).click();
            searchTopicsRequestFromHomePageIsSent = false;

         //   System.out.println("I am the request from the click on the search bar : " + request.url());
        }
        return new SearchBarPage(browserManager);
    }
    public boolean theSearchPageIsVisible(){
       return browserManager.getPage().waitForSelector(searchPage).isVisible();
    }
    public HomePageGreetingsSections getTheGreetingSection(){
        return new HomePageGreetingsSections(browserManager);
    }
    public boolean theSearchBarTopicsRequestIsSent(){
        return searchTopicsRequestFromHomePageIsSent;
    }

    public HomePageMainCarousal scrollToTheCarouselSection(){
        scrollToElement(carousalXpath);
        return new HomePageMainCarousal(browserManager);
    }
    public TopStoriesGlobally scrollToTopStoriesSection(){

        return new TopStoriesGlobally(browserManager);


    }
    public GeneralFiltersAndSettings userScrollsToTheGeneralFiltersSection(){
        return new GeneralFiltersAndSettings(browserManager);
    }


}
