package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private SHAFT.GUI.WebDriver driver;
    public SearchPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By searchBox = By.id("id_q");
    private final By searchButton = By.id("submit_search");
    private final By assertionMessage = By.xpath("//b");

    public void searchForProducts(String product){
        driver.element().type(searchBox,product);
        driver.element().click(searchButton);
    }

    public String getAssertionMessage(){
       return driver.element().getText(assertionMessage);
    }
}
