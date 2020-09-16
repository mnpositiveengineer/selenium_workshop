package com.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class YahooDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //strona ma 10 sekund na wczytanie
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //od tej pory na wyszukanie danego elementu (findElement(By by)) na stronie będzie 10 sekund

        driver.get("https://login.yahoo.com/");

        driver.findElement(By.id("login-username")).sendKeys("przykladowy@email.com");
        driver.findElement(By.id("login-signin")).click();

        driver.quit();
    }
}
