package cs.ltd.Helpers;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import cs.ltd.Pages.BasePage;
import cs.ltd.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HomePageHelper extends HomePage {
    WebDriverWait wait = new WebDriverWait(driver, 60);

    public void searchText() {
        search();
    }

    public void resultList() throws IOException {

        result();

    }

    public void closeApp() {
        driver.quit();
    }
}
