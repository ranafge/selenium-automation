package pages;

import com.org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TimeOut;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement inputUsername;
    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;

    // create constructor
    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String password){
        inputUsername.isDisplayed();
        inputUsername.sendKeys(username);
        inputPassword.isDisplayed();
        inputPassword.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }




}
