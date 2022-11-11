package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class homePage extends basePage{

    public homePage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    private By tweetBox=By.xpath("//div[@role='textbox']");
    private By tweetButton=By.xpath("//div[@data-testid='tweetButtonInline']");
    private By addPic=By.xpath("//div[@aria-label='Add photos or video']");
    private By addGIF=By.xpath("//div[@data-testid='gifSearchButton']");
    private By searchGIF=By.xpath("//input[@data-testid='gifSearchSearchInput']");
    private By selectedGIF=By.xpath("//div[@aria-label='Happy Cheering GIF by bluesbear']");
    private By addPOLL=By.xpath("//div[@data-testid='createPollButton']");
    private By addChoice1=By.name("Choice1");
    private By addChoice2=By.name("Choice2");

    private By successfulMessage=By.xpath("//div[@role='alert'] //div[@dir='auto']");



    public void TweetSendText(String data)
    {
        setText(tweetBox, data);
    }
    public void ClickPostTweet()
    {
        waitElement(tweetButton);
        click(tweetButton);
    }


    public void ClickAddPic()
    {
        waitElement(addPic);
        click(addPic);
    }

    public void ClickAddGIF()
    {
        waitElement(addGIF);
        click(addGIF);
    }
    public void searchForGIF(String data)
    {
        setText(searchGIF, data);
    }
    public void selectGIF()
    {
        waitElement(selectedGIF);
        click(selectedGIF);
    }
    public void ClickAddPoll()
    {
        click(addPOLL);
    }
    public void AddChoice1(String data)
    {
        setText(addChoice1, data);
    }
    public void AddChoice2(String data)
    {
        setText(addChoice2, data);
    }

    public void tweetTextFunction(){
        TweetSendText("welcome All");
        ClickPostTweet();
    }

    public void tweetGIFFunction(){

        waitElement(tweetBox);
        ClickAddGIF();
        searchForGIF("happy");
        waitElement(selectedGIF);
        selectGIF();
        waitElement(tweetButton);
        ClickPostTweet();
    }

    public void tweetPollFunction(){
        waitElement(tweetButton);
        TweetSendText("poll");
        ClickAddPoll();
        AddChoice1("123456");
        AddChoice2("78976");
        waitElement(tweetButton);
        ClickPostTweet();
    }

    public void tweetPhotoFunction() throws AWTException {
        String imgName="bayern.jpg";
        String imgPath=System.getProperty("user.dir")+"\\Uploads\\"+imgName;
        ClickAddPic();
        uploadImage(imgPath,addPic);
        scrollDown();
        ClickPostTweet();
    }

    public String AssertTweetText(){
        waitElement(successfulMessage);
        return    driver.findElement(successfulMessage).getText();
    }
}
