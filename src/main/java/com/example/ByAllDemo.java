package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class ByAllDemo {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");

        ByAll locator = new ByAll(
                By.id("submit"),
                By.id("submitbtn"),
                By.id("signup"),
                By.id("button")
        );

        // NOTE: ByAll returns the element that matches the earliest specified locator
        // Think of it as a logical OR operator

        WebElement element = driver.findElement(locator);
        System.out.println(element.getText());
        driver.quit();
    }
}
