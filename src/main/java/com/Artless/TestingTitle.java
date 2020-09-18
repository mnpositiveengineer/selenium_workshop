package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestingTitle {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://artlessdesign.pl/";

        // TESTING IF THE TITLE IS AS EXPECTED
        String expectedTitle = "Artless | Projektowanie wnętrz";
        String actualTitle = "";

        driver.get(baseUrl);
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is incorrect. Expected: " + expectedTitle + ", actual: " + actualTitle);
        }


    }
}
