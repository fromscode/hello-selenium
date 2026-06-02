package com.example;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout((Duration.ofSeconds(5)))
                .pollingEvery(Duration.ofSeconds((5))).ignoring(NoSuchElementException.class);

        driver.get("https://a4boxd.onrender.com");

        WebElement searchBox = wait.until((driver1) -> driver1.findElement(By.xpath("//*[@id=\"search\"]")));
        searchBox.sendKeys("Blood");

        wait.until((driver1) -> driver1.findElement(By.xpath("/html/body/nav/div/form/button"))).click();
    }
}
