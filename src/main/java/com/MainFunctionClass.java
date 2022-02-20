package com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class MainFunctionClass {

    public static void main(String[] args) throws InterruptedException {
        //TestBase.firefoxLaunch();
        TestBase.chromeLaunch();
        TestBase.driver.manage().window().maximize();
        System.out.println("Browser opened");
        TestBase.openURL("http://automationpractice.com/index.php");
        System.out.println("Link opened");
        TestBase.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        UserClass user1 = new UserClass();
        UserClass user2 = new UserClass();

        //System.out.println(user1.registeredName + "  " + user1.password );
        //System.out.println(user2.registeredName + "  " + user2.password );

        user1.Registration();
        user2.Registration();
        user1.LoginAndOrder(user1.registeredName,user1.password);
        user1.logOut();
        System.out.println("user1 is logged out");
        Thread.sleep(2000);

        user2.LoginAndOrder(user2.registeredName,user2.password);
        user2.logOut();
        System.out.println("user2 is logged out");
        TestBase.closeBrowser();
        System.out.println("Browser closed");
    }

}
