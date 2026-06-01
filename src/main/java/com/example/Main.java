package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://opencart.com");

            String title = driver.getTitle();

            assert title != null;
            if (title.contains("OpenCart")) {
                System.out.println("Test passed");
            } else
                System.out.println("Test failed");

           List<WebElement> elements = driver.findElements(By.cssSelector("ul.nav > *"));

           System.out.println(elements.size());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}