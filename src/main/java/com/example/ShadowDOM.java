package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ShadowDOM {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("https://dev.automationtesting.in/shadow-dom");

            SearchContext shadowDOM = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
            WebElement shadowElement = shadowDOM.findElement(By.cssSelector("#shadow-element"));
            System.out.println(shadowElement.getText());

            SearchContext innerShadowDom = shadowDOM.findElement(By.cssSelector("inner-shadow-dom")).getShadowRoot();
            WebElement nestedShadowElement = innerShadowDom.findElement(By.cssSelector("#nested-shadow-element"));
            System.out.println(nestedShadowElement.getText());

            SearchContext nestedShadowDom = innerShadowDom.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
            WebElement multiNestedShadowElement = nestedShadowDom.findElement(By.cssSelector("#multi-nested-shadow-element"));
            System.out.println(multiNestedShadowElement.getText());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            driver.quit();
        }


    }
}
