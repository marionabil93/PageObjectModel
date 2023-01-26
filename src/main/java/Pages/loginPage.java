package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePage{

    public loginPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    private By userName=By.xpath("//*[@id='email']");
    private By password=By.xpath("//*[@id='password']");
    private By loginButton=By.xpath("//*[@class='w-75 about-section']//*[@type='submit']");

    private By profileNameAccount= By.xpath("//*[@class='dropdown action-dropdown user-actions']//*[@class='action-icons-text']");

    public void enterUserName(String data)
    {
        setText(userName,data);
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
        enterUserName("test22@gmail.com");
        enterPassword("123456789");
        clickLogin();
    }

    public String getHomePageDashboardUserName(){
        waitElement(profileNameAccount);
        return    driver.findElement(profileNameAccount).getText();
    }
}
