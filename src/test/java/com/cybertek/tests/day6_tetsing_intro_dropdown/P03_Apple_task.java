package com.cybertek.tests.day6_tetsing_intro_dropdown;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Apple_task {
    public static void main(String[] args) {
        /**
         * TC #03: FINDELEMENTS_APPLE
         * 1. Open Chrome browser
         * 2. Go to https://www.apple.com/
         * 3. Click to all of the headers one by one
         *       a. Mac, iPad, iPhone, Watch, TV, Music, Support
         * 4. Print out the titles of the each page
         * 5. Print out total number of links in each page
         * 6. While in each page:
         * a. Print out how many link is missing text TOTAL
         * b. Print out how many link has text TOTAL
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Go to http://practice.cybertekschool.com/checkboxes
        driver.get("https://www.apple.com/");
        driver.manage().window().maximize();

        // Storing 9 web elements including of the each page
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        for (int eachLink = 1; eachLink < headerLinks.size() - 1; eachLink++) {    // NO need for macIcon and search button.
           // System.out.println(headerLinks.get(eachLink).getText());
            headerLinks.get(eachLink).click();

            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));  // In order to refresh the Selenium memory

            //4
            System.out.println("Current title in the page: " + driver.getTitle());

            //5
            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

            System.out.println("Total number of links in current page: " + allLinks.size());

            //6
            int linkWithNoText = 0;
            int linkWithText = 0;
            for (WebElement each : allLinks){
                if(each.getText().isEmpty()){
                    linkWithNoText++;
                } else{
                    linkWithText++;
                }


            }
            System.out.println("--> Current page links with NO text: " + linkWithNoText);
            System.out.println("--> Current page links with text: " + linkWithText);
            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
        }



    }
}
