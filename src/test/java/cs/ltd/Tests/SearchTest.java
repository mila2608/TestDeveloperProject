package cs.ltd.Tests;

import org.testng.annotations.Test;

import java.io.IOException;

import static cs.ltd.Tests.BaseTest.app;

public class SearchTest {
    @Test
    public void search() throws IOException {
        app.homePage.searchText();
        app.homePage.resultList();
        app.homePage.compareToFiles();
   //     app.homePage.closeApp();

    }


}
