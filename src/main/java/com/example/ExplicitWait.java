package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://a4boxd.onrender.com");
        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search\"]")));
        search.sendKeys("Blood");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/form/button"))).click();
    }
}
