package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddNewAddress {
    private SHAFT.GUI.WebDriver driver;
    public AddNewAddress(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By dropDownList = By.xpath("//i[@class='fa fa-caret-down']");
    private final By address = By.xpath("//*[@id=\"info-topBar\"]/div/div/div[2]/div/div/li[4]/ul/li[5]/a/span");
    private final By addNewAddressButton = By.xpath("//a[@class='btn btn-default btn-red-bg btn-font-fff-bold']");
    private final By fullNameTxt = By.id("id_full_name");
    private final By countryTxt = By.id("select2-chosen-1");
    private final By countryChosen = By.xpath("//*[@id=\"select2-results-1\"]/li[2]");
    private final By cityTxt = By.id("select2-chosen-2");
    private final By cityChosen = By.xpath("//*[@id=\"select2-results-2\"]/li[6]");
    private final By phoneNumberTxt = By.id("id_phone_number");
    private final By F_LineAddressTxt = By.id("id_line1");
    private final By noteTxt = By.id("id_notes");
    private final By saveButton = By.xpath("//button[@class='btn btn-default btn-red-bg btn-font-fff-bold no-margin']");
    private final By assertionMessage = By.xpath("//div[text()='My Address']");

    public void navigateToAddressPage(){
        driver.element().hover(dropDownList);
        driver.element().click(address);
    }

    public void enterAddressData(String fullName,String phone,String F_line,String note){
        driver.element().click(addNewAddressButton);
        driver.element().type(fullNameTxt,fullName);
        driver.element().click(countryTxt);
        driver.element().click(countryChosen);
        driver.element().click(cityTxt);
        driver.element().click(cityChosen);
        driver.element().type(phoneNumberTxt,phone);
        driver.element().type(F_LineAddressTxt,F_line);
        driver.element().type(noteTxt,note);
        driver.element().click(saveButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }


}
