package stepDefinitions.hooks;

import driverFactory.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import pages.HomePageComponents.HomePage;

import java.sql.DriverManager;

public class Hooks {

    public final BrowserManager  bm;

    public Hooks(BrowserManager bm) {
        this.bm = bm;
    }


    @Before
    public void beforeScenario(){
        System.out.println("I am the before scenario hook");
        bm.setBrowserManager();



    }

    @After
    public void afterScenario(){
        bm.tearDown();
    }
}
