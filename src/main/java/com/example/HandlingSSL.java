package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSSL {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");

        if (driver.getTitle().equals("expired.badssl.com")) {
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");

        driver.quit();
    }
}
