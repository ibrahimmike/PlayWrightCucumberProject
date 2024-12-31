package pages.newsAndSearchPages;

import driverFactory.BrowserManager;
import pages.BasePage;

public class NewsAndSearchPage extends BasePage {

    private final String filterWrapper = "//div[contains(@class,'__filters-buttons-wrapper___')]";
    public NewsAndSearchPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean newsAndSearchPageIsLoaded(){
       return browserManager.getPage().waitForSelector(filterWrapper).isVisible();
    }


}
