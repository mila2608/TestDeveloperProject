package cs.ltd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy (name = "#")
    private WebElement spanGlass;

    @FindBy (name = "search_form_type[term]")
    private WebElement search;


}
