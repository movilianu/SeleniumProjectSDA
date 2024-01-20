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
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class testExerciseNine {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestLoginToOrangeHRMPage() {
        final String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"; // expected page URL after logging in

        WebElement usernameInput, passwordInput, loginButton;
        String currentUrl;

        driver.get("https://opensource-demo.orangehrmlive.com/"); // open https://opensource-demo.orangehrmlive.com/

        WebDriverWait waitForResults = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForResults.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Username']"))); // waiting for results visibility

        usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        loginButton = driver.findElement(By.xpath("//button[@type='submit']"));


        usernameInput.sendKeys("Admin"); // in the "Username" field enter "Admin"
        passwordInput.sendKeys("admin123"); // in the "Password" field enter "admin123"
        loginButton.click(); // click "Login" button

        currentUrl = driver.getCurrentUrl(); // assigning the URL of the page you are currently on to the currentUrl variable

        assertEquals(expectedUrl, currentUrl); // checking if the current page title is as expected
        Assertions.assertEquals(expectedUrl, currentUrl); // same as above
    }

//    @After
//    public void tearDown() {
//        driver.quit(); // close browser
//    }
}