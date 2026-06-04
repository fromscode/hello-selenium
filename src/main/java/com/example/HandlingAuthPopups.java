package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthPopups {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();


        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String finalText = driver.findElement(By.xpath("//p")).getText();

        if (finalText.contains("Congratulations!")) System.out.println("Success");
        else System.out.println("Failure");

        driver.close();

    }
}