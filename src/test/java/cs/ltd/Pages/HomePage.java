package cs.ltd.Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@class = 'pure-menu-link squared scope']")
 //"//*[@id=\"undefined-sticky-wrapper\"]/header/div/div/div[2]/div[1]/ul/li[1]/a")
   // @FindBy (className = "pure-menu-link squared scope")
    private WebElement spanGlass;

  //  @FindBy(xpath = "input[@id = 'search_form_type_term']")
    @FindBy(name = "search_form_type[term]")
    private WebElement search;


    protected void search() {
        spanGlass.click();
        search.sendKeys("DEVELOPER");
        search.submit();
    }

    protected void result() throws IOException {
        ArrayList<String> resultText = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='section-search']/div/div[2]/div[2]/ul/li/a"));
         //elements.get(0).click();
        for (WebElement element : elements) {
            System.out.println(element.getText());
            resultText.add(element.getText());
        }
        FileWriter writer = new FileWriter("actual.txt");
        for (String line : resultText) {
            writer.write(line);
            writer.write(System.getProperty("line.separator"));
        }
        writer.close();
    }

    public void compareToFiles() throws IOException {
        File f1 = new File("actual.txt");
        File f2 = new File("expected.txt");
        if (!f1.exists() && !f1.exists()) {
           // System.out.printf("File %s doesn't exist",f1.getAbsolutePath());
           // System.out.printf("File %s doesn't exist",f2.getAbsolutePath());
            System.out.println("File was not found");
        }
        else {
            List<String> file1 = Files.readAllLines(Paths.get("actual.txt"));
            List<String> file2 = Files.readAllLines(Paths.get("expected.txt"));
            assertEquals(file1.size(), file2.size());
            for (int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
        }
    // assertEquals(FileUtils.checksumCRC32((File) file1), FileUtils.checksumCRC32((File) file2));
    }

    public void compareToFiles2()  {
        File f1 = new File("actual.txt");
        File f2 = new File("expected.txt");
        try {
            if (f1.exists() && f1.exists()) {
                // System.out.printf("File %s doesn't exist",f1.getAbsolutePath());
                // System.out.printf("File %s doesn't exist",f2.getAbsolutePath());
                List<String> file1 = Files.readAllLines(Paths.get("actual.txt"));
                List<String> file2 = Files.readAllLines(Paths.get("expected.txt"));
                assertEquals(file1.size(), file2.size());
                for (int i = 0; i < file1.size(); i++) {
                    System.out.println("Comparing line: " + i);
                    assertEquals(file1.get(i), file2.get(i));
                }
            }
            throw new FileNotFoundException("File was not found in TRY block");
        }
        catch (IOException e)
        {
            System.out.println("File was not found in CATCH block");
        }
          /*  else {
                List<String> file1 = Files.readAllLines(Paths.get("actual.txt"));
                List<String> file2 = Files.readAllLines(Paths.get("expected.txt"));
                assertEquals(file1.size(), file2.size());
                for (int i = 0; i < file1.size(); i++) {
                    System.out.println("Comparing line: " + i);
                    assertEquals(file1.get(i), file2.get(i));
                }
            }*/
        //   e.printStackTrace();
    }


}

