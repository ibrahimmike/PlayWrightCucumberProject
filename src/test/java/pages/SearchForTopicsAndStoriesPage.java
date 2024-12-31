package pages;

import driverFactory.BrowserManager;

public class SearchForTopicsAndStoriesPage extends BasePage {

    private final String pageTitle = "//h1[text()='Search for Topics and Stories']";
    public SearchForTopicsAndStoriesPage(BrowserManager browserManager)
    {
        super(browserManager);
        browserManager.getPage().waitForSelector(pageTitle);


    }
    public boolean pageIsLoaded(){
       return  browserManager.getPage().waitForSelector(pageTitle).isVisible();
    }
    public String getUrl(){
        return browserManager.getPage().url();
    }
}
