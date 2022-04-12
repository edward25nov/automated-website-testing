package pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

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
        $(By.id("txtPassword")).typeAndEnter(password);
    }

    @Step("This step will verify the dashboard")
    public String verifyDashboard() {
        return getDriver().getCurrentUrl();
    }

}
