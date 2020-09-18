package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestingMandatoryEmail {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://artlessdesign.pl/";

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElementsLocation wel = new WebElementsLocation();

        try {
            driver.get(baseUrl);
        } catch (WebDriverException e) {
            System.out.println("Webdriver Exception occured.");
        }

        try {
            driver.findElement(By.xpath(wel.getCityPath())).sendKeys("Test");
            driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("50");
            driver.findElement(By.xpath(wel.getSubmitPath())).submit();

            String expectedURL = "https://artlessdesign.pl/";
            String actualURL = driver.getCurrentUrl();

            if (!expectedURL.equals(actualURL)) {
                System.out.println("Test failed.");
                System.out.println("Expected: " + expectedURL +", actual: " + actualURL);
            } else {
                System.out.println("Test passed.");
            }

        } catch (NoSuchElementException e) {
            System.out.println("No such element. Browser closed.");
        } finally {
            driver.close();
        }
    }
}
