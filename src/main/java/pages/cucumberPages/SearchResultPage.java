package pages.cucumberPages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Edward
 * @since 04/21/2022
 */
public class SearchResultPage extends PageObject {

    private final By RESULT_TITLES = By.cssSelector("#links .result__title a:nth-child(1)");

    @Step("Get all titles result")
    public List<String> titles() {
        return findAll(RESULT_TITLES)
                .stream()
                .map(WebElementFacade::getTextContent)
                .filter(text -> !text.equalsIgnoreCase("Ad"))
                .collect(Collectors.toList());
    }
}
