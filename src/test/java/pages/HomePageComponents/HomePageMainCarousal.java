package pages.HomePageComponents;

import driverFactory.BrowserManager;
import pages.BasePage;

public class HomePageMainCarousal extends BasePage {

    private final String nextChevron = "//div[contains(@class,'__main_carousel_container___')]//div[contains(@class,'__arrow_button_next___')]";
    private final String sentimentSlideTitle = "//div[contains(@class,'__tiles_slider_item___')]//div[text()='Insight into the mood of the market']";
    private final String premiumBtn = "//div[contains(@class,'__carousel_tabs_container___')]//div[text()='Premium']";
    private final String sentimentBtn = "//div[contains(@class,'__carousel_tabs_container___')]//div[text()='Sentiment']";
    private final String internalContent = "//div[contains(@class,'__carousel_tabs_container___')]//div[text()='Internal Content']";
    private final String previousChevron = "//div[contains(@class,'__main_carousel_container___')]//div[contains(@class,'__arrow_button_prev___')]";
    private final String premiumSlideTitle = "//div[contains(@class,'__tiles_slider_item___')]//div[text()='Skip the Paywalls. Skip the Ads.']";


    public HomePageMainCarousal(BrowserManager browserManager) {
        super(browserManager);
    }

   public void clickOnTheNextChevron(){
        browserManager.getPage().waitForSelector(nextChevron).click();
   }
   public boolean theSentimentSlideShouldShow(){
      return browserManager.getPage().waitForSelector(sentimentSlideTitle).isVisible();
   }
   public void clickOnSentimentBtn(){
        browserManager.getPage().waitForSelector(sentimentBtn).click();
   }
   public void clickOnInternalContent(){
        browserManager.getPage().waitForSelector(internalContent).click();
   }
   public void clickOnPremiumBtn(){
        browserManager.getPage().waitForSelector(premiumBtn).click();
   }
   public void clickOnThePreviousChevron(){
        browserManager.getPage().waitForSelector(previousChevron).click();
   }
   public boolean thePremiumSlideTitleIsVisible(){
        return browserManager.getPage().waitForSelector(premiumSlideTitle).isVisible();
   }



}
