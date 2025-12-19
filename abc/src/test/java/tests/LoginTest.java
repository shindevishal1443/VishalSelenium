package tests;

import base.BaseTest;
import factory.DriverFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.open("https://example.com/login");
        login.enterUsername("admin");
        login.enterPassword("admin123");
        login.clickLogin();

        HomePage home = new HomePage(DriverFactory.getDriver());
        System.out.println("Heading: " + home.getHeadingText());
    }
}
