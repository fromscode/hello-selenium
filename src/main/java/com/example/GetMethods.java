package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");

        System.out.println("Title: " + driver.getTitle()); // get title of the page

        System.out.println("Current URL: " + driver.getCurrentUrl());

        // System.out.println();
        // System.out.println("--------------- PAGE SOURCE -----------");


        // System.out.println(driver.getPageSource());
        // System.out.println();

        System.out.println("Window handle: " + driver.getWindowHandle());
        System.out.println("Window handles: " + driver.getWindowHandles());


        driver.quit();
    }
}
