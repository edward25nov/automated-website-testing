package app;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;
import pages.ExampleHomePage;

/**
 * @author Edward
 * @since 04/20/2022
 */
@RunWith(SerenityRunner.class)
public class DynamicLoadingTest {

    @Managed
    WebDriver driver;

    @Steps
    ExampleHomePage exampleHomePage;

    @Steps
    DynamicLoadingPage dynamicLoadingPage;

    @Steps
    DynamicLoadingExample1Page dynamicLoadingExample1Page;

    @Steps
    DynamicLoadingExample2Page dynamicLoadingExample2Page;

    @Test
    @Title("First way: using implicit wait to work with element on page that is hidden")
    public void usingImplicitWait() {
        exampleHomePage.toTheHomePage();
        exampleHomePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample1();
        String result = dynamicLoadingExample1Page.clickStartButton1();
        Assert.assertEquals(result, "Hello World!");
    }

    @Test
    @Title("Second way: using explicit wait (timeouts) to work with element on page that is hidden")
    public void usingExplicitWait() {
        exampleHomePage.toTheHomePage();
        exampleHomePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample1();
        String result = dynamicLoadingExample1Page.clickStartButton2();
        Assert.assertEquals(result, "Hello World!");
    }


    @Test
    @Title("Another way to use explicit timeouts - Element rendered after the fact")
    public void elementRenderedAfter() {
        exampleHomePage.toTheHomePage();
        exampleHomePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample2();
        String result = dynamicLoadingExample2Page.clickStartButton1();
        Assert.assertEquals(result, "Hello World!");
    }

}
