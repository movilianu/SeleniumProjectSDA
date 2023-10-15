import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * In acest test vom:
 * - accesa google
 * - refuza cookie-uri
 * - cauta pe google prin input box "Java"
 * - afisa in consola numarul de rezultate de pe pagina
 */
public class testExerciseSeven {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintNumberOfResultsOnFirstPageWhenSearchingForJava() throws InterruptedException {
        final String googleSearchQuery = "Java";
        final String searchResultsCssSelector = "h3";

        WebElement googleSearchInput;
        List<WebElement> searchResults;

        driver.get("http://www.google.com"); // open http://www.google.com
        WebElement rejectCookies = driver.findElement(By.id("W0wltc"));
        rejectCookies.click();

        googleSearchInput = driver.findElement(By.name("q"));
        googleSearchInput.sendKeys(googleSearchQuery); // enter "Java" in the search field
        googleSearchInput.submit(); // send the form

        WebDriverWait waitForResults = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForResults.until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchResultsCssSelector))); // waiting for results visibility

        searchResults = driver.findElements(By.cssSelector(searchResultsCssSelector)); // assigning results to the searchResults list

        System.out.println("Numărul rezultatelor de pe pagină sunt: " + searchResults.size()); // printing the result in the console
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}