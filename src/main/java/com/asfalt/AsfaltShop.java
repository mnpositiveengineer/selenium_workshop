package com.asfalt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AsfaltShop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

        driver.get("https://asfaltshop.pl/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-remove']")).click();


        List<String> listOfTitles = new ArrayList<>();

        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//a[contains(@href, \"kawa\") and (@style = 'left: 0px;')]")));
        driver.findElement(By.id("banery")).click();
        listOfTitles.add(driver.getTitle());

        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//a[contains(@href, \"ostr\") and (@style = 'left: 0px;')]")));
        driver.findElement(By.id("banery")).click();
        listOfTitles.add(driver.getTitle());

        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//a[contains(@href, \"darmowa\") and (@style = 'left: 0px;')]")));
        driver.findElement(By.id("banery")).click();
        listOfTitles.add(driver.getTitle());

        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//a[contains(@href, \"drugi\") and (@style = 'left: 0px;')]")));
        driver.findElement(By.id("banery")).click();
        listOfTitles.add(driver.getTitle());

        driver.quit();

        for (String title : listOfTitles){
            System.out.print("***" + title + "***");
        }
    }
}
