package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestingSendingForm {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String baseUrl = "https://artlessdesign.pl/";

        try {
            driver.get(baseUrl);
        } catch (WebDriverException e) {
            System.out.println("Webdriver Exception occured.");
        }

        WebElementsLocation wel = new WebElementsLocation();

        try {
            driver.findElement(By.xpath(wel.getCityPath())).sendKeys("Test");
            driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("50");
            driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("mnpositiveengineer@gmail.com");
            driver.findElement(By.xpath(wel.getSubmitPath())).submit();

            //TESTING IF CORRECT MESSAGE (THANKS TEXT) IS DISPLAYED

            String expectedText = "Dziękujemy za przesłanie formularza.";

            try {
                String actualText = driver.findElement(By.xpath(wel.getThanksText())).getText();
                if (!expectedText.equals(actualText)) {
                    System.out.println("Test failed. Message is not as expected.");
                    System.out.println("Expected: " + expectedText + ", actual: " + actualText);
                } else {
                    System.out.println("Test for message passed.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Test for message failed. Text is not displayed.");
            }

        } catch (NoSuchElementException e) {
            System.out.println("No such element. Browser closed.");
        } finally {
            driver.close();
        }
    }
}
