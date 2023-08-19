import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.Keys.*;

public class testExerciseOne {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);  // ChromeDriver initialization
    }

    @Test
    public void TestSearchAirpodsOnEmag() throws InterruptedException {
        // Rezultatul pe care il vom valida
        final String expectedTitle = "Produse promovate"; // expected message after logging in with incorrect data

        // Defineste variabila si tipul ei pentru bara de cautare
        WebElement searchInput;

        // Deschidem browserul pe pagina unde incepem testarea
        driver.get("https://emag.ro/"); // open eMag

        // Manipulam bara de cautare sa cautam produsul ales
        searchInput = driver.findElement(By.id("searchboxTrigger"));
        searchInput.click();
        searchInput.sendKeys("Casti Apple Airpods Pro (2nd Generation) - 2022");
        searchInput.sendKeys(ENTER);

        // Identificam produsul si il accesam
        Thread.sleep(3000);
        WebElement castileNoastre = driver.findElement(By.xpath("//img[starts-with(@alt, 'Casti Apple Airpods Pro (2nd Generation) - 2022')]"));
        castileNoastre.click();
        // Metoda #1 de amanare a timpului pentru incarcarea valorii selectorului
             // Schema pentru asteptarea incarcarii paginii/elementului
        WebDriverWait waitForResults = new WebDriverWait(driver, Duration.ofSeconds(10));
            // waiting for results visibility
        waitForResults.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='js-section-title']")));

        // Metoda #2 de amanare a timpului pentru incarcarea valorii selectorului
        Thread.sleep(12000);

        // Gasim elementul din pagina care ne intereseaza
        WebElement currentPromotedProductsTitle = driver.findElement(By.xpath("//span[@class='js-section-title']"));

        // Metoda #3 de amanare a timpului pentru incarcarea valorii selectorului
            // Crearea unui obiect de tip JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
            // Executarea codului JavaScript pentru a efectua scroll până la elementul dorit
        js.executeScript("arguments[0].scrollIntoView();", currentPromotedProductsTitle);

        // Salvarea valorilor elementelor de interes
        String currentPromotedProductsTitleText = currentPromotedProductsTitle.getText();
        String newInputBoxValue = driver.findElement(By.xpath("//input[@id='searchboxTrigger']")).getAttribute("placeholder");

        // Validam valorile stocate anterior
        assertEquals("Începe o nouă căutare", newInputBoxValue);
        assertEquals(expectedTitle, currentPromotedProductsTitleText);

        // Afișăm valorile stocate anterior
        if (!newInputBoxValue.equals("Începe o nouă căutare")) {
            System.out.println("Eroare: Valorile stocate anterior nu corespund.");
            System.out.println("Valoarea așteptată pentru newInputBoxValue: Începe o nouă căutare");
            System.out.println("Valoarea actuală pentru newInputBoxValue: " + newInputBoxValue);
        } else {
            System.out.println("Valoarea stocată anterior pentru newInputBoxValue este corectă.");
        }

        if (!expectedTitle.equals(currentPromotedProductsTitle.getText())) {
            System.out.println("Eroare: Valorile stocate anterior nu corespund.");
            System.out.println("Valoarea așteptată pentru currentPromotedProductsTitleText: " + expectedTitle);
            System.out.println("Valoarea actuală pentru currentPromotedProductsTitleText: " + currentPromotedProductsTitle.getText());
        } else {
            System.out.println("Valoarea stocată anterior pentru currentPromotedProductsTitleText este corectă.");
        }
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}