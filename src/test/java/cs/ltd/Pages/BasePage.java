package cs.ltd.Pages;

import cs.ltd.Driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {
    static protected WebDriver driver = DriverFactory.getDriver();
}
