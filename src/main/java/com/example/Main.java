package com.example;

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

            WebElement element = driver.findElement(By.cssSelector("a.btn-link"));

            System.out.println(element.getAccessibleName());

            driver.findElement(By.linkText("Features")).click();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}