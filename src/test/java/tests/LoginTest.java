package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SHAFT.TestData.JSON registerData;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException {
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        registerPage = new RegisterPage(driver);
        registerPage.enterRegisterData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("password"));
        Assert.assertEquals(registerPage.getAssertionMessage(),registerData.getTestData("email")+currentTime+"@gmail.com");
    }

    @Test(priority = 2)
    public void logout(){
        homePage = new HomePage(driver);
        homePage.logout();
    }

    @Test(priority = 3)
    public void navigateToLoginPageAndEnterLoginData() throws IOException, ParseException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToLoginPage();
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        loginPage.enterLoginData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("password"));
        Assert.assertEquals(loginPage.getAssertionMessage(),registerData.getTestData("email")+currentTime+"@gmail.com");
    }

}
