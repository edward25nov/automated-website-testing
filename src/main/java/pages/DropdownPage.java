package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;

/**
 * @author Edward
 * @since 04/19/2022
 */
public class DropdownPage extends PageObject {

    @FindBy(id = "dropdown")
    private WebElementFacade dropdown;

    @Step("Select value {0} from dropdown list")
    public void selectFromDropdown(String option) {
        dropdown.selectByVisibleText(option);
    }

    @Step("Get selected options")
    public String getSelectedElements() {
        return dropdown.getFirstSelectedOptionVisibleText();
    }

}
