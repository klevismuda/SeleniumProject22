package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPracticesHover {

    //TC #15: Hover Test
    // 1.Go to http://practice.cybertekschool.com/hovers
    // 2.Hover over to first image
    // 3.Assert: a.“name: user1” is displayed
    // 4.Hover over to second image
    // 5.Assert: a.“name: user2” is displayed
    // 6.Hover over to third image
    // 7.Confirm: a.“name: user3” is displayed

    @Test
    public void tc12_actions_hover(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        //Locating all of the images here;
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        //We must create object of Actions class to be able to use methods coming from there
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(img1).perform();  // perform() function is to move over without clicking
        Assert.assertTrue(user1.isDisplayed(), "User1 text is not displayed. FAIL!!");

        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed(), "User2 text is not displayed. FAIL!!");

        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed(), "User3 text is not displayed. FAIL!!");

    }

    @Test
    public void scrolling_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //Scroll down to "Powered by Cybertek School"
        Actions actions = new Actions(Driver.getDriver());

        //Locate "Powered by Cybertek School"
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //Scroll using actions object
        BrowserUtils.sleep(2);
        actions.moveToElement(cybertekSchoolLink).perform();

        //Scroll up using Keys.Page_UP button
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
}
