package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Tests extends baseTest {

    String ProfileName;

    @Test(priority=1)
    public void login() throws InterruptedException
    {
        loginObject.loginWithUserFunction();
        System.out.println(loginObject.getHomePageDashboardUserName());
        Assert.assertEquals(loginObject.getHomePageDashboardUserName(),"@AndrewMichealK1");
    }

    @Test(priority=2)
    public void tweetByText()
    {
       homeObject.tweetTextFunction();
       System.out.println(homeObject.AssertTweetText());
       Assert.assertEquals(homeObject.AssertTweetText(),"Your Tweet was sent.");
    }


    @Test(priority=3)
    public void TweetByGIF()
    {
        homeObject.tweetGIFFunction();
        System.out.println(homeObject.AssertTweetText());
        Assert.assertEquals(homeObject.AssertTweetText(),"Your Tweet was sent.");
    }

    @Test(priority=4)
    public void tweetByPoll()
    {
        homeObject.tweetPollFunction();
        System.out.println(homeObject.AssertTweetText());
        Assert.assertEquals(homeObject.AssertTweetText(),"Your Tweet was sent.");
    }

    @Test(priority=5)
    public void tweetByPic() throws AWTException {

        homeObject.tweetPhotoFunction();
        System.out.println(homeObject.AssertTweetText());
        Assert.assertEquals(homeObject.AssertTweetText(),"Your Tweet was sent.");
    }
}
