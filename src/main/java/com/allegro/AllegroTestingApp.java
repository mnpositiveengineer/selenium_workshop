package com.allegro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AllegroTestingApp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/Chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://allegro.pl/");


        //JAWNE OCZEKIWANIE AŻ ELEMENT BĘDZIE WIDOCZNY I ANI CHWILI DŁUŻEJ
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-role='close-and-accept-consent']")));

        WebElement inputField = driver.findElement(By.xpath("//button[@data-role='close-and-accept-consent']"));
        inputField.click();

        inputField = driver.findElement(By.xpath("//*[contains(@type, \"search\")]"));
        inputField.sendKeys("Mavic mini");

        inputField = driver.findElement(By.xpath("//*[contains(@aria-label, \"ategor\")]"));
        Select categorySelect = new Select(inputField);
        categorySelect.selectByVisibleText("Elektronika");

        inputField = driver.findElement(By.xpath("//button[@data-role='search-button']"));
        inputField.submit();
        }
    }
