import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

import java.util.List;


public class testExerciseSix {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintNumberOfImagesAndLinksOnBBCPage() {
        List<WebElement> allImagesOnPage, allLinksOnPage;

        driver.get("https://www.bbc.com"); // open https://www.bbc.com

        allImagesOnPage = driver.findElements(By.tagName("img")); // assigning images (WebElements <img>) to the allImagesOnPage list
        allLinksOnPage = driver.findElements(By.tagName("a")); // assigning links (WebElements <a>) to the allLinksOnPage list

        System.out.println("Number of pictures on page: " + allImagesOnPage.size()); // printing the number of pictures on page in the console
        System.out.println("Number of links on page: " + allLinksOnPage.size()); // printing the number of links on page in the console

        Assertions.assertEquals(60, allImagesOnPage.size());
        Assertions.assertEquals(292, allLinksOnPage.size());
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}