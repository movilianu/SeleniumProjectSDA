/**
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.Keys.ENTER;

public class testExerciseTemplate {
    private WebDriver driver;

    // Stabilim setupul pentru browserul pe care il vom folosi
    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("");
        driver = new ChromeDriver(options);  // ChromeDriver initialization
        driver.manage().window().maximize();
    }

    @Test
    public void TestSearchAirpodsOnEmag() throws InterruptedException {
        // Variabile definite
        final String variabilaDefinitaLaInceputFiindPreconizata = "Ceva Text care stim ca va aparea la finalul testarii";
        WebElement numeElement;

        // Deschidem browserul pe pagina unde incepem testarea
        driver.get("https://pui aici un site.ro/"); // open site-ul din link

        // Manipulam bara de cautare sa cautam produsul ales
        numeElement = driver.findElement(By.id("id-ul elementului"));
        numeElement.click();
        numeElement.sendKeys("Asa scriem ceva");
        numeElement.sendKeys(ENTER); // asa apasam pe Enter
        // SAU
        Actions actions = new Actions(driver);
        // asa apasam pe mai multe taste deodata
        actions.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys(Keys.DELETE).perform();

                   // Verificăm dacă butonul de cookies este prezent
        WebElement acceptCookie = null;
        try {
            acceptCookie = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.pad-sep-xs.pad-hrz-none.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block"));
            System.out.println("Cookie acceptat");
            acceptCookie.click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Butonul Cookie nu a fost găsit. Continuăm fără acceptarea cookie-urilor.");
        }

        // Gasim elemente in functie de xpath
        WebElement altWebElement = driver.findElement(By.classname(".tag.numeleclasei.alDoileaNumeAlClaseiDacaExista"));
        // Dam click pe un element
        altWebElement.click();

        // Schema pentru asteptarea incarcarii paginii/elementului
        WebDriverWait waitForResults = new WebDriverWait(driver, Duration.ofSeconds(numar_de_secunde));
        // waiting for results visibility
        waitForResults.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tagName[@atribut='valoarea atributului']")));
        Thread.sleep(numar_de_milisecunde); // 10000 milisecunde = 10 secunde
        // Crearea unui obiect de tip JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Executarea codului JavaScript pentru a efectua scroll până la elementul dorit
        js.executeScript("arguments[0].scrollIntoView();", numeleVariabileiCareGazduiesteElementulLaCareVremSaScrollam);

        // Gasim si definim varii valori din pagina
        String valoareaUnuiAtributAnimeAUnuiElement = driver.findElement(By.xpath("//tagName[@atribut='valoarea atributului']")).getAttribute("numele_unui_alt_atribut_al_elementului");
        String valoareaTextuluiUnuiElement = driver.findElement(By.xpath("//tagName[@atribut='valoarea atributului']")).getText();

        // Validam valorile stocate anterior
        assertEquals("String-ul pe care il asteptam", valoareaTextuluiUnuiElement);
        assertEquals(variabilaDefinitaLaInceputFiindPreconizata, valoareaUnuiAtributAnumeAUnuiElement);
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}

*/