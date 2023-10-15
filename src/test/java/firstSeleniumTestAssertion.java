import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class firstSeleniumTestAssertion {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintSDAcademyPageTitleOnConsole() {
        driver.get("https://sdacademy.dev"); // open https://sdacademy.dev

        // checking if the current page title is as expected
        assertEquals("Software Development Academy | Give IT a go!", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}