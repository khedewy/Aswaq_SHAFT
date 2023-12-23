package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;
import pages.WishListPage;

import java.io.IOException;

public class WishListTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    WishListPage wishListPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    SHAFT.TestData.JSON registerData;

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
    public void searchForProducts(){
        searchPage = new SearchPage(driver);
        searchPage.searchForProducts("pens");
        Assert.assertEquals(searchPage.getAssertionMessage(),"pens");
    }
    @Test(priority = 3)
    public void navigateToProduct(){
        wishListPage = new WishListPage(driver);
        wishListPage.navigateToProduct();
        Assert.assertEquals(wishListPage.getProductChosenAssertionMessage(),"Zebra Sarasa Ink Pen, 0.7 mm, Rollerball, Black");
        wishListPage.addToWishList("mahmoud");
    }

    @Test(priority = 4)
    public void moveToWishList(){
        wishListPage = new WishListPage(driver);
        wishListPage.moveToWishList();
        Assert.assertEquals(wishListPage.getAssertionMessage(),"mahmoud");
    }
}

