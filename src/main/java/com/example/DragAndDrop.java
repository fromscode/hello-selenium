package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement maxSlide=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
        System.out.println(maxSlide.getLocation());

        Actions act=new Actions(driver);
        act.dragAndDropBy(maxSlide,-200,0).build().perform();



    }
}