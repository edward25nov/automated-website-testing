package app;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

/**
 * @author Edward
 * @since 04/11/2022
 */
@RunWith(SerenityRunner.class)
public class WebSiteTest {

    @Managed
    WebDriver driver;

    @Test
    public void shouldInstantiateAWebDriverInstanceForAWebTest() {
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(titleContains("firefly - Buscar con Google"));

        Assert.assertTrue(driver.getTitle().contains("firefly - Buscar con Google"));

        driver.quit();
    }
}
