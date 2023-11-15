package LoginTesting.PageObjectClasses;

import LoginTesting.BaseFiles.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class LoginPage extends BasePage {
    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    //*********Web Elements*********
    By usernameBy = By.xpath("//input[@placeholder='Username']");
    By passwordBy = By.xpath("//input[@placeholder='Password']");
    By loginButtonBy = By.xpath("//button[@type='submit']");
    By errorMessageBy = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']");
    By searchByFirstNameBy = By.xpath("//input[@placeholder='Type for hints...']");
    By tableOfContents = By.cssSelector(".oxd-table-body");
    By closeDeletionConfirmation = By.id("oxd-toaster_1");
    By noRecordsFound = By.xpath("//p[contains(text(),'No Records Found')]");

    // Buttons
    By pimButtonBy = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");

    By addButtonBy = By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon");
    By saveUserandSearchButtonBy = By.xpath("//button[@type='submit']");
    By confirmDeletion = By.cssSelector(".oxd-icon.bi-trash.oxd-button-icon");
    By trashButton = By.cssSelector(".oxd-icon.bi-trash");

    // Form inputs
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By middleName = By.name("middleName");
    By employeeId = By.cssSelector(".oxd-input.oxd-input--active");

    //*********Page Methods*********
    public LoginPage loginToOrangeHrmLive(String username, String password) {
        //Enter Username(Email)
        writeText(usernameBy, username);
        //Enter Password
        writeText(passwordBy, password);
        //Click Login Button
        click(loginButtonBy);
        return this;
    }

    //Verify Error Login Status
    public LoginPage verifyErrorLoginStatus(String expectedText) {
        assertEquals(errorMessageBy, expectedText);
        return this;
    }

    //Verify Login Status
    public LoginPage verifySuccessfulLoginStatus(String expectedText) {
        assertEquals(pimButtonBy, expectedText);
        return this;
    }

    public LoginPage addAUser(String FirstName, String MiddleName, String LastName, Integer EmployeeId) {
        //Click PIM button
        click(pimButtonBy);
        //Click +Add button
        click(addButtonBy);
        //Wait until the last form input is loaded
        waitVisibility(employeeId);
        //Fill out the form
        writeText(firstName, FirstName);
        writeText(middleName, MiddleName);
        writeText(lastName, LastName);
        writeText(employeeId, EmployeeId.toString());
        //Save the user to the datatable
        click(saveUserandSearchButtonBy);
        return this;
    }

    public LoginPage searchForUser(String searchFirstName) {
        //Click PIM Button
        click(pimButtonBy);
        //Search for added employee
        click(searchByFirstNameBy);
        writeText(searchByFirstNameBy, searchFirstName);
        //Press the search button
        click(saveUserandSearchButtonBy);
        return this;
    }

    public LoginPage assertUserExists(String addedUserMiddleName, String addedLastName) {
        // Turn the contents of the table to a string
        waitVisibility(tableOfContents);
        String textInRecordTable = driver.findElement(tableOfContents).getText();
        // Search the aforementioned string for our user's middle name
        assert textInRecordTable.contains(addedUserMiddleName);
        assert textInRecordTable.contains(addedLastName);
        return this;
    }

    public LoginPage deleteCreatedUser () {
        List<WebElement> deleteEmployeeEntryButtonsBy = driver.findElements(By.cssSelector((".oxd-icon.bi-trash")));
        // Find all delete buttons on the page
        for (WebElement deleteButton : deleteEmployeeEntryButtonsBy) {
            waitVisibility(saveUserandSearchButtonBy);
            wait.until(ExpectedConditions.elementToBeClickable(trashButton)); // Wait for the element to be visible
            deleteButton.click();
            waitVisibility(confirmDeletion);
            click(confirmDeletion);
            click(closeDeletionConfirmation);
        }
        waitVisibility(closeDeletionConfirmation);
        return this;
    }
}