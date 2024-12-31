package runner;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty","html:target/HtmlReports1/report.html",

        "json:target/JSONReports/report.json",

        "junit:target/JUnitReports/report.xml"}

)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)

    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

}


