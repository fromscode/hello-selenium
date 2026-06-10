package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ganeshsadagopan.github.io/HandleWindows/");

        try {
            driver.findElement(By.xpath("//button[1]")).click();

            String parentWindowHandle = driver.getWindowHandle();

            Set<String> windowHandles = driver.getWindowHandles();

            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                }
            }

            driver.manage().window().maximize();
            System.out.println(driver.getTitle());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
