package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionPractices {
    /**
     * 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
     * 2.Switch to iframe.
     * 3.Double click on the text “Double-click me to change my text color.”
     * 4.Assert: Text’s “style” attribute value contains “red
     */

    @Test
    public void p2_double_click_test(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");// switch can be used with id value too.

        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(textToDoubleClick).doubleClick().perform();

        WebElement textInRed = Driver.getDriver().findElement(By.id("demo"));
        String getTextRed = textInRed.getAttribute("style");

        Assert.assertTrue(getTextRed.contains("red"));

    }
}
