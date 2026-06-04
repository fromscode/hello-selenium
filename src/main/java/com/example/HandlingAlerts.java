package com.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();

        // 1. Handling normal alerts (both accept and dismiss works same here)
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();



        // 2. Handling confirm alerts (accept clicks OK, and dismiss clicks Cancel)
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println(confirmAlert.getText()); // get the alert text
        Thread.sleep(1000);
        confirmAlert.dismiss();

        // 3. Handling prompts: sendKeys()
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.print(promptAlert.getText());
        Thread.sleep(2000);
        promptAlert.sendKeys("Some random text");
        promptAlert.accept();
    }
}
