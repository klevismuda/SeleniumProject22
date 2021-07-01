package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {
    //TC #18: Context Click –HOMEWORK
    // 1.Go to https://the-internet.herokuapp.com/context_menu
    // 2.Right click to the box.
    // 3.Alert will open.
    // 4.Accept alert
    // No assertion needed for this practice.


    @Test
    public void TC18_Context_Click(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement context = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(context).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

}
