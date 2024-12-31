package pages;

import com.microsoft.playwright.Locator;
import driverFactory.BrowserManager;
import pages.topicsPages.TopicsPages;

import java.util.function.BooleanSupplier;

public class SearchBarPage extends BasePage {


    private boolean searchBarSentTheRequestToSearchMetadataFuzzy;
    private final String searchTopics = "//div[contains(@class, '__search_result_name__')]//span[contains(@class, 'module__name__')]";
    private final String searchBar = "//div//section[@data-component='SearchbarInput']//input[@placeholder='']";
    private final String keyWordInTheSearch = "//div[@data-component='SearchBarKeywordsList']//div/span";
    private final String topicsSearchList = "//div[contains(@class,'__searchbar_topics_list_wrapper___')]";
    private final String advancedSearchTab = "//div[contains(@class,'__searchbar_types___')]//div[text()='Advanced Search']";
    private final String topicsInTheSearchBar = "//div[@class='menu-wrapper']//div[contains(@class, 'menu-item-wrapper')]//span";
    private final String searchBtn = "//div[contains(@class,'__button_submit___')]";//span[text()='Search']
    private final String cancelBtn = "//div[contains(@class,'__button_cancel___')]";
    private String searchKey;









    public SearchBarPage(BrowserManager browserManager) {
        super(browserManager);
        browserManager.getPage().waitForSelector(searchTopics);
    }

    public boolean searchElementsAreVisible() {
        return browserManager.getPage().waitForSelector(searchTopics).isVisible();
    }

    public SearchBarPage enterASearchTopic(String searchKey) {
        this.searchKey = searchKey;
        browserManager.getPage().waitForSelector(searchBar).fill(searchKey);
        browserManager.getPage().waitForSelector(keyWordInTheSearch).isVisible();
        return this;
    }
    public void clickOnTheSearchBar(){
        browserManager.getPage().waitForSelector(searchBar).click();
    }

    public boolean theSearchEnteredIsShowingInTheKeyWord(String keySearch) {
        String keyWord = browserManager.getPage().waitForSelector(keyWordInTheSearch).textContent().trim();
        System.out.println("key word search : " + keyWord);
        return keySearch.equalsIgnoreCase(keyWord);
    }

    public boolean theSearchTopicsAreVisible() {
        return browserManager.getPage().waitForSelector("//div[contains(@class,'__searchbar_topics_list_wrapper___')]").isVisible();
    }

    private BooleanSupplier theLoadOfTheSearchIsOver(){
       BooleanSupplier sup = ()-> browserManager.getPage().querySelectorAll("//div[@data-component='BluePreloader']//div[contains(@class,'__preloader_wrapper___')]").isEmpty();

       return sup;
    }



   public SearchForTopicsAndStoriesPage clickOnTheSearchBtnToGetTheSearchForTopics(){

       browserManager.getPage().waitForLoadState();
       boolean loaded = !browserManager.getPage().querySelectorAll("//div[@data-component='BluePreloader']//div[contains(@class,'__preloader_wrapper___')]").isEmpty();
//       while (!loaded){
//           try {
//               browserManager.getPage().wait(5000);
//           }catch(InterruptedException e){
//               e.getMessage();
//           }
//       }
       browserManager.getPage().waitForCondition(theLoadOfTheSearchIsOver());


        browserManager.getPage().waitForSelector(searchBtn);
//        browserManager.getPage().waitForSelector(searchBtn).click();
//       browserManager.getPage().waitForSelector(searchBtn).click();
       browserManager.getPage().locator(searchBtn).dblclick(new Locator.DblclickOptions().setDelay(2));

        return new SearchForTopicsAndStoriesPage(browserManager);
   }
   public TopicsPages clickOnTheSearchBtnAndGetToTheTopicsPages(){
       browserManager.getPage().waitForSelector(keyWordInTheSearch).isVisible();
       browserManager.getPage().locator(searchBtn).click();
       return new TopicsPages(browserManager);
   }


    public AdvancedSearchOperators getAdvancedSearchOperator(){
        return new AdvancedSearchOperators();
    }




    public class AdvancedSearchOperators{
        private final String openBracket = "//div[contains(@class,'__advanced-search-operators___')]//div[text()='(']";
        private final String closeBracket = "//div[contains(@class,'__advanced-search-operators___')]//div[text()=')']";
        private final String andBtn = "//div[contains(@class,'__advanced-search-operators___')]//div[text()='AND']";
        private final String orBtn = "//div[contains(@class,'__advanced-search-operators___')]//div[text()='OR']";
        private final String andNotBtn = "//div[contains(@class,'__advanced-search-operators___')]//div[text()='AND NOT']";
        private final String okSignForTheSearchXpath  = "//div[contains(@class,'__query_validation_status___')]";

        public AdvancedSearchOperators clickOnAdvancedSearch(){
            browserManager.getPage().waitForSelector(advancedSearchTab).click();
            return this;
        }
        public AdvancedSearchOperators clickOnTheOpenBracket(){
            browserManager.getPage().waitForSelector(openBracket).click();
            return this;
        }
        public AdvancedSearchOperators clickOnTheCloseBracket(){
            browserManager.getPage().waitForSelector(closeBracket).click();
            return this;
        }
        public AdvancedSearchOperators clickOnTheAndBtn(){
            browserManager.getPage().waitForSelector(andBtn).click();
            return this;
        }
        public AdvancedSearchOperators clickOnTheAndNotBtn(){
            browserManager.getPage().waitForSelector(andNotBtn).click();
            return this;
        }
        public AdvancedSearchOperators clickOnTheOrOperators()  {
           browserManager.getPage().waitForSelector(orBtn);
            browserManager.getPage().locator(orBtn).click();
            return this;
        }
        public AdvancedSearchOperators writeASearchBetweenBrackets(String searchItem){
              browserManager.getPage().click(searchBar);
              browserManager.getPage().waitForSelector(searchBar).fill(searchItem);
            return this;
        }
        public SearchForTopicsAndStoriesPage clickOnAdvancedSearchSearchBtn(){
            browserManager.getPage().waitForCondition(theLoadOfTheSearchIsOver());

            browserManager.getPage().locator(searchBtn).dblclick(new Locator.DblclickOptions().setDelay(2));



            return new SearchForTopicsAndStoriesPage(browserManager);
        }




    }







}
