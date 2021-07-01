package com.cybertek.tests.Group12.Assignemnt_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreManagerTesting1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("storemanager73");
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
        login.click();
        String expectedResult = "Dashboard";
        String actualResult = driver.getTitle();
        if (actualResult.equals(expectedResult)) {
            System.out.println("verification PASSED!!");
        } else {
            System.out.println("verification FAILED!!");
        }
    }
}
