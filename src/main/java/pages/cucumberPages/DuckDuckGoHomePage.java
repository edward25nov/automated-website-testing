package pages.cucumberPages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import utils.PropertySource;
import utils.constants.KeyProperties;

/**
 * @author Edward
 * @since 04/21/2022
 */
public class DuckDuckGoHomePage extends PageObject {

    @Step("Open the DuckDuckGo home page")
    public void theDuckDuckGoHomePage() {
        PropertySource prop = new PropertySource();
        openUrl(prop.getProperty(KeyProperties.DUCK_HOME.getValue()));
    }

    @WhenPageOpens
    @Step("Maximize our browser")
    public void maximizeScreen() {
        getDriver().manage().window().maximize();
    }

}
