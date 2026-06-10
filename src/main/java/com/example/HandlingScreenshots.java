package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class HandlingScreenshots {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Index.html");

        TakesScreenshot ts = (TakesScreenshot) driver;

        //1. Full Page screenshot
        File file = ts.getScreenshotAs(OutputType.FILE);

        File targetFile = new File(System.getProperty("user.dir") + "/src/main/resources/screenshots/full-page.jpg");

        file.renameTo(targetFile);


        //2. Screenshot of an element:

        WebElement logo = driver.findElement(By.id("logo"));

        logo.getScreenshotAs(OutputType.FILE).renameTo(new File(System.getProperty("user.dir") + "/src/main/resources/screenshots/logo-only.jpg"));

        driver.quit();
    }
}
