package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WorkingWithFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        driver.findElement(By.tagName("input")).sendKeys("Hello World");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[contains(text(), 'Single')]")).click();
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        driver.findElement(By.tagName("input")).sendKeys("Good Morning");

//        driver.quit();
    }
}
