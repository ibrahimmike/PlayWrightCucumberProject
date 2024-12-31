package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.OnboardingPages.CreateWatchListPage;
import pages.SearchBarPage;

public class CreateWatchListPage_Steps {

    private final CreateWatchListPage createWatchListPage;
    private SearchBarPage searchBarPage;

    public CreateWatchListPage_Steps(CreateWatchListPage createWatchListPage) {
        this.createWatchListPage = createWatchListPage;
    }

//    @When("User clicks on the create watch list page search bar")
//     public void user_clicks_on_the_create_watch_list_page_search_bar(){
//        searchBarPage = createWatchListPage.clickOnTheSearchBar();
//
//    }
//    @And("The user types a search on the search bar")
//    public void the_user_types_a_search_on_the_search_bar(String topic){
//        searchBarPage.enterASearchTopic(topic);
//    }
//    @Then("The Search Bar Page with topics is visible on the create watch list page")
//    public void the_search_bar_page_with_topics_is_visible_on_the_create_watch_list_page(){
//        Assert.assertTrue(searchBarPage.searchElementsAreVisible());
//    }
}
