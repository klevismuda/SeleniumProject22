package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {
    //TC17_Drag_And_Drop
    // 1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
    // 2.Drag and drop the small circle to bigger circle.
    // 3.Assert: -Text in big circle changed to: “You did great!”

    @Test
    public void TC17_Drag_And_Drop(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement cookies = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click(); // To click on Cookies button

        WebElement littleBall = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigBal = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(littleBall, bigBal).build().perform();

        WebElement textToBeDisplayed = Driver.getDriver().findElement(By.xpath("//div[@class='k-header painted']"));
        String textDisplayed = textToBeDisplayed.getText();

        Assert.assertTrue(textDisplayed.contains("You did great!"));
    }

}
