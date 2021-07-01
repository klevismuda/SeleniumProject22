package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {
    //TC #16: Double ClickTest
    // 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    // 2.Switch to iframe.
    // 3.Double click on the text “Double-click me to change my text color.”
    // 4.Assert: Text’s “style” attribute value contains “red”.

    @Test
    public void TC_16_Double_ClickTest() {
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));
        Driver.getDriver().switchTo().frame(iframe);

        WebElement textDoubleClick = Driver.getDriver().findElement(By.xpath("//p[@ondblclick='myFunction()']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(textDoubleClick).doubleClick().perform();

        String actualColor = Driver.getDriver().findElement(By.xpath("//p[@ondblclick='myFunction()']")).getAttribute("style");

        Assert.assertTrue(actualColor.contains("red"));



    }
}
