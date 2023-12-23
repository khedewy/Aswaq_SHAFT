package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HomePage {
    private final SHAFT.GUI.WebDriver driver;
    Actions actions;
    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By registerIcon = By.id("login_link");
    private final By registerButton = By.xpath("//a[@class='btn btn-default btn-blue-bg btn-font-fff-bold']");
    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By logoutButton = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[6]/a/i");

    public RegisterPage navigateToRegisterPage() throws InterruptedException {
        driver.element().click(registerIcon);
        driver.element().click(registerButton);
        return new RegisterPage(driver);
    }

    public void logout(){
        driver.element().hover(dropDownList);
        driver.element().click(logoutButton);
    }

    public LoginPage navigateToLoginPage(){
        driver.element().click(registerIcon);
        return new LoginPage(driver);
    }
}
