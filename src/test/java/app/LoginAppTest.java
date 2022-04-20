package app;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.PropertySource;
import utils.constants.KeyProperties;

/**
 * @author Edward
 * @since 04/11/2022
 */
@RunWith(SerenityRunner.class)
public class LoginAppTest {

    //@Managed(driver = "firefox")
    @Managed
    WebDriver driver;

    @Steps
    HomePage home;

    @Test
    @Title("Login to orange hrm site as admin.")
    public void loginAsAdmin() {
        PropertySource prop = new PropertySource();
        driver.get(prop.getProperty(KeyProperties.ORANGE_LOGIN.getValue()));
        Assert.assertEquals("OrangeHRM", home.verifyTitle());
        home.enterCredentials(
                prop.getProperty(KeyProperties.ORANGE_USER.getValue()),
                prop.getProperty(KeyProperties.ORANGE_PASS.getValue()));
        Assert.assertTrue(home.verifyDashboard().contains("dashboard"));
    }

}
