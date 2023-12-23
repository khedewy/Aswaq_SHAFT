package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;
    WebDriverWait wait;
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.id("id_login-username");
    private final By passwordTxt = By.id("id_login-password");
    private final By loginButton = By.name("login_submit");
    private final By assertionMessage = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/a/span");

    public void enterLoginData(String email, String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(loginButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
