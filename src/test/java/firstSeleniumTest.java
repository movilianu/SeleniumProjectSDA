import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.*;

public class firstSeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintSDAcademyPageTitleOnConsole() {
        driver.get("https://sdacademy.dev"); // open https://sdacademy.dev

        System.out.println(driver.getTitle()); // retrieve page's title and print it in the console
        assertEquals("Software Development Academy | Give IT a go!", driver.getTitle());
        assertNotEquals("Textul vechi al titlului! Xamolxes e smeq.", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}