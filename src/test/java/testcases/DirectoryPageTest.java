package testcases;

import com.org.baseClass.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DirectoryPage;
import pages.HomePage;
import pages.LoginPage;

public class DirectoryPageTest extends BaseClass {
    HomePage homePage;
    LoginPage loginPage;
    DirectoryPage directoryPage;

    public DirectoryPageTest(){
        super();

    }

    @BeforeMethod
    public void initialization() {
        setUp();
        directoryPage = new DirectoryPage();
    }

    @Test
    public void loginWithCredentials() throws InterruptedException {
        directoryPage = new DirectoryPage()
                .login(getUserName(), getPassword());
        Assert.assertTrue(directoryPage.directoryTextVerify());
        Assert.assertTrue(directoryPage.hqcaUsaRecordVerify());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
