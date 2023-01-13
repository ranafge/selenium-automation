package testcases;
import com.org.baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    DirectoryPage directoryPage;
    public  LoginTest(){
        super();
    }

    @BeforeMethod
    public void initialization() {
        setUp();
        loginPage = new LoginPage();
    }

    @Test
    public void loginWithCredentials() {
        homePage = new LoginPage()
                .login(getUserName(), getPassword());
        Assert.assertTrue(homePage.dashboardText());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
