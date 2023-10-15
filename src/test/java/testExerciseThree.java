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

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

/**
    In acest exercitiu vom:
    - intra pe istqb
    - vom accepta cookie-uri
    - vom accesa un articol
    - vom valida ca acel articol s-a deschis prin verificarea titlului
 */
public class testExerciseThree {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestIstqbArticle() {

        // Defineste variabilele pe care le folosesti
        WebElement acceptCookies, readMeButton, newsArticleTitle;

        // Deschidem browserul pe pagina unde incepem testarea
        driver.get("https://www.istqb.org/"); // open website

        // Definim wait-ul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Acceptam cookie-uri
        acceptCookies = driver.findElement(By.id("rcc-confirm-button"));
        acceptCookies.click();

        // Identificam articolul de interes si il accesam
        readMeButton = driver.findElement(By.xpath("//a[@href='/news/posts/istqb-releases-certified-tester-foundation-level-v40-ctfl']"));
        wait.until(ExpectedConditions.elementToBeClickable(readMeButton));
        readMeButton.click();

        // Cream o conditie de asteptare pentru a ne asigura ca suntem pe pagina corespunzatoare.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("https://www.istqb.org/certifications/certified-tester-foundation-level")));

        // Ne asiguram ca titlul articolului este cel corect.
        newsArticleTitle = driver.findElement(By.tagName("h1"));
        assertEquals(
                "ISTQB® releases Certified Tester Foundation Level v4.0 (CTFL)",
                newsArticleTitle.getText(),
                "Title differs from expected one");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}