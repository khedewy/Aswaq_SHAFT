package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;
import pages.WriteReviewPage;

import java.io.IOException;

public class WriteReviewTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    WriteReviewPage writeReviewPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    SHAFT.TestData.JSON registerData;
    SHAFT.TestData.JSON writeReviewData;
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
    public void searchForProduct(){
        searchPage = new SearchPage(driver);
        searchPage.searchForProducts("laptob");
    }

    @Test(priority = 3)
    public void writeReview() throws IOException, ParseException {
        writeReviewData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/reviewData.json");
        writeReviewPage.addReview(writeReviewData.getTestData("title"), writeReviewData.getTestData("body"));
        Assert.assertEquals(writeReviewPage.getAssertionMessage(),"Thank You !");
    }
}
