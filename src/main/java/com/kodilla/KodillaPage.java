package com.youtube.selenium.kodilla;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class KodillaPage {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://kodilla.com/pl");
        driver.findElement(By.linkText("Zaloguj")).click();
        driver.findElement(By.name("email")).sendKeys("mnpositiveengineer@gmail.com");
        driver.findElement(By.name("password")).sendKeys("--------");
        driver.findElement(By.xpath("//button[contains(@data-role, \"submit-button\")]")).submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(@aria-label, \"Close\")]")).click();

        JavascriptExecutor scrolling = (JavascriptExecutor) driver;
        scrolling.executeScript("window.scrollBy(0,1500)");

        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.partialLinkText("regresji")).click();
        driver.findElement(By.xpath("//input[contains(@value, \"Akceptuj\")]")).click();

        WebElement regulamin = driver.findElement(By.partialLinkText("Regulamin"));

        Point location = regulamin.getLocation();
        int y = location.getY();

        int currentLocation = 0;

        do{
            TakesScreenshot scrShot = (TakesScreenshot) driver;
            File sourceFile = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File("C:\\Users\\mnpos\\OneDrive\\Pulpit\\kodilla Selenium\\Selenium + Ocular\\snapshots" + "/ "
                    + currentLocation + ".png"));
            scrolling.executeScript("window.scrollBy(0,700)");
            currentLocation = currentLocation + 700;
        } while (currentLocation < y);

        driver.quit();
    }
}
