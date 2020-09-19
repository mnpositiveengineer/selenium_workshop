package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestingMandatoryEmailTest {

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
    public void isEmailMandatory() {
        driver.findElement(By.xpath(wel.getCityPath())).sendKeys("Test");
        driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("50");
        driver.findElement(By.xpath(wel.getSubmitPath())).submit();

        assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/");
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }


}