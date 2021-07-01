package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void information_alert_test() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']")); ////button[.='Click for JS Alert']
        informationAlertButton.click();

        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfuly clicked an alert” text is displayed.
        // This is long way. NUK sugjertohet.
        // Me mire eshte WebElement resultText = drive.findElement((By.xpath("//p[.='You successfuly clicked an alert']"));


        String actualAlert = driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']")).getText();
        String expectedAlert = "You successfuly clicked an alert";
        Assert.assertEquals(actualAlert, expectedAlert);

    }
}
