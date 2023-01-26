package testCases;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class Tests extends baseTest {
    ExtentTest test;
    @Test(priority=1)
    public void login(Method method) throws InterruptedException
    {
        loginObject.loginWithUserFunction();
        System.out.println(loginObject.getHomePageDashboardUserName());
        Assert.assertTrue(loginObject.getHomePageDashboardUserName().contains("test"));
        //test=Extent.createTest("Login");
        String descriptiveTestNameTC1 = method.getName();
        System.out.println(descriptiveTestNameTC1);
        test = Extent.createTest(descriptiveTestNameTC1);
        test.log(Status.PASS,descriptiveTestNameTC1);
    }

    @Test(priority=2)
    public void addProduct(Method method) throws InterruptedException, AWTException {
        homeObject.clickOnAddProduct();
        homeObject.assertCheckBoxIsSelected();
        homeObject.stepTabOne();
        homeObject.stepTabTwo();
        homeObject.uploadImageFunction();
        homeObject.stepTabThree();
        Assert.assertEquals(homeObject.AssertText(),"product added successfully");
        String descriptiveTestNameTC2 = method.getName();
        System.out.println(descriptiveTestNameTC2);
        test = Extent.createTest(descriptiveTestNameTC2);
        test.log(Status.PASS,descriptiveTestNameTC2);
    }
}
