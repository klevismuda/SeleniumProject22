package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        //1- Setting up the browser driver
        WebDriverManager.chromedriver().setup();
        //System.setProperty("chrome","path of where you saved the driver");

        //2- Create instance of chrome driver and open browser
        //This is the line that is opening the browser.
        WebDriver driver = new ChromeDriver();

        //3- Go to https://www.google.com
        driver.get("https://www.google.com");

    }

}
