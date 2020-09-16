package com.exceptions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NoAlertException {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.pl/");

        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

        //CHECK IF THERE IS ANY ALERT ON THE SITE AND ACCEPT IT, IF NOT CREATE A SCREENSHOT AND CARRY ON

        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            TakesScreenshot scrShot = (TakesScreenshot) driver;
            File sourceFile = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(
                    "C:\\Users\\mnpos\\OneDrive\\Pulpit\\Selenium\\Selenium + Ocular\\snapshots" +
                            "/noAlertDefect.png"));
            System.out.println("No alert. Screenshot created.");
        }
        driver.findElement(By.name("q")).sendKeys("Selenium");
    }
}
