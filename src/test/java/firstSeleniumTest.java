import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstSeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintSDAcademyPageTitleOnConsole() {
        driver.get("https://sdacademy.dev"); // open https://sdacademy.dev

        System.out.println(driver.getTitle()); // retrieve page's title and print it in the console
    }

    @After
    public void tearDown() {
        driver.close(); // close browser
    }
}