package driverFactory;

import com.microsoft.playwright.*;
import utils.ReadProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private ThreadLocal<Playwright> playwrightThread = new ThreadLocal<>();
    private ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    private Properties properties;

    public Playwright getPlayWright(){
      return   playwrightThread.get();
    }
    public void setPlayWright(Playwright playWright){
        playwrightThread.set(playWright);
    }
    public Browser getBrowser(){
       return browserThreadLocal.get();
    }
    public void setBrowser(Browser browser){
        browserThreadLocal.set(browser);
    }
    public BrowserContext getBrowserContext(){
        return browserContextThreadLocal.get();
    }
    public void setBrowserContext(BrowserContext context){
        browserContextThreadLocal.set(context);
    }
    public Page getPage(){
       return pageThreadLocal.get();
    }
    public void setPage(Page page){
        pageThreadLocal.set(page);
    }



    public  void setBrowserManager(){

        try {
            setPlayWright(Playwright.create());
            String browser = ReadProperties.getPropertyValue("browser");
            switch(browser){
                case "chrome":
                    setBrowser(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")));
                    break;
                case "firefox":
                    setBrowser(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox")));
                    break;
                case "safari":
                    setBrowser(getPlayWright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                    break;
                case "edge":
                    setBrowser(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")));
                    break;
                default:
                    setBrowser(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                    break;
            }
            setBrowserContext(getBrowser().newContext(new Browser.NewContextOptions()
//                            .setScreenSize(430 , 932)
//                            .setDeviceScaleFactor(3)
//                            .setViewportSize(430 , 932)
                    )
            );
            getBrowserContext().setDefaultTimeout(60000);
            setPage(getBrowserContext().newPage());

        }catch (RuntimeException e){
            e.getMessage();

        }


    }

    public  void tearDown(){
        try {

            if (pageThreadLocal.get() != null) pageThreadLocal.get().close();
            if (browserThreadLocal.get() != null) browserThreadLocal.get().close();
            if (playwrightThread.get() != null) playwrightThread.get().close();
        }catch (RuntimeException e){
          e.getMessage();
        }

    }




}
