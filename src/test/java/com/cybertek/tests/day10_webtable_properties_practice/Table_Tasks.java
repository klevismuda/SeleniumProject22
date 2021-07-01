package com.cybertek.tests.day10_webtable_properties_practice;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Table_Tasks extends TestBase {



    //Note: Create locator for Tim that will be dynamic and doesn’t care in which row Tim is.

    @Test
    public void task3_return_tims_due_amount(){

        // driver.get(ConfigurationReader.getProperty("dataTableUrl")); same
        String url = ConfigurationReader.getProperty("dataTableUrl");
        driver.get(url);
        //1.	Open browser and go to: http://practice.cybertekschool.com/tables#edit
        //2.	Locate first table and verify Tim has due amount of “$50”
        //
        //Note: Create locator for Tim that will be dynamic and doesn’t care in which row Tim is.

        // //table[@id='table1']//td[.='Tim'] -->
        // This is dynamic because it find directly Tim

        WebElement timsDueAmountCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));
        System.out.println("timsDueAmountCell = " + timsDueAmountCell.getText());

        String actualTimResult = timsDueAmountCell.getText();
        String expectedTimResult = "$50.00";

        Assert.assertEquals(expectedTimResult,actualTimResult);

        // 1st way (find amount of Tim by go to parent)
        // table[@id='table1']//td[.='Tim']/../td[4]

        // 2nd way (find amount of Tim by go to sibling directly)
        // table[@id='table1']//td[.='Tim']/following-sibling::td[2]


    }

    @Test
    public void task4_verify_order_method(){
        TableUtils.verifyOrder(driver, "Tim"); // find all values
    }

    @Test
    public void task5_print_all_names_and_emails(){

        TableUtils.printNamesAndEmails(driver);

    }
}
