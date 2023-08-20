package LoginTesting;

import org.junit.Test;
import LoginTesting.PageObjectClasses.HomePage;
import LoginTesting.BaseFiles.*;
import org.junit.jupiter.api.Order;

public class testExerciseEleven extends BaseTest {
    @Test
    @Order(1)
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        //*************PAGE METHODS********************
        homePage.goToOrangeHrmLive()
                .goToLoginPage()
                .loginToOrangeHrmLive("onur@swtestacademy.com", "11223344")
                .verifyErrorLoginStatus(("Invalid credentials"));
    }

    @Test
    @Order(2)
    public void validLoginTest_ValidUserAndPassword() {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        //*************PAGE METHODS********************
        homePage.goToOrangeHrmLive()
                .goToLoginPage()
                .loginToOrangeHrmLive("Admin", "admin123")
                .verifySuccessfulLoginStatus("PIM")
                .addAUser("Keanu", "Charles", "Reeves", 666)
                .searchForUser("Keanu")
                .assertUserExists("Charles", "Reeves")
                .deleteCreatedUser();
    }
}
