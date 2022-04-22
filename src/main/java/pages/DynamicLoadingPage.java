package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;

/**
 * @author Edward
 * @since 04/20/2022
 */
public class DynamicLoadingPage extends PageObject {

    @FindBy(xpath = ".//a[contains(text(), \"Example 1\")]")
    private WebElementFacade link_Example1;

    @FindBy(xpath = ".//*[@id=\"content\"]/div/a[2]")
    private WebElementFacade link_Example2;

    @Step("Click on example 1")
    public DynamicLoadingExample1Page clickExample1() {
        link_Example1.click();
        return new DynamicLoadingExample1Page();
    }

    @Step("Click on example 2")
    public DynamicLoadingExample2Page clickExample2() {
        link_Example2.click();
        return new DynamicLoadingExample2Page();
    }

}
