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

            List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), 'OpenCart')]"));

            System.out.println(elements.size());


        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}