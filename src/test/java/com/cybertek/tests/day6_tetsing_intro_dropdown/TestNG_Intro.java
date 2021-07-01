package com.cybertek.tests.day6_tetsing_intro_dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    @BeforeClass
    public void setupClass(){
        System.out.println("--> Before CLASS is running...");
    }
    @AfterClass
    public void teardownClass(){
        System.out.println("--> After CLASS is running...");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("--> Before method is running...");
    }
    @AfterMethod
    public void teardownMethod(){
        System.out.println("---> After method is running...");
    }
    @Test (priority = 2)  // to give priority to run firstly
    public void test1(){
        System.out.println("Running test1...");

        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);

        Assert.assertTrue(actual.equals(expected));
    }
    @Test (priority = 1)
    public void test2(){
        System.out.println("Running test2...");


    }
}
