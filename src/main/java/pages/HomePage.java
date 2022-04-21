package pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import utils.PropertySource;
import utils.constants.KeyProperties;

/**
 * @author Edward
 * @since 04/11/2022
 */
public class HomePage extends PageObject {

    @Step("This step will verify the title")
    public String verifyTitle() {
        return getDriver().getTitle();
    }

    @Step("This step will allow us to login to application for user {0}")
    public void enterCredentials(String user, String password) {
        $(By.id("txtUsername")).type(user);
        $(By.id("txtPassword")).type(password);
        $(By.id("btnLogin")).click();
    }

    @Step("This step will verify the dashboard")
    public String verifyDashboard() {
        return getDriver().getCurrentUrl();
    }

    @Step("Navigate to the OrangeHRM home page")
    public void toTheOrangeHomePage() {
        PropertySource prop = new PropertySource();
        openUrl(prop.getProperty(KeyProperties.ORANGE_LOGIN.getValue()));
    }

    @WhenPageOpens
    @Step("Maximize our browser")
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

}
