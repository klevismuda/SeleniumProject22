package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {
//TC #14: UploadTest
// 1.Go tohttp://practice.cybertekschool.com/upload
// 2.Find some small file from your computer, and get the path of it.
// 3.Upload the file.
// 4.Assert:
//  -Fileuploaded text is displayed on the page

    @Test
    public static void upload_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        String path = "C:\\Users\\Daemons\\Desktop\\download.png";  //Jepet path me String, arsyeja ashtu kan menduar developers

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));

        WebElement fileSubmitButton = Driver.getDriver().findElement(By.id("file-submit"));

        //sending the file path to the chooseFile WebElement
        chooseFile.sendKeys(path);

        BrowserUtils.sleep(2);

        fileSubmitButton.click();

        WebElement fileUploaded = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));

        Assert.assertTrue(fileUploaded.isDisplayed());

        Driver.closeDriver();

    }
}
