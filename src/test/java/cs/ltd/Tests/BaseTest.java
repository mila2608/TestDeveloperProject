package cs.ltd.Tests;

import cs.ltd.App;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Factory;

public class BaseTest {
    static App app = new App();


    /*@AfterSuite
    public void tearDown() {
        app.homePage.closeApp();
    }*/
}

