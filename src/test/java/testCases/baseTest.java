package testCases;

import Pages.addProduct;
import Pages.loginPage;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class baseTest {


    WebDriver driver;

    String baseURL ="https://staging.mazaady.com/login";
    loginPage loginObject;
    addProduct homeObject;
    ExtentReports Extent;



    @BeforeSuite
    public void setup() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        loginObject=new loginPage(driver);
        homeObject=new addProduct(driver);
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Extent = new ExtentReports();
        ExtentSparkReporter Report = new ExtentSparkReporter("D:\\Report.html");
        Extent.attachReporter(Report);
        Extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
        Extent.createTest("login");
        Extent.createTest("addProduct");
    }
   @AfterSuite
    public void exit()
    {
        Extent.flush();
        driver.quit();
    }
}

