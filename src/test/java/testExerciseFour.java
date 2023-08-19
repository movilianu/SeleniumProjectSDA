import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.openqa.selenium.Keys.*;

/**
    In acest exercitiu vom:
    - intra pe stackoverflow
    - Vom cauta pe site "Selenium question" prin search box
    - Vom valida cate raspunsuri ne sunt intoarse
 */
public class testExerciseFour {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestPrintStackOverflowPageTitleOnConsole() {
        driver.get("https://stackoverflow.com/"); // open https://stackoverflow.com/

        System.out.println(driver.getTitle()); // retrieve the page title and display it in the console
        // Search for any question regarding Selenium
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("Selenium Question" + ENTER);
        // Prima data cand rulezi testul da-i stop si bifeaza Captcha-ul
        // Acceptam cookie-urile
        WebElement acceptCookies = driver.findElement(By.xpath("/html/body/div[4]/div[1]/button[1]"));
        acceptCookies.click();
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'reCAPTCHA')]")));
//        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("label.rc-anchor-center-item.rc-anchor-checkbox-label"))).click();
        // Luam lista rezultatelor si verificam cate exista pe prima pagina
        List<WebElement> allResults = driver.findElements(By.className("s-link"));
        assertEquals(18, allResults.size());
        allResults.get(0).click(); // Asa dam click pe primul rezultat si putem testa mai departe la nevoie
    }

    @After
    public void tearDown() {
        driver.close(); // close browser
    }
}