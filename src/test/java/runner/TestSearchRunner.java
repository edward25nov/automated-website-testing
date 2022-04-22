package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author Edward
 * @since 04/21/2022
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/search/search_by_keyword.feature",
        glue = {"stepsDefs"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber1.json", "html:target/cucumber-reports/report1.html"}
)
public class TestSearchRunner {
}
