package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;

public class Tests extends baseTest {

    @Test(priority=1)
    public void login() throws InterruptedException
    {
        loginObject.loginWithUserFunction();
    }

    @Test(priority=2)
    public void tweetByText()
    {
       homeObject.tweetTextFunction();
    }

    @Test(priority=3)
    public void TweetByGIF()
    {
        homeObject.tweetGIFFunction();
    }

    @Test(priority=4)
    public void tweetByPoll()
    {
        homeObject.tweetPollFunction();
    }

	@Test(priority=5)
	public void tweetByPic() throws AWTException {

         homeObject.tweetPhotoFunction();
	}
}
