package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class UpdateWishlistTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    WishListPage wishListPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    UpdateWishListPage updateWishListPage;
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
    @Test(priority = 5)
    public void removeProductFromWishlist(){
        updateWishListPage = new UpdateWishListPage(driver);
        updateWishListPage.removeProduct();
        Assert.assertEquals(updateWishListPage.getRemovingProductAssertionMessage(),"Your Wish List Is Empty.");
    }

    @Test(priority = 6)
    public void changeListName(){
        updateWishListPage = new UpdateWishListPage(driver);
        updateWishListPage.changeListName("khedewy");
        Assert.assertEquals(updateWishListPage.getChangeListNameAssertion(),"khedewy");
    }

    @Test(priority = 7)
    public void deleteWishlist(){
        updateWishListPage = new UpdateWishListPage(driver);
        updateWishListPage.deleteList();
        Assert.assertEquals(updateWishListPage.getDeleteListAssertionMessage(),"You Don'T Have Any Wish Lists Yet.");
    }
}
