package pages.HomePageComponents;

import driverFactory.BrowserManager;
import pages.BasePage;
import pages.newsAndSearchPages.NewsAndSearchPage;

public class TopStoriesGlobally extends BasePage {

    private final String topStoriesGloballyText = "Top Stories Globally";
    private final String seeMoreBtn = "//div[contains(@class,'__top-news-wrapper___')]//a[text()='See More']";

    private final String topStoriesGloballyScrollableContainer = "//div[contains(@class,'__top-news-wrapper___')]//div[contains(@class,'__scrollable-container___')]";
    public TopStoriesGlobally(BrowserManager browserManager) {
        super(browserManager);

        browserManager.getPage().waitForSelector(topStoriesGloballyScrollableContainer).scrollIntoViewIfNeeded();
    }

    public boolean clickOnTopStoriesGlobally(){
        return browserManager.getPage().getByAltText(topStoriesGloballyText).isVisible();
    }

    public NewsAndSearchPage clickOnSeeMore(){
        browserManager.getPage().waitForSelector(seeMoreBtn).click();
        return new NewsAndSearchPage(browserManager);

    }



}
