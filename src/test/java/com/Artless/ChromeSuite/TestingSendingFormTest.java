package com.Artless.ChromeSuite;

import com.Artless.WebElementsLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingSendingFormTest {

    private String baseUrl = "https://artlessdesign.pl/";
    private WebDriver driver;
    private WebElementsLocation wel;

    @BeforeTest (groups = {"polish_characters"})
    public void setBaseUrl() {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        wel = new WebElementsLocation();
        driver.get(baseUrl);
        Dimension d = new Dimension(360,740);
        driver.manage().window().setSize(d);
    }
    @AfterTest (groups = {"polish_characters"})
    public void endSession(){
        driver.quit();
    }

    @Test(priority = 0, groups = {"polish_characters"})
    public void isFormSent() throws InterruptedException {
        driver.findElement(By.xpath(wel.getCityPath())).sendKeys("Test");
        driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("50");
        driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("mnpositiveengineer@gmail.com");
        driver.findElement(By.xpath(wel.getSubmitPath())).submit();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/projektowanie-wn%C4%99trz#thanks");
    }

    @Test (priority = 1)
    public void isMessageDisplayed(){
        Assert.assertTrue(driver.findElement(By.xpath(wel.getThanksText())).isDisplayed());
    }

    @Test (priority = 1, groups = {"polish_characters"})
    public void isMessageCorrect() {
        Assert.assertEquals(driver.findElement(By.xpath(wel.getThanksText())).getText(), "Dziękujemy za przesłanie formularza.");
    }
}