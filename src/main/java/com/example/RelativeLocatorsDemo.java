package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");

        WebElement firstNameInput = driver.findElement(By.xpath("//*[@placeholder='First Name']"));

        WebElement nameLabel = driver.findElement(
                RelativeLocator.with(By.tagName("label")).toLeftOf(firstNameInput)
        );

        WebElement addressLabel = driver.findElement(
                RelativeLocator.with(By.xpath("//*[.='Address']")).near(firstNameInput)
        );

        System.out.println(nameLabel.getText());
        System.out.println(addressLabel.getText());
        driver.quit();
    }
}
