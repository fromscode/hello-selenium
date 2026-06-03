package com.example;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {
     public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String currentWindowId = driver.getWindowHandle();

        driver.findElement(By.partialLinkText("OrangeHRM")).click();

        Set<String> windowIdSet = driver.getWindowHandles();

        for (String id : windowIdSet) {
            if (!id.equals(currentWindowId)) {
                driver.switchTo().window(id);
            }
        }

        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowId);
        System.out.println(driver.getTitle());
        driver.close();
    }
}
