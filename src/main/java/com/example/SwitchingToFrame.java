package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingToFrame {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((5)));
        driver.manage().window().maximize();

        driver.get("https://webapps.tekstac.com/PurchaseApp/");

        WebElement iframe = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe);

        System.out.println(driver.getCurrentUrl());

        
    }
}
