package pages.cucumberPages;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

/**
 * @author Edward
 * @since 04/21/2022
 */
public class SearchForPage extends UIInteractionSteps {

    private final By SEARCH_FIELD = By.name("q");
    private final By SEARCH_BUTTON = By.cssSelector(".search__button");

    @Step("Search for term {0}")
    public void term(String term) {
        $(SEARCH_FIELD).clear();
        $(SEARCH_FIELD).type(term);
        $(SEARCH_BUTTON).click();
    }
}
