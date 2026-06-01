package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        WebDriver driver = new ChromeDriver();
        driver.get("http://opencart.com");

        String title = driver.getTitle();

        if (title.contains("OpenCart")) {
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");

        driver.quit();
    }
}