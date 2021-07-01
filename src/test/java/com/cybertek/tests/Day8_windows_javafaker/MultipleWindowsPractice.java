package com.cybertek.tests.Day8_windows_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 *TC-6 : Window Handle practice
 * 1. Create new test and make set ups
 * 2. Go to : https://www.amazon.com/
 * 3. Copy paste the lines from below into your class
 * 4. Create a logic to switch to the tab where Etsy.com is open
 * 5. Assert: Title contains “Etsy”
 * Lines to be pasted:
 * ((JavascriptExecutor) driver).executeScript("window.open('http://google.com/%27,%27_blank%27);%22);
 * ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com/%27,%27_blank%27);%22);
 * ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com/%27,%27_blank%27);%22);
 * These lines will simple open new tabs using something called JavaScriptExecut
 * and get those pages. We will learn JavaScriptExecutor later as well.
 */
public class MultipleWindowsPractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void multiple_windows_test(){
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        for(String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("Title ine current page: " + driver.getTitle());

            if(driver.getTitle().contains("Etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }
    }


}
