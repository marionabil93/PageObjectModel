package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class basePage {
    protected WebDriver driver;
    public basePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    private List<WebElement> findItem(By locator) {
        return driver.findElements(locator);
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
    protected void selectItem(By locator , int index) {
        Select select=new Select(find(locator));
        select.selectByIndex(index);
    }



    public void waitElement(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementLoadingPage(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

        public void uploadImage(String path) throws AWTException {
            StringSelection strSelection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
            Robot robot = new Robot();
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(3000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);

    }

    public void scrollDown()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollDownToElement(By locator)
    {
        WebElement element = find(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickButton(By locator){
        WebElement element = find(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getTitle()
    {
        return driver.getTitle();
    }


    public void mouseHover(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(find(locator)).moveToElement(find(locator)).click().build().perform();
    }

    public void switchFrame(By locator){
        driver.switchTo().frame(find(locator));
    }
}