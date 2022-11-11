package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePage{

    public loginPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    private By signInButton=By.xpath("//a[@href='/login']");
    private By userName=By.xpath("//input[@name='text']");
    private By next=By.xpath("(//div[@role='button']//div[@dir='auto'])[3]");
    private By password=By.name("password");
    private By loginButton=By.xpath("(//div[@role='button']//div[@dir='auto'])[3]");

    private By profileNameAccount= By.xpath("//div[@aria-label='Account menu'] //div[@dir='ltr']");

    public void navigateToSignInPage()
    {
        click(signInButton);
    }
    public void enterUserName(String data)
    {
        setText(userName,data);
    }

    public void clickNext()
    {
        click(next);
    }
    public void enterPassword(String data)
    {
        setText(password, data);
    }
    public void clickLogin()
    {
        click(loginButton);
    }


    public void loginWithUserFunction(){
       navigateToSignInPage();
       enterUserName("AndrewMichealK1");
       clickNext();
       enterPassword("P@ssw0rd");
       clickLogin();
    }

    public String getHomePageDashboardUserName(){
        waitElement(profileNameAccount);
        return    driver.findElement(profileNameAccount).getText();
    }
}
