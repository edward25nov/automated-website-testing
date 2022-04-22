package stepsDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import pages.cucumberPages.DuckDuckGoHomePage;
import pages.cucumberPages.SearchForPage;
import pages.cucumberPages.SearchResultPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author Edward
 * @since 04/21/2022
 */
public class SearchStepdefs {

    @Steps
    DuckDuckGoHomePage navigateTo;

    @Steps
    SearchForPage searchFor;

    @Steps
    SearchResultPage searchResult;

    @Given("Sergey is on the DuckDuckGo home page")
    public void SergeyIsOnTheDuckDuckGoHomePage(){
        navigateTo.theDuckDuckGoHomePage();
    }

    @When("he search for {string}")
    public void heSearchFor(String term) {
        searchFor.term(term);
    }

    @Then("all the result titles should contain the word {string}")
    public void allTheResultTitlesShouldContainTheWord(String expectedTerm) {
        // https://reflectoring.io/assertj-lists/
        assertThat(searchResult.titles())
                .isNotEmpty()
                .allMatch(title -> title.contains(expectedTerm));
    }
}
