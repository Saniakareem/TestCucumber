package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Parameters Junit test runner class
@RunWith(Cucumber.class)
@CucumberOptions
        (
                features ="C:\\Users\\Dell\\Desktop\\SaniaCucumberTest\\SeleniumCucumber1.1-master\\Features\\Login.feature",
                glue="stepDefinitions",
                monochrome = true,
                plugin = {"pretty", "html:target/html-test-output.html",
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml" }

        )

public class TestRunner {

}
