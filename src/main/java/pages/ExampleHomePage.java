package pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import utils.PropertySource;
import utils.constants.KeyProperties;

/**
 * @author Edward
 * @since 04/19/2022
 */
public class ExampleHomePage extends PageObject {

    @Step("Navigate to the home page")
    public void toTheHomePage() {
        PropertySource prop = new PropertySource();
        openUrl(prop.getProperty(KeyProperties.EXAMPLE_HOMEPAGE.getValue()));
    }

    @WhenPageOpens
    @Step("Maximize our browser")
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    @Step("Click on link text - dropdown.")
    public DropdownPage clickDropDown() {
        clickLink("Dropdown");
        return new DropdownPage();
    }

    @Step("Navigate to Dynamic Loading Page")
    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage();
    }

    private void clickLink(String linkText) {
        $(By.linkText(linkText)).click();
    }
}
