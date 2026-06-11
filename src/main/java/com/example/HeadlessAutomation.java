package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessAutomation {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.automationtesting.in/Register.html");

        if (driver.findElement(By.tagName("h1")).getText().equals("Automation Demo Site")) {
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");

        driver.quit();
    }
}
