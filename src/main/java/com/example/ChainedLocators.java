package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ChainedLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Index.html");

        ByChained chainedLocator = new ByChained(
                By.id("main"),
                By.tagName("div"),
                By.tagName("input")
        );

        WebElement element = driver.findElement(chainedLocator);
        element.sendKeys("Hello World");
    }
}
