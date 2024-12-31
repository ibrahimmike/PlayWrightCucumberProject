package stepDefinitions;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import driverFactory.BrowserManager;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePageComponents.*;
import pages.OnboardingPages.CreateWatchListPage;
import pages.SearchBarPage;
import pages.newsAndSearchPages.NewsAndSearchPage;

public class HomePage_Steps {


    private final HomePage hp;

    private SearchBarPage sbp;
    private HomePageGreetingsSections homePageGreetingsSections;
    private HomePageMainCarousal mainCarousal;
    private TopStoriesGlobally topStoriesGlobally;
    private  NewsAndSearchPage newsAndSearchPage;

    private GeneralFiltersAndSettings generalFiltersAndSettings;
    private  GeneralFiltersAndSettings.LocationDropDownPage  locationDropDownPage;


    public HomePage_Steps( HomePage hp) {

        this.hp = hp;
      // homePageGreetingsSections = hp.getTheGreetingSection();
    }


    @Given("Guest user is on the home page")
    public void guest_user_is_on_home_page(){
        hp.navigateToHomePage();

       // hp.theSearchPageIsVisible();
    //    System.out.println("I am the request method output : " + sbp.requestSent());
    }
    @When("User clicks on the greetings section search bar")
    public void user_clicks_on_the_search_bar_the_request_is_sent(){
        sbp = hp.clickOnSearchBar();
      Assert.assertTrue(sbp.searchElementsAreVisible());
    }
    @Then("User can see all the sectors locations")
    public void user_can_see_all_the_sectors_locations(){
      boolean check = hp.getTheGreetingSection().theTopicsSectionHasTheSectorsLocators();
        System.out.println("The check value on the step "+check);
        Assert.assertTrue(check, "elements are not visible");
    }
    @When("The user clicks on any of the sectors")
    public void user_clicks_on_any_of_the_sectors(){
        homePageGreetingsSections =  hp.getTheGreetingSection().clickOnAnyOfTheSectors();
    }
    @Then("The user is redirected to the relevant topic page")
    public void the_user_is_redirected_to_the_relevant_page(){
     Assert.assertTrue(homePageGreetingsSections.thePageRedirectsToTheChosenPage());
        System.out.println("The user is redirected to the relevant page");
    }
    @When("User clicks on the learn more button")
    public void the_user_clicks_on_the_learn_more_button(){
        System.out.println("The user clicked on the learn more button");
    }
    @When("The user is redirected to the learn more page")
    public void the_user_is_redirected_to_the_learn_more_page(){
        System.out.println("The user is redirected to the learn more page");
    }
    @And("The request for the topics is sent and the search page is loaded")
    public void the_request_for_the_topics_ise_sent_and_the_search_page_is_loaded(){
       Assert.assertTrue(hp.theSearchBarTopicsRequestIsSent());

    }
    @When("User scrolls to the trusted by section")
    public void the_user_scrolls_to_trusted_by_section(){
        hp.getTheGreetingSection().scrollToTrustedBy();

    }
    @Then("The trusted by logos are visible")
    public void the_trusted_by_logos_are_visible(){
      Assert.assertTrue(hp.getTheGreetingSection().logosOfTheTrustedBySectionAreVisible());
    }
    @When("User scrolls to the main carousel")
    public void user_scrolls_to_the_main_carousel(){
      mainCarousal =   hp.scrollToTheCarouselSection();
    }
    @And("User clicks on the next chevron")
    public void user_clicks_on_the_right_chevron(){
        mainCarousal.clickOnTheNextChevron();
    }
    @Then("The sentiment slide is visible")
    public void the_sentiment_slide_is_visible(){
       Assert.assertTrue(mainCarousal.theSentimentSlideShouldShow());
    }
    @When ("User clicks on the previous chevron")
    public void user_clicks_on_the_previous_chevron(){
        mainCarousal.clickOnThePreviousChevron();
    }
    @Then("The premium slide is visible")
    public void the_premium_slide_is_visible(){
       Assert.assertTrue(mainCarousal.thePremiumSlideTitleIsVisible());
    }
    @When ("User scrolls to the top stories page")
    public void user_scrolls_to_the_top_stories_page(){
        topStoriesGlobally = hp.scrollToTopStoriesSection();
    }
    @And("User clicks on the see more button")
    public void user_clicks_on_the_see_more_button(){
     newsAndSearchPage = topStoriesGlobally.clickOnSeeMore();
    }
    @Then ("User is redirected to the News and Research page")
    public void user_is_redirected_to_the_news_research_page(){
    Assert.assertTrue(newsAndSearchPage.newsAndSearchPageIsLoaded());
    }

    @When("User scrolls to the general filters section")
    public void user_scrolls_to_the_general_filters_section(){
        generalFiltersAndSettings = hp.userScrollsToTheGeneralFiltersSection();
    }
    @And ("User clicks on the general filters locations drop down")
    public void user_clicks_on_the_general_filters_locations_drop_down(){
       locationDropDownPage=  generalFiltersAndSettings.clickOnTheLocationsDropDownList();
    }

    @Then ("The dropdown with the continents is displayed")
    public void the_dropdown_with_the_continents_is_displayed(){
       Assert.assertTrue(locationDropDownPage.listOfContinentsIsDisplayed());
    }
    @And ("User chooses a continent")
    public void user_chooses_a_continent(){
        locationDropDownPage.userChoosesContinentAsia();
    }
    @Then("The page sends the request to the stories endpoint with continent")
    public void the_page_sends_the_request_to_the_stories_endpoint_with_continent(){
        locationDropDownPage.itemOfTheListIsSentToTheStoriesAPI();
    }








}
