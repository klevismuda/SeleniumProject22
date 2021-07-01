package com.cybertek.tests.base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;   // or protected. If it is default it doesnt work

    @BeforeMethod
    public void setupMethod(){

        //This line return String = chrome
        String browser = ConfigurationReader.getProperty("browser");
        //This line return String = http://practice.cybertekschool.com/tables#edit


        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //below code is same as above
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
