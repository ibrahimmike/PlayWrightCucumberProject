package pages.HomePageComponents;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.microsoft.playwright.*;
import driverFactory.BrowserManager;
import pages.BasePage;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class GeneralFiltersAndSettings extends BasePage {

    private final String generalSettingsFilter = "//div[contains(@class, 'top-news-wrapper')]//parent::div[contains(@class, 'top-news-wrapper')]" +
            "//following::div[contains(@class, 'general-filters-section')]//div[contains(@class,'filters-wrapper')]//div[contains(@class,'location-filter')]";

    private final String generalSettingsTitle = "//div[contains(@class, 'top-news-wrapper')]//" +
            "parent::div[contains(@class, 'top-news-wrapper')]//following::div[contains(@class, 'general-filters-section')]//span[text()='General filters and settings']";

    private final String languageButtonList = "//button[@id='source-dropdown-button']";
    private boolean boo;
    public GeneralFiltersAndSettings(BrowserManager browserManager) {
        super(browserManager);
        scrollToElement(generalSettingsFilter);
    }
    public boolean generalSettingsTitleIsVisible(){
        return browserManager.getPage().waitForSelector(generalSettingsTitle).isVisible();
    }
    public LocationDropDownPage clickOnTheLocationsDropDownList(){
        browserManager.getPage().waitForSelector(generalSettingsFilter).click();
        return new LocationDropDownPage();
    }
    public LanguagesFilter clickOnLanguagesBtnFilter(){
        browserManager.getPage().waitForSelector(languageButtonList).click();
        return new LanguagesFilter(browserManager);
    }

    public class LocationDropDownPage {
        private final String dropDownLocations = "//div[contains(@class,'__location-filter___')]";
        private final String locationFiltersArea = "//div[contains(@class,'__location-filter___')]//div[@class='menu-wrapper']";

        private final String locationsAreasButtons = "//div[contains(@class,'__location-filter___')]//div[@class='menu-wrapper']//button";

        private final String locationsItemList = "//div[contains(@class,'__location-filter___')]" +
                "//div[contains(@class,'__location-filter-content___')]//span[contains(@class,'__location-filter-item-container-name___')]";
        private final String visibleSearchItemsNames = "//div[contains(@class,'__location-filter-item-container___')]//span";




        private void waitForLocationsFilterAreaToBeVisible(){
            browserManager.getPage().waitForSelector(locationsAreasButtons);
        }
        private void waitForLocationsItemListToBeVisible(){
            browserManager.getPage().waitForSelector(locationsItemList);
        }
        public boolean locationsDropDownIsVisible(){
            waitForLocationsFilterAreaToBeVisible();
            return browserManager.getPage().waitForSelector(dropDownLocations).isVisible();
        }

        public LocationDropDownPage clickOnDesignatedBtn(String button){
            waitForLocationsFilterAreaToBeVisible();
            List<ElementHandle> buttonsLocators = browserManager.getPage().querySelectorAll(locationsAreasButtons);
            for (ElementHandle btn : buttonsLocators){
                if (btn.textContent().equalsIgnoreCase(button)){
                    btn.click();
                }
            }
            return this;

        }
        public boolean listOfContinentsIsDisplayed(){
            waitForLocationsItemListToBeVisible();
            boolean check = false;
            List<String> displayedContinentsNames = new ArrayList<>();
            List<ElementHandle>  listOfContinents =  browserManager.getPage().querySelectorAll(locationsItemList);
            for (ElementHandle continentName : listOfContinents){
              if (Objects.nonNull(continentName.asElement().textContent())){
                  displayedContinentsNames.add(continentName.asElement().textContent());
              }
            }
            System.out.println(displayedContinentsNames);
            List<String> continents = Arrays.asList("Africa","Antarctica","Asia", "Europe", "North America","Oceania/Australia","South America");

            if (displayedContinentsNames.containsAll(continents)){
                check = true;
            }else {
                check = false;
            }

            return check;
        }
        public LocationDropDownPage userChoosesContinentAsia(){

            Request request ;

            try{
                request  = browserManager.getPage()
                        .waitForRequest("https://www.cityfalcon.com/webapi/v1/stories?" +
                                "all_languages=false&categories=mp%2Cop%2Cr&domains_filtering_mode=all&fold_similar_stories=true&languages=en&limit=20&min_score=5&" +
                                "only_with_images=true&order_by=top&premium_only=false&query=" +
                                "%22group%3ACountry%3A2%3AUnited+Kingdom+of+Great+Britain%22+OR+%22group%3ACountry%3A26%3AUnited+States+of+" +
                                "America%22+OR+%22group%3AContinent%3A1%3AAsia%22" +
                                "&selected_time_filter=predefined&time_filter=week1&with_sentiments=true", () -> {
                            browserManager.getPage().locator("//div[contains(@class,'__location-filter-item-container___')]//span[text()='Asia']").click();
                        });

                boo= true;
            }catch(TimeoutError error){
                boo = false;
                throw new RuntimeException("The request was not sent");
            };


            return this;
        }
        public boolean itemOfTheListIsSentToTheStoriesAPI(){

            return boo;
        }





    }
    public class LanguagesFilter extends BasePage{
        public LanguagesFilter(BrowserManager browserManager) {
            super(browserManager);
        }

    }






}
