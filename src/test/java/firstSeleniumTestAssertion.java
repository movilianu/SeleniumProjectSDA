import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class firstSeleniumTestAssertion {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintSDAcademyPageTitleOnConsole() {
        driver.get("https://sdacademy.dev"); // open https://sdacademy.dev

        // checking if the current page title is as expected
        assertEquals(driver.getTitle(), "Software Development Academy - Learn IT from Scratch");
    }

    @After
    public void tearDown() {
        driver.close(); // close browser
    }
}