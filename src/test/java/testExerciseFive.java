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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
    In acest exercitiu vom:
    - intra pe sameday.ro
    - valida numele paginii
    - verifica ca textul placeholder-ului din caseta de cautare sa fie "Introdu numărul AWB"
    - verifica ca textul butonului de cautare sa fie "Verifică AWB"
    - verifica valorile textelor din meniul principal
 */
public class testExerciseFive {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();  // ChromeDriver initialization
        driver.manage().window().maximize();
    }

    @Test
    public void TestTexteButoaneSameday() {

        String titlulPaginii, placeholderInputBox, textButonCautareAwb, textButonMeniuPrincipal;
        List<WebElement> butoaneMeniuPrincipal;

        // Deschidem browserul pe pagina unde incepem testarea
        driver.get("https://www.sameday.ro/"); // open website

        titlulPaginii = driver.getTitle();
        assertEquals("Sameday - Curierat rapid, national si international", titlulPaginii);

        // Salvam textele in variabile si verificam valorile lor.
        placeholderInputBox = driver.findElement(By.id("awbtracker_input")).getAttribute("placeholder");
        assertEquals("Introdu numărul AWB", placeholderInputBox);
        textButonCautareAwb = driver.findElement(By.xpath("//span[contains(text(), 'Verifică AWB')]")).getText();
        assertEquals("VERIFICĂ AWB", textButonCautareAwb);
        WebElement acceptCookie = null;
        try {
            acceptCookie = driver.findElement(By.id("wt-cli-accept-btn"));
            acceptCookie.click();
            System.out.println("Cookie acceptat");
        } catch (org.openqa.selenium.NoSuchElementException eroareMAximaSaMoaraJana) {
            System.out.println("Butonul Cookie nu a fost găsit. Continuăm fără acceptarea cookie-urilor.");
        }

        butoaneMeniuPrincipal = driver.findElements(By.xpath("//div[@class='menu-meniu-principal-container']/ul/li"));
        int s = butoaneMeniuPrincipal.size();
        String[] listaExpectedNumeButoane = {"", "Servicii", "Despre noi", "Cariere", "Contact", "LOGIN", "TRIMITE COLET\n" +
                "Trimite colete cu Sameday indiferent daca esti persoana fizica sau companie\n" +
                "new", "RO"};
        for(int i=0; i<s; i++){
            textButonMeniuPrincipal = butoaneMeniuPrincipal.get(i).getText();
//            System.out.println(butoaneMeniuPrincipal.get(i).getText());
            assertEquals(listaExpectedNumeButoane[i],textButonMeniuPrincipal);
        }
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}