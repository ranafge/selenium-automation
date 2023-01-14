package pages;

import com.org.baseClass.BaseClass;
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
    @FindBy(css = "[role=\"listbox\"]")
    List<WebElement> locations;
    @FindBy(css = "[tabindex=\"0\"]")
    WebElement locationHqUsa;
    @FindBy(xpath = "(//button)[4]")
    WebElement locationSearchButton;
    @FindBy(xpath = "(//div[@class=\"oxd-select-text-input\"])[2]")
    WebElement locationInputField;
    @FindBy(xpath = "(//div[@class=\"oxd-select-dropdown --positon-bottom\"]/div)[3]/span")
    WebElement hqcausa;
    @FindBy(xpath = "(//div[@class=\"oxd-select-dropdown --positon-bottom\"]/div)[4]/span")
    WebElement newYorkSaleOffice;
    @FindBy(xpath = "//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span")
    WebElement numberOfRecord;

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
        Thread.sleep(1000);
        hqcausa.click();
        Thread.sleep(4000);
        locationSearchButton.click();
        Thread.sleep(4000);
        super.scrollDown();
        Thread.sleep(3000);
        return new DirectoryPage();
    }


    // verify we are in directory page
    public boolean directoryTextVerify() {
        return directoryText.isDisplayed();
    }

    // verify we found number of record for search item  of HQ-CA-USA
    public boolean hqcaUsaRecordVerify() {
        boolean contains = numberOfRecord.getText().contains("(6) Records Found");
        System.out.println("Trying to find \"(6) Records Found\" ");
        System.out.println(numberOfRecord.getText());
        return contains;
    }

}
