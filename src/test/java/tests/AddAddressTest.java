package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewAddress;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class AddAddressTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    AddNewAddress addNewAddress;
    String currentTime = String.valueOf(System.currentTimeMillis());
    SHAFT.TestData.JSON registerData;
    SHAFT.TestData.JSON addAddressData;
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
    public void navigateToAddressPage(){
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.navigateToAddressPage();
    }

    @Test(priority = 3)
    public void addNewAddress() throws IOException, ParseException {
        addAddressData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/addAddressData.json");
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.enterAddressData(addAddressData.getTestData("fullName"), registerData.getTestData("phone")
                , addAddressData.getTestData("firstLine"),addAddressData.getTestData("note"));
        Assert.assertEquals(addNewAddress.getAssertionMessage(),"My Address");
    }
}
