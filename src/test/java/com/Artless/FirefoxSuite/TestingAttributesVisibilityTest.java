package com.Artless.FirefoxSuite;

import com.Artless.WebElementsLocation;
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

    @Test (priority = 0, groups = {"com.Artless.FirefoxSuite.TestingAttributesVisibilityTest"})
    public void emailIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getEmailPath())).isDisplayed());
    }

    @Test (priority = 1, groups = {"com.Artless.FirefoxSuite.TestingAttributesVisibilityTest"})
    public void projectIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getProjectPatch())).isDisplayed());
    }

    @Test (priority = 2, groups = {"com.Artless.FirefoxSuite.TestingAttributesVisibilityTest"})
    public void cityIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getCityPath())).isDisplayed());
    }

    @Test (priority = 3, groups = {"com.Artless.FirefoxSuite.TestingAttributesVisibilityTest"})
    public void areaIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getAreaPath())).isDisplayed());
    }

    @Test (priority = 4, groups = {"com.Artless.FirefoxSuite.TestingAttributesVisibilityTest"})
    public void deadlineIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getDeadlinePath())).isDisplayed());
    }

    @Test (priority = 5, groups = {"com.Artless.FirefoxSuite.TestingAttributesVisibilityTest"})
    public void messageIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(wel.getMessagePath())).isDisplayed());
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}