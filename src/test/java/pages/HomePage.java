package pages;

import com.org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//span/h6[contains(., \"Dashboard\")]")
    WebElement dashboardVerifyText;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean dashboardText() {
        return dashboardVerifyText.isDisplayed();
    }

}
