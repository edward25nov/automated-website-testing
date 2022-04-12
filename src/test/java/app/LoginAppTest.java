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

/**
 * @author Edward
 * @since 04/11/2022
 */
@RunWith(SerenityRunner.class)
public class LoginAppTest {

    @Managed
    WebDriver driver;

    @Steps
    HomePage home;

    @Test
    @Title("Login to orange hrm site as admin.")
    public void loginAsAdmin() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertEquals("OrangeHRM", home.verifyTitle());
        home.enterCredentials("Admin", "admin123");
        Assert.assertTrue( home.verifyDashboard().contains("dashboard"));
    }

}
