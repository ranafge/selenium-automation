package pages;

import com.org.baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import utils.TimeOut;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
    // CLICK ON LOCATION MENTU
    @FindBy(xpath = "//label[contains(text(),'Location')]/following::div[3]")
    WebElement locationDropdownMenu;
    // ALL LOCATIONS FORM LOCATION MENTU

    @FindBy(className = "oxd-select-option")
    List<WebElement> locations;
    // ONE ELEMENT FORM LOCATION MENTU
    @FindBy(css = "//*[contains(text(), \"HQ - CA, USA\")]")
    WebElement locationHqUsa;
    //Click on search Button
    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button[contains(text(), \"Search\")]")
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
        Thread.sleep(2000);
        locationDropdownMenu.click();
        Thread.sleep(2000);
//
//        for(WebElement element: locations) {
//            if(Objects.equals(element.getText(), "HQ - CA, USA")){
//                element.click();
//            }
//        }
//
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for( int i =0; i < locations.size(); i++) {
            js.executeScript("arguments[0].click()", locations.get(i));
        }

        locationSearchButton.click();


        return new DirectoryPage();
    }

//    public

    public boolean directoryTextVerify() {
        return directoryText.isDisplayed();
    }


}
