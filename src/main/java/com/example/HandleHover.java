package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandleHover {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/trigger-hover.html");
            driver.manage().window().maximize();

            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
            Actions action = new Actions(driver);
            action.moveToElement(button).build().perform();


            List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul//span")));

            list.forEach((e) -> System.out.println(
                    e.getText()
            ));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
