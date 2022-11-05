package testCases;

import Pages.homePage;
import Pages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class baseTest {


    WebDriver driver;
    String baseURL ="https://twitter.com/";
    loginPage loginObject;
    homePage homeObject;
    String title;

    @BeforeSuite
    public void setup() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        loginObject=new loginPage(driver);
        homeObject=new homePage(driver);
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }
//    @AfterSuite
//    public void exit()
//    {
//        driver.quit();
//    }
}

