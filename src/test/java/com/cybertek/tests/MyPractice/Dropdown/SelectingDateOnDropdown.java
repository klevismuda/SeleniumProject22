package com.cybertek.tests.MyPractice.Dropdown;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectingDateOnDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void DateOnDropdown (){
        //3.Select “December 1st, 1922” and verify it is selected.
        // Select year using: visible text
        // Select month using : value attribute
        // Select day using: index number

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        selectMonth.selectByValue("11");
        selectDay.selectByIndex(0);
        selectYear.selectByVisibleText("1992");

        String expectedMonth = "December";
        String expectedDay = "1";
        String expectedYear = "1992";


        Assert.assertEquals(expectedMonth, selectMonth.getFirstSelectedOption().getText());
        Assert.assertEquals(expectedDay, selectDay.getFirstSelectedOption().getText());
        Assert.assertEquals(expectedYear, selectYear.getFirstSelectedOption().getText());
    }
}
