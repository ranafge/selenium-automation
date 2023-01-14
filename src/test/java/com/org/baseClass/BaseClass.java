package com.org.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.TimeOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Properties;
import static utils.TimeOut.PAGE_WAIT_TIME;


public class BaseClass {
    protected static WebDriver driver;
    private Properties properties;

    // constructor

    public BaseClass() {
        try{
            properties = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void setUp() {
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_WAIT_TIME));
    }

    public String getUserName() {
        return properties.getProperty("username");
    }
    public String getPassword() {
        return properties.getProperty("password");
    }

    public void  scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }








}