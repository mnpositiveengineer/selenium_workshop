package com.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ListenerMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        manageDriver(driver);

        driver.navigate().to("https://www.edureka.co/blog/");

        driver.findElement(By.id("wzrk-cancel")).click();

        js.executeScript("window.scrollBy(0,700)");

        try {
            driver.findElement(By.linkText("Software Testing")).click();
        } catch (Exception e) {
            System.out.println("Element not found");
        }

    }

    private static void manageDriver(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
