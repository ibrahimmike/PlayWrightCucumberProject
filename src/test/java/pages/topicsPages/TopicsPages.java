package pages.topicsPages;

import driverFactory.BrowserManager;
import pages.BasePage;

public class TopicsPages extends BasePage {

    private final String topicsHeader = "//article[contains(@class,'__topic-header___')]";
    public TopicsPages(BrowserManager browserManager) {

        super(browserManager);
        browserManager.getPage().waitForSelector(topicsHeader);
    }

    public String getUrl(){
        return getBrowserManager().getPage().url();
    }
}
