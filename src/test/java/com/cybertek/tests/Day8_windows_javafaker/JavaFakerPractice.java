package com.cybertek.tests.Day8_windows_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){
        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        String preferredFood = faker.food().fruit();
        System.out.println("preferredFood = " + preferredFood);

        String chuckNorris = faker.chuckNorris().fact();
        System.out.println("chuckNorris = " + chuckNorris);


    }
}
