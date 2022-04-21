package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;


import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author Edward
 * @since 04/20/2022
 */
public class DynamicLoadingExample1Page extends PageObject {

    @FindBy(css = "#start button")
    private WebElementFacade startButton;

    @FindBy(id = "finish")
    private WebElementFacade loadedText;

    @Step("Load hidden word using implicit waits")
    public String clickStartButton1() {
        startButton.click();
        setImplicitTimeout(7, SECONDS);
        waitFor(loadedText).isDisplayed();
        // So once you are done, you should always reset the implicit timeout to its previous value.
        resetImplicitTimeout();
        return loadedText.getText();
    }

    @Step("Load hidden word using explicit timeouts")
    public String clickStartButton2() {
        startButton.click();

        // The default time that Serenity will wait is 5 seconds
        // Sometimes you want to give WebDriver some more time for a specific operation.
        // You can override or extend the explicit timeout by using the withTimeoutOf() method
        withTimeoutOf(7, SECONDS).waitFor(loadedText).isDisplayed();
        return loadedText.getText();
    }

}
