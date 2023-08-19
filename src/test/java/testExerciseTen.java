import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class testExerciseTen {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();  // ChromeDriver initialization
    }

    @Test
    public void TestUnsuccessfulLoginToOrangeHRMPage() throws Exception {
        final String expectedMessage = "Invalid credentials"; // expected message after logging in with incorrect data

        WebElement usernameInput, passwordInput, loginButton;
        String currentMessage;

        driver.get("https://opensource-demo.orangehrmlive.com/"); // open https://opensource-demo.orangehrmlive.com

        WebDriverWait waitForResults = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForResults.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Username']"))); // waiting for results visibility

        passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameInput.sendKeys("WrongUsername"); // in the "Username" field enter "WrongUsername"
        passwordInput.sendKeys("WrongPassword"); // in the "Password" field enter "WrongPassword"
        loginButton.click(); // click "Login" button

        // assigning the text displayed in the spanMessage element to the currentMessage variable
        waitForResults.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']")));
        currentMessage = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']")).getText();

        assertEquals(expectedMessage, currentMessage); // checking if the current message is as expected
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }
}