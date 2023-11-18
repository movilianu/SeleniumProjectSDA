import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.*;

public class firstSeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("");
        driver = new ChromeDriver(options);  // ChromeDriver initialization
        driver.manage().window().maximize();
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