package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    WebDriver driver;
    //String str;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //str = "name";
    }

    @Test
    public void tc1_simple_dropdown_test() {
        // 3. Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentSelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualTextOfCurrentOption = currentSelectedOption.getText();
        String expectedText = "Please select an option";

        Assert.assertTrue(actualTextOfCurrentOption.equals(expectedText));


        // 4.Verify“State selection” default selected value is correctExpected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement currentSelectState = stateDropdown.getFirstSelectedOption();

        String actualStateDropdownText = currentSelectState.getText();
        String expectedStateDropdownText = "Select a State";

        Assert.assertEquals(expectedStateDropdownText, actualStateDropdownText);
    }

    @Test
    public void tc2_simple_dropdown_test() throws InterruptedException {

        //LOCATING STATE DROPDOWN
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //stateDropdown.selectByVisibleText("California");


        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)

        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText,
                "This message will be print out only if assertion is failed");

    }

    @AfterMethod
        public void teardownClass(){
        driver.close();
    }
}
