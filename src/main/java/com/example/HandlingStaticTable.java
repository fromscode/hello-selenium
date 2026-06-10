package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandlingStaticTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://blazedemo.com");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement from = driver.findElement(By.name("fromPort"));
            Select fromSelect = new Select(from);
            fromSelect.selectByIndex(0);

            WebElement to = driver.findElement(By.name("toPort"));
            Select toSelect = new Select(to);
            toSelect.selectByIndex(0);

            driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

            int numRows = driver.findElements(By.xpath("//tbody//tr")).size();

            double minPrice = Integer.MAX_VALUE;
            int minPriceIndex = -1;

            for (int i=0; i<numRows; ++i) {
                double price = Double.parseDouble(driver.findElement(By.xpath("//tbody/tr["+(i+1)+"]/td[6]")).getText().substring(1));
                if (price < minPrice) {
                    minPrice = price;
                    minPriceIndex = i+1;
                }
            }

            System.out.println("Min Price: " + minPrice);

            driver.findElement(By.xpath("//tbody//tr[" + minPriceIndex + "]//input[@type='submit']")).click();


            driver.findElement(By.id("inputName")).sendKeys("John Doe");
            driver.findElement(By.id("address")).sendKeys("New Mexico");
            driver.findElement(By.id("city")).sendKeys("Alburquerque");
            driver.findElement(By.id("state")).sendKeys("Texas");
            driver.findElement(By.id("zipCode")).sendKeys("12345");
            WebElement card = driver.findElement(By.id("cardType"));
            Select cardSelect = new Select(card);
            cardSelect.selectByIndex(0);
            driver.findElement(By.id("creditCardNumber")).sendKeys("9999777766666565");
            driver.findElement(By.id("creditCardMonth")).sendKeys("10");
            driver.findElement(By.id("creditCardYear")).sendKeys("2019");
            driver.findElement(By.id("nameOnCard")).sendKeys("John Doe");
            driver.findElement(By.id("rememberMe")).click();
            driver.findElement(By.xpath("//input[@type='submit']")).click();

            System.out.println("Final Message: " + driver.findElement(By.tagName("h1")).getText());
        }
        catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
