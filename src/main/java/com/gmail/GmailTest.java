package com.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.gmail.com/");

        driver.findElement(By.id("identifierId")).sendKeys("mnpositiveengineer@gmail.com");

        if (driver.getTitle().equalsIgnoreCase("gmail")){
            System.out.printf("Test passed");
        } else {
            System.out.printf("Test failed");
        }
        driver.quit();
    }
}
