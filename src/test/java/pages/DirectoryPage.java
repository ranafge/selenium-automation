package pages;

import com.org.baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DirectoryPage extends BaseClass {
    @FindBy(xpath = "//span/h6[contains(., \"Directory\")]")
    WebElement directoryText;
    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement inputUsername;
    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;
    @FindBy(xpath = "//li/a[contains(@href, \"Directory\")]")
    WebElement directoryLink;
    @FindBy(xpath = "//label[contains(text(), \"Location\")]/following::div[3]")
    WebElement locationUsa;
    @FindBy(xpath = "//label[contains(text(),'Location')]/following::div[3]")
    WebElement locationDropdownMenu;
    @FindBy(css ="[role=\"listbox\"]")
    List <WebElement> locations;
    @FindBy(css = "[tabindex=\"0\"]")
    WebElement locationHqUsa;

    public DirectoryPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public DirectoryPage login(String username, String password) throws InterruptedException {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
        directoryLink.click();
        locationDropdownMenu.click();
        Thread.sleep(10000);
        for(WebElement e: locations) {
            if(e.getText() == "HQ - CA, USA") {
                e.click();
                System.out.println(e.getText());
            }

        }
        Thread.sleep(4000);



        return new DirectoryPage();
    }

//    public

    public boolean directoryTextVerify() {
        return directoryText.isDisplayed();
    }

    public void directoryLocationVerify(){
//        return locationHqUsa.getText().contains("HQ - CA, USA");
        System.out.println(locationHqUsa.getText());
    }

}
