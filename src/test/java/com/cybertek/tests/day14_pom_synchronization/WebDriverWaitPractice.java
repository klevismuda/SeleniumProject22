package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.DynamicLoad1Page;
import com.cybertek.pages.DynamicLoad7Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {
    /**
     TC#40 : Dynamically Loaded Page Elements 7
     1. Go to http://practice.cybertekschool.com/dynamic_loading/7
     2. Wait until title is “Dynamic title”
     3. Assert : Message “Done” is displayed.
     4. Assert : Image is displayed.
     Note: Follow POM
     */

    @Test
    public void dynamical_load_7_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        //Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //use the object to wait for the explicit condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        DynamicLoad7Page dynamicLoad7Pages = new DynamicLoad7Page();

        //this will wait until the image is displayed on the page
        //wait.until(ExpectedConditions.visibilityOf(dynamicLoad7Pages.spongeBobImage));

        Assert.assertTrue(dynamicLoad7Pages.doneMessage.isDisplayed());
        Assert.assertTrue(dynamicLoad7Pages.spongeBobImage.isDisplayed());

    }

    @Test
    public void dynamical_loading_1_test(){

        /**
         TC#41 : Dynamically Loaded Page Elements 1
         1. Go to http://practice.cybertekschool.com/dynamic_loading/1
         2. Click to start
         3. Wait until loading bar disappears
         4. Assert username inputbox is displayed
         5. Enter username: tomsmith
         6. Enter password: incorrectpassword
         7. Click to Submit button
         8. Assert “Your password is invalid!” text is displayed.
         Note: Follow POM Design Pattern
         */

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        dynamicLoad1Page.startButton.click();
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        Assert.assertTrue(dynamicLoad1Page.username.isDisplayed());

        dynamicLoad1Page.username.sendKeys("tomsmith");
        dynamicLoad1Page.password.sendKeys("incorrectpassword");
        dynamicLoad1Page.submitButton.click();

        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}
