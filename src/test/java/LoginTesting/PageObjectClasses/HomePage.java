package LoginTesting.PageObjectClasses;

import LoginTesting.BaseFiles.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //*********Constructor*********
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToOrangeHrmLive() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage goToLoginPage() {
        return new LoginPage(driver);
    }
}