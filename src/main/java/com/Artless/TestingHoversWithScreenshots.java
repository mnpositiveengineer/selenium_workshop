package com.Artless;

import com.Artless.Screenshots.snapshot.FirstImageHover;
import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestingHoversWithScreenshots {
    public static void main(String[] args) throws InterruptedException {
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

        try {
            WebElementsLocation wel = new WebElementsLocation();
            WebElement firstImage = driver.findElement(By.xpath(wel.getFirstImagePath()));
            Actions builder = new Actions(driver);
            builder.moveToElement(firstImage).build().perform();

        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");
        }


        Ocular.config()
                .resultPath(Paths.get("C:\\selenium_workshop\\src\\main\\java\\com\\Artless\\Screenshots\\results"))
                .snapshotPath(Paths.get("C:\\selenium_workshop\\src\\main\\java\\com\\Artless\\Screenshots\\snapshot"))
                .globalSimilarity(95)
                .saveSnapshot(true);
        FirstImageHover firstImageHover = new FirstImageHover(driver);
        Thread.sleep(5000);
        firstImageHover.compare();

        driver.close();
    }
}
