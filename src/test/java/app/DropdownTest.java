package app;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.DropdownPage;
import pages.ExampleHomePage;

/**
 * @author Edward
 * @since 04/19/2022
 */
@RunWith(SerenityRunner.class)
public class DropdownTest {

    @Managed
    WebDriver driver;

    @Steps
    ExampleHomePage exampleHomePage;

    @Steps
    DropdownPage dropdownPage;

    @Test
    public void testSelectOption() {
        exampleHomePage.toTheHomePage();
        exampleHomePage.clickDropDown();
        String option = "Option 2";
        dropdownPage.selectFromDropdown(option);
        String selectedOption = dropdownPage.getSelectedElements();
        Assert.assertEquals(option, selectedOption);
    }

}
