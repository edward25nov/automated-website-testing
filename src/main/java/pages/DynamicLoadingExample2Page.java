package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Edward
 * @since 04/20/2022
 */
public class DynamicLoadingExample2Page extends PageObject {

    @FindBy(css = "#start button")
    private WebElementFacade startButton;

    private final By LOADED_TEXT = By.id("finish");

    @Step("Load hidden word using explicit timeouts")
    public String clickStartButton1() {
        startButton.click();
        waitFor(ExpectedConditions.presenceOfElementLocated(LOADED_TEXT)).isDisplayed();
        return $(LOADED_TEXT).getText();
    }

}
