package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.File;

public class addProduct extends basePage{

    public addProduct(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    private By profile=By.xpath("//*[@class='dropdown action-dropdown user-actions']//*[@class='action-icons-text']");
    private By addProductButton=By.xpath("//*[@dusk='header-dashboard']//*[@href='https://staging.mazaady.com/add-product']");

    public By singleProductCheckBox=By.xpath("//label[@for='opt-single_product']");
    private By stepOneBtn=By.xpath("//*[@id='step-1']//*[@class='btn btn-buy continue']");

    //StepTwo
    private By auctionNameField=By.xpath("//input[@name='title']");
    private By mainCategoryField=By.id("vs3__combobox");
    private By itemFromMainCategory=By.id("vs3__option-0");
    private By subCategoryField=By.id("vs4__combobox");
    private By itemFromSubCategory=By.id("vs4__option-0");
    private By quantityField=By.xpath("//*[@name='quantity']");
    private By countryField=By.id("vs5__combobox");
    private By itemFromCountryField=By.id("vs5__option-62");
    private By regionField=By.id("vs6__combobox");

    private By itemFromRegionField=By.id("vs6__option-0");
    private By cityField=By.id("vs7__combobox");
    private By itemFromCityField=By.id("vs7__option-0");
    private By productAddressField=By.xpath("//input[@name='title']");
    private By frame=By.id("tinymce_description_ifr");
    private By auctionDetailsField=By.xpath("//*[@data-id='tinymce_description']");
    private By addImageButton=By.xpath("//*[@class='image-container position-relative text-center']//label[@for='main_image']");
    private By stepTwoBtn=By.xpath("//*[@id='step-2']//*[@class='btn btn-buy continue']");

    //StepThree
    private By sellingTypeField=By.xpath("//select[@name='selling_type']");
    private By  buyNowValueField=By.xpath("//input[@name='value']");
    private By  startingBidValueField=By.xpath("//input[@name='starting_bid']");
    private By  estimatedValueField =By.xpath("//input[@name='estimated_value']");


    private By  bidIncrementValueField =By.xpath("//input[@name='bid_increase']");
    private By  dateField =By.id("vue-button-to-open-date");
    private By  CalendarField =By.id("mddtp-picker__date");

    private By  selectedDay =By.xpath("//*[@id='mddtp-date__current']//span[@class='mddtp-picker__cell'][5]");
    private By  OkButton =By.id("mddtp-date__ok");

    private By  timeField =By.id("vue-button-to-open-time");
    private By  timePickerField =By.id("mddtp-picker__time");
    private By  OkTimeButton =By.id("mddtp-time__ok");
    private By  audioCheckBox =By.xpath("//input[@value='audio']");

    private By stepThreeBtn=By.xpath("//*[@id='step-3']//*[@class='btn btn-buy continue']");

    private By addButtonInStepFour=By.xpath("//*[@id='step-4']//*[@type='submit']");
    private By productAddedTitle=By.xpath("//div[@role='dialog']//*[@class='swal-text']");


    public void clickOnAddProduct(){
        mouseHover(profile);
        click(addProductButton);
    }

    public void stepTabOne(){
        click(stepOneBtn);
    }

    public void stepTabTwo() throws InterruptedException {
        setText(auctionNameField,"Ibram Makram");
        click(mainCategoryField);
        click(itemFromMainCategory);
        click(subCategoryField);
        click(itemFromSubCategory);
        scrollDown();
        setText(quantityField, "1");
        waitElement(countryField);
        scrollDownToElement(countryField);
        click(countryField);
        click(itemFromCountryField);
        click(regionField);
        click(itemFromRegionField);
        Thread.sleep(4000);
        click(cityField);
        click(itemFromCityField);
        scrollDown();
        switchFrame(frame);
        setText(auctionDetailsField,"iam ibram");
        driver.switchTo().parentFrame();
    }

    public void uploadImageFunction() throws AWTException, InterruptedException {
        String imgName="bayern.jpg";
        String imgPath=System.getProperty("user.dir")+"\\Uploads\\"+imgName;
        scrollDown();
        clickButton(addImageButton);
        uploadImage(imgPath);
        click(stepTwoBtn);
    }

    public void stepTabThree(){
        waitElement(sellingTypeField);
        selectItem(sellingTypeField,1);
        setText(buyNowValueField,"3");
        setText(startingBidValueField,"2");
        setText(bidIncrementValueField,"2");
        setText(estimatedValueField,"2");
        scrollDown();
        click(dateField);
        waitElement(CalendarField);
        click(selectedDay);
        waitElement(OkButton);
        click(OkButton);
        click(timeField);
        waitElement(timePickerField);
        waitElement(OkTimeButton);
        click(OkTimeButton);
        scrollDown();
        clickButton(audioCheckBox);
        click(stepThreeBtn);
        click(addButtonInStepFour);
    }

    public boolean assertCheckBoxIsSelected(){
        waitElement(singleProductCheckBox);
        return    driver.findElement(singleProductCheckBox).isSelected();
    }

    public String AssertText(){
        waitElement(productAddedTitle);
        return    driver.findElement(productAddedTitle).getText();
    }
}
