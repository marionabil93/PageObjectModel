package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class basePage {
    protected WebDriver driver;
    public basePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected void setText(By locator , String text) {
        //waitElement(locator);
//        find(locator).clear();
        find(locator).sendKeys(text);
    }
    protected  void click(By locator){
        waitElement(locator);
        find(locator).click();
    }
    protected void selectData(By locator , int index) {
        Select select=new Select(find(locator));
        select.selectByIndex(index);
    }
    public void waitElement(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void uploadImage(String path , By locator) throws AWTException {
        StringSelection strSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
        waitElement(locator);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
     //To Click on the "Open" button to upload files
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void scrollDown()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollUp()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)","");
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
 }