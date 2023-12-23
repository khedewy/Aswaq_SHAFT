package tests;


import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class EditProfileTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    EditProfilePage editProfilePage;
    SHAFT.TestData.JSON registerData;
    SHAFT.TestData.JSON editProfileData;
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
    public void navigateToProfilePage(){
        editProfilePage = new EditProfilePage(driver);
        editProfilePage.navigateToProfilePage();
    }

    @Test(priority = 3)
    public void editProfileInf() throws IOException, ParseException {
        editProfileData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/editProfileData.json");
        editProfilePage = new EditProfilePage(driver);
        editProfilePage.editProfile(editProfileData.getTestData("firstName"),
                editProfileData.getTestData("lastName"),editProfileData.getTestData("gender"),
                editProfileData.getTestData("phone"), editProfileData.getTestData("idNumber"),
                editProfileData.getTestData("currency"));
        Assert.assertEquals(editProfilePage.getAssertionMessage(),"mahmoud khedewy");
    }
}
