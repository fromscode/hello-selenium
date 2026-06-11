package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HandlingBrokenLinks {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        int numBrokenLinks = 0;

        for (WebElement element : elements) {
            String href = element.getAttribute("href");

            if (href == null || href.isBlank()) {
                ++numBrokenLinks;
                System.out.println(numBrokenLinks + ". Link is empty or null");
            }
            else {
                try {
                    URL url = new URL(href);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    int responseCode = connection.getResponseCode();

                    if (responseCode >= 400) {
                        ++numBrokenLinks;
                        System.out.println(numBrokenLinks + ". " + href + " is broken with status code: " + responseCode);
                    }
                }
                catch (Exception e) {
                    ++numBrokenLinks;
                    System.out.println(numBrokenLinks + ". " + href + " is broken with the following exception: " + e.getClass());
                }
            }
        }

        System.out.println("Total number of broken links: " + numBrokenLinks);

        driver.quit();
    }
}
