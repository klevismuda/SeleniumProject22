package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilPractice {
    @Test
    public void simple_google_search_test(){

        //1- Go to google.com
        Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        // String searchValue = "there is no spoon";
        String searchValue = ConfigurationReader.getProperty("searchValue");  // Shiko tek configuration.properties file
        searchBox.sendKeys(searchValue + Keys.ENTER);
        //2- Search for a value
        //3- Verify value is contained in the title

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedTitle));

       //Driver.getDriver().quit();
       //Driver.getDriver().close();

        Driver.closeDriver();
        Driver.getDriver().get("https://etsy.com");

    }
}
