package com.cybertek.tests.MyPractice.Dropdown;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSelectDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //3.Select all the options from multiple select dropdown.
        // 4.Print out all selected values.
        // 5.Deselect all values.

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void MultipleSelectDropdown(){
        WebElement selectOptions = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select selectLanguage = new Select(selectOptions);

        List<WebElement> allOptions = selectLanguage.getOptions();

        for (int i = 0; i < allOptions.size(); i++) {
            selectLanguage.selectByIndex(i);
            System.out.println(selectLanguage.getAllSelectedOptions().get(i).getText());
        }
        selectLanguage.deselectAll();

    }
}
