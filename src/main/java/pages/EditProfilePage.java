package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfilePage {
    private SHAFT.GUI.WebDriver driver;
    Actions actions;
    Select select;
    WebDriverWait wait;
    public EditProfilePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By profile = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[2]/a/span");
    private final By editProfile = By.xpath("//a[text()='Edit Info']");
    private final By firstNameTxt = By.id("id_first_name");
    private final By lastNameTxt = By.id("id_last_name");
    private final By genderList = By.id("id_gender");
    private final By MobileNumber = By.id("id_phone_number");
    private final By idNumberTxt = By.id("id_id_number");
    private final By currencyList = By.id("id_preferred_currency");
    private final By saveButton = By.xpath("//button[@class='btn btn-block btn-red-bg btn-font-fff-bold']");
    private final By assertionMessage = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/a/span");


    public void navigateToProfilePage(){
       driver.element().hover(dropDownList);
        driver.element().click(profile);
    }

    public void editProfile(String firstName,String lastName,String gender,
                            String Mobile, String idNumber,String currency){
        driver.element().click(editProfile);
        driver.element().type(firstNameTxt,firstName);
        driver.element().type(lastNameTxt,lastName);
        driver.element().select(genderList,gender);
        driver.element().type(MobileNumber,Mobile);
        driver.element().type(idNumberTxt,idNumber);
        driver.element().select(currencyList,currency);
        driver.element().click(saveButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }


}
