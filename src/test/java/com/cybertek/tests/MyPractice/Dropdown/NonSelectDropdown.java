package com.cybertek.tests.MyPractice.Dropdown;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NonSelectDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    // 3. Click to non-select dropdown
    // 4.Select Facebook from dropdown
    // 5.Verify title is “Facebook -Log In or Sign Up”
    @Test
    public void NonSelectDropdown(){

    }
}
