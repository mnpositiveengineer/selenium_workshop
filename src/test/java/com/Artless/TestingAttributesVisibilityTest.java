package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestingAttributesVisibilityTest {

    private String baseUrl = "https://artlessdesign.pl/";
    private WebDriver driver;
    private WebElementsLocation wel;

    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        wel = new WebElementsLocation();
        driver.get(baseUrl);
    }

    @Test
    public void emailIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getEmailPath())).isDisplayed());
    }

    @Test
    public void projectIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getProjectPatch())).isDisplayed());
    }

    @Test
    public void cityIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getCityPath())).isDisplayed());
    }

    @Test
    public void areaIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getAreaPath())).isDisplayed());
    }

    @Test
    public void deadlineIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getDeadlinePath())).isDisplayed());
    }

    @Test
    public void messageIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getMessagePath())).isDisplayed());
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}