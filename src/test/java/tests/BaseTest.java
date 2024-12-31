package tests;

import driverFactory.BrowserManager;
import pages.HomePageComponents.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    BrowserManager browserManager;
    HomePage hp;

    @BeforeMethod
    public void setUP(){
       browserManager = new BrowserManager();
        hp = new HomePage(browserManager);

    }
    @AfterMethod
    public void tearDown(){
        browserManager.tearDown();
    }
}
