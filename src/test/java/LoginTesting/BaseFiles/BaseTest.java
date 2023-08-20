package LoginTesting.BaseFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup() {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}