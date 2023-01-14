package pages;

import com.org.baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
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
    @FindBy(xpath = "(//button)[4]")
    WebElement locationSearchButton;

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

        for(WebElement e: locations) {
            System.out.println(e.getText());
            e.click();

        }
        Thread.sleep(10000);
        locationSearchButton.click();

        super.scrollDown();
        Thread.sleep(10000);







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
