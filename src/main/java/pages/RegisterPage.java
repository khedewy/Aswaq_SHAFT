package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final SHAFT.GUI.WebDriver driver;
    WebDriverWait wait;
    public RegisterPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("id_email");
    private final By passwordTxt = By.id("id_password1");
    private final By confirmPasswordTxt = By.id("id_password2");
    private final By registerButton = By.name("registration_submit");
    private final By assertionMessage = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/a/span");

    public void enterRegisterData(String email, String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().type(confirmPasswordTxt,password);
        driver.element().click(registerButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
