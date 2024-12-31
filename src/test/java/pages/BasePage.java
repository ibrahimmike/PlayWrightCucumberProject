package pages;

import com.microsoft.playwright.Locator;
import driverFactory.BrowserManager;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

   protected BrowserManager browserManager;
    public BasePage(BrowserManager browserManager){
        this.browserManager = browserManager;

    }
    public BrowserManager getBrowserManager(){
        return browserManager;
    }

    protected boolean allElementsAreVisible(Locator locator){

        System.out.println("The size of the locators : " + locator.all().size());


        ArrayList<Integer> check = new ArrayList<>();
        if (!locator.all().isEmpty()){
            List<Locator> locators = locator.all();
            System.out.println("The locators are visible : "+locators.size());

            for (Locator  lo: locators){
                if(lo.isVisible()){
                    check.add(1);
                }else{
                    check.add(0);
                }
            }
        }else{
            System.out.println("locator is Empty");
        }
        System.out.println("The value of the check : "+check);


        return !check.contains(0)&& !check.isEmpty();
    }

    public boolean scrollToElement(String locator){
        browserManager.getPage().locator(locator).scrollIntoViewIfNeeded();
        if (browserManager.getPage().waitForSelector(locator).isVisible()){
            return true;
        }else{
            return false;
        }
    }
}
