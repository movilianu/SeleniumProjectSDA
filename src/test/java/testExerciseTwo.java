import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

/**
 * In acest test vom:
 * - intra pe site-ul royalcaribbean.com
 * - accepta cookie-urile si vom inchide pop-up-urile
 * - cauta croaziere ce pleaca din Amsterdam si traverseaza Transatlanticul
 * - verifica ca ni s-au intors rezultate
 */
public class testExerciseTwo {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestSearchCruise() throws InterruptedException {

        // Defineste variabila si tipul ei pentru bara de cautare
        WebElement cruisingTo;

        // Deschidem browserul pe pagina unde incepem testarea
        driver.get("https://www.royalcaribbean.com/"); // open website

        // Acceptam cookies si inchidem pop-up-uri
//Declare and initialise a fluent wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
//Specify the timout of the wait
        wait.withTimeout(Duration.ofSeconds(10));
//Specify polling time
        wait.pollingEvery(Duration.ofMillis(100));
//Specify what exceptions to ignore
        wait.ignoring(Exception.class);        // waiting for results visibility
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='notification-banner__close']")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='notification-banner__section-close']")).click();
        // Manipulam bara de cautare sa cautam produsul ales
        cruisingTo = driver.findElement(By.className("cruise-search-widget__selection"));
        Thread.sleep(2000);
        cruisingTo.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Transatlantic')]")));
        driver.findElement(By.xpath("//label[contains(text(),'Transatlantic')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Departing from')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Amsterdam, Netherlands')]")));
        driver.findElement(By.xpath("//label[contains(text(),'Amsterdam, Netherlands')]")).click();
        driver.findElement(By.id("rciCruiseSearchWidgetSubmitButton")).click();
        Thread.sleep(2000);
        assertEquals("Cruise Search Results", driver.findElement(By.xpath("//h1[contains(text(),'Cruise Search Results')]")).getText());
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}