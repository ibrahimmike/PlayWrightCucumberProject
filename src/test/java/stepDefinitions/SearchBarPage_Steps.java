package stepDefinitions;

import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.SearchBarPage;
import pages.SearchForTopicsAndStoriesPage;
import pages.topicsPages.TopicsPages;

import java.util.EventListener;

public class SearchBarPage_Steps {


    private final SearchBarPage sbp;
    private SearchForTopicsAndStoriesPage searchForTopicsAndStoriesPage;
    private TopicsPages topicsPages;
    private SearchBarPage.AdvancedSearchOperators advancedSearchOperators;

    private String url;

    public SearchBarPage_Steps(SearchBarPage sbp) {
        this.sbp = sbp;
    }

    @And("The user types a search on the search bar page {word}")
    public void user_types_a_search_on_the_search_bar_page(String searchItem){
        sbp.enterASearchTopic(searchItem);
    }
    @And("The search bar page is loaded")
    public void the_search_bar_is_loaded(){
      Assert.assertTrue(sbp.searchElementsAreVisible());
    }
    @Then("The search entered by the user is showing on the keyword search")
    public void the_search_entered_by_the_user_is_showing_on_the_keyword_search_topic(){
        Assert.assertTrue(sbp.theSearchEnteredIsShowingInTheKeyWord("Gold"));
    }
    @Then("The search entered by the user is showing on the keyword search {word}")
    public void the_search_entered_by_the_user_examples_is_showing_on_the_keyword_search_topic(String topic){
        sbp.theSearchEnteredIsShowingInTheKeyWord(topic.trim());
    }
    @And ("The user types a search for a predefined topic on the search bar")
    public void the_user_types_a_search_on_the_search_bar(){
        sbp.enterASearchTopic("Gold");

    }
    @And("User clicks on the search button next to the search bar to be redirected to the topic page")
    public void user_clicks_on_the_search_button_next_to_the_search_bar(){
      topicsPages =  sbp.clickOnTheSearchBtnAndGetToTheTopicsPages();
    }
    @Then ("User should be redirected to the topics search page")
    public void user_should_be_redirected_to_the_topics_search_page(){
        searchForTopicsAndStoriesPage = sbp.clickOnTheSearchBtnToGetTheSearchForTopics();
      Assert.assertTrue(searchForTopicsAndStoriesPage.getUrl().equalsIgnoreCase("https://www.cityfalcon.ai/search"));



    }
    @Then("User should be redirected to the topic page")
    public void user_should_be_redirected_to_the_topic_page(){
        url = topicsPages.getUrl();
        System.out.println("The url value : "+url);
        Assert.assertTrue(url.contains("gold"));
    }
    @When("The user clicks on the advanced search tab")
    public void the_user_clicks_on_the_advanced_search_tab(){
          advancedSearchOperators =    sbp.getAdvancedSearchOperator();
          advancedSearchOperators.clickOnAdvancedSearch();
    }
    @When("The user clicks on the open bracket operator")
    public void the_user_clicks_on_the_open_bracket_operator(){
        advancedSearchOperators.clickOnTheOpenBracket();
    }
    @And ("The user clicks on the search bar")
    public void the_user_clicks_on_the_search_bar(){
        sbp.clickOnTheSearchBar();
    }
    @And("The user clicks on the closing bracket operator")
    public void the_user_clicks_on_the_closing_bracket_operator(){
        advancedSearchOperators.clickOnTheCloseBracket();
    }
    @And("The user clicks on the or operator")
    public void the_user_clicks_on_the_or_operator(){
        advancedSearchOperators.clickOnTheOrOperators();
    }
    @And("User clicks on the search button next to the search bar to be redirected to the search")
    public void user_clicks_on_the_search_button_next_to_the_search_bar_to_be_redirected_to_the_search(){
        sbp.getAdvancedSearchOperator().clickOnAdvancedSearchSearchBtn();
    }
    @And("User types a search between the brackets")
    public void user_types_a_search_between_the_brackets(){
        advancedSearchOperators.writeASearchBetweenBrackets("Nasdaq");

    }
    @And("User types a search in the advanced search")
    public void user_types_a_search_in_the_advanced_search(){

    }












}
