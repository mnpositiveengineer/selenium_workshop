package com.facebook;

import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;

public class FacebookDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("28");

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("sie");

        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1992");

        Ocular.config()
                .resultPath(Paths.get("C:\\Users\\mnpos\\OneDrive\\Pulpit\\Selenium\\Selenium + Ocular\\results"))
                .snapshotPath(Paths.get("C:\\Users\\mnpos\\OneDrive\\Pulpit\\Selenium\\Selenium + Ocular\\snapshots"))
                .globalSimilarity(95)
                .saveSnapshot(true);

        FacebookPage screenshotPage = new FacebookPage(driver);
        screenshotPage.compare();

        driver.quit();

    }
}
