package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");

//        WebElement frame = driver.findElement(By.id("singleframe"));

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Hello World");
    }
}
