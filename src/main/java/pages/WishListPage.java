package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishListPage {
    private final SHAFT.GUI.WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public WishListPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By product = By.xpath("//a[text()='Zebra Sarasa Ink Pen, 0.7 mm, Rollerball, Black']");
    private final By productAssertionMessage = By.xpath("//h3[text()='Zebra Sarasa Ink Pen, 0.7 mm, Rollerball, Black']");
    private final By addToWishlistButton = By.xpath("//button[@class='btn btn-default dropdown-toggle add-to-wishlist btn-white-bg']");
    private final By wishlistName = By.name("name");
    private final By submitAddingTOWishList = By.xpath("//button[@class='add_to_wishlist_submit btn-link']");
    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By wishlist = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[4]/a/span");
    private final By assertionMessage = By.xpath("//div[@class='wishlist-name']");

    public void navigateToProduct(){
        driver.element().click(product);
    }

    public String getProductChosenAssertionMessage(){
        return driver.element().getText(productAssertionMessage);
    }

    public void addToWishList(String listName){
        driver.element().click(addToWishlistButton);
        driver.element().type(wishlistName,listName);
        driver.element().click(submitAddingTOWishList);
    }

    public void moveToWishList(){
        driver.element().hover(dropDownList);
        driver.element().click(wishlist);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
