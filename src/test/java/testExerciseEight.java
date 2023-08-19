import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

/**
 * In acest test vom:
 * - accesa google
 * - refuza cookie-uri
 * - cauta pe google prin input box "Java"
 * - afisa in consola numarul de rezultate de pe pagina
 */
public class testExerciseEight {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintNumberOfResultsOnFirstPageWhenSearchingForJava() throws InterruptedException {
        // Define variables
        final String googleSearchQuery = "Software Development Academy";
        final String sdaUrl = "sdacademy.ro/";
        final String searchResultCssSelector = ".CCgQ5.vCa9Yd.QfkTvb.N8QANc.MUxGbd.v0nnCb>span";

        WebElement googleSearchInput;
        List<WebElement> searchResults;

        // Access google and reject cookies
        driver.get("http://www.google.com"); // open http://www.google.com
        WebElement rejectCookies = driver.findElement(By.id("W0wltc"));
        rejectCookies.click();

        // Searching for our input in google
        googleSearchInput = driver.findElement(By.name("q"));
        googleSearchInput.sendKeys(googleSearchQuery); // enter "Java" in the search field
        googleSearchInput.submit(); // send the form

        // Waiting for the first link then checking if it contains the "Software Development Academy" string.
        // Access the link
        WebDriverWait waitForResults = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForResults.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(searchResultCssSelector))); // waiting for results visibility

        // Access the link
        WebElement firstLink = driver.findElement(By.cssSelector(searchResultCssSelector));
        firstLink.click();

        // Check the page url and ensure it contains the academy's link
        String firstLinkUrl = driver.getCurrentUrl();
        assertTrue(firstLinkUrl.contains(sdaUrl));
        // Alta metoda care intoarce si text pentru asertia anterioara. Redundanta considerand ca testul va pica la linia 61
        if (!firstLinkUrl.contains(sdaUrl)) {
            System.out.println("Eroare: Valoarea stocată anterior nu corespunde.");
            System.out.println("Valoarea așteptată pentru pagină este: " + sdaUrl);
            System.out.println("Valoarea actuală pentru firstLinkUrl: " + firstLinkUrl);

        } else {
            System.out.println("Valoarea stocată anterior pentru sdaUrl este corectă.");
        }
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}