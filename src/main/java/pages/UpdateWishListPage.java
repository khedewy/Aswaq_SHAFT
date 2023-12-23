package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateWishListPage {
    private final SHAFT.GUI.WebDriver driver;
    WebDriverWait wait;
    public UpdateWishListPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By removeProductButton = By.xpath("//button[@class='wishlist-option remove-btn-wishlist']");
    private final By removingProductAssertion = By.xpath("//div[text()='Your wish list is empty.']");
    private final By editWishListButton = By.id("edit-wishlist");
    private final By changeListName = By.name("name");
    private final By doneButton = By.xpath("//button[@class='btn btn-default btn-red-bg btn-font-fff-bold']");
    private final By changeListNameAssertion = By.xpath("//div[@class='wishlist-name']");
    private final By deleteListButton = By.id("remove-wishlist");
    private final By confirmDelete = By.xpath("//button[text()='Delete']");
    private final By deleteListAssertion = By.xpath("//*[@id=\"default\"]/div[1]/div[2]/div/div/div[2]/div/div/div/div[1]");


    public void removeProduct(){
        driver.element().click(removeProductButton);
    }

    public String getRemovingProductAssertionMessage(){
        return driver.element().getText(removingProductAssertion);
    }

    public void changeListName(String name){
        driver.element().click(editWishListButton);
        driver.element().type(changeListName,name);
        driver.element().click(doneButton);
    }
    public String getChangeListNameAssertion(){

        return driver.element().getText(changeListNameAssertion);
    }

    public void deleteList(){
        driver.element().click(deleteListButton);
        driver.element().click(confirmDelete);
    }

    public String getDeleteListAssertionMessage(){
        return driver.element().getText(deleteListAssertion);
    }
}
