package pages.OnboardingPages;

import driverFactory.BrowserManager;
import pages.BasePage;
import pages.SearchBarPage;

public class CreateWatchListPage extends BasePage {

    private final String searchBaXpath = "//section[@data-component='SearchbarInput']";
    public CreateWatchListPage(BrowserManager browserManager) {
        super(browserManager);
        browserManager.getPage().waitForSelector(searchBaXpath);
    }
    public SearchBarPage clickOnTheSearchBar(){
        browserManager.getPage().click(searchBaXpath);
        return new SearchBarPage(browserManager);
    }


}
