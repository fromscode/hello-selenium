package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://a4boxd.onrender.com");
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Blood");
        driver.findElement(By.xpath("/html/body/nav/div/form/button")).click();

        // driver.quit();
    }
}